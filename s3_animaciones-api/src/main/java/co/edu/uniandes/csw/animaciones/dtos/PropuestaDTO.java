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

import co.edu.uniandes.csw.animaciones.dtos.FacturaDTO.Estado;
import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PropuestaDTO implements Serializable {
    
    private Estado estado;
    
    private Integer precio;
    
    private Long id;
    
    private FacturaDTO factura;
    
    private Long idCliente;
    
   // private ClienteDTO cliente;
    
   // private ArtistaDTO artista;
    
    public PropuestaDTO(){
        
    }
    
    public PropuestaDTO(PropuestaEntity yo){
        if(yo!=null){
            id = yo.getId();
            precio = yo.getPrecio();
            idCliente = yo.getIdCliente();
            if(yo.getEstado()==FacturaEntity.Estado.ACEPTADO){
                estado = Estado.ACEPTADO;
            }else if(yo.getEstado()==FacturaEntity.Estado.RECHAZADO){
                estado = Estado.RECHAZADO;
            }else{
                estado = Estado.ENPROCESO;
            }
            if(yo.getFactura()!=null){
                factura = new FacturaDTO(yo.getFactura()); 
            }             
        }
    
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
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
     * @return the factura
     */
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }
    
    public Long getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(Long sapo){
        this.idCliente = sapo;
    }
    
    public PropuestaEntity toEntity(){
        PropuestaEntity yo = new PropuestaEntity();
        if(estado==Estado.ACEPTADO){
            yo.setEstado(FacturaEntity.Estado.ACEPTADO);
        }else if(estado==Estado.RECHAZADO){
            yo.setEstado(FacturaEntity.Estado.RECHAZADO);
        }else{
            yo.setEstado(FacturaEntity.Estado.ENPROCESO);
        }
        yo.setId(id);
        yo.setPrecio(precio);
        yo.setIdCliente(idCliente);
        if(factura!=null){
            yo.setFactura(factura.toEntity());
        }        
        return yo;
    }
}
