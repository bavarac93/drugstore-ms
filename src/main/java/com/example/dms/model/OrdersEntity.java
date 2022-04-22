package com.example.dms.model;


import javax.persistence.*;

@Entity
@Table (name = "orders")
public class OrdersEntity extends AuditSuperclass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private InventoryEntity inventoryEntity;
    private String instructionsToCustomer;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    public OrdersEntity() {
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
