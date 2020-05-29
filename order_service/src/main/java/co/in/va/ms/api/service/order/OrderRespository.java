package co.in.va.ms.api.service.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRespository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomer(int customer);
}