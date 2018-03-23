package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.shoppingcartfullstack.CauldronController.PotionNotFoundException;

public class CauldronControllerTest {

	@InjectMocks
	CauldronController underTest;

	@Mock
	private CrudRepository<Potion, Long> potionRepo;

	@Mock
	private Potion potion;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrivePotions() {
		when(potionRepo.findAll()).thenReturn(Collections.singleton(potion));

		Iterable<Potion> result = underTest.findPotions();

		assertThat(result, contains(any(Potion.class)));

	}

	@Test
	public void shouldRetrieveSinglePotion() {
		long id = 42L;
		when(potionRepo.findOne(id)).thenReturn(potion);

		Potion savedPotion = underTest.findPotion(id);

		assertThat(savedPotion, is(potion));

	}

	@Test(expected = PotionNotFoundException.class)
	public void shouldReturnIfRequestForPotionIsBad() {
		long invalidPotionId = 42L;
		underTest.findPotion(invalidPotionId);
	}

}
