package springboot_ecommerce.springboot_ecommerce.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeFromGroupDTO {
    @JsonProperty("id_group")
    private Long idGroup;

    @JsonProperty("group_attribute")
    private List<AttributeItemDTO> listAttribute;

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public List<AttributeItemDTO> getAttributes() {
        return listAttribute;
    }

    public void setAttributes(List<AttributeItemDTO> listAttribute) {
        this.listAttribute = listAttribute;
    }
}
