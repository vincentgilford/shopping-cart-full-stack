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
		
		
		Potion red = new Potion("Poultice","health","1", "/images/red-square.png",5.00);
		potionRepo.save(red);
		Potion blue = new Potion("Mana Regen","Mana","1", "/images/blue-magic.png",5.00);
		potionRepo.save(blue);
		Potion blueTwo = new Potion("Mana Regen 2","Mana","2", "/images/dark-rainbow.png",10.00);
		potionRepo.save(blueTwo);
		Potion redTwo = new Potion("Poultice Full","health","2", "/images/red-classic.png",10.00);
		potionRepo.save(redTwo);
		
		Potion green = new Potion("Luck of the Green","Luck","1", "/images/green-luck.png",8.00);
		potionRepo.save(green);
		Potion greenTwo = new Potion("Luck of the Black","Black","2", "/images/green-strength.png",16.00);
		potionRepo.save(greenTwo);
		
		cartRepo.save(cart);
		Long cartId = cart.getId();
		cart = cartRepo.findOne(cartId);
			
		
		
	}

}
