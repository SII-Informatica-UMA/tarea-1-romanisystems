package es.uma.informatica;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Notificacion implements Serializable{

    @Id
    private int id;
    
    @Column(nullable = false)
    private String mensaje;
    
    @Column(nullable = false)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "LISTA")
    private Lista lista;

    public int getId() {
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

    
    
    public void setId(int id) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.mensaje);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.lista);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.lista, other.lista);
    }

    @Override
    public String toString() {
        return "Notificacion{" + "id=" + id + ", mensaje=" + mensaje + ", tipo=" + tipo + ", lista=" + lista + '}';
    }
}