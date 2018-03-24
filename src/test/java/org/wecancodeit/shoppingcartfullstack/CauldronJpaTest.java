package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
	
	@Test
	public void shouldFindByClassificationForPotion() {
		Potion red = new Potion("Red","health",2); 
		potionRepo.save(red); 
		Collection<Potion> testFind = potionRepo.findByClassification("health"); 
		
		
		assertThat(testFind, contains(red));
	}

	@Test
	public void shouldFindByClassificationWithTwoPotions() {
		Potion red = new Potion("Red","health",2); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health",1);
		potionRepo.save(blue);
		
	
		Collection<Potion> testFind = potionRepo.findByClassification("health"); 

		
		assertThat(testFind, containsInAnyOrder(red,blue));
	}
	
	
	
	@Test
	public void shouldFindByLevelForPotion() {
		Potion red = new Potion("Red","health",2); 
		potionRepo.save(red);
		Potion blue = new Potion("Super Red","health",1);
		potionRepo.save(blue);
		Potion green = new Potion("Red","mana",1);
		potionRepo.save(green);
		Collection<Potion> testFind = potionRepo.findbyLevel(1);
		
		
		assertThat(testFind, containsInAnyOrder(red,green));
		
	}
	
	
	
	}
