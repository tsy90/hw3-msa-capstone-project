package msa.project.domain;

import java.util.Date;
import lombok.Data;
import msa.project.domain.*;
import msa.project.infra.AbstractEvent;

@Data
public class OrderApproved extends AbstractEvent {

    private String id;
    private String OrderId;
    private String ProductId;
    private String ProductName;
    private Integer qty;
    private String UserId;
    private Float price;
    private String address;
    private String PayId;
    private String OrderStatus;
    // keep

}
