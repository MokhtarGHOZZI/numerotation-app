package numerotation.config_service.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import numerotation.config_service.DTO.ConfigurationRulesDTO;
import numerotation.config_service.DTO.RuleDto;
import numerotation.config_service.Service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@RequiredArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping
    public List<String> getAllConfigs() {
        return ruleService.getAllConfigIds();
    }

    @PostMapping
    public ResponseEntity<Void>  createRules(@RequestBody ConfigurationRulesDTO dtos){
        ruleService.createAll(dtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public List<RuleDto> getRules(@PathVariable String id) {
        return ruleService.getAllRules(id);
    }
}

