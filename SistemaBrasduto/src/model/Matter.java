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
public class Matter {

    private IntegerProperty matId;
    private StringProperty matName;

    public Matter(int matId, String matName) {
        this.matId = new SimpleIntegerProperty(matId);
        this.matName = new SimpleStringProperty(matName);
    }

    //Metodos atributo: matId
    public int getMatId() {
        return matId.get();
    }

    public void setMatId(int matId) {
        this.matId = new SimpleIntegerProperty(matId);
    }

    public IntegerProperty MatIdProperty() {
        return matId;
    }
    //Metodos atributo: matName

    public String getMatName() {
        return matName.get();
    }

    public void setMatName(String matName) {
        this.matName = new SimpleStringProperty(matName);
    }

    public StringProperty MatNameProperty() {
        return matName;
    }
    @Override
    public String toString(){
    return matName.get();
    }
}
