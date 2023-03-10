<<<<<<< HEAD
package es.uma.informatica.jpa;
import javax.persistence.*;

@Entity
public class Corrector {

    @Id
    private int ID;
    @Column(nullable = false);
    private String nombre;
    @Column(nullable = false);
    private String apellidos;
    private String correo_electronico;
    private double telefono;
    private int max_Exam_Corregir;

    @ManyToOne
    @JoinColumn(name = "materia")
    private Materia materia;


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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public int getMax_Exam_Corregir() {
        return max_Exam_Corregir;
    }

    public void setMax_Exam_Corregir(int max_Exam_Corregir) {
        this.max_Exam_Corregir = max_Exam_Corregir;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
=======
package es.uma.informatica.jpa;
import javax.persistence.*;

@Entity
public class Corrector {

    @Id
    private int ID;
    @Column(nullable = false);
    private String nombre;
    @Column(nullable = false);
    private String apellidos;
    private String correo_electronico;
    private double telefono;
    private int max_Exam_Corregir;

    @ManyToOne
    @JoinColumn(name = "materia")
    private Materia materia;


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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public int getMax_Exam_Corregir() {
        return max_Exam_Corregir;
    }

    public void setMax_Exam_Corregir(int max_Exam_Corregir) {
        this.max_Exam_Corregir = max_Exam_Corregir;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
>>>>>>> origin/master
}