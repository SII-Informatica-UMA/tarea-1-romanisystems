/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.controladores;

import es.uma.informatica.entidades.Notificacion;
import es.uma.informatica.servicios.NotificacionServicio;
import es.uma.informatica.servicios.excepciones.EntidadNoEncontradaException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/notificaciones")
public class NotificacionControlador {

    private final NotificacionServicio servicio;
    private ModelMapper modelMapper;

    @Autowired
    public NotificacionControlador(NotificacionServicio service) {
        this.servicio = service;
    }

    @GetMapping
    public List<Notificacion> obtenerNotificaciones() {
        List<Notificacion> notificaciones = servicio.obtenerNotificaciones();
        return notificaciones.stream().toList();
    }

    @GetMapping
    public List<Notificacion> obtenerNotificaciones(@PathVariable String tipo, @PathVariable String estado) {
        List<Notificacion> notificaciones = servicio.obtenerNotificaciones(tipo, estado);
        return notificaciones.stream().toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Notificacion obtenerNotificacion(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        Notificacion notificacion = servicio.obtenerNotificacionById(id);
        return notificacion;
    }

    @PostMapping
    public ResponseEntity<?> aniadirNotificacion(@RequestBody Notificacion nuevaNotificacion, UriComponentsBuilder builder) {
        Notificacion notificacion = modelMapper.map(nuevaNotificacion, Notificacion.class);
        notificacion.setId(null);
        Long id = servicio.aniadirNotificacion(notificacion);
        URI uri = builder.path("/notificaciones")
                .path(String.format("/%d", id))
                .build()
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminarNotitficacion(@PathVariable Long id) {
        servicio.eliminarNotificacion(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity modificaNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        notificacion.setId(id);
        servicio.actualizarNotificacion(notificacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pendientes/abortar")
    public void abortarPendientes(){
        servicio.abortarPendientes();
    }
    
    @GetMapping("/pendientes/abortar/{tipo}")
    public void abortarPendientes(@PathVariable String tipo){
        servicio.abortarPendientes(tipo);
    }
    
    @ExceptionHandler(EntidadNoEncontradaException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void noEncontrado() {

    }
}
