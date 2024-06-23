package srs.customerservice.Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="BillingAccount")
public class BillingAccount {

//Fatura Hesabı

//⦁	Account Status
//⦁	Account Number
//⦁	Account Name
//⦁	Account Type


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Use GenerationType.AUTO for UUID
    @Column(name="id", columnDefinition = "BINARY(16)") // Define column type for UUID
    private UUID id;

    @Column(name="status")
    private boolean status;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer  customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private Address address;

    public BillingAccount(UUID id, boolean status, String accountNumber, String name, String type, Customer customer, Address address) {
        this.id = id;
        this.status = status;
        this.accountNumber = accountNumber;
        this.name = name;
        this.type = type;
        this.customer = customer;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
