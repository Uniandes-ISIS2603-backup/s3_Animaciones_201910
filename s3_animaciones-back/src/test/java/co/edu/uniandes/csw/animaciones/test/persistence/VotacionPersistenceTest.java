/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.persistence.VotacionPersistence;
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
public class VotacionPersistenceTest {
    
    @Inject
    private VotacionPersistence vp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction ut;
    
    private List <VotacionEntity> listVE = new ArrayList<VotacionEntity>(); 
    
     @Deployment
        public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VotacionEntity.class.getPackage())
                .addPackage(VotacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
        
    private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

        VotacionEntity ve = factory.manufacturePojo(VotacionEntity.class);

        em.persist(ve);

        listVE.add(ve);
        }
    }
      
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.joinTransaction();
            em.createQuery("delete from VotacionEntity").executeUpdate();
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
    public void createVotacionTest(){
        PodamFactory factory = new PodamFactoryImpl();
        VotacionEntity newVotacionEntity = factory.manufacturePojo(VotacionEntity.class);
        VotacionEntity ve = vp.create(newVotacionEntity);
       
        Assert.assertNotNull(ve);
        
        VotacionEntity VotacionEntity = em.find(VotacionEntity.class, ve.getId());
           Assert.assertEquals(newVotacionEntity.getIdAnimacion(), VotacionEntity.getIdAnimacion());
    }
    
        @Test
    public void getVotacionTest() {
        VotacionEntity ve = listVE.get(0);
        VotacionEntity ve2 = vp.find(ve.getId());
        Assert.assertNotNull(ve2);
        Assert.assertEquals(ve2, ve);
    }
    
    @Test
    public void getVotacionesTest() {
        List<VotacionEntity> listT = vp.findAll();
        Assert.assertEquals(listT.size(), listVE.size());
        for(VotacionEntity ve : listT){
            boolean encontro = false;
            for(VotacionEntity ve2 : listVE){
                if(ve.getId().equals(ve2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
}
