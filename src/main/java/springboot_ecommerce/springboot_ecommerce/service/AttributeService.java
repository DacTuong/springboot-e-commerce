package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;

public interface AttributeService {
    // void createAttribute(Long idGroupAttribute, List<CreateAttributeRequest>
    // createAttribute);

    List<AttributeResponse> getByGroupId(Long idGroup);

}
