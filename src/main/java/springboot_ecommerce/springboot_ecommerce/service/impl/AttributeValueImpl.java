package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeValueRequest;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeValue;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeValueRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeValueService;

@Service
@Transactional
public class AttributeValueImpl implements AttributeValueService {
    private final AttributeRepository attributeRepository;
    private final AttributeValueRepository attributeValueRepository;

    public AttributeValueImpl(AttributeRepository attributeRepository,
            AttributeValueRepository attributeValueRepository) {
        this.attributeRepository = attributeRepository;
        this.attributeValueRepository = attributeValueRepository;
    }

    public void saveAttributeValue(AttributeValueRequest request) {
        // 1 kiểm tra dữ liệu
        if (request == null || request.getIdAttribute() == null) {
            throw new IllegalArgumentException("Attribute id không được để trống");
        }
        if (request.getValueAttributes() == null || request.getValueAttributes().isEmpty()) {
            throw new IllegalArgumentException("danh sách lựa chọn đang để trống");
        }

        // 2 kiểm tra xem có idAttribute trong danh sách không
        Attribute attributeId = attributeRepository.findById(request.getIdAttribute())
                .orElseThrow(() -> new RuntimeException("Không có thuộc tính này"));

        // 3. Tạo danh sách entity

        List<AttributeValue> entities = new ArrayList<>();
        for (String value : request.getValueAttributes()) {
            if (value == null || value.isBlank()) {
                continue;
            }
            AttributeValue attributeValue = new AttributeValue();

            attributeValue.setAttribute(attributeId);
            attributeValue.setValueAttributes(value.trim());
            entities.add(attributeValue);
        }

        // 4. Kiểm tra danh sách sau khi lọc
        if (entities.isEmpty()) {
            throw new IllegalArgumentException(
                    "Không có lựa chọn hợp lệ để thêm");
        }

        // 5. Lưu tất cả entity
        // attributeValueRepository.saveAll(entities);
    }
}
