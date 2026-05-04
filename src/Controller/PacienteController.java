package Controller;

import Model.Estudio;
import Model.Paciente;
import java.util.ArrayList;

public class PacienteController{
    private Paciente paciente;

    public PacienteController(Paciente paciente) {
        this.paciente = paciente;
    }
    
    //SETTERS
    public void colocarNombre(String nombre) {
        paciente.setNombre(nombre);
    }

    public void colocarApellido(String apellido) {
        paciente.setApellido(apellido);
    }

    public void colocarDni(String dni) {
        paciente.setDni(dni);
    }

    public void colocarTelefono(String telefono) {
        paciente.setTelefono(telefono);
    }
    
    public void colocarEmail (String email) {
        paciente.setMail(email);
    }

    public void colocarObraSocial(boolean obraSocial) {
        paciente.setObraSocial(obraSocial);
    }

    // Métodos GET
    public String muestraNombre() {
        return paciente.getNombre();
    }

    public String muestraApellido() {
        return paciente.getApellido();
    }

    public String muestraDni() {
        return paciente.getDni();
    }

    public String muestraMail() {
        return paciente.getMail();
    }

    public String muestraTelefono() {
        return paciente.getTelefono();
    }

    public boolean muestraObraSocial() {
        return paciente.getObraSocial();
    }

    public String mostrarDatos() {
        return paciente.toString();
    }
    
    
    public Paciente obtenerPaciente(){
        return paciente;
    }
    
    // Otros metodos
    public int obtenerCantidadEstudios(ArrayList<Estudio> listaEstudios) {
    int contador = 0;
    
    String dniBusqueda = this.muestraDni();

    for (Estudio est : listaEstudios) {
        EstudioController miEst = new EstudioController(est);
        
        if (miEst.muestraDniPaciente().equals(dniBusqueda)) {
            contador++;
        }
    }
    return contador;
}
}

