/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author gateway1
 */
public interface daoreporte {
    public ArrayList<reporte> getallnombre(String tabla,String campo,Connection c);
    public Connection getconexion(String bd);
}
