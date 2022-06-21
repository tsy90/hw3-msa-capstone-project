package msa.project.infra;

import java.util.List;
import msa.project.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerViewRepository
    extends CrudRepository<CustomerView, Long> {
    List<CustomerView> findByOrderId(String orderId);
    List<CustomerView> findByPayId(String payId);
    List<CustomerView> findByPayId(String payId);
    List<CustomerView> findByDeliverId(String deliverId);

    void deleteByOrderId(String orderId);
    // keep

}
