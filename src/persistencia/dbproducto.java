/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.producto;

/**
 *
 * @author gateway1
 */
public class dbproducto extends db {

    public ArrayList<producto> search_all() throws ClassNotFoundException, SQLException {
        ArrayList<producto> array = new ArrayList<producto>();
        producto p;
        try {
            abrir();
            String query = "select c.suela as 'suela',c.gramaje as 'gramaje',c.precio as 'precio', descripcion as 'desc'"
                    + " from costossuela c join Productos p on c.suela=p.producto ";
            
            Statement smt;
            ResultSet df;
            smt = getConexion().createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                p = new producto();
                //System.out.println(df.getInt("suela"));
                p.setSuela(df.getInt("suela"));
                p.setGramaje(df.getFloat("gramaje"));
                p.setCosto(df.getFloat("precio"));
                p.setDescripcion(df.getString("desc"));
                array.add(p);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //cerrar();
        return array;
    }
        public boolean buscaid(int id) throws ClassNotFoundException, SQLException {
        boolean resp=false;
        String query="";
        try {
            abrir();
            query = "select suela from costossuela where suela="+id;
            
            Statement smt;
            ResultSet df;
            smt = getConexion().createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(query +"-"+resp);
        return resp;
    }
    
        public void nuevo_prod(producto p) throws ClassNotFoundException, SQLException {
        PreparedStatement st = null;
        boolean b = false;
        int a = 0;
        try {
            abrir();
            conexion.setAutoCommit(false);
            String s = "insert into costossuela values("+p.getSuela()+","+p.getGramaje()+","+p.getCosto()+")";
            //System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            conexion.commit();
        } catch (Exception e) {
            Logger.getLogger(dbproducto.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }
        st.close();
    }
        public boolean mod_prod(producto p) throws ClassNotFoundException, SQLException {
        PreparedStatement st = null;
        boolean b = false;
        int a = 0;
        try {
            abrir();
            conexion.setAutoCommit(false);
            String s = "update costossuela set gramaje="+p.getGramaje()+", precio="+p.getCosto() +" where suela="+p.getSuela();
            //System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            conexion.commit();
            b = (st!= null)?true:false;
        } catch (Exception e) {
            Logger.getLogger(dbproducto.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }
        st.close();
        return b;
    }
        public boolean del_prod(int p) throws ClassNotFoundException, SQLException {
        PreparedStatement st = null;
        boolean b = false;
        int a = 0;
        try {
            abrir();
            conexion.setAutoCommit(false);
            String s = "delete from costossuela where suela="+p;
            //System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            conexion.commit();
            b = (st!= null)?true:false;
        } catch (Exception e) {
            Logger.getLogger(dbproducto.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }
        st.close();
        return b;
    }
}
