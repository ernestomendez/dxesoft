package mx.com.dxesoft.dxesoft.repository;

import mx.com.dxesoft.dxesoft.domain.PersistentToken;
import mx.com.dxesoft.dxesoft.domain.User;
import org.joda.time.LocalDate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data MongoDB repository for the PersistentToken entity.
 */
public interface PersistentTokenRepository extends MongoRepository<PersistentToken, String> {

    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);

}
