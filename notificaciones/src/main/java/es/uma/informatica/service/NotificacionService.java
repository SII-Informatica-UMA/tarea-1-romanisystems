/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.service;

import es.uma.informatica.Notificacion;
import es.uma.informatica.repositories.NotificacionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificacionService {
    
    private NotificacionRepository notificacionRepository;
    
    @Autowired
    public NotificacionService (NotificacionRepository not) {
        
        this.notificacionRepository = not;
        
    }
    
    
    // No sabemos si esta bien (No esta acabado el controlador)
    public List<Notificacion> obtieneNotificaciones(String tipo, String estado) {
        
        List <Notificacion> listaNotificaciones = new ArrayList <> ();
        
       for (Notificacion n : notificacionRepository.findAll() ){
           
           if ( (n.getTipo().equalsIgnoreCase(tipo) || n.getTipo().equals("")) && (n.getEstado().equalsIgnoreCase(estado) || n.getEstado().equals("estado"))) {
           
              listaNotificaciones.add(n);
       }
        
		
    }
       
       return listaNotificaciones;
	} 
    
    
    
    
     // ¿Hay que usar Optional?
    
    public Optional <Notificacion> getNotificacionById (Long id) {
        
        return notificacionRepository.findById(id);
    }
    
    public void ModificarNotificacion (Notificacion not) {
     
         if   (notificacionRepository.existsById(not.getId())) {
             
             notificacionRepository.findById(not.getId()).
                     ifPresent(l->l.setMensaje(not.getMensaje()));
             

            
        }
    }
   

    public Long aniadeNotificacion(Notificacion n) {
       notificacionRepository.save(n);
       return n.getId();
    }
    
    
    public void eliminarNotificacion(Long id) {
		if (notificacionRepository.existsById(id)) {
			notificacionRepository.deleteById(id);
		} else {
			throw new NoEncontradoException();
		}
	}
        
          
     
     
     
    
}

   


    


