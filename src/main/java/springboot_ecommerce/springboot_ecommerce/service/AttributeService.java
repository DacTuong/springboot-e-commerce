package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;

public interface AttributeService {

    List<AttributeResponse> getByGroupId(Long idGroup);
}
