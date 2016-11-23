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
public class MaritalStatus {

    private IntegerProperty marStaId;
    private StringProperty marStaName;

    public MaritalStatus(int marStaId, String marStaName) {
        this.marStaId = new SimpleIntegerProperty(marStaId);
        this.marStaName = new SimpleStringProperty(marStaName);
    }

    //Metodos atributo: marStaId
    public int getMarStaId() {
        return marStaId.get();
    }

    public void setMarStaId(int marStaId) {
        this.marStaId = new SimpleIntegerProperty(marStaId);
    }

    public IntegerProperty MarStaIdProperty() {
        return marStaId;
    }
    //Metodos atributo: marStaName

    public String getMarStaName() {
        return marStaName.get();
    }

    public void setMarStaName(String marStaName) {
        this.marStaName = new SimpleStringProperty(marStaName);
    }

    public StringProperty MarStaNameProperty() {
        return marStaName;
    }

    @Override
    public String toString() {
        return marStaName.get();
    }
}
