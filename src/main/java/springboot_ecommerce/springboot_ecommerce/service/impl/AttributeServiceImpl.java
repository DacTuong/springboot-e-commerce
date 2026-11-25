package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeStorage;
import springboot_ecommerce.springboot_ecommerce.entity.Brand;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeGroupRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;

import springboot_ecommerce.springboot_ecommerce.service.AttributeService;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeStorageRepository;

@Service
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeGroupRepository attributeGroupRepository;
    private final AttributeStorageRepository attributeStorageRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository,
            AttributeGroupRepository attributeGroupRepository, AttributeStorageRepository attributeStorageRepository) {
        this.attributeRepository = attributeRepository;

        this.attributeGroupRepository = attributeGroupRepository;

        this.attributeStorageRepository = attributeStorageRepository;
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
            attribute.setInputType(req.getInputType());
            attribute.setIsVariant(req.getIsVariant());

            attribute.setIsFilterable(req.getIsFilterable());

            if (req.getIdStorage() != null) {

                AttributeStorage attributeStorage = attributeStorageRepository
                        .findById(req.getIdStorage())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy nguồn dữ liệu"));

                attribute.setAttributeStorage(attributeStorage);
            }

            attribute.setAttributeGroup(group);
            return attribute;
        }).toList();
        attributeRepository.saveAll(attributes);

    }

    @Override
    public AttributeResponse getAttributeById(Long idAttribute) {
        Attribute attribute = attributeRepository.findById(idAttribute)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thuộc tính này"));
        return new AttributeResponse(
                attribute.getIdAttribute(),
                attribute.getNameAttribute(),
                attribute.getInputType(),
                attribute.getAttributeStorage() != null
                        ? attribute.getAttributeStorage().getIdStorage()
                        : null,
                attribute.getIsFilterable(),
                attribute.getIsVariant());

    }
}
