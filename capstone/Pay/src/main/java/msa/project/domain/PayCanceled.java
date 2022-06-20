package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class PayCanceled extends AbstractEvent {

    private String id;
    private Float price;
    private String orderId;
    private Boolean sucessYn;
    private String productId;
    private Integer qty;
    private Boolean payStatus;

    public PayCanceled(Pay aggregate) {
        super(aggregate);
    }

    public PayCanceled() {
        super();
    }
    // keep

}
