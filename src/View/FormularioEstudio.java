package View;

import Controller.EstudioController;
import Model.Estudio;
import Model.Fecha;
import Model.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class FormularioEstudio extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private int op;

      public FormularioEstudio() {
            initComponents();
            setLocationRelativeTo(null);
      }
      
      public FormularioEstudio(HashMap<String, Persona> mapaPersonas, String operacion, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.accionActual = operacion; 
        this.listaEstudios = listaEstudios;
        metAux(accionActual);
      }
      
       private void metAux(String accionActual){
           if (accionActual == "Mostrar todos"){
               jPanelMostrarEstudios.setVisible(true);
               jPanelMostrarEstudios.setEnabled(true);
               jPanelBuscarEstudioEstado.setVisible(false);
               jPanelBuscarEstudioEstado.setEnabled(false);
               jPanelBuscarEstudioFechaRec.setVisible(false);
               jPanelBuscarEstudioFechaRec.setEnabled(false);
               jPanelBuscarEstudioPro.setVisible(false);
               jPanelBuscarEstudioPro.setEnabled(false);
               Fecha fechaR = new Fecha(0, 0, 0);
               mostrarEstudios(accionActual, "", fechaR);
               txtMuestraEstudios.setVisible(true);
               txtMuestraEstudios.setEnabled(true);
           }else if (accionActual == "Mostrar por profesional"){
               jPanelMostrarEstudios.setVisible(false);
               jPanelMostrarEstudios.setEnabled(false);
               jPanelBuscarEstudioEstado.setVisible(false);
               jPanelBuscarEstudioEstado.setEnabled(false);
               jPanelBuscarEstudioFechaRec.setVisible(false);
               jPanelBuscarEstudioFechaRec.setEnabled(false);
               jPanelBuscarEstudioPro.setVisible(true);
               jPanelBuscarEstudioPro.setEnabled(true);
           }else if (accionActual == "Mostrar por estado"){
               jPanelMostrarEstudios.setVisible(false);
               jPanelMostrarEstudios.setEnabled(false);
               jPanelBuscarEstudioEstado.setVisible(true);
               jPanelBuscarEstudioEstado.setEnabled(true);
               jPanelBuscarEstudioFechaRec.setVisible(false);
               jPanelBuscarEstudioFechaRec.setEnabled(false);
               jPanelBuscarEstudioPro.setVisible(false);
               jPanelBuscarEstudioPro.setEnabled(false);
           }else if(accionActual == "Mostrar por fecha de realizacion"){
               jPanelMostrarEstudios.setVisible(false);
               jPanelMostrarEstudios.setEnabled(false);
               jPanelBuscarEstudioEstado.setVisible(false);
               jPanelBuscarEstudioEstado.setEnabled(false);
               jPanelBuscarEstudioFechaRec.setVisible(true);
               jPanelBuscarEstudioFechaRec.setEnabled(true);
               jPanelBuscarEstudioPro.setVisible(false);
               jPanelBuscarEstudioPro.setEnabled(false);
           }
           this.revalidate();
           this.repaint();
      }
      
      private void muestraOno(boolean muestra){
          if (muestra){
              jPanelMostrarEstudios.setVisible(true);
              jPanelMostrarEstudios.setEnabled(true);
              txtMuestraEstudios.setVisible(true);
              txtMuestraEstudios.setEnabled(true);
          }else{
              jPanelMostrarEstudios.setVisible(false);
              txtMuestraEstudios.setVisible(false);
          }
      }
      
      
       private void mostrarEstudios(String accionActual, String opcion, Fecha fec) {
        boolean encontro = false;
        
        switch(accionActual){
            
            case "Mostrar todos":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    String infoEstudio = miEst.muestraEstudio();
                    txtMuestraEstudios.append(infoEstudio + "\n");
                    muestraOno(true);
                }break;
                
            case "Mostrar por profesional":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraMatriculaProfesional().trim().equals(opcion.trim())){
                        String infoEstudio = miEst.muestraEstudio();
                        txtMuestraEstudios.append(infoEstudio + "\n");
                        encontro = true;
                    }
                }break;
                
            case "Mostrar por estado":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraEstado().equals(opcion)){
                        String infoEstudio = miEst.muestraEstudio();
                        txtMuestraEstudios.append(infoEstudio + "\n");
                        encontro = true;
                    }
                }break;
                    
            case "Mostrar por fecha de realizacion":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.esMismaFecha(fec)){
                        String infoEstudio = miEst.muestraEstudio();
                        txtMuestraEstudios.append(infoEstudio + "\n");
                        encontro = true;
                    }
                }break;
        }
        
        if (encontro == true){
            muestraOno(true);
            jPanelBuscarEstudioPro.setVisible(false);
            jPanelBuscarEstudioFechaRec.setVisible(false);
            jPanelBuscarEstudioEstado.setVisible(false);
        }else{
            switch(accionActual){
                case "Mostrar por estado":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con el estado ingresada.");break;
                case "Mostrar por profesional":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con el profesional ingresada.");break;
                case "Mostrar por fecha de realizacion":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con la fecha ingresada.");break;
            }
        }
    }
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMostrarEstudios = new javax.swing.JPanel();
        txtMuestraEstudios = new java.awt.TextArea();
        jPanelBuscarEstudioEstado = new javax.swing.JPanel();
        btnBuscarEstEsta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estadoInput = new javax.swing.JComboBox<>();
        jPanelBuscarEstudioFechaRec = new javax.swing.JPanel();
        btnBuscarEstFec = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fechaRealInput = new javax.swing.JSpinner();
        jPanelBuscarEstudioPro = new javax.swing.JPanel();
        btnBuscarEstPro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        matProEstInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtMuestraEstudios.setBackground(new java.awt.Color(153, 204, 255));
        txtMuestraEstudios.setEditable(false);
        txtMuestraEstudios.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelMostrarEstudiosLayout = new javax.swing.GroupLayout(jPanelMostrarEstudios);
        jPanelMostrarEstudios.setLayout(jPanelMostrarEstudiosLayout);
        jPanelMostrarEstudiosLayout.setHorizontalGroup(
            jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMuestraEstudios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
        );
        jPanelMostrarEstudiosLayout.setVerticalGroup(
            jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMuestraEstudios, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        jPanelBuscarEstudioEstado.setBackground(new java.awt.Color(153, 204, 255));

        btnBuscarEstEsta.setText("Buscar");
        btnBuscarEstEsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstEstaActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Estado");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar estudio");

        estadoInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
        estadoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarEstudioEstadoLayout = new javax.swing.GroupLayout(jPanelBuscarEstudioEstado);
        jPanelBuscarEstudioEstado.setLayout(jPanelBuscarEstudioEstadoLayout);
        jPanelBuscarEstudioEstadoLayout.setHorizontalGroup(
            jPanelBuscarEstudioEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioEstadoLayout.createSequentialGroup()
                .addGroup(jPanelBuscarEstudioEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarEstudioEstadoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBuscarEstudioEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanelBuscarEstudioEstadoLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnBuscarEstEsta)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanelBuscarEstudioEstadoLayout.setVerticalGroup(
            jPanelBuscarEstudioEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioEstadoLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudioEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarEstEsta)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        jPanelBuscarEstudioFechaRec.setBackground(new java.awt.Color(153, 204, 255));

        btnBuscarEstFec.setText("Buscar");
        btnBuscarEstFec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstFecActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Buscar estudio");

        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Fecha de realizacion");

        fechaRealInput.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1777426620000L), new java.util.Date(1777426620000L), new java.util.Date(1924997820000L), java.util.Calendar.DAY_OF_MONTH));
        fechaRealInput.setEditor(new javax.swing.JSpinner.DateEditor(fechaRealInput, "dd/MM/yyyy"));

        javax.swing.GroupLayout jPanelBuscarEstudioFechaRecLayout = new javax.swing.GroupLayout(jPanelBuscarEstudioFechaRec);
        jPanelBuscarEstudioFechaRec.setLayout(jPanelBuscarEstudioFechaRecLayout);
        jPanelBuscarEstudioFechaRecLayout.setHorizontalGroup(
            jPanelBuscarEstudioFechaRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioFechaRecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarEstudioFechaRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarEstudioFechaRecLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3))
                    .addGroup(jPanelBuscarEstudioFechaRecLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaRealInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBuscarEstudioFechaRecLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnBuscarEstFec)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanelBuscarEstudioFechaRecLayout.setVerticalGroup(
            jPanelBuscarEstudioFechaRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioFechaRecLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBuscarEstudioFechaRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaRealInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarEstFec)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        jPanelBuscarEstudioPro.setBackground(new java.awt.Color(153, 204, 255));

        btnBuscarEstPro.setText("Buscar");
        btnBuscarEstPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstProActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Buscar estudio");

        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Matricula del profesional");

        matProEstInput.setForeground(new java.awt.Color(255, 255, 255));
        matProEstInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matProEstInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarEstudioProLayout = new javax.swing.GroupLayout(jPanelBuscarEstudioPro);
        jPanelBuscarEstudioPro.setLayout(jPanelBuscarEstudioProLayout);
        jPanelBuscarEstudioProLayout.setHorizontalGroup(
            jPanelBuscarEstudioProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matProEstInput, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarEstudioProLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarEstudioProLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarEstPro)
                .addGap(170, 170, 170))
        );
        jPanelBuscarEstudioProLayout.setVerticalGroup(
            jPanelBuscarEstudioProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudioProLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBuscarEstudioProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matProEstInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarEstPro)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMostrarEstudios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanelBuscarEstudioEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(922, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelBuscarEstudioFechaRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(786, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanelBuscarEstudioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(772, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMostrarEstudios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelBuscarEstudioEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelBuscarEstudioFechaRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelBuscarEstudioPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEstEstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstEstaActionPerformed
        String estadoSelec = estadoInput.getItemAt(estadoInput.getSelectedIndex());
        Fecha fechaR = new Fecha(0, 0, 0);
        mostrarEstudios(accionActual, estadoSelec, fechaR);
    }//GEN-LAST:event_btnBuscarEstEstaActionPerformed

    private void estadoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoInputActionPerformed

    private void btnBuscarEstFecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstFecActionPerformed
        
        java.util.Date dateRealizacion = (java.util.Date) fechaRealInput.getValue();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dateRealizacion);
        int diaR = cal.get(java.util.Calendar.DAY_OF_MONTH);
        int mesR = cal.get(java.util.Calendar.MONTH) + 1;
        int anioR = cal.get(java.util.Calendar.YEAR);
        Fecha fechaR = new Fecha(diaR, mesR, anioR);
        mostrarEstudios(accionActual, "", fechaR);
    }//GEN-LAST:event_btnBuscarEstFecActionPerformed

    private void btnBuscarEstProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstProActionPerformed
        String matricula = matProEstInput.getText().trim();
        if (!matricula.isEmpty()){
            Fecha fechaR = new Fecha(0, 0, 0);
            mostrarEstudios(accionActual, matricula, fechaR);
        }else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una matrícula.");
        }
    }//GEN-LAST:event_btnBuscarEstProActionPerformed

    private void matProEstInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProEstInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProEstInputActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEstEsta;
    private javax.swing.JButton btnBuscarEstFec;
    private javax.swing.JButton btnBuscarEstPro;
    private javax.swing.JComboBox<String> estadoInput;
    private javax.swing.JSpinner fechaRealInput;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelBuscarEstudioEstado;
    private javax.swing.JPanel jPanelBuscarEstudioFechaRec;
    private javax.swing.JPanel jPanelBuscarEstudioPro;
    private javax.swing.JPanel jPanelMostrarEstudios;
    private javax.swing.JTextField matProEstInput;
    private java.awt.TextArea txtMuestraEstudios;
    // End of variables declaration//GEN-END:variables
}
