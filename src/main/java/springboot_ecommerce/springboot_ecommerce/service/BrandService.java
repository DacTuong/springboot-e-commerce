package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.entity.Brands;

public interface BrandService {
    void saveAll(List<Brands> brands);

    List<Brands> getAll();
}
