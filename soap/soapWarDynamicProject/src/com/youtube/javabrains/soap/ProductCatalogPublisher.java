package com.youtube.javabrains.soap;

import javax.xml.ws.Endpoint;

public class ProductCatalogPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/productCatalog", new ShopInfo());
		//then can access the wsdl at http://localhost:1234/productCatalog?wsdl
	}
}
