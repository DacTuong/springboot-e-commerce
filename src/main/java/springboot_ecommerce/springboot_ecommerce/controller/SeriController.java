package springboot_ecommerce.springboot_ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import springboot_ecommerce.springboot_ecommerce.dto.SeriDTO;
import springboot_ecommerce.springboot_ecommerce.entity.Seri;
import springboot_ecommerce.springboot_ecommerce.service.SeriService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/seri")
@CrossOrigin(origins = "http://localhost:3000")
public class SeriController {
    private final SeriService seriService;

    public SeriController(SeriService seriService) {
        this.seriService = seriService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<SeriDTO> lSeriDTOs) {
        seriService.saveAll(lSeriDTOs);
        return ResponseEntity.ok("save successfull");
    }

    @GetMapping
    public List<Seri> getAll() {
        return seriService.getAll();
    }

    @GetMapping("/{id}")
    public Seri getSeriById(@PathVariable Long id) {
        return seriService.getSeriById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateSeri(@PathVariable Long id, @RequestBody SeriDTO seriDTO) {
        seriService.updateSeri(id, seriDTO);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeri(@PathVariable Long id) {
        seriService.deleteSeriID(id);
        return ResponseEntity.ok("xóa thành công");
    }
}
