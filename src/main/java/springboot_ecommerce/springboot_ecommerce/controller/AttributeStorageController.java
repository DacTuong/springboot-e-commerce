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

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeStorageRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeStorageResponse;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeStorage;
import springboot_ecommerce.springboot_ecommerce.service.AttributeStorageService;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;

@RestController
@RequestMapping("/api/attribute-storage")
@CrossOrigin("http://localhost:3000")
public class AttributeStorageController {
    private final AttributeStorageService attributeTypeService;

    public AttributeStorageController(
            AttributeStorageService attributeTypeService) {
        this.attributeTypeService = attributeTypeService;
    }

    @PostMapping
    public ResponseEntity<String> saveAll(
            @RequestBody List<AttributeStorageRequest> requests) {

        attributeTypeService.saveAll(requests);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Thêm loại thuộc tính thành công");
    }

    @GetMapping
    public List<AttributeStorageResponse> getAll() {
        return attributeTypeService.getAttributeStorage();
    }
}
