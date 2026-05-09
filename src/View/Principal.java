package View;

import Controller.PacienteController;
import Controller.ProfesionalController;
import Controller.EstudioController;
import Model.Estudio;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import Model.Fecha;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;



public class Principal extends javax.swing.JFrame{
    private ArrayList<Estudio> listaEstudios;
    private HashMap <String, Persona> mapaPersonas;
    
    public final void precargaPacientes(){
          BufferedReader lector = null;
        try{
              String nombre, apellido, dni, telefono, email, obSoc;
              File arPac = new File("archivos/archivoPacientes.txt");
              FileReader fr = new FileReader(arPac);
              lector = new BufferedReader(fr);
              while((nombre = lector.readLine()) != null){
                    apellido = lector.readLine();
                    dni = lector.readLine();
                    telefono = lector.readLine();
                    email = lector.readLine();
                    obSoc = lector.readLine();
                    lector.readLine();
                    Paciente pac = new Paciente();
                    PacienteController miPac = new PacienteController(pac);
                    miPac.colocarNombre(nombre);
                    miPac.colocarApellido(apellido);
                    miPac.colocarDni(dni);
                    miPac.colocarTelefono(telefono);
                    miPac.colocarEmail(email);
                    if("true".equals(obSoc))
                        miPac.colocarObraSocial(true);
                    else
                        miPac.colocarObraSocial(false);
                    mapaPersonas.put(dni, miPac.obtenerPaciente());
              }
        } catch(IOException e){
              JOptionPane.showMessageDialog(this, e.getMessage());
        } finally{
              try{
                    if(lector != null){
                          lector.close();
                    }
              } catch(IOException e){
                  JOptionPane.showMessageDialog(this, e.getMessage());
              }
        }
    }
    
    public final void precargaProfesional(){
          BufferedReader lector = null;
        try{
              String nombre, apellido, dni, telefono, email, matricula;
              File arPac = new File("archivos/archivoProfesionales.txt");
              FileReader fr = new FileReader(arPac);
              lector = new BufferedReader(fr);
              while((nombre = lector.readLine()) != null){
                    apellido = lector.readLine();
                    dni = lector.readLine();
                    telefono = lector.readLine();
                    email = lector.readLine();
                    matricula = lector.readLine();
                    lector.readLine();
                    Profesional pro = new Profesional();
                    ProfesionalController miPro = new ProfesionalController(pro);
                    miPro.colocarNombre(nombre);
                    miPro.colocarApellido(apellido);
                    miPro.colocarDni(dni);
                    miPro.colocarTelefono(telefono);
                    miPro.colocarEmail(email);
                    miPro.colocarMatricula(matricula);
                    mapaPersonas.put(dni, miPro.ObtenerProfesional());
              }
        } catch(IOException e){
              JOptionPane.showMessageDialog(this, e.getMessage());
        } finally{
              try{
                    if(lector != null){
                          lector.close();
                    }
              } catch(IOException e){
                  JOptionPane.showMessageDialog(this, e.getMessage());
              }
        }
    }
    
