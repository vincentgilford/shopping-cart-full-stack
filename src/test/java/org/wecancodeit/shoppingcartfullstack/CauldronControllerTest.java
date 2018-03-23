package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.springframework.data.repository.CrudRepository;

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
		
		
		
		Potion savedPotion = underTest.getPotion(42L);
		
		
		assertThat(savedPotion, is(not(nullValue())));
		
		
	}
	
}
