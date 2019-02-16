
package co.edu.uniandes.csw.animaciones.test.persistence;
import co.edu.uniandes.csw.animaciones.entities.AnimacionGanadoraEntity;
import co.edu.uniandes.csw.animaciones.persistence.AnimacionGanadoraPersistence;
import java.util.ArrayList;
import java.util.List;
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
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class AnimacionGanadoraPersistenceTest{

    /**
     * Inyección de la dependencia a la clase EditorialPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private AnimacionGanadoraPersistence animacionGanadoraPersistence; 
     

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Lista que tiene los datos de prueba.
     */
    private List<AnimacionGanadoraEntity> data = new ArrayList<AnimacionGanadoraEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AnimacionGanadoraEntity.class.getPackage())
                .addPackage(AnimacionGanadoraPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from AnimacionGanadoraEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

            AnimacionGanadoraEntity entity = factory.manufacturePojo(AnimacionGanadoraEntity.class);

            em.persist(entity);

            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Editorial.
     *
     *
     */
    @Test
    public void createEditorialTest() {
        PodamFactory factory = new PodamFactoryImpl();
        AnimacionGanadoraEntity newEntity = factory.manufacturePojo(AnimacionGanadoraEntity.class);
        AnimacionGanadoraEntity result = animacionGanadoraPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AnimacionGanadoraEntity entity = em.find(AnimacionGanadoraEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para eliminar una Editorial.
     *
     *
     */
    @Test
    public void deleteEditorialTest() {
        AnimacionGanadoraEntity entity = data.get(0);
        animacionGanadoraPersistence.delete(entity.getId());
        AnimacionGanadoraEntity deleted = em.find(AnimacionGanadoraEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    
}


