package springboot_ecommerce.springboot_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupItemAttrDTO {
    @JsonProperty("id_group")
    private Long idGroup;

    @JsonProperty("name_group")
    private String nameGroup;

    public GroupItemAttrDTO(Long idGroup, String nameGroup) {
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
