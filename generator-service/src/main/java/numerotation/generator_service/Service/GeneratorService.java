package numerotation.generator_service.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import numerotation.generator_service.CommunicationMicro.ConfigServiceClient;
import numerotation.generator_service.CommunicationMicro.CounterServiceClient;
import numerotation.generator_service.DTO.InscritDto;
import numerotation.generator_service.DTO.RuleDto;
import numerotation.generator_service.Entity.NumeroInscrit;
import numerotation.generator_service.Map.InscritMapper;
import numerotation.generator_service.Repository.NumeroInscritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GeneratorService {

    @Autowired
    private ConfigServiceClient configServiceClient;
    @Autowired
    private NumeroInscritRepository numeroInscritRepository;
    @Autowired
    private CounterServiceClient counterServiceClient;
    @Autowired
    private InscritMapper inscritMapper;
    public String generateNumber(InscritDto request) {
        List<RuleDto> rules = configServiceClient.getRules(request.getConfigid());
        NumeroInscrit inscrit = inscritMapper.dtoToEntity(request);
        numeroInscritRepository.save(inscrit);
        rules.sort(Comparator.comparing(RuleDto::getOrderIndex));

        StringBuilder numero = new StringBuilder();

        for (RuleDto rule : rules) {
            switch (rule.getField()) {
                case "FIRSTNAME" -> {
                    String prenom = truncate(request.getLastName(), rule.getLength());
                    numero.append(rule.getPrefix() != null ? rule.getPrefix() : "")
                            .append(prenom)
                            .append(rule.getSuffix() != null ? rule.getSuffix() : "");
                }
                case "LASTNAME" -> {
                    String nom = truncate(request.getFirstName(), rule.getLength());
                    numero.append(rule.getPrefix() != null ? rule.getPrefix() : "")
                            .append(nom)
                            .append(rule.getSuffix() != null ? rule.getSuffix() : "");
                }
                case "BIRTHDATE" -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(rule.getDateFormat());
                    String formattedDate = request.getBirthDate().format(formatter);
                    numero.append(rule.getPrefix() != null ? rule.getPrefix() : "")
                            .append(formattedDate)
                            .append(rule.getSuffix() != null ? rule.getSuffix() : "");
                }
                case "COUNTER" -> {
                    int nextValue = counterServiceClient.getNextValue(request.getConfigid(), rule.getValeurInitiale());
                    String formattedCounter = String.format("%0" + rule.getLength() + "d", nextValue);
                   // int nextValue = counterService.getNextValue(request.getConfigid(), rule.getValeurInitiale());
                    numero.append(rule.getPrefix() != null ? rule.getPrefix() : "")
                            .append(formattedCounter)
                            .append(rule.getSuffix() != null ? rule.getSuffix() : "");
                }
            }
        }
        return numero.toString();
    }
    private String truncate(String value, Integer length) {
        if (value == null || length == null) return "";
        return value.length() <= length ? value.toUpperCase() : value.substring(0, length).toUpperCase();
    }

}

