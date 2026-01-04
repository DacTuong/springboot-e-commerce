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

import springboot_ecommerce.springboot_ecommerce.entity.Brands;
import springboot_ecommerce.springboot_ecommerce.service.BrandService;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> saveBrands(@RequestBody List<Brands> brands) {
        brandService.saveAll(brands);
        return ResponseEntity.ok("Lưu thương hiệu thành công");
    }

    // Lấy danh sách brand
    @GetMapping
    public ResponseEntity<List<Brands>> getBrands() {
        return ResponseEntity.ok(brandService.getAll());
    }
}
