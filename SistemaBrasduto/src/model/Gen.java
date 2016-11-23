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
public class Gen {

    private IntegerProperty genId;
    private StringProperty genName;

    public Gen(int genId, String genName) {
        this.genId = new SimpleIntegerProperty(genId);
        this.genName = new SimpleStringProperty(genName);
    }

    //Metodos atributo: genId
    public int getGenId() {
        return genId.get();
    }

    public void setGenId(int genId) {
        this.genId = new SimpleIntegerProperty(genId);
    }

    public IntegerProperty GenIdProperty() {
        return genId;
    }
    //Metodos atributo: genName

    public String getGenName() {
        return genName.get();
    }

    public void setGenName(String genName) {
        this.genName = new SimpleStringProperty(genName);
    }

    public StringProperty GenNameProperty() {
        return genName;
    }

    @Override
    public String toString() {
        return genName.get();
    }
}
