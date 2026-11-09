package springboot_ecommerce.springboot_ecommerce.service;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateOperationSystem;

public interface OperationSystemService {
    void saveOperationSystem(CreateOperationSystem request);
}
