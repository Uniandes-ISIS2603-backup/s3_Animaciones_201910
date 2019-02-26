/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 *
 * @author ld.manrique
 */
public class ClienteDTO  implements Serializable{
    
   private Integer id;
   //QUE SI HERMANO QUE ESTE ES EL GIT FLOW CREAME
       private String nombre;
    
    private String informacion;
    
    private String usuario;
    
    private String contrasenia;
    
    public  ClienteDTO(){
        
    }

//    public ClienteDTO(ClienteEntity entity)
//    {
//       entity.setContrasenia(contrasenia);
//       entity.setInformacion(informacion);
//       entity.setNombre(nombre);
//       entity.setUsuario(usuario);
//    }
    
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
  @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
//    public ClienteEntity toEntity()
//    {
//        ClienteEntity entity= new ClienteEntity();
//        entity.setContrasenia(contrasenia);
//        entity.setInformacion(informacion);
//        entity.setNombre(nombre);
//        entity.setUsuario(usuario);
//        return entity;
//    }
}
