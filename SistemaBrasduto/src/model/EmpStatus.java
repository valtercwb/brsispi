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
public class EmpStatus {

    private IntegerProperty empStaId;
    private StringProperty empStaName;

    public EmpStatus(int empStaId, String empStaName) {
        this.empStaId = new SimpleIntegerProperty(empStaId);
        this.empStaName = new SimpleStringProperty(empStaName);
    }

    //Metodos atributo: empStaId
    public int getEmpStaId() {
        return empStaId.get();
    }

    public void setEmpStaId(int empStaId) {
        this.empStaId = new SimpleIntegerProperty(empStaId);
    }

    public IntegerProperty EmpStaIdProperty() {
        return empStaId;
    }
    //Metodos atributo: empStaName

    public String getEmpStaName() {
        return empStaName.get();
    }

    public void setEmpStaName(String empStaName) {
        this.empStaName = new SimpleStringProperty(empStaName);
    }

    public StringProperty EmpStaNameProperty() {
        return empStaName;
    }

    public String toString() {
        return empStaName.get();
    }
}
