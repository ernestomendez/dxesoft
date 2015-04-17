package mx.com.dxesoft.dxesoft.repository;

import mx.com.dxesoft.dxesoft.domain.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Authority entity.
 */
public interface AuthorityRepository extends MongoRepository<Authority, String> {
}
