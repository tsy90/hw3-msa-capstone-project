package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
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

    public PayCanceled(Pay aggregate) {
        super(aggregate);
    }

    public PayCanceled() {
        super();
    }
    // keep

}
