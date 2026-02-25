package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import springboot_ecommerce.springboot_ecommerce.dto.AttributeCategoryDTO;
import springboot_ecommerce.springboot_ecommerce.dto.AttributeFromGroupDTO;
import springboot_ecommerce.springboot_ecommerce.dto.AttributeItemDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;
import springboot_ecommerce.springboot_ecommerce.entity.Category;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeGroupRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;
import springboot_ecommerce.springboot_ecommerce.repository.CategoryRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;
    private final CategoryRepository categoryRepository;
    private final AttributeGroupRepository attributeGroupRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository, CategoryRepository categoryRepository,
            AttributeGroupRepository attributeGroupRepository) {
        this.attributeRepository = attributeRepository;
        this.categoryRepository = categoryRepository;
        this.attributeGroupRepository = attributeGroupRepository;
    }

    @Override
    public void saveAttribute(AttributeCategoryDTO attributeCategoryDTO) {
        Category category = categoryRepository.findById(attributeCategoryDTO.getIdCategory())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy category"));

        for (AttributeFromGroupDTO group : attributeCategoryDTO.getGroupAttribute()) {
            AttributeGroup attributeGroup = attributeGroupRepository.findById(group.getIdGroup())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy nhóm"));
            for (AttributeItemDTO attr : group.getAttributes()) {
                Attribute entity = new Attribute();
                entity.setCategory(category);
                entity.setAttributeGroup(attributeGroup);
                entity.setNameAttribute(attr.getNameAttribute());
                entity.setDatatype(attr.getDataType());
                attributeRepository.save(entity);
            }
        }
    }

    @Override
    public List<AttributeCategoryDTO> getAllAttributes() {
        List<Attribute> listAttribute = attributeRepository.findAllWithJoin();

        Map<Long, Map<Long, List<AttributeItemDTO>>> categoryMap = new LinkedHashMap<>();
        for (Attribute att : listAttribute) {
            Long idCategory = att.getCategory().getIdCategory();
            Long idGroup = att.getAttributeGroup().getIdGroup();

            if (!categoryMap.containsKey(idCategory)) {
                categoryMap.put(idCategory, new LinkedHashMap<>());
            }

            Map<Long, List<AttributeItemDTO>> groupMap = categoryMap.get(idCategory);

            if (!groupMap.containsKey(idGroup)) {
                groupMap.put(idGroup, new ArrayList<>());
            }
            groupMap.get(idGroup).add(new AttributeItemDTO(
                    att.getIdAttribute(),
                    att.getNameAttribute(),
                    att.getDataType()));
        }

        List<AttributeCategoryDTO> result = new ArrayList<>();
        for (Map.Entry<Long, Map<Long, List<AttributeItemDTO>>> categoEntry : categoryMap.entrySet()) {
            AttributeCategoryDTO categoryDTO = new AttributeCategoryDTO();
            categoryDTO.setIdCategory(categoEntry.getKey());

            List<AttributeFromGroupDTO> groupDTOs = new ArrayList<>();
            for (Map.Entry<Long, List<AttributeItemDTO>> groupsEntry : categoEntry.getValue().entrySet()) {
                AttributeFromGroupDTO groupDTO = new AttributeFromGroupDTO();
                groupDTO.setIdGroup(groupsEntry.getKey());
                groupDTO.setAttributes(groupsEntry.getValue());

                groupDTOs.add(groupDTO);

            }
            categoryDTO.setGroupAttribute(groupDTOs);
            result.add(categoryDTO);

        }
        return result;

    }

}
