package es.uma.informatica;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Corrector implements Serializable{

    @Id
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellidos;
    
    private String correoElectronico;
    private String telefono;
    private int maxExamCorregir;

    @ManyToOne
    @JoinColumn(name = "MATERIA")
    private Materia materia;
        
    @Override
    public String toString() {
        return "Corrector{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", maxExamCorregir=" + maxExamCorregir + ", materia=" + materia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.apellidos);
        hash = 53 * hash + Objects.hashCode(this.correoElectronico);
        hash = 53 * hash + Objects.hashCode(this.telefono);
        hash = 53 * hash + this.maxExamCorregir;
        hash = 53 * hash + Objects.hashCode(this.materia);
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
        final Corrector other = (Corrector) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.maxExamCorregir != other.maxExamCorregir) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.materia, other.materia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getMaxExamCorregir() {
        return maxExamCorregir;
    }

    public void setMaxExamCorregir(int maxExamCorregir) {
        this.maxExamCorregir = maxExamCorregir;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}