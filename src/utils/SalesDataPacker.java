package utils;
import com.google.gson.JsonObject;

import sockets.SocketManager;

public class SalesDataPacker {
	
	private JsonObject salesDataMessage;
	
	
	public SalesDataPacker() {
		this.salesDataMessage = null;

	}
	
	private void generateHeader() {
		salesDataMessage.addProperty("type", "tradeAlert");
		salesDataMessage.addProperty("uniqueID", "sG27t8Af");   //TODO: replace with generated code
		salesDataMessage.addProperty("platform", "pcUser");
	}
	
	public void packAndSendSalesData(String buyerName, String itemName, String price) {
		this.salesDataMessage = new JsonObject();
		
		generateHeader();
		
		salesDataMessage = new JsonObject();
		salesDataMessage.addProperty("buyerName", buyerName);
		salesDataMessage.addProperty("itemName", itemName);
		salesDataMessage.addProperty("price", price);
		
		sendSalesDataMsg();
		
	}
	
	private void sendSalesDataMsg() {
		// check to see if there is a message
		if (salesDataMessage != null) {
			//SocketManager.getInstance().sendMessage(salesDataMessage.toString());
			FrontEndDataObserver.getInstance().notifyTradeRequestUpdate(salesDataMessage);
			clearMessage();
		}
	}
	
	private void clearMessage() {
		this.salesDataMessage = null;
	}
	
}
