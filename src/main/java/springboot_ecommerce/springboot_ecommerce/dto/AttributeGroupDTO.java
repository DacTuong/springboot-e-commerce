package springboot_ecommerce.springboot_ecommerce.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeGroupDTO {

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("groups_name")
    private List<GroupItemAttrDTO> groups;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<GroupItemAttrDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupItemAttrDTO> groups) {
        this.groups = groups;
    }
}
