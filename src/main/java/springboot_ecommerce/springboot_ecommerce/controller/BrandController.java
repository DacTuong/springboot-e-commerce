package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot_ecommerce.springboot_ecommerce.dto.BrandRequest;
import springboot_ecommerce.springboot_ecommerce.entity.Brands;
import springboot_ecommerce.springboot_ecommerce.service.BrandService;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<?> saveBrands(
            @RequestBody List<BrandRequest> requests) {

        List<Brands> brands = new ArrayList<>();

        for (BrandRequest r : requests) {
            Brands b = new Brands();
            b.setName(r.getName());
            b.setSlug(r.getSlug_name()); // ⭐ QUAN TRỌNG

            brands.add(b);
        }

        brandService.saveAll(brands);
        return ResponseEntity.ok("Lưu thương hiệu thành công");
    }

    @GetMapping
    public ResponseEntity<List<Brands>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }
}
