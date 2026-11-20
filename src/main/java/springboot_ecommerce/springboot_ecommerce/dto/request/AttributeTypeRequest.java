package springboot_ecommerce.springboot_ecommerce.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeTypeRequest {

    @JsonProperty("type_code")
    private String typeCode;

    @JsonProperty("type_name")
    private String typeName;

    public String getTypeCode() {
        return typeCode;
    }

    public void setCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypename(String typeName) {
        this.typeName = typeName;
    }
}
