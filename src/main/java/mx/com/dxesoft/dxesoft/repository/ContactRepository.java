package mx.com.dxesoft.dxesoft.repository;

import mx.com.dxesoft.dxesoft.domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 * Spring Data MongoDB repository for the Contact entity.
 */
public interface ContactRepository extends MongoRepository<Contact,String> {

//    Page<Contact> findByNombresContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCase(String name, String apellidoPaterno, String apellidoMaterno, Pageable pageable);

    @Query("{'$or' : [{'nombres' : {$regex: ?0, $options: 'i'}}, {'apellidoPaterno' : {$regex: ?1, $options: 'i'}}, {'apellidoMaterno' : {$regex: ?2, $options: 'i'}}]}")
    Page<Contact> findByNombresContainingOrApellidoPaternoContainingOrApellidoMaternoContainingQuery(String name, String apellidoPaterno, String apellidoMaterno, Pageable pageable);
}
