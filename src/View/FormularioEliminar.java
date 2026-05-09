package View;

import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FormularioEliminar extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String modoActual;

      public FormularioEliminar() {
            initComponents();
            setLocationRelativeTo(null);
      }

    public FormularioEliminar(HashMap<String, Persona> mapaPersonas, int op) {
        this();
        this.mapaPersonas = mapaPersonas;
        setLocationRelativeTo(null);
        metAux(op);
    }
    
    public void metAux(int op){
            if(op == 0){
                  this.modoActual = "Paciente";
                  jPanelEliminarPaciente.setVisible(true);
                  jPanelEliminarPaciente.setEnabled(true);
                  jPanelEliminarProfesional.setVisible(false);
                  jPanelEliminarProfesional.setEnabled(false);
            } else if(op == 1){
                  this.modoActual = "Profesional";
                  jPanelEliminarProfesional.setVisible(true);
                  jPanelEliminarProfesional.setEnabled(true);
                  jPanelEliminarPaciente.setVisible(false);
                  jPanelEliminarPaciente.setEnabled(false);
            }
            this.revalidate();
            this.repaint();
      }
    
    //Este metodo actualiza los archivos de paciente y profesional
    
      public void actualizarArchivoGeneral() {
            try(BufferedWriter escritorPac = new BufferedWriter(new FileWriter("archivos/archivoPacientes.txt"));
                    BufferedWriter escritorPro = new BufferedWriter(new FileWriter("archivos/archivoProfesionales.txt"))){
            for (Persona p : mapaPersonas.values()) {
                  if (p instanceof Paciente pac) {
                        escritorPac.append(pac.getNombre() + "\n");
                        escritorPac.append(pac.getApellido() + "\n");
                        escritorPac.append(pac.getDni() + "\n");
                        escritorPac.append(pac.getMail() + "\n");
                        escritorPac.append(pac.getTelefono() + "\n");
                        escritorPac.append(pac.getObraSocial() + "\n\n");
                  } else if (p instanceof Profesional pro) {
                        escritorPro.append(pro.getNombre() + "\n");
                        escritorPro.append(pro.getApellido() + "\n");
                        escritorPro.append(pro.getTelefono() + "\n");
                        escritorPro.append(pro.getMail() + "\n");
                        escritorPro.append(pro.getMatricula() + "\n\n");
                        }
                  }
            } catch (IOException e) {
                  JOptionPane.showMessageDialog(this, "Error al abrir el archivo: " + e.getMessage());
            }
      }
      
      

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanelEliminarPaciente = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            dniPacEliminarTxt = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            jSeparator1 = new javax.swing.JSeparator();
            btnEliminarPac = new javax.swing.JButton();
            btnCancelar1 = new javax.swing.JButton();
            jPanelEliminarProfesional = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            dniProEliminarTxt = new javax.swing.JTextField();
            jLabel6 = new javax.swing.JLabel();
            jSeparator3 = new javax.swing.JSeparator();
            btnEliminarPro = new javax.swing.JButton();
            btnCancelar = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jPanelEliminarPaciente.setBackground(new java.awt.Color(153, 204, 255));

            jLabel1.setBackground(new java.awt.Color(0, 0, 0));
            jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(0, 0, 0));
            jLabel1.setText("Eliminar paciente");

            dniPacEliminarTxt.setBackground(new java.awt.Color(51, 51, 51));
            dniPacEliminarTxt.setForeground(new java.awt.Color(255, 255, 255));
            dniPacEliminarTxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPacEliminarTxtActionPerformed(evt);
                  }
            });
            dniPacEliminarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniPacEliminarTxtKeyTyped(evt);
                  }
            });

            jLabel4.setForeground(new java.awt.Color(102, 102, 102));
            jLabel4.setText("DNI");

            jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnEliminarPac.setBackground(new java.awt.Color(0, 51, 102));
            btnEliminarPac.setForeground(new java.awt.Color(255, 255, 255));
            btnEliminarPac.setText("Buscar y eliminar");
            btnEliminarPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnEliminarPacActionPerformed(evt);
                  }
            });

            btnCancelar1.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelar1.setText("Cancelar");
            btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelar1ActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelEliminarPacienteLayout = new javax.swing.GroupLayout(jPanelEliminarPaciente);
            jPanelEliminarPaciente.setLayout(jPanelEliminarPacienteLayout);
            jPanelEliminarPacienteLayout.setHorizontalGroup(
                  jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dniPacEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                                    .addGap(102, 102, 102)
                                    .addGroup(jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(btnEliminarPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(92, Short.MAX_VALUE))
                  .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanelEliminarPacienteLayout.setVerticalGroup(
                  jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGroup(jPanelEliminarPacienteLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanelEliminarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniPacEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminarPac)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar1)))
                        .addContainerGap(77, Short.MAX_VALUE))
            );

            jPanelEliminarProfesional.setBackground(new java.awt.Color(153, 204, 255));

            jLabel3.setBackground(new java.awt.Color(0, 0, 0));
            jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(0, 0, 0));
            jLabel3.setText("Eliminar profesional");

            dniProEliminarTxt.setBackground(new java.awt.Color(51, 51, 51));
            dniProEliminarTxt.setForeground(new java.awt.Color(255, 255, 255));
            dniProEliminarTxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniProEliminarTxtActionPerformed(evt);
                  }
            });
            dniProEliminarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniProEliminarTxtKeyTyped(evt);
                  }
            });

            jLabel6.setForeground(new java.awt.Color(102, 102, 102));
            jLabel6.setText("Matricula");

            jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnEliminarPro.setBackground(new java.awt.Color(0, 51, 102));
            btnEliminarPro.setForeground(new java.awt.Color(255, 255, 255));
            btnEliminarPro.setText("Buscar y eliminar");
            btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnEliminarProActionPerformed(evt);
                  }
            });

            btnCancelar.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelar.setText("Cancelar");
            btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelarActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelEliminarProfesionalLayout = new javax.swing.GroupLayout(jPanelEliminarProfesional);
            jPanelEliminarProfesional.setLayout(jPanelEliminarProfesionalLayout);
            jPanelEliminarProfesionalLayout.setHorizontalGroup(
                  jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                    .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dniProEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(btnEliminarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                      .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addContainerGap(69, Short.MAX_VALUE))
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEliminarProfesionalLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addGap(83, 83, 83))))
            );
            jPanelEliminarProfesionalLayout.setVerticalGroup(
                  jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                        .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                    .addGap(86, 86, 86)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniProEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminarPro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar)))
                        .addContainerGap(84, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanelEliminarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jPanelEliminarProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addContainerGap()))
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanelEliminarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                              .addGap(10, 10, 10)
                              .addComponent(jPanelEliminarProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addContainerGap()))
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      
    private void btnEliminarPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacActionPerformed
        String dniBusqueda = dniPacEliminarTxt.getText();
        
        //Falta agregar controles de si teiene estudios, etc.
        if (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Paciente)){
            Object[] opciones = {"Eliminar", "Cancelar"};
            int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Esta seguro que desea eliminar al paciente?\n", "Eliminar", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(seleccion == 0){
                mapaPersonas.remove(dniBusqueda);
                actualizarArchivoGeneral();
                JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
                  }
            }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
        this.dispose();
    }//GEN-LAST:event_btnEliminarPacActionPerformed

    
    private void dniPacEliminarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacEliminarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacEliminarTxtActionPerformed

    private void dniProEliminarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniProEliminarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniProEliminarTxtActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
        String dniBusqueda = dniProEliminarTxt.getText();
        //Falta agregar controles de si tiene estudios, etc.
        if (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Profesional)){
              Object[] opciones = {"Eliminar", "Cancelar"};
            int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Esta seguro que desea eliminar el profesional?\n", "Eliminar", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if(seleccion == 0){
                mapaPersonas.remove(dniBusqueda);
                actualizarArchivoGeneral();
                JOptionPane.showMessageDialog(this, "Profesional eliminado correctamente.");
            }
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun profesional con esa matricula " + dniBusqueda);
        }
        this.dispose();
    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

      private void dniPacEliminarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniPacEliminarTxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniPacEliminarTxtKeyTyped

      private void dniProEliminarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniProEliminarTxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniProEliminarTxtKeyTyped

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnCancelar;
      private javax.swing.JButton btnCancelar1;
      private javax.swing.JButton btnEliminarPac;
      private javax.swing.JButton btnEliminarPro;
      private javax.swing.JTextField dniPacEliminarTxt;
      private javax.swing.JTextField dniProEliminarTxt;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JPanel jPanelEliminarPaciente;
      private javax.swing.JPanel jPanelEliminarProfesional;
      private javax.swing.JSeparator jSeparator1;
      private javax.swing.JSeparator jSeparator3;
      // End of variables declaration//GEN-END:variables
}