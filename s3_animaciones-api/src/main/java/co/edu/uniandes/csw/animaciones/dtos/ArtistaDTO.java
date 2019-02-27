package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ArtistaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Nicolas Alvarado
 */
public class ArtistaDTO implements Serializable{
    
    private Long id;
    private String contraseña;
    private String usuario;
    private String tema;
    private String tecnica;
    private String nombre;
    private Boolean privado;
    
    public ArtistaDTO(){
        
    }

    ArtistaDTO(ArtistaEntity artista) {
        if(artista != null){
            this.id = artista.getId();
            this.contraseña = artista.getContraseña();
            this.usuario = artista.getUsuario();
            this.tema = artista.getTema();
            this.tecnica = artista.getTecnina();
            this.nombre = artista.getNombre();
            this.privado = artista.getPrivado();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    public ArtistaEntity toEntity(){
        ArtistaEntity ae = new ArtistaEntity();
        ae.setId(id);
        ae.setContraseña(contraseña);
        ae.setUsuario(usuario);
        ae.setTema(tema);
        ae.setTecnina(tecnica);
        ae.setNombre(nombre);
        ae.setPrivado(privado);
        return ae;
    }
    
}
