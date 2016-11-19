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
public class Supplier {

    private IntegerProperty supId;
    private StringProperty supName;
    private StringProperty supCtr;
    private StringProperty supPhone;
    private StringProperty supEmail;
    private StringProperty supContact;
    private StringProperty supMatTyp;
    private StringProperty supAdress;
    private StringProperty supZipCode;
    private StringProperty supSub;
    private StringProperty supCity;
    private StringProperty supState;
    private StringProperty supCountry;
    private Date supDate;

    public Supplier(int supId, String supName, String supCtr,
            String supPhone, String supEmail, String supContact,
            String supMatTyp, String supAdress, String supZipCode,
            String supSub, String supCity, String supState,
            String supCountry, Date supDate) {
        this.supId = new SimpleIntegerProperty(supId);
        this.supName = new SimpleStringProperty(supName);
        this.supCtr = new SimpleStringProperty(supCtr);
        this.supPhone = new SimpleStringProperty(supPhone);
        this.supEmail = new SimpleStringProperty(supEmail);
        this.supContact = new SimpleStringProperty(supContact);
        this.supMatTyp = new SimpleStringProperty(supMatTyp);
        this.supAdress = new SimpleStringProperty(supAdress);
        this.supZipCode = new SimpleStringProperty(supZipCode);
        this.supSub = new SimpleStringProperty(supSub);
        this.supCity = new SimpleStringProperty(supCity);
        this.supState = new SimpleStringProperty(supState);
        this.supCountry = new SimpleStringProperty(supCountry);
        this.supDate = supDate;
    }

    public Supplier() {
    }

    public Supplier(int supId, String supName) {
        this.supId = new SimpleIntegerProperty(supId);
        this.supName = new SimpleStringProperty(supName);
    }

    //Metodos atributo: supId
    public int getSupId() {
        return supId.get();
    }

    public void setSupId(int supId) {
        this.supId = new SimpleIntegerProperty(supId);
    }

    public IntegerProperty SupIdProperty() {
        return supId;
    }
    //Metodos atributo: supName

    public String getSupName() {
        return supName.get();
    }

    public void setSupName(String supName) {
        this.supName = new SimpleStringProperty(supName);
    }

    public StringProperty SupNameProperty() {
        return supName;
    }
    //Metodos atributo: supCtr

    public String getSupCtr() {
        return supCtr.get();
    }

    public void setSupCtr(String supCtr) {
        this.supCtr = new SimpleStringProperty(supCtr);
    }

    public StringProperty SupCtrProperty() {
        return supCtr;
    }
    //Metodos atributo: supPhone

    public String getSupPhone() {
        return supPhone.get();
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = new SimpleStringProperty(supPhone);
    }

    public StringProperty SupPhoneProperty() {
        return supPhone;
    }
    //Metodos atributo: supEmail

    public String getSupEmail() {
        return supEmail.get();
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = new SimpleStringProperty(supEmail);
    }

    public StringProperty SupEmailProperty() {
        return supEmail;
    }
    //Metodos atributo: supContact

    public String getSupContact() {
        return supContact.get();
    }

    public void setSupContact(String supContact) {
        this.supContact = new SimpleStringProperty(supContact);
    }

    public StringProperty SupContactProperty() {
        return supContact;
    }
    //Metodos atributo: supMatTyp

    public String getSupMatTyp() {
        return supMatTyp.get();
    }

    public void setSupMatTyp(String supMatTyp) {
        this.supMatTyp = new SimpleStringProperty(supMatTyp);
    }

    public StringProperty SupMatTypProperty() {
        return supMatTyp;
    }
    //Metodos atributo: supAdress

    public String getSupAdress() {
        return supAdress.get();
    }

    public void setSupAdress(String supAdress) {
        this.supAdress = new SimpleStringProperty(supAdress);
    }

    public StringProperty SupAdressProperty() {
        return supAdress;
    }
    //Metodos atributo: supZipCode

    public String getSupZipCode() {
        return supZipCode.get();
    }

    public void setSupZipCode(String supZipCode) {
        this.supZipCode = new SimpleStringProperty(supZipCode);
    }

    public StringProperty SupZipCodeProperty() {
        return supZipCode;
    }
    //Metodos atributo: supSub

    public String getSupSub() {
        return supSub.get();
    }

    public void setSupSub(String supSub) {
        this.supSub = new SimpleStringProperty(supSub);
    }

    public StringProperty SupSubProperty() {
        return supSub;
    }
    //Metodos atributo: supCity

    public String getSupCity() {
        return supCity.get();
    }

    public void setSupCity(String supCity) {
        this.supCity = new SimpleStringProperty(supCity);
    }

    public StringProperty SupCityProperty() {
        return supCity;
    }
    //Metodos atributo: supState

    public String getSupState() {
        return supState.get();
    }

    public void setSupState(String supState) {
        this.supState = new SimpleStringProperty(supState);
    }

    public StringProperty SupStateProperty() {
        return supState;
    }
    //Metodos atributo: supCountry

    public String getSupCountry() {
        return supCountry.get();
    }

    public void setSupCountry(String supCountry) {
        this.supCountry = new SimpleStringProperty(supCountry);
    }

    public StringProperty SupCountryProperty() {
        return supCountry;
    }
    //Metodos atributo: supDate

    public Date getSupDate() {
        return supDate;
    }

    public void setSupDate(Date supDate) {
        this.supDate = supDate;
    }

@Override
        public String toString() {
        return supName.get();
    }
}
