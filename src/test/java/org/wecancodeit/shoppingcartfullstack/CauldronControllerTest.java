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

		Iterable<Potion> result = underTest.getPotions();

		assertThat(result, contains(any(Potion.class)));

	}

	@Test
	public void shouldRetrieveSinglePotion() {
		CauldronController underTest = new CauldronController();

		Potion savedPotion = underTest.getPotion(42L);

		assertThat(savedPotion, is(not(nullValue())));

	}

}
