/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.reporte;

/**
 *
 * @author gateway1
 */
public class dbreporte extends db {

    public ArrayList<reporte> search_allreport(String tabla, String campo, Connection c) throws ClassNotFoundException, SQLException {
        ArrayList<reporte> array = new ArrayList<reporte>();
        reporte p;
        try {
            Statement smt;
            ResultSet df;
            String query = "select " + campo + " from " + tabla + " order by " + campo;
            // System.out.println(query);
            smt = c.createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                p = new reporte();
                p.setNombre(df.getString(campo));
                array.add(p);
            }
            df.close();
            smt.close();
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        } finally { //Cierre siempre la conexión en un bloque de este tipo
            if ((c != null) && (!c.isClosed())) {
                c.close();
            }
        }
        return array;
    }

}
