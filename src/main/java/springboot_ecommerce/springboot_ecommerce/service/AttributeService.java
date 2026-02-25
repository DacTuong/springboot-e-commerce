package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeCategoryDTO;

public interface AttributeService {
    void saveAttribute(AttributeCategoryDTO attributeCategoryDTO);

    List<AttributeCategoryDTO> getAllAttributes();
}
