
package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Brands;

public interface BrandRepository extends JpaRepository<Brands, Long> {
    boolean existsBySlug(String slug);
}
