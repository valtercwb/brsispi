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
public class Esc {

    private IntegerProperty escCode;
    private StringProperty escName;

    public Esc(int escCodigo, String escNome) {
        this.escCode = new SimpleIntegerProperty(escCodigo);
        this.escName = new SimpleStringProperty(escNome);
    }

    //Metodos atributo: escCodigo
    public int getEscCodigo() {
        return escCode.get();
    }

    public void setEscCodigo(int escCodigo) {
        this.escCode = new SimpleIntegerProperty(escCodigo);
    }

    public IntegerProperty EscCodigoProperty() {
        return escCode;
    }
    //Metodos atributo: escNome

    public String getEscNome() {
        return escName.get();
    }

    public void setEscNome(String escNome) {
        this.escName = new SimpleStringProperty(escNome);
    }

    public StringProperty EscNomeProperty() {
        return escName;
    }
    @Override
    public String toString(){
    return escName.get();
    }

}
