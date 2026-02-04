package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.SeriDTO;
import springboot_ecommerce.springboot_ecommerce.service.SeriService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/seri")
@CrossOrigin(origins = "http://localhost:3000")
public class SeriController {
    private final SeriService seriService;

    public SeriController(SeriService seriService) {
        this.seriService = seriService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<SeriDTO> lSeriDTOs) {
        seriService.saveAll(lSeriDTOs);
        return ResponseEntity.ok("save successfull");
    }

}
