package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import springboot_ecommerce.springboot_ecommerce.dto.BrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brands;

public interface BrandService {
    void saveAll(List<BrandDTO> brands, List<MultipartFile> images);

    List<Brands> getAll();

    Brands getBrandById(Long id);

    void deleteBrandID(Long id);

}
