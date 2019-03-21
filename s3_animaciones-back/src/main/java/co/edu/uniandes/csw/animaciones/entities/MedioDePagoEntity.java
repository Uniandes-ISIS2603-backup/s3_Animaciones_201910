/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author df.serrano
 */
@Entity
public class MedioDePagoEntity extends BaseEntity implements Serializable{
    
    /**
     * Atributo que contiene el numero de la tarjeta con el cual 
     * se hace el pago
     */
    private Integer numeroTarjeta;
    /**
     * Atributo que contiene el codigo con el cual se va a aprobar el pago
     */
    private Integer codigo;
    
    /**
     * Atributo que Guarda la fecha de vencimiento del pago
     */
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    /**
     * Enumeracion con las formas de pago
     */
    @PodamExclude
    @OneToOne
    private FacturaEntity factura;
    
    public enum FormaDePago{
        DEBITO, CREDITO, PAYPAL, PSE
    }

           
    public MedioDePagoEntity(){
        
    }

 

    /**
     * @return the numeroTarjeta
     */
    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    } 
}
