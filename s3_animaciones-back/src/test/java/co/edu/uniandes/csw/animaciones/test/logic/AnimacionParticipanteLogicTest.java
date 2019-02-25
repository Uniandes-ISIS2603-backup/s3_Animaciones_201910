/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.entities.AnimacionParticipanteEntity;
import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionParticipantePersistence;
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
 * @author df.perezc
 */
@RunWith(Arquillian.class)
public class AnimacionParticipanteLogicTest {
    
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private AnimacionParticipantePersistence app;

      @Inject
    private AnimacionParticipanteLogic apel;
    
    @Inject
    UserTransaction utx;

    private List<AnimacionParticipanteEntity> dataAPE = new ArrayList<AnimacionParticipanteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimacionParticipanteEntity.class.getPackage())
                .addPackage(AnimacionParticipantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    private void clearData() {
        em.createQuery("delete from AnimacionParticipanteEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AnimacionParticipanteEntity ape = factory.manufacturePojo(AnimacionParticipanteEntity.class);
            em.persist(ape);
            dataAPE.add(ape);
        }
    }

    @Before
    public void setUp() {
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

    @Test
    public void createAnimacionParticipanteTest() {
        PodamFactory factory = new PodamFactoryImpl();

        AnimacionParticipanteEntity newAnimacionParticipanteEntity = factory.manufacturePojo(AnimacionParticipanteEntity.class);
        AnimacionParticipanteEntity ape = app.create(newAnimacionParticipanteEntity);

        Assert.assertNotNull(ape);

        AnimacionParticipanteEntity ape2 = em.find(AnimacionParticipanteEntity.class, ape.getId());
        Assert.assertEquals(ape.getId(), ape2.getId());

    }
    
    @Test(expected = BusinessLogicException.class)
    public void createAnimacionParticipanteIdExistenteTest() throws BusinessLogicException {
        AnimacionParticipanteEntity newAPE = factory.manufacturePojo(AnimacionParticipanteEntity.class);
        newAPE.setId(dataAPE.get(0).getId());
        apel.create(newAPE);

    }
     
    @Test
    public void getConcursoTest() {
        AnimacionParticipanteEntity ape = dataAPE.get(0);
        AnimacionParticipanteEntity ape2 = app.find(ape.getId());
        Assert.assertNotNull(ape2);
        Assert.assertEquals(ape, ape2);
    }
    
    @Test
    public void getCocursosTest() {
        List<AnimacionParticipanteEntity> apps = app.findAll();
        Assert.assertEquals(apps.size(), dataAPE.size());
        for(AnimacionParticipanteEntity ape : apps){
            boolean encontro = false;
            for(AnimacionParticipanteEntity ape2 : dataAPE){
                if(ape.getId().equals(ape2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void updateConcursoTest() {
        AnimacionParticipanteEntity ape = dataAPE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AnimacionParticipanteEntity ape2 = factory.manufacturePojo(AnimacionParticipanteEntity.class);
        ape2.setId(ape.getId());
        app.update(ape2);
        
        AnimacionParticipanteEntity ape3 = em.find(AnimacionParticipanteEntity.class, ape.getId());
        Assert.assertEquals(ape2, ape3);
    }
    
    @Test
    public void deleteAnimacionTest() {
        AnimacionParticipanteEntity ape = dataAPE.get(0);
        app.delete(ape.getId());
        AnimacionParticipanteEntity ape2 = em.find(AnimacionParticipanteEntity.class, ape.getId());
        Assert.assertNull(ape2);
    }
    
}
