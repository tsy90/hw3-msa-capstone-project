package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class OrderCanceled extends AbstractEvent {

    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private Integer qty;
    private String userId;
    private Float price;
    private String address;
    private String payId;
    private String orderStatus;

    public OrderCanceled(Store aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
    // keep

}
