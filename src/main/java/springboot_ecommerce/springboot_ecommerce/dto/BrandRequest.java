package springboot_ecommerce.springboot_ecommerce.dto;

public class BrandRequest {
    private String name;
    private String slug_name;

    public String getName() {
        return name;
    }

    public String getSlug_name() {
        return slug_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug_name(String slug_name) {
        this.slug_name = slug_name;
    }
}
