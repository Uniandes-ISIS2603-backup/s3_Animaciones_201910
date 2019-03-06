package co.edu.uniandes.csw.animaciones.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Nicolas Alvarado
 */
@Entity
public class ArtistaEntity extends BaseEntity implements Serializable {
    
    private Boolean privado;
    private String nombre;
    private String tecnina;
    private String tema;
    private String usuario;
    private String contrasenia;
    
    @PodamExclude
    @OneToMany(mappedBy = "artista", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<AnimacionEntity> animaciones = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "artista", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArrayList<PropuestaEntity> propuestas = new ArrayList<>();

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnina() {
        return tecnina;
    }

    public void setTecnina(String tecnina) {
        this.tecnina = tecnina;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<AnimacionEntity> getAnimaciones() {
        return animaciones;
    }

    public void setAnimaciones(ArrayList<AnimacionEntity> animaciones) {
        this.animaciones = animaciones;
    }

    public ArrayList<PropuestaEntity> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(ArrayList<PropuestaEntity> propuestas) {
        this.propuestas = propuestas;
    }
    
    
    
}
