package springboot_ecommerce.springboot_ecommerce.service.impl;

import org.springframework.stereotype.Service;

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

        for (AttributeFromGroupDTO group : attributeCategoryDTO.getAttributeGroup()) {
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

}
