package springboot_ecommerce.springboot_ecommerce.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Brands;

public interface BrandRepository extends JpaRepository<Brands, Long> {
}
