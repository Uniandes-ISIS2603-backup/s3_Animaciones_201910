/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.ConcursoEntity;
import co.edu.uniandes.csw.animaciones.persistence.ConcursoPersistence;
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
public class ConcursoPersistenceTest {

    @Inject
    private ConcursoPersistence cp;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<ConcursoEntity> dataCE = new ArrayList<ConcursoEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ConcursoEntity.class.getPackage())
                .addPackage(ConcursoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    private void clearData() {
        em.createQuery("delete from ConcursoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ConcursoEntity ce = factory.manufacturePojo(ConcursoEntity.class);
            em.persist(ce);
            dataCE.add(ce);
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
    public void createConcursoTest() {
        PodamFactory factory = new PodamFactoryImpl();

        ConcursoEntity newConcursoEntity = factory.manufacturePojo(ConcursoEntity.class);
        ConcursoEntity ce = cp.create(newConcursoEntity);

        Assert.assertNotNull(ce);

        ConcursoEntity concursoE = em.find(ConcursoEntity.class, ce.getId());
        Assert.assertEquals(newConcursoEntity.getId(), concursoE.getId());

    }
     
    @Test
    public void getConcursoTest() {
        ConcursoEntity ce = dataCE.get(0);
        ConcursoEntity ce2 = cp.find(ce.getId());
        Assert.assertNotNull(ce2);
        Assert.assertEquals(ce, ce2);
    }
    
    @Test
    public void getCocursosTest() {
        List<ConcursoEntity> ces = cp.findAll();
        Assert.assertEquals(ces.size(), dataCE.size());
        for(ConcursoEntity ce : ces){
            boolean encontro = false;
            for(ConcursoEntity ae2 : dataCE){
                if(ce.getId().equals(ae2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void updateConcursoTest() {
        ConcursoEntity ce = dataCE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ConcursoEntity ce2 = factory.manufacturePojo(ConcursoEntity.class);
        ce2.setId(ce.getId());
        cp.update(ce2);
        
        ConcursoEntity ce3 = em.find(ConcursoEntity.class, ce.getId());
        Assert.assertEquals(ce2, ce3);
    }
    
    @Test
    public void deleteConcursoTest() {
        ConcursoEntity ce = dataCE.get(0);
        cp.delete(ce.getId());
        ConcursoEntity ce2 = em.find(ConcursoEntity.class, ce.getId());
        Assert.assertNull(ce2);
    }

}
