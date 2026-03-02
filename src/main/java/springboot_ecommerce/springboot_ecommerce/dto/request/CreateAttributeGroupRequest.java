package springboot_ecommerce.springboot_ecommerce.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAttributeGroupRequest {

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("groups_name")
    private List<CreateGroupItemRequest> groups;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<CreateGroupItemRequest> getGroups() {
        return groups;
    }

    public void setGroups(List<CreateGroupItemRequest> groups) {
        this.groups = groups;
    }
}
