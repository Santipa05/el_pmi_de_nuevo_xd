package Model;


public class Persona {
    private String apellido, nombre, telefono, mail, dni;

    //Constructor
    public Persona() {
        this.dni = "";
        this.apellido = "";
        this.nombre = "";
        this.telefono = "";
        this.mail = "";
    }
    
    public Persona(String dni, String nombre, String telefono, String mail, String apellido) {
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.dni = dni;
        this.nombre = nombre;
    }
    
    //Setters & Getters
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "\nApellido: " + apellido + "\nNombre: " + nombre + "\nTelefono: " + telefono + "\nMail: " + mail + "\nDni: " + dni;
    }
}