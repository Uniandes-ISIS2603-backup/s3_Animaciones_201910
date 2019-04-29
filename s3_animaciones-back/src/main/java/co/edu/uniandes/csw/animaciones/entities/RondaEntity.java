/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.serrano
 */
@Entity
public class RondaEntity extends BaseEntity implements Serializable {

    /**
     * @return the votaciones
     */
    public ArrayList <VotacionEntity> getVotaciones() {
        return votaciones;
    }

    /**
     * @param votaciones the votaciones to set
     */
    public void setVotaciones(ArrayList <VotacionEntity> votaciones) {
        this.votaciones = votaciones;
    }

    /**
     * @return the animacionesPartcipantes
     */
    public ArrayList<AnimacionParticipanteEntity> getAnimacionesPartcipantes() {
        return animacionesPartcipantes;
    }

    /**
     * @param animacionesPartcipantes the animacionesPartcipantes to set
     */
    public void setAnimacionesPartcipantes(ArrayList<AnimacionParticipanteEntity> animacionesPartcipantes) {
        this.animacionesPartcipantes = animacionesPartcipantes;
    }

    /**
     * @return the concurso
     */
    public ConcursoEntity getConcurso() {
        return concurso;
    }

    /**
     * @param concurso the concurso to set
     */
    public void setConcurso(ConcursoEntity concurso) {
        this.concurso = concurso;
    }

    private Integer numero;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;


    public RondaEntity() {

    }

    @PodamExclude
    @ManyToOne()
    private ConcursoEntity concurso;

    
    @PodamExclude
    @OneToMany(mappedBy = "ronda", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<AnimacionParticipanteEntity> animacionesPartcipantes = new ArrayList<>();
    @PodamExclude
    @OneToMany(mappedBy = "ronda")
    private ArrayList <VotacionEntity> votaciones = new ArrayList<>();
    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
