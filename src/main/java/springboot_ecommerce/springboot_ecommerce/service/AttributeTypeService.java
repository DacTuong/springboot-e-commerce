package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeTypeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeTypeResponse;

public interface AttributeTypeService {
    void saveAll(List<AttributeTypeRequest> requests);

    List<AttributeTypeResponse> getAttributeType();
}
