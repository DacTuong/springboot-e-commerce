package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategorySlug(String categorySlug);
}
