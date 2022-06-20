package msa.project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
    private String id;

    private Float price;

    private String orderId;

    private Boolean sucessYn;

    private String productId;

    private Integer qty;

    private String payId;

    private String payStatus;

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

    public static PayRepository repository() {
        PayRepository payRepository = PayApplication.applicationContext.getBean(
            PayRepository.class
        );
        return payRepository;
    }

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
