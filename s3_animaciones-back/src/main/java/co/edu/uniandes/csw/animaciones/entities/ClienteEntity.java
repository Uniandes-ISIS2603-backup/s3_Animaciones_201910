/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ld.manrique
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable {
    
    private String nombre;
    
    private String informacion;
    
    private String usuario;
    
    private String contrasenia;
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<PropuestaEntity> propuestas = new ArrayList<>(); 
    
    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<CalificacionEntity> calificaciones = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "cliente",fetch=FetchType.LAZY)
    private List<MedioDePagoEntity> mediosPago = new ArrayList<>();


    public ClienteEntity(){
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the propuestas
     */
    public ArrayList<PropuestaEntity> getPropuestas() {
        return propuestas;
    }

    /**
     * @param propuestas the propuestas to set
     */
    public void setPropuestas(ArrayList<PropuestaEntity> propuestas) {
        this.propuestas = propuestas;
    }

    /**
     * @return the calificaciones
     */
    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the mediosPago
     */
    public List<MedioDePagoEntity> getMediosPago() {
        return mediosPago;
    }

    /**
     * @param mediosPago the mediosPago to set
     */
    public void setMediosPago(List<MedioDePagoEntity> mediosPago) {
        this.mediosPago = mediosPago;
    }
    
}
