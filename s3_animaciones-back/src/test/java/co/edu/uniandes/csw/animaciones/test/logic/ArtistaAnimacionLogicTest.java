package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.AnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.ArtistaAnimacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.ArtistaLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import java.util.ArrayList;
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
 * @author Nicolas Alvarado
 */
@RunWith(Arquillian.class)
public class ArtistaAnimacionLogicTest {
    
    private PodamFactory pf = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction ut;
    
    @Inject
    private ArtistaLogic arl;
    
    @Inject
    private AnimacionLogic anl;
    
    @Inject
    private ArtistaAnimacionLogic aal;
    
    ArtistaEntity ae = new ArtistaEntity();
    ArrayList<AnimacionEntity> listAn = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(AnimacionEntity.class.getPackage())
                .addPackage(ArtistaAnimacionLogic.class.getPackage())
                .addPackage(ArtistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        ae = pf.manufacturePojo(ArtistaEntity.class);
        ae.setAnimaciones(new ArrayList<>());
        em.persist(ae);
        
        for(int i = 0; i < 5; i++){
            AnimacionEntity ane = pf.manufacturePojo(AnimacionEntity.class);
            ane.setArtista(ae);
            em.persist(ane);
            listAn.add(ane);
            ae.getAnimaciones().add(ane);
        }
    }
    
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.createQuery("delete from AnimacionEntity").executeUpdate();
            em.createQuery("delete from ArtistaEntity").executeUpdate();
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
    public void addAnimacionTest() throws BusinessLogicException {
        AnimacionEntity nueva = pf.manufacturePojo(AnimacionEntity.class);
        nueva.setArtista(ae);
        anl.createAnimacion(nueva);
        
        AnimacionEntity result1 = aal.addAnimacion(ae.getId(), nueva.getId());
        Assert.assertNotNull(result1);
        Assert.assertEquals(result1, nueva);
        
        AnimacionEntity result2 = aal.getAnimacion(ae.getId(), nueva.getId());
        Assert.assertEquals(result2, nueva);
    }
    
    @Test
    public void getAnimacionesTest() {
        ArrayList<AnimacionEntity> result = aal.getAnimaciones(ae.getId());
        Assert.assertEquals(result.size(), listAn.size());
        for(int i = 0; i < listAn.size(); i++){
            Assert.assertTrue(result.contains(listAn.get(i)));
        }
    }
    
    @Test
    public void getAnimacionTest() {
        AnimacionEntity aeT = listAn.get(0);
        AnimacionEntity result = aal.getAnimacion(ae.getId(), aeT.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(aeT, result);
    }
    
    @Test
    public void deleteAnimacionTest() {
        aal.removeAnimacion(ae.getId(), listAn.get(0).getId());
        AnimacionEntity result = aal.getAnimacion(ae.getId(), listAn.get(0).getId());
        Assert.assertNull(result);
    }
    
}
