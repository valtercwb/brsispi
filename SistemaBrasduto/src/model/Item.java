/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Item {

    private IntegerProperty itemId;
    private StringProperty itemCode;
    private StringProperty itemName;
    private StringProperty itemLocal;
    private Matter matter;
    private Sector sector;
    private Supplier supplier;
    private StringProperty itemPrice;
    private IntegerProperty itemQtt;
    private IntegerProperty itemQttDay;
    private StringProperty itemWei;
    private StringProperty itemDim;
    private Date itemDate;
    public String imagePath;
    private Blob itemImage;
    public Image image;

    public Item(int itemId, String itemCode, String itemName,
            String itemLocal, Matter matter, Sector sector,
            Supplier supplier, String itemDim, int itemQtt,
            int itemQttDay, String itemWei, String itemPrice,
            Date itemDate, Blob itemImage) {
        this.itemId = new SimpleIntegerProperty(itemId);
        this.itemCode = new SimpleStringProperty(itemCode);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemLocal = new SimpleStringProperty(itemLocal);
        this.matter = matter;
        this.sector = sector;
        this.supplier = supplier;
        this.itemDim = new SimpleStringProperty(itemDim);
        this.itemQtt = new SimpleIntegerProperty(itemQtt);
        this.itemQttDay = new SimpleIntegerProperty(itemQttDay);
        this.itemWei = new SimpleStringProperty(itemWei);
        this.itemPrice = new SimpleStringProperty(itemPrice);
        this.itemDate = itemDate;
        this.itemImage = itemImage;
    }

    public Item() {
    }

    //Metodos atributo: itemId
    public int getItemId() {
        return itemId.get();
    }

    public void setItemId(int itemId) {
        this.itemId = new SimpleIntegerProperty(itemId);
    }

    public IntegerProperty ItemIdProperty() {
        return itemId;
    }
    //Metodos atributo: itemCode

    public String getItemCode() {
        return itemCode.get();
    }

    public void setItemCode(String itemCode) {
        this.itemCode = new SimpleStringProperty(itemCode);
    }

    public StringProperty ItemCodeProperty() {
        return itemCode;
    }
    //Metodos atributo: itemName

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public StringProperty ItemNameProperty() {
        return itemName;
    }
    //Metodos atributo: itemLocal

    public String getItemLocal() {
        return itemLocal.get();
    }

    public void setItemLocal(String itemLocal) {
        this.itemLocal = new SimpleStringProperty(itemLocal);
    }

    public StringProperty ItemLocalProperty() {
        return itemLocal;
    }
    //Metodos atributo: matter

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }
    //Metodos atributo: sector

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    //Metodos atributo: supplier

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    //Metodos atributo: itemPrice

    public String getItemPrice() {
        return itemPrice.get();
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = new SimpleStringProperty(itemPrice);
    }

    public StringProperty ItemPriceProperty() {
        return itemPrice;
    }
    //Metodos atributo: itemQtt

    public int getItemQtt() {
        return itemQtt.get();
    }

    public void setItemQtt(int itemQtt) {
        this.itemQtt = new SimpleIntegerProperty(itemQtt);
    }

    public IntegerProperty ItemQttProperty() {
        return itemQtt;
    }
    //Metodos atributo: itemQttDay

    public int getItemQttDay() {
        return itemQttDay.get();
    }

    public void setItemQttDay(int itemQttDay) {
        this.itemQttDay = new SimpleIntegerProperty(itemQttDay);
    }

    public IntegerProperty ItemQttDayProperty() {
        return itemQttDay;
    }
    //Metodos atributo: itemWei

    public String getItemWei() {
        return itemWei.get();
    }

    public void setItemWei(String itemWei) {
        this.itemWei = new SimpleStringProperty(itemWei);
    }

    public StringProperty ItemWeiProperty() {
        return itemWei;
    }
    //Metodos atributo: itemDim

    public String getItemDim() {
        return itemDim.get();
    }

    public void setItemDim(String itemDim) {
        this.itemDim = new SimpleStringProperty(itemDim);
    }

    public StringProperty ItemDimProperty() {
        return itemDim;
    }
    //Metodos atributo: itemDate

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }
    //Metodos atributo: itemImage

    public Blob getItemImage() {
        return itemImage;
    }

    public void setItemImage(Blob itemImage) {
        this.itemImage = itemImage;
    }
}
