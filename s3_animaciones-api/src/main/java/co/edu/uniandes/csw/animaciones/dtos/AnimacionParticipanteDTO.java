/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
/**
 * es la clase que maneja el detail de la animaicion que participa en un concurso
 * @author df.perezc
 */
public class AnimacionParticipanteDTO extends AnimacionDTO implements Serializable
{
    //
    // ATRIBUTOS
    //
  
    // atributo que indica puntaje que le otorgan los jueces a la animacion
    private Double puntaje;
    
    // atributo que indica que puesto ocupa la animacion en el concurso en base al puntaje
    private Integer puesto;
    
    //atributo que indica si la animacion pasa a segunda ronda (true en caso de hacerlo 
    private Boolean finalista;
    
    //atributo que indica cuanto dinero gana la animacion
    private Integer dinero;
    
    
    //
    //CONSTRUCTOR
    //
    /**
     * metodo que construye una animacion participante vacia
     */
    public AnimacionParticipanteDTO(){
        
    }
    //
    //METODOS
    //

    /**
     * metodo que retorna el puntaje de la animacion participante
     * @return the puntaje
     */
    public Double getPuntaje() {
        return puntaje;
    }

    /**
     * metodo que modifica el puntaje de la animacion participante
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * metodo que retorna el puesto de la animacion participante
     * @return the puesto
     */
    public Integer getPuesto() {
        return puesto;
    }

    /**
     * metodo que modifica el puesto de la animacion participante
     * @param puesto the puesto to set
     */
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    /**metodo que true si la animacion participante pasa a segunda ronda
     * @return the finalista
     */
    public Boolean getFinalista() {
        return finalista;
    }

    /**metodo que modifica el atributo que indica si la animacion pasa a la siguiente ronda
     * @param finalista the finalista to set
     */
    public void setFinalista(Boolean finalista) {
        this.finalista = finalista;
    }

    /**
     * metodo que retorna el dinero obtenido por la animacionParticipante, como premio
     * @return the dinero
     */
    public Integer getDinero() {
        return dinero;
    }

    /**
     * metodo que modifica el dinero obtenido por animacion participante, como premio
     * @param dinero the dinero to set
     */
    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

     
    
}
