package View;

import Controller.EstudioController;
import Controller.PacienteController;
import Controller.ProfesionalController;
import Model.Estudio;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormularioEliminar extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private ArrayList<Estudio> listaEstudios;
    FondoPanel fondo = new FondoPanel();

      public FormularioEliminar() {
            this.setContentPane(fondo);
            initComponents();
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/unnamed.png")).getImage());
            setLocationRelativeTo(null);
      }

    public FormularioEliminar(HashMap<String, Persona> mapaPersonas, int op, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.listaEstudios = listaEstudios;
        setLocationRelativeTo(null);
        metAux(op);
    }
    
    public void metAux(int op){
            if(op == 0){
                  jPanelEliminarPaciente.setVisible(true);
                  jPanelEliminarPaciente.setEnabled(true);
                  jPanelEliminarProfesional.setVisible(false);
                  jPanelEliminarProfesional.setEnabled(false);
            } else if(op == 1){
                  jPanelEliminarProfesional.setVisible(true);
                  jPanelEliminarProfesional.setEnabled(true);
                  jPanelEliminarPaciente.setVisible(false);
                  jPanelEliminarPaciente.setEnabled(false);
            }
            this.revalidate();
            this.repaint();
      }
    //Falta agregar lo de archivos
    //Este metodo actualiza los archivos de paciente y profesional
    
      private void actualizarArchivoGeneral() {
            try(BufferedWriter escritorPac = new BufferedWriter(new FileWriter("archivos/archivoPacientes.txt"));
                    BufferedWriter escritorPro = new BufferedWriter(new FileWriter("archivos/archivoProfesionales.txt"))){
            for (Persona p : mapaPersonas.values()) {
                  if (p instanceof Paciente pac) {
                        PacienteController miPac = new PacienteController(pac);
                        escritorPac.append(miPac.muestraNombre() + "\n");
                        escritorPac.append(miPac.muestraApellido() + "\n");
                        escritorPac.append(miPac.muestraDni() + "\n");
                        escritorPac.append(miPac.muestraMail() + "\n");
                        escritorPac.append(miPac.muestraTelefono() + "\n");
                        escritorPac.append(miPac.muestraObraSocial() + "\n\n");
                  } else if (p instanceof Profesional pro) {
                        ProfesionalController miPro = new ProfesionalController(pro);
                        escritorPro.append(miPro.muestraNombre() + "\n");
                        escritorPro.append(miPro.muestraApellido() + "\n");
                        escritorPro.append(miPro.muestraDni() + "\n");
                        escritorPro.append(miPro.muestraTelefono() + "\n");
                        escritorPro.append(miPro.muestraMail() + "\n");
                        escritorPro.append(miPro.muestraMatricula() + "\n\n");
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
        matProEliminarTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEliminarPro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelEliminarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        jPanelEliminarPaciente.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI");

        jSeparator1.setBackground(new java.awt.Color(153, 204, 255));
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
        btnCancelar1.setText("Volver");
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
                .addContainerGap(88, Short.MAX_VALUE))
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
        jPanelEliminarProfesional.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Eliminar profesional");

        matProEliminarTxt.setBackground(new java.awt.Color(51, 51, 51));
        matProEliminarTxt.setForeground(new java.awt.Color(255, 255, 255));
        matProEliminarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matProEliminarTxtActionPerformed(evt);
            }
        });
        matProEliminarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matProEliminarTxtKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Matricula");

        jSeparator3.setBackground(new java.awt.Color(153, 204, 255));
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
        btnCancelar.setText("Volver");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEliminarProfesionalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(83, 83, 83))
                    .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                        .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanelEliminarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelEliminarProfesionalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(matProEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(79, Short.MAX_VALUE))))
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
                            .addComponent(matProEliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        boolean encontro = false;
        for (Estudio e : listaEstudios){
           EstudioController miEst = new EstudioController(e);
           if (miEst.muestraDniPaciente().equals(dniBusqueda)){
               JOptionPane.showMessageDialog(this, "No es posible eliminar un paciente que posea estudios. ");
               encontro = true;
               break;
           }
        }
        if (encontro == false){
            if (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Paciente)){
                Object[] opciones = {"Eliminar", "Cancelar"};
                int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Esta seguro que desea eliminar al paciente?\n", "Eliminar", 
                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(seleccion == 0){
                    mapaPersonas.remove(dniBusqueda);
                    actualizarArchivoGeneral();
                    JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
                  }
                }else{
                    JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
                    }
        }
        this.dispose();
    }//GEN-LAST:event_btnEliminarPacActionPerformed

    
    private void dniPacEliminarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacEliminarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacEliminarTxtActionPerformed

    private void matProEliminarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProEliminarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProEliminarTxtActionPerformed

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed

        String matBusqueda = matProEliminarTxt.getText();
        boolean tieneEst = false;
        boolean encontro = false;
        //Control (si profesional tiene estudios)
        for (Estudio e : listaEstudios){
                EstudioController miEst = new EstudioController(e);
                if (miEst.muestraMatriculaProfesional().equals(matBusqueda)){
                JOptionPane.showMessageDialog(this, "No es posible eliminar un profesional que posea estudios.");
                tieneEst = true;break;
                }
            }
        if (tieneEst == false){
            for (Persona p : mapaPersonas.values()){
                if (p instanceof Profesional pro){
                    ProfesionalController miPro = new ProfesionalController(pro);
                    if(miPro.muestraMatricula().equals(matBusqueda)){
                        encontro = true;
                        Object[] opcion = {"Eliminar", "Cancelar"};
                        int selecciones = javax.swing.JOptionPane.showOptionDialog(this,"Esta seguro que desea eliminar al profesional?\n", "Eliminar", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
                        if(selecciones == 0){
                            mapaPersonas.remove(miPro.muestraDni());
                            actualizarArchivoGeneral();
                            JOptionPane.showMessageDialog(this, "Profesional eliminado correctamente.");break;
                        }
                    }
                  }
                }
            if (encontro == false){
                JOptionPane.showMessageDialog(this, "Profesional no encontrado.");
                matProEliminarTxt.setText("");
            }
        }
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

      private void matProEliminarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matProEliminarTxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matProEliminarTxtKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminarPac;
    private javax.swing.JButton btnEliminarPro;
    private javax.swing.JTextField dniPacEliminarTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelEliminarPaciente;
    private javax.swing.JPanel jPanelEliminarProfesional;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField matProEliminarTxt;
    // End of variables declaration//GEN-END:variables
}
