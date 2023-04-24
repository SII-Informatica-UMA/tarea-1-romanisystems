/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.controladores;

import es.uma.informatica.dtos.NotificacionDTO;
import es.uma.informatica.entidades.Notificacion;
import es.uma.informatica.servicios.NotificacionServicio;
import es.uma.informatica.servicios.excepciones.EntidadNoEncontradaException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import java.net.URI;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/notificaciones")
public class NotificacionControlador {
    private final NotificacionServicio servicio;

    @Autowired
    public NotificacionControlador(NotificacionServicio service) {
        this.servicio = service;
    }

    @GetMapping
    public List<NotificacionDTO> obtenerNotificaciones() {
        List<Notificacion> notificaciones = servicio.obtenerNotificaciones();
        return notificaciones.stream().map(not -> NotificacionDTO.fromNotificacion(not)).toList();
    }
    
    @GetMapping
    public List<NotificacionDTO> obtenerNotificaciones(@RequestParam String query) {
        List estados = Arrays.asList("PENDIENTE", "ENVIADO", "ABORTADA", "ERROR");
        List<Notificacion> notificaciones;
        if(estados.contains(query)){
            notificaciones = servicio.obtenerNotificaciones("", query);
        }else{
            notificaciones = servicio.obtenerNotificaciones(query, "");
        }
        return notificaciones.stream().map(not -> NotificacionDTO.fromNotificacion(not)).toList();
    }

    @GetMapping
    public List<NotificacionDTO> obtenerNotificaciones(@RequestParam("tipo") String tipo, @RequestParam("estado") String estado) {
        List<Notificacion> notificaciones = servicio.obtenerNotificaciones(tipo, estado);
        return notificaciones.stream().map(not -> NotificacionDTO.fromNotificacion(not)).toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public NotificacionDTO obtenerNotificacion(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        Notificacion notificacion = servicio.obtenerNotificacionById(id);
        return NotificacionDTO.fromNotificacion(notificacion);
    }

    @PostMapping
    public ResponseEntity<?> aniadirNotificacion(@RequestBody NotificacionDTO nuevaNotificacion, UriComponentsBuilder builder) {
        Long id = servicio.aniadirNotificacion(nuevaNotificacion.notificacion());
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
    public ResponseEntity modificaNotificacion(@PathVariable Long id, @RequestBody NotificacionDTO notificacion) {
        Notificacion not = notificacion.notificacion();
        not.setId(id);
        servicio.actualizarNotificacion(not);
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
