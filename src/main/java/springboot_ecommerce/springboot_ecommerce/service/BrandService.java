package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import springboot_ecommerce.springboot_ecommerce.dto.BrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brand;

public interface BrandService {
    void saveAll(List<BrandDTO> brands, List<MultipartFile> images);

    List<Brand> getAll();

    Brand getBrandById(Long id);

    void deleteBrandID(Long id);

    void updateBrand(Long id, BrandDTO brandDTO, MultipartFile image);
}
