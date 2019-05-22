/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.ejb;

/**
 *
 * @author ld.manrique
 */


import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteLogic {
     @Inject
    private ClientePersistence cliente;
    
    public ClienteEntity create(ClienteEntity temp) throws BusinessLogicException {
        if(temp.getNombre() == null || temp.getUsuario() == null || temp.getContrasenia() == null){
            throw new BusinessLogicException("El nombre, usuario o contrasena no pueden ser nulos");
        }
        if(cliente.findByUser(temp.getUsuario()) != null){
            throw new BusinessLogicException("El nombre de usuario ya existe");
        }
        cliente.create(temp);
        return temp;
    }
    
    public ClienteEntity getCliente(Long id){
        ClienteEntity temp = cliente.find(id);
        return temp;
    }
    
    public List<ClienteEntity> getClientes() {
        List<ClienteEntity> list = cliente.findAll();
        return list;
    }
    
    public ClienteEntity update(ClienteEntity temp) throws BusinessLogicException {
        if(temp.getNombre() == null || temp.getUsuario() == null || temp.getContrasenia() == null){
            throw new BusinessLogicException("El nombre, usuario o contrasena no pueden ser nulos");
        }
        /**if(cliente.findByUser(temp.getUsuario()) != null){
            throw new BusinessLogicException("El nombre de usuario ya existe");
        }**/
        ClienteEntity temp2 = cliente.update(temp);
        return temp2;
    }
    
    public void delete(Long id){
        cliente.delete(id);
    }
    
}
