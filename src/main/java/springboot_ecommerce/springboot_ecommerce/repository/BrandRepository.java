
package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    boolean existsBySlug(String slug);
}
