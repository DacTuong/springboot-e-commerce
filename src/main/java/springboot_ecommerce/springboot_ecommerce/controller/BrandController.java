package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import springboot_ecommerce.springboot_ecommerce.dto.BrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brands;
import springboot_ecommerce.springboot_ecommerce.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createBrands(
            @RequestPart("brands") List<BrandDTO> brands,
            @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        brandService.saveAll(brands, images);
        return ResponseEntity.ok("Thêm thương hiệu thành công");
    }

    @GetMapping
    public ResponseEntity<List<Brands>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrandID(id);
        return ResponseEntity.ok("Xoá thương hiệu thành công");
    }

    @GetMapping("/{id}")
    public Brands getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestPart("brand") BrandDTO brandDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        brandService.updateBrand(id, brandDTO, image);
        return ResponseEntity.ok("Cập nhật thành công");
    }

}
