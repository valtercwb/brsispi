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
 * @author valter.franco
 */
public class User {

    private IntegerProperty userId;
    private StringProperty userName;
    private StringProperty userLogin;
    private StringProperty userSenha;
    private UserStatus userStatus;
    private UserType userType;

    public User(int userId, String userName, String userLogin,
            String userSenha, UserStatus userStatus, UserType userType) {
        this.userId = new SimpleIntegerProperty(userId);
        this.userName = new SimpleStringProperty(userName);
        this.userLogin = new SimpleStringProperty(userLogin);
        this.userSenha = new SimpleStringProperty(userSenha);
        this.userStatus = userStatus;
        this.userType = userType;
    }

    public User() {
    }

    //Metodos atributo: userId
    public int getUserId() {
        return userId.get();
    }

    public void setUserId(int userId) {
        this.userId = new SimpleIntegerProperty(userId);
    }

    public IntegerProperty UserIdProperty() {
        return userId;
    }
    //Metodos atributo: userName

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }

    public StringProperty UserNameProperty() {
        return userName;
    }
    //Metodos atributo: userLogin

    public String getUserLogin() {
        return userLogin.get();
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = new SimpleStringProperty(userLogin);
    }

    public StringProperty UserLoginProperty() {
        return userLogin;
    }
    //Metodos atributo: userSenha

    public String getUserSenha() {
        return userSenha.get();
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = new SimpleStringProperty(userSenha);
    }

    public StringProperty UserSenhaProperty() {
        return userSenha;
    }
    //Metodos atributo: userStatus

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    //Metodos atributo: userType
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
