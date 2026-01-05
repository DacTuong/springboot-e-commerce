package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.entity.Brands;
import springboot_ecommerce.springboot_ecommerce.reponsitory.BrandRepository;
import springboot_ecommerce.springboot_ecommerce.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void saveAll(List<Brands> brands) {
        for (Brands b : brands) {

            if (b.getName() == null || b.getName().isBlank()) {
                throw new RuntimeException("Tên thương hiệu không được để trống");
            }
            if (b.getSlug() == null || b.getSlug().isBlank()) {
                throw new RuntimeException("Slug thương hiệu không được để trống");
            }

            if (brandRepository.existsBySlug(b.getSlug())) {
                throw new RuntimeException("Slug đã tồn tại: " + b.getSlug());
            }
        }

        brandRepository.saveAll(brands);
    }

    @Override
    public List<Brands> getAll() {
        return brandRepository.findAll();
    }

}
