package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class OrderUpdated extends AbstractEvent {

    private Long id;
    private String productName;
    private Float price;
    private String userId;
    private Integer qty;
    private Long productId;
    private String address;
    private String orderStatus;

    public OrderUpdated(Order aggregate) {
        super(aggregate);
    }

    public OrderUpdated() {
        super();
    }
    // keep

}
