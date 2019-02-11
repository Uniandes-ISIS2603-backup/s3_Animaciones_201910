/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

/**
 *
 * @author df.perezc
 */

public class ConcursoDetailDTO extends ConcursoDTO implements Serializable{
    
    //
    // ATRIBUTOS
    //
  
    List<AnimacionGanadoraDTO> ganadores = new ArrayList<AnimacionGanadoraDTO>();
    //List<JuradoDTO> jurados = new ArrayList<JuradoDTO>();
    List<Ronda> rondas = new ArrayList<Ronda>();
    
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
     * @return the ganadores
     */
    public List getGanadores(){
        return ganadores;
    }
   
    /**
     * @return the jurados
     */
   // public List getJurados(){   return jurados;}
   
    /**
     * @return the rondas
     */
    public List getRondas(){
        return rondas;
    }
    
 
    /**
     * @param ganadores the ganadores to set
     */
    public void setGanadores(List ganadores)
    {
        this.ganadores = ganadores;
    }
     /**
     * @param jurados the jurados to set
     */
    //public void setJurados(List jurados)
    //{
    //    this.jurados = jurados;
    //}
     /**
     * @param rondas the rondas to set
     */
    public void setGanadores(List rondas)
    {   
        this.rondas = rondas;
    }
    
}
