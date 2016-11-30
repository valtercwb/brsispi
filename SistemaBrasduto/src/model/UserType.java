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
public class UserType {

    private IntegerProperty userTypId;
    private StringProperty userTypName;

    public UserType(int userTypId, String userTypName) {
        this.userTypId = new SimpleIntegerProperty(userTypId);
        this.userTypName = new SimpleStringProperty(userTypName);
    }

    //Metodos atributo: userTypId
    public int getUserTypId() {
        return userTypId.get();
    }

    public void setUserTypId(int userTypId) {
        this.userTypId = new SimpleIntegerProperty(userTypId);
    }

    public IntegerProperty UserTypIdProperty() {
        return userTypId;
    }
    //Metodos atributo: userTypName

    public String getUserTypName() {
        return userTypName.get();
    }

    public void setUserTypName(String userTypName) {
        this.userTypName = new SimpleStringProperty(userTypName);
    }

    public StringProperty UserTypNameProperty() {
        return userTypName;
    }

    @Override
    public String toString() {
        return userTypName.get();
    }
}
