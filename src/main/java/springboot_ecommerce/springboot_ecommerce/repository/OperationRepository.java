package springboot_ecommerce.springboot_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot_ecommerce.springboot_ecommerce.entity.OperationSystem;

@Repository
public interface OperationRepository extends JpaRepository<OperationSystem, Long> {
    List<OperationSystem> findByAttribute_IdAttribute(Long idAttribute);

}
