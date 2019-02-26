/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.ClienteLogic;
import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ClientePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ld.manrique
 */
@RunWith(Arquillian.class)
public class ClienteLogicTest {
  private PodamFactory pf = new PodamFactoryImpl();
    
    @Inject
    private ClienteLogic clienteLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utrans;
    
    private List<ClienteEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 5; i++){
            ClienteEntity temp = pf.manufacturePojo(ClienteEntity.class);
            em.persist(temp);
            data.add(temp);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
            em.createQuery("delete from ClienteEntity").executeUpdate();
            insertData();
            utrans.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            try{
                utrans.rollback();
            }
            catch(Exception f){
                f.printStackTrace();
            }
        }
    }
    
    @Test
    public void createTest() throws BusinessLogicException {
        ClienteEntity temp = pf.manufacturePojo(ClienteEntity.class);
        clienteLogic.create(temp);
        ClienteEntity temp2 = em.find(ClienteEntity.class, temp.getId());
        Assert.assertEquals(temp, temp2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createTestSinNombre() throws BusinessLogicException {
        ClienteEntity temp = pf.manufacturePojo(ClienteEntity.class);
        temp.setNombre(null);
        clienteLogic.create(temp);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createTestUsuarioExistente() throws BusinessLogicException {
        ClienteEntity temp = data.get(0);
        ClienteEntity temp2 = pf.manufacturePojo(ClienteEntity.class);
        temp2.setUsuario(temp.getUsuario());
        clienteLogic.create(temp2);
    }
    
    @Test
    public void getClienteTest() {
        ClienteEntity temp = data.get(0);
        ClienteEntity temp2 = clienteLogic.getCliente(temp.getId());
        Assert.assertNotNull(temp2);
        Assert.assertEquals(temp, temp2);
    }
    
    @Test
    public void getClientesTest() {
        List<ClienteEntity> result = clienteLogic.getClientes();
        Assert.assertEquals(result.size(), data.size());
        for(ClienteEntity temp : result){
            boolean encontro = false;
            for(ClienteEntity temp2 : data){
                if(temp.equals(temp2)){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void deleteTest() {
        ClienteEntity temp = data.get(0);
        clienteLogic.delete(temp.getId());
        ClienteEntity temp2 = em.find(ClienteEntity.class, temp.getId());
        Assert.assertNull(temp2);
    }
      
}
