/**
 * 
 */
package org.wecancodeit.shoppingcartfullstack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

/**
 * @author WeCanCodeIT
 *
 */

public interface PotionRepository extends CrudRepository<Potion, Long> {
	Potion findByItemName(String itemName);

	Collection<Potion> findByClassification(String classification);

	Collection<Potion> findByLevel(String level);

	Collection<Potion> findByPotionPrice(double potionPrice);
	
	
}
