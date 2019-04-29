/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.persistence.ConcursoPersistence;
import co.edu.uniandes.csw.animaciones.persistence.JuradoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.perezc
 */

@Stateless
public class ConcursoJuradoLogic {
    @Inject
    private ConcursoPersistence cp;
    
    @Inject
    private JuradoPersistence jp;
    
     public JuradoEntity addJurado(Long concursoId, Long juradoId) {
        ConcursoEntity ce = cp.find(concursoId);
        JuradoEntity je = jp.find(juradoId);
        ce.getJurados().add(je);
        return je;
    }
    
    public List<JuradoEntity> getJurados(Long concursoId) {
        return cp.find(concursoId).getJurados();
    }
    
    public JuradoEntity getJurado(Long concursoId, Long juradoId) {
        List<JuradoEntity> list = getJurados(concursoId);
        JuradoEntity je = jp.find(juradoId);
        int i = list.indexOf(je);
        if(i >= 0){
            return list.get(i);
        }
        return null;
    }
    
    
}
