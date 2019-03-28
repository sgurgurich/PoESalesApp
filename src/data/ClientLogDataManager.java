package data;

import org.json.simple.JSONObject;

import utils.SalesDataPacker;
import sockets.SocketManager;

public class ClientLogDataManager {
	
	private String lastLine;
	private String prevVersion;
	private boolean isFirstRead;
	private SalesDataPacker dataPacker;

	
	public ClientLogDataManager(){
		this.lastLine = "";
		this.prevVersion = "";
		this.isFirstRead = true;
		this.dataPacker = new SalesDataPacker();
	}
	
	public void updateLastLine(String line) {
		
		// used to set the first iteration
		if (isFirstRead) {
			lastLine = line;
			isFirstRead = false;
		}
		
		if (!(line.equals(prevVersion))) {
			prevVersion = lastLine;
			lastLine = line;
			System.out.println("Last line changed to: " + lastLine);
			
			if (lastLine.contains("Hi, I would like to buy")){
				parseSaleInfo(lastLine);
			}
		}
		
	}
	
	private String extractBuyerName(String line) {
		String[] firstSplit = line.split("@From "); //[trash, NAME+trash]
		String[] secondSplit = firstSplit[1].split(":"); //[NAME, trash]
		return secondSplit[0];
	}
	
	private void parseSaleInfo(String line) {
		String[] firstSplit  = line.split("your ");   //[trash, ITEM NAME listed for PRICE+trash]
		String buyerName = extractBuyerName(firstSplit[0]);
		String[] secondSplit = firstSplit[1].split(" listed for "); //[ITEM NAME, PRICE+trash]
		String itemName = secondSplit[0]; 
		String[] thirdSplit = secondSplit[1].split(" in"); //[PRICE, trash]
		String itemPrice = thirdSplit[0];
		
		System.out.println(buyerName);
		System.out.println(itemName);
		System.out.println(itemPrice);
		
		dataPacker.packAndSendSalesData(buyerName, itemName, itemPrice);
		
	}
	
}
