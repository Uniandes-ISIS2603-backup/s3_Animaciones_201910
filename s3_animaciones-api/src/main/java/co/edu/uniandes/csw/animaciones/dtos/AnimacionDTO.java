package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.adapters.DateAdapter;
import co.edu.uniandes.csw.animaciones.entities.AnimacionEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Nicolas Alvarado
 */
public class AnimacionDTO implements Serializable{
    
    private Long id;
    private String nombre;
    private String descripcionn;
    private Integer precio;
    private String tecnica;
    private String tags;
    private String link;
    private Double calificacion;
    
    private ArtistaDTO artista;
    
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fecha;
    
    public AnimacionDTO(){
        
    }
    
    public AnimacionDTO(AnimacionEntity ae){
        if(ae != null){
            this.id = ae.getId();
            this.nombre = ae.getNombre();
            this.descripcionn = ae.getDescripcion();
            this.precio = ae.getPrecio();
            this.tecnica = ae.getTecnica();
            this.tags = ae.getTags();
            this.link = ae.getLink();
            this.calificacion = ae.getCalificacion();
            this.fecha = ae.getFecha();
            if(ae.getArtista() != null){
                this.artista = new ArtistaDTO(ae.getArtista());
            }
            else{
                this.artista = null;
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionn() {
        return descripcionn;
    }

    public void setDescripcionn(String descripcionn) {
        this.descripcionn = descripcionn;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    public AnimacionEntity toEntity(){
        AnimacionEntity ae = new AnimacionEntity();
        ae.setId(id);
        ae.setNombre(nombre);
        ae.setDescripcion(descripcionn);
        ae.setPrecio(precio);
        ae.setTecnica(tecnica);
        ae.setTags(tags);
        ae.setLink(link);
        ae.setCalificacion(calificacion);
        ae.setFecha(fecha);
        if(this.getArtista() != null){
            System.out.println("===========================================================");
            ae.setArtista(getArtista().toEntity());
        }
        return ae;
    }

    /**
     * @return the artista
     */
    public ArtistaDTO getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(ArtistaDTO artista) {
        this.artista = artista;
    }
    
}
