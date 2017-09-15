package ds.account.repositories;

import ds.game.entities.basic.Mage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Damian on 24.06.2017.
 */
@RepositoryRestResource
public interface MageRepository extends CrudRepository <Mage,Long> {
}
