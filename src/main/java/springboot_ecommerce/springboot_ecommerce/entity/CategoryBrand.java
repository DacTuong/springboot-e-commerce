package springboot_ecommerce.springboot_ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brand_category")
public class CategoryBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand_cate")
    private Long id; // 🔥 đổi từ idBrandCate → id

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category; // OK

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand; // OK

    // ===== Getter & Setter =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
