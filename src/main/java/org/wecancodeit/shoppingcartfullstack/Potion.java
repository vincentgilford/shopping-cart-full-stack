package org.wecancodeit.shoppingcartfullstack;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Potion {
	
	@Id
	private long id; 

	private String itemName;
	private String classification; 
	
	
	public String getClassification() {
		return classification;
	}


	public long getId() {
		return id;
	}


	public String getItemName() {
		return itemName;
	}

	public Potion(String itemName) {
		this.itemName = itemName;
		// TODO Auto-generated constructor stub
	}
	
	
	protected Potion(String itemName, String classification) {
		this.itemName = itemName;
		this.classification = classification;
		
		
	}  
	
}
