package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.FacturaLogic;
import co.edu.uniandes.csw.animaciones.entities.FacturaEntity;
import co.edu.uniandes.csw.animaciones.entities.MedioDePagoEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.FacturaPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author García de nuevo
 */
@RunWith(Arquillian.class)
public class FacturaLogicTest {
    
    @Inject
    private FacturaLogic facturaLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Test
    public void createFTest() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       FacturaEntity r = facturaLogic.createF(e);
       Assert.assertNotNull(r);
       FacturaEntity fe = em.find(FacturaEntity.class, r.getId());
       Assert.assertEquals(e.getId(), fe.getId());
       Assert.assertEquals(e.getIdAnim(), fe.getIdAnim());
    }
    
    @Test(expected=BusinessLogicException.class)
    public void createFTestException()throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       e.setEstado(null);
       facturaLogic.createF(e);
    }
    
    @Test
    public void getFTest(){
       try{
           PodamFactory f = new PodamFactoryImpl();
           FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
           FacturaEntity r = facturaLogic.createF(e); 
           FacturaEntity em = facturaLogic.getF(e.getId());
           Assert.assertEquals(em.getIdAnim(), e.getIdAnim());
       }catch(BusinessLogicException exc){
           Assert.fail("No se pudo crear el objeto para buscarlos después");
       }
       
    }
    
    @Test
    public void getAllTest(){
       PodamFactory f = new PodamFactoryImpl();
       ArrayList<FacturaEntity> facE = new ArrayList<FacturaEntity>();
       for(int x = 0;x<10;x++){
           FacturaEntity e = f.manufacturePojo(FacturaEntity.class);       
           FacturaEntity eTest; 
           try {
               eTest = facturaLogic.createF(e);
               facE.add(eTest);
           } catch (BusinessLogicException ex) {
               Assert.fail("No se pudo crear la factura: "+ex.getMessage());
           }
           
       }
       boolean sentry = true;
       List<FacturaEntity> ich = facturaLogic.getAllF();
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
    
    @Test
    public void updateFTest()throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       FacturaEntity eTest = facturaLogic.createF(e);
       Integer idTemp = (int) (Math.random() * 1000);
       eTest.setIdAnim(idTemp);
       facturaLogic.updateF(eTest);
       e = facturaLogic.getF(eTest.getId());
       Assert.assertEquals(idTemp, e.getIdAnim());
    }
    
    @Test(expected=BusinessLogicException.class)
    public void updateFTestException() throws BusinessLogicException{
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       FacturaEntity eTest = facturaLogic.createF(e);
       Integer idTemp = (int) (Math.random() * 1000);
       eTest.setIdAnim(idTemp);
       eTest.setEstado(null);
       facturaLogic.updateF(eTest);
    }
    
    public void deleteFTest(){
       PodamFactory f = new PodamFactoryImpl();
       FacturaEntity e = f.manufacturePojo(FacturaEntity.class);
       try{
            FacturaEntity eTest = facturaLogic.createF(e);
            Long id = eTest.getId();
            facturaLogic.deleteF(id);
            FacturaEntity fe = facturaLogic.getF(id);
            Assert.assertNull(fe);
       }catch (BusinessLogicException exc){
           Assert.fail("El test de DELETE falló: "+exc.getMessage());
       }
    }
}
