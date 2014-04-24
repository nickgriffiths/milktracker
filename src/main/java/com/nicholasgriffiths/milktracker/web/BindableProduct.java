package com.nicholasgriffiths.milktracker.web;

import java.util.ArrayList;
import java.util.Collection;

import com.nicholasgriffiths.milktracker.core.Product;

/**
 * UI model representation of a Product.
 */
public class BindableProduct {
    private long id;
    private String name;
    private int basePrice;

    public BindableProduct() {
    }

    public BindableProduct(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.basePrice = product.getBasePrice();
    }

    public Product asProduct() {
        return new Product(id, name, basePrice);
    }

    public static Collection<BindableProduct> bindableProducts(Collection<Product> products) {
        Collection<BindableProduct> bindables = new ArrayList<BindableProduct>();
        for (Product product : products) {
            bindables.add(new BindableProduct(product));
        }
        return bindables;
    }
}
