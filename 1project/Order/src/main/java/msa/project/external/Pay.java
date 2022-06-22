package msa.project.external;

import java.util.Date;
import lombok.Data;

@Data
public class Pay {

    private Long id;
    private String payStatus;
    private Float pirce;
    private Long orderId;
    private Boolean successYn;
    private Long productId;
    private String productName;
    // keep

}
