package springboot_ecommerce.springboot_ecommerce.service;

import java.util.List;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeGroupDTO;

public interface AttributeGroupService {
    void createGroup(List<AttributeGroupDTO> attributeGroups);
}
