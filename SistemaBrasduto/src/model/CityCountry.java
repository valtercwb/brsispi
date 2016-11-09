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
public class CityCountry {

    private IntegerProperty cityCountryId;
    private StringProperty cityCountryName;

    public CityCountry(int cityCountryId, String cityCountryName) {
        this.cityCountryId = new SimpleIntegerProperty(cityCountryId);
        this.cityCountryName = new SimpleStringProperty(cityCountryName);
    }

    //Metodos atributo: cityCountryId
    public int getCityCountryId() {
        return cityCountryId.get();
    }

    public void setCityCountryId(int cityCountryId) {
        this.cityCountryId = new SimpleIntegerProperty(cityCountryId);
    }

    public IntegerProperty CityCountryIdProperty() {
        return cityCountryId;
    }
    //Metodos atributo: cityCountryName

    public String getCityCountryName() {
        return cityCountryName.get();
    }

    public void setCityCountryName(String cityCountryName) {
        this.cityCountryName = new SimpleStringProperty(cityCountryName);
    }

    public StringProperty CityCountryNameProperty() {
        return cityCountryName;
    }
}

