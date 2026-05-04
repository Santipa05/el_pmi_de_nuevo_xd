package Controller;
import Model.Profesional;

public class ProfesionalController {
    private Profesional profesional;

    public ProfesionalController(Profesional profesional) {
        this.profesional = profesional;
    }
    
    //SETTERS
    public void colocarNombre(String nombre) {
        profesional.setNombre(nombre);
    }

    public void colocarApellido(String apellido) {
        profesional.setApellido(apellido);
    }

    public void colocarDni(String dni) {
        profesional.setDni(dni);
    }

    public void colocarTelefono(String telefono) {
        profesional.setTelefono(telefono);
    }

    public void colocarMatricula(String matricula) {
        profesional.setMatricula(matricula);
    }
    
    public void colocarEmail(String email) {
        profesional.setMail(email);
    }

    // Métodos GET
    public String muestraNombre() {
        return profesional.getNombre();
    }

    public String muestraApellido() {
        return profesional.getApellido();
    }

    public String muestraDni() {
        return profesional.getDni();
    }

    public String muestraMail() {
        return profesional.getMail();
    }

    public String muestraTelefono() {
        return profesional.getTelefono();
    }

    public String muestraMatricula() {
        return profesional.getMatricula();
    }

    public String mostrarDatos() {
        return profesional.toString();
    }

   
    public Profesional ObtenerProfesional() {
        return profesional;
    }
    
    
}