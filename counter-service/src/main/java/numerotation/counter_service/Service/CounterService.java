package numerotation.counter_service.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import numerotation.counter_service.DTO.CounterDto;
import numerotation.counter_service.Entity.Counter;
import numerotation.counter_service.Map.CounterMapper;
import numerotation.counter_service.Repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CounterService {

    @Autowired
    private  CounterRepository counterRepository;
    @Autowired
    private CounterMapper counterMapper;

    @Transactional
    public int getNextValue(String configId, Integer valeurInitiale) {
        Counter compteur = counterRepository.findById(configId)
                .orElseGet(() -> {
                    Counter newCompteur = new Counter();
                    newCompteur.setConfigid(configId);
                    newCompteur.setValeurInitiale(valeurInitiale);
                    newCompteur.setValeurActuelle(valeurInitiale);
                    return counterRepository.save(newCompteur);
                });

        int next = compteur.getValeurActuelle() + 1;
        compteur.setValeurActuelle(next);
        counterRepository.save(compteur);

        return next;
    }
}


