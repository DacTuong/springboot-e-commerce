package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.CategoryBrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.CategoryBrand;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryBrandRepository;
import springboot_ecommerce.springboot_ecommerce.service.CategoryBrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/category-brand")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryBrandDTO dto) {
        categoryBrandService.save(dto);
        return ResponseEntity.ok("save successfully");
    }

    @GetMapping
    public List<CategoryBrand> getAll() {
        return categoryBrandService.getAll();
    }

}
