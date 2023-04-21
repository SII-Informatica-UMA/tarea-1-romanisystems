/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.controllers;

import es.uma.informatica.Notificacion;
import es.uma.informatica.dto.NotificacionDto;
import es.uma.informatica.repositories.NotificacionRepository;
import es.uma.informatica.service.NoEncontradoException;
import es.uma.informatica.service.NotificacionService;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.net.URI;
import java.util.Optional;
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
@RequestMapping  (path = "/notificaciones")



public class NotificacionController {
    
    private NotificacionService service;
      	public static final String NOTIFICACIONES_PATH="/notificaciones"; 
        private ModelMapper modelMapper;
        
    
        /* No sabemos como acabarlo
    @GetMapping
    public List<Long> obtieneNotificaciones(@PathVariable(name = "tipo") String tipo, @PathVariable(name = "estado") String estado) {
	List<Notificacion> obtieneNotificaciones = service.obtieneNotificaciones(tipo, estado);
		return ResponseEntity.of(obtieneNotificaciones
                        .map(l->modelMapper.map(l, NotificacionDto.class)));
	} 
    */
  
        @Autowired
	public NotificacionController(NotificacionService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}
        
        @PostMapping
	@Operation(description = "Crea una nueva notificacion", 
		responses = {
                    @ApiResponse(responseCode = "403",
						description = "Acceso no autorizado"),
				@ApiResponse(responseCode = "201",
						description = "Created",
						headers= {
								@Header(name = "location", 
										description="URI de la nueva lista",
										schema = @Schema(type = "string",
													format="uri"
												))})
                  
                })
		
				
  
public ResponseEntity<?> aniadeNotificacion(@RequestBody NotificacionDto nuevaNotificacion,
										 UriComponentsBuilder builder) {
		Notificacion n = modelMapper.map(nuevaNotificacion, Notificacion.class);
		n.setId(null);
		Long id = service.aniadeNotificacion(n);
		URI uri = builder.path(NOTIFICACIONES_PATH)
						.path(String.format("/%d", id))
						.build()
						.toUri();
		return ResponseEntity.created(uri).build();
	}


	@GetMapping("{id}")
        @Operation(description = "Obtiene una notificación concreta", 
		responses = {
                    @ApiResponse(responseCode = "403",
						description = "Acceso no autorizado"),
                    @ApiResponse(responseCode = "404",
						description = "La notificación no existe"),
				@ApiResponse(responseCode = "200",
						description = "La notificación existe",
						headers= {
								@Header(name = "location", 
										description="URI de la nueva lista",
										schema = @Schema(type = "string",
													format="uri"
												))})
                  
                })
	public ResponseEntity<NotificacionDto> obtenerNotificacion(@PathVariable(name = "id") Long id) {
		Optional<Notificacion> getNotificacionById = service.getNotificacionById(id);
		return ResponseEntity.of(getNotificacionById
				.map(l->modelMapper.map(l, NotificacionDto.class)));
	}
        
         @DeleteMapping("{idNotificacion}/notificacion/{idNotificacion}")
        @Operation(description = "Elimina la notificación", 
		responses = {
                    @ApiResponse(responseCode = "403",
						description = "Acceso no autorizado"),
                    @ApiResponse(responseCode = "404",
						description = "La notificación no existe"),
				@ApiResponse(responseCode = "200",
						description = "La notificación se ha eliminado"
						)
                  
                })
	public ResponseEntity<?> eliminarNotitficacion(@PathVariable(name="idNotificacion") Long idNotificacion) {
		service.eliminarNotificacion(idNotificacion);
		return ResponseEntity.ok().build();
	}
        
        
        
        @PutMapping("{id}")
         @Operation(description = "Actualiza una notificación", 
		responses = {
                    @ApiResponse(responseCode = "403",
						description = "Acceso no autorizado"),
                    @ApiResponse(responseCode = "404",
						description = "La notificación no existe"),
				@ApiResponse(responseCode = "200",
						description = "La notificación se ha actualizado"
						)
                  
                })
	public ResponseEntity<?> modificaNotificacion(@PathVariable(name = "id") Long id, @RequestBody NotificacionDto notificacion) {		
		Notificacion n = modelMapper.map(notificacion, Notificacion.class);
		if (service.getNotificacionById(id).isPresent()) {
			n.setId(id);
			service.ModificarNotificacion(n);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
        
        
        
        @ExceptionHandler(NoEncontradoException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void noEncontrado() {
		
	}



}



