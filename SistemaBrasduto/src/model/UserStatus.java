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
public class UserStatus {

    private IntegerProperty userStatusId;
    private StringProperty userStatusName;

    public UserStatus(int userStatusId, String userStatusName) {
        this.userStatusId = new SimpleIntegerProperty(userStatusId);
        this.userStatusName = new SimpleStringProperty(userStatusName);
    }

    //Metodos atributo: userStatusId
    public int getUserStatusId() {
        return userStatusId.get();
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = new SimpleIntegerProperty(userStatusId);
    }

    public IntegerProperty UserStatusIdProperty() {
        return userStatusId;
    }
    //Metodos atributo: userStatusName

    public String getUserStatusName() {
        return userStatusName.get();
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = new SimpleStringProperty(userStatusName);
    }

    public StringProperty UserStatusNameProperty() {
        return userStatusName;
    }

    public String toString() {
        return userStatusName.get();
    }

}
