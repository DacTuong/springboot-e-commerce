package springboot_ecommerce.springboot_ecommerce.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeStorageRequest {

    @JsonProperty("storage_code")
    private String storageCode;

    @JsonProperty("storage_name")
    private String storageName;

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStoragename(String storageName) {
        this.storageName = storageName;
    }
}
