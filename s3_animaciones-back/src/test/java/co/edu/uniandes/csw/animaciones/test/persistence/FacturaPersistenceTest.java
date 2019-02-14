
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import javax.inject.Inject;
import co.edu.uniandes.csw.animaciones.persistence.FacturaPersistence;
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
    
    @Deployment
    public static JavaArchive createDeploymment(){
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
    
}
