package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.Productrepository;
import com.example.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	Productrepository productrepository;

	@Override
	public Product addproduct(Product product) {
		// TODO Auto-generated method stub
		
		return productrepository.save(product);
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		
		Product product1=productrepository.getById(productId);
		
		if(product1!=null)
		{
			product1.setProductName(product1.getProductName());
			product1.setProductDet(product1.getProductDet());
			
		
		}
		return product1;
	}

	@Override
	public String delete(int productId) {
		// TODO Auto-generated method stub
		Product product2=productrepository.getById(productId);
		if(product2!=null)
		{
			productrepository.delete(product2);
		}
		return "product is deleted";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productrepository.findAll();	
		}
	
}
