package UnitTests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import utils.CurrencyLookupUtility;

public class CurrencyLookupTests {

	@Test
	public void successfulConnectTest() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();
		assertTrue(clu.connectToApi());		
	}
	
	@Test
	public void unsuccessfulConnectTest() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();
		clu.setApiPath("false");
		assertFalse(clu.connectToApi());		
	}
	
	@Test
	public void statusGoodBelowRangeTest() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();		
		assertFalse(clu.verifyStatusGood(103));		
	}
	
	@Test
	public void statusGoodInRangeTest() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();		
		assertTrue(clu.verifyStatusGood(203));		
	}
	
	@Test
	public void statusAboveRangeTest() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();		
		assertFalse(clu.verifyStatusGood(403));		
	}
	
	@Test
	public void defaultValuesJson() {
		CurrencyLookupUtility clu = new CurrencyLookupUtility();		
		assertNotNull(clu.getDefaultCurrencyValuesJson());		
	}

}
