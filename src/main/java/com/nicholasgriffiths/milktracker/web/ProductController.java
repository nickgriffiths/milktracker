package com.nicholasgriffiths.milktracker.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nicholasgriffiths.milktracker.core.Product;
import com.nicholasgriffiths.milktracker.core.ProductService;

/**
 * Responsible for handling HTTP requests and for translating between domain model and UI model.
 * 
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<BindableProduct> get() {
        return BindableProduct.bindableProducts(productService.get());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String get(Model model) {
        return get(null, model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        Product product = productService.get(id);
        if (product == null) {
            model.addAttribute(new BindableProduct());
        } else {
            model.addAttribute(new BindableProduct(product));
        }
        return "product"; // view name
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteViaGet(@PathVariable Long id) {
        return delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:../../employees";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(BindableProduct bindableProduct) {
        productService.save(bindableProduct.asProduct());
        return "redirect:employees";
    }
}
