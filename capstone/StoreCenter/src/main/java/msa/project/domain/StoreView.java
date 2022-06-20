package msa.project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreView_table")
@Data
public class StoreView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String userId;
    private String orderId;
    private Boolean orderStatus;
    private String payId;
    private Boolean payStatus;
    private String deliveryId;
    private Boolean deliveryStatus;
}
