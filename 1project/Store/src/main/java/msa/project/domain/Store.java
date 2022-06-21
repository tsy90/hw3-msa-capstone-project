package msa.project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msa.project.StoreApplication;
import msa.project.domain.OrderApproved;
import msa.project.domain.OrderCanceled;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long productId;

    private String productName;

    private Integer qty;

    private String userId;

    private Float price;

    private String address;

    private Long payId;

    private String orderStatus;

    @PostPersist
    public void onPostPersist() {
        OrderApproved orderApproved = new OrderApproved(this);
        orderApproved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public static void cancelApprove(PayCanceled payCanceled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCanceled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }
}
