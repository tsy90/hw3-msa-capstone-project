package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class PayCompleted extends AbstractEvent {

    private String id;
    private Float price;
    private String orderId;
    private Boolean sucessYn;
    private String productId;
    private Boolean payStatus;

    public PayCompleted(Pay aggregate) {
        super(aggregate);
    }

    public PayCompleted() {
        super();
    }
    // keep

}
