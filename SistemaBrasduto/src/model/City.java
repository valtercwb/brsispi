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


public class City {

    private IntegerProperty cityId;
    private StringProperty cityName;
    private CityState cityState;
    private CityCountry cityCountry;

    public City(int cityId, String cityName, CityState cityState,
            CityCountry cityCountry) {
        this.cityId = new SimpleIntegerProperty(cityId);
        this.cityName = new SimpleStringProperty(cityName);
        this.cityState = cityState;
        this.cityCountry = cityCountry;
    }

    //Metodos atributo: cityId
    public int getCityId() {
        return cityId.get();
    }

    public void setCityId(int cityId) {
        this.cityId = new SimpleIntegerProperty(cityId);
    }

    public IntegerProperty CityIdProperty() {
        return cityId;
    }
    //Metodos atributo: cityName

    public String getCityName() {
        return cityName.get();
    }

    public void setCityName(String cityName) {
        this.cityName = new SimpleStringProperty(cityName);
    }

    public StringProperty CityNameProperty() {
        return cityName;
    }
    //Metodos atributo: cityState

    public CityState getCityState() {
        return cityState;
    }

    public void setCityState(CityState cityState) {
        this.cityState = cityState;
    }
    //Metodos atributo: cityCountry

    public CityCountry getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(CityCountry cityCountry) {
        this.cityCountry = cityCountry;
    }

}
