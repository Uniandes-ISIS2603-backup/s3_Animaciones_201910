/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
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
public class RondaPersistenceTest {

    @Inject
    private RondaPersistence rp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction ut;
    
    private List <RondaEntity> listRE = new ArrayList<RondaEntity>(); 
    
    @Deployment
        public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RondaEntity.class.getPackage())
                .addPackage(RondaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
        
    private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

        RondaEntity rt = factory.manufacturePojo(RondaEntity.class);

        em.persist(rt);

        listRE.add(rt);
        }
    }
      
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.joinTransaction();
            em.createQuery("delete from RondaEntity").executeUpdate();
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
    public void createRondaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        RondaEntity newRondaEntity = factory.manufacturePojo(RondaEntity.class);
        RondaEntity re = rp.create(newRondaEntity);
       
        Assert.assertNotNull(re);
        
        RondaEntity rondaEntity = em.find(RondaEntity.class, re.getId());
        //Assert.assertEquals(newRondaEntity.getFechaInicio(), rondaEntity.getFechaInicio());
        //Assert.assertEquals(newRondaEntity.getFechaFin(), rondaEntity.getFechaFin());
          Assert.assertEquals(newRondaEntity.getNumero(), rondaEntity.getNumero());
    }
    
        @Test
    public void getRondaTest() {
        RondaEntity re = listRE.get(0);
        RondaEntity re2 = rp.find(re.getId());
        Assert.assertNotNull(re2);
        Assert.assertEquals(re2, re);
    }
    
    @Test
    public void getRondassTest() {
        List<RondaEntity> listT = rp.findAll();
        Assert.assertEquals(listT.size(), listRE.size());
        for(RondaEntity re : listT){
            boolean encontro = false;
            for(RondaEntity re2 : listRE){
                if(re.getId().equals(re2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
        
    @Test
    public void updatRondaTest() {
        RondaEntity re = listRE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RondaEntity re2 = factory.manufacturePojo(RondaEntity.class);
        re2.setId(re.getId());
        rp.update(re2);
        
        RondaEntity re3 = em.find(RondaEntity.class, re.getId());
        Assert.assertEquals(re2, re3);
    }
    
    @Test
    public void deleteRondaTest() {
        RondaEntity re = listRE.get(0);
        rp.delete(re.getId());
        RondaEntity re2 = em.find(RondaEntity.class, re.getId());
        Assert.assertNull(re2);
    }
}
