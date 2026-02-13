package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeGroupDTO;
import springboot_ecommerce.springboot_ecommerce.service.AttributeGroupService;

@RestController
@RequestMapping("/api/attribute-group")
@CrossOrigin(origins = "http://localhost:3000")
public class AttributeGroupController {
    @Autowired
    private final AttributeGroupService attributeGroupService;

    public AttributeGroupController(AttributeGroupService attributeGroupService) {
        this.attributeGroupService = attributeGroupService;
    }

    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody List<AttributeGroupDTO> attributeGroupDTOs) {
        attributeGroupService.createGroup(attributeGroupDTOs);
        return ResponseEntity.ok("save successfully");

    }

    @GetMapping
    public List<AttributeGroupDTO> getAll() {
        return attributeGroupService.getAllAttributeGroup();
    }
}
