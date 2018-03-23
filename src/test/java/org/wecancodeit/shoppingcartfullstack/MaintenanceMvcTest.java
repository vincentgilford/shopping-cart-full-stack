package org.wecancodeit.shoppingcartfullstack;

import javax.annotation.Resource;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(MaintenanceController.class)
public class MaintenanceMvcTest {

	@Resource
	private MockMvc mvc;

	@Resource
	private ObjectMapper jsonMapper;

	@MockBean
	private CrudRepository<Potion, Long> potionRepo;

	@Test
	public void shouldCreatePotion() throws Exception {
		Potion potion = new Potion("Luck");
		String potionJson = jsonMapper.writeValueAsString(potion);

		mvc.perform(post("/products").content(potionJson)).andExpect(status().isOk());
	}

}
