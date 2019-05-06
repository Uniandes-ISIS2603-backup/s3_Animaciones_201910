package co.edu.uniandes.csw.animaciones.entities;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity.Estado;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    
    @Enumerated
    private Estado estado;
    
    @PodamExclude
    @ManyToOne
    private ArtistaEntity artista;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;    

    @PodamExclude
    @OneToOne(mappedBy = "propuesta", fetch =FetchType.LAZY/*, cascade = CascadeType.PERSIST*/)
    private FacturaEntity factura;
    
    private Long idCliente;

    
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

    /**
     * @return the artista
     */
    public ArtistaEntity getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(ArtistaEntity artista) {
        this.artista = artista;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
    public Long getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(Long sapo){
        this.idCliente = sapo;
    }
    
   
}
