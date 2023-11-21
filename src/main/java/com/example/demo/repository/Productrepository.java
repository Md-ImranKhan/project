package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public interface Productrepository extends JpaRepository<Product,Integer>{
	
	@Query(value="Select * from Product where Product_id=?",nativeQuery=true)
	Product findById(int id);
}
