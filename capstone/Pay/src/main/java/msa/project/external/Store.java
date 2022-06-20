package msa.project.external;

import java.util.Date;
import lombok.Data;

@Data
public class Store {

    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private Integer qty;
    private String userId;
    private Float price;
    private String address;
    private String payId;
    private String orderStatus;
    // keep

}
