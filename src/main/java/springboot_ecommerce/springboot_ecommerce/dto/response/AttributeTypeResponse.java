package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeTypeResponse {
    @JsonProperty("type_code")
    private String typeCode;

    @JsonProperty("type_name")
    private String typeName;

    // Constructor không tham số
    public AttributeTypeResponse() {
    }

    // Constructor có tham số
    public AttributeTypeResponse(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
