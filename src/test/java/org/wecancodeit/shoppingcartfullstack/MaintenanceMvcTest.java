package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
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

		mvc.perform(post("/potions").content(potionJson)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldCreatePotionAsExpected() throws Exception {
		when(potionRepo.save(any(Potion.class))).thenReturn(new Potion("Lycanthropy"));
		
		Potion potion = new Potion("Lycanthropy");
		String potionJson = jsonMapper.writeValueAsString(potion); 
		
		MockHttpServletRequestBuilder request = post("/potions").content(potionJson);
		mvc.perform(request).andExpect(jsonPath("@.name", is("Lycanthropy")));

	}
	
	

}
