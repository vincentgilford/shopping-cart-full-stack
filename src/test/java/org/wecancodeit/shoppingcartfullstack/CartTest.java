package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CartTest {
	
	
	
	@Test
	public void cartShouldReturnTotal() {
		Cart cart = new Cart(); 
		
		cart.placePotions(new Potion("Red","health","2", 6.00));
		cart.placePotions(new Potion("Blue","mana","2", 6.00));
		cart.placePotions(new Potion("Red","health","1", 3.00));
	
		int quantity = cart.getQuantity();
		
		assertThat(quantity, is(3));
		
	
	}
	
	
}
