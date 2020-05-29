package co.in.va.ms.api.service.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_order")
public class Order {
    @Id
    private int id;
    @Column(name = "customer")
    private int customer;
    @Column(name = "amount")
    private int amount;

    public Order() {

    }

    public Order(int id, int customer,  int amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

 
}