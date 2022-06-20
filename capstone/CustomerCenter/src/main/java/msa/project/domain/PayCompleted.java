package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.infra.AbstractEvent;

@Data
public class PayCompleted extends AbstractEvent {

    private String id;
    private Float price;
    private String orderId;
    private Boolean SucessYn;
    private String ProductId;
    private Boolean PayStatus;
}
