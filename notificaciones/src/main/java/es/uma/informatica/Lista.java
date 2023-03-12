package es.uma.informatica;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Lista implements Serializable{
    @Id
    private int id;
    
    @ManyToMany
    @JoinTable(
        name = "lista_destinatario", 
        joinColumns = @JoinColumn(name = "lista_id"), 
        inverseJoinColumns = @JoinColumn(name = "destinatario_id")
    )
    private Set<Destinatario> destinatarios;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setDestinatarios(Set<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public Set<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.destinatarios);
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
        final Lista other = (Lista) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.destinatarios, other.destinatarios);
    }

    @Override
    public String toString() {
        return "Lista{" + "id=" + id + ", destinatarios=" + destinatarios + '}';
    }
    
}