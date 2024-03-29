/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import co.edu.uniandes.csw.animaciones.persistence.ClientePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
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
public class ClientePersistenceTest {
    
       /**
     * Inyección de la dependencia a la clase ClientePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ClientePersistence clientePersistence; 
     

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Lista que tiene los datos de prueba.
     */
    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Client, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            em.persist(entity);

            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Client.
     *
     *
     */
    @Test
    public void createTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity result = clientePersistence.create(newEntity);

        Assert.assertNotNull(result);

        ClienteEntity entity = em.find(ClienteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

 @Test
    public void findTest() {
        ClienteEntity ae = data.get(0);
        ClienteEntity ae2 = clientePersistence.find(ae.getId());
        junit.framework.Assert.assertNotNull(ae2);
        junit.framework.Assert.assertEquals(ae, ae2);
    }
    
    @Test
    public void findAllTest() {
        PodamFactory f = new PodamFactoryImpl();
       ArrayList<ClienteEntity> calE = new ArrayList<ClienteEntity>();
       for(int x = 0;x<10;x++){
           ClienteEntity e = f.manufacturePojo(ClienteEntity.class);       
           ClienteEntity eTest = clientePersistence.create(e); 
           calE.add(eTest);
       }
       boolean sentry = true;
       List<ClienteEntity> ich = clientePersistence.findAll();
       for(ClienteEntity ff: calE){
           boolean tempcheck = false;
           for(ClienteEntity fcheck: ich){
               if(ff.getId().equals(fcheck.getId())){
                   tempcheck = true;
               }
           }
           sentry = sentry && tempcheck;
       }
       Assert.assertTrue(sentry);
    }
    
    @Test
    public void updateTest() {
        ClienteEntity ae = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity ae2 = factory.manufacturePojo(ClienteEntity.class);
        ae2.setId(ae.getId());
        clientePersistence.update(ae2);
        
        ClienteEntity ae3 = em.find(ClienteEntity.class, ae.getId());
        junit.framework.Assert.assertEquals(ae2, ae3);
    }
    
      @Test
    public void findByUserTest() {
        ClienteEntity ae = data.get(0);
        ClienteEntity ae2 = clientePersistence.findByUser(ae.getUsuario());
        
        Assert.assertNotNull(ae2);
        Assert.assertEquals(ae.getUsuario(), ae2.getUsuario());
        
        ae2 = clientePersistence.findByUser(null);
        Assert.assertNull(ae2);
    }
    /**
     * Prueba para eliminar un Client.
     *
     *
     */
    @Test
    public void deleteTest() {
        ClienteEntity entity = data.get(0);
        clientePersistence.delete(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
