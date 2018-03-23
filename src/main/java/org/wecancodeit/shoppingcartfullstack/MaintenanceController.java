package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {

	@Resource
	CrudRepository<Potion, Long> potionRepo; 
	
	
	@RequestMapping("/potions")
	public Potion createPotion(Potion incoming) {
		return 	potionRepo.save(incoming);
	}

}
