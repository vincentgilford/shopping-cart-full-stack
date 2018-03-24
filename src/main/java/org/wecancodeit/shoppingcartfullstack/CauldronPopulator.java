package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;

public class CauldronPopulator implements CommandLineRunner {

	@Resource
	private PotionRepository potionRepo;
	
	@Resource
	private CartRepository cartRepo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Cart cart = new Cart(); 
		
		
		
	}

}
