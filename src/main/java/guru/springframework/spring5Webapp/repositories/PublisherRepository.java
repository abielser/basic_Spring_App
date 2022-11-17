package guru.springframework.spring5Webapp.repositories;

import guru.springframework.spring5Webapp.damain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
