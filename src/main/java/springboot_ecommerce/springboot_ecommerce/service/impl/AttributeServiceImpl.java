package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeGroupRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;

import springboot_ecommerce.springboot_ecommerce.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeGroupRepository attributeGroupRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository,
            AttributeGroupRepository attributeGroupRepository) {
        this.attributeRepository = attributeRepository;

        this.attributeGroupRepository = attributeGroupRepository;
    }

    @Override

    public List<AttributeResponse> getByGroupId(Long idGroup) {
        if (!attributeGroupRepository.existsById(idGroup)) {
            throw new RuntimeException("Group is not found with id" + idGroup);
        }
        return attributeRepository.findByAttributeGroup_IdGroup(idGroup);
    }

    @Override
    public void saveAttributes(Long idGroup, List<CreateAttributeRequest> requests) {
        AttributeGroup group = attributeGroupRepository.findById(idGroup)
                .orElseThrow(() -> new RuntimeException("Không thể tìm thấy nhóm thuộc tính"));

        List<Attribute> attributes = requests.stream().map(req -> {
            Attribute attribute = new Attribute();
            attribute.setNameAttribute(req.getNameAttribute());
            attribute.setDataType(req.getDataType());
            attribute.setIsFiter(req.getIsFilter());
            attribute.setAttributeGroup(group);
            return attribute;
        }).toList();
        attributeRepository.saveAll(attributes);

    }
}
