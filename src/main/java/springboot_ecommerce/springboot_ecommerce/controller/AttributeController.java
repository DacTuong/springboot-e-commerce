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

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.service.AttributeService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/attributes")
@CrossOrigin(origins = "http://localhost:3000")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    // Lưu danh sách thuộc tính theo nhóm thuộc tính
    @PostMapping("/group/{idGroup}")
    public ResponseEntity<?> createAttribute(@PathVariable Long idGroup,
            @RequestBody List<CreateAttributeRequest> request) {
        attributeService.saveAttributes(idGroup, request);
        return ResponseEntity.ok("save");
    }

    // lấy danh sách toàn bộ thuộc tính thuộc nhóm thuộc tính
    @GetMapping("/group/{idGroup}")
    public ResponseEntity<List<AttributeResponse>> getAttributeByGroup(@PathVariable Long idGroup) {
        return ResponseEntity.ok(attributeService.getByGroupId(idGroup));
    }
    // Lấy thông tin theo id thuộc tính

    @GetMapping("/{idAttribute}")
    public ResponseEntity<AttributeResponse> getAttributeById(@PathVariable Long idAttribute) {
        return ResponseEntity.ok(attributeService.getAttributeById(idAttribute));
    }

}
