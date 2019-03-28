package data;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import types.enums.CurrencyEnum;
import utils.CurrencyLookupUtility;

public class CurrencyDataManager {
	
	private Map<CurrencyEnum, Double> currencyMap;
	private CurrencyLookupUtility lookupUtil;
	
	public CurrencyDataManager(){
		this.lookupUtil = new CurrencyLookupUtility();
		this.currencyMap = new HashMap<CurrencyEnum, Double>();
		loadCurrencyData();
	}
	
	public Map<CurrencyEnum, Double> getCurrencyData(){
		return this.currencyMap;
	}
	
	private void loadCurrencyData() {
		
		JsonObject json;
		if (lookupUtil.connectToApi()) {
			json = lookupUtil.getApiJsonObj();
		} else {
			json = lookupUtil.getDefaultCurrencyValuesJson();
		}
		
		JsonArray lines = json.getAsJsonArray("lines");
		
		for (JsonElement e : lines) {
			JsonObject line = e.getAsJsonObject();
			String currencyTypeName = line.get("currencyTypeName").getAsString();
			Double chaosEquivalent = line.get("chaosEquivalent").getAsDouble();
			System.out.println(currencyTypeName + ": " + chaosEquivalent);
			
//			if(CurrencyEnum.fromString(currencyTypeName) != CurrencyEnum.INVALID_CURRENCY) {
//				currencyMap.put(CurrencyEnum.fromString(currencyTypeName), chaosEquivalent);
//			}
//			
//			for (Map.Entry<CurrencyEnum, Double> entry : currencyMap.entrySet()) {
//				System.out.println(entry.getKey() + ":" + entry.getValue());
//			}
		}
		
		
	}

}
