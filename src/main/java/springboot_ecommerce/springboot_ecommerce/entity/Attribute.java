package springboot_ecommerce.springboot_ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attribute")
    private Long idAttribute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", nullable = false)
    private AttributeGroup attributeGroup;

    @Column(name = "name_attribute", nullable = false)
    private String nameAttribute;

    @Column(name = "input_type", nullable = false)
    private String inputType;

    // Nơi lưu trữ dữ liệu của thuộc tính
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_storage")
    private AttributeStorage attributeStorage;

    @Column(name = "is_filterable", nullable = false)
    private Long isFilter;

    // Có phải thuộc tính phân loại biến thể hay không
    @Column(name = "is_variant", nullable = false)
    private Long isVariant;

    // ===== Getter & Setter =====

    public Long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Long idAttribute) {
        this.idAttribute = idAttribute;
    }

    public AttributeGroup getAttributeGroup() {
        return attributeGroup;
    }

    public void setAttributeGroup(AttributeGroup attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

    public String getNameAttribute() {
        return nameAttribute;
    }

    public void setNameAttribute(String nameAttribute) {
        this.nameAttribute = nameAttribute;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public AttributeStorage getAttributeStorage() {
        return attributeStorage;
    }

    public void setAttributeStorage(AttributeStorage attributeStorage) {
        this.attributeStorage = attributeStorage;
    }

    public Long getIsFilterable() {
        return isFilter;
    }

    public void setIsFilterable(Long isFiter) {
        this.isFilter = isFiter;
    }

    public Long getIsVariant() {
        return isVariant;
    }

    public void setIsVariant(Long isVariant) {
        this.isVariant = isVariant;
    }
}
