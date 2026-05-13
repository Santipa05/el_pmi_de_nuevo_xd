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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Principal extends javax.swing.JFrame{
    private ArrayList<Estudio> listaEstudios;
    private HashMap <String, Persona> mapaPersonas;

    public Principal() {
        initComponents();
        this.mapaPersonas = new HashMap<String, Persona>();
        this.listaEstudios = new ArrayList<Estudio>();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/unnamed.png")).getImage());
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

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            Principal = new javax.swing.JPanel();
            menuPaciente = new javax.swing.JComboBox<>();
            menuProfesional = new javax.swing.JComboBox<>();
            menuEstudio = new javax.swing.JComboBox<>();
            txtPrincipal = new javax.swing.JLabel();
            btnConfirmarMenu = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            btnSalir = new javax.swing.JButton();
            jPanelFondo = new FondoPanel();
            togglePac = new javax.swing.JToggleButton();
            togglePro = new javax.swing.JToggleButton();
            toggleEst = new javax.swing.JToggleButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setBounds(new java.awt.Rectangle(0, 0, 600, 100));
            setResizable(false);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            Principal.setBackground(new java.awt.Color(153, 204, 255));
            Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            menuPaciente.setBackground(new java.awt.Color(0, 102, 153));
            menuPaciente.setForeground(new java.awt.Color(255, 255, 255));
            menuPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Eliminar", "Modificar", "Mostrar/Buscar" }));
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
            Principal.add(menuPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 200, 30));

            menuProfesional.setBackground(new java.awt.Color(0, 102, 153));
            menuProfesional.setForeground(new java.awt.Color(255, 255, 255));
            menuProfesional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Eliminar", "Modificar", "Mostrar/Buscar" }));
            menuProfesional.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuProfesional.setMaximumSize(new java.awt.Dimension(167, 26));
            menuProfesional.setMinimumSize(new java.awt.Dimension(167, 26));
            menuProfesional.setPreferredSize(new java.awt.Dimension(167, 26));
            menuProfesional.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuProfesionalActionPerformed(evt);
                  }
            });
            Principal.add(menuProfesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 200, 30));

            menuEstudio.setBackground(new java.awt.Color(0, 102, 153));
            menuEstudio.setForeground(new java.awt.Color(255, 255, 255));
            menuEstudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargar", "Modificar", "Mostrar/Buscar" }));
            menuEstudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            menuEstudio.setMaximumSize(new java.awt.Dimension(167, 26));
            menuEstudio.setMinimumSize(new java.awt.Dimension(167, 26));
            menuEstudio.setPreferredSize(new java.awt.Dimension(167, 26));
            menuEstudio.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuEstudioActionPerformed(evt);
                  }
            });
            Principal.add(menuEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 200, 30));

            txtPrincipal.setBackground(new java.awt.Color(85, 177, 177));
            txtPrincipal.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            txtPrincipal.setForeground(new java.awt.Color(102, 153, 255));
            txtPrincipal.setText("OPCION");
            Principal.add(txtPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

            btnConfirmarMenu.setBackground(new java.awt.Color(0, 51, 102));
            btnConfirmarMenu.setForeground(new java.awt.Color(255, 255, 255));
            btnConfirmarMenu.setText("CONFIRMAR");
            btnConfirmarMenu.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnConfirmarMenuActionPerformed(evt);
                  }
            });
            Principal.add(btnConfirmarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 330, 190, -1));

            jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(102, 153, 255));
            jLabel1.setText("OPERACION");
            jLabel1.setToolTipText("Operacion");
            Principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 135, -1));

            btnSalir.setBackground(new java.awt.Color(0, 51, 102));
            btnSalir.setForeground(new java.awt.Color(255, 255, 255));
            btnSalir.setText("SALIR");
            btnSalir.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnSalirActionPerformed(evt);
                  }
            });
            Principal.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 370, 190, -1));

            togglePac.setBackground(new java.awt.Color(0, 102, 204));
            togglePac.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
            togglePac.setForeground(new java.awt.Color(0, 0, 0));
            togglePac.setText("PACIENTE");
            togglePac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        togglePacActionPerformed(evt);
                  }
            });

            togglePro.setBackground(new java.awt.Color(0, 102, 204));
            togglePro.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
            togglePro.setForeground(new java.awt.Color(0, 0, 0));
            togglePro.setText("PROFESIONAL");
            togglePro.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        toggleProActionPerformed(evt);
                  }
            });

            toggleEst.setBackground(new java.awt.Color(0, 102, 204));
            toggleEst.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
            toggleEst.setForeground(new java.awt.Color(0, 0, 0));
            toggleEst.setText("ESTUDIO");
            toggleEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        toggleEstActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
            jPanelFondo.setLayout(jPanelFondoLayout);
            jPanelFondoLayout.setHorizontalGroup(
                  jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(togglePac)
                        .addGap(18, 18, 18)
                        .addComponent(togglePro)
                        .addGap(18, 18, 18)
                        .addComponent(toggleEst)
                        .addContainerGap(96, Short.MAX_VALUE))
            );
            jPanelFondoLayout.setVerticalGroup(
                  jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(togglePac, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(togglePro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(toggleEst, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(294, Short.MAX_VALUE))
            );

            Principal.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

            getContentPane().add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void menuProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProfesionalActionPerformed

      }//GEN-LAST:event_menuProfesionalActionPerformed

      private void btnConfirmarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarMenuActionPerformed
        String caso, op;
        int opcion;
        if(togglePac.isSelected()){
              op = "Paciente";
              opcion = 0;
        }
        else if(togglePro.isSelected()){
              op = "Profesional";
              opcion = 1;
        }
        else{
              op = "Estudio";
              opcion = 2;
        }
        
        
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
                          
                      case "Mostrar/Buscar":
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
                      case "Mostrar/Buscar":
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
                      case "Mostrar/Buscar":
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

      private void menuEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstudioActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_menuEstudioActionPerformed

      private void togglePacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglePacActionPerformed
                  togglePro.setSelected(false);
                  toggleEst.setSelected(false);
                  menuPaciente.setVisible(true);
                  menuPaciente.setEnabled(true);
                  menuEstudio.setVisible(false);
                  menuEstudio.setEnabled(false);
                  menuProfesional.setVisible(false);
                  menuProfesional.setEnabled(false);
      }//GEN-LAST:event_togglePacActionPerformed

      private void toggleProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleProActionPerformed
                  togglePac.setSelected(false);
                  toggleEst.setSelected(false);
                  menuProfesional.setVisible(true);
                  menuProfesional.setEnabled(true);
                  menuEstudio.setVisible(false);
                  menuEstudio.setEnabled(false);
                  menuPaciente.setVisible(false);
                  menuPaciente.setEnabled(false);
      }//GEN-LAST:event_toggleProActionPerformed

      private void toggleEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleEstActionPerformed
                  togglePac.setSelected(false);
                  togglePro.setSelected(false);
                  menuEstudio.setVisible(true);
                  menuEstudio.setEnabled(true);
                  menuPaciente.setVisible(false);
                  menuPaciente.setEnabled(false);
                  menuProfesional.setVisible(false);
                  menuProfesional.setEnabled(false);
      }//GEN-LAST:event_toggleEstActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel Principal;
      private javax.swing.JButton btnConfirmarMenu;
      private javax.swing.JButton btnSalir;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JPanel jPanelFondo;
      private javax.swing.JComboBox<String> menuEstudio;
      private javax.swing.JComboBox<String> menuPaciente;
      private javax.swing.JComboBox<String> menuProfesional;
      private javax.swing.JToggleButton toggleEst;
      private javax.swing.JToggleButton togglePac;
      private javax.swing.JToggleButton togglePro;
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