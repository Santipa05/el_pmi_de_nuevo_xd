package CRUDPMI;
import View.Principal;
import java.util.HashMap;

public class PMI {
      //El hashMap de los analisis
      public static HashMap<Integer, String> catalogoAnalisis = new HashMap<>();
    
      public static void main(String[] args) {
        cargarCatalogoAnalisis();
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Principal ventana = new Principal();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            }
          });
      }
      //Los estudios posibles
      public static void cargarCatalogoAnalisis(){
          catalogoAnalisis.put(0, "Hemograma Completo");
          catalogoAnalisis.put(1, "Glucemia");
          catalogoAnalisis.put(2, "Colesterol Total");
          catalogoAnalisis.put(3, "Orina Completa");
          catalogoAnalisis.put(4, "Uremia");
          catalogoAnalisis.put(5, "Creatinemia");
          catalogoAnalisis.put(6, "Hepatograma");
          catalogoAnalisis.put(7, "Perfil Lipidico");
          catalogoAnalisis.put(8, "Grupo y Factor");
          catalogoAnalisis.put(9, "Coagulograma");
    }
}