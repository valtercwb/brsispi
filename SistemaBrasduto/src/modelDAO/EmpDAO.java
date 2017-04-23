/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.City;
import model.CityState;
import model.Country;
import model.Dep;
import model.EmpStatus;
import model.Employee;
import model.Gen;
import model.MaritalStatus;
import model.SchLevel;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class EmpDAO extends DAO {

    public static Boolean isUniqCodeStatus = false;
    public static Boolean isUniqCpfStatus = false;
    public static Boolean isUniqPisStatus = false;
    public static Boolean isUniqCpStatus = false;
    public static Boolean isUniqMatStatus = false;

    public EmpDAO() {
        super();
    }

    public int UpdateEmp(Connection conector, Employee emp, int resultado) {

        try {
            pst = conector.prepareStatement(
                    "UPDATE funcionario "
                    + " SET fun_mat = ?,  "
                    + " fun_nome = ?,  "
                    + " fun_genero= ?, "
                    + " fun_data_nasc = ?,  "
                    + " fun_estado_civil = ?,  "
                    + " fun_telefone_fixo = ?,  "
                    + " fun_telefone_cel = ?,  "
                    + " fun_email = ?,  "
                    + " fun_endereco = ?,  "
                    + " fun_end_cep = ?,  "
                    + " fun_bairro = ?, "
                    + " fun_cidade = ?, "
                    + " fun_estado = ?, "
                    + " fun_pais = ?, "
                    + " fun_escolaridade = ?, "
                    + " fun_escDesc = ?, "
                    + " fun_rg = ?, "
                    + " fun_cpf = ?, "
                    + " fun_num_cp = ?, "
                    + " fun_pis = ?, "
                    + " fun_cnh = ?,  "
                    + " fun_trans = ?,  "
                    + " fun_status = ?,  "
                    + " fun_departamento = ?,  "
                    + " fun_cargo = ?,  "
                    + " fun_salario = ?,  "
                    + " fun_data_adm = ?,  "
                    + " fun_data_dem = ?,  "
                    + " fun_foto = ?  "
                    + " WHERE fun_codigo = ?"        
            );
            pst.setString(1, emp.getEmpCode());
            pst.setString(2, emp.getEmpName());
            pst.setInt(3, emp.getGen().getGenId());
            pst.setDate(4, emp.getEmpBirthDate());
            pst.setInt(5, emp.getMaritalStatus().getMarStaId());
            pst.setString(6, emp.getEmpPhoneFix());
            pst.setString(7, emp.getEmpPhoneCel());
            pst.setString(8, emp.getEmpEmail());
            pst.setString(9, emp.getEmpAdress());
            pst.setString(10, emp.getEmpZipCode());
            pst.setString(11, emp.getEmpSub());
            pst.setInt(12, emp.getCity().getCityId());
            pst.setInt(13, emp.getCityState().getCityStateId());
            pst.setInt(14, emp.getCountry().getCityCountryId());
            pst.setInt(15, emp.getSchLevel().getSchLevelId());
            pst.setString(16, emp.getEmpSchDesc());
            pst.setString(17, emp.getEmpRg());
            pst.setString(18, emp.getEmpCpf());
            pst.setString(19, emp.getEmpCp());
            pst.setString(20, emp.getEmpPis());
            pst.setString(21, emp.getEmpCnh());
            pst.setString(22, emp.getEmpTrans());
            pst.setInt(23, emp.getEmpStatus().getEmpStaId());
            pst.setInt(24, emp.getEmpDep().getDepCode());
            pst.setString(25, emp.getEmpPosition());
            pst.setString(26, emp.getEmpSalary());
            pst.setDate(27, emp.getAdmDate());
            pst.setDate(28, emp.getFireDate());

            if (emp.imagePath != null) {
                InputStream is;
                is = new FileInputStream(new File(emp.imagePath));
                pst.setBlob(29, is);
            } else if (emp.imagePath == null) {
                pst.setBlob(29, (Blob) null);
            }
            pst.setInt(30, resultado);
            return pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int DeleteItem(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM funcionario "
                    + "WHERE fun_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void FillEmpInfo(Connection conector, ObservableList<Employee> listaEmp) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.fun_codigo,"
                    + "A.fun_mat, "
                    + "A.fun_nome, "
                    + "A.fun_genero, "
                    + "B.gen_nome, "
                    + "A.fun_data_nasc, "
                    + "A.fun_estado_civil, "
                    + "C.est_civil_nome, "
                    + "A.fun_telefone_fixo, "
                    + "A.fun_telefone_cel, "
                    + "A.fun_email, "
                    + "A.fun_endereco, "
                    + "A.fun_end_cep, "
                    + "A.fun_bairro, "
                    + "A.fun_cidade, "
                    + "D.cid_nome, "
                    + "A.fun_estado, "
                    + "E.est_nome, "
                    + "A.fun_pais, "
                    + "F.pais_nome, "
                    + "A.fun_escolaridade, "
                    + "G.esc_nome, "
                    + "A.fun_escDesc, "
                    + "A.fun_rg, "
                    + "A.fun_cpf, "
                    + "A.fun_num_cp, "
                    + "A.fun_pis, "
                    + "A.fun_cnh, "
                    + "A.fun_trans, "
                    + "A.fun_status, "
                    + "H.fun_status_nome, "
                    + "A.fun_departamento, "
                    + "I.dep_nome, "
                    + "A.fun_cargo, "
                    + "A.fun_salario, "
                    + "A.fun_data_adm, "
                    + "A.fun_data_dem, "
                    + "A.fun_foto "
                    + "FROM funcionario A "
                    + "INNER JOIN genero B "
                    + "ON (A.fun_genero = B.gen_codigo) "
                    + "INNER JOIN estado_civil C "
                    + "ON (A.fun_estado_civil = C.est_civil_codigo) "
                    + "INNER JOIN cidade D "
                    + "ON (A.fun_cidade = D.cid_codigo) "
                    + "INNER JOIN estado E "
                    + "ON (A.fun_estado = E.est_codigo) "
                    + "INNER JOIN pais F "
                    + "ON (A.fun_pais = F.pais_codigo) "
                    + "INNER JOIN escolaridade G "
                    + "ON (A.fun_escolaridade = G.esc_codigo) "
                    + "INNER JOIN fun_status H "
                    + "ON (A.fun_status = H.fun_status_codigo) "
                    + "INNER JOIN departamento I "
                    + "ON (A.fun_departamento = I.dep_codigo) "
            );
            while (resultado.next()) {
                listaEmp.add(
                        new Employee(
                                resultado.getInt("fun_codigo"),
                                resultado.getString("fun_mat"),
                                resultado.getString("fun_nome"),
                                new Gen(resultado.getInt("fun_genero"),
                                        resultado.getString("gen_nome")),
                                resultado.getDate("fun_data_nasc"),
                                new MaritalStatus(resultado.getInt("fun_estado_civil"),
                                        resultado.getString("est_civil_nome")),
                                resultado.getString("fun_telefone_fixo"),
                                resultado.getString("fun_telefone_cel"),
                                resultado.getString("fun_email"),
                                resultado.getString("fun_endereco"),
                                resultado.getString("fun_end_cep"),
                                resultado.getString("fun_bairro"),
                                new City(resultado.getInt("fun_cidade"),
                                        resultado.getString("cid_nome")),
                                new CityState(resultado.getInt("fun_estado"),
                                        resultado.getString("est_nome")),
                                new Country(resultado.getInt("fun_pais"),
                                        resultado.getString("pais_nome")),
                                new SchLevel(resultado.getInt("fun_escolaridade"),
                                        resultado.getString("esc_nome")),
                                resultado.getString("fun_escDesc"),
                                resultado.getString("fun_rg"),
                                resultado.getString("fun_cpf"),
                                resultado.getString("fun_num_cp"),
                                resultado.getString("fun_pis"),
                                resultado.getString("fun_cnh"),
                                resultado.getString("fun_trans"),
                                new EmpStatus(resultado.getInt("fun_status"),
                                        resultado.getString("fun_status_nome")),
                                new Dep(resultado.getInt("fun_departamento"),
                                        resultado.getString("dep_nome")),
                                resultado.getString("fun_cargo"),
                                resultado.getString("fun_salario"),
                                resultado.getDate("fun_data_adm"),
                                resultado.getDate("fun_data_dem"),
                                resultado.getBlob("fun_foto"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUniq(Employee emp) {

        boolean isUniqCode = false;
        isUniqCodeStatus = isUniqCode;
        try {
            pst = conector.prepareStatement("select * from funcionario where fun_mat = ?");
            pst.setString(1, emp.getEmpCode());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um funcionario cadastrado com essa matricula");
                msg.show();
                return isUniqCode;
            }
            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqCodeStatus = isUniqCode;
        } catch (SQLException e) {
        }
        return isUniqCode;
    }

    public void SaveEmpInput(Connection connection, Employee emp) {

        if (isUniq(emp)) {
        try {
            pst = conector.prepareStatement("INSERT INTO funcionario (fun_mat, fun_nome, fun_genero , fun_data_nasc, fun_estado_civil,"
                    + "fun_telefone_fixo, fun_telefone_cel , fun_email, fun_endereco, fun_end_cep, fun_bairro, fun_cidade,fun_estado,"
                    + "fun_pais ,fun_escolaridade , fun_escDesc , fun_rg , fun_cpf , fun_num_cp , fun_pis, fun_cnh , fun_trans, fun_status,"
                    + "fun_departamento, fun_cargo, fun_salario, fun_data_adm, fun_data_dem, fun_foto) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            pst.setString(1, emp.getEmpCode());
            pst.setString(2, emp.getEmpName());
            pst.setInt(3, emp.getGen().getGenId());
            pst.setDate(4, emp.getEmpBirthDate());
            pst.setInt(5, emp.getMaritalStatus().getMarStaId());
            pst.setString(6, emp.getEmpPhoneFix());
            pst.setString(7, emp.getEmpPhoneCel());
            pst.setString(8, emp.getEmpEmail());
            pst.setString(9, emp.getEmpAdress());
            pst.setString(10, emp.getEmpZipCode());
            pst.setString(11, emp.getEmpSub());
            pst.setInt(12, emp.getCity().getCityId());
            pst.setInt(13, emp.getCityState().getCityStateId());
            pst.setInt(14, emp.getCountry().getCityCountryId());
            pst.setInt(15, emp.getSchLevel().getSchLevelId());
            pst.setString(16, emp.getEmpSchDesc());
            pst.setString(17, emp.getEmpRg());
            pst.setString(18, emp.getEmpCpf());
            pst.setString(19, emp.getEmpCp());
            pst.setString(20, emp.getEmpPis());
            pst.setString(21, emp.getEmpCnh());
            pst.setString(22, emp.getEmpTrans());
            pst.setInt(23, emp.getEmpStatus().getEmpStaId());
            pst.setInt(24, emp.getEmpDep().getDepCode());
            pst.setString(25, emp.getEmpPosition());
            pst.setString(26, emp.getEmpSalary());
            pst.setDate(27, emp.getAdmDate());
            pst.setDate(28, emp.getFireDate());
          
            if (emp.imagePath != null) {
                InputStream is;
                is = new FileInputStream(new File(emp.imagePath));
                pst.setBlob(29, is);
            } else {
                pst.setBlob(29, (Blob) null);
            }
            pst.executeUpdate();
            pst.close();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
}
