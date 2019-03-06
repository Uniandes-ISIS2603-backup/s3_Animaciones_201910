/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.animaciones.persistence.MedioDePagoPersistence;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
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
public class MedioDePagoPersistenceTest {
    
    @Inject
    private MedioDePagoPersistence mdpp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction ut;
    
    private List <MedioDePagoEntity> listMDPE = new ArrayList<MedioDePagoEntity>(); 
    
     @Deployment
        public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioDePagoEntity.class.getPackage())
                .addPackage(MedioDePagoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
        
    private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

        MedioDePagoEntity mdpe = factory.manufacturePojo(MedioDePagoEntity.class);

        em.persist(mdpe);

        listMDPE.add(mdpe);
        }
    }
      
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.joinTransaction();
            em.createQuery("delete from MedioDePagoEntity").executeUpdate();
            insertData();
            ut.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                ut.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    @Test
    public void createMedioDePagoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity newMedioDePagoEntity = factory.manufacturePojo(MedioDePagoEntity.class);
        MedioDePagoEntity mdpe = mdpp.create(newMedioDePagoEntity);
        Assert.assertNotNull(mdpe);
        MedioDePagoEntity MedioDePagoEntity = em.find(MedioDePagoEntity.class, mdpe.getId());
        Assert.assertEquals(newMedioDePagoEntity.getNumeroTarjeta(), MedioDePagoEntity.getNumeroTarjeta());
    }
    
        @Test
    public void getMedioDePagoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity newMedioDePagoEntity = factory.manufacturePojo(MedioDePagoEntity.class);
        MedioDePagoEntity mdpe = mdpp.create(newMedioDePagoEntity);
        Assert.assertNotNull(mdpe);
        Assert.assertEquals(newMedioDePagoEntity.getId(), mdpe.getId());
    }
    
    @Test
    public void getMediosDePagoTest() {
        List<MedioDePagoEntity> listT = mdpp.findAll();
        Assert.assertEquals(listT.size(), listMDPE.size());
        
        for(MedioDePagoEntity mdpe : listT){
            boolean encontro = false;
            for(MedioDePagoEntity mdpe2 : listMDPE){
                if(mdpe.getId().equals(mdpe2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void updatMedioDePagoTest() {
        MedioDePagoEntity mdpe = listMDPE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MedioDePagoEntity mdpe2 = factory.manufacturePojo(MedioDePagoEntity.class);
        mdpe2.setId(mdpe.getId());
        mdpp.update(mdpe2);
        
        MedioDePagoEntity mdpe3 = em.find(MedioDePagoEntity.class, mdpe.getId());
        Assert.assertEquals(mdpe2, mdpe3);
    }
    
    @Test
    public void deleteMedioDePagoTest() {
        MedioDePagoEntity mdpe = listMDPE.get(0);
        mdpp.delete(mdpe.getId());
        MedioDePagoEntity mdpe2 = em.find(MedioDePagoEntity.class, mdpe.getId());
        Assert.assertNull(mdpe2);
    }
    
}
