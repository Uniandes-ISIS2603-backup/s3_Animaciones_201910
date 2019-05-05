/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.persistence.ConcursoPersistence;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author dfperezc
 */
@Stateless
public class ConcursoRondaLogic {
    
    @Inject
    private ConcursoPersistence cp;
    
    @Inject
    private RondaPersistence rp;
    
     public RondaEntity addRonda(Long concursoId, Long rondaId) {
        ConcursoEntity ce = cp.find(concursoId);
        RondaEntity re = rp.find(rondaId);
        ce.getRondas().add(re);
        return re;
    }
    
    public List<RondaEntity> getRondas(Long concursoId) {
        return cp.find(concursoId).getRondas();
    }
    
    public RondaEntity getRonda(Long concursoId, Long rondaId) {
        List<RondaEntity> list = getRondas(concursoId);
        RondaEntity re = rp.find(rondaId);
        int i = list.indexOf(re);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
}
