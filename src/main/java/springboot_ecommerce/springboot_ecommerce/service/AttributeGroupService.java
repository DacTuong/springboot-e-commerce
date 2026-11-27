package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeGroupRequest;

import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeGroupResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.GroupAttributeDetailResponse;

public interface AttributeGroupService {
    void createGroup(List<CreateAttributeGroupRequest> attributeGroups);

    List<AttributeGroupResponse> getAllAttributeGroup();

    GroupAttributeDetailResponse getGroupInfo(Long idGroup);

    // AttributeGroup getGroupWithCategory(Long groupId);
}
