/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.servicios;

import es.uma.informatica.entidades.Notificacion;
import es.uma.informatica.repositories.NotificacionRepository;
import es.uma.informatica.servicios.excepciones.EntidadNoEncontradaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificacionServicio {

    private final NotificacionRepository repo;

    @Autowired
    public NotificacionServicio(NotificacionRepository notification) {
        this.repo = notification;
    }

    public List<Notificacion> obtenerNotificaciones() {
        List<Notificacion> listaNotificaciones = new ArrayList<>();

        for (Notificacion notificacion : repo.findAll()) {
            listaNotificaciones.add(notificacion);
        }

        return listaNotificaciones;

    }

    public List<Notificacion> obtenerNotificaciones(String tipo, String estado) {
        List<Notificacion> listaNotificaciones = new ArrayList<>();

        for (Notificacion notificacion : repo.findAll()) {
            if (estado.equals(notificacion.getEstado()) && tipo.equals(notificacion.getTipo())) {
                listaNotificaciones.add(notificacion);
            }
        }

        return listaNotificaciones;
    }

    public Notificacion obtenerNotificacionById(Long id) {
        Optional<Notificacion> notificacion = repo.findById(id);
        if (notificacion.isEmpty()) {
            throw new EntidadNoEncontradaException();
        } else {
            return notificacion.get();
        }
    }

    public Long aniadirNotificacion(Notificacion notificacion) {
        repo.save(notificacion);
        return notificacion.getId();
    }

    public void eliminarNotificacion(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new EntidadNoEncontradaException();
        }
    }

    public void actualizarNotificacion(Notificacion notificacion) {
        if (repo.existsById(notificacion.getId())) {
            repo.save(notificacion);
        } else {
            throw new EntidadNoEncontradaException();
        }
    }

    public void abortarPendientes(String tipo) {
        for (Notificacion notificacion : repo.findAll()) {
            if (notificacion.getEstado().equals("PENDIENTE") && notificacion.getTipo().equals(tipo)) {
                Optional<Notificacion> res = repo.findById(notificacion.getId());
                Notificacion abortar = res.get();
                abortar.setEstado("ABORTADA");
                repo.save(abortar);
            }

        }
    }

    public void abortarPendientes() {
        for (Notificacion notificacion : repo.findAll()) {
            if (notificacion.getEstado().equals("PENDIENTE")) {
                Optional<Notificacion> res = repo.findById(notificacion.getId());
                Notificacion abortar = res.get();
                abortar.setEstado("ABORTADA");
                repo.save(abortar);
            }
        }
    }
}
