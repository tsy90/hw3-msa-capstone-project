package msa.project.external;

import java.util.Date;
import lombok.Data;

@Data
public class Pay {

    private String id;
    private Float price;
    private String orderId;
    private Boolean sucessYn;
    private String productId;
    private Integer qty;
    private String payId;
    private String payStatus;
    // keep

}
