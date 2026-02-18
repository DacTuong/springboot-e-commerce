package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeGroupDTO;
import springboot_ecommerce.springboot_ecommerce.dto.GroupItemAttrDTO;
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

            for (GroupItemAttrDTO groupDTO : dto.getGroups()) {
                AttributeGroup attributeGroup = new AttributeGroup();
                attributeGroup.setCategory(category);
                attributeGroup.setNameGroup(groupDTO.getNameGroup());
                entities.add(attributeGroup);
            }

        }
        attributeGroupRepository.saveAll(entities);
    }

    @Override
    public List<AttributeGroupDTO> getAllAttributeGroup() {
        List<AttributeGroup> listAttribute = attributeGroupRepository.findAll();

        Map<Long, List<GroupItemAttrDTO>> map = new LinkedHashMap<>();

        for (AttributeGroup ag : listAttribute) {
            Long categoryId = ag.getCategory().getIdCategory();

            if (!map.containsKey(categoryId)) {
                map.put(categoryId, new ArrayList<>());
            }
            map.get(categoryId).add(new GroupItemAttrDTO(
                    ag.getIdGroup(),
                    ag.getNameGroup()));
        }
        List<AttributeGroupDTO> result = new ArrayList<>();
        for (Map.Entry<Long, List<GroupItemAttrDTO>> entry : map.entrySet()) {
            AttributeGroupDTO dto = new AttributeGroupDTO();

            dto.setCategoryId(entry.getKey());
            dto.setGroups(entry.getValue());

            result.add(dto);
        }
        return result;

    }
}
