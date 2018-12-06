/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.daoreporte;
import modelo.reporte;
import persistencia.dbreporte;

/**
 *
 * @author gateway1
 */
public class Reportes implements daoreporte{

    @Override
    public Connection getconexion(String bd) {
        dbreporte rep = new dbreporte();
        
            try {
                if(bd.equals("cliente")|| bd.equals("agente")){
                rep.abrircliente();
                }else if(bd.equals("linea") ){
                rep.abrir();}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            return rep.getConexion();
    }

    @Override
    public ArrayList<reporte> getallnombre(String tabla, String campo, Connection c) {
        dbreporte rep = new dbreporte();
        ArrayList<reporte> resp = new ArrayList<reporte>();
        try {
            resp=rep.search_allreport(tabla,campo, c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
}
