package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupAttributeDetailResponse {
    @JsonProperty("id_group")
    private Long idGroup;

    @JsonProperty("name_group")
    private String nameGroup;

    @JsonProperty("id_category")
    private Long idCategory;

    @JsonProperty("name_category")
    private String nameCategory;

    public GroupAttributeDetailResponse() {
    }

    public GroupAttributeDetailResponse(Long idGroup, String nameGroup, Long idCategory, String nameCategory) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
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

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
