package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

public class MaintenanceControllerTest {

	@InjectMocks
	private MaintenanceController underTest;

	@Mock
	private CrudRepository<Potion, Long> potionRepo;

	@Mock
	private Potion incoming;

	@Mock
	private Potion persisted;

	@Test
	public void shouldCreatePotion() {
		MockitoAnnotations.initMocks(this);

		when(potionRepo.save(incoming)).thenReturn(persisted);

		Potion result = underTest.createPotion(incoming);

		assertThat(result, is(persisted));
	}

}
