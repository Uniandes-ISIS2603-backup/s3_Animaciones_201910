/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author by.cuta10
 */
public class JuradoDTO implements Serializable{
    
    
    String credencial;
    String usuario;
    String contrasena;
    Long id;
    ConcursoDTO concurso;
    private List<VotacionDTO> votaciones;
    
    
    public JuradoDTO (){}
    
    public JuradoDTO (JuradoEntity j){
        this.credencial=j.getCredencial();
        this.usuario=j.getUsuario();
        this.id=j.getId(); 
    }
    
    public JuradoEntity toentity(){
     JuradoEntity r=new JuradoEntity();
     r.setContraseña(this.getContraseña());
     r.setUsuario(usuario);
     r.setCredencial(credencial);
     return r;
    }
    
    public ConcursoDTO getConcursoDTO (){
        return concurso;
    }
    
    public void setConcursoDTO (ConcursoDTO pConcurso){
        concurso = pConcurso;
    }
    
    /**
     * 
     * @return  la credencial 
     */
    public String getCredencial (){
        return credencial;
    }
    
    /**
     * @param pCredencial la credencial a cambiar
     */
    public void setCredenciales (String pCredencial){
        credencial = pCredencial;
    }
    
    /**
     * @return  el usuario
     */
    public String getUsuario(){
        return usuario;
    }
    
    /**
     * @param pUsuario 
     */
    public void setUsuario(String pUsuario){
        usuario = pUsuario;
    }
    public String getContraseña(){
        return contrasena;
    }
    public void setContraseña (String pContrasena){
        contrasena = pContrasena;
    }
    public Long getId (){
        return id;
    }
    public void setId (Long pId){
        id = pId;
    }
    public List<VotacionDTO> getVotaciones (){
        return votaciones;
    }
    public void setVotaciones (VotacionDTO pVotacion){
        votaciones.add(pVotacion);
    }
    
    public JuradoEntity juradoEntity(){
        JuradoEntity theOne = new JuradoEntity();
        
        return theOne;
    }
    
}