    public final void precargaEstudio(){
          BufferedReader lector = null;
        try{
              String dniPac, matricula,  estado, analisis;
              String diaR, mesR, anioR, diaE, mesE, anioE;
              int aux1, aux2, aux3;
              File arPac = new File("archivos/archivoEstudios.txt");
              FileReader fr = new FileReader(arPac);
              lector = new BufferedReader(fr);
              while((dniPac = lector.readLine()) != null){
                    matricula = lector.readLine();
                    estado = lector.readLine();
                    diaR = lector.readLine();
                    mesR = lector.readLine();
                    anioR = lector.readLine();
                    aux1 = Integer.parseInt(diaR);
                    aux2 = Integer.parseInt(mesR);
                    aux3 = Integer.parseInt(anioR);
                    Fecha fechaRea = new Fecha(aux1, aux2, aux3);
                    diaE = lector.readLine();
                    mesE = lector.readLine();
                    anioE = lector.readLine();
                    aux1 = Integer.parseInt(diaE);
                    aux2 = Integer.parseInt(mesE);
                    aux3 = Integer.parseInt(anioE);
                    Fecha fechaEnt = new Fecha(aux1, aux2, aux3);
                    analisis = lector.readLine();
                    lector.readLine();
                    Estudio est = new Estudio();
                    EstudioController miEst = new EstudioController(est);
                    miEst.ColocarDniPaciente(dniPac);
                    miEst.ColocarMatricula(matricula);
                    miEst.ColocarEstado(estado);
                    miEst.ColocarFechaRealizacion(fechaRea);
                    miEst.ColocarFechaEntrega(fechaEnt);
                    ArrayList <Integer>aux =  new ArrayList<>();
                    if (analisis != null && !analisis.isEmpty()) {
                        String[] partes = analisis.split(";");
                        for (String p : partes) {
                               try {
                                    aux.add(Integer.parseInt(p.trim())); 
                              } catch (NumberFormatException e) {
                                     JOptionPane.showMessageDialog(this, e.getMessage());
                              }
                        }
                  }
                  miEst.colocarAnalisisRealizados(aux);
                    listaEstudios.add(miEst.obtenerEstudio());
              }
        } catch(IOException e){
              JOptionPane.showMessageDialog(this, e.getMessage());
        } finally{
              try{
                    if(lector != null){
                          lector.close();
                    }
              } catch(IOException e){
                  JOptionPane.showMessageDialog(this, e.getMessage());
              }
        }
    }

    public Principal() {
        initComponents();
        this.mapaPersonas = new HashMap<String, Persona>();
        this.listaEstudios = new ArrayList<Estudio>();
        setLocationRelativeTo(null);
        menuEstudio.setVisible(false);
        menuEstudio.setEnabled(false);
        menuProfesional.setVisible(false);
        menuProfesional.setEnabled(false);
        precargaPacientes();
        precargaProfesional();
        precargaEstudio();
    }
    
