package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

}
