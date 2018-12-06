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
import modelo.daoproducto;
import modelo.producto;
import persistencia.dbproducto;

/**
 *
 * @author gateway1
 */
public class Producto implements daoproducto{

    @Override
    public boolean buscaprod(int prod) {
       boolean resp=false;
        dbproducto p = new dbproducto();
        try {
            resp=p.buscaid(prod);
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

  
    @Override
    public void nuevoprod(producto p) {
        dbproducto prod = new dbproducto();
        try {
            prod.nuevo_prod(p);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<producto> getall() {
        dbproducto prod = new dbproducto();
        ArrayList<producto> p=new ArrayList<producto>();
        try {
            p= prod.search_all();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean modiprod(producto prod) {
         boolean resp=false;
        dbproducto p = new dbproducto();
        try {
            resp=p.mod_prod(prod);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public void eliminar(int prod) {
        dbproducto p = new dbproducto();
        try {
            p.del_prod(prod);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Connection getconexion() {
         dbproducto p = new dbproducto();
        try {
            p.abrir();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return p.getConexion();
    }

    
}
