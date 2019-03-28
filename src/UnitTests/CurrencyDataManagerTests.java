package UnitTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data.CurrencyDataManager;
import types.enums.CurrencyEnum;

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
	
	@Test
	public void getCurrencyValueFromAPIString() {
		CurrencyDataManager cdm = new CurrencyDataManager();
		cdm.setInternetConnection(false);
		cdm.loadCurrencyData();
		double price = cdm.getValueForCurrency("Gemcutter's Prism");
		
		assertTrue(price == 0.97);
	}
	
	@Test
	public void getCurrencyValueFromTradeString() {
		CurrencyDataManager cdm = new CurrencyDataManager();		
		cdm.setInternetConnection(false);
		cdm.loadCurrencyData();
		double price = cdm.getValueForCurrency("gcp");
		assertTrue(price == 0.97);
	}
	
	@Test
	public void getCurrencyValueFromInvalid() {
		CurrencyDataManager cdm = new CurrencyDataManager();
		double price = cdm.getValueForCurrency(CurrencyEnum.INVALID_CURRENCY);
		
		assertTrue(price == 0);
	}
	
	@Test
	public void getCurrencyValueFromGarbage() {
		CurrencyDataManager cdm = new CurrencyDataManager();
		double price = cdm.getValueForCurrency("garbage string");
		
		assertTrue(price == 0);
	}
}

