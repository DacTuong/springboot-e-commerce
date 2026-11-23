package springboot_ecommerce.springboot_ecommerce.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot_ecommerce.springboot_ecommerce.dto.request.AttributeStorageRequest;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeStorageResponse;
import springboot_ecommerce.springboot_ecommerce.entity.AttributeStorage;
import springboot_ecommerce.springboot_ecommerce.repository.AttributeStorageRepository;
import springboot_ecommerce.springboot_ecommerce.service.AttributeStorageService;

@Service
@Transactional
public class AttributeStorageServiceImpl implements AttributeStorageService {

    private final AttributeStorageRepository attributeStorageRepository;

    public AttributeStorageServiceImpl(AttributeStorageRepository attributeStorageRepository) {
        this.attributeStorageRepository = attributeStorageRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<AttributeStorageRequest> requests) {
        if (requests == null || requests.isEmpty()) {
            throw new RuntimeException("Danh sách loại thuộc tính không được để trống");
        }

        Set<String> storageCodes = new HashSet<>();
        List<AttributeStorage> attributeStorages = new ArrayList<>();

        for (AttributeStorageRequest request : requests) {
            if (request.getStorageCode() == null || request.getStorageCode().isBlank()) {
                throw new RuntimeException("Mã loại thuộc tính không được để trống");
            }

            if (request.getStorageName() == null || request.getStorageName().isBlank()) {
                throw new RuntimeException("Tên loại thuộc tính không được để trống");
            }

            String storageCode = request.getStorageCode().trim();
            String storageName = request.getStorageName().trim();

            // Kiểm tra mã bị trùng trong chính danh sách gửi lên
            if (!storageCodes.add(storageCode)) {
                throw new RuntimeException("Mã bị trùng: " + storageCode);
            }

            // Kiểm tra mã đã tồn tại trong database chưa
            if (attributeStorageRepository.existsByStorageCode(storageCode)) {
                throw new RuntimeException("Mã này đã tồn tại: " + storageCode);
            }

            AttributeStorage attributeStorage = new AttributeStorage();
            attributeStorage.setStorageCode(storageCode);
            attributeStorage.setStorageName(storageName);
            attributeStorages.add(attributeStorage);
        }

        attributeStorageRepository.saveAll(attributeStorages);
    }

    @Override
    public List<AttributeStorageResponse> getAttributeStorage() {
        List<AttributeStorage> attributeStorages = attributeStorageRepository.findAll();
        List<AttributeStorageResponse> responses = new ArrayList<>();

        for (AttributeStorage item : attributeStorages) {
            responses.add(new AttributeStorageResponse(
                    item.getStorageCode(),
                    item.getStorageName()));
        }

        return responses;
    }
}