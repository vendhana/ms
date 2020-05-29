package co.in.va.ms.api.service.order.connector;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceProxy {

    @GetMapping(value =  "/customer/age/{toAge}")
    public List<Integer> getCustomersIdByAge(@PathVariable Integer toAge);

    @GetMapping(value = "/customer/age/{toAge}/{fromAge}")
    public List<Integer> getCustomersIdByAge(@PathVariable Integer toAge, @PathVariable Integer fromAge);
}
