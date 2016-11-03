/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Cat {

    private IntegerProperty catCode;
    private StringProperty catName;

    public Cat(int catCode, String catName) {
        this.catCode = new SimpleIntegerProperty(catCode);
        this.catName = new SimpleStringProperty(catName);
    }

    //Metodos atributo: catCode
    public int getCatCode() {
        return catCode.get();
    }

    public void setCatCode(int catCode) {
        this.catCode = new SimpleIntegerProperty(catCode);
    }

    public IntegerProperty CatCodeProperty() {
        return catCode;
    }
    //Metodos atributo: catName

    public String getCatName() {
        return catName.get();
    }

    public void setCatName(String catName) {
        this.catName = new SimpleStringProperty(catName);
    }

    public StringProperty CatNameProperty() {
        return catName;
    }
    @Override
    public String toString(){
    return catName.get();
    }
}
