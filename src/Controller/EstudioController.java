package Controller;

import Model.Estudio;
import Model.Fecha;
import java.util.ArrayList;

public class EstudioController {
    private Estudio estudio;

    public EstudioController(Estudio estudio) {
        this.estudio = estudio;
    }
    
    //SETTERS
    public void ColocarDniPaciente(String DniPaciente) {
        estudio.setDniPaciente(DniPaciente);
    }
    
    public void colocarAnalisisRealizados(ArrayList<Integer> analisisRealizados){
        estudio.setAnalisisRealizados(analisisRealizados);
    }

    public void ColocarEstado(String estado) {
        estudio.setEstado(estado);
    }

    public void ColocarMatricula(String matricula) {
        estudio.setMatriculaProfesional(matricula);
    }

    public void ColocarFechaEntrega(Fecha fec_entrega) {
        estudio.setFec_entrega(fec_entrega);
    }

    public void ColocarFechaRealizacion(Fecha fec_realizacion) {
        estudio.setFec_realizacion(fec_realizacion);
    }

    // GETTERS
    public String muestraDniPaciente() {
        return estudio.getDniPaciente();
    }

    public String muestraMatriculaProfesional() {
        return estudio.getMatriculaProfesional();
    }

    public String muestraEstado() {
        return estudio.getEstado();
    }
    
    public ArrayList<Integer> obetenerAnalisis(){
        return estudio.getAnalisisRealizados();
    }

    public Fecha muestraFechaEntrega() {
        return estudio.getFec_entrega();
    }
    
    public int muestraFecEntDia(){
        return estudio.getFec_entrega().getDia();
    }
    public int muestraFecEntMes(){
        return estudio.getFec_entrega().getMes();
    }
    public int muestraFecEntAnio(){
        return estudio.getFec_entrega().getAnio();
    }

    public Fecha muestraFechaRealizacion() {
        return estudio.getFec_realizacion();
    }
    
     public int muestraFecRealDia(){
        return estudio.getFec_realizacion().getDia();
    }
    public int muestraFecRealMes(){
        return estudio.getFec_realizacion().getMes();
    }
    public int muestraFecRealAnio(){
        return estudio.getFec_realizacion().getAnio();
    }
    
    public String muestraStringFechaRealizacion() {
        return estudio.getFec_realizacion().toString();
    }
    
    public boolean esMismaFecha(Fecha fechaConsulta){
        return estudio.getFec_realizacion().getDia() == fechaConsulta.getDia() &&
               estudio.getFec_realizacion().getMes() == fechaConsulta.getMes() &&
               estudio.getFec_realizacion().getAnio() == fechaConsulta.getAnio();        
    }
    
    public String muestraAnalisisRealizados() {
        ArrayList<Integer> ids = estudio.getAnalisisRealizados();
        if (ids == null || ids.isEmpty()) {
            return "No hay análisis cargados";
        }
        StringBuilder nombresTraducidos = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            Integer clave = ids.get(i);
            String nombre = CRUDPMI.PMI.catalogoAnalisis.get(clave);
            //Agregamos el string de catalogo analisis al acumulador string
            nombresTraducidos.append(nombre);
            //Agregamos una coma y espacio si no es el ultimo elemento
            if (i < ids.size() - 1) {
                nombresTraducidos.append("\n");
            }
        }
        return nombresTraducidos.toString();
    }
    
    public String muestraEstudio(){
    String resultado = estudio.toString() + muestraAnalisisRealizados() + "\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n\n\n";
    return resultado;
    }
    
    public Estudio obtenerEstudio(){
        return estudio;
    }
    
}