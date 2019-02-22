package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.AnimacionLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import java.util.ArrayList;
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
 * @author Nicolas Alvarado
 */
@RunWith(Arquillian.class)
public class AnimacionLogicTest {
    
    @Inject
    private UserTransaction utrans;
    
    @PersistenceContext
    private EntityManager em;
    
    private PodamFactory pf = new PodamFactoryImpl();
    
    List<AnimacionEntity> listaA = new ArrayList<>();
    
    @Inject
    private AnimacionLogic al;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimacionEntity.class.getPackage())
                .addPackage(AnimacionLogic.class.getPackage())
                .addPackage(AnimacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 5; i++){
            AnimacionEntity ae = pf.manufacturePojo(AnimacionEntity.class);
            ArtistaEntity are = pf.manufacturePojo(ArtistaEntity.class);
            em.persist(are);
            ae.setArtista(are);
            em.persist(ae);
            listaA.add(ae);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
            em.createQuery("delete from AnimacionEntity").executeUpdate();
            em.createQuery("delete from ArtistaEntity").executeUpdate();
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
    public void createTest() throws BusinessLogicException {
        AnimacionEntity ae = pf.manufacturePojo(AnimacionEntity.class);
        ae.setArtista(listaA.get(0).getArtista());
        ae.setPrecio(20);
        al.createAnimacion(ae);
        AnimacionEntity ae2 = em.find(AnimacionEntity.class, ae.getId());
        Assert.assertEquals(ae, ae2);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createSinNombreTest() throws BusinessLogicException {
        AnimacionEntity ae = pf.manufacturePojo(AnimacionEntity.class);
        ae.setNombre(null);
        al.createAnimacion(ae);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createSinArtistaTest() throws BusinessLogicException {
        AnimacionEntity ae = pf.manufacturePojo(AnimacionEntity.class);
        ArtistaEntity are = new ArtistaEntity();
        are.setId(Long.MIN_VALUE);
        ae.setArtista(are);
        al.createAnimacion(ae);
    }
    
    @Test(expected = BusinessLogicException.class)
    public void createConPrecioNegativo() throws BusinessLogicException {
        AnimacionEntity ae = pf.manufacturePojo(AnimacionEntity.class);
        ae.setArtista(listaA.get(0).getArtista());
        ae.setPrecio(-1);
        al.createAnimacion(ae);
    }
    
    @Test
    public void getAnimacionTest() {
        AnimacionEntity ae = listaA.get(0);
        AnimacionEntity ae2 = al.getAnimacion(ae.getId());
        Assert.assertNotNull(ae2);
        Assert.assertEquals(ae, ae2);
    }
    
    @Test
    public void getAnimacionesTest() {
        List<AnimacionEntity> result = al.getAnimaciones();
        Assert.assertNotNull(result);
        for(AnimacionEntity ae : result){
            boolean encontro = false;
            for(AnimacionEntity ae2 : listaA){
                if(ae.equals(ae2)){
                    encontro = true;
                }
            }
            Assert.assertTrue(encontro);
        }
    }
    
    @Test
    public void deleteTest() {
        AnimacionEntity ae = listaA.get(0);
        al.deleteAnimacion(ae.getId());
        AnimacionEntity ae2 = em.find(AnimacionEntity.class, ae.getId());
        Assert.assertNull(ae2);
    }
    
}
