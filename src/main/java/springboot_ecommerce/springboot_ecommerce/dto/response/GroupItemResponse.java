package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupItemResponse {
    @JsonProperty("id_group")
    private Long idGroup;

    @JsonProperty("name_group")
    private String nameGroup;

    public GroupItemResponse() {
    }

    public GroupItemResponse(Long idGroup, String nameGroup) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}
