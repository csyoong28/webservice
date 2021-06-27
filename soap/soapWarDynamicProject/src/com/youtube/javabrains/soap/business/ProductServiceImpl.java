package com.youtube.javabrains.soap.business;

import java.util.ArrayList;
import java.util.List;

import com.youtube.javabrains.soap.model.Product;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();

	public ProductServiceImpl() {
		bookList.add("book1");
		bookList.add("book2");
		bookList.add("book3");
		musicList.add("music1");
		musicList.add("music2");
		musicList.add("music3");
		movieList.add("movie1");
		movieList.add("movie2");
		movieList.add("movie3");
	}

	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("book");
		categories.add("music");
		categories.add("movie");
		return categories;
	}

	// given category, return the products it has
	public List<String> getProducts(String category) {
		switch (category.toLowerCase()) {
		case "book":
			return bookList;
		case "music":
			return musicList;
		case "movie":
			return movieList;
		}
		return null;
	}

	public boolean addProduct(String category, String product) {
		switch (category.toLowerCase()) {
		case "book":
			bookList.add(product);
			break;
		case "music":
			musicList.add(product);
			break;
		case "movie":
			movieList.add(product);
			break;
		default:
			return false;
		}
		return true;
	}

	public List<Product> getProductsV2(String category) {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("java brain book", "11", 10));
		productList.add(new Product("java brain another book", "22", 50));
		return productList;
	}

}
