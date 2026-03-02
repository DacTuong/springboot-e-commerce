package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeGroupRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.CreateGroupItemRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeGroupResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.GroupItemResponse;
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
    public void createGroup(List<CreateAttributeGroupRequest> attributeGroupDTOs) {

        List<AttributeGroup> entities = new ArrayList<>();
        for (CreateAttributeGroupRequest dto : attributeGroupDTOs) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category không tồn tại"));

            for (CreateGroupItemRequest groupDTO : dto.getGroups()) {
                AttributeGroup attributeGroup = new AttributeGroup();
                attributeGroup.setCategory(category);
                attributeGroup.setNameGroup(groupDTO.getNameGroup());
                entities.add(attributeGroup);
            }

        }
        attributeGroupRepository.saveAll(entities);
    }

    @Override
    public List<AttributeGroupResponse> getAllAttributeGroup() {
        List<AttributeGroup> listAttribute = attributeGroupRepository.findAll();

        Map<Long, List<GroupItemResponse>> map = new LinkedHashMap<>();

        for (AttributeGroup ag : listAttribute) {
            Long categoryId = ag.getCategory().getIdCategory();

            if (!map.containsKey(categoryId)) {
                map.put(categoryId, new ArrayList<>());
            }
            map.get(categoryId).add(new GroupItemResponse(
                    ag.getIdGroup(),
                    ag.getNameGroup()));
        }
        List<AttributeGroupResponse> result = new ArrayList<>();
        for (Map.Entry<Long, List<GroupItemResponse>> entry : map.entrySet()) {
            AttributeGroupResponse dto = new AttributeGroupResponse();

            dto.setCategoryId(entry.getKey());

            dto.setGroups(entry.getValue());
            for (AttributeGroup ag : listAttribute) {
                if (ag.getCategory().getIdCategory().equals(entry.getKey())) {
                    dto.setCategoryName(ag.getCategory().getCategoryName());
                    break;
                }
            }

            result.add(dto);
        }
        return result;

    }

    @Override
    public List<CreateGroupItemRequest> getGroupsByCategoryId(Long categoryId) {
        List<AttributeGroup> groups = attributeGroupRepository.findByCategory_IdCategory(categoryId);
        return groups.stream().map(group -> new CreateGroupItemRequest(
                group.getIdGroup(),
                group.getNameGroup())).toList();
    }
}
