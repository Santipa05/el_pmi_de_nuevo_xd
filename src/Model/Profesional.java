package Model;

public class Profesional extends Persona{
    private String matricula;

    //Constructor
    public Profesional(String matricula, String dni, String nombre, String telefono, String mail, String apellido) {
        super(dni, nombre, telefono, mail, apellido);
        this.matricula = matricula;
    }

    public Profesional() {
    }

    
    //Setters & Getters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "\n---Profesional---\n" + super.toString() + "\nMatricula: " + matricula;
    }
    
}