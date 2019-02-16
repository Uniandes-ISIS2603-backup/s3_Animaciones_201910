package co.edu.uniandes.csw.animaciones.entities;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity.Estado;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author yo (Tengo que repetirlo?)
 * Bueno, ya lo digo otra vez
 * García
 */
@Entity
public class PropuestaEntity extends BaseEntity implements Serializable {
    
    private Integer precio;
    
    private Estado estado;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ArtistaEntity artista;
    
    @PodamExclude
    @OneToOne
    private FacturaEntity factura;
    
    public PropuestaEntity(){
        
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
   
}
