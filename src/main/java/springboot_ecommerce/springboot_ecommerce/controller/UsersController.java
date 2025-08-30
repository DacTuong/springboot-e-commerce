package springboot_ecommerce.springboot_ecommerce.controller;

import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.model.Users;
import springboot_ecommerce.springboot_ecommerce.service.UsersService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // Lấy tất cả user
    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    // Lấy user theo id
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    // Tạo user mới
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    // Xóa user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return "Deleted user with id " + id;
    }
}
