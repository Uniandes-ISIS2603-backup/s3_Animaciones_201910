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

    private Long id;

    private String comentario;
    private Integer calificacion;
   /*
    * Relación a una animación
    * dado que esta tiene cardinalidad 1.
     */
    private AnimacionDTO animacion;
    
       /*
    * Relación a un cliente
    * dado que esta tiene cardinalidad 1.
     */
        private ClienteDTO cliente;
    
    public CalificacionDTO() {

    }
    
 /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entity: Es la entidad que se va a convertir a DTO
     */
    public CalificacionDTO(CalificacionEntity entity) {
          if (entity != null) {
            this.id = entity.getId();
            this.comentario = entity.getComentario();
            this.calificacion = entity.getCalificacion();

            if (entity.getAnimacion()!= null) {
                this.animacion = new AnimacionDTO(entity.getAnimacion());
            } else {
                this.animacion = null;
            }
            
            
            
            if (entity.getCliente()!= null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            } else {
                this.cliente = null;
            }
        }
    }



    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
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

     /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
       entity.setId(this.id);
        entity.setCalificacion(this.calificacion);
        entity.setComentario(this.comentario);
           if (this.animacion != null) {
            entity.setAnimacion(this.animacion.toEntity());}
             if (this.cliente != null) {
            entity.setCliente(this.cliente.toEntity());}
        
        return entity;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
