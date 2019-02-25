package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.ArtistaPropuestaLogic;
import co.edu.uniandes.csw.animaciones.ejb.PropuestaLogic;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
import java.util.ArrayList;
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
public class ArtistaPropuestaLogicTest {
    
    private PodamFactory pf = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction ut;
    
    @Inject
    private PropuestaLogic pl;
    
    @Inject
    private ArtistaPropuestaLogic apl;
    
    ArtistaEntity ae = new ArtistaEntity();
    ArrayList<PropuestaEntity> listPro = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(PropuestaEntity.class.getPackage())
                .addPackage(ArtistaPropuestaLogic.class.getPackage())
                .addPackage(ArtistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        ae = pf.manufacturePojo(ArtistaEntity.class);
        ae.setPropuestas(new ArrayList<>());
        em.persist(ae);
        
        for(int i = 0; i < 5; i++){
            PropuestaEntity pe = pf.manufacturePojo(PropuestaEntity.class);
            pe.setArtista(ae);
            em.persist(pe);
            listPro.add(pe);
            ae.getPropuestas().add(pe);
        }
    }
    
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.createQuery("delete from PropuestaEntity").executeUpdate();
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
    public void addPropuestaTest() throws BusinessLogicException {
        PropuestaEntity nueva = pf.manufacturePojo(PropuestaEntity.class);
        nueva.setArtista(ae);
        nueva.setPrecio(5);
        pl.createP(nueva);
        
        PropuestaEntity result1 = apl.addPropuesta(ae.getId(), nueva.getId());
        Assert.assertNotNull(result1);
        Assert.assertEquals(result1, nueva);
        
        PropuestaEntity result2 = apl.getPropuesta(ae.getId(), nueva.getId());
        Assert.assertEquals(result2, nueva);
    }
    
    @Test
    public void getPropuestasTest() {
        ArrayList<PropuestaEntity> result = apl.getPrestamos(ae.getId());
        Assert.assertEquals(result.size(), listPro.size());
        for(int i = 0; i < listPro.size(); i++){
            Assert.assertTrue(result.contains(listPro.get(i)));
        }
    }
    
    @Test
    public void getPropuestaTest() {
        PropuestaEntity pe = listPro.get(0);
        PropuestaEntity result = apl.getPropuesta(ae.getId(), pe.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(pe, result);
    }
    
    @Test
    public void deletePropuestaTest() {
        apl.removePropuesta(ae.getId(), listPro.get(0).getId());
        PropuestaEntity result = apl.getPropuesta(ae.getId(), listPro.get(0).getId());
        Assert.assertNull(result);
    }
    
}
