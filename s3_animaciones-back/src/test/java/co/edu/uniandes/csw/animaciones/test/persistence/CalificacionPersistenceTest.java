/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
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
public class CalificacionPersistenceTest {
       /**
     * Inyección de la dependencia a la clase CalificacionPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CalificacionPersistence calificacionPersistence; 
     

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
    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();

     private List<AnimacionEntity> dataAnimacion = new ArrayList<AnimacionEntity>();

      /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
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
     */
    private void clearData() {
        em.createQuery("delete from CalificacionEntity").executeUpdate();
        em.createQuery("delete from AnimacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AnimacionEntity entity = factory.manufacturePojo(AnimacionEntity.class);
            em.persist(entity);
            dataAnimacion.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);
            if (i == 0) {
                entity.setAnimacion(dataAnimacion.get(0));
            }
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear una Calificacion.
     *
     *
     */
    @Test
    public void createTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
  /**
     * Prueba para consultar un Review.
     */
    @Test
    public void findTest() {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity newEntity = calificacionPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getComentario(), newEntity.getComentario());
        Assert.assertEquals(entity.getCalificacion(), newEntity.getCalificacion());
      
    }
    
    @Test
    public void findAllTest() {
        PodamFactory f = new PodamFactoryImpl();
       ArrayList<CalificacionEntity> calE = new ArrayList<CalificacionEntity>();
       for(int x = 0;x<10;x++){
           CalificacionEntity e = f.manufacturePojo(CalificacionEntity.class);       
           CalificacionEntity eTest = calificacionPersistence.create(e); 
           calE.add(eTest);
       }
       boolean sentry = true;
       List<CalificacionEntity> ich = calificacionPersistence.findAll();
       for(CalificacionEntity ff: calE){
           boolean tempcheck = false;
           for(CalificacionEntity fcheck: ich){
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
        CalificacionEntity ae = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity ae2 = factory.manufacturePojo(CalificacionEntity.class);
        ae2.setId(ae.getId());
        calificacionPersistence.update(ae2);
        
        CalificacionEntity ae3 = em.find(CalificacionEntity.class, ae.getId());
        junit.framework.Assert.assertEquals(ae2, ae3);
    }
    /**
     * Prueba para eliminar una Calificacion.
     *
     *
     */
    @Test
    public void deleteTest() {
        CalificacionEntity entity = data.get(0);
        calificacionPersistence.delete(entity.getId());
        CalificacionEntity deleted = em.find(CalificacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
