package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.TypeCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeTypeRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeTypeResponse;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeType;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeValue;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeRepository;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeTypeRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeTypeService;

@Service
@Transactional
public class AttributeTypeServiceImpl implements AttributeTypeService {
    private final AttributeTypeRepository attributeTypeRepository;

    AttributeTypeServiceImpl(AttributeTypeRepository attributeTypeRepository) {
        this.attributeTypeRepository = attributeTypeRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<AttributeTypeRequest> requests) {
        // // 1 kiểm tra dữ liệu
        if (requests == null || requests.isEmpty()) {
            throw new RuntimeException("Danh sách loại thuộc tính không được để trống");
        }
        Set<String> codes = new HashSet<>();
        List<AttributeType> attributeTypes = new ArrayList<>();

        for (AttributeTypeRequest request : requests) {
            if (request.getTypeCode() == null || request.getTypeCode().isBlank()) {
                throw new RuntimeException("Mã loại thuộc tính không được để trống");
            }

            if (request.getTypeName() == null || request.getTypeName().isBlank()) {
                throw new RuntimeException("Tên loại thuộc tính không được để trống");
            }

            String code = request.getTypeCode().trim();
            String name = request.getTypeName().trim();

            // kiểm tra xem dữ liệu tải lên có bị trùng không
            if (!codes.add(code)) {
                throw new RuntimeException("Mã bị trùng" + code);
            }

            // kiểm tra đã có mã trong database

            if (attributeTypeRepository.existsById(code)) {
                throw new RuntimeException("Mã này đã tồn tại");

            }
            AttributeType attributeType = new AttributeType();

            attributeType.setTypeCode(code);
            attributeType.setTypeName(name);
            attributeTypes.add(attributeType);
        }
        attributeTypeRepository.saveAll(attributeTypes);

    }

    @Override
    public List<AttributeTypeResponse> getAttributeType() {

        List<AttributeType> attributeTypes = attributeTypeRepository.findAll();
        List<AttributeTypeResponse> attributeTypeResponses = new ArrayList<>();
        for (AttributeType item : attributeTypes) {
            AttributeTypeResponse attributeResponse = new AttributeTypeResponse(
                    item.getTypeCode(),
                    item.getTypeName());

            attributeTypeResponses.add(attributeResponse);
        }
        return attributeTypeResponses;
    }

}