    public Principal(HashMap<String, Persona> mapaRecibido, ArrayList<Estudio> listaEstudios) {
        initComponents();
        this.mapaPersonas = mapaRecibido;
        this.listaEstudios = listaEstudios;
        setLocationRelativeTo(null);
        menuEstudio.setVisible(false);
        menuEstudio.setEnabled(false);
        menuProfesional.setVisible(false);
        menuProfesional.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            Principal = new javax.swing.JPanel();
            menuOpciones = new javax.swing.JComboBox<>();
            menuPaciente = new javax.swing.JComboBox<>();
            menuProfesional = new javax.swing.JComboBox<>();
            menuEstudio = new javax.swing.JComboBox<>();
            txtPrincipal = new javax.swing.JLabel();
            btnConfirmarMenu = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            btnSalir = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setBounds(new java.awt.Rectangle(0, 0, 600, 100));
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            Principal.setBackground(new java.awt.Color(153, 204, 255));
            Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            menuOpciones.setBackground(new java.awt.Color(0, 102, 153));
            menuOpciones.setForeground(new java.awt.Color(255, 255, 255));
            menuOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paciente", "Profesional", "Estudio" }));
            menuOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuOpciones.setMaximumSize(new java.awt.Dimension(167, 26));
            menuOpciones.setMinimumSize(new java.awt.Dimension(167, 26));
            menuOpciones.setPreferredSize(new java.awt.Dimension(167, 26));
            menuOpciones.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuOpcionesActionPerformed(evt);
                  }
            });
            Principal.add(menuOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 106, 200, 30));

            menuPaciente.setBackground(new java.awt.Color(0, 102, 153));
            menuPaciente.setForeground(new java.awt.Color(255, 255, 255));
            menuPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Eliminar", "Modificar", "Mostrar todos", "Buscar por DNI", "Mostrar con obra social", "Mostrar sin obra social", "Ver cantidad de estudios" }));
            menuPaciente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuPaciente.setMaximumSize(new java.awt.Dimension(167, 26));
            menuPaciente.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
                  public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                        menuPacienteMouseWheelMoved(evt);
                  }
            });
            menuPaciente.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuPacienteActionPerformed(evt);
                  }
            });
            Principal.add(menuPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 200, 30));

            menuProfesional.setBackground(new java.awt.Color(0, 102, 153));
            menuProfesional.setForeground(new java.awt.Color(255, 255, 255));
            menuProfesional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Eliminar", "Modificar", "Mostrar todos", "Buscar por matricula" }));
            menuProfesional.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuProfesional.setMaximumSize(new java.awt.Dimension(167, 26));
            menuProfesional.setMinimumSize(new java.awt.Dimension(167, 26));
            menuProfesional.setPreferredSize(new java.awt.Dimension(167, 26));
            menuProfesional.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuProfesionalActionPerformed(evt);
                  }
            });
            Principal.add(menuProfesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 200, 30));

            menuEstudio.setBackground(new java.awt.Color(0, 102, 153));
            menuEstudio.setForeground(new java.awt.Color(255, 255, 255));
            menuEstudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Modificar", "Mostrar todos", "Mostrar por estado", "Mostrar por profesional", "Mostrar por fecha de realizacion" }));
            menuEstudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuEstudio.setMaximumSize(new java.awt.Dimension(167, 26));
            menuEstudio.setMinimumSize(new java.awt.Dimension(167, 26));
            menuEstudio.setPreferredSize(new java.awt.Dimension(167, 26));
            Principal.add(menuEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 200, 30));

            txtPrincipal.setBackground(new java.awt.Color(10, 30, 30));
            txtPrincipal.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
            txtPrincipal.setForeground(new java.awt.Color(0, 0, 0));
            txtPrincipal.setText("OPCION");
            Principal.add(txtPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 75, -1, -1));

            btnConfirmarMenu.setBackground(new java.awt.Color(0, 51, 102));
            btnConfirmarMenu.setForeground(new java.awt.Color(255, 255, 255));
            btnConfirmarMenu.setText("CONFIRMAR");
            btnConfirmarMenu.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnConfirmarMenuActionPerformed(evt);
                  }
            });
            Principal.add(btnConfirmarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 321, 206, -1));

            jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(0, 0, 0));
            jLabel1.setText("OPERACION");
            jLabel1.setToolTipText("Operacion");
            Principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 214, 135, -1));

            btnSalir.setBackground(new java.awt.Color(0, 51, 102));
            btnSalir.setForeground(new java.awt.Color(255, 255, 255));
            btnSalir.setText("SALIR");
            btnSalir.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSalirActionPerformed(evt);
                  }
            });
            Principal.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 366, 206, -1));

            getContentPane().add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 410));

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void menuProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProfesionalActionPerformed

      }//GEN-LAST:event_menuProfesionalActionPerformed

      private void btnConfirmarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarMenuActionPerformed
        String caso, op = menuOpciones.getItemAt(menuOpciones.getSelectedIndex());
        int opcion = menuOpciones.getSelectedIndex();
        
        //Esto es para que la ventana de los formularios cambie segun
        //que se quiere cargar, sea paciente, profesional o estudio
        FormularioCarga form = new FormularioCarga(this.mapaPersonas, this.listaEstudios);
        form.metAux(opcion);
        
          switch (op){
              case "Paciente":
                  caso = menuPaciente.getItemAt(menuPaciente.getSelectedIndex());
                  switch (caso){
                      case "Cargar":
                          form.setVisible(true);
                          form.setEnabled(true);
                          form.setLocationRelativeTo(null);
                          break;
                          
                      case "Eliminar":
                          new FormularioEliminar(this.mapaPersonas, opcion, this.listaEstudios).setVisible(true);
                          break;
                          
                      case "Modificar":
                          new FormularioBuscar(this.mapaPersonas, opcion, caso, this.listaEstudios).setVisible(true);
                          break;
                          
                      case "Mostrar todos":
                          mostrarTodosPacientes();
                          break;
                          
                      case "Buscar por DNI":
                          new FormularioBuscar(this.mapaPersonas, opcion, caso, this.listaEstudios).setVisible(true);
                          break;
                          
                      case "Mostrar con obra social":
                          mostrarPacientesConOsinObra(true);
                          break;
                          
                      case "Mostrar sin obra social":
                          mostrarPacientesConOsinObra(false);
                          break;
                          
                      case "Ver cantidad de estudios":
                          new FormularioBuscar(this.mapaPersonas, opcion, caso, this.listaEstudios).setVisible(true);
                          break;
                  }
                  break;
              case "Profesional":
                  caso = menuProfesional.getItemAt(menuProfesional.getSelectedIndex());
                  switch(caso){
                      case "Cargar":
                          form.setVisible(true);
                          form.setEnabled(true);
                          form.setLocationRelativeTo(null);
                          break;
                      case "Eliminar":
                          new FormularioEliminar(this.mapaPersonas, opcion, this.listaEstudios).setVisible(true);
                          break;
                      case "Modificar":
                          new FormularioBuscar(this.mapaPersonas, opcion, caso, this.listaEstudios).setVisible(true);
                          break;
                      case "Mostrar todos":
                          mostrarTodosProfesionales();
                          break;
                      case "Buscar por matricula":
                          new FormularioBuscar(this.mapaPersonas, opcion, caso, this.listaEstudios).setVisible(true);
                          break;
                  }
                  break;
              case "Estudio":
                  caso = menuEstudio.getItemAt(menuEstudio.getSelectedIndex());
                  switch(caso){
                      case "Cargar":
                          form.setVisible(true);
                          form.setEnabled(true);
                          form.setLocationRelativeTo(null);
                          break;
                      case "Mostrar todos":
                          if (listaEstudios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No hay estudios cargados en el sistema.");
                            return;
                          }
                          new FormularioEstudio(this.mapaPersonas, caso, this.listaEstudios).setVisible(true);
                          break;
                      case "Mostrar por estado":
                          if (listaEstudios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No hay estudios cargados en el sistema.");
                            return;
                          }
                          new FormularioEstudio(this.mapaPersonas, caso, this.listaEstudios).setVisible(true);
                          break;
                      case "Mostrar por profesional":
                          if (listaEstudios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No hay estudios cargados en el sistema.");
                            return;
                          }
                          new FormularioEstudio(this.mapaPersonas, caso, this.listaEstudios).setVisible(true);
                          break;
                      case "Mostrar por fecha de realizacion":
                          if (listaEstudios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No hay estudios cargados en el sistema.");
                            return;
                          }
                          new FormularioEstudio(this.mapaPersonas, caso, this.listaEstudios).setVisible(true);
                          break;
                      case "Modificar":
                          if (listaEstudios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No hay estudios cargados en el sistema.");
                            return;
                          }
                          new FormularioEstudio(this.mapaPersonas, caso, this.listaEstudios).setVisible(true);
                          break;
                  }
          }
          
      }//GEN-LAST:event_btnConfirmarMenuActionPerformed

      private void menuOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionesActionPerformed
            int op = menuOpciones.getSelectedIndex();
            switch (op){
                  case 0:
                  menuPaciente.setVisible(true);
                  menuPaciente.setEnabled(true);
                  menuEstudio.setVisible(false);
                  menuEstudio.setEnabled(false);
                  menuProfesional.setVisible(false);
                  menuProfesional.setEnabled(false);
                  break;
                  case 1:
                  menuProfesional.setVisible(true);
                  menuProfesional.setEnabled(true);
                  menuEstudio.setVisible(false);
                  menuEstudio.setEnabled(false);
                  menuPaciente.setVisible(false);
                  menuPaciente.setEnabled(false);
                  break;
                  case 2:
                  menuEstudio.setVisible(true);
                  menuEstudio.setEnabled(true);
                  menuPaciente.setVisible(false);
                  menuPaciente.setEnabled(false);
                  menuProfesional.setVisible(false);
                  menuProfesional.setEnabled(false);
                  break;
            }
            this.revalidate();
            this.repaint();
      }//GEN-LAST:event_menuOpcionesActionPerformed

      private void menuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacienteActionPerformed

      }//GEN-LAST:event_menuPacienteActionPerformed

      private void menuPacienteMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_menuPacienteMouseWheelMoved
            // TODO add your handling code here:
      }//GEN-LAST:event_menuPacienteMouseWheelMoved

      private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            Object[] opciones = {"Salir", "Cancelar"};
            int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Esta seguro que desea salir?\n", "Salida", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(seleccion == 0)
                  System.exit(0);
      }//GEN-LAST:event_btnSalirActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel Principal;
      private javax.swing.JButton btnConfirmarMenu;
      private javax.swing.JButton btnSalir;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JComboBox<String> menuEstudio;
      private javax.swing.JComboBox<String> menuOpciones;
      private javax.swing.JComboBox<String> menuPaciente;
      private javax.swing.JComboBox<String> menuProfesional;
      private javax.swing.JLabel txtPrincipal;
      // End of variables declaration//GEN-END:variables

      
      //METODOS PACIENTES
    
      private void mostrarTodosPacientes(){
        boolean encontroPac = false;
        
        if (mapaPersonas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista está vacía.");
            return;
        }
        String listado = "---LISTADO PACIENTES---\n\n";
        for (Persona p : mapaPersonas.values()) {
            if (p instanceof Paciente pac){
                PacienteController miPac = new PacienteController(pac);
                encontroPac = true;
                listado += miPac.mostrarDatos() + "\n";
            }
        }
        if (encontroPac == true){
            JOptionPane.showMessageDialog(this, listado);}
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes caragdos.");}
      }
      
      
      private void mostrarPacientesConOsinObra(boolean conOsin){
        boolean encontroPac = false;
        boolean encontroPacObra = false;
        
        if (mapaPersonas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista está vacía.");
            return;
        }
        if (conOsin == true){
            String listado = "---LISTADO PACIENTES CON OBRA SOCIAL---\n\n";
        
            for (Persona p : mapaPersonas.values()) {
                if (p instanceof Paciente pac){
                    PacienteController miPac = new PacienteController(pac);
                    encontroPac = true;
                    if (miPac.muestraObraSocial()==true){
                        encontroPacObra = true;
                        listado += miPac.mostrarDatos() + "\n";
                }
            }
        }
        if (encontroPacObra == true){
            JOptionPane.showMessageDialog(this, listado);
            return;
        }
        else if(encontroPac == true){
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con obra social.");
        }
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes caragdos.");
        }
        }else{
            String listado = "---LISTADO PACIENTES SIN OBRA SOCIAL---\n\n";
        
            for (Persona p : mapaPersonas.values()) {
                if (p instanceof Paciente pac){
                    PacienteController miPac = new PacienteController(pac);
                    encontroPac = true;
                    if (miPac.muestraObraSocial()==false){
                        encontroPacObra = true;
                        listado += miPac.mostrarDatos() + "\n";
                }
            }
        }
        if (encontroPacObra == true){
            JOptionPane.showMessageDialog(this, listado);
            return;
        }
        else if(encontroPac == true){
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes sin obra social.");
        }
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes caragdos.");
        }
        }
      }
      
      //METODOS PROFESIONALES
      
      private void mostrarTodosProfesionales(){
        boolean encontroPro = false;
        
        if (mapaPersonas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista está vacía.");
            return;
        }
        String listado = "---LISTADO PROFESIONALES---\n\n";
        for (Persona p : mapaPersonas.values()) {
            if (p instanceof Profesional pro){
                ProfesionalController miPro = new ProfesionalController(pro);
                encontroPro = true;
                listado += miPro.mostrarDatos() + "\n";
            }
        }
        if (encontroPro == true){
            JOptionPane.showMessageDialog(this, listado);
        }
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron profesionales cargados.");
        }
      }
}