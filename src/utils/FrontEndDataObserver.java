package utils;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonObject;

public class FrontEndDataObserver {
	
	private static FrontEndDataObserver instance;
	
	private Map<String, ObserverIF> subscriberMap;
	
	private JsonObject currentTradeRequestData;
	
	public static FrontEndDataObserver getInstance() {
		if (instance == null) {
			instance = new FrontEndDataObserver();
		}
		return instance;
	}
	
	private FrontEndDataObserver() {
		subscriberMap = new Hashtable<String, ObserverIF>();
		currentTradeRequestData = null;
	}
	
	public void subscribe(String topic, ObserverIF subscriber) {
		subscriberMap.put(topic, subscriber);
	}
	
	public void unsubscribe(String topic, ObserverIF subscriber) {
		subscriberMap.remove(topic,subscriber);	
	}

	public void notifyTradeRequestUpdate(JsonObject obj) {
		currentTradeRequestData = obj;
		
		Set<String> keys = subscriberMap.keySet();
        for(String key: keys){
            if (key.equals("tradeRequests")) {
            	subscriberMap.get(key).observerCallback();;
            }
        }
	}
	
	public JsonObject getCurrentTradeReqData() {
		return currentTradeRequestData;
	}
	
}
