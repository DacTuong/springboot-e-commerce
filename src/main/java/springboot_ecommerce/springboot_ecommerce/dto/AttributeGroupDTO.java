package springboot_ecommerce.springboot_ecommerce.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeGroupDTO {
    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("groups_name")
    private List<String> groupName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getGroupName() {
        return groupName;
    }

    public void setGroupName(List<String> groupName) {
        this.groupName = groupName;
    }
}
