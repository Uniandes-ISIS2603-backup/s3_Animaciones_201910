package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
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
    
    //@PodamExclude
    //@OneToMany(mappedBy = "video", cascade = CascadeType.PERSIST, orphanRemoval = true)
    // Calificaciones
    
    // Setters and getters
}
