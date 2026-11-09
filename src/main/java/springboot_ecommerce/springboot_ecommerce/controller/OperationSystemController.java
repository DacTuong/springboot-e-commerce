package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeValueRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeGroupRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.CreateOperationSystem;
import springboot_ecommerce.springboot_ecommerce.service.AttributeGroupService;
import springboot_ecommerce.springboot_ecommerce.service.OperationSystemService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/create-operation")
@CrossOrigin(origins = "http://localhost:3000")

public class OperationSystemController {
    @Autowired
    private final OperationSystemService operationSystemService;

    public OperationSystemController(OperationSystemService operationSystemService) {
        this.operationSystemService = operationSystemService;
    }

    @PostMapping
    public ResponseEntity<?> createMany(
            @RequestBody CreateOperationSystem request) {

        // attributeValueService.saveAttributeValue(request);
        // In dữ liệu React gửi lên
        System.out.println("========== CONTROLLER ĐƯỢC GỌI ==========");
        System.out.println("Attribute ID: " + request.getIdAttribute());
        System.out.println("Value Attributes: " + request.getOperationName());

        try {
            operationSystemService.saveOperationSystem(request);
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
