package numerotation.generator_service.CommunicationMicro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "counter-service", url = "http://localhost:8082")
public interface CounterServiceClient {

    @GetMapping("/api/counter/{configId}/next")
    Integer getNextValue(@PathVariable String configId,
                         @RequestParam("valeurInitiale") int valeurInitiale);

}

