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

    @Column(name = "data_type", nullable = false)
    private String dataType;
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

    public String getDataType() {
        return dataType;

    }

    public void setDatatype(String dataType) {
        this.dataType = dataType;
    }
}
