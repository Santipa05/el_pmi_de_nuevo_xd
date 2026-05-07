package View;

import Controller.EstudioController;
import Model.Estudio;
import Model.Fecha;
import Model.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
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
      
    public void mostrarEstudioATabla(Estudio est) {
    DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
    EstudioController miEst = new EstudioController(est);
    Object[] nuevaFila = new Object[6]; 
    nuevaFila[0] = miEst.muestraDniPaciente();
    nuevaFila[1] = miEst.muestraMatriculaProfesional();
    nuevaFila[2] = miEst.muestraFechaRealizacion();
    nuevaFila[3] = miEst.muestraFechaEntrega();
    nuevaFila[4] = miEst.muestraEstado();
    nuevaFila[5] = miEst.muestraAnalisisRealizados();
    modelo.addRow(nuevaFila);
}
       private void metAux(String accionActual){
           if (listaEstudios.isEmpty()){
               JOptionPane.showMessageDialog(this, "No se encontraron estudios cargados.");
           }else{
               switch (accionActual) {
                   case "Mostrar todos":
                       jPanelMostrarEstudios.setVisible(false);
                       jPanelMostrarEstudios.setEnabled(false);
                       jPanelBuscarEstudioEstado.setVisible(false);
                       jPanelBuscarEstudioEstado.setEnabled(false);
                       jPanelBuscarEstudioFechaRec.setVisible(false);
                       jPanelBuscarEstudioFechaRec.setEnabled(false);
                       jPanelBuscarEstudioPro.setVisible(false);
                       jPanelBuscarEstudioPro.setEnabled(false);
                       Fecha fechaR = new Fecha(0, 0, 0);
                       mostrarEstudios(accionActual, "", fechaR);
                       jPanelModificarEst.setVisible(false);
                       jPanelModificarEst.setEnabled(false);
                       break;
                   case "Mostrar por profesional":
                       jPanelMostrarEstudios.setVisible(false);
                       jPanelMostrarEstudios.setEnabled(false);
                       jPanelBuscarEstudioEstado.setVisible(false);
                       jPanelBuscarEstudioEstado.setEnabled(false);
                       jPanelBuscarEstudioFechaRec.setVisible(false);
                       jPanelBuscarEstudioFechaRec.setEnabled(false);
                       jPanelBuscarEstudioPro.setVisible(true);
                       jPanelBuscarEstudioPro.setEnabled(true);
                       jPanelModificarEst.setVisible(false);
                       jPanelModificarEst.setEnabled(false);
                       break;
                   case "Mostrar por estado":
                       jPanelMostrarEstudios.setVisible(false);
                       jPanelMostrarEstudios.setEnabled(false);
                       jPanelBuscarEstudioEstado.setVisible(true);
                       jPanelBuscarEstudioEstado.setEnabled(true);
                       jPanelBuscarEstudioFechaRec.setVisible(false);
                       jPanelBuscarEstudioFechaRec.setEnabled(false);
                       jPanelBuscarEstudioPro.setVisible(false);
                       jPanelBuscarEstudioPro.setEnabled(false);
                       jPanelModificarEst.setVisible(false);
                       jPanelModificarEst.setEnabled(false);
                       break;
                   case "Mostrar por fecha de realizacion":
                       jPanelMostrarEstudios.setVisible(false);
                       jPanelMostrarEstudios.setEnabled(false);
                       jPanelBuscarEstudioEstado.setVisible(false);
                       jPanelBuscarEstudioEstado.setEnabled(false);
                       jPanelBuscarEstudioFechaRec.setVisible(true);
                       jPanelBuscarEstudioFechaRec.setEnabled(true);
                       jPanelBuscarEstudioPro.setVisible(false);
                       jPanelBuscarEstudioPro.setEnabled(false);
                       jPanelModificarEst.setVisible(false);
                       jPanelModificarEst.setEnabled(false);
                       break;
                   case "Modificar":
                       jPanelModificarEst.setVisible(true);
                       jPanelModificarEst.setEnabled(true);
                       jPanelMostrarEstudios.setVisible(false);
                       jPanelMostrarEstudios.setEnabled(false);
                       jPanelBuscarEstudioEstado.setVisible(false);
                       jPanelBuscarEstudioEstado.setEnabled(false);
                       jPanelBuscarEstudioFechaRec.setVisible(false);
                       jPanelBuscarEstudioFechaRec.setEnabled(false);
                       jPanelBuscarEstudioPro.setVisible(false);
                       jPanelBuscarEstudioPro.setEnabled(false);
                       
               }
           this.revalidate();
           this.repaint();
      }
    }
      
      
       private void mostrarEstudios(String accionActual, String opcion, Fecha fec) {
        boolean encontro = false;
        switch(accionActual){
            case "Mostrar todos":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    mostrarEstudioATabla(miEst.obtenerEstudio());
                }jPanelMostrarEstudios.setVisible(true);
                 jPanelMostrarEstudios.setEnabled(true);break;
                
            case "Mostrar por profesional":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraMatriculaProfesional().trim().equals(opcion.trim())){
                        mostrarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }break;
                
            case "Mostrar por estado":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraEstado().equals(opcion)){
                        mostrarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }jPanelMostrarEstudios.setVisible(true);
                 jPanelMostrarEstudios.setEnabled(true);break;
                    
            case "Mostrar por fecha de realizacion":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.esMismaFecha(fec)){
                        mostrarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }jPanelMostrarEstudios.setVisible(true);
                 jPanelMostrarEstudios.setEnabled(true);break;
            case "Modificar":
                for (Estudio est : listaEstudios){
                    EstudioController miEst = new EstudioController(est);
                    if(miEst.muestraDniPaciente().equals(opcion)){
                        mostrarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }jPanelMostrarEstudios.setVisible(true);
                 jPanelMostrarEstudios.setEnabled(true);break;
        }
        
        if (encontro == true){
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
            jScrollPane2 = new javax.swing.JScrollPane();
            jTableMostrar = new javax.swing.JTable();
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
            jPanelModificarEst = new javax.swing.JPanel();
            jLabel6 = new javax.swing.JLabel();
            dniPactxt = new javax.swing.JTextField();
            jLabel7 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);

            jPanelMostrarEstudios.setBackground(new java.awt.Color(153, 204, 255));

            jTableMostrar.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "DNI paciente", "Matricula profesional", "Fecha de realizacion", "Fecha de entrega", "Estado", "Analisis"
                  }
            ) {
                  Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                  };
                  boolean[] canEdit = new boolean [] {
                        false, false, false, true, true, false
                  };

                  public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                  }

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            jScrollPane2.setViewportView(jTableMostrar);

            javax.swing.GroupLayout jPanelMostrarEstudiosLayout = new javax.swing.GroupLayout(jPanelMostrarEstudios);
            jPanelMostrarEstudios.setLayout(jPanelMostrarEstudiosLayout);
            jPanelMostrarEstudiosLayout.setHorizontalGroup(
                  jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            jPanelMostrarEstudiosLayout.setVerticalGroup(
                  jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMostrarEstudiosLayout.createSequentialGroup()
                        .addContainerGap(224, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
            );

            jPanelBuscarEstudioEstado.setBackground(new java.awt.Color(153, 204, 255));

            btnBuscarEstEsta.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarEstEsta.setForeground(new java.awt.Color(255, 255, 255));
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

            estadoInput.setBackground(new java.awt.Color(51, 51, 51));
            estadoInput.setForeground(new java.awt.Color(255, 255, 255));
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

            btnBuscarEstFec.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarEstFec.setForeground(new java.awt.Color(255, 255, 255));
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

            fechaRealInput.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
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
                        .addContainerGap(388, Short.MAX_VALUE))
            );

            jPanelBuscarEstudioPro.setBackground(new java.awt.Color(153, 204, 255));

            btnBuscarEstPro.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarEstPro.setForeground(new java.awt.Color(255, 255, 255));
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

            matProEstInput.setBackground(new java.awt.Color(51, 51, 51));
            matProEstInput.setForeground(new java.awt.Color(255, 255, 255));
            matProEstInput.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matProEstInputActionPerformed(evt);
                  }
            });
            matProEstInput.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        matProEstInputKeyTyped(evt);
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
                        .addContainerGap(404, Short.MAX_VALUE))
            );

            jPanelModificarEst.setBackground(new java.awt.Color(153, 204, 255));

            jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(0, 0, 0));
            jLabel6.setText("Modificacion de estudios");

            dniPactxt.setBackground(new java.awt.Color(0, 51, 102));
            dniPactxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPactxtActionPerformed(evt);
                  }
            });

            jLabel7.setForeground(new java.awt.Color(51, 51, 51));
            jLabel7.setText("DNI del paciente");

            jButton1.setText("Buscar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelModificarEstLayout = new javax.swing.GroupLayout(jPanelModificarEst);
            jPanelModificarEst.setLayout(jPanelModificarEstLayout);
            jPanelModificarEstLayout.setHorizontalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dniPactxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                  .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addComponent(jLabel6))
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGap(139, 139, 139)
                                    .addComponent(jButton1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanelModificarEstLayout.setVerticalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(dniPactxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(256, Short.MAX_VALUE))
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
                              .addContainerGap(954, Short.MAX_VALUE)))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                              .addGap(20, 20, 20)
                              .addComponent(jPanelBuscarEstudioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addContainerGap(900, Short.MAX_VALUE)))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                              .addGap(0, 0, Short.MAX_VALUE)
                              .addComponent(jPanelModificarEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(0, 0, Short.MAX_VALUE)))
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
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                              .addGap(0, 0, Short.MAX_VALUE)
                              .addComponent(jPanelModificarEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(0, 0, Short.MAX_VALUE)))
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
            JOptionPane.showMessageDialog(this, "Ingrese una matrícula.");
        }
    }//GEN-LAST:event_btnBuscarEstProActionPerformed

    private void matProEstInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProEstInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProEstInputActionPerformed

      private void matProEstInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matProEstInputKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matProEstInputKeyTyped

    private void dniPactxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPactxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPactxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dni = dniPactxt.getText().trim();
        if (!dni.isEmpty()){
            Fecha fechaR = new Fecha(0, 0, 0);
            mostrarEstudios(accionActual, dni, fechaR);
        }else {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed



      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnBuscarEstEsta;
      private javax.swing.JButton btnBuscarEstFec;
      private javax.swing.JButton btnBuscarEstPro;
      private javax.swing.JTextField dniPactxt;
      private javax.swing.JComboBox<String> estadoInput;
      private javax.swing.JSpinner fechaRealInput;
      private javax.swing.JButton jButton1;
      private javax.swing.JLabel jLabel10;
      private javax.swing.JLabel jLabel12;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private javax.swing.JPanel jPanelBuscarEstudioEstado;
      private javax.swing.JPanel jPanelBuscarEstudioFechaRec;
      private javax.swing.JPanel jPanelBuscarEstudioPro;
      private javax.swing.JPanel jPanelModificarEst;
      private javax.swing.JPanel jPanelMostrarEstudios;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JTable jTableMostrar;
      private javax.swing.JTextField matProEstInput;
      // End of variables declaration//GEN-END:variables
}
