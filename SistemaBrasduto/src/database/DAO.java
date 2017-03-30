/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class DAO {

    protected Connection conector = DbConnection.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement pst;   

    public DAO() {
    }
}
