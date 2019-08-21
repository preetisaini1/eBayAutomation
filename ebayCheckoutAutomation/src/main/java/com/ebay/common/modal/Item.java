package com.ebay.common.modal;

public class Item {
	private String itemName;
	private String itemPrice;
		
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
		public String getitemPrice() {
		return itemPrice;
	}

	public void setitemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return String.format("[Item Name]: %s [Item Price]: %s ",itemName,itemPrice );
	}

}
