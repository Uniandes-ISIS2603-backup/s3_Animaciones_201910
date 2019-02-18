package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
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
 * @author Nicolas Alvarado
 */
@RunWith(Arquillian.class)
public class AnimacionPersistenceTest {
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private AnimacionPersistence ap;
    
    @Inject
    UserTransaction ut;
    
    private List<AnimacionEntity> listAE = new ArrayList<AnimacionEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimacionEntity.class.getPackage())
                .addPackage(AnimacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

        AnimacionEntity et = factory.manufacturePojo(AnimacionEntity.class);

        em.persist(et);

        listAE.add(et);
        }
    }
    
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.joinTransaction();
            em.createQuery("delete from AnimacionEntity").executeUpdate();
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
    public void createAnimacionTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AnimacionEntity ae = factory.manufacturePojo(AnimacionEntity.class);
        AnimacionEntity result = ap.create(ae);
        
        Assert.assertNotNull(result);
        
        AnimacionEntity clone = em.find(AnimacionEntity.class, result.getId());
        
        Assert.assertEquals(ae.getNombre(), clone.getNombre());
    }
    
    @Test
    public void getAnimacionTest() {
        AnimacionEntity ae = listAE.get(0);
        AnimacionEntity ae2 = ap.find(ae.getId());
        Assert.assertNotNull(ae2);
        Assert.assertEquals(ae, ae2);
    }
    
    @Test
    public void getAnimacionesTest() {
        List<AnimacionEntity> listT = ap.finndAll();
        Assert.assertEquals(listT.size(), listAE.size());
        for(AnimacionEntity ae : listT){
            boolean encontro = false;
            for(AnimacionEntity ae2 : listAE){
                if(ae.getId().equals(ae2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void updateAnimacionTest() {
        AnimacionEntity ae = listAE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AnimacionEntity ae2 = factory.manufacturePojo(AnimacionEntity.class);
        ae2.setId(ae.getId());
        ap.update(ae2);
        
        AnimacionEntity ae3 = em.find(AnimacionEntity.class, ae.getId());
        Assert.assertEquals(ae2, ae3);
    }
    
    @Test
    public void deleteAnimacionTest() {
        AnimacionEntity ae = listAE.get(0);
        ap.delete(ae.getId());
        AnimacionEntity ae2 = em.find(AnimacionEntity.class, ae.getId());
        Assert.assertNull(ae2);
    }
    
}
