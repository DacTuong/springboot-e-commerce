package springboot_ecommerce.springboot_ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeCategoryDTO;
import springboot_ecommerce.springboot_ecommerce.service.AttributeService;

@RestController
@RequestMapping("/api/attributes")
@CrossOrigin(origins = "http://localhost:3000")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping
    public ResponseEntity<?> saveAttribute(@RequestBody AttributeCategoryDTO attributeCategoryDTO) {
        attributeService.saveAttribute(attributeCategoryDTO);
        return ResponseEntity.ok("save success");
    }
}
