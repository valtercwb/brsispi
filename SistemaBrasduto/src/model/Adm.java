///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
///**
// *
// * @author valterFranco<unicuritiba/ads>
// */
//public class Adm {
//
//    private IntegerProperty admId;
//    private StringProperty admName;
//    private StringProperty admLogin;
//    private StringProperty admSenha;
//
//    public Adm(int admId, String admName, String admLogin,
//            String admSenha) {
//        this.admId = new SimpleIntegerProperty(admId);
//        this.admName = new SimpleStringProperty(admName);
//        this.admLogin = new SimpleStringProperty(admLogin);
//        this.admSenha = new SimpleStringProperty(admSenha);
//    }
//
//    //Metodos atributo: admId
//    public int getAdmId() {
//        return admId.get();
//    }
//
//    public void setAdmId(int admId) {
//        this.admId = new SimpleIntegerProperty(admId);
//    }
//
//    public IntegerProperty AdmIdProperty() {
//        return admId;
//    }
//    //Metodos atributo: admName
//
//    public String getAdmName() {
//        return admName.get();
//    }
//
//    public void setAdmName(String admName) {
//        this.admName = new SimpleStringProperty(admName);
//    }
//
//    public StringProperty AdmNameProperty() {
//        return admName;
//    }
//    //Metodos atributo: admLogin
//
//    public String getAdmLogin() {
//        return admLogin.get();
//    }
//
//    public void setAdmLogin(String admLogin) {
//        this.admLogin = new SimpleStringProperty(admLogin);
//    }
//
//    public StringProperty AdmLoginProperty() {
//        return admLogin;
//    }
//    //Metodos atributo: admSenha
//
//    public String getAdmSenha() {
//        return admSenha.get();
//    }
//
//    public void setAdmSenha(String admSenha) {
//        this.admSenha = new SimpleStringProperty(admSenha);
//    }
//
//    public StringProperty AdmSenhaProperty() {
//        return admSenha;
//    }
//}
