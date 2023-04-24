/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import es.uma.informatica.entidades.Corrector;
import es.uma.informatica.repositories.CorrectoresRepository;
import java.net.URI;
import java.util.List;
import lombok.var;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

/**
 *
 * @author manus
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("En el servicio de agenda")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class GestionCorrectoresTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private CorrectoresRepository correctoresRepository;

    @BeforeEach
    public void initializeDatabase() {
        correctoresRepository.deleteAll();
    }

    private URI uri(String scheme, String host, int port, String... paths) {
        UriBuilderFactory ubf = new DefaultUriBuilderFactory();
        UriBuilder ub = ubf.builder()
                .scheme(scheme)
                .host(host).port(port);
        for (String path : paths) {
            ub = ub.path(path);
        }
        return ub.build();
    }

    private RequestEntity<Void> get(String scheme, String host, int port, String path) {
        URI uri = uri(scheme, host, port, path);
        RequestEntity peticion = RequestEntity.get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        return peticion;
    }

    private RequestEntity<Void> delete(String scheme, String host, int port, String path) {
        URI uri = uri(scheme, host, port, path);
        RequestEntity peticion = RequestEntity.delete(uri)
                .build();
        return peticion;
    }

    private <T> RequestEntity<T> post(String scheme, String host, int port, String path, T object) {
        URI uri = uri(scheme, host, port, path);
        RequestEntity peticion = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(object);
        return peticion;
    }

    private <T> RequestEntity<T> put(String scheme, String host, int port, String path, T object) {
        URI uri = uri(scheme, host, port, path);
        RequestEntity peticion = RequestEntity.put(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(object);
        return peticion;
    }

    private void compruebaCampos(Corrector expected, Corrector actual) {
        assertThat(expected.getId(),equalTo(actual.getId()));
        assertThat(expected.getNombre(),equalTo(actual.getNombre()));
        assertThat(actual.getApellidos(),equalTo((expected.getApellidos())));
        assertThat(actual.getTelefono(),equalTo((expected.getTelefono())));
        assertThat(actual.getMaxExamCorregir(),equalTo(expected.getMaxExamCorregir()));
        assertThat(actual.getIdentificadorUsuario(),equalTo(expected.getIdentificadorUsuario()));
    }

    @Nested
    @DisplayName("cuando la lista de correctores esta vacia")
    public class ListaVacia {

        @Test
        @DisplayName("devuelve la lista de correctores vacía")
        public void devuelveLista() {

            RequestEntity peticion = get("http", "localhost", port, "/api/correctores");

            ResponseEntity respuesta = restTemplate.exchange(peticion,
                    new ParameterizedTypeReference<List<Corrector>>() {
            });

            assertThat(respuesta.getStatusCode().value(),equalTo(200));
            assertThat(respuesta.getBody(),empty();
        }

        private Object assertThat(Object body) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    

    @Nested
    @DisplayName("inserta un corrector")
    public class InsertaCorrectores {

        @Test
        @DisplayName("sin ID")
        public void sinID() {
            Corrector corrector = new Corrector(null,
                    "Antonio",
                    "García",
                    "antonio@uma.es",
                    "123456789",
                    2,
                     5L
            );
            var peticion = post("http", "localhost", port, "/api/correctores", corrector);

            var respuesta = restTemplate.exchange(peticion, Void.class);

            compruebaRespuesta(contacto, respuesta);
        }

    }
    
    }
    
}
    



