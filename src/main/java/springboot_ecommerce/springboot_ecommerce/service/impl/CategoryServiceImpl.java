package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.CategoryDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // ✅ xử lý 1 category
    @Override
    public void createCategory(CategoryDTO dto) {

        if (dto.getCategoryName() == null ||
                dto.getCategoryName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên danh mục không được để trống");
        }

        if (dto.getCategoryName().length() < 2) {
            throw new IllegalArgumentException("Tên danh mục phải ít nhất 2 ký tự");
        }

        if (dto.getCategorySlug() == null ||
                dto.getCategorySlug().trim().isEmpty()) {
            throw new IllegalArgumentException("Slug không được để trống");
        }

        if (!dto.getCategorySlug().matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException(
                    "Slug chỉ chứa chữ thường, số và dấu gạch ngang");
        }

        if (categoryRepository.existsByCategorySlug(dto.getCategorySlug())) {
            throw new IllegalArgumentException("Slug đã tồn tại");
        }

        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setCategorySlug(dto.getCategorySlug());

        categoryRepository.save(category);
    }

    // ✅ xử lý nhiều category
    @Override
    public void createCategories(List<CategoryDTO> dtos) {
        for (CategoryDTO dto : dtos) {
            createCategory(dto); // tái sử dụng validate
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
