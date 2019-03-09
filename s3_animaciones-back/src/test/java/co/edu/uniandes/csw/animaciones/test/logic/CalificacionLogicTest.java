/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.CalificacionLogic;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.CalificacionPersistence;
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
public class CalificacionLogicTest {
    private PodamFactory pf = new PodamFactoryImpl();
    
    @Inject
    private CalificacionLogic calificacionLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utrans;
    
    private List<CalificacionEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionLogic.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 5; i++){
            CalificacionEntity temp = pf.manufacturePojo(CalificacionEntity.class);
            em.persist(temp);
            data.add(temp);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
            em.createQuery("delete from CalificacionEntity").executeUpdate();
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
        CalificacionEntity temp = pf.manufacturePojo(CalificacionEntity.class);
        calificacionLogic.create(data.get(1).getId(),temp);
        CalificacionEntity temp2 = em.find(CalificacionEntity.class, temp.getId());
        Assert.assertEquals(temp, temp2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createTestSinComentario() throws BusinessLogicException {
        CalificacionEntity temp = pf.manufacturePojo(CalificacionEntity.class);
        temp.setComentario(null);
        calificacionLogic.create(data.get(1).getId(),temp);
    }
    
//    @Test(expected = BusinessLogicException.class)
//    public void createTestCalificaionFueraDeLimites() throws BusinessLogicException {
//        
//        CalificacionEntity temp2 = pf.manufacturePojo(CalificacionEntity.class);
//        temp2.setCalificacion(15);
//        calificacionLogic.create(temp2);
//    }
    
    @Test
    public void getCalificacionTest() {
        CalificacionEntity temp = data.get(0);
        CalificacionEntity temp2 = calificacionLogic.getCalificacion(temp.getId());
        Assert.assertNotNull(temp2);
        Assert.assertEquals(temp, temp2);
    }
    
    @Test
    public void getCalificacionesTest() {
        List<CalificacionEntity> result = calificacionLogic.getCalificaciones();
        Assert.assertEquals(result.size(), data.size());
        for(CalificacionEntity temp : result){
            boolean encontro = false;
            for(CalificacionEntity temp2 : data){
                if(temp.equals(temp2)){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void deleteTest() {
        CalificacionEntity temp = data.get(0);
        calificacionLogic.delete(temp.getId());
        CalificacionEntity temp2 = em.find(CalificacionEntity.class, temp.getId());
        Assert.assertNull(temp2);
    } 
}
