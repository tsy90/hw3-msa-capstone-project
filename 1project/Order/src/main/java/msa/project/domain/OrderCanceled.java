package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String productName;
    private Float price;
    private String userId;
    private Integer qty;
    private Long productId;
    private String address;
    private String orderStatus;

    public OrderCanceled(Order aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
    // keep

}
