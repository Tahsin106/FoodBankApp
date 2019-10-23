package com.example.user.foodbank;

/**
 * Created by rafiqul islam on 8/2/2017.
 */

public class ItemInfo {
    private String itemName;
    private String price;
    private String shopName;
    private String shopArea;

    public ItemInfo(String itemName, String price, String shopName,String area) {
        this.itemName = itemName;
        this.price = price;
        this.shopName = shopName;
        this.shopArea = area;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getShopArea() {
        return shopArea;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
