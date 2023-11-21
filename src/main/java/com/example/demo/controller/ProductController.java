package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.Productrepository;
import com.example.demo.service.ProductService;

@Controller
public class ProductController{
	@Autowired
	ProductService productservice;
	@Autowired
	Productrepository productrepository;
	
	@PostMapping("/post")
	public Product addProduct(@RequestBody Product prod)
	
	{
		productservice.addproduct(prod);
		
		return prod;
		
	}
	@GetMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("listproduct",productservice.getAllProducts());
		return "index";
	}
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {
		//create model attribute to bind form data
		Product product=new Product();
		model.addAttribute("product", product);
		return "newproduct";
	}
	      
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product){
		//save product to database
		productservice.addproduct(product);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{productId}")
	public String showFormForUpdate(@PathVariable int productId,Model model ) {
		//get employee from the service
		Product product=productrepository.findById(productId);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("product", product);
		return "updateproduct";
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		//call delete employee method
		this.productrepository.deleteById(productId);
		return "redirect:/";
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product prod, @RequestHeader int productId)
	{
		productservice.updateProduct(productId, prod);
		return prod;
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestHeader int productId)
	{
		productservice.delete(productId);
	}
	
		
}
