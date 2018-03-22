package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.Collection;

import org.junit.Test;

public class CauldronControllerTest {

	@Test
	public void shouldRetrivePotions() {
		CauldronController underTest = new CauldronController();
		
		Collection<Potion> result = underTest.getPotions();
		
		assertThat(result, hasSize(greaterThan(0)));
		
				
	}
	
}
