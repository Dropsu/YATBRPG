package ds.game.hero;

import ds.account.Account;
import ds.game.entities.Mage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Damian on 24.06.2017.
 */
@RepositoryRestResource
public interface MageRepository extends CrudRepository <Mage,Long> {
}
