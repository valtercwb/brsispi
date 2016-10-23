/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import modelDao.UsuarioDAO;

/**
 *
 * @author elenice.carvalho
 */
public class DAOController {

    private static DAOController banco = new DAOController();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

}
