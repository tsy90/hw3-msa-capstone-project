package msa.project.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Store", url = "${api.url.Store}")
public interface StoreService {
    @RequestMapping(method = RequestMethod.POST, path = "/stores")
    public void approve(@RequestBody Store store);
    // keep

}
