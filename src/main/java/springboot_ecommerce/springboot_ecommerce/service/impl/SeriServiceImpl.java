package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.SeriDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brand;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.entity.Seri;
import springboot_ecommerce.springboot_ecommerce.repository.BrandRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.repository.SeriRepository;
import springboot_ecommerce.springboot_ecommerce.service.SeriService;

@Service
public class SeriServiceImpl implements SeriService {

    private final SeriRepository seriRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public SeriServiceImpl(
            SeriRepository seriRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.seriRepository = seriRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void saveAll(List<SeriDTO> listDto) {
        for (SeriDTO dto : listDto) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category không tồn tại"));
            Brand brand = brandRepository.findById(dto.getBrandId())
                    .orElseThrow(() -> new RuntimeException("Brand không tồn tại"));

            Seri seri = new Seri();
            seri.setCategory(category);
            seri.setBrand(brand);
            seri.setNameSeri(dto.getNameSeri());

            seriRepository.save(seri);

        }
    }

    @Override
    public List<Seri> getAll() {
        return seriRepository.findAll();
    }

    @Override
    public Seri getSeriById(Long id) {
        return seriRepository.findById(id).orElseThrow(() -> new RuntimeException("seri này không tồn tại"));
    }

    @Override
    public void updateSeri(Long id, SeriDTO seriDTO) {
        Seri seri = seriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không thể tìm thấy seri só" + id));

        if (seriDTO.getNameSeri() != null) {
            seri.setNameSeri(seriDTO.getNameSeri());
        }
        seriRepository.save(seri);
    }

    @Override
    public void deleteSeriID(Long id) {
        Seri seri = seriRepository.findById(id).orElseThrow(() -> new RuntimeException("Seri này không tồn tại"));
        // if (productRepository.existsBySeri(seri)) {
        // throw new RuntimeException("Seri đang được sử dụng, không thể xóa");
        // }

        seriRepository.delete(seri);
    }
}
