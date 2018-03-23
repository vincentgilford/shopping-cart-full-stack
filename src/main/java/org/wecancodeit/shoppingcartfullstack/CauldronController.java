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

	@Resource
	private CrudRepository<Potion, Long> potionRepo;

	@RequestMapping("/potions")
	public Iterable<Potion> findPotions() {

		return potionRepo.findAll();
	}

	@RequestMapping("/potions/{id}")
	public Potion findPotion(@PathVariable(name = "id") long id) {
		return potionRepo.findOne(id);
	}

	public class PotionNotFoundException extends RuntimeException {
		
	}
	
}
