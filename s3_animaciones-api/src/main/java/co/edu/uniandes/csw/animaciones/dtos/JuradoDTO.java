package co.edu.uniandes.csw.animaciones.dtos;
import co.edu.uniandes.csw.animaciones.entities.JuradoEntity;
import java.io.Serializable;

/**
 *
 * @author by.cuta10
 */
public class JuradoDTO implements Serializable{

    /**
     * @return the concurso
     */
    public ConcursoDTO getConcurso() {
        return concurso;
    }

    /**
     * @param concurso the concurso to set
     */
    public void setConcurso(ConcursoDTO concurso) {
        this.concurso = concurso;
    }
    
    /**
     * Atributo que contien la credencial del jurado
     */
    String credencial;
    /**
     * Atributo que contiene el nombre del jurado
     */
    String usuario;
    /**
     * Atributo que contiene la contrasena del jurado
     */
    String contrasena;
    /**
     * Atributo que contiene el id del jurado
     */

    Long id;
    /**
     * Atributo que contiene el DTOConcurso
     */
    private ConcursoDTO concurso;
    /**
     * Atributo que contiene las votaciones que el jurado ha hecho
     */
    private List<VotacionDTO> votaciones;
    

    /**
     * Contructor vacio de Jurado DTO
     */
    public JuradoDTO (){}
    
    /**
     * Metodo que permite la creacion de un JuradoDTO a partir de un jurado
     * entity
     * @param j JuradEntity que entra como parametro
     */
    public JuradoDTO (JuradoEntity j){
        if(j!=null){
        this.credencial=j.getCredencial();
        this.usuario=j.getUsuario();
        this.id=j.getId(); 
        this.contrasena=j.getContrasena();
    }
    
    /**
     * Metodo que genera un Enitty de Jurado
     * @return el Entity de Jurado
     */
    public JuradoEntity toEntity(){
     JuradoEntity r=new JuradoEntity();
     r.setContrasena(this.contrasena);
     r.setUsuario(this.usuario);
     r.setCredencial(this.credencial);

     return r;
    }

    
    /**
     * Metodo que retorna el conccursoDTO
     * @return el atributo concurso
     */
    public ConcursoDTO getConcursoDTO (){
        return getConcurso();
    }
    
    /**
     * Cambia el valor de concurso con el nuevo concurso que entra como parametro
     * @param pConcurso nuevo concursoDTO 
     */
    public void setConcursoDTO (ConcursoDTO pConcurso){
        setConcurso(pConcurso);
    }
    

    /**
     * 
     * @return  la credencial 
     */
    public String getCredencial (){
        return credencial;
    }
    
    /**
     * @param pCredencial la credencial a cambiar
     */
    public void setCredencial (String pCredencial){
        credencial = pCredencial;
    }
    
    /**
     * @return  el usuario
     */
    public String getUsuario(){
        return usuario;
    }
    
    /**
     * @param pUsuario 
     */
    public void setUsuario(String pUsuario){
        usuario = pUsuario;
    }
    /**
     * Obtiene la contrasena del Jurado
     * @return  contrasena
     */
    public String getContrasena(){
        return contrasena;
    }
    /**
     * Cambia la contrasena por la que entra como parametro
     * @param pContrasena  
     */
    public void setContrasena (String pContrasena){
        contrasena = pContrasena;
    }
    /**
     * Retorna el id del jurado
     * @return Id 
     */
    public Long getId (){
        return id;
    }
    /**
     * Cambia el id del jurado
     * @param pId 
     */
    public void setId (Long pId){
        id = pId;
    }
    /**
     * Da un nuevo jurado entity
     * @return  jurado entity
     */
    public JuradoEntity juradoEntity(){
    return new JuradoEntity();

    }
    
}
