package controllers;


import data.FrontEndDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import types.enums.CurrencyEnum;

public class FrontEndController{
	
	private FrontEndDataManager frontEndDataMgr;
	
	@FXML
	private CheckBox sendTradesToMobileCheckbox;
	
	@FXML
	private CheckBox priceFilterCheckbox;
	
	@FXML
	private CheckBox strFilterCheckbox;
	
	@FXML
	private CheckBox tradeSpamFilterCheckbox;
	
	@FXML
	private Button applyFiltersButton;
	
	@FXML
	private Button resetToDefaultsButton;
	
	@FXML
	private Button removeRequestButton;
	
	@FXML
	private TextField filterPriceValueText;
	
	@FXML
	private ComboBox<String> currencyFilterSelection;
	
	@FXML
	private TextField filterStringText;
	
	@FXML
	private TreeView<String> tradeRequestsTreeView;

	public FrontEndController() {
		this.frontEndDataMgr = FrontEndDataManager.getInstance();
	}
	
	public void initializeData() {
		populateCurrencyOptions();
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
	
	@FXML
    protected void handleRemoveRequestButtonAction(ActionEvent event) {
		 
	}
	
	@FXML
    protected void handleApplyFiltersButtonAction(ActionEvent event) {
		
	}
	
	@FXML
    protected void handleResetToDefaultsButtonAction(ActionEvent event) {
		//TODO: Add alert with ok and cancel options
		frontEndDataMgr.resetToDefaults();
	}
	
	private void populateCurrencyOptions() {
		for (CurrencyEnum curr : CurrencyEnum.values()) {
			if (curr != CurrencyEnum.INVALID_CURRENCY) {
				currencyFilterSelection.getItems().add(curr.getApiString());
			}
		}
	}


	
	
	
	
	
	
	
}
