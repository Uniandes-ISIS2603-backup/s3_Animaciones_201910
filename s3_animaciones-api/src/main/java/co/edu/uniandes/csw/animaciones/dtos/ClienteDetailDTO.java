/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ld.manrique
 */
public class ClienteDetailDTO extends ClienteDTO implements Serializable{
    
     ArrayList<FacturaDTO> facturas;
    ArrayList<PropuestaDTO> propuestas;
    ArrayList<MedioDePagoDTO> mediosPago;
    
    
    public ClienteDetailDTO()
    {
        super();
    }
    
//    public ClienteDetailDTO( ClienteEntity entity)
//    {
//        super(entity);
//        if (entity!= null)
//        {
//            
//        }
//    }
    
    
        public ArrayList<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<FacturaDTO> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(ArrayList<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
    
        public ArrayList<MedioDePagoDTO> getMediosDePago() {
        return mediosPago;
    }

    public void setMediosDePago(ArrayList<MedioDePagoDTO> mediosPago) {
        this.mediosPago = mediosPago;
    }
}
