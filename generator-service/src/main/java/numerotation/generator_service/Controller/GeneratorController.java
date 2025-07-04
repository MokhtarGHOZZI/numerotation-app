package numerotation.generator_service.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import numerotation.generator_service.DTO.InscritDto;
import numerotation.generator_service.Service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generator")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class GeneratorController {

    @Autowired private GeneratorService generatorService;

    @PostMapping
    public ResponseEntity<String> generateNumero(@Valid @RequestBody InscritDto inscritDto) {
        String numero = generatorService.generateNumber(inscritDto);
        return ResponseEntity.ok(numero);
    }
}
