/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ld.manrique
 */
public class ClienteDetailDTO extends ClienteDTO implements Serializable{
    
 
    private ArrayList<PropuestaDTO> propuestas;
    private ArrayList<CalificacionDTO> calificaciones;
    
    
    public ClienteDetailDTO()
    {
        super();
    }
    
  /**
     * Crea un objeto ClienteDetailDTO a partir de un objeto ClienterEntity
     * incluyendo los atributos de ClienteDTO.
     *
     * @param entity Entidad ClienteEntity desde la cual se va a crear el
     * nuevo objeto.
     *
     */
    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
        if (entity != null) {
            propuestas = new ArrayList<>();
            for (PropuestaEntity entityPropuestas : entity.getPropuestas()) {
                propuestas.add(new PropuestaDTO(entityPropuestas));
            }
            calificaciones = new ArrayList();
            for (CalificacionEntity entityCalificacion : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(entityCalificacion));
            }
        }
    }

    /**
     * Convierte un objeto ClienteDetailDTO a ClienteEntity incluyendo los
     * atributos de ClienteDTO.
     *
     * @return Nueva objeto ClienteEntity.
     *
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity entity = super.toEntity();
        if (propuestas != null) {
            ArrayList<PropuestaEntity> propuestasEntity = new ArrayList<>();
            for (PropuestaDTO dtoPropuesta : propuestas) {
                propuestasEntity.add(dtoPropuesta.toEntity());
            }
            entity.setPropuestas(propuestasEntity);
        }
        if (calificaciones != null) {
            ArrayList<CalificacionEntity> calificacionesEntity = new ArrayList<>();
            for (CalificacionDTO dtoCalificacion : calificaciones) {
                calificacionesEntity.add(dtoCalificacion.toEntity());
            }
            entity.setCalificaciones(calificacionesEntity);
        }
        return entity;
    }
    
    


    public ArrayList<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestass(ArrayList<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
    
        public ArrayList<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setMediosDePago(ArrayList<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
