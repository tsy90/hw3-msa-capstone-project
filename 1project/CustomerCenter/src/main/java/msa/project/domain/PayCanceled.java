package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.infra.AbstractEvent;

@Data
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String payStatus;
    private Float pirce;
    private Long orderId;
    private Boolean successYn;
    private Long productId;
    private String productName;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPayStatus() {
        return payStatus;
    }
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public Float getPirce() {
        return pirce;
    }
    public void setPirce(Float pirce) {
        this.pirce = pirce;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Boolean getSuccessYn() {
        return successYn;
    }
    public void setSuccessYn(Boolean successYn) {
        this.successYn = successYn;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
