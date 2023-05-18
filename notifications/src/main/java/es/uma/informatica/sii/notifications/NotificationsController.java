<<<<<<<< Updated upstream:notifications/src/main/java/es/uma/informatica/sii/notifications/controladores/NotificationsController.java
========
package es.uma.informatica.sii.notifications;

>>>>>>>> Stashed changes:notifications/src/main/java/es/uma/informatica/sii/notifications/NotificationsController.java
import es.uma.informatica.sii.notifications.dtos.NotificacionDTO;
import es.uma.informatica.sii.notifications.entidades.Notificacion;
import es.uma.informatica.sii.notifications.servicios.LogicaNotificaciones;
import es.uma.informatica.sii.notifications.servicios.excepciones.EntidadNoEncontrada;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/notificaciones")
public class NotificationsController {
    private final LogicaNotificaciones servicio;

    @Autowired
    public NotificationsController(LogicaNotificaciones service) {
        this.servicio = service;
    }

    @GetMapping
    public List<Notificacion> obtenerNotificaciones() {
        List<Notificacion> notificaciones = servicio.obtenerNotificaciones();
        return notificaciones.stream().toList();
    }
    
//    @GetMapping("{estado}")
//    public List<NotificacionDTO> obtenerNotificaciones(@PathVariable("estado") String estado) {
//        List estados = Arrays.asList("PENDIENTE", "ENVIADO", "ABORTADA", "ERROR");
//        List<Notificacion> notificaciones;
//        if(estados.contains(estado)){
//            notificaciones = servicio.obtenerNotificaciones("", estado);
//        }else{
//            notificaciones = servicio.obtenerNotificaciones(estado, "");
//        }
//        return notificaciones.stream().map(not -> NotificacionDTO.fromNotificacion(not)).toList();
//    }

    @GetMapping("{tipo}/{estado}")
    public List<NotificacionDTO> obtenerNotificaciones(@PathVariable("tipo") String tipo, @RequestParam("estado") String estado) {
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
    public ResponseEntity<?> aniadirNotificacion(@RequestBody Notificacion nuevaNotificacion, UriComponentsBuilder builder) {
        Long id = servicio.aniadirNotificacion(nuevaNotificacion);
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
        Notificacion not = notificacion;
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
    
    @ExceptionHandler(EntidadNoEncontrada.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void noEncontrado() {

    }
}

