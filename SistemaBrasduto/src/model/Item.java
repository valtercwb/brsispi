/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    private IntegerProperty itemCode;
    private StringProperty itemName;
    private StringProperty itemLocal;
    private StringProperty itemMatter;
    private StringProperty itemPrice;
    private IntegerProperty itemQtd;
    private IntegerProperty itemQtdDay;
    private StringProperty itemWeight;
    private StringProperty itemDim;
    private Date itemDate;
    private Image itemImage;
    public String imagePath;

    public Item(int itemId, int itemCode, String itemName,
            String itemLocal, String itemMatter, String itemPrice,
            int itemQtd, int itemQtdDay, String itemWeight,
            String itemDim, Date itemDate) {
        this.itemId = new SimpleIntegerProperty(itemId);
        this.itemCode = new SimpleIntegerProperty(itemCode);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemLocal = new SimpleStringProperty(itemLocal);
        this.itemMatter = new SimpleStringProperty(itemMatter);
        this.itemPrice = new SimpleStringProperty(itemPrice);
        this.itemQtd = new SimpleIntegerProperty(itemQtd);
        this.itemQtdDay = new SimpleIntegerProperty(itemQtdDay);
        this.itemWeight = new SimpleStringProperty(itemWeight);
        this.itemDim = new SimpleStringProperty(itemDim);
        this.itemDate = itemDate;
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

    public int getItemCode() {
        return itemCode.get();
    }

    public void setItemCode(int itemCode) {
        this.itemCode = new SimpleIntegerProperty(itemCode);
    }

    public IntegerProperty ItemCodeProperty() {
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
    //Metodos atributo: itemMatter

    public String getItemMatter() {
        return itemMatter.get();
    }

    public void setItemMatter(String itemMatter) {
        this.itemMatter = new SimpleStringProperty(itemMatter);
    }

    public StringProperty ItemMatterProperty() {
        return itemMatter;
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
    //Metodos atributo: itemQtd

    public int getItemQtd() {
        return itemQtd.get();
    }

    public void setItemQtd(int itemQtd) {
        this.itemQtd = new SimpleIntegerProperty(itemQtd);
    }

    public IntegerProperty ItemQtdProperty() {
        return itemQtd;
    }
    //Metodos atributo: itemQtdDay

    public int getItemQtdDay() {
        return itemQtdDay.get();
    }

    public void setItemQtdDay(int itemQtdDay) {
        this.itemQtdDay = new SimpleIntegerProperty(itemQtdDay);
    }

    public IntegerProperty ItemQtdDayProperty() {
        return itemQtdDay;
    }
    //Metodos atributo: itemWeight

    public String getItemWeight() {
        return itemWeight.get();
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = new SimpleStringProperty(itemWeight);
    }

    public StringProperty ItemWeightProperty() {
        return itemWeight;
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

    public Image getItemImage() {
        return itemImage;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }
}
