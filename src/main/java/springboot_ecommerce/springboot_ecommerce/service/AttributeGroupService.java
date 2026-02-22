package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeGroupDTO;
import springboot_ecommerce.springboot_ecommerce.dto.GroupItemAttrDTO;

public interface AttributeGroupService {
    void createGroup(List<AttributeGroupDTO> attributeGroups);

    List<AttributeGroupDTO> getAllAttributeGroup();

    List<GroupItemAttrDTO> getGroupsByCategoryId(Long categoryId);
}
