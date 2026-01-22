package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.CategoryDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Category;

public interface CategoryService {
    void createCategory(CategoryDTO categoryDTO);

    void createCategories(List<CategoryDTO> dtos); // 👈 thêm

    List<Category> getAllCategories();
}
