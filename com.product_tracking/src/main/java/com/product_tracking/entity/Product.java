package com.product_tracking.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;
    private String serialNumber;
    private String description;
    private String location;
    private String comments;
    private String owner;
    private String demo;
    private String reservedby;



    public Product() {    }

    public Product(String productCode, String serialNumber, String description, String location, String comments, String owner, String demo, String reservedby) {
        this.productCode = productCode;
        this.serialNumber = serialNumber;
        this.description = description;
        this.location = location;
        this.comments = comments;
        this.owner = owner;
        this.demo = demo;
        this.reservedby = reservedby;
    }
}
