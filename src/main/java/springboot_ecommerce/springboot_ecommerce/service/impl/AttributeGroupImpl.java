package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeGroupDTO;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeGroupRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeGroupService;

@Service
public class AttributeGroupImpl implements AttributeGroupService {
    private final CategoryRepository categoryRepository;
    private final AttributeGroupRepository attributeGroupRepository;

    public AttributeGroupImpl(AttributeGroupRepository attributeGroupRepository,
            CategoryRepository categoryRepository) {
        this.attributeGroupRepository = attributeGroupRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createGroup(List<AttributeGroupDTO> attributeGroupDTOs) {

        List<AttributeGroup> entities = new ArrayList<>();
        for (AttributeGroupDTO dto : attributeGroupDTOs) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category không tồn tại"));

            for (String groupName : dto.getGroupName()) {
                AttributeGroup attributeGroup = new AttributeGroup();
                attributeGroup.setCategory(category);
                attributeGroup.setNameGroup(groupName);
                entities.add(attributeGroup);
            }

        }
        attributeGroupRepository.saveAll(entities);
    }
}
