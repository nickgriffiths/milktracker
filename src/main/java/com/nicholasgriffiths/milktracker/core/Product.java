package com.nicholasgriffiths.milktracker.core;

public class Product {
	private long id;
	private String name;
	private int basePrice;
	
	public Product(long id, String name, int basePrice) {
		super();
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return The basic price, in pence.
	 */
	public int getBasePrice() {
		return basePrice;
	}
	
	/**
	 * @param basePrice The basic price, in pence.
	 */
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
}
