package UnitTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data.CurrencyDataManager;

public class CurrencyDataManagerTests {
	
	@Test
	public void stub() {
		CurrencyDataManager cdm = new CurrencyDataManager();
	}
	
	
	@Test
	public void getCurrencyDataMapNull() {
		CurrencyDataManager cdm = new CurrencyDataManager();
		assertNotNull(cdm.getCurrencyData());
	}
	
	@Test
	public void getCurrencyDataMapSize() {
		CurrencyDataManager cdm = new CurrencyDataManager();
		assertTrue(cdm.getCurrencyData().size() > 0);
	}
}
