/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.sii.correctores;

import es.uma.informatica.sii.correctores.dtos.CorrectorDTO;
import es.uma.informatica.sii.correctores.entidades.Corrector;
import es.uma.informatica.sii.correctores.repositorios.CorrectorRepo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
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
@DisplayName("En el servicio de gestion de correctores")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CorrectorApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private CorrectorRepo repo;

    @BeforeEach
    public void initializeDatabase() {
        repo.deleteAll();
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
        assertThat(expected.getId()).isEqualTo(actual.getId());
        assertThat(expected.getNombre()).isEqualTo(actual.getNombre());
        assertThat(actual.getApellidos()).isEqualTo((expected.getApellidos()));
        assertThat(actual.getTelefono()).isEqualTo((expected.getTelefono()));
        assertThat(actual.getMaxExamCorregir()).isEqualTo(expected.getMaxExamCorregir());
        assertThat(actual.getIdentificadorUsuario()).isEqualTo(expected.getIdentificadorUsuario());
    }

    @Nested
    @DisplayName("cuando no estan correctores")
    public class BaseDatosVacia {

        @Test
        @DisplayName("devuelve la lista de correctores vacía")
        public void devuelveLista() {
            RequestEntity peticion = get("http", "localhost", port, "/correctores");

            ResponseEntity respuesta = restTemplate.exchange(peticion,
                    new ParameterizedTypeReference<List<Corrector>>() {
            });

            ArrayList a = new ArrayList();
            a.add(new ArrayList());
            
            assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
           assertThat(Arrays.asList(respuesta.getBody())).isEqualTo(a);
        }

        @Nested
        @DisplayName("inserta una corrector")
        public class InsertaCorrectores {

           @Test
            @DisplayName("sin ID")
            public void sinID() {

               // Preparamos la corrector de insertar
               Corrector corrector =new  Corrector  (
                        
                        null,
                        1234767687,
                          "test",
                        "Test",
                        "Pedro",
                        "3122",
                        123345,                 
                        22324355l  );
               
               
               // Preparamos la petición con la corrector dentro
               RequestEntity peticion = post("http", "localhost", port, "/correctores", corrector);

                // Invocamos al servicio REST 
                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                // Comprobamos el resultado
             assertThat(respuesta.getStatusCode().value()).isEqualTo(201);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .startsWith("http://localhost:" + port + "/correctores");

               List<Corrector> correctoresBD = new ArrayList<>();

                for (Corrector corr : repo.findAll()) {
                    correctoresBD.add(corr);
                }

                assertThat(correctoresBD).hasSize(1);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .endsWith("/" + correctoresBD.get(0).getId());
                compruebaCampos(corrector, correctoresBD.get(0));
            }

            private void compruebaRespuesta(Corrector corrector, ResponseEntity<Void> respuesta) {
                assertThat(respuesta.getStatusCode().value()).isEqualTo(201);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .startsWith("http://localhost:" + port + "/correctores");

                List<Corrector> correctoresBD = new ArrayList<>();

                for (Corrector not : repo.findAll()) {
                    correctoresBD.add(not);
                }

                assertThat(correctoresBD).hasSize(1);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .endsWith("/" + correctoresBD.get(0).getId());
                compruebaCampos(corrector, correctoresBD.get(0));
            }

//            @Test
//            @DisplayName("a pesar de que tenga ID")
//            public void conID() {
//                // Preparamos la corrector de insertar
//                // Preparamos la corrector de insertar
//                CorrectorDTO corrector = CorrectorDTO.builder()
//                        .id(1L)
//                        .nombre("Test")
//                        .apellido("Test")
//                        .identificadorUsuario(123345L)
//                        .materias(new ArrayList<>())
//                        .maximasCorrecciones(2)
//                        .telefono("3492902932")
//                        .build();
//
//                RequestEntity peticion = post("http", "localhost", port, "/correctores", corrector);
//
//                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);
//
//                compruebaRespuesta(corrector.corrector(), respuesta);
//            }
        }

        @Test
        @DisplayName("devuelve error cuando se pide una corrector concreta")
        public void devuelveErrorAlConsultarCorrector() {
            RequestEntity peticion = get("http", "localhost", port, "/correctores/1");

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
            assertThat(respuesta.hasBody()).isEqualTo(false);
        }

        @Test
        @DisplayName("devuelve error cuando se modifica una corrector concreta")
        public void devuelveErrorAlModificarCorrector() {
                // Preparamos la corrector de insertar
                
                
                Corrector corrector = new Corrector (
                        
                        1L,
                        1234767687,
                          "test",
                        "Test",
                        "Pedro",
                        "3122",
                        123345,                 
                        22324355l  );

            RequestEntity peticion = put("http", "localhost", port, "/correctores/1", corrector);

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
        }

        @Test
        @DisplayName("devuelve error cuando se elimina una corrector concreta")
        public void devuelveErrorAlEliminarCorrector() {
            RequestEntity peticion = delete("http", "localhost", port, "/correctores/1");

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
        }
    }

}
