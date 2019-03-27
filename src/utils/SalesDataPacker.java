package utils;
import org.json.simple.JSONObject;

import sockets.SocketManager;

public class SalesDataPacker {
	
	private JSONObject salesDataMsgHeader;
	private JSONObject salesDataMsgBody;
	private JSONObject salesDataMessage;
	
	
	public SalesDataPacker() {
		this.salesDataMsgHeader = new JSONObject();
		this.salesDataMsgBody   = null;
		this.salesDataMessage   = null; 
		
		generateHeader();
	}
	
	@SuppressWarnings("unchecked")
	private void generateHeader() {
		salesDataMsgHeader.put("type", "tradeAlert");
		salesDataMsgHeader.put("uniqueID", "sG27t8Af");   //TODO: replace with generated code
		salesDataMsgHeader.put("platform", "pcUser");
	}
	
	@SuppressWarnings("unchecked")
	public void packAndSendSalesData(String buyerName, String itemName, String price) {
		salesDataMsgBody = new JSONObject();
		salesDataMsgBody.put("buyerName", buyerName);
		salesDataMsgBody.put("itemName", itemName);
		salesDataMsgBody.put("price", price);
		
		// attach the header and body into the main message
		salesDataMessage = new JSONObject();
		salesDataMessage.put("header", salesDataMsgHeader);
		salesDataMessage.put("body", salesDataMsgBody);
		
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
		this.salesDataMsgBody   = null;
		this.salesDataMessage   = null; 
	}
	
}
