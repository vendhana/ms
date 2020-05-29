package co.in.va.ms.api.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.in.va.ms.api.service.order.connector.CustomerServiceProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderRespository repository;

  @Autowired
  private CustomerServiceProxy customerProxy;

  @GetMapping
  public List<Order> getAllOrders() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable int id) {
    return repository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

  @GetMapping("/customer/{id}")
  public List<Order> getOrdersByCustomerId(@PathVariable int id) {
    return repository.findByCustomer(id);
  }
  @HystrixCommand(fallbackMethod = "getDefaultOrders")
  @GetMapping(value = { "/customer/age/{toAge}", "/customer/age/{toAge}/{fromAge}" })
  public List<Order> getOrdersByCustomerAgeSegment(@PathVariable Integer toAge,
      @PathVariable Optional<Integer> fromAge) {
    List<Integer> customerIdList = null;
    if (fromAge.isPresent())
      customerIdList = customerProxy.getCustomersIdByAge(toAge, fromAge.get());
    else
      customerIdList = customerProxy.getCustomersIdByAge(toAge);
    List<Order> orderList = customerIdList.stream().map(id -> repository.findByCustomer(id))
        .flatMap(orderlist -> orderlist.stream()).collect(Collectors.toList());
    return orderList;
  }

  public List<Order> getDefaultOrders(@PathVariable Integer toAge,
  @PathVariable Optional<Integer> fromAge)  {
    return new ArrayList<Order>();
  }
}