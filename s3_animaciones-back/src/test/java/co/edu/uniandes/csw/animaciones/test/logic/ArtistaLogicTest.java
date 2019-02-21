package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.ArtistaLogic;
import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.ArtistaPersistence;
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
public class ArtistaLogicTest {
    
    private PodamFactory pf = new PodamFactoryImpl();
    
    @Inject
    private ArtistaLogic al;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utrans;
    
    private List<ArtistaEntity> listaA = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArtistaEntity.class.getPackage())
                .addPackage(ArtistaLogic.class.getPackage())
                .addPackage(ArtistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        for(int i = 0; i < 5; i++){
            ArtistaEntity ae = pf.manufacturePojo(ArtistaEntity.class);
            em.persist(ae);
            listaA.add(ae);
        }
    }
    
    @Before
    public void config() {
        try{
            utrans.begin();
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
        ArtistaEntity ae = pf.manufacturePojo(ArtistaEntity.class);
        al.createArtista(ae);
        ArtistaEntity ae2 = em.find(ArtistaEntity.class, ae.getId());
        Assert.assertEquals(ae, ae2);
    }
    
    // TODO 
    
}
