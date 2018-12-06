/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author gateway1
 */
public class producto implements Serializable{

    public int getSuela() {
        return this.suela;
    }

    public void setSuela(int suela) {
        this.suela = suela;
    }

    public float getGramaje() {
        return this.gramaje;
    }

    public void setGramaje(float gramaje) {
        this.gramaje = gramaje;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    private int suela;
    private float gramaje,costo;
    private String descripcion;

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
