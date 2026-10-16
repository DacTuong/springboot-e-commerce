package springboot_ecommerce.springboot_ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeValueRequest;
import springboot_ecommerce.springboot_ecommerce.service.AttributeValueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/attribute-values")
@CrossOrigin("http://localhost:3000")
public class AttributeValueController {
    private final AttributeValueService attributeValueService;

    public AttributeValueController(AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }

    @PostMapping
    public ResponseEntity<?> createMany(
            @RequestBody AttributeValueRequest request) {

        // attributeValueService.saveAttributeValue(request);

        try {
            attributeValueService.saveAttributeValue(request);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Thêm giá trị thuộc tính thành công");
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

}
