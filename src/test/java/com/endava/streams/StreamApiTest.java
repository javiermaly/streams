package com.endava.streams;

import com.endava.streams.repos.CustomerRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
public class StreamApiTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
    public void exercise1() {
        //testing data
        customerRepo.findAll().forEach(x -> log.info(x.toString()));
    }
/*
	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {

	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
	public void exercise3() {

	}

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
