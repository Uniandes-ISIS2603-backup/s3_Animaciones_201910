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

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FacturaDTO implements Serializable {
    
    private Long id;
    
    private Integer idAnim;
    
    private Date fecha;
    
    private Estado estado;
    
    private MedioDePagoDTO medioDePago;
    
    public enum Estado{
        ENPROCESO, ACEPTADO, RECHAZADO
    }
    
    public FacturaDTO(){
        
    }
    
    public FacturaDTO(FacturaEntity yo){
        if(yo!=null){
            id = yo.getId();
            idAnim = yo.getIdAnim();
            fecha = yo.getFecha();
            if(yo.getEstado()==FacturaEntity.Estado.ACEPTADO){
                estado = Estado.ACEPTADO;
            }else if(yo.getEstado()==FacturaEntity.Estado.RECHAZADO){
                estado = Estado.RECHAZADO;
            }else{
                estado = Estado.ENPROCESO;
            }
            if(yo.getMedioDePago()!=null){
               medioDePago = new MedioDePagoDTO(yo.getMedioDePago());  
            }             
        }        
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the medioDePago
     */
    public MedioDePagoDTO getMedioDePago() {
        return medioDePago;
    }

    /**
     * @param medioDePago the medioDePago to set
     */
    public void setMedioDePago(MedioDePagoDTO medioDePago) {
        this.medioDePago = medioDePago;
    }
    
    public FacturaEntity toEntity(){
        FacturaEntity yo = new FacturaEntity();
        if(estado==Estado.ACEPTADO){
            yo.setEstado(FacturaEntity.Estado.ACEPTADO);
        }else if(estado==Estado.RECHAZADO){
            yo.setEstado(FacturaEntity.Estado.RECHAZADO);
        }else{
            yo.setEstado(FacturaEntity.Estado.ENPROCESO);
        }
        if(fecha!=null){
           yo.setFecha(fecha); 
        }else{
           yo.setFecha(new Date());
        }        
        yo.setId(id);
        yo.setIdAnim(idAnim);
        if(medioDePago!=null){
           yo.setMedioDePago(medioDePago.toEntity()); 
        }        
        return yo;
    }
}
