/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gateway1
 */
public class validar {
    public boolean idprod(String id){
        String patt = "[0-9]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(id);
        return match.matches();
}
        public boolean decimal(String cantidad){
        String patt = "[0-9/.]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cantidad);
        return match.matches();
}
    
}
