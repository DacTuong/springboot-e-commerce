package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeGroupRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.CreateGroupItemRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeGroupResponse;

public interface AttributeGroupService {
    void createGroup(List<CreateAttributeGroupRequest> attributeGroups);

    List<AttributeGroupResponse> getAllAttributeGroup();

    List<CreateGroupItemRequest> getGroupsByCategoryId(Long categoryId);
}
