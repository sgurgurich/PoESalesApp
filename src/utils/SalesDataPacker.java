package utils;
import org.json.simple.JSONObject;

import sockets.SocketManager;

public class SalesDataPacker {
	
	private JSONObject salesDataMessage;
	
	
	public SalesDataPacker() {
		this.salesDataMessage = null;

	}
	
	@SuppressWarnings("unchecked")
	private void generateHeader() {
		salesDataMessage.put("type", "tradeAlert");
		salesDataMessage.put("uniqueID", "sG27t8Af");   //TODO: replace with generated code
		salesDataMessage.put("platform", "pcUser");
	}
	
	@SuppressWarnings("unchecked")
	public void packAndSendSalesData(String buyerName, String itemName, String price) {
		this.salesDataMessage = new JSONObject();
		
		generateHeader();
		
		salesDataMessage = new JSONObject();
		salesDataMessage.put("buyerName", buyerName);
		salesDataMessage.put("itemName", itemName);
		salesDataMessage.put("price", price);
		
		sendSalesDataMsg();
		
	}
	
	private void sendSalesDataMsg() {
		// check to see if there is a message
		if (salesDataMessage != null) {
			SocketManager.getInstance().sendMessage(salesDataMessage.toJSONString());
			clearMessage();
		}
	}
	
	private void clearMessage() {
		this.salesDataMessage = null;
	}
	
}
