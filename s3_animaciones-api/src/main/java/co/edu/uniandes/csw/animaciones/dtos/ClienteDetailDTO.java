/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.animaciones.dtos;

import co.edu.uniandes.csw.animaciones.entities.ClienteEntity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ld.manrique
 */
public class ClienteDetailDTO extends ClienteDTO implements Serializable{
    
 
    ArrayList<PropuestaDTO> propuestas;
    ArrayList<MedioDePagoDTO> mediosPago;
    
    
    public ClienteDetailDTO()
    {
        super();
    }
    
  /**
     * Crea un objeto ClienteDetailDTO a partir de un objeto ClienterEntity
     * incluyendo los atributos de AuthorDTO.
     *
     * @param entity Entidad AuthorEntity desde la cual se va a crear el
     * nuevo objeto.
     *
     */
//    public ClienteDetailDTO(ClienteEntity entity) {
//        super(entity);
//        if (entity != null) {
//            propuestas = new ArrayList<>();
//            for (PropuestaEntity entityPropuestas : entity.getBooks()) {
//                books.add(new BookDTO(entityBooks));
//            }
//            prizes = new ArrayList();
//            for (PrizeEntity entityPrize : authorEntity.getPrizes()) {
//                prizes.add(new PrizeDTO(entityPrize));
//            }
//        }
//    }

    /**
     * Convierte un objeto AuthorDetailDTO a AuthorEntity incluyendo los
     * atributos de AuthorDTO.
     *
     * @return Nueva objeto AuthorEntity.
     *
     */
//    @Override
//    public AuthorEntity toEntity() {
//        AuthorEntity authorEntity = super.toEntity();
//        if (books != null) {
//            List<BookEntity> booksEntity = new ArrayList<>();
//            for (BookDTO dtoBook : books) {
//                booksEntity.add(dtoBook.toEntity());
//            }
//            authorEntity.setBooks(booksEntity);
//        }
//        if (prizes != null) {
//            List<PrizeEntity> prizesEntity = new ArrayList<>();
//            for (PrizeDTO dtoPrize : prizes) {
//                prizesEntity.add(dtoPrize.toEntity());
//            }
//            authorEntity.setPrizes(prizesEntity);
//        }
//        return authorEntity;
//    }
    
    


    public ArrayList<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(ArrayList<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
    
        public ArrayList<MedioDePagoDTO> getMediosDePago() {
        return mediosPago;
    }

    public void setMediosDePago(ArrayList<MedioDePagoDTO> mediosPago) {
        this.mediosPago = mediosPago;
    }
}
