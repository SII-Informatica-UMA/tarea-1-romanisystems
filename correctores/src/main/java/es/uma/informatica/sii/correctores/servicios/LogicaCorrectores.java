package es.uma.informatica.sii.correctores.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uma.informatica.sii.correctores.entidades.Corrector;
import es.uma.informatica.sii.correctores.repositorios.CorrectorRepo;
import es.uma.informatica.sii.correctores.servicios.excepciones.EntidadNoEncontrada;
import java.util.ArrayList;

@Service
@Transactional
public class LogicaCorrectores {
	
    private CorrectorRepo repo;

    @Autowired
    public LogicaCorrectores(CorrectorRepo correctores) {
        this.repo = correctores;
    }

    public List<Corrector> obtenerCorrectores() {
        List<Corrector> listaCorrectores = new ArrayList<>();

        for (Corrector corrector : repo.findAll()) {
            listaCorrectores.add(corrector);
        }

        return listaCorrectores;
    }

    public Corrector obtenerCorrectorById(Long id) {
        Optional<Corrector> corrector = repo.findById(id);
        if (corrector.isEmpty()) {
            throw new EntidadNoEncontrada();
        } else {
            return corrector.get();
        }
    }

    public Long aniadirCorrector(Corrector corrector) {
        repo.save(corrector);
        return corrector.getId();
    }

    public void eliminarCorrector(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new EntidadNoEncontrada();
        }
    }

    public void actualizarCorrector(Corrector corrector) {
        if (repo.existsById(corrector.getId())) {
            repo.save(corrector);
        } else {
            throw new EntidadNoEncontrada();
        }
    }
	
}
