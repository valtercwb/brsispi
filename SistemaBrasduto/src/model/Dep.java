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
public class Dep {

    private IntegerProperty depCode;
    private StringProperty depName;

    public Dep(int depCode, String depName) {
        this.depCode = new SimpleIntegerProperty(depCode);
        this.depName = new SimpleStringProperty(depName);
    }

    //Metodos atributo: depCode
    public int getDepCode() {
        return depCode.get();
    }

    public void setDepCode(int depCode) {
        this.depCode = new SimpleIntegerProperty(depCode);
    }

    public IntegerProperty DepCodeProperty() {
        return depCode;
    }
    //Metodos atributo: depName

    public String getDepName() {
        return depName.get();
    }

    public void setDepName(String depName) {
        this.depName = new SimpleStringProperty(depName);
    }

    public StringProperty DepNameProperty() {
        return depName;
    }
     @Override
    public String toString(){
    return depName.get();
    }
}

