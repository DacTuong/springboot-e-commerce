package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.UpdateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;

public interface AttributeService {
    void saveAttributes(Long idGroup, List<CreateAttributeRequest> saveAttributes);

    List<AttributeResponse> getByGroupId(Long idGroup);

    AttributeResponse getAttributeById(Long idAttribute);

    void updateAttribute(Long idAttribute, UpdateAttributeRequest request);

}
