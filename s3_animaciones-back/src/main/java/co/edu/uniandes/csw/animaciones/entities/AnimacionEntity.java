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
 * @author Nicolas Alvarado
 */
@Entity
public class AnimacionEntity extends BaseEntity implements Serializable {
    
    private String nombre;
    private String descripcion;
    private Integer precio;
    private String tecnica;
    private String tags;
    private Double calificacion;
    private String link;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ArtistaEntity artista;
    
    @PodamExclude
    @OneToMany(mappedBy = "animacion", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<CalificacionEntity> calificaciones = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArtistaEntity getArtista() {
        return artista;
    }

    public void setArtista(ArtistaEntity artista) {
        this.artista = artista;
    }

    public ArrayList<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    
}
