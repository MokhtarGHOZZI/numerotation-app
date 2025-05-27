package numerotation.config_service.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numerotation.config_service.DTO.ConfigurationRulesDTO;
import numerotation.config_service.DTO.RuleDto;
import numerotation.config_service.Entity.Rule;
import numerotation.config_service.Map.RuleMapper;
import numerotation.config_service.Repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuleService {

    @Autowired
    private  RuleRepository ruleRepository;
    private  RuleMapper ruleMapper;
    public List<String> getAllConfigIds() {
        return ruleRepository.findAllConfigIds();
    }
    @Transactional
    public void createAll(ConfigurationRulesDTO dtos) {
        ruleRepository.deleteByConfigid(dtos.getConfigid());

        List<Rule> rules = dtos.getRules().stream()
                .map(ruleDTO->{
                    Rule rule = ruleMapper.dtoToModel(ruleDTO);
                    rule.setConfigid(dtos.getConfigid());
                    return rule;})
                .collect(Collectors.toList());

        List<Rule> savedRules = ruleRepository.saveAll(rules);


    }

    public  List<RuleDto> getAllRules(String id) {
        return ruleRepository.findAllByConfigidOrderByOrderIndexAsc(id)
                .stream()
                .map(RuleMapper::modelToDto)
                .collect(Collectors.toList());
    }
}


