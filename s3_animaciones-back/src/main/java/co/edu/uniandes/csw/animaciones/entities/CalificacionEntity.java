/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ld.manrique
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable{
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private AnimacionEntity animacion;
    
     @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClienteEntity cliente ;
    
    
    private String comentario;
            
    private Integer calificacion;
            
            public CalificacionEntity()
            {
                
            }
            
    //  public Integer getId() {
    //    return id;
   // }

  //  public void setId(Integer id) {
  //      this.id = id;
 //   }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public AnimacionEntity getAnimacion() {
        return animacion;
    }

    public void setAnimacion(AnimacionEntity animacion) {
        this.animacion = animacion;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
 
}
