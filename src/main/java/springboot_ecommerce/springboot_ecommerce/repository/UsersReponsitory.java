package springboot_ecommerce.springboot_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.entity.Users;

public interface UsersReponsitory extends JpaRepository<Users, Long> {

}
