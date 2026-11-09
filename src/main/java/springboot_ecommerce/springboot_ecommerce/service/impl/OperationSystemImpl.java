package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.dto.request.CreateOperationSystem;
import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.entity.OperationSystem;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;
import springboot_ecommerce.springboot_ecommerce.repository.OperationRepository;
import springboot_ecommerce.springboot_ecommerce.service.OperationSystemService;

@Service
public class OperationSystemImpl implements OperationSystemService {
    private final OperationRepository operationRepository;
    private final AttributeRepository attributeRepository;

    public OperationSystemImpl(OperationRepository operationRepository, AttributeRepository attributeRepository) {
        this.operationRepository = operationRepository;
        this.attributeRepository = attributeRepository;
    }

    @Override
    public void saveOperationSystem(CreateOperationSystem request) {
        if (request == null || request.getIdAttribute() == null) {
            throw new IllegalArgumentException("Attribute không được để trống");
        }
        if (request.getOperationName() == null || request.getOperationName().isEmpty()) {
            throw new IllegalArgumentException("danh sách lựa chọn đang để trống");
        }
        Attribute attributeId = attributeRepository.findById(request.getIdAttribute())
                .orElseThrow(() -> new RuntimeException("Không có attribute này tồn tại"));

        List<OperationSystem> entities = new ArrayList<>();
        for (String value : request.getOperationName()) {
            if (value == null || value.isBlank()) {
                continue;
            }
            OperationSystem operationSystem = new OperationSystem();
            operationSystem.setAttribute(attributeId);
            operationSystem.setNameOperation(value.trim());
            entities.add(operationSystem);

        }

        // 4. Kiểm tra danh sách sau khi lọc
        if (entities.isEmpty()) {
            throw new IllegalArgumentException(
                    "Không có lựa chọn hợp lệ để thêm");
        }

        // 5. Lưu tất cả entity
        // operationRepository.saveAll(entities);
    }

}
