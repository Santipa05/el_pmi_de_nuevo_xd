package Model;

import java.util.ArrayList;

public class Estudio {
    private String matriculaProfesional, dniPaciente, estado, dniProfesional;
    private Fecha fec_realizacion, fec_entrega;
    private ArrayList<Integer> analisisRealizados;

    //Constructor
    public Estudio(String matriculaProfesional, String dniPaciente, Fecha fec_realizacion, Fecha fec_entrega, String estado) {
        this.matriculaProfesional = matriculaProfesional;
        this.dniPaciente = dniPaciente;
        this.fec_realizacion = fec_realizacion;
        this.fec_entrega = fec_entrega;
        this.estado = estado;
        this.analisisRealizados = new ArrayList<>();
    }

    public Estudio() {
        this.analisisRealizados = new ArrayList<>();
    }
    

    //Setters & Getters

    public void setAnalisisRealizados(ArrayList<Integer> analisisRealizados) {
        this.analisisRealizados = analisisRealizados;
    }
    
    public ArrayList<Integer> getAnalisisRealizados() {
        return this.analisisRealizados;
    }

    
    public String getDniProfesional() {
        return dniProfesional;
    }

    public void setDniProfesional(String dniProfesional) {
        this.dniProfesional = dniProfesional;
    }
    
    public String getMatriculaProfesional() {
        return matriculaProfesional;
    }

    public void setMatriculaProfesional(String matriculaProfesional) {
        this.matriculaProfesional = matriculaProfesional;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public Fecha getFec_realizacion() {
        return fec_realizacion;
    }

    public void setFec_realizacion(Fecha fec_realizacion) {
        this.fec_realizacion = fec_realizacion;
    }

    public Fecha getFec_entrega() {
        return fec_entrega;
    }

    public void setFec_entrega(Fecha fec_entrega) {
        this.fec_entrega = fec_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||DATOS ESTUDIO|||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n" + "||| Matricula profesional: " + matriculaProfesional + "  ||  " + "DNI paciente: " + dniPaciente + "  ||  " + "Estado: " + estado + "\n"+ "||| DNI profesional: " + dniProfesional +
                " || " + "Fecha realizacion: " + fec_realizacion + " || " + "Fecha entrega: " + fec_entrega + "\n||| Analisis realizados: \n|||[] ";
    }
    
    
    
    
    // Método para ir agregando los análisis a este estudio
    public void agregarAnalisisAlEstudio(int codigo) {
        if (codigo >= 0 && codigo <= 9) {
            this.analisisRealizados.add(codigo);
        }
    }
}