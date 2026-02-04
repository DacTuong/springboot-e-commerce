package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.SeriDTO;

public interface SeriService {
    void saveAll(List<SeriDTO> listDto);
}
