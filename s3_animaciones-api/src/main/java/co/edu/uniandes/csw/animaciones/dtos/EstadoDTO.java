/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

/**
 *
 * @author by.cuta
 */
public class EstadoDTO {
    
    String mensaje;
    
    public EstadoDTO(){
    }
    
    public EstadoDTO(String mensaje){
        this.mensaje=mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje=mensaje;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
}
