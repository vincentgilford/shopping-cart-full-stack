package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class CauldronControllerTest {

	@Test
	public void shouldRetrivePotions() {
		CauldronController underTest = new CauldronController();
		
		Collection<Potion> result = underTest.getPotions();
		
		assertThat(result, hasSize(greaterThan(0)));
				
	}
	
	@Test 
	public void shouldRetrieveSinglePotion() {
		CauldronController underTest = new CauldronController();
		
		
		Potion potion = underTest.getPotion(42L);
		
		Potion expected = new Potion("Potion");
		
		assertThat(potion, is(underTest.getPotion(42L)));
		
		
	}
	
}
