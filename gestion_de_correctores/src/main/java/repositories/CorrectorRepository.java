package es.uma.repositories.CorrectorRepository


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import es.uma.informatica.sii.helloworld.entities.Item;

@Repository
public interface CorrectorRepository extends CrudRepository<Corrector, Long> {

}