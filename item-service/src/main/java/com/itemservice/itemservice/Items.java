package com.itemservice.itemservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Item_service")

public class Items {

@Id
@Column(name="item_name")
private String itemName;


@Column(name="item_id")
private Long itemId;
@Column(name="description")
public String description;
@Column(name="price")
private int  price;
private int port;

public Items() {
}

public Items(String itemName, Long itemId, String description, int price) {
	super();
	this.itemName = itemName;
	this.itemId = itemId;
	this.description = description;
	this.price = price;
	
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public Long getItemId() {
	return itemId;
}

public void setItemId(Long itemId) {
	this.itemId = itemId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getPort() {
	return port;
}

public void setPort(int port) {
	this.port = port;
}

}
