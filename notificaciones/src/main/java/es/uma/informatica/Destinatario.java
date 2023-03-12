package es.uma.informatica;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Destinatario implements Serializable{

    @Id
    private int id;
    
    @Column(nullable = false)
    private String tipo;
        
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String correoElectronico;
       
    private String telefono;
    
    @ManyToMany(mappedBy= "destinatarios")
    private Set<Lista> listas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public Set<Lista> getListas() {
        return listas;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setListas(Set<Lista> listas) {
        this.listas = listas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.correoElectronico);
        hash = 67 * hash + Objects.hashCode(this.telefono);
        hash = 67 * hash + Objects.hashCode(this.listas);
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
        final Destinatario other = (Destinatario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.listas, other.listas);
    }

    @Override
    public String toString() {
        return "Destinatario{" + "id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", listas=" + listas + '}';
    }

}