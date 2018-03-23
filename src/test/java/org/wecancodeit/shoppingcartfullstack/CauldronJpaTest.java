package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CauldronJpaTest {
	
	@Resource
	private CrudRepository<Potion, Long> potionRepo; 
	
	
	@Test
	public void shouldInitializePotionRepository() {
		
		
	}
	
	
	}
