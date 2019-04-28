/*
Ok cuck

Copyright (c) 2019 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity.FormaDePago;
import java.io.Serializable;
import java.sql.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MedioDePagoDTO implements Serializable {
    
    /**
     * Atributo que contiene el id del medio de pago
     */
    private Long id;
    /**
     * Atributo que contiene el numero de la tarjeta 
     */
    private Integer numeroTarjeta;
    /**
     * Atributo que contiene el codigo del medio de pago
     */
    private Integer codigo;
    /**
     * Atributo que contiene el Date de la fecha de vencimiento del  medio de pago
     */
    private String fechaVencimiento;
    /**
     * Atributo que contiene la forma de pago
     */
    private FormaDePago formaDePago;

   
    
    public MedioDePagoDTO(){
        
    }
    
    public MedioDePagoDTO (MedioDePagoEntity mDPE){
        this.id = mDPE.getId();
        this.codigo = mDPE.getCodigo();
        this.fechaVencimiento = mDPE.getFechaVencimiento();
        this.formaDePago = mDPE.getFormaDePago();
        this.numeroTarjeta = mDPE.getNumeroTarjeta();
    }

    /**
     * @return the id
     */
    public Long  getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the formaDePago
     */
    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    /**
     * @param formaDePago the formaDePago to set
     */
    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }
    
    
    public MedioDePagoEntity toEntity( ){
        MedioDePagoEntity n = new MedioDePagoEntity();
        n.setCodigo(this.codigo);
        n.setFechaVencimiento(this.fechaVencimiento);
        n.setNumeroTarjeta(this.numeroTarjeta);
        n.setFormaDePago(this.formaDePago);
        n.setId(this.id);
        
        return n;
    
    }

}   
