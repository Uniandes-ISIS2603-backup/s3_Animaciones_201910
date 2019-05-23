/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import java.io.Serializable;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import java.util.List;
import java.util.ArrayList;

/**
 * clase que maneja el detalle del concurso
 *
 * @author dfperezc
 */
public class ConcursoDetailDTO extends ConcursoDTO implements Serializable {

    //
    // ATRIBUTOS
    //
    /**
     * atributo que maneja la lista de jurados escogidos para el concurso
     */
    private List<JuradoDTO> jurados = new ArrayList<JuradoDTO>();

    /**
     * atributo que maneja la lista de rondas que posee el concurso
     */
    private List<RondaDTO> rondas = new ArrayList<RondaDTO>();

    //
    //CONSTRUCTOR
    //
    /**
     * metodo que contruye un detalle vacio de concurso constructores
     */
    public ConcursoDetailDTO() {

    }

    /**
     * medtodo que conctruye un detalle de concurso a partir de una como entidad
     * equivalente a concurso
     *
     * @param ce la entidad de concurso respectiva
     */
    public ConcursoDetailDTO(ConcursoEntity ce) {
        super(ce);
        if (ce != null) {
            if (ce.getJurados() != null) {
                for (JuradoEntity je : ce.getJurados()) {
                    jurados.add(new JuradoDTO(
                            je
                    ));
                }
            }
        }
        if (ce != null) {
            if (ce.getRondas() != null) {
                for (RondaEntity re : ce.getRondas()) {
                    rondas.add(new RondaDTO(
                            re
                    ));
                }
            }
        }
    }

    //
    //METODOS
    //
    public ConcursoEntity toEntity() {
        ConcursoEntity ce = super.toEntity();
        if (jurados != null) {
            ArrayList<JuradoEntity> listJus = new ArrayList<>();
            for (JuradoDTO cj : jurados) {
                listJus.add(cj.toEntity());
            }
            ce.setJurados(listJus);
        }
        if (rondas != null) {
            ArrayList<RondaEntity> listRos = new ArrayList<>();
            for (RondaDTO rd : rondas) {
                listRos.add(rd.toEntity());
            }
            ce.setRondas(listRos);
        }
        return ce;
    }

    /**
     * @return the jurados
     */
    public List<JuradoDTO> getJurados() {
        return jurados;
    }

    /**
     * @param jurados the jurados to set
     */
    public void setJurados(List<JuradoDTO> jurados) {
        this.jurados = jurados;
    }

    /**
     * @return the rondas
     */
    public List<RondaDTO> getRondas() {
        return rondas;
    }

    /**
     * @param rondas the rondas to set
     */
    public void setRondas(List<RondaDTO> rondas) {
        this.rondas = rondas;
    }

}
