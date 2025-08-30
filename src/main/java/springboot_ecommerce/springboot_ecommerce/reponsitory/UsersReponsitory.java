package springboot_ecommerce.springboot_ecommerce.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot_ecommerce.springboot_ecommerce.model.Users;

public interface UsersReponsitory extends JpaRepository<Users, Long> {

}
