package es.uma.informatica.notificaciones;

import es.uma.informatica.Main;
import es.uma.informatica.dtos.NotificacionDTO;
import es.uma.informatica.entidades.Destinatario;
import es.uma.informatica.entidades.Notificacion;
import es.uma.informatica.repositories.NotificacionRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gabrycina
 */
@SpringBootTest(classes= Main.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("En el servicio de notificaciones")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class NotificacionesApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private NotificacionRepository repo;

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
        RequestEntity<Void> peticion = RequestEntity.get(uri)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        return peticion;
    }

    private RequestEntity<Void> delete(String scheme, String host, int port, String path) {
        URI uri = uri(scheme, host, port, path);
        RequestEntity<Void> peticion = RequestEntity.delete(uri)
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

    private void compruebaCampos(Notificacion expected, Notificacion actual) {
        assertThat(actual.getEstado(), equalTo(expected.getEstado()));
        assertThat(actual.getMensaje(), equalTo(expected.getMensaje()));
        assertThat(actual.getTipo(), equalTo(expected.getTipo()));
        assertThat(actual.getAsunto(), equalTo(expected.getAsunto()));
        assertThat(actual.getDestinatario(), equalTo(expected.getDestinatario()));
        assertThat(actual.getMomentoRealEnvio(), equalTo(expected.getMomentoRealEnvio()));
        assertThat(actual.getProgramacionEnvio(), equalTo(expected.getProgramacionEnvio()));
        assertThat(actual.isEmail(), equalTo(expected.isEmail()));
        assertThat(actual.isSms(), equalTo(expected.isSms()));
    }

    @Nested
    @DisplayName("cuando no estan notificaciones")
    public class BaseDatosVacia {

        @Test
        @DisplayName("devuelve la lista de notificaciones vacía")
        public void devuelveLista() {
            RequestEntity peticion = get("http", "localhost", port, "/notificaciones");

            ResponseEntity respuesta = restTemplate.exchange(peticion,
                    new ParameterizedTypeReference<List<NotificacionDTO>>() {
            });

            assertThat(respuesta.getStatusCode().value(), equalTo(200));
            assertThat(Arrays.asList(respuesta.getBody()), empty());
        }

        @Nested
        @DisplayName("inserta una notificacion")
        public class InsertaNotificaciones {

            @Test
            @DisplayName("sin ID")
            public void sinID() {

                // Preparamos la notificacion de insertar
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .asunto("asunto test")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                // Preparamos la petición con la notificacion dentro
                RequestEntity peticion = post("http", "localhost", port, "/notificaciones", notificacion);

                // Invocamos al servicio REST 
                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                // Comprobamos el resultado
                assertThat(respuesta.getStatusCode().value()).isEqualTo(201);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .startsWith("http://localhost:" + port + "/notificaciones");

                List<Notificacion> notificacionesBD = new ArrayList<>();

                for (Notificacion not : repo.findAll()) {
                    notificacionesBD.add(not);
                }

                assertThat(notificacionesBD).hasSize(1);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .endsWith("/" + notificacionesBD.get(0).getId());
                compruebaCampos(notificacion.notificacion(), notificacionesBD.get(0));
            }

            private void compruebaRespuesta(Notificacion notificacion, ResponseEntity<Void> respuesta) {
                assertThat(respuesta.getStatusCode().value()).isEqualTo(201);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .startsWith("http://localhost:" + port + "/notificaciones");

                List<Notificacion> notificacionesBD = new ArrayList<>();

                for (Notificacion not : repo.findAll()) {
                    notificacionesBD.add(not);
                }

                assertThat(notificacionesBD).hasSize(1);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .endsWith("/" + notificacionesBD.get(0).getId());
                compruebaCampos(notificacion, notificacionesBD.get(0));
            }

            @Test
            @DisplayName("a pesar de que tenga ID")
            public void conID() {
                // Preparamos la notificacion de insertar
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .id(2L)
                        .asunto("asunto test")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = post("http", "localhost", port, "/notificaciones", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                compruebaRespuesta(notificacion.notificacion(), respuesta);
            }
        }

        @Test
        @DisplayName("devuelve error cuando se pide una notificacion concreta")
        public void devuelveErrorAlConsultarNotificacion() {
            RequestEntity peticion = get("http", "localhost", port, "/notificaciones/1");

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
            assertThat(respuesta.hasBody()).isEqualTo(false);
        }

        @Test
        @DisplayName("devuelve error cuando se modifica una notificacion concreta")
        public void devuelveErrorAlModificarNotificacion() {
            NotificacionDTO notificacion = NotificacionDTO.builder()
                    .id(2L)
                    .asunto("asunto test")
                    .cuerpo("cuerpo test")
                    .emailDestino("email test")
                    .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                    .programacionEnvio("1 02 2018")
                    .telefonoDestino("32843220842")
                    .medios(Arrays.asList("SMS", "EMAIL"))
                    .build();

            RequestEntity peticion = put("http", "localhost", port, "/notificaciones/1", notificacion);

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
        }

        @Test
        @DisplayName("devuelve error cuando se elimina una notificacion concreta")
        public void devuelveErrorAlEliminarNotificacion() {
            RequestEntity peticion = delete("http", "localhost", port, "/notificaciones/1");

            ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

            assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
        }
    }

    @Nested
    @DisplayName("cuando la agenda tiene datos")
    public class BaseDeDatosConDatos {

        @BeforeEach
        public void introduceDatos() {
            repo.save(
                    new Notificacion(null, "asunto test", "cuerpo test", "ANUNCIO_NOTA_ESTUDIANTE", new Destinatario(), "PENDIENTE", false, false, new Date(), new Date())
            );
            repo.save(
                    new Notificacion(null, "asunto test2", "cuerpo test2", "ANUNCIO_NOTA_ESTUDIANTE", new Destinatario(), "PENDIENTE", false, false, new Date(), new Date())
            );
        }

        @Test
        @DisplayName("devuelve la lista de notificaciones correctamente")
        public void devuelveLista() {
            RequestEntity peticion = get("http", "localhost", port, "/notificaciones");

            ResponseEntity respuesta = restTemplate.exchange(peticion,
                    new ParameterizedTypeReference<List<NotificacionDTO>>() {
            });

            assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
            assertThat(Arrays.asList(respuesta.getBody()), hasSize(2));
        }

        @Nested
        @DisplayName("inserta una notificacion")
        public class InsertaNotificaciones {

            @Test
            @DisplayName("sin ID")
            public void sinID() {
                // Preparamos la notificacion de insertar
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .asunto("asunto test")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = post("http", "localhost", port, "/notificaciones", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                compruebaRespuesta(notificacion.notificacion(), respuesta);
            }

            @Test
            @DisplayName("a pesar de que tenga ID")
            public void conIDNoExistente() {
                // Preparamos la notificacion de insertar
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .id(3L)
                        .asunto("aniadir")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = post("http", "localhost", port, "/notificaciones", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                compruebaRespuesta(notificacion.notificacion(), respuesta);
            }

            @Test
            @DisplayName("a pesar de que el ID coincida con uno existente")
            public void conIDExistente() {
                // Preparamos la notificacion de insertar
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .id(1L)
                        .asunto("aniadir")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = post("http", "localhost", port, "/notificaciones", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                compruebaRespuesta(notificacion.notificacion(), respuesta);
            }

            private void compruebaRespuesta(Notificacion notificacion, ResponseEntity<Void> respuesta) {
                assertThat(respuesta.getStatusCode().value()).isEqualTo(201);
                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .startsWith("http://localhost:" + port + "/notificaciones");

                List<Notificacion> notificacionesBD = new ArrayList<>();

                for (Notificacion not : repo.findAll()) {
                    notificacionesBD.add(not);
                }

                assertThat(notificacionesBD).hasSize(3);

                Notificacion not = notificacionesBD.stream()
                        .filter(n -> n.getAsunto().equals("aniadir"))
                        .findAny()
                        .get();

                assertThat(respuesta.getHeaders().get("Location").get(0))
                        .endsWith("/" + not.getId());
                compruebaCampos(notificacion, not);
            }
        }

        @Nested
        @DisplayName("al consultar una notifica concreta")
        public class ObtenerNotificaciones {

            @Test
            @DisplayName("lo devuelve cuando existe")
            public void devuelveNotificacion() {
                RequestEntity peticion = get("http", "localhost", port, "/notificaciones/1");

                ResponseEntity respuesta = restTemplate.exchange(peticion, NotificacionDTO.class);

                assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
                assertThat(respuesta.hasBody()).isEqualTo(true);
                assertThat(respuesta.getBody()).isNotNull();
            }

            @Test
            @DisplayName("da error cuando no existe")
            public void errorCuandoNotificacionNoExiste() {
                RequestEntity peticion = get("http", "localhost", port, "/notificaciones/28");

                ResponseEntity respuesta = restTemplate.exchange(peticion,
                        new ParameterizedTypeReference<List<Notificacion>>() {
                });

                assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
                assertThat(respuesta.hasBody()).isEqualTo(false);
            }
        }

        @Nested
        @DisplayName("al modificar una notificacion")
        public class ModificarNotificaciones {

            @Test
            @DisplayName("lo modifica correctamente cuando existe")
            @DirtiesContext
            public void modificaCorrectamente() {
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .asunto("asunto test")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = put("http", "localhost", port, "/notificaciones/1", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
                Notificacion notificacionBD = repo.findById(1L).get();
                compruebaCampos(notificacion.notificacion(), notificacionBD);
            }

            @Test
            @DisplayName("da error cuando no existe")
            public void errorCuandoNoExiste() {
                NotificacionDTO notificacion = NotificacionDTO.builder()
                        .asunto("asunto test")
                        .cuerpo("cuerpo test")
                        .emailDestino("email test")
                        .tipoNotificacion("ANUNCIO_NOTA_ESTUDIANTE")
                        .programacionEnvio("1 02 2018")
                        .telefonoDestino("32843220842")
                        .medios(Arrays.asList("SMS", "EMAIL"))
                        .build();

                RequestEntity peticion = put("http", "localhost", port, "/notificaciones/28", notificacion);

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
                assertThat(respuesta.hasBody()).isEqualTo(false);
            }
        }

        @Nested
        @DisplayName("al eliminar una notifica")
        public class EliminarNotificaciones {

            @Test
            @DisplayName("lo elimina cuando existe")
            public void eliminaCorrectamente() {
                List<Notificacion> notificacionesBD = new ArrayList<>();

                for (Notificacion not : repo.findAll()) {
                    notificacionesBD.add(not);
                }
                
                notificacionesBD.forEach(c -> System.out.println(c));
                
                RequestEntity peticion = delete("http", "localhost", port, "/notificaciones/1");

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
                List<Notificacion> notificaciones = new ArrayList<>();

                for (Notificacion not : repo.findAll()) {
                    notificaciones.add(not);
                }
                assertThat(notificaciones).hasSize(1);
                assertThat(notificaciones).allMatch(n -> n.getId() != 1);
            }

            @Test
            @DisplayName("da error cuando no existe")
            public void errorCuandoNoExiste() {
                RequestEntity peticion = delete("http", "localhost", port, "/notificaciones/28");

                ResponseEntity respuesta = restTemplate.exchange(peticion, Void.class);

                assertThat(respuesta.getStatusCode().value()).isEqualTo(404);
                assertThat(respuesta.hasBody()).isEqualTo(false);
            }
        }

    }

}
