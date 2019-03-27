package data;

import java.util.HashMap;
import java.util.Map;

import types.enums.CurrencyEnum;
import utils.CurrencyLookupUtility;

public class CurrencyDataManager {
	
	private Map<CurrencyEnum, Double> currencyMap;
	private CurrencyLookupUtility lookupUtil;
	
	public CurrencyDataManager(){
		this.currencyMap = new HashMap<CurrencyEnum, Double>();
		this.lookupUtil = new CurrencyLookupUtility();
	}
	
	public Map<CurrencyEnum, Double> getCurrencyData(){
		return this.currencyMap;
	}
	
	private void loadCurrencyData() {
		if (lookupUtil.connectToApi()) {
			//TODO: populate map based on currency data
		}
		else {
			//TODO: create a default list of estimated values and log
		}
		
	}

}
