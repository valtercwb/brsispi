/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Expression valter is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Employee {

    private IntegerProperty empId;
    private StringProperty empCode;
    private StringProperty empName;
    private Gen gen;
    private Date empBirthDate;
    private MaritalStatus maritalStatus;
    private StringProperty empPhoneFix;
    private StringProperty empPhoneCel;
    private StringProperty empEmail;
    private StringProperty empAdress;
    private StringProperty empZipCode;
    private StringProperty empSub;
    private City city;
    private CityState cityState;
    private Country country;
    private SchLevel schLevel;
    private StringProperty empRg;
    private StringProperty empCpf;
    private StringProperty empCp;
    private StringProperty empPis;
    private StringProperty empCnh;
    private StringProperty empTrans;
    private EmpStatus empStatus;
    private Dep empDep;
    private StringProperty empPosition;
    private StringProperty empSalary;
    private Date admDate;
    private Date fireDate;
    public String imagePath;
    private Blob empBlob;
    private StringProperty empSchDesc;

    public Employee() {
    }

    public Employee(int empId, String empCode, String empName,
            Gen gen, Date empBirthDate, MaritalStatus maritalStatus,
            String empPhoneFix, String empPhoneCel, String empEmail,
            String empAdress, String empZipCode, String empSub,
            City city, CityState cityState, Country country,
            SchLevel schLevel, String empSchDesc, String empRg, String empCpf,
            String empCp, String empPis, String empCnh,
            String empTrans, EmpStatus empStatus, Dep empDep,
            String empPosition, String empSalary, Date admDate,
            Date fireDate, Blob empBlob) {
        this.empId = new SimpleIntegerProperty(empId);
        this.empCode = new SimpleStringProperty(empCode);
        this.empName = new SimpleStringProperty(empName);
        this.gen = gen;
        this.empBirthDate = empBirthDate;
        this.maritalStatus = maritalStatus;
        this.empPhoneFix = new SimpleStringProperty(empPhoneFix);
        this.empPhoneCel = new SimpleStringProperty(empPhoneCel);
        this.empEmail = new SimpleStringProperty(empEmail);
        this.empAdress = new SimpleStringProperty(empAdress);
        this.empZipCode = new SimpleStringProperty(empZipCode);
        this.empSub = new SimpleStringProperty(empSub);
        this.city = city;
        this.cityState = cityState;
        this.country = country;
        this.schLevel = schLevel;
        this.empSchDesc = new SimpleStringProperty(empSchDesc);
        this.empRg = new SimpleStringProperty(empRg);
        this.empCpf = new SimpleStringProperty(empCpf);
        this.empCp = new SimpleStringProperty(empCp);
        this.empPis = new SimpleStringProperty(empPis);
        this.empCnh = new SimpleStringProperty(empCnh);
        this.empTrans = new SimpleStringProperty(empTrans);
        this.empStatus = empStatus;
        this.empDep = empDep;
        this.empPosition = new SimpleStringProperty(empPosition);
        this.empSalary = new SimpleStringProperty(empSalary);
        this.admDate = admDate;
        this.fireDate = fireDate;
        this.empBlob = empBlob;

    }

    //Metodos atributo: empId
    public int getEmpId() {
        return empId.get();
    }

    public void setEmpId(int empId) {
        this.empId = new SimpleIntegerProperty(empId);
    }

    public IntegerProperty EmpIdProperty() {
        return empId;
    }
    //Metodos atributo: empCode

    public String getEmpCode() {
        return empCode.get();
    }

    public void setEmpCode(String empCode) {
        this.empCode = new SimpleStringProperty(empCode);
    }

    public StringProperty EmpCodeProperty() {
        return empCode;
    }
    //Metodos atributo: empName

    public String getEmpName() {
        return empName.get();
    }

    public void setEmpName(String empName) {
        this.empName = new SimpleStringProperty(empName);
    }

    public StringProperty EmpNameProperty() {
        return empName;
    }
    //Metodos atributo: gen

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }
    //Metodos atributo: empBirthDate

    public Date getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(Date empBirthDate) {
        this.empBirthDate = empBirthDate;
    }
    //Metodos atributo: maritalStatus

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    //Metodos atributo: empPhoneFix

    public String getEmpPhoneFix() {
        return empPhoneFix.get();
    }

    public void setEmpPhoneFix(String empPhoneFix) {
        this.empPhoneFix = new SimpleStringProperty(empPhoneFix);
    }

    public StringProperty EmpPhoneFixProperty() {
        return empPhoneFix;
    }
    //Metodos atributo: empPhoneCel

    public String getEmpPhoneCel() {
        return empPhoneCel.get();
    }

    public void setEmpPhoneCel(String empPhoneCel) {
        this.empPhoneCel = new SimpleStringProperty(empPhoneCel);
    }

    public StringProperty EmpPhoneCelProperty() {
        return empPhoneCel;
    }
    //Metodos atributo: empEmail

    public String getEmpEmail() {
        return empEmail.get();
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = new SimpleStringProperty(empEmail);
    }

    public StringProperty EmpEmailProperty() {
        return empEmail;
    }
    //Metodos atributo: empAdress

    public String getEmpAdress() {
        return empAdress.get();
    }

    public void setEmpAdress(String empAdress) {
        this.empAdress = new SimpleStringProperty(empAdress);
    }

    public StringProperty EmpAdressProperty() {
        return empAdress;
    }
    //Metodos atributo: empZipCode

    public String getEmpZipCode() {
        return empZipCode.get();
    }

    public void setEmpZipCode(String empZipCode) {
        this.empZipCode = new SimpleStringProperty(empZipCode);
    }

    public StringProperty EmpZipCodeProperty() {
        return empZipCode;
    }
    //Metodos atributo: empSub

    public String getEmpSub() {
        return empSub.get();
    }

    public void setEmpSub(String empSub) {
        this.empSub = new SimpleStringProperty(empSub);
    }

    public StringProperty EmpSubProperty() {
        return empSub;
    }
    //Metodos atributo: city

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    //Metodos atributo: cityState

    public CityState getCityState() {
        return cityState;
    }

    public void setCityState(CityState cityState) {
        this.cityState = cityState;
    }
    //Metodos atributo: country

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    //Metodos atributo: schLevel

    public SchLevel getSchLevel() {
        return schLevel;
    }

    public void setSchLevel(SchLevel schLevel) {
        this.schLevel = schLevel;
    }
    //Metodos atributo: empRg

    public String getEmpRg() {
        return empRg.get();
    }

    public void setEmpRg(String empRg) {
        this.empRg = new SimpleStringProperty(empRg);
    }

    public StringProperty EmpRgProperty() {
        return empRg;
    }
    //Metodos atributo: empCpf

    public String getEmpCpf() {
        return empCpf.get();
    }

    public void setEmpCpf(String empCpf) {
        this.empCpf = new SimpleStringProperty(empCpf);
    }

    public StringProperty EmpCpfProperty() {
        return empCpf;
    }
    //Metodos atributo: empCp

    public String getEmpCp() {
        return empCp.get();
    }

    public void setEmpCp(String empCp) {
        this.empCp = new SimpleStringProperty(empCp);
    }

    public StringProperty EmpCpProperty() {
        return empCp;
    }
    //Metodos atributo: empPis

    public String getEmpPis() {
        return empPis.get();
    }

    public void setEmpPis(String empPis) {
        this.empPis = new SimpleStringProperty(empPis);
    }

    public StringProperty EmpPisProperty() {
        return empPis;
    }
    //Metodos atributo: empCnh

    public String getEmpCnh() {
        return empCnh.get();
    }

    public void setEmpCnh(String empCnh) {
        this.empCnh = new SimpleStringProperty(empCnh);
    }

    public StringProperty EmpCnhProperty() {
        return empCnh;
    }
    //Metodos atributo: empTrans

    public String getEmpTrans() {
        return empTrans.get();
    }

    public void setEmpTrans(String empTrans) {
        this.empTrans = new SimpleStringProperty(empTrans);
    }

    public StringProperty EmpTransProperty() {
        return empTrans;
    }
    //Metodos atributo: empStatus

    public EmpStatus getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(EmpStatus empStatus) {
        this.empStatus = empStatus;
    }
    //Metodos atributo: empDep

    public Dep getEmpDep() {
        return empDep;
    }

    public void setEmpDep(Dep empDep) {
        this.empDep = empDep;
    }
    //Metodos atributo: empPosition

    public String getEmpPosition() {
        return empPosition.get();
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = new SimpleStringProperty(empPosition);
    }

    public StringProperty EmpPositionProperty() {
        return empPosition;
    }
    //Metodos atributo: empSalary

    public String getEmpSalary() {
        return empSalary.get();
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = new SimpleStringProperty(empSalary);
    }

    public StringProperty EmpSalaryProperty() {
        return empSalary;
    }
    //Metodos atributo: admDate

    public Date getAdmDate() {
        return admDate;
    }

    public void setAdmDate(Date admDate) {
        this.admDate = admDate;
    }
    //Metodos atributo: fireDate

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }
    //Metodos atributo: empBlob

    public Blob getEmpBlob() {
        return empBlob;
    }

    public void setEmpBlob(Blob empBlob) {
        this.empBlob = empBlob;
    }
    //Metodos atributo: empSchDesc

    public String getEmpSchDesc() {
        return empSchDesc.get();
    }

    public void setEmpSchDesc(String empSchDesc) {
        this.empSchDesc = new SimpleStringProperty(empSchDesc);
    }

    public StringProperty EmpSchDescProperty() {
        return empSchDesc;
    }
}
