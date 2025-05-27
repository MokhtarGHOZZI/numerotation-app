package numerotation.generator_service.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {

    private final Map<String, AtomicInteger> compteurParConfig = new HashMap<>();

    public int getNextValue(String configId, int valeurInitiale) {
        return compteurParConfig
                .computeIfAbsent(configId, k -> new AtomicInteger(valeurInitiale))
                .incrementAndGet();
    }
}
