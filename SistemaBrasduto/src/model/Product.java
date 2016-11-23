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

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Product {

    private IntegerProperty proId;
    private StringProperty proMat;
    private StringProperty proName;
    private Cat category;
    private StringProperty proFin;
    private StringProperty proQtt;
    private StringProperty proDim;
    private StringProperty proWei;
    private StringProperty proCostPrice;
    private StringProperty proSellPrice;
    private Date proData;
    public String imagePath;
    private Blob proImage;

    public Product(int proId, String proMat, String proName,
            Cat category, String proFin, String proQtt,
            String proDim, String proWei,String proCostPrice, String proSellPrice,
            Date proData, Blob proImage) {
        this.proId = new SimpleIntegerProperty(proId);
        this.proMat = new SimpleStringProperty(proMat);
        this.proName = new SimpleStringProperty(proName);
        this.category = category;
        this.proFin = new SimpleStringProperty(proFin);
        this.proQtt = new SimpleStringProperty(proQtt);
        this.proDim = new SimpleStringProperty(proDim);
        this.proWei = new SimpleStringProperty(proWei);
        this.proCostPrice = new SimpleStringProperty(proCostPrice);
        this.proSellPrice = new SimpleStringProperty(proSellPrice);
        this.proData = proData;
        this.proImage = proImage;
    }

    public Product() {
    }

    //Metodos atributo: proId
    public int getProId() {
        return proId.get();
    }

    public void setProId(int proId) {
        this.proId = new SimpleIntegerProperty(proId);
    }

    public IntegerProperty ProIdProperty() {
        return proId;
    }
    //Metodos atributo: proMat

    public String getProMat() {
        return proMat.get();
    }

    public void setProMat(String proMat) {
        this.proMat = new SimpleStringProperty(proMat);
    }

    public StringProperty ProMatProperty() {
        return proMat;
    }
    //Metodos atributo: proName

    public String getProName() {
        return proName.get();
    }

    public void setProName(String proName) {
        this.proName = new SimpleStringProperty(proName);
    }

    public StringProperty ProNameProperty() {
        return proName;
    }
    //Metodos atributo: category

    public Cat getCategory() {
        return category;
    }

    public void setCategory(Cat category) {
        this.category = category;
    }
    //Metodos atributo: proFin

    public String getProFin() {
        return proFin.get();
    }

    public void setProFin(String proFin) {
        this.proFin = new SimpleStringProperty(proFin);
    }

    public StringProperty ProFinProperty() {
        return proFin;
    }
    //Metodos atributo: proQtt

    public String getProQtt() {
        return proQtt.get();
    }

    public void setProQtt(String proQtt) {
        this.proQtt = new SimpleStringProperty(proQtt);
    }

    public StringProperty ProQttProperty() {
        return proQtt;
    }
    //Metodos atributo: proDim

    public String getProDim() {
        return proDim.get();
    }

    public void setProDim(String proDim) {
        this.proDim = new SimpleStringProperty(proDim);
    }

    public StringProperty ProDimProperty() {
        return proDim;
    }
    //Metodos atributo: proWei

    public String getProWei() {
        return proWei.get();
    }

    public void setProWei(String proWei) {
        this.proWei = new SimpleStringProperty(proWei);
    }

    public StringProperty ProWeiProperty() {
        return proWei;
    }
    //Metodos atributo: proCostPrice

    public String getProCostPrice() {
        return proCostPrice.get();
    }

    public void setProCostPrice(String proCostPrice) {
        this.proCostPrice = new SimpleStringProperty(proCostPrice);
    }

    public StringProperty ProCostPriceProperty() {
        return proCostPrice;
    }
    //Metodos atributo: proSellPrice

    public String getProSellPrice() {
        return proSellPrice.get();
    }

    public void setProSellPrice(String proSellPrice) {
        this.proSellPrice = new SimpleStringProperty(proSellPrice);
    }

    public StringProperty ProSellPriceProperty() {
        return proSellPrice;
    }
    //Metodos atributo: proData

    public Date getProData() {
        return proData;
    }

    public void setProData(Date proData) {
        this.proData = proData;
    }
    //Metodos atributo: proImage

    public Blob getProImage() {
        return proImage;
    }

    public void setProImage(Blob proImage) {
        this.proImage = proImage;
    }
}
