/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.dtos;

import es.uma.informatica.entidades.Notificacion;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 *
 * @author gabrycina
 */
public class NotificacionDTO {
    private Long id;
    String asunto;
    String cuerpo;
    String emailDestino;
    String telefonoDestino;
    String programacionEnvio;
    List<String> medios;
    String tipoNotificacion;
    String estado;
    String mensajeError;
    String momentoRealEnvio;

    public static NotificacionDTO fromNotificacion(Notificacion notificacion) {
        NotificacionDTO dto = new NotificacionDTO();
        dto.setId(notificacion.getId());
        dto.setAsunto(notificacion.getAsunto());
        dto.setCuerpo(notificacion.getMensaje());

        dto.setEmailDestino(notificacion.getDestinatario().getCorreoElectronico());
        dto.setTelefonoDestino(notificacion.getDestinatario().getTelefono());
        
        dto.setEstado(notificacion.getEstado());
        dto.setTipoNotificacion(notificacion.getTipo());
        
        List medios = new ArrayList();
        
        if(notificacion.isEmail()){
            medios.add("EMAIL");
        }
        
        if(notificacion.isSms()){
            medios.add("SMS");
        }
        
        dto.setMedios(new ArrayList(medios));
        
        dto.setProgramacionEnvio(notificacion.getProgramacionEnvio().toString());
        dto.setMomentoRealEnvio(notificacion.getMomentoRealEnvio().toString());
        
        dto.setMensajeError("");

        return dto;
    }

    public Notificacion notificacion() {
        Notificacion not = new Notificacion();
        not.setId(id);

        return not;
    }
}
