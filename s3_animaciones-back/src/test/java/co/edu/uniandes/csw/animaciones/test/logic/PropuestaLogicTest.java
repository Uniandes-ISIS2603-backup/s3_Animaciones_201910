package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.PropuestaLogic;
import co.edu.uniandes.csw.animaciones.entities.PropuestaEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.PropuestaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
 * @author PZ&EOT
 */
@RunWith(Arquillian.class)
public class PropuestaLogicTest {
    
    @Inject
    private PropuestaLogic propuestaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PropuestaEntity.class.getPackage())
                .addPackage(PropuestaLogic.class.getPackage())
                .addPackage(PropuestaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Test
    public void createPTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       e.setPrecio(Math.abs(e.getPrecio()));
       PropuestaEntity r = propuestaLogic.createP(e);
       Assert.assertNotNull(r);
       PropuestaEntity fe = em.find(PropuestaEntity.class, r.getId());
       Assert.assertEquals(e.getId(), fe.getId());
       Assert.assertEquals(e.getPrecio(), fe.getPrecio());
    }
    
    @Test(expected=BusinessLogicException.class)
    public void createPTestException() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       e.setPrecio((Math.abs(e.getPrecio())*-1)-1);
       PropuestaEntity r = propuestaLogic.createP(e);

    }
    
    @Test
    public void getPTest(){
       try{
           PodamFactory f = new PodamFactoryImpl();
           PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
           e.setPrecio(Math.abs(e.getPrecio()));
           PropuestaEntity r = propuestaLogic.createP(e); 
           PropuestaEntity em = propuestaLogic.getP(e.getId());
           Assert.assertEquals(em.getPrecio(), e.getPrecio());
       }catch(BusinessLogicException exc){
           Assert.fail("No se pudo crear el objeto para buscarlos después");
       }
       
    }
    
    @Test
    public void getAllTest(){
       PodamFactory f = new PodamFactoryImpl();
       ArrayList<PropuestaEntity> facE = new ArrayList<PropuestaEntity>();
       for(int x = 0;x<10;x++){
           PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
           e.setPrecio(Math.abs(e.getPrecio()));
           PropuestaEntity eTest; 
           try {
               eTest = propuestaLogic.createP(e);
               facE.add(eTest);
           } catch (BusinessLogicException ex) {
               Assert.fail("No se pudo crear la factura: "+ex.getMessage());
           }
           
       }
       boolean sentry = true;
       List<PropuestaEntity> ich = propuestaLogic.getAllP();
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
    public void updatePTest()throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       e.setPrecio(Math.abs(e.getPrecio()));
       PropuestaEntity eTest = propuestaLogic.createP(e);
       Integer idTemp = (int)Math.abs(Math.random() * 1000);
       eTest.setPrecio(idTemp);
       propuestaLogic.updateP(eTest);
       e = propuestaLogic.getP(eTest.getId());
       Assert.assertEquals(idTemp, e.getPrecio());
    }
    
    @Test(expected=BusinessLogicException.class)
    public void updatePTestException() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       PropuestaEntity eTest = propuestaLogic.createP(e);
       Integer idTemp = (int)-Math.abs(Math.random() * 1000);
       eTest.setPrecio(idTemp);
       propuestaLogic.updateP(eTest);
    }
    
    public void deleteFTest(){
       PodamFactory f = new PodamFactoryImpl();
       PropuestaEntity e = f.manufacturePojo(PropuestaEntity.class);
       e.setPrecio(Math.abs(e.getPrecio()));
       try{
            PropuestaEntity eTest = propuestaLogic.createP(e);
            Long id = eTest.getId();
            propuestaLogic.deleteP(id);
            PropuestaEntity fe = propuestaLogic.getP(id);
            Assert.assertNull(fe);
       }catch (BusinessLogicException exc){
           Assert.fail("El test de DELETE falló: "+exc.getMessage());
       }
    }
}
