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
public class SchLevel {

    private IntegerProperty schLevelId;
    private StringProperty schLevelName;

    public SchLevel(int schLevelId, String schLevelName) {
        this.schLevelId = new SimpleIntegerProperty(schLevelId);
        this.schLevelName = new SimpleStringProperty(schLevelName);
    }

    //Metodos atributo: schLevelId
    public int getSchLevelId() {
        return schLevelId.get();
    }

    public void setSchLevelId(int schLevelId) {
        this.schLevelId = new SimpleIntegerProperty(schLevelId);
    }

    public IntegerProperty SchLevelIdProperty() {
        return schLevelId;
    }
    //Metodos atributo: schLevelName

    public String getSchLevelName() {
        return schLevelName.get();
    }

    public void setSchLevelName(String schLevelName) {
        this.schLevelName = new SimpleStringProperty(schLevelName);
    }

    public StringProperty SchLevelNameProperty() {
        return schLevelName;
    }

    public String toString() {
        return schLevelName.get();
    }
}
