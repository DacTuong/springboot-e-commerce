package springboot_ecommerce.springboot_ecommerce.dto.request;

public class AttributeValueRequest {

    private Long idAttribute;
    private String valueAttribute;

    public Long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Long idAttribute) {
        this.idAttribute = idAttribute;
    }

    public String getValueAttribute() {
        return valueAttribute;
    }

    public void setValueAttribute(String valueAttribute) {
        this.valueAttribute = valueAttribute;
    }

}
