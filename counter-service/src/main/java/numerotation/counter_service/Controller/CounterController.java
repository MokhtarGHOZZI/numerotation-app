package numerotation.counter_service.Controller;

import lombok.AllArgsConstructor;
import numerotation.counter_service.Service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/counter")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CounterController {

    @Autowired
    private  CounterService counterService;



    @GetMapping("/{configId}/next")
    public ResponseEntity<Integer> getNextCompteur(
            @PathVariable String configId,
            @RequestParam(name = "valeurInitiale", defaultValue = "0") int valeurInitiale) {

        int next = counterService.getNextValue(configId, valeurInitiale);
        return ResponseEntity.ok(next);
    }
}

