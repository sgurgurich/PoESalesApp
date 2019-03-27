package data;

import types.enums.CurrencyEnum;

public class FrontEndDataManager {
	
	private static FrontEndDataManager instance;
	
	private boolean tradesByValueFilter;
	private boolean tradesByStringFilter;
	private boolean consolidateTradeSpamming;
	private boolean sendAllTradeRequestsToMobile;
	
	private int          minimumTradeValue;
	private CurrencyEnum selectedFilterCurrency;
	private String       tradeStringValue;

	public static FrontEndDataManager getInstance() {
		if (instance == null) {
			instance = new FrontEndDataManager();
		}
		return instance;
	}
	
	private FrontEndDataManager() {
		resetToDefaults();  //sets up the default values
	}
	
	public void resetToDefaults() {
		tradesByValueFilter = false;     
		tradesByStringFilter = false;
		consolidateTradeSpamming = true;
		sendAllTradeRequestsToMobile = true;
		minimumTradeValue = 1;
		selectedFilterCurrency = CurrencyEnum.INVALID_CURRENCY;
		tradeStringValue = "";
	}

}
