/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author df.serrano
 */
public class RondaDetailDTO extends RondaDTO implements Serializable {
    
 /**
 *
 * Esta lista de tipo VOtacionDTO contiene las votaciones que han hecho los jurados en esa ronda
 */
    private List<VotacionDTO> votaciones;
    
 /**
 *
 * Esta lista de tipo AnimacionDTO contiene las animaciones que están participando en esa ronda
 */
    private List<AnimacionDTO> animacionesParticipantes;
    
    public RondaDetailDTO(){
        
    }

    /**
     * @return the votaciones
     */
    public List<VotacionDTO> getVotaciones() {
        return votaciones;
    }

    /**
     * @param votaciones the votaciones to set
     */
    public void setVotaciones(List<VotacionDTO> votaciones) {
        this.votaciones = votaciones;
    }

    /**
     * @return the animacionesParticipantes
     */
    public List<AnimacionDTO> getAnimacionesParticipantes() {
        return animacionesParticipantes;
    }

    /**
     * @param animacionesParticipantes the animacionesParticipantes to set
     */
    public void setAnimacionesParticipantes(List<AnimacionDTO> animacionesParticipantes) {
        this.animacionesParticipantes = animacionesParticipantes;
    }
}
