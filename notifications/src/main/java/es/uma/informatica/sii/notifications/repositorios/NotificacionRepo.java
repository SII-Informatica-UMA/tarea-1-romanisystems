package es.uma.informatica.sii.notifications.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uma.informatica.sii.notifications.entidades.Notificacion;

@Repository
public interface NotificacionRepo extends JpaRepository<Notificacion, Long> {

}
