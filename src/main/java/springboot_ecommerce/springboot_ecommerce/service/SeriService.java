package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.SeriDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Seri;

public interface SeriService {
    void saveAll(List<SeriDTO> listDto);

    List<Seri> getAll();

    Seri getSeriById(Long id);

    void updateSeri(Long id, SeriDTO seriDTO);
}
