package controllers;

import com.google.gson.JsonObject;

import data.FrontEndDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import types.enums.CurrencyEnum;
import utils.FrontEndDataObserver;
import utils.ObserverIF;

public class FrontEndController implements ObserverIF{
	
	private FrontEndDataManager frontEndDataMgr;

	private TreeItem<String> mainRoot;

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
		createTreeItems();
		subscribe();
	}

	public void addTradeRequestToTree(JsonObject obj) {
		
		String itemName  = obj.get("itemName").getAsString();
		String buyerName = obj.get("buyerName").getAsString();
		String itemPrice = obj.get("price").getAsString();
		
		TreeItem<String> newTrade = new TreeItem<String>(itemName);
		newTrade.setExpanded(true);
		newTrade.getChildren().addAll(
				new TreeItem<String>("Buyer: " + buyerName),
				new TreeItem<String>("Price: " + itemPrice)
				);

		mainRoot.getChildren().add(newTrade);
	
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
			mainRoot.getChildren().remove(tradeRequestsTreeView.getSelectionModel().getSelectedItem());	
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


	private void createTreeItems() {
		mainRoot = new TreeItem<String>("All Trade Requests");
		mainRoot.setExpanded(true);
		tradeRequestsTreeView.setRoot(mainRoot);
	}

	private void subscribe() {
		FrontEndDataObserver.getInstance().subscribe( "tradeRequests", this);
	}
	
	@Override
	public void observerCallback() {
		addTradeRequestToTree(FrontEndDataObserver.getInstance().getCurrentTradeReqData());
		
	}
}
