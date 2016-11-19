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

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Customer {

    private IntegerProperty cusId;
    private StringProperty cusName;
    private StringProperty cusCnpj;
    private StringProperty cusPhone;
    private StringProperty cusEmail;
    private CusStatus cusStatus;
    private StringProperty cusAdress;
    private StringProperty cusZipCode;
    private StringProperty cusCity;
    private StringProperty cusState;
    private StringProperty cusCountry;
    private Date cusDate;

    public Customer(int cusId, String cusName, String cusCnpj,
            String cusPhone, String cusEmail, CusStatus cusStatus,
            String cusAdress, String cusZipCode, String cusCity,
            String cusState, String cusCountry, Date cusDate) {
        this.cusId = new SimpleIntegerProperty(cusId);
        this.cusName = new SimpleStringProperty(cusName);
        this.cusCnpj = new SimpleStringProperty(cusCnpj);
        this.cusPhone = new SimpleStringProperty(cusPhone);
        this.cusEmail = new SimpleStringProperty(cusEmail);
        this.cusStatus = cusStatus;
        this.cusAdress = new SimpleStringProperty(cusAdress);
        this.cusZipCode = new SimpleStringProperty(cusZipCode);
        this.cusCity = new SimpleStringProperty(cusCity);
        this.cusState = new SimpleStringProperty(cusState);
        this.cusCountry = new SimpleStringProperty(cusCountry);
        this.cusDate = cusDate;
    }

    public Customer() {
    }

    //Metodos atributo: cusId
    public int getCusId() {
        return cusId.get();
    }

    public void setCusId(int cusId) {
        this.cusId = new SimpleIntegerProperty(cusId);
    }

    public IntegerProperty CusIdProperty() {
        return cusId;
    }
    //Metodos atributo: cusName

    public String getCusName() {
        return cusName.get();
    }

    public void setCusName(String cusName) {
        this.cusName = new SimpleStringProperty(cusName);
    }

    public StringProperty CusNameProperty() {
        return cusName;
    }
    //Metodos atributo: cusCnpj

    public String getCusCnpj() {
        return cusCnpj.get();
    }

    public void setCusCnpj(String cusCnpj) {
        this.cusCnpj = new SimpleStringProperty(cusCnpj);
    }

    public StringProperty CusCnpjProperty() {
        return cusCnpj;
    }
    //Metodos atributo: cusPhone

    public String getCusPhone() {
        return cusPhone.get();
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = new SimpleStringProperty(cusPhone);
    }

    public StringProperty CusPhoneProperty() {
        return cusPhone;
    }
    //Metodos atributo: cusEmail

    public String getCusEmail() {
        return cusEmail.get();
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = new SimpleStringProperty(cusEmail);
    }

    public StringProperty CusEmailProperty() {
        return cusEmail;
    }
    //Metodos atributo: cusStatus

    public CusStatus getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(CusStatus cusStatus) {
        this.cusStatus = cusStatus;
    }
    //Metodos atributo: cusAdress

    public String getCusAdress() {
        return cusAdress.get();
    }

    public void setCusAdress(String cusAdress) {
        this.cusAdress = new SimpleStringProperty(cusAdress);
    }

    public StringProperty CusAdressProperty() {
        return cusAdress;
    }
    //Metodos atributo: cusZipCode

    public String getCusZipCode() {
        return cusZipCode.get();
    }

    public void setCusZipCode(String cusZipCode) {
        this.cusZipCode = new SimpleStringProperty(cusZipCode);
    }

    public StringProperty CusZipCodeProperty() {
        return cusZipCode;
    }
    //Metodos atributo: cusCity

    public String getCusCity() {
        return cusCity.get();
    }

    public void setCusCity(String cusCity) {
        this.cusCity = new SimpleStringProperty(cusCity);
    }

    public StringProperty CusCityProperty() {
        return cusCity;
    }
    //Metodos atributo: cusState

    public String getCusState() {
        return cusState.get();
    }

    public void setCusState(String cusState) {
        this.cusState = new SimpleStringProperty(cusState);
    }

    public StringProperty CusStateProperty() {
        return cusState;
    }
    //Metodos atributo: cusCountry

    public String getCusCountry() {
        return cusCountry.get();
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = new SimpleStringProperty(cusCountry);
    }

    public StringProperty CusCountryProperty() {
        return cusCountry;
    }
    //Metodos atributo: cusDate

    public Date getCusDate() {
        return cusDate;
    }

    public void setCusDate(Date cusDate) {
        this.cusDate = cusDate;
    }
}
