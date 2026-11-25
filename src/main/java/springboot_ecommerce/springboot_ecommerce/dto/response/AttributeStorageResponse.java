package springboot_ecommerce.springboot_ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeStorageResponse {
    @JsonProperty("id_storage")
    private Long idStorage;

    @JsonProperty("storage_code")
    private String storageCode;

    @JsonProperty("storage_name")
    private String storageName;

    // Constructor không tham số
    public AttributeStorageResponse() {
    }

    // Constructor có tham số
    public AttributeStorageResponse(Long idStorage, String storageCode, String storageName) {
        this.idStorage = idStorage;
        this.storageCode = storageCode;
        this.storageName = storageName;
    }

    public Long getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(Long idStorage) {
        this.idStorage = idStorage;
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
