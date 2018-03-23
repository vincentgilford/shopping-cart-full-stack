package org.wecancodeit.shoppingcartfullstack;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CauldronController {
	
	
	
	@RequestMapping("/potions")
	public Collection<Potion> getPotions() {
		
		return Collections.singleton(new Potion("Stuff"));
	}
	
	@RequestMapping("/potions/{id}")
	public Potion getIndividualPoitionArbitraryId(@PathVariable(name="id") long id) {
		return new Potion("test potion");
		
		
	}
	

}
