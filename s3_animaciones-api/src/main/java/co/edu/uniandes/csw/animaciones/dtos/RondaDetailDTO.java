 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfserrano
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
    private List<AnimacionParticipanteDTO> animacionesParticipantes;
    
    public RondaDetailDTO(){
        super();
    }
    @Override
    public RondaEntity toEntity(){
        RondaEntity re = super.toEntity();
        ArrayList<VotacionEntity> votacionesEntity = new ArrayList();
        for(VotacionDTO v : votaciones)
        {
            votacionesEntity.add(v.toEntity());
        }
        re.setVotaciones(votacionesEntity);
        ArrayList<AnimacionParticipanteEntity> animacionesEntity = new ArrayList();
        for(AnimacionParticipanteDTO a : animacionesParticipantes)
        {
           animacionesEntity.add(a.toEntity());
        }
        re.setAnimacionesPartcipantes(animacionesEntity);
        return re;
    }
    public RondaDetailDTO(RondaEntity re){
        super(re);
        if(re != null)
        {
            //TODO revisar esto
            this.animacionesParticipantes = new ArrayList();
            this.votaciones = new ArrayList();
        }
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
    public List<AnimacionParticipanteDTO> getAnimacionesParticipantes() {
        return animacionesParticipantes;
    }

    /**
     * @param animacionesParticipantes the animacionesParticipantes to set
     */
    public void setAnimacionesParticipantes(List<AnimacionParticipanteDTO> animacionesParticipantes) {
        this.animacionesParticipantes = animacionesParticipantes;
    }
}
