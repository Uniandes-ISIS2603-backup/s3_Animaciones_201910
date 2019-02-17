
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import javax.inject.Inject;
import co.edu.uniandes.csw.animaciones.persistence.PropuestaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author YO (Garc´´ia) (otra vez)
 */
@RunWith(Arquillian.class)
public class PropuestaPersistenceTest {
    @Inject
    private PropuestaPersistence fp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PropuestaEntity.class.getPackage())
                .addPackage(PropuestaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Test
    public void createTest(){
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       
       PropuestaEntity eTest = fp.create(e);       
       Assert.assertNotNull(eTest);
    }
    
    @Test
    public void findTest(){
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);       
       PropuestaEntity eTest = fp.create(e); 
       PropuestaEntity fe = em.find(PropuestaEntity.class, eTest.getId());
       Assert.assertEquals(e.getPrecio(), fe.getPrecio());
    }
    
    @Test
    public void findAllTest(){
       PodamFactory f = new PodamFactoryImpl();
       ArrayList<PropuestaEntity> facE = new ArrayList<PropuestaEntity>();
       for(int x = 0;x<10;x++){
           PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);       
           PropuestaEntity eTest = fp.create(e); 
           facE.add(eTest);
       }
       boolean sentry = true;
       List<PropuestaEntity> ich = fp.findAll();
       for(PropuestaEntity ff: facE){
           boolean tempcheck = false;
           for(PropuestaEntity fcheck: ich){
               if(ff.getPrecio().equals(fcheck.getPrecio())){
                   tempcheck = true;
               }
           }
           sentry = sentry && tempcheck;
       }
       Assert.assertTrue(sentry);
    }
    
    @Test
    public void updateTest(){
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       PropuestaEntity eTest = fp.create(e);
       Integer idTemp = (int) (Math.random() * 1000);
       eTest.setPrecio(idTemp);
       fp.update(eTest);
       e = fp.find(eTest.getId());
       Assert.assertEquals(idTemp, e.getPrecio());
    }
    
    @Test
    public void deleteTest(){
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       PropuestaEntity eTest = fp.create(e);
       Long id = eTest.getId();
       fp.delete(id);
       PropuestaEntity fe = em.find(PropuestaEntity.class, id);
       Assert.assertNull(fe);
    }
    
}
