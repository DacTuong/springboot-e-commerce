package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springboot_ecommerce.springboot_ecommerce.dto.BrandDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Brand;
import springboot_ecommerce.springboot_ecommerce.repository.BrandRepository;
import springboot_ecommerce.springboot_ecommerce.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/brands";

    @Override
    public void saveAll(List<BrandDTO> brands, List<MultipartFile> images) {

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists())
            dir.mkdirs();

        for (int i = 0; i < brands.size(); i++) {

            BrandDTO dto = brands.get(i);

            if (dto.getName() == null || dto.getName().isBlank()) {
                throw new IllegalArgumentException("Tên thương hiệu không được để trống");
            }

            Brand brand = new Brand();
            brand.setName(dto.getName());
            brand.setSlug(dto.getSlug());

            // xử lý ảnh nếu có
            if (images != null && i < images.size()) {
                MultipartFile file = images.get(i);
                if (file != null && !file.isEmpty()) {
                    try {
                        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                        file.transferTo(new File(UPLOAD_DIR + "/" + filename));
                        brand.setImage(filename);
                    } catch (Exception e) {
                        throw new RuntimeException("Upload ảnh thất bại", e);
                    }
                }
            }

            brandRepository.save(brand);
        }
    }

    @Override
    public void updateBrand(Long id, BrandDTO dto, MultipartFile image) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không thể tìm thấy Brand id =" + id));
        brand.setName(dto.getName());
        brand.setSlug(dto.getSlug());
        if (image != null && !image.isEmpty()) {
            if (brand.getImage() != null) {
                File oldFile = new File(UPLOAD_DIR + "/" + brand.getImage());
                if (oldFile.exists())
                    oldFile.delete();
            }
            try {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                image.transferTo(new File(UPLOAD_DIR + "/" + fileName));
                brand.setImage(fileName);
            } catch (Exception e) {
                throw new RuntimeException("Upload ảnh thất bại");
            }

        }
        brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy brand id = " + id));
    }

    @Override
    public void deleteBrandID(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand không tồn tại"));
        if (brand.getImage() != null) {
            File imageFile = new File(UPLOAD_DIR + "/" + brand.getImage());
            if (imageFile.exists()) {
                imageFile.delete();
            }
        }
        brandRepository.deleteById(id);
    }

}
