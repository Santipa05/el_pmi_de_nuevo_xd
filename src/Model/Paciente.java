package Model;

public class Paciente extends Persona {
    private boolean obraSocial;

    //Constructor
    public Paciente(boolean ObraSocial, String dni, String nombre, String telefono, String mail, String apellido) {
        super(dni, nombre, telefono, mail, apellido);
        this.obraSocial = ObraSocial;
    }

    public Paciente() {
        super();
    }

    //Setters & Getters
    public boolean getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean ObraSocial) {
        this.obraSocial = ObraSocial;
    }

    @Override
    public String toString() {
        if (obraSocial == true){
            return "\n---Paciente---\n" + super.toString() + "\nObraSocial: Si";
        }
        else{
            return "\n---Paciente---\n" + super.toString() + "\nObraSocial: No";
        }
    }
}