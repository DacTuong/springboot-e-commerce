package springboot_ecommerce.springboot_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot_ecommerce.springboot_ecommerce.entity.Attribute;
import springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    // @Query("""
    // SELECT a
    // FROM Attribute a
    // JOIN FETCH a.attributeGroup g
    // WHERE g.idGroup = :groupId
    // """)

    @Query("""
            SELECT new springboot_ecommerce.springboot_ecommerce.dto.response.AttributeResponse(
                g.idGroup,
                g.nameGroup,
                a.idAttribute,
                a.nameAttribute,
               a.dataType
            )
            FROM Attribute a
            JOIN a.attributeGroup g
            WHERE g.idGroup = :groupId
            """)
    List<AttributeResponse> findByAttributeGroup_IdGroup(@Param("groupId") Long idGroup);
}
