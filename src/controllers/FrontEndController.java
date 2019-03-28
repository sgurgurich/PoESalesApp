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
	protected void handleCheckboxActions(ActionEvent event) {
		if (event.getSource().equals(sendTradesToMobileCheckbox)) {
			frontEndDataMgr.setSendAllTradeRequestsToMobile(sendTradesToMobileCheckbox.isSelected());
		}
		else if (event.getSource().equals(priceFilterCheckbox)) {
			frontEndDataMgr.setTradesByValueFilter(priceFilterCheckbox.isSelected());
		}
		else if (event.getSource().equals(strFilterCheckbox)) {
			frontEndDataMgr.setTradesByStringFilter(strFilterCheckbox.isSelected());
		}
		else if (event.getSource().equals(tradeSpamFilterCheckbox)) {
			frontEndDataMgr.setConsolidateTradeSpamming(tradeSpamFilterCheckbox.isSelected());
		}
		else {
			// do nothing
		}
		
	}
	
	@FXML
    protected void handleButtonActions(ActionEvent event) {
		 if (event.getSource().equals(resetToDefaultsButton)) {
			 frontEndDataMgr.resetToDefaults();
		 }
		 else if (event.getSource().equals(removeRequestButton)) {
			 //TODO: add remove request feature
		 }
		 else {
			 // do nothing
		 }
	}
	
	@FXML
	protected void handleTextFieldActions(ActionEvent event) {
		 if (event.getSource().equals(filterPriceValueText)) {
			 //TODO: add filter price text functionality
		 }
		 else if (event.getSource().equals(filterStringText)) {
			//TODO: add filter String text functionality
		 }
		 else {
			 // do nothing
		 }
	}
	
	@FXML
	protected void handleComboBoxActions(ActionEvent event) {
		//TODO: Handle combo box selection
	}
	
	private void populateCurrencyOptions() {
		for (CurrencyEnum curr : CurrencyEnum.values()) {
			if (curr != CurrencyEnum.INVALID_CURRENCY) {
				currencyFilterSelection.getItems().add(curr.getApiString());
			}
		}
	}


	
	
	
	
	
	
	
}
