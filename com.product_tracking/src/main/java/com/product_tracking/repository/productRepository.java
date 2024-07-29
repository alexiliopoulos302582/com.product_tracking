package com.product_tracking.repository;

import com.product_tracking.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE p.productCode  LIKE %?1% " +
            "OR p.description LIKE %?1%" +
            "OR p.serialNumber LIKE %?1% " +
            "OR p.location LIKE %?1%" +
            "OR p.owner LIKE %?1%" +
            "OR p.demo LIKE %?1%" +
            "OR p.comments LIKE %?1%")
    List<Product> findbysearch(String x);





}
