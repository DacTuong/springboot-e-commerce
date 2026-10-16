package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeValueRequest;

public interface AttributeValueService {
    void saveAttributeValue(AttributeValueRequest request);
}
