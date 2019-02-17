/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author by.cuta10
 */
public class JuradoDTO implements Serializable{
    
    String credencial;
    String usuario;
    String contraseña;
    Integer id;
    private List<VotacionDTO> votaciones;
    
    public JuradoDTO (){
    votaciones = new ArrayList<VotacionDTO>() ;
}
    
    public String getCredencial (){
        return credencial;
    }
    public void setCredenciales (String pCredencial){
        credencial = pCredencial;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String pUsuario){
        usuario = pUsuario;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña (String pContraseña){
        contraseña = pContraseña;
    }
    public int getId (){
        return id;
    }
    public void setId (int pId){
        id = pId;
    }
    public List<VotacionDTO> getVotaciones (){
        return votaciones;
    }
    public void setVotaciones (VotacionDTO pVotacion){
        votaciones.add(pVotacion);
    }
}
