package es.uma.informatica.sii.notifications.entidades;

<<<<<<< Updated upstream
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
=======
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
>>>>>>> Stashed changes
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Notificacion implements Serializable {    
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String asunto;    
    
    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String tipo;

    private String destinatario;

    private String estado;
    
    private boolean sms;
    private boolean email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date programacionEnvio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date momentoRealEnvio;

    public Notificacion() {
    }

    public Notificacion(Long id, String asunto, String mensaje, String tipo, String destinatario, String estado, boolean sms, boolean email, Date programacionEnvio, Date momentoRealEnvio) {
        this.id = id;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.destinatario = destinatario;
        this.estado = estado;
        this.sms = sms;
        this.email = email;
        this.programacionEnvio = programacionEnvio;
        this.momentoRealEnvio = momentoRealEnvio;
    }

    public Long getId() {
        return id;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isSms() {
        return sms;
    }

    public boolean isEmail() {
        return email;
    }

    public Date getProgramacionEnvio() {
        return programacionEnvio;
    }

    public Date getMomentoRealEnvio() {
        return momentoRealEnvio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public void setProgramacionEnvio(Date programacionEnvio) {
        this.programacionEnvio = programacionEnvio;
    }

    public void setMomentoRealEnvio(Date momentoRealEnvio) {
        this.momentoRealEnvio = momentoRealEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.asunto);
        hash = 41 * hash + Objects.hashCode(this.mensaje);
        hash = 41 * hash + Objects.hashCode(this.tipo);
        hash = 41 * hash + Objects.hashCode(this.destinatario);
        hash = 41 * hash + Objects.hashCode(this.estado);
        hash = 41 * hash + (this.sms ? 1 : 0);
        hash = 41 * hash + (this.email ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.programacionEnvio);
        hash = 41 * hash + Objects.hashCode(this.momentoRealEnvio);
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
        final Notificacion other = (Notificacion) obj;
        if (this.sms != other.sms) {
            return false;
        }
        if (this.email != other.email) {
            return false;
        }
        if (!Objects.equals(this.asunto, other.asunto)) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        if (!Objects.equals(this.programacionEnvio, other.programacionEnvio)) {
            return false;
        }
        return Objects.equals(this.momentoRealEnvio, other.momentoRealEnvio);
    }

    @Override
    public String toString() {
        return "Notificacion{" + "id=" + id + ", asunto=" + asunto + ", mensaje=" + mensaje + ", tipo=" + tipo + ", destinatario=" + destinatario + ", estado=" + estado + ", sms=" + sms + ", email=" + email + ", programacionEnvio=" + programacionEnvio + ", momentoRealEnvio=" + momentoRealEnvio + '}';
    }

    
}
