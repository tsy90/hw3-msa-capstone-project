package msa.project.infra;

import java.util.List;
import msa.project.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerViewRepository
    extends CrudRepository<CustomerView, Long> {
    List<CustomerView> findByOrderId(Long orderId);
    List<CustomerView> findByPayId(Long payId);
    List<CustomerView> findByDeliverId(Long deliverId);

    void deleteByOrderId(Long orderId);
    // keep

}
