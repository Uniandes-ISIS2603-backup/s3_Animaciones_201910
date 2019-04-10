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
    
    /**
     * Atributo que contien la credencial del jurado
     */
    String credencial;
    /**
     * Atributo que contiene el nombre del jurado
     */
    String usuario;
    /**
     * Atributo que contiene la contrasena del jurado
     */
    String contrasena;
    /**
     * Atributo que contiene el id del jurado
     */
    Long id;
    /**
     * Atributo que contiene el DTOConcurso
     */
    ConcursoDTO concurso;
    /**
     * Atributo que contiene las votaciones que el jurado ha hecho
     */
    private List<VotacionDTO> votaciones;
    
    /**
     * Contructor vacio de Jurado DTO
     */
    public JuradoDTO (){}
    
    /**
     * Metodo que permite la creacion de un JuradoDTO a partir de un jurado
     * entity
     * @param j JuradEntity que entra como parametro
     */
    public JuradoDTO (JuradoEntity j){
        this.credencial=j.getCredencial();
        this.usuario=j.getUsuario();
        this.id=j.getId(); 
    }
    
    /**
     * Metodo que genera un Enitty de Jurado
     * @return el Entity de Jurado
     */
    public JuradoEntity toentity(){
     JuradoEntity r=new JuradoEntity();
     r.setContrasena(this.contrasena);
     r.setUsuario(this.usuario);
     r.setCredencial(this.credencial);
     return r;
    }
    
    /**
     * Metodo que retorna el conccursoDTO
     * @return el atributo concurso
     */
    public ConcursoDTO getConcursoDTO (){
        return concurso;
    }
    
    /**
     * Cambia el valor de concurso con el nuevo concurso que entra como parametro
     * @param pConcurso nuevo concursoDTO 
     */
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
    public void setCredencial (String pCredencial){
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
    /**
     * Obtiene la contrasena del Jurado
     * @return  contrasena
     */
    public String getContrasena(){
        return contrasena;
    }
    /**
     * Cambia la contrasena por la que entra como parametro
     * @param pContrasena  
     */
    public void setContrasena (String pContrasena){
        contrasena = pContrasena;
    }
    /**
     * Retorna el id del jurado
     * @return Id 
     */
    public Long getId (){
        return id;
    }
    /**
     * Cambia el id del jurado
     * @param pId 
     */
    public void setId (Long pId){
        id = pId;
    }
    /**
     * Retorna la lista de votaciones del jurado
     * @return Lista de votaciones
     */
    public List<VotacionDTO> getVotaciones (){
        return votaciones;
    }
    /**
     * Agrega una votacion a la lista de votaciones del jurado con la votaciones
     * @param pVotacion 
     */
    public void setVotaciones (VotacionDTO pVotacion){
        votaciones.add(pVotacion);
    }
    /**
     * Da un nuevo jurado entity
     * @return  jurado entity
     */
    public JuradoEntity juradoEntity(){
    return new JuradoEntity();

    }
    
}
