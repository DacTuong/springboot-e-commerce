package springboot_ecommerce.springboot_ecommerce.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeGroupResponse {
    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("groups_name")
    private List<GroupItemResponse> groups;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<GroupItemResponse> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupItemResponse> groups) {
        this.groups = groups;
    }
}
