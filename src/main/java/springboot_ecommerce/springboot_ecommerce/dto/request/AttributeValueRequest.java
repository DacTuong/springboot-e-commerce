package springboot_ecommerce.springboot_ecommerce.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeValueRequest {
    @JsonProperty("attribute_id")
    private Long idAttribute;
    @JsonProperty("values")
    private List<String> valueAttributes;

    public Long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Long idAttribute) {
        this.idAttribute = idAttribute;
    }

    public List<String> getValueAttributes() {
        return valueAttributes;
    }

    public void setValueAttributes(List<String> valueAttributes) {
        this.valueAttributes = valueAttributes;
    }

}
