package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String address;
    private String userId;
    private Long payId;
    private Float price;
    private String productName;
    private String deliveryStatus;
}
