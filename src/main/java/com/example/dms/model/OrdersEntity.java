package com.example.dms.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "orders")
public class OrdersEntity extends AuditSuperclass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateOrdered;
    private String instructionsToCustomer;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private InventoryEntity inventoryEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerEntity customerEntity;

    public OrdersEntity() {
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstructionsToCustomer() {
        return instructionsToCustomer;
    }

    public void setInstructionsToCustomer(String instructionsToCustomer) {
        this.instructionsToCustomer = instructionsToCustomer;
    }

    public InventoryEntity getInventoryEntity() {
        return inventoryEntity;
    }

    public void setInventoryEntity(InventoryEntity inventoryEntity) {
        this.inventoryEntity = inventoryEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
