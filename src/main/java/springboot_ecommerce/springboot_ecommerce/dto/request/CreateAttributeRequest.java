package springboot_ecommerce.springboot_ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAttributeRequest {

    @JsonProperty("name_attribute")
    private String nameAttribute;

    @JsonProperty("data_type")
    private String dataType;

    @JsonProperty("is_filter")
    private Long isFilter;

    // ✅ BẮT BUỘC phải có
    public CreateAttributeRequest() {
    }

    public CreateAttributeRequest(String nameAttribute, String dataType) {

        this.nameAttribute = nameAttribute;
        this.dataType = dataType;
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

    public Long getIsFilter() {
        return isFilter;
    }

    public void setIsFilter(Long isFilter) {
        this.isFilter = isFilter;
    }
}
