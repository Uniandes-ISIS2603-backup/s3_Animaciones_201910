/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.test.logic;

import co.edu.uniandes.csw.animaciones.ejb.JuradoLogic;
import co.edu.uniandes.csw.animaciones.ejb.JuradoVotacionLogic;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import co.edu.uniandes.csw.animaciones.entities.VotacionEntity;
import co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animaciones.persistence.JuradoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de logica de la relacion Jurado - Votacions
 *
 * @author by.cuta10
 */
@RunWith(Arquillian.class)
public class JuradoVotacionLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private JuradoLogic juradoLogic;
    @Inject
    private JuradoVotacionLogic juradoVotacionsLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<JuradoEntity> data = new ArrayList<JuradoEntity>();

    private List<VotacionEntity> votacionsData = new ArrayList();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(JuradoEntity.class.getPackage())
                .addPackage(JuradoLogic.class.getPackage())
                .addPackage(JuradoPersistence.class.getPackage())
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
     */
    private void clearData() {
        em.createQuery("delete from VotacionEntity").executeUpdate();
        em.createQuery("delete from JuradoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            VotacionEntity votacions = factory.manufacturePojo(VotacionEntity.class);
            em.persist(votacions);
            votacionsData.add(votacions);
        }
        for (int i = 0; i < 3; i++) {
            JuradoEntity entity = factory.manufacturePojo(JuradoEntity.class);
            em.persist(entity);
            data.add(entity);
            if (i == 0) {
                votacionsData.get(i).setJurado(entity);
            }
        }
    }

    /**
     * Prueba para asociar un Votacions existente a un Jurado.
     */
    @Test
    public void addVotacionsTest() {
        JuradoEntity entity = data.get(0);
        VotacionEntity votacionEntity = votacionsData.get(1);
        VotacionEntity response = juradoVotacionsLogic.addVotacion(votacionEntity.getId(), entity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(votacionEntity.getId(), response.getId());
    }

    /**
     * Prueba para obtener una colección de instancias de Votacions asociadas a una
     * instancia Jurado.
     */
    @Test
    public void getVotacionsTest() {
        List<VotacionEntity> list = juradoVotacionsLogic.getVotaciones(data.get(0).getId());

        Assert.assertEquals(1, list.size());
    }

    /**
     * Prueba para obtener una instancia de Votacions asociada a una instancia
     * Jurado.
     *
     * @throws co.edu.uniandes.csw.animaciones.exceptions.BusinessLogicException
     */
    @Test
    public void getVotacionTest() throws BusinessLogicException {
        JuradoEntity entity = data.get(0);
        VotacionEntity votacionEntity = votacionsData.get(0);
        VotacionEntity response = juradoVotacionsLogic.getVotacion(entity.getId(), votacionEntity.getId());

        Assert.assertEquals(votacionEntity.getId(), response.getId());
        Assert.assertEquals(votacionEntity.getIdAnimacion(), response.getIdAnimacion());
        Assert.assertEquals(votacionEntity.getNumRonda(), response.getNumRonda());
        Assert.assertEquals(votacionEntity.getPuntos(), response.getPuntos());

    }

    /**
     * Prueba para obtener una instancia de Votacions asociada a una instancia
     * Jurado que no le pertenece.
     *
     * @throws co.edu.uniandes.csw.votacionstore.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void getVotacionNoAsociadoTest() throws BusinessLogicException {
        JuradoEntity entity = data.get(0);
        VotacionEntity votacionEntity = votacionsData.get(1);
        juradoVotacionsLogic.getVotacion(entity.getId(), votacionEntity.getId());
    }

    /**
     * Prueba para remplazar las instancias de Votacions asociadas a una instancia
     * de Jurado.
     */
    @Test
    public void replaceVotacionsTest() {
        JuradoEntity entity = data.get(0);
        List<VotacionEntity> list = votacionsData.subList(1, 3);
        juradoVotacionsLogic.replaceVotaciones(entity.getId(), list);

        entity = juradoLogic.getJurado(entity.getId());
        Assert.assertFalse(entity.getVotaciones().contains(votacionsData.get(0)));
        Assert.assertTrue(entity.getVotaciones().contains(votacionsData.get(1)));
        Assert.assertTrue(entity.getVotaciones().contains(votacionsData.get(2)));
    }
    
}
