/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author by.cuta10
 */
@Entity
public class JuradoEntity extends BaseEntity implements Serializable{
    
    private String credencial;
    private String usuario;
    private String contraseña;

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCredencial() {
        return credencial;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

   
}
