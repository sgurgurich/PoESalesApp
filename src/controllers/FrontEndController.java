package controllers;



import data.FrontEndDataManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FrontEndController {
	
	private FrontEndDataManager frontEndDataMgr;
	
	@FXML
	private CheckBox sendTradesToMobileCheckbox;
	
	@FXML
	private CheckBox priceFilterCheckbox;
	
	@FXML
	private CheckBox strFilterCheckbox;
	
	@FXML
	private CheckBox tradeSpamFilterCheckbox;

	public FrontEndController() {
		this.frontEndDataMgr = FrontEndDataManager.getInstance();
		
	}
	
	@FXML
    protected void handleSendTradesToMobileCBAction(ActionEvent event) {
		 frontEndDataMgr.setSendAllTradeRequestsToMobile(sendTradesToMobileCheckbox.isSelected());
	}
	
	@FXML
    protected void handlePriceFilterCBAction(ActionEvent event) {
		 frontEndDataMgr.setTradesByValueFilter(priceFilterCheckbox.isSelected());
	}
	
	@FXML
    protected void handleStrFilterCBAction(ActionEvent event) {
		 frontEndDataMgr.setTradesByStringFilter(strFilterCheckbox.isSelected());
	}
	
	@FXML
    protected void handleTradeSpamFilterCBAction(ActionEvent event) {
		 frontEndDataMgr.setConsolidateTradeSpamming(tradeSpamFilterCheckbox.isSelected());
	}
	
	
	
	
	
	
	
}
