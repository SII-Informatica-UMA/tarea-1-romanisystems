package es.uma.informatica.sii.notifications.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Fallo implements Serializable{

    @Id @GeneratedValue
    private int id;
    
    @Column(nullable = false)
    private int code;
    
    @Column(nullable = false)
    private String mensaje;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "NOTIFICACION_id")
    private Notificacion notificacion;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + this.code;
        hash = 41 * hash + Objects.hashCode(this.mensaje);
        hash = 41 * hash + Objects.hashCode(this.notificacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fallo other = (Fallo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        return Objects.equals(this.notificacion, other.notificacion);
    }

    @Override
    public String toString() {
        return "Fallo{" + "id=" + id + ", code=" + code + ", mensaje=" + mensaje + ", notificacion=" + notificacion + '}';
    }

    
    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
    
    

}