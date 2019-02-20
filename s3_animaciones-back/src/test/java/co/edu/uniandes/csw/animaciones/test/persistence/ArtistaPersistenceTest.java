package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
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
 * @author Nicolas Alvarado
 */
@RunWith(Arquillian.class)
public class ArtistaPersistenceTest {
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private ArtistaPersistence ap;
    
    @Inject
    UserTransaction ut;
    
    private List<ArtistaEntity> listAE = new ArrayList<ArtistaEntity>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

        ArtistaEntity et = factory.manufacturePojo(ArtistaEntity.class);

        em.persist(et);

        listAE.add(et);
        }
    }
    
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.joinTransaction();
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
    public void createArtistaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ArtistaEntity ae = factory.manufacturePojo(ArtistaEntity.class);
        ArtistaEntity result = ap.createArtista(ae);
        
        Assert.assertNotNull(result);
        
        ArtistaEntity clone = em.find(ArtistaEntity.class, result.getId());
        
        Assert.assertEquals(ae.getNombre(), clone.getNombre());
    }
    
    @Test
    public void getArtistaTest() {
        ArtistaEntity ae = listAE.get(0);
        ArtistaEntity ae2 = ap.findArtista(ae.getId());
        Assert.assertNotNull(ae2);
        Assert.assertEquals(ae, ae2);
    }
    
    @Test
    public void getArtistasTest() {
        List<ArtistaEntity> listF = ap.findAll();
        Assert.assertEquals(listF.size(), listAE.size());
        for(ArtistaEntity ae : listF){
            boolean encontro = false;
            for(ArtistaEntity ae2 : listAE){
                if(ae.getId().equals(ae2.getId())){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void updateArtistaTest() {
        ArtistaEntity ae = listAE.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ArtistaEntity ae2 = factory.manufacturePojo(ArtistaEntity.class);
        ae2.setId(ae.getId());
        ap.updateArtista(ae2);
        
        ArtistaEntity ae3 = em.find(ArtistaEntity.class, ae.getId());
        Assert.assertEquals(ae2, ae3);
    }
    
    @Test
    public void deleteArtistaEntity() {
        ArtistaEntity ae = listAE.get(0);
        ap.deleteArtista(ae.getId());
        ArtistaEntity ae2 = em.find(ArtistaEntity.class, ae.getId());
        Assert.assertNull(ae2);
    }
    
    @Test
    public void findByUserTest() {
        ArtistaEntity ae = listAE.get(0);
        ArtistaEntity ae2 = ap.findByUser(ae.getUsuario());
        
        Assert.assertNotNull(ae2);
        Assert.assertEquals(ae.getUsuario(), ae2.getUsuario());
        
        ae2 = ap.findByUser(null);
        Assert.assertNull(ae2);
    }
}
