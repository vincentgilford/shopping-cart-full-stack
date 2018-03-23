package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {

	@Resource
	CrudRepository<Potion, Long> potionRepo;

	@RequestMapping(path = "/potions",method = RequestMethod.POST )
	public Potion createPotion(Potion incoming) {
		return potionRepo.save(incoming);
	}

}
