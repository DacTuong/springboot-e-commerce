package springboot_ecommerce.springboot_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot_ecommerce.springboot_ecommerce.entity.AttributeGroup;

public interface AttributeGroupRepository extends JpaRepository<AttributeGroup, Long> {

    List<AttributeGroup> findByCategory_IdCategory(Long idCagegory);

    @Query("SELECT ag FROM AttributeGroup ag JOIN FETCH ag.category")
    List<AttributeGroup> findAllWithCategory();

    // @Query("""
    // SELECT g
    // FROM AttributeGroup g
    // JOIN FETCH g.category c
    // WHERE g.idGroup = :groupId
    // """)
    // AttributeGroup findGroupWithCategory(@Param("groupId") Long groupId);
}
