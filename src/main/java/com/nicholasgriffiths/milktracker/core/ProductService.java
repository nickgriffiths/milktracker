package com.nicholasgriffiths.milktracker.core;

import java.util.Collection;

public interface ProductService {
	
	Collection<Product> get();
	
	Product get(long id);
	
	void save(Product product);
	
	void delete (long id);
}
