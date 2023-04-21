/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.dto;

import es.uma.informatica.Lista;

public class NotificacionDto {

    private Long id;
    private String mensaje;
    private String tipo;
    private Lista lista;

     public Long getId() {
        return id;
    }


    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public Lista getLista() {
        return lista;
    }

    
    
    public void setId(Long id) {
        this.id = id;
    }

    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
}
