package springboot_ecommerce.springboot_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot_ecommerce.springboot_ecommerce.entity.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    @Query("""
            SELECT att FROM Attribute att
            JOIN FETCH att.category
            JOIN FETCH att.attributeGroup
            """)
    List<Attribute> findAllWithJoin();
}
