package es.uma.informatica.jpa;
import javax.persistence.*;

@Entity
public class Materia {

    @Id
    private int ID;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int anio;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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