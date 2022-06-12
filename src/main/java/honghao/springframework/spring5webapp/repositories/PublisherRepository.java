package honghao.springframework.spring5webapp.repositories;

import honghao.springframework.spring5webapp.domain.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
