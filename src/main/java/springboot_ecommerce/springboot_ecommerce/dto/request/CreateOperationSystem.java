package springboot_ecommerce.springboot_ecommerce.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOperationSystem {
    @JsonProperty("id_attribute")
    private Long idAttribute;
    @JsonProperty("operation_name")
    private List<String> operationName;

    // ✅ BẮT BUỘC phải có
    // public CreateOperationRequest() {
    // }

    // public CreateOperationRequest() {

    // this.nameAttribute = nameAttribute;
    // this.dataType = dataType;
    // }

    public Long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Long idAttribute) {
        this.idAttribute = idAttribute;
    }

    public List<String> getOperationName() {
        return operationName;
    }

    public void setOperationName(List<String> operationName) {
        this.operationName = operationName;
    }

}
