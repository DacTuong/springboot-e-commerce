package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeStorageRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeStorageResponse;

public interface AttributeStorageService {
    void saveAll(List<AttributeStorageRequest> requests);

    List<AttributeStorageResponse> getAttributeStorage();
}
