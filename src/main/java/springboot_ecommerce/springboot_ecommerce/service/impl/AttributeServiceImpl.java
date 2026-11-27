package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateAttributeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.request.UpdateAttributeRequest;
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
    @Transactional
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
                attribute.getAttributeStorage() != null
                        ? attribute.getAttributeStorage().getStorageCode()
                        : null,
                attribute.getIsFilterable(),
                attribute.getIsVariant());

    }

    @Override
    @Transactional
    public void updateAttribute(Long idAttribute, UpdateAttributeRequest request) {

        // 1. Kiểm tra id có tồn tại
        Attribute attribute = attributeRepository.findById(idAttribute)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thuộc tính này"));
        // 2. Kiểm tra Request
        if (request == null) {
            throw new RuntimeException("Dữ liệu cập nhật không được để trống");
        }

        // 3. Kiểm tra tên thuộc tính
        if (request.getNameAttribute() == null ||
                request.getNameAttribute().trim().isEmpty()) {

            throw new RuntimeException("Tên thuộc tính không được để trống");
        }

        // 4. Kiểm tra inputType
        if (request.getInputType() == null ||
                request.getInputType().trim().isEmpty()) {

            throw new RuntimeException("Input type không được để trống");
        }

        // 5. Kiểm tra idStorage
        if (request.getIdStorage() == null) {
            throw new RuntimeException("Storage không được để trống");
        }

        AttributeStorage storage = attributeStorageRepository
                .findById(request.getIdStorage())
                .orElseThrow(() -> new RuntimeException("Storage không tồn tại"));

        // 6. Kiểm tra isFilterable
        if (request.getIsFilterable() == null ||
                (request.getIsFilterable() != 0 &&
                        request.getIsFilterable() != 1)) {

            throw new RuntimeException(
                    "isFilterable chỉ được nhận giá trị 0 hoặc 1");
        }

        // 7. Kiểm tra isVariant
        if (request.getIsVariant() == null ||
                (request.getIsVariant() != 0 &&
                        request.getIsVariant() != 1)) {

            throw new RuntimeException(
                    "isVariant chỉ được nhận giá trị 0 hoặc 1");
        }

        // 8. Cập nhật dữ liệu
        attribute.setNameAttribute(request.getNameAttribute().trim());
        attribute.setInputType(request.getInputType());
        attribute.setAttributeStorage(storage);
        attribute.setIsFilterable(request.getIsFilterable());
        attribute.setIsVariant(request.getIsVariant());

        // 9. Lưu dữ liệu
        attributeRepository.save(attribute);
    }

}
