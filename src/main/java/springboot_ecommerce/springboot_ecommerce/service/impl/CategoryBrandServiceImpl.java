package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.CategoryBrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brand;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.entity.CategoryBrand;
import springboot_ecommerce.springboot_ecommerce.repository.BrandRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryBrandRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.service.CategoryBrandService;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandRepository categoryBrandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void save(CategoryBrandDTO dto) {

        // 1️⃣ Lấy Category
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // 3️⃣ Tạo danh sách CategoryBrand mới
        List<CategoryBrand> list = dto.getBrandIds().stream()
                .map(brandId -> {
                    Brand brand = brandRepository.findById(brandId)
                            .orElseThrow(() -> new RuntimeException("Brand not found"));

                    CategoryBrand cb = new CategoryBrand();
                    cb.setCategory(category);
                    cb.setBrand(brand);
                    return cb;
                })
                .toList();

        // 4️⃣ Lưu DB
        categoryBrandRepository.saveAll(list);
    }

    @Override
    public List<CategoryBrand> getAll() {
        return categoryBrandRepository.findAll();
    }
}
