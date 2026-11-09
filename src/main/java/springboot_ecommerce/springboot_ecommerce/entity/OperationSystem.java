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
@Table(name = "operation_system")
public class OperationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation ")
    private Long idOperation;

    @ManyToOne
    @JoinColumn(name = "id_attribute", nullable = false)
    private Attribute attribute;

    @Column(name = "name_operation", nullable = false)
    private String nameOperation;

    public Long getidOperation() {
        return idOperation;
    }

    public void setidOperation(Long idOperation) {
        this.idOperation = idOperation;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }
}
