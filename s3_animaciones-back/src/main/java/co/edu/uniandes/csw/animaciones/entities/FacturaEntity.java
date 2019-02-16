
package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author PORYGON Z (García)
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable {
    
    private Integer idAnim;
    
    private Estado estado;    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    //@OneToOne(mappedBy="factura", fetch=FetchType.LAZY)
    //private MedioDePagoEntity medioDePago;
    
    @PodamExclude
    @OneToOne
    private PropuestaEntity propuesta;
    
    public enum Estado{
        ENPROCESO, ACEPTADO, RECHAZADO
    }
    
    public FacturaEntity(){
        
    }

    
    /**
     * @return the idAnim
     */
    public Integer getIdAnim() {
        return idAnim;
    }

    /**
     * @param idAnim the idAnim to set
     */
    public void setIdAnim(Integer idAnim) {
        this.idAnim = idAnim;
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

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
