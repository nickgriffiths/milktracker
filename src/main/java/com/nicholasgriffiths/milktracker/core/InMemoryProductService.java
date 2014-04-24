package com.nicholasgriffiths.milktracker.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryProductService implements ProductService {

	private static final long maxId = 999999999L;

	private final Map<Long, Product> products = new HashMap<Long, Product>() {
		private static final long serialVersionUID = -7856372901904987885L;
		// This is an instance initializer block. See
		// http://c2.com/cgi/wiki?DoubleBraceInitialization
		{
			put(1L, new Product(1L, "Semi-skimmed milk", 50));
			put(2L, new Product(2L, "Bread", 200));
		}
	};

	@Override
	public Collection<Product> get() {
		return products.values();
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}

	@Override
	public void save(Product product) {
		final long id = (long) (Math.random() * maxId);
		products.put(id, product);
	}

	@Override
	public void delete(long id) {
		products.remove(id);
	}

}
