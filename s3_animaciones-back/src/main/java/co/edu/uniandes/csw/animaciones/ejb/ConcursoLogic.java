/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ConcursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la logica de un concurso
 *
 * @author df.perezc
 */
@Stateless
public class ConcursoLogic {

    @Inject
    private ConcursoPersistence cp;

    /**
     * medoto que crea la entidad de un concurso
     *
     * @param ce es el concurso qeu se quiere crear
     * @return el concurso que se crea
     * @throws BusinessLogicException se lanza si el tema es demasiado largo
     */
    public ConcursoEntity create(ConcursoEntity ce) throws BusinessLogicException {
        if (ce==null||ce.getTecnica() == null || ce.getTema() == null || ce.getId() == null || ce.getOrganizador() == null || ce.getReglas() == null) {
            throw new BusinessLogicException("ningun atributo debe ser null");
        }
        if (ce.getTema().length() <= 1) {
            throw new BusinessLogicException("el concurso debe tener un tema " + ce.getTema());
        }

        ce = cp.create(ce);
        return ce;
    }

    /**
     * metodo que retorna un concurso teniendo su id
     *
     * @param concursoEntityId la id del concurso buscado
     * @return el concurso correspondiente a la id ingresada
     */
    public ConcursoEntity find(Long concursoEntityId) {
        return cp.find(concursoEntityId);
    }

    /**
     * metodo que retorna la lista de todas las entidades de concursos
     *
     * @return la lista del entidades de los concursos
     */
    public List<ConcursoEntity> findAll() {
        List<ConcursoEntity> list = cp.findAll();
        return list;
    }

    /**
     * metodo que actualiza la entidad un concurso
     *
     * @param ce la entidad que va a actualizar el concurso
     * @return la entidad actualizada
     */
     public ConcursoEntity update(ConcursoEntity ce){
        return cp.update(ce);
    }
    /**
     * metodo que borra la entidad de un concurso teniendo su id
     *
     * @param ceId la id de la entidad del concurso a eliminar
     */
    //public void delete(Long ceId) {
    //    cp.delete(ceId);
    //}
    // el concurso no debe borrarse
}
