package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String ProductName;
    private Float Price;
    private String UserId;
    private Integer qty;
    private String ProductId;
    private String Address;
    private Boolean orderStatus;
}
