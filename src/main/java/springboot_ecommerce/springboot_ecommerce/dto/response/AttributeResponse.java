package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeResponse {
    @JsonProperty("id_attribute")
    private Long idAttribute;

    @JsonProperty("name_attribute")
    private String nameAttribute;

    @JsonProperty("input_type")
    private String inputType;

    @JsonProperty("id_storage")
    private Long idStorage;

    @JsonProperty("is_filterable")
    private Long isFilterable;

    @JsonProperty("is_variant")
    private Long isVariant;

    public AttributeResponse() {
    }

    public AttributeResponse(
            Long idAttribute,
            String nameAttribute,
            String inputType,
            Long idStorage,
            Long isFilterable,
            Long isVariant) {

        this.idAttribute = idAttribute;
        this.nameAttribute = nameAttribute;
        this.inputType = inputType;
        this.idStorage = idStorage;
        this.isFilterable = isFilterable;
        this.isVariant = isVariant;
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

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Long getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(Long idStorage) {
        this.idStorage = idStorage;
    }

    public Long getIsFilterable() {
        return isFilterable;
    }

    public void setIsFilterable(Long isFilterable) {
        this.isFilterable = isFilterable;
    }

    public Long getIsVariant() {
        return isVariant;
    }

    public void setIsVariant(Long isVariant) {
        this.isVariant = isVariant;
    }
}
