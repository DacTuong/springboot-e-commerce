package springboot_ecommerce.springboot_ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAttributeRequest {

    @JsonProperty("id_attribute")
    private Long idAttribute;
    @JsonProperty("name_attribute")
    private String nameAttribute;
    @JsonProperty("data_type")
    private String dataType;

    // ✅ BẮT BUỘC phải có
    public CreateAttributeRequest() {
    }

    public CreateAttributeRequest(Long idAttribute, String nameAttribute, String dataType) {
        this.idAttribute = idAttribute;
        this.nameAttribute = nameAttribute;
        this.dataType = dataType;
    }

    public Long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Long idAttribute) {
        this.idAttribute = idAttribute;
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

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
