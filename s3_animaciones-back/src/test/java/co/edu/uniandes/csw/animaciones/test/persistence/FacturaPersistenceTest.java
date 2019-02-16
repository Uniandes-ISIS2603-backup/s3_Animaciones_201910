
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import javax.inject.Inject;
import co.edu.uniandes.csw.animaciones.persistence.FacturaPersistence;
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
 * @author YO (Garc´´ia)
 */
@RunWith(Arquillian.class)
public class FacturaPersistenceTest {
    @Inject
    private FacturaPersistence fp;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Test
    public void createTest(){
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       
       FacturaEntity eTest = fp.create(e);       
       Assert.assertNotNull(eTest);      
       
    }
    
    @Test
    public void findTest(){
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);       
       FacturaEntity eTest = fp.create(e); 
       FacturaEntity fe = em.find(FacturaEntity.class, eTest.getId());
       Assert.assertEquals(e.getIdAnim(), fe.getIdAnim());
    }
    
    @Test
    public void findAllTest(){
       PodamFactory f = new PodamFactoryImpl();
       ArrayList<FacturaEntity> facE = new ArrayList<FacturaEntity>();
       for(int x = 0;x<10;x++){
           FacturaEntity e = f.manufacturePojo(FacturaEntity.class);       
           FacturaEntity eTest = fp.create(e); 
           facE.add(eTest);
       }
       boolean sentry = true;
       List<FacturaEntity> ich = fp.findAll();
       for(FacturaEntity ff: facE){
           boolean tempcheck = false;
           for(FacturaEntity fcheck: ich){
               if(ff.getIdAnim().equals(fcheck.getIdAnim())){
                   tempcheck = true;
               }
           }
           sentry = sentry && tempcheck;
       }
       Assert.assertTrue(sentry);
    }
    
}
