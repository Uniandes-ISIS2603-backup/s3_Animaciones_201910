/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ld.manrique
 */
public class CalificacionDTO implements Serializable {

    private Integer id;

    private String comentario;
    private Integer calificacion;

    public CalificacionDTO() {

    }
    
    public CalificacionDTO(CalificacionEntity ce) {
        
    }

//    public CalificacionDTO(CalificacionEntity entity) {
//        entity.setCalificacion(calificacion);
//        entity.setComentario(comentario);
//    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setCalificacion(calificacion);
        entity.setComentario(comentario);
        return entity;
    }
}
