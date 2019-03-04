/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.RondaLogic;
import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.Date;
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
 * @author df.serrano
 */
@RunWith(Arquillian.class)
public class RondaLogicTest {
    
        
    private PodamFactory pf = new PodamFactoryImpl();
    
    @Inject
    private RondaLogic rl;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utrans;
    
    private List<RondaEntity> listaRE = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RondaEntity.class.getPackage())
                .addPackage(RondaLogic.class.getPackage())
                .addPackage(RondaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 4; i++){
            RondaEntity re = pf.manufacturePojo(RondaEntity.class);
            em.persist(re);
            listaRE.add(re);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
            em.createQuery("delete from RondaEntity").executeUpdate();
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
    public void createRondaUnoTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       e.setNumero(1);
       RondaEntity re = rl.createRonda(e);
       Assert.assertNotNull(re);
       RondaEntity re2 = em.find(RondaEntity.class, re.getId());
       Assert.assertEquals(re, re2);
    }
        @Test
    public void createRondaDosTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       e.setNumero(2);
       RondaEntity re = rl.createRonda(e);
       Assert.assertNotNull(re);
       RondaEntity re2 = em.find(RondaEntity.class, re.getId());
       Assert.assertEquals(re, re2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createSinFechaFinTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setFechaFin(null);
       rl.createRonda(e);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createSinFechaInicioTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setFechaInicio(null);
       rl.createRonda(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createSinNumeroTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setNumero(null);
       rl.createRonda(e);
    }
    
    //@Test (expected = BusinessLogicException.class)
    public void createFechaInicioDespuesDeFinTest(){
        
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createConNumeroDiferenteTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setNumero(4);
       rl.createRonda(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createConFechaInicioViejaTest() throws BusinessLogicException{
        PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setFechaInicio(new Date(100, 0, 1));
       rl.createRonda(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createconFechaFinViejaTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       RondaEntity e = f.manufacturePojo(RondaEntity.class);
       rl.createRonda(e);
       e.setFechaFin(new Date(100, 0, 1));
       rl.createRonda(e);
    }
    
    @Test
    public void getRondaTest(){
        RondaEntity re = listaRE.get(0);
        RondaEntity re2 = rl.getRonda(re.getId());
        Assert.assertNotNull(re2);
        Assert.assertEquals(re, re2);
    }
    
    @Test
    public void getRondasTest(){
        
         List<RondaEntity> result = rl.getRondas();
        Assert.assertEquals(result.size(), listaRE.size());
        for(RondaEntity re : result){
            boolean encontro = false;
            for(RondaEntity re2 : listaRE){
                if(re.equals(re2)){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
        
    }
    
    @Test
    public void deleteRondaTest(){
        
        RondaEntity re = listaRE.get(0);
        rl.deleteRonda(re.getId());
        RondaEntity re2 = em.find(RondaEntity.class, re.getId());
        Assert.assertNull(re2);
        
    }
    
    
    
}
