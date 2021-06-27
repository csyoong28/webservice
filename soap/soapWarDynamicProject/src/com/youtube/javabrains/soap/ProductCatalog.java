package com.youtube.javabrains.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.youtube.javabrains.soap.business.ProductServiceImpl;
import com.youtube.javabrains.soap.model.Product;


//name attribute, is used to set the portType name. others name also can be used to set the respective wsdl element name
//changing serviceName will change the WSDL URL
//namespace is like package in java, so by default is taking the package name and reverse it
@WebService(name="TestMartCatalog", portName="TestMartCatalogPort", serviceName="TestMartCatalogService",
		targetNamespace="http://www.testmart.com")
public class ProductCatalog {
	
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	//action attribute is to give name to the action
	//exclude is tell whether to exclude this method from being published as web service
	@WebMethod(exclude=true, action="fetch_categories", operationName="fetch_categories_op")		//this @WebMethod is optional
	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("books");
		categories.add("music");
		categories.add("movie");
		return categories;
	}
	
	//move the business logic to business layer
	@WebMethod
	public List<String> getProductCategories2() {
		return productServiceImpl.getProductCategories();
	}
	
	@WebMethod
	public List<String> getProducts(String category) {
		return productServiceImpl.getProducts(category);
	}
	
	@WebMethod
	public Boolean addProduct(String category, String product) {
		return productServiceImpl.addProduct(category, product);
	}
	
	@WebMethod
	public List<Product> getProductsV2(String category) {
		return productServiceImpl.getProductsV2(category);
	}
	
	
}
