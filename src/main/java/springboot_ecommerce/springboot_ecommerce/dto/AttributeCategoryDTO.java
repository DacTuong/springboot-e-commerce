package springboot_ecommerce.springboot_ecommerce.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeCategoryDTO {
    @JsonProperty("id_category")
    private Long idCategory;
    @JsonProperty("group_attributes")
    private List<AttributeFromGroupDTO> attributeGroup;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public List<AttributeFromGroupDTO> getAttributeGroup() {
        return attributeGroup;
    }

    public void setAttributeGroup(List<AttributeFromGroupDTO> attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

}
