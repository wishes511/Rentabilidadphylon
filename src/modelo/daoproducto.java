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
public interface daoproducto {
    public boolean buscaprod(int prod);
    public boolean modiprod(producto prod);
    public void nuevoprod(producto p);
    public ArrayList<producto> getall();
    public void eliminar(int p);
    public Connection getconexion();
}
