package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeTypeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeTypeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeType;
import springboot_ecommerce.springboot_ecommerce.service.AttributeTypeService;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;

@RestController
@RequestMapping("/api/attribute-type")
@CrossOrigin("http://localhost:3000")
public class AttributeTypeController {
    private final AttributeTypeService attributeTypeService;

    public AttributeTypeController(
            AttributeTypeService attributeTypeService) {
        this.attributeTypeService = attributeTypeService;
    }

    @PostMapping
    public ResponseEntity<String> saveAll(
            @RequestBody List<AttributeTypeRequest> requests) {

        attributeTypeService.saveAll(requests);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Thêm loại thuộc tính thành công");
    }

    @GetMapping
    public List<AttributeTypeResponse> getAll() {
        return attributeTypeService.getAttributeType();
    }
}
