/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;

import co.edu.uniandes.csw.animaciones.dtos.ConcursoDTO;
import java.util.List;
import java.util.ArrayList;

public class ConcursoDetailDTO extends ConcursoDTO implements Serializable{
    
    //
    // ATRIBUTOS
    //
  
    private List<JuradoDTO> jurados = new ArrayList<JuradoDTO>();
    private List<RondaDTO> rondas = new ArrayList<RondaDTO>();
    
    //
    //CONSTRUCTOR
    //
    
    /**
     * constructor
     */
    public ConcursoDetailDTO(){
        
    }
    
    //
    //METODOS
    //

    /**
     * @return the jurados
     */
    public List<JuradoDTO> getJurados() {
        return jurados;
    }

    /**
     * @param jurados the jurados to set
     */
    public void setJurados(List<JuradoDTO> jurados) {
        this.jurados = jurados;
    }

    /**
     * @return the rondas
     */
    public List<RondaDTO> getRondas() {
        return rondas;
    }

    /**
     * @param rondas the rondas to set
     */
    public void setRondas(List<RondaDTO> rondas) {
        this.rondas = rondas;
    }
   
   
    
}
