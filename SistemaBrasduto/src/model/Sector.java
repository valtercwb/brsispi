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
public class Sector {

    private IntegerProperty secId;
    private StringProperty secName;

    public Sector(int secId, String secName) {
        this.secId = new SimpleIntegerProperty(secId);
        this.secName = new SimpleStringProperty(secName);
    }

    //Metodos atributo: secId
    public int getSecId() {
        return secId.get();
    }

    public void setSecId(int secId) {
        this.secId = new SimpleIntegerProperty(secId);
    }

    public IntegerProperty SecIdProperty() {
        return secId;
    }
    //Metodos atributo: secName

    public String getSecName() {
        return secName.get();
    }

    public void setSecName(String secName) {
        this.secName = new SimpleStringProperty(secName);
    }

    public StringProperty SecNameProperty() {
        return secName;
    }

    @Override
    public String toString() {
        return secName.get();
    }
}
