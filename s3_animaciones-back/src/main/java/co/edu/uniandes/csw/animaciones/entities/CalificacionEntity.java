/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
    
   /// private Integer id;

  
    
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
    
    
    
 
}
