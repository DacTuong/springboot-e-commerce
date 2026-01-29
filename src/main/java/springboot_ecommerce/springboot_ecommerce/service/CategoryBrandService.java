package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.CategoryBrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.CategoryBrand;

public interface CategoryBrandService {
    void save(CategoryBrandDTO dto);

    List<CategoryBrand> getAll();
}
