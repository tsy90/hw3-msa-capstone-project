package msa.project.infra;

import java.util.List;
import msa.project.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StoreViewRepository extends CrudRepository<StoreView, Long> {
    // keep

}
