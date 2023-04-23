/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.controladores;

import es.uma.informatica.entidades.Corrector;
import es.uma.informatica.servicios.GestionCorrectoresServicio;
import java.net.URI;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/gestioncorrectores")
public class GestionCorrectoresControlador {
    
     private final GestionCorrectoresServicio servicio;
    private ModelMapper modelMapper;
    
     @Autowired
    public GestionCorrectoresControlador(GestionCorrectoresServicio service) {
        this.servicio = service;
    }
    
    @GetMapping
    public List<Corrector> obtenerCorrectores() {
        List<Corrector> corrector = servicio.obtenerCorrectores();
        return corrector.stream().toList();
    }
    
    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Corrector obtenerCorrector(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        Corrector corrector = servicio.obtenerCorrectorById(id);
        return corrector;
    }
    
    @PostMapping
    public ResponseEntity<?> aniadirCorrector(@RequestBody Corrector nuevoCorrector, UriComponentsBuilder builder) {
        Corrector corrector = modelMapper.map(nuevoCorrector, Corrector.class);
        corrector.setId(null);
        Long id = servicio.aniadirCorrector(corrector);
        URI uri = builder.path("/gestion_de_correctores")
                .path(String.format("/%d", id))
                .build()
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    
     @DeleteMapping("{id}")
    public ResponseEntity eliminarNotitficacion(@PathVariable Long id) {
        servicio.eliminarCorrector(id);
        return ResponseEntity.ok().build();
    }
    
        @PutMapping("{id}")
    public ResponseEntity modificaCorrector(@PathVariable Long id, @RequestBody Corrector corrector) {
        corrector.setId(id);
        servicio.actualizarCorrector(corrector);
        return ResponseEntity.ok().build();
    }
    
    
    
}
