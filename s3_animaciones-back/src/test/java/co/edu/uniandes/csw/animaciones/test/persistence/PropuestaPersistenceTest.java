
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import javax.inject.Inject;
import co.edu.uniandes.csw.animaciones.persistence.PropuestaPersistence;
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
       
       PropuestaEntity fe = em.find(PropuestaEntity.class, eTest.getId());
       Assert.assertEquals(e.getPrecio(), fe.getPrecio());
    }
    
}
