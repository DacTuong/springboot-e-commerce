package springboot_ecommerce.springboot_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeriDTO {
    @JsonProperty("category_id")
    private Long categoryId;
    @JsonProperty("brand_id")
    private Long brandId;
    @JsonProperty("name_seri")
    private String nameSeri;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getNameSeri() {
        return nameSeri;
    }

    public void setNameSeri(String nameSeri) {
        this.nameSeri = nameSeri;
    }
}
