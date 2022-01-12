package com.endava.streams;

import com.endava.streams.models.Order;
import com.endava.streams.models.Product;
import com.endava.streams.repos.CustomerRepo;
import com.endava.streams.repos.OrderRepo;
import com.endava.streams.repos.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
public class StreamApiTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
    public void exercise1() {
        List<Product> products = productRepo.findAll().stream().filter(product -> product.getCategory().equalsIgnoreCase("Books")).filter(product -> product.getPrice() > 100).collect(Collectors.toList());
        products.forEach(product -> log.info(product.toString()));
    }

    @Test
    @DisplayName("Obtain a list of order with product category = \"Baby\"")
    public void exercise2() {
        List<Order> orders = orderRepo.findAll().stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equalsIgnoreCase("baby"))).collect(Collectors.toList());
        orders.forEach(order -> log.info(order.toString()));
    }

    @Test
    @DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
    public void exercise3() {
        List<Product> products = productRepo.findAll().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("toys"))
                .map(product -> product.withPrice((double) Math.round(product.getPrice() * 0.9)))
                .collect(Collectors.toList());
        products.forEach(product -> log.info(product.toString()));

    }
/*
	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {

	}

	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {

	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {

	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {

	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {

	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {

	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {

	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {

	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {

	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {

	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {

	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {

	}
*/
}
