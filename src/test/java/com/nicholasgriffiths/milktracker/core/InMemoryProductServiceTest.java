package com.nicholasgriffiths.milktracker.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class InMemoryProductServiceTest {

    private InMemoryProductService cut;

    @Before
    public void setUp() throws Exception {
        cut = new InMemoryProductService();
    }

    @Test
    public void testGet() {
        // When
        Collection<Product> products = cut.get();

        // Then
        assertNotNull(products);
    }

    @Test
    public void testGetOneProduct() {
        // Given
        Collection<Product> products = cut.get();
        assertTrue("Cannot run test without any products", products.size() > 0);
        long id = products.iterator().next().getId();

        // When
        Product result = cut.get(id);

        // Then
        assertNotNull(result);
    }

    @Test
    public void testDelete() {
        // Given
        Collection<Product> products = cut.get();
        int size = products.size();
        assertTrue("Cannot run test without any products", size > 0);
        long id = products.iterator().next().getId();

        // When
        cut.delete(id);

        // Then
        assertEquals("Should be one less product than there was before", size - 1, cut.get().size());
    }
}
