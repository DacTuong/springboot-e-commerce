package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.AttributeStorage;

public interface AttributeStorageRepository extends JpaRepository<AttributeStorage, Long> {
    boolean existsByStorageCode(String storageCode);
}
