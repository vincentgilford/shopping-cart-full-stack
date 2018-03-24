/**
 * 
 */
package org.wecancodeit.shoppingcartfullstack;

import org.springframework.data.repository.CrudRepository;

/**
 * @author WeCanCodeIT
 *
 */

public interface PotionRepository extends CrudRepository<Potion, Long> {
	Potion findByItemName(String itemName);
}
