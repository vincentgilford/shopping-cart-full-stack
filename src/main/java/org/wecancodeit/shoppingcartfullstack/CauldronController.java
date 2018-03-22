package org.wecancodeit.shoppingcartfullstack;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CauldronController {
	
	
	@RequestMapping("/potions")
	public Collection<Potion> getPotions() {
		
		return Collections.singleton(new Potion("Stuff"));
	}

}
