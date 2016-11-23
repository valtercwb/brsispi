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
public class CityState {

    private IntegerProperty cityStateId;
    private StringProperty cityStateName;

    public CityState(int cityStateId, String cityStateName) {
        this.cityStateId = new SimpleIntegerProperty(cityStateId);
        this.cityStateName = new SimpleStringProperty(cityStateName);
    }

    //Metodos atributo: cityStateId
    public int getCityStateId() {
        return cityStateId.get();
    }

    public void setCityStateId(int cityStateId) {
        this.cityStateId = new SimpleIntegerProperty(cityStateId);
    }

    public IntegerProperty CityStateIdProperty() {
        return cityStateId;
    }
    //Metodos atributo: cityStateName

    public String getCityStateName() {
        return cityStateName.get();
    }

    public void setCityStateName(String cityStateName) {
        this.cityStateName = new SimpleStringProperty(cityStateName);
    }

    public StringProperty CityStateNameProperty() {
        return cityStateName;
    }

    public String toString() {
        return cityStateName.get();
    }
}
