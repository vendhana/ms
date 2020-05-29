package co.in.va.ms.api.service.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRespository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM tbl_customer c WHERE c.age <=?1 AND c.age >= ?2")
    List<Customer> findByAgeSegemnt(int toAge, int fromAge);
}