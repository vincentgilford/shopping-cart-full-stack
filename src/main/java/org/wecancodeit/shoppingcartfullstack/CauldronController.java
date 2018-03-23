package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CauldronController {

	@Resource
	private CrudRepository<Potion, Long> potionRepo;

	@RequestMapping(path = "/potions", method = RequestMethod.GET)
	public Iterable<Potion> findPotions() {

		return potionRepo.findAll();
	}

	@RequestMapping("/potions/{id}")
	public Potion findPotion(@PathVariable(name = "id") long id) {
		Potion chosenPotion = potionRepo.findOne(id);
		if (chosenPotion != null) {
			return chosenPotion;
		}
		throw new PotionNotFoundException();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class PotionNotFoundException extends RuntimeException {

	}

}
