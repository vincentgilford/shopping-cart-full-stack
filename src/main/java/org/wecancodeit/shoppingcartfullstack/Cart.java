package org.wecancodeit.shoppingcartfullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	
	@OneToMany(mappedBy = "cart")
	private List<Potion> potions;
	

	public Collection<Potion> getPotions() {
		return potions;
	}


	public long getId() {
		return id;
	}

	public Collection<Potion> placePotions(Potion...salves) {
		for(Potion salve : salves) {
			potions.add(salve);
		}
		return potions;
	}

	
	public Cart(Potion...potion) {
		this.potions = Arrays.asList(potion);
		
	}
	
	protected Cart() {}


	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
