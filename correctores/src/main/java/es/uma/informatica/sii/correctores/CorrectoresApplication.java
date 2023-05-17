package es.uma.informatica.sii.correctores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorrectoresApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;

        emf = Persistence.createEntityManagerFactory("correctores");
        em = emf.createEntityManager();

        SpringApplication.run(CorrectoresApplication.class, args);

        em.close();
        emf.close();
    }

}
