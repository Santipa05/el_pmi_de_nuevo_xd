package Controller;
import Model.Persona;

public class PersonaController {
    private Persona persona;

    //Constructor
    public PersonaController(Persona persona) {
        this.persona = persona;
    }
    
    public void colocarNombre(String nombre) {
        persona.setNombre(nombre);
    }

    public void colocarApellido(String apellido) {
        persona.setApellido(apellido);
    }

    public void colocarDni(String dni) {
        persona.setDni(dni);
    }

    public void colocarTelefono(String telefono) {
        persona.setTelefono(telefono);
    }
    
    public void colocarEmail(String email) {
        persona.setMail(email);
    }

    // Métodos GET
    public String muestraNombre() {
        return persona.getNombre();
    }

    public String muestraApellido() {
        return persona.getApellido();
    }

    public String muestraDni() {
        return persona.getDni();
    }

    public String muestraMail() {
        return persona.getMail();
    }

    public String muestraTelefono() {
        return persona.getTelefono();
    }

    public String mostrarDatos() {
        return persona.toString();
    }

    public Persona ObenerPersona() {
        return persona;
    }

    public void ColocarPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
