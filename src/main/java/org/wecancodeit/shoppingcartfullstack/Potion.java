package org.wecancodeit.shoppingcartfullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Potion {
	
	@Id
	@GeneratedValue
	private long id; 

	private String itemName;
	private String classification;

	private int level; 
	
	
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
	
	
	protected Potion(String itemName, String classification, int level) {
		this.itemName = itemName;
		this.classification = classification;
		this.level = level;
		
		
	}


	public int getLevel() {
		return level;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potion other = (Potion) obj;
		if (id != other.id)
			return false;
		return true;
	}  
	
}
