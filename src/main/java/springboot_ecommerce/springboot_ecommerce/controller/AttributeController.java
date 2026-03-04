package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.service.AttributeService;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "http://localhost:3000")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    // @PostMapping
    // public ResponseEntity<?> saveAttribute(@RequestBody AttributeCategoryDTO
    // attributeCategoryDTO) {
    // attributeService.saveAttribute(attributeCategoryDTO);
    // return ResponseEntity.ok("save success");
    // }

    @GetMapping("/{idGroup}/attributes")
    public ResponseEntity<List<AttributeResponse>> getAttributeByGroup(@PathVariable Long idGroup) {
        return ResponseEntity.ok(attributeService.getByGroupId(idGroup));
    }

}
