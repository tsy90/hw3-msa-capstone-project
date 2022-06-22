package msa.project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import msa.project.PayApplication;
import msa.project.domain.PayCanceled;
import msa.project.domain.PayCompleted;

@Entity
@Table(name = "Pay_table")
@Data
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PostPersist
    public void onPostPersist() {
        PayCompleted payCompleted = new PayCompleted(this);
        payCompleted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        msa.project.external.Store store = new msa.project.external.Store();
        // mappings goes here
        PayApplication.applicationContext
            .getBean(msa.project.external.StoreService.class)
            .approve(store);
    }

    @PostUpdate
    public void onPostUpdate() {
        PayCanceled payCanceled = new PayCanceled(this);
        payCanceled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        PayCanceled payCanceled = new PayCanceled(this);
        BeanUtils.copyProperties(this, payCanceled);
        payCanceled.publishAfterCommit();
    }
    
    // public static PayRepository repository() {
    //     PayRepository payRepository = PayApplication.applicationContext.getBean(
    //         PayRepository.class
    //     );
    //     return payRepository;
    // }

    
    
    public static void cancelPay(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);


         });
        */


    }
}
