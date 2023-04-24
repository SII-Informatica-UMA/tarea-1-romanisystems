/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.servicios;

import es.uma.informatica.entidades.Corrector;
import es.uma.informatica.repositories.CorrectoresRepository;
import es.uma.informatica.servicios.excepciones.EntidadNoEncontradaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GestionCorrectoresServicio {

    private final CorrectoresRepository repo;

    @Autowired
    public GestionCorrectoresServicio(CorrectoresRepository correctores) {
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
            throw new EntidadNoEncontradaException();
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
            throw new EntidadNoEncontradaException();
        }
    }

    public void actualizarCorrector(Corrector corrector) {
        if (repo.existsById(corrector.getId())) {
            repo.save(corrector);
        } else {
            throw new EntidadNoEncontradaException();
        }
    }
}
