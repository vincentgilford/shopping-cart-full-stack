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
	public Iterable<Potion> getPotions() {

		return potionRepo.findAll();
	}

	@RequestMapping("/potions/{id}")
	public Potion getPotion(@PathVariable(name = "id") long id) {
		return new Potion("Confusion");
	}

}
