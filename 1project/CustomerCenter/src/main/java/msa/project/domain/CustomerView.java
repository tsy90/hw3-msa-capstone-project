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
    private Long id;

    private String userId;
    private String orderStatus;
    private String deliveryStatus;
    private Long orderId;
    private Long deliverId;
    private String payStatus;
    private Long payId;
}
