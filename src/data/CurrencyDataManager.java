package data;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import types.enums.CurrencyEnum;
import utils.CurrencyLookupUtility;

public class CurrencyDataManager {
	
	private boolean debug = false;
	private boolean internetConnection = true;
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
	
	public void loadCurrencyData() {
		
		JsonObject json;
		if (lookupUtil.connectToApi() && internetConnection) {
			json = lookupUtil.getApiJsonObj();
		} else {
			json = lookupUtil.getDefaultCurrencyValuesJson();
		}
		
		JsonArray lines = json.getAsJsonArray("lines");
		
		for (JsonElement e : lines) {
			JsonObject line = e.getAsJsonObject();
			String currencyTypeName = line.get("currencyTypeName").getAsString();
			Double chaosEquivalent = line.get("chaosEquivalent").getAsDouble();
			if (debug) {
				System.out.println(currencyTypeName + ": " + chaosEquivalent);
			}
			
			
			if(CurrencyEnum.fromString(currencyTypeName) != CurrencyEnum.INVALID_CURRENCY) {
				currencyMap.put(CurrencyEnum.fromString(currencyTypeName), chaosEquivalent);
				
			}	
		}
		if (debug) {
			for (Map.Entry<CurrencyEnum, Double> entry : currencyMap.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}		
	}
	
	public Double getValueForCurrency(String currency) {
		CurrencyEnum convertedToEnum = CurrencyEnum.fromString(currency);
		return currencyMap.containsKey(convertedToEnum) ? currencyMap.get(convertedToEnum) : 0;
	}
	
	public Double getValueForCurrency(CurrencyEnum currency) {
		return currencyMap.containsKey(currency) ? currencyMap.get(currency) : 0;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isInternetConnection() {
		return internetConnection;
	}

	public void setInternetConnection(boolean internetConnection) {
		this.internetConnection = internetConnection;
	}	

}
