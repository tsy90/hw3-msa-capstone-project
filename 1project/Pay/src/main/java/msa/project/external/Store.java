package msa.project.external;

import java.util.Date;
import lombok.Data;

@Data
public class Store {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer qty;
    private String userId;
    private Float price;
    private String address;
    private Long payId;
    private String orderStatus;
    // keep

}
