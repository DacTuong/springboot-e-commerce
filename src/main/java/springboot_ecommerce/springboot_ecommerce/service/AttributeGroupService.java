package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeGroupRequest;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeGroupResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.GroupItemResponse;

public interface AttributeGroupService {
    void createGroup(List<CreateAttributeGroupRequest> attributeGroups);

    List<AttributeGroupResponse> getAllAttributeGroup();

    GroupItemResponse getNameGroupByIdGroup(Long idGroup);

    // AttributeGroup getGroupWithCategory(Long groupId);
}
