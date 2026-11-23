package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeStorageResponse {
    @JsonProperty("storage_code")
    private String storageCode;

    @JsonProperty("storage_name")
    private String storageName;

    // Constructor không tham số
    public AttributeStorageResponse() {
    }

    // Constructor có tham số
    public AttributeStorageResponse(String storageCode, String storageName) {
        this.storageCode = storageCode;
        this.storageName = storageName;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String StorageName) {
        this.storageName = StorageName;
    }
}
