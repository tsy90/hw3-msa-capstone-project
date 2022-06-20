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
    private Boolean SucessYn;
    private String ProductId;
    private Integer qty;
    private Boolean PayStatus;
    // keep

}
