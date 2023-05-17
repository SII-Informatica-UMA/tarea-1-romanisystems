package es.uma.informatica.sii.correctores.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Materia implements Serializable{

    @Id
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private int anio;
    
    private Long idConvocatoria;

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (int) (71 * hash + this.id);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + this.anio;
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
        final Materia other = (Materia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    public Long getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Long idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + ", anio=" + anio + '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}