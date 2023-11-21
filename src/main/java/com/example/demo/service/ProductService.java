package com.example.demo.service;
import java.util.List;
//import java.util.list;
import com.example.demo.entity.Product;

public interface ProductService {
	
	Product addproduct(Product product);
	Product updateProduct(int productId, Product product);
	String delete(int productId);
    List<Product> getAllProducts();

}