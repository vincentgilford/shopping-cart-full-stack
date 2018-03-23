package org.wecancodeit.shoppingcartfullstack;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CauldronController.class)
public class CauldronMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private CrudRepository<Potion, Long> potionRepo;

	@Test
	public void shouldRetrievePotions() throws Exception {

		mvc.perform(get("/potions")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveIndividualPotion() throws Exception {
		when(potionRepo.findOne(42L)).thenReturn(new Potion("Strength"));
		mvc.perform(get("/potions/42")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindPotionId() throws Exception {
		mvc.perform(get("/products/42")).andExpect(status().isNotFound());
	}
}
