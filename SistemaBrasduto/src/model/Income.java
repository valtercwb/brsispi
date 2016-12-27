/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class Income {

    private IntegerProperty incId;
    private Monthfat monthfat;
    private DoubleProperty incAmount;
    private DoubleProperty incAmountGoal;
    private IntegerProperty incSaleQtt;
    private IntegerProperty incSaleQttGoal;

    public Income(int incId, Monthfat monthfat, Double incAmount,
            Double incAmountGoal, int incSaleQtt, int incSaleQttGoal) {
        this.incId = new SimpleIntegerProperty(incId);
        this.monthfat = monthfat;
        this.incAmount = new SimpleDoubleProperty(incAmount);
        this.incAmountGoal = new SimpleDoubleProperty(incAmountGoal);
        this.incSaleQtt = new SimpleIntegerProperty(incSaleQtt);
        this.incSaleQttGoal = new SimpleIntegerProperty(incSaleQttGoal);
    }

    public Income() {
    }


    //Metodos atributo: incId
    public int getIncId() {
        return incId.get();
    }

    public void setIncId(int incId) {
        this.incId = new SimpleIntegerProperty(incId);
    }

    public IntegerProperty IncIdProperty() {
        return incId;
    }
    //Metodos atributo: incMonth

    public Monthfat getMonthfat() {
        return monthfat;
    }

    public void setMonthfat(Monthfat monthfat) {
        this.monthfat = monthfat;
    }

    //Metodos atributo: incAmount
    public Double getIncAmount() {
        return incAmount.get();
    }

    public void setIncAmount(Double incAmount) {
        this.incAmount = new SimpleDoubleProperty(incAmount);
    }

    public DoubleProperty IncAmountProperty() {
        return incAmount;
    }
    //Metodos atributo: incAmountGoal

    public Double getIncAmountGoal() {
        return incAmountGoal.get();
    }

    public void setIncAmountGoal(Double incAmountGoal) {
        this.incAmountGoal = new SimpleDoubleProperty(incAmountGoal);
    }

    public DoubleProperty IncAmountGoalProperty() {
        return incAmountGoal;
    }
    //Metodos atributo: incSaleQtt

    public int getIncSaleQtt() {
        return incSaleQtt.get();
    }

    public void setIncSaleQtt(int incSaleQtt) {
        this.incSaleQtt = new SimpleIntegerProperty(incSaleQtt);
    }

    public IntegerProperty IncSaleQttProperty() {
        return incSaleQtt;
    }
    //Metodos atributo: incSaleQttGoal

    public int getIncSaleQttGoal() {
        return incSaleQttGoal.get();
    }

    public void setIncSaleQttGoal(int incSaleQttGoal) {
        this.incSaleQttGoal = new SimpleIntegerProperty(incSaleQttGoal);
    }

    public IntegerProperty IncSaleQttGoalProperty() {
        return incSaleQttGoal;
    }
}
