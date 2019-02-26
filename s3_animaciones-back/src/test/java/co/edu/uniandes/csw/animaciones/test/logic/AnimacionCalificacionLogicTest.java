package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.AnimacionCalificacionLogic;
import co.edu.uniandes.csw.animaciones.ejb.CalificacionLogic;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import co.edu.uniandes.csw.animaciones.entities.CalificacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionPersistence;
import java.util.ArrayList;
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
public class AnimacionCalificacionLogicTest {
    
    private PodamFactory pf = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction ut;
    
    @Inject
    private CalificacionLogic cl;
    
    @Inject
    private AnimacionCalificacionLogic acl;
    
    AnimacionEntity ae = new AnimacionEntity();
    ArrayList<CalificacionEntity> listCal = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimacionEntity.class.getPackage())
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(AnimacionCalificacionLogic.class.getPackage())
                .addPackage(AnimacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    private void insertData() {
        ae = pf.manufacturePojo(AnimacionEntity.class);
        ae.setCalificaciones(new ArrayList<>());
        em.persist(ae);
        
        for(int i = 0; i < 5; i++) {
            CalificacionEntity ce = pf.manufacturePojo(CalificacionEntity.class);
            ce.setAnimacion(ae);
            em.persist(ce);
            listCal.add(ce);
            ae.getCalificaciones().add(ce);
        }
    }
    
    @Before
    public void configTest() {
        try {
            ut.begin();
            em.createQuery("delete from CalificacionEntity").executeUpdate();
            em.createQuery("delete from AnimacionEntity").executeUpdate();
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
    public void addCalificacionTest() throws BusinessLogicException {
        CalificacionEntity nueva = pf.manufacturePojo(CalificacionEntity.class);
        nueva.setAnimacion(ae);
        cl.create(nueva);
        
        CalificacionEntity result1 = acl.addCalificacion(ae.getId(), nueva.getId());
        Assert.assertNotNull(result1);
        Assert.assertEquals(result1, nueva);
        
        CalificacionEntity result2 = acl.getAimacion(ae.getId(), nueva.getId());
        Assert.assertEquals(result2, nueva);
    }
    
}
