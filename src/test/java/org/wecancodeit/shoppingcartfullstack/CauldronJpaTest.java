package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CauldronJpaTest {
	
	@Resource
	private PotionRepository potionRepo; 
	
	
	
	@Test
	public void shouldInitializePotionRepository() {	
		
	}
	
	@Test
	public void shouldFindByNameForPotion() {
		Potion red = new Potion("Red"); 
		potionRepo.save(red); 
		Potion testFind = potionRepo.findByItemName("Red"); 
		
		assertThat(testFind, is(red));
		
	}
	
	
	
	}
