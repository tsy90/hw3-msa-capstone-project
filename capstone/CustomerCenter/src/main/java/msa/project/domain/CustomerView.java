package msa.project.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CustomerView_table")
@Data
public class CustomerView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String userId;
    private String orderStatus;
    private String deliveryStatus;
    private String orderId;
    private String deliverId;
    private Boolean payStatus;
    private String payId;
}
