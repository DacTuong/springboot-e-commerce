package springboot_ecommerce.springboot_ecommerce.service;

import org.springframework.stereotype.Service;

import springboot_ecommerce.springboot_ecommerce.entity.Users;
import springboot_ecommerce.springboot_ecommerce.repository.UsersReponsitory;

import java.util.List;

@Service
public class UsersService {
    private final UsersReponsitory usersReponsitory;

    public UsersService(UsersReponsitory usersReponsitory) {
        this.usersReponsitory = usersReponsitory;
    }

    public List<Users> getAllUsers() {
        return usersReponsitory.findAll();
    }

    public Users createUser(Users user) {
        return usersReponsitory.save(user);
    }

    public Users getUserById(Long id) {
        return usersReponsitory.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        usersReponsitory.deleteById(id);
    }
}
