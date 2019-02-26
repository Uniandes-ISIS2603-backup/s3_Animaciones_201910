/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.VotacionLogic;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.persistence.VotacionPersistence;
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
public class VotacionLogicTest {
    private PodamFactory pf = new PodamFactoryImpl();
    
    @Inject
    private VotacionLogic vl;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utrans;
    
    private List<VotacionEntity> listaRE = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VotacionEntity.class.getPackage())
                .addPackage(VotacionLogic.class.getPackage())
                .addPackage(VotacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 4; i++){
            VotacionEntity ve = pf.manufacturePojo(VotacionEntity.class);
            em.persist(ve);
            listaRE.add(ve);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
            em.createQuery("delete from VotacionEntity").executeUpdate();
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
    public void createTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       VotacionEntity ve = vl.createVotacion(e);
       Assert.assertNotNull(ve);
       VotacionEntity ve2 = em.find(VotacionEntity.class, ve.getId());
        Assert.assertEquals(ve, ve2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createSinIDAnimacionTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setIdAnimacion(null);
       vl.createVotacion(e);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createConIDAnimacionNegativoTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setIdAnimacion(-50);
       vl.createVotacion(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createSinPuntosTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setPuntos(null);
       vl.createVotacion(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createPuntosMenorQue1() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setPuntos(-25.9);
       vl.createVotacion(e);
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createPuntosMayorQue10() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setPuntos(25.9);
       vl.createVotacion(e);
    }
        @Test (expected = BusinessLogicException.class)
    public void createConNumeroRondaNullTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setNumRonda(null);
       vl.createVotacion(e);
    }
    @Test (expected = BusinessLogicException.class)
    public void createConNumeroRondaDiferenteTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       VotacionEntity e = f.manufacturePojo(VotacionEntity.class);
       vl.createVotacion(e);
       e.setNumRonda(4);
       vl.createVotacion(e);
    }
    
 
    @Test
    public void getVotacionTest(){
        VotacionEntity ve = listaRE.get(0);
        VotacionEntity ve2 = vl.getVotacion(ve.getId());
        Assert.assertNotNull(ve2);
        Assert.assertEquals(ve, ve2);
    }
    
    @Test
    public void getVotacionesTest(){
        
         List<VotacionEntity> result = vl.getVotacions();
        Assert.assertEquals(result.size(), listaRE.size());
        for(VotacionEntity ve : result){
            boolean encontro = false;
            for(VotacionEntity ve2 : listaRE){
                if(ve.equals(ve2)){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
        
    }
    
    @Test
    public void deleteVotacionTest(){
        
        VotacionEntity ve = listaRE.get(0);
        vl.deleteVotacion(ve.getId());
        VotacionEntity ve2 = em.find(VotacionEntity.class, ve.getId());
        Assert.assertNull(ve2);
        
    }
}
