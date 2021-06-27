package com.youtube.javabrains.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.youtube.javabrains.soap.model.Product;

//name attribute, is used to set the portType name. others name also can be used to set the respective wsdl element name
//changing serviceName will change the WSDL URL
//namespace is like package in java, so by default is taking the package name and reverse it
@WebService(name="TestMartCatalog", targetNamespace="http://www.testmart.com")
public interface ProductCatalogOriginalWayInterface {

	//action attribute is to give name to the action
	//exclude is tell whether to exclude this method from being published as web service
	@WebMethod(exclude=true, action="fetch_categories", operationName="fetch_categories_op")
	List<String> getProductCategories();

	//move the business logic to business layer
	@WebMethod
	List<String> getProductCategories2();
	
	@WebMethod
	List<String> getProducts(String category);
	
	@WebMethod
	Boolean addProduct(String category, String product);
	
	@WebMethod
	List<Product> getProductsV2(String category);

}