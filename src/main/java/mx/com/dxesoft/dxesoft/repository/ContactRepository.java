package mx.com.dxesoft.dxesoft.repository;

import mx.com.dxesoft.dxesoft.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Contact entity.
 */
public interface ContactRepository extends MongoRepository<Contact,String> {

}
