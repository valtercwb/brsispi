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
public class CusStatus {

    private IntegerProperty cusStaId;
    private StringProperty cusStaName;

    public CusStatus(int cusStaId, String cusStaName) {
        this.cusStaId = new SimpleIntegerProperty(cusStaId);
        this.cusStaName = new SimpleStringProperty(cusStaName);
    }

    //Metodos atributo: cusStaId
    public int getCusStaId() {
        return cusStaId.get();
    }

    public void setCusStaId(int cusStaId) {
        this.cusStaId = new SimpleIntegerProperty(cusStaId);
    }

    public IntegerProperty CusStaIdProperty() {
        return cusStaId;
    }
    //Metodos atributo: cusStaName

    public String getCusStaName() {
        return cusStaName.get();
    }

    public void setCusStaName(String cusStaName) {
        this.cusStaName = new SimpleStringProperty(cusStaName);
    }

    public StringProperty CusStaNameProperty() {
        return cusStaName;
    }

    @Override
    public String toString() {
        return cusStaName.get();
    }
}
