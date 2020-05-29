package co.in.va.ms.api.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customer")
public class CustomerController {

  @Autowired
  private CustomerRespository repository;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable int id) {
    return repository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

  @GetMapping(value = { "/age/{toAge}", "/age/{toAge}/{fromAge}" })
  public List<Integer> getCustomersIdByAge(@PathVariable Integer toAge, @PathVariable Optional<Integer> fromAge) {
    Integer fromAgeValue = fromAge.isPresent() ? fromAge.get() : Integer.valueOf(0);
    return repository.findByAgeSegemnt(toAge.intValue(), fromAgeValue.intValue()).stream()
        .map(customer -> customer.getId()).collect(Collectors.toList());
  }
}