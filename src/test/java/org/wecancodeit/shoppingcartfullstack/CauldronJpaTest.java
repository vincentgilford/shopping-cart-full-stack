package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CauldronJpaTest {
	
	@Resource
	private TestEntityManager testEntity; 
	
	
	@Resource
	private PotionRepository potionRepo; 
	
	@Resource
	private CartRepository cartRepo;
	
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
	
	@Test
	public void shouldFindByClassificationForPotion() {
		Potion red = new Potion("Red","health","2"); 
		potionRepo.save(red); 
		Collection<Potion> testFind = potionRepo.findByClassification("health"); 
		
		
		assertThat(testFind, contains(red));
	}

	@Test
	public void shouldFindByClassificationWithTwoPotions() {
		Potion red = new Potion("Red","health","1"); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1");
		potionRepo.save(blue);
		
	
		Collection<Potion> testFind = potionRepo.findByClassification("health"); 

		
		assertThat(testFind, containsInAnyOrder(red,blue));
	}
	
	
	
	@Test
	public void shouldFindByLevelForPotion() {
		Potion red = new Potion("Red","health","2"); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1");
		potionRepo.save(blue);
		Potion green = new Potion("Blue","mana","1");
		potionRepo.save(green);
		Collection<Potion> testFind = potionRepo.findByLevel("1");
		

		assertThat(testFind, containsInAnyOrder(blue,green));
	
	}
	
	
	@Test
	public void shouldSaveAndLoadPotionToCart() {
		Potion red = new Potion("Red","health","2"); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1");
		potionRepo.save(blue);
		Potion green = new Potion("Blue","mana","1");
		potionRepo.save(green);
		
		Cart cart = new Cart();
		
		cartRepo.save(cart);
		
		
		testEntity.flush();
		testEntity.clear();
		
		long cartId = cart.getId();
		cart = cartRepo.findOne(cartId);
		cart.placePotions(red,blue,green);
		Collection<Potion> testPotions = cart.getPotions();
		assertThat(testPotions, containsInAnyOrder(red,blue,green));
	}
	
	@Test
	public void shouldFindByPotionPrice() {
		Potion red = new Potion("Red","health","2", 3.00); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1", 6.00);
		potionRepo.save(blue);
		Potion green = new Potion("Blue","mana","1",3.00);
		potionRepo.save(green);

		testEntity.flush();
		testEntity.clear();
		
		Collection<Potion> testPotions = potionRepo.findByPotionPrice(3.00); 
		
		assertThat(testPotions.size(), is(2));
		
	}
	
	@Test
	public void shouldFindByPotionPriceSpecficItems() {
		Potion red = new Potion("Red","health","2", 3.00); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1", 6.00);
		potionRepo.save(blue);
		Potion green = new Potion("Blue","mana","1",3.00);
		potionRepo.save(green);

		testEntity.flush();
		testEntity.clear();		
		
		Collection<Potion> testPotions = potionRepo.findByPotionPrice(3.00);
		
		assertThat(testPotions, containsInAnyOrder(red,green));
	}
	
	@Test 
	public void shouldGetQuantityFromPotionCollectionFromCart() {
		Potion red = new Potion("Red","health","2"); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health","1");
		potionRepo.save(blue);
		Potion green = new Potion("Blue","mana","1");
		potionRepo.save(green);
		
		Cart cart = new Cart();
		
		cartRepo.save(cart);
		
		
		testEntity.flush();
		testEntity.clear();
		
		long cartId = cart.getId();
		cart = cartRepo.findOne(cartId);
		cart.placePotions(red,blue,green);
		int testQuantity = cart.getQuantity();
		
		assertThat(testQuantity, is(3));
		
	}
	
	
	
	}
