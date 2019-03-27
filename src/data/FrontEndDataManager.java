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

	
	
	/*
	 * 
	 *  Setters and Getters
	 * 
	 * 
	 */
	
	public boolean isTradesByValueFilter() {
		return tradesByValueFilter;
	}

	public void setTradesByValueFilter(boolean tradesByValueFilter) {
		this.tradesByValueFilter = tradesByValueFilter;
	}

	public boolean isTradesByStringFilter() {
		return tradesByStringFilter;
	}

	public void setTradesByStringFilter(boolean tradesByStringFilter) {
		this.tradesByStringFilter = tradesByStringFilter;
	}

	public boolean isConsolidateTradeSpamming() {
		return consolidateTradeSpamming;
	}

	public void setConsolidateTradeSpamming(boolean consolidateTradeSpamming) {
		this.consolidateTradeSpamming = consolidateTradeSpamming;
	}

	public boolean isSendAllTradeRequestsToMobile() {
		return sendAllTradeRequestsToMobile;
	}

	public void setSendAllTradeRequestsToMobile(boolean sendAllTradeRequestsToMobile) {
		this.sendAllTradeRequestsToMobile = sendAllTradeRequestsToMobile;
	}

	public int getMinimumTradeValue() {
		return minimumTradeValue;
	}

	public void setMinimumTradeValue(int minimumTradeValue) {
		this.minimumTradeValue = minimumTradeValue;
	}

	public CurrencyEnum getSelectedFilterCurrency() {
		return selectedFilterCurrency;
	}

	public void setSelectedFilterCurrency(CurrencyEnum selectedFilterCurrency) {
		this.selectedFilterCurrency = selectedFilterCurrency;
	}

	public String getTradeStringValue() {
		return tradeStringValue;
	}

	public void setTradeStringValue(String tradeStringValue) {
		this.tradeStringValue = tradeStringValue;
	}

	
	 
	 

}
