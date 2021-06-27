package com.youtube.javabrains.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.youtube.javabrains.soap.business.ProductServiceImpl;
import com.youtube.javabrains.soap.model.Product;


@WebService(endpointInterface="com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface", 
portName="TestMartCatalogOriginalWayPort", serviceName="TestMartCatalogOriginalWayService")
public class ProductCatalogOriginalWay implements ProductCatalogOriginalWayInterface {
	
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	//action attribute is to give name to the action
	//exclude is tell whether to exclude this method from being published as web service
	/* (non-Javadoc)
	 * @see com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("books");
		categories.add("music");
		categories.add("movie");
		return categories;
	}
	
	//move the business logic to business layer
	/* (non-Javadoc)
	 * @see com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface#getProductCategories2()
	 */
	@Override
	
	public List<String> getProductCategories2() {
		return productServiceImpl.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface#getProducts(java.lang.String)
	 */
	@Override
	@WebMethod
	public List<String> getProducts(String category) {
		return productServiceImpl.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	@WebMethod
	public Boolean addProduct(String category, String product) {
		return productServiceImpl.addProduct(category, product);
	}
	
	/* (non-Javadoc)
	 * @see com.youtube.javabrains.soap.ProductCatalogOriginalWayInterface#getProductsV2(java.lang.String)
	 */
	@Override
	@WebMethod
	public List<Product> getProductsV2(String category) {
		return productServiceImpl.getProductsV2(category);
	}
	
	
}
