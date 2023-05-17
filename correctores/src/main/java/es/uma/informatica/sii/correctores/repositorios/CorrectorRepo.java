package es.uma.informatica.sii.correctores.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uma.informatica.sii.correctores.entidades.Corrector;

@Repository
public interface CorrectorRepo extends JpaRepository<Corrector, Long> {

}
