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
public class Monthfat {

    private IntegerProperty monId;
    private StringProperty monName;

    public Monthfat(int monId, String monName) {
        this.monId = new SimpleIntegerProperty(monId);
        this.monName = new SimpleStringProperty(monName);
    }

    //Metodos atributo: monId
    public int getMonId() {
        return monId.get();
    }

    public void setMonId(int monId) {
        this.monId = new SimpleIntegerProperty(monId);
    }

    public IntegerProperty MonIdProperty() {
        return monId;
    }
    //Metodos atributo: monName

    public String getMonName() {
        return monName.get();
    }

    public void setMonName(String monName) {
        this.monName = new SimpleStringProperty(monName);
    }

    public StringProperty MonNameProperty() {
        return monName;
    }

    public String toString() {
        return monName.get();
    }
}
