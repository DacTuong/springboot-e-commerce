package springboot_ecommerce.springboot_ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attribute_values")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attribute_value")
    private Long idAttributeValue;

    @ManyToOne
    @JoinColumn(name = "id_attribute", nullable = false)
    private Attribute attribute;

    @Column(name = "value_attribute", nullable = false)
    private String valueAttribute;

    public Long getIdAttributeValue() {
        return idAttributeValue;
    }

    public void setIdAttributeValue(Long idAttributeValue) {
        this.idAttributeValue = idAttributeValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValueAttribute() {
        return valueAttribute;
    }

    public void setValueAttribute(String valueAttribute) {
        this.valueAttribute = valueAttribute;
    }

}
