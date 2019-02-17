
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.persistence;

import co.edu.uniandes.csw.animaciones.entities.RondaEntity;
import co.edu.uniandes.csw.animaciones.persistence.RondaPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class RondaPersistenceTest {
    
      @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RondaEntity.class.getPackage())
                .addPackage(RondaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private RondaPersistence rondaDePrueba;
       
    @Test
    public void createEditorialTest() {
        PodamFactory factory = new PodamFactoryImpl();
        RondaEntity newEntity = factory.manufacturePojo(RondaEntity.class);
        RondaEntity result = rondaDePrueba.create(newEntity);

        Assert.assertNotNull(result);
    }
}