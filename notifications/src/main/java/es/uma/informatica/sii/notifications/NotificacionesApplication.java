package es.uma.informatica.sii.notifications;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< Updated upstream
@SpringBootApplication
=======
@SpringBootApplication(scanBasePackages = "es.uma.informatica.sii.notifications")
>>>>>>> Stashed changes
public class NotificacionesApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;

        emf = Persistence.createEntityManagerFactory("notifications");
        em = emf.createEntityManager();

        SpringApplication.run(NotificacionesApplication.class, args);

        em.close();
        emf.close();
    }

}
