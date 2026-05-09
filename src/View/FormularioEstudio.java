package View;

import Controller.EstudioController;
import Controller.PacienteController;
import Controller.ProfesionalController;
import Model.Estudio;
import Model.Fecha;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author santi
 */
public class FormularioEstudio extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private Estudio estudioSelec;

      public FormularioEstudio() {
            initComponents();
            this.pack();
            jSplitPane1.setDividerLocation(484);
            setLocationRelativeTo(null);
      }
      
      public FormularioEstudio(HashMap<String, Persona> mapaPersonas, String operacion, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.accionActual = operacion; 
        this.listaEstudios = listaEstudios;
        this.pack();
        jSplitPane1.setDividerLocation(484);
        setLocationRelativeTo(null);
        ocultarTodosLosBusqueda();
        // Aplicar a la columna 5 (Análisis)
        jTableMostrar.getColumnModel().getColumn(5).setCellRenderer(new RenderAnalisis());
        muestraOnoCamposModEst(false);
        metAux(accionActual);
        // Le damos un ancho de 400 píxeles para que no corte las palabras
        jTableMostrar.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableMostrar.getColumnModel().getColumn(4).setPreferredWidth(120);
        // Opcional: Si quieres que las otras columnas sean más finitas para ganar espacio
        jTableMostrar.getColumnModel().getColumn(0).setPreferredWidth(80); // DNI
        jTableMostrar.getColumnModel().getColumn(1).setPreferredWidth(80); // Matrícula
        // Ajustamos la ventana al tamaño real de tu tabla (basado en tu imagen)
      }
      
      private void cargarEstudioATabla(Estudio est) {
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
      
      private void metAux(String accionActual) {
        if (listaEstudios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron estudios cargados.");
        } else {
            jPanelMostrarEstudios.setVisible(true);
            switch (accionActual) {
                case "Mostrar todos":
                    Fecha fechaR = new Fecha(0, 0, 0);
                    mostrarEstudios(accionActual, "", fechaR);
                    break;
                
                case "Mostrar por profesional":
                    ocultarTodosLosBusqueda();
                    jPanelBusquedas.setVisible(true);
                    jPanelBuscarEstudioPro.setVisible(true);
                    break;
                
                case "Mostrar por estado":
                    ocultarTodosLosBusqueda();
                    jPanelBusquedas.setVisible(true);
                    jPanelBuscarEstudioEstado.setVisible(true);
                    break;

                case "Mostrar por fecha de realizacion":
                    ocultarTodosLosBusqueda();
                    jPanelBusquedas.setVisible(true);
                    jPanelBuscarEstudioFechaRec.setVisible(true);
                    break;
                case "Modificar":
                    ocultarTodosLosBusqueda();
                    jPanelBusquedas.setVisible(true);
                    jPanelModificarEst.setVisible(true);
                    break;
            }
            this.revalidate();
            this.repaint();
            this.pack();
            }
        }
      
      private void ocultarTodosLosBusqueda() {
        jPanelBuscarEstudioEstado.setVisible(false);
        jPanelBuscarEstudioFechaRec.setVisible(false);
        jPanelBuscarEstudioPro.setVisible(false);
        jPanelModificarEst.setVisible(false);
        jPanelMostrarEstudios.setVisible(false);
        muestraOnoCamposModEst(false);
        estadoInput.setSelectedIndex(0);
        matProEstInput.setText("");
    }
      
      private void actualizarArchivoGeneral() {
            try(BufferedWriter escritorEst = new BufferedWriter(new FileWriter("archivos/archivoEstudios.txt"))){
            for (Estudio est : listaEstudios) {
                EstudioController miEst = new EstudioController(est);
                escritorEst.append(miEst.muestraDniPaciente() + "\n");
                escritorEst.append(miEst.muestraMatriculaProfesional() + "\n");
                escritorEst.append(miEst.muestraEstado() + "\n");
                escritorEst.append(miEst.muestraFecRealDia()+ "\n");
                escritorEst.append(miEst.muestraFecRealMes()+ "\n");
                escritorEst.append(miEst.muestraFecRealAnio()+ "\n");
                escritorEst.append(miEst.muestraFecEntDia()+ "\n");
                escritorEst.append(miEst.muestraFecEntMes()+ "\n");
                escritorEst.append(miEst.muestraFecEntAnio()+ "\n");
                boolean primero = true;
                for(int i : miEst.obetenerAnalisis()){
                    if (primero){
                        escritorEst.append(String.valueOf(i));
                        primero = false;
                    }else{
                        escritorEst.append(";" + i);
                    }
                }
                escritorEst.append("\n\n");
            }
            }catch (IOException e){
                  JOptionPane.showMessageDialog(this, "Error al abrir el archivo: " + e.getMessage());
            }
      }
      
       private void mostrarEstudios(String accionActual, String opcion, Fecha fec) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        boolean encontro = false;
        
        switch(accionActual){
            case "Mostrar todos":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    cargarEstudioATabla(miEst.obtenerEstudio());
                }break;
                
            case "Mostrar por profesional":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraMatriculaProfesional().trim().equals(opcion.trim())){
                        cargarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }break;
                
            case "Mostrar por estado":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.muestraEstado().equals(opcion)){
                        cargarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }break;
                    
            case "Mostrar por fecha de realizacion":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    if (miEst.esMismaFecha(fec)){
                        cargarEstudioATabla(miEst.obtenerEstudio());
                        encontro = true;
                    }
                }break;
        }
        
        if (modelo.getRowCount() == 0) {
            switch(accionActual){
                case "Mostrar todos":
                    JOptionPane.showMessageDialog(this, "No hay estudios cargados.");break;
                case "Mostrar por estado":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con el estado ingresada.");break;
                case "Mostrar por profesional":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con el profesional ingresada.");break;
                case "Mostrar por fecha de realizacion":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con la fecha ingresada.");break;
                case "Modificar":
                    JOptionPane.showMessageDialog(this, "No se encontro ningun estudio con el DNI ingresado.");break;
            }
            if (jPanelModificarEst != null) jPanelModificarEst.setVisible(false);
            return;
    }
    jPanelMostrarEstudios.setVisible(true);
    }
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jSplitPane1 = new javax.swing.JSplitPane();
            jPanelBusquedas = new javax.swing.JPanel();
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
            titulo = new javax.swing.JLabel();
            subtitulo = new javax.swing.JLabel();
            buscarModEst = new javax.swing.JButton();
            campoDniPac = new javax.swing.JTextField();
            noEncontro = new javax.swing.JLabel();
            nombreSig = new javax.swing.JLabel();
            dniPacTXT = new javax.swing.JLabel();
            apellidoSig = new javax.swing.JLabel();
            matriculaTXT = new javax.swing.JLabel();
            dniSig = new javax.swing.JLabel();
            fechaReTXT = new javax.swing.JLabel();
            telefonoSig = new javax.swing.JLabel();
            emailSig = new javax.swing.JLabel();
            separador = new javax.swing.JSeparator();
            btnConfirmarEstMod = new javax.swing.JButton();
            btnCancelarPacMod = new javax.swing.JButton();
            estadoEst = new javax.swing.JComboBox<>();
            fechaEntEst = new javax.swing.JSpinner();
            jPanelMostrarEstudios = new javax.swing.JPanel();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTableMostrar = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setBackground(new java.awt.Color(153, 204, 255));
            setResizable(false);

            jSplitPane1.setDividerLocation(400);
            jSplitPane1.setResizeWeight(1.0);

            jPanelBusquedas.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBusquedas.setPreferredSize(new java.awt.Dimension(790, 427));
            jPanelBusquedas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanelBuscarEstudioEstado.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBuscarEstudioEstado.setMaximumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioEstado.setMinimumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioEstado.setPreferredSize(new java.awt.Dimension(562, 478));

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
                        .addContainerGap(307, Short.MAX_VALUE))
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
                        .addContainerGap(307, Short.MAX_VALUE))
            );

            jPanelBusquedas.add(jPanelBuscarEstudioEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 6, -1, -1));

            jPanelBuscarEstudioFechaRec.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBuscarEstudioFechaRec.setMaximumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioFechaRec.setMinimumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioFechaRec.setPreferredSize(new java.awt.Dimension(562, 478));

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
                        .addContainerGap(290, Short.MAX_VALUE))
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
                        .addContainerGap(301, Short.MAX_VALUE))
            );

            jPanelBusquedas.add(jPanelBuscarEstudioFechaRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, -1));

            jPanelBuscarEstudioPro.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBuscarEstudioPro.setMaximumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioPro.setMinimumSize(new java.awt.Dimension(562, 478));
            jPanelBuscarEstudioPro.setPreferredSize(new java.awt.Dimension(562, 478));

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
                        .addContainerGap(271, Short.MAX_VALUE))
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
                        .addContainerGap(307, Short.MAX_VALUE))
            );

            jPanelBusquedas.add(jPanelBuscarEstudioPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

            jPanelModificarEst.setBackground(new java.awt.Color(153, 204, 255));
            jPanelModificarEst.setMaximumSize(new java.awt.Dimension(562, 478));
            jPanelModificarEst.setMinimumSize(new java.awt.Dimension(562, 478));
            jPanelModificarEst.setPreferredSize(new java.awt.Dimension(562, 478));

            titulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            titulo.setForeground(new java.awt.Color(0, 0, 0));
            titulo.setText("Modificacion de estudio");

            subtitulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            subtitulo.setForeground(new java.awt.Color(102, 102, 102));
            subtitulo.setText("DNI paciente");

            buscarModEst.setBackground(new java.awt.Color(0, 51, 102));
            buscarModEst.setForeground(new java.awt.Color(255, 255, 255));
            buscarModEst.setText("Buscar");
            buscarModEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buscarModEstActionPerformed(evt);
                  }
            });

            campoDniPac.setBackground(new java.awt.Color(51, 51, 51));
            campoDniPac.setForeground(new java.awt.Color(255, 255, 255));
            campoDniPac.setToolTipText("Ingrese el DNI");
            campoDniPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        campoDniPacActionPerformed(evt);
                  }
            });
            campoDniPac.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        campoDniPacKeyTyped(evt);
                  }
            });

            noEncontro.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            noEncontro.setForeground(new java.awt.Color(102, 102, 102));
            noEncontro.setText("Estudio no encontrado");
            noEncontro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            nombreSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            nombreSig.setForeground(new java.awt.Color(102, 102, 102));
            nombreSig.setText("DNI paciente");

            dniPacTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            dniPacTXT.setForeground(new java.awt.Color(0, 0, 0));
            dniPacTXT.setText("default");

            apellidoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            apellidoSig.setForeground(new java.awt.Color(102, 102, 102));
            apellidoSig.setText("Matricula profesional");

            matriculaTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            matriculaTXT.setForeground(new java.awt.Color(0, 0, 0));
            matriculaTXT.setText("default");

            dniSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            dniSig.setForeground(new java.awt.Color(102, 102, 102));
            dniSig.setText("Fecha realizacion");

            fechaReTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            fechaReTXT.setForeground(new java.awt.Color(0, 0, 0));
            fechaReTXT.setText("default");

            telefonoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            telefonoSig.setForeground(new java.awt.Color(102, 102, 102));
            telefonoSig.setText("Estado");

            emailSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            emailSig.setForeground(new java.awt.Color(102, 102, 102));
            emailSig.setText("Fecha entrega");

            separador.setBackground(new java.awt.Color(153, 204, 255));
            separador.setForeground(new java.awt.Color(102, 102, 102));
            separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnConfirmarEstMod.setBackground(new java.awt.Color(0, 51, 102));
            btnConfirmarEstMod.setForeground(new java.awt.Color(255, 255, 255));
            btnConfirmarEstMod.setText("Confirmar cambios");
            btnConfirmarEstMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnConfirmarEstModActionPerformed(evt);
                  }
            });

            btnCancelarPacMod.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelarPacMod.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelarPacMod.setText("Cancelar");
            btnCancelarPacMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelarPacModActionPerformed(evt);
                  }
            });

            estadoEst.setBackground(new java.awt.Color(51, 51, 51));
            estadoEst.setForeground(new java.awt.Color(255, 255, 255));
            estadoEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
            estadoEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoEstActionPerformed(evt);
                  }
            });

            fechaEntEst.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1777426620000L), new java.util.Date(1777426620000L), new java.util.Date(1924997820000L), java.util.Calendar.DAY_OF_MONTH));
            fechaEntEst.setEditor(new javax.swing.JSpinner.DateEditor(fechaEntEst, "dd/MM/yyyy"));

            javax.swing.GroupLayout jPanelModificarEstLayout = new javax.swing.GroupLayout(jPanelModificarEst);
            jPanelModificarEst.setLayout(jPanelModificarEstLayout);
            jPanelModificarEstLayout.setHorizontalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(subtitulo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                                            .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(dniSig)
                                                                  .addComponent(emailSig)
                                                                  .addComponent(telefonoSig)
                                                                  .addComponent(apellidoSig)
                                                                  .addComponent(nombreSig))
                                                            .addGap(25, 25, 25)
                                                            .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(dniPacTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(matriculaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(fechaReTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(estadoEst, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(fechaEntEst, javax.swing.GroupLayout.Alignment.LEADING))))
                                                      .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                                            .addGap(22, 22, 22)
                                                            .addComponent(noEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                          .addComponent(titulo)
                                          .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGap(139, 139, 139)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(btnCancelarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(btnConfirmarEstMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGap(141, 141, 141)
                                    .addComponent(buscarModEst, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
            );
            jPanelModificarEstLayout.setVerticalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(subtitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarModEst)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addComponent(noEncontro)
                                    .addGap(7, 7, 7)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombreSig)
                                          .addComponent(dniPacTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidoSig)
                                          .addComponent(matriculaTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniSig)
                                          .addComponent(fechaReTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(telefonoSig)
                                          .addComponent(estadoEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                          .addComponent(emailSig)
                                          .addComponent(fechaEntEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addComponent(separador))
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmarEstMod)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarPacMod)
                        .addContainerGap(20, Short.MAX_VALUE))
            );

            jPanelBusquedas.add(jPanelModificarEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

            jSplitPane1.setLeftComponent(jPanelBusquedas);

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
                        false, false, false, false, false, false
                  };

                  public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                  }

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            jTableMostrar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jTableMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jTableMostrarMouseClicked(evt);
                  }
            });
            jScrollPane2.setViewportView(jTableMostrar);

            javax.swing.GroupLayout jPanelMostrarEstudiosLayout = new javax.swing.GroupLayout(jPanelMostrarEstudios);
            jPanelMostrarEstudios.setLayout(jPanelMostrarEstudiosLayout);
            jPanelMostrarEstudiosLayout.setHorizontalGroup(
                  jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelMostrarEstudiosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                        .addContainerGap())
            );
            jPanelMostrarEstudiosLayout.setVerticalGroup(
                  jPanelMostrarEstudiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelMostrarEstudiosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE))
            );

            jSplitPane1.setRightComponent(jPanelMostrarEstudios);

            getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

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

      private void matProEstInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matProEstInputKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matProEstInputKeyTyped

    private void buscarModEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarModEstActionPerformed
        String dniBusqueda = campoDniPac.getText().trim();
        boolean encontro = false;
        for (Estudio est : listaEstudios) {
            EstudioController miEst = new EstudioController(est);
            if (miEst.muestraDniPaciente().trim().equals(dniBusqueda)){
                cargarEstudioATabla(miEst.obtenerEstudio());
                encontro = true;
            }
        }
        if (encontro == true){
            jPanelMostrarEstudios.setVisible(true);
        }else{
            muestraOnoCamposModEst(false);
            JOptionPane.showMessageDialog(this, "El paciente ingresado no posee estudios.");
        }
        
    }//GEN-LAST:event_buscarModEstActionPerformed

    private void muestraDatosModEst(EstudioController miEst) {
        muestraOnoCamposModEst(true);
        dniPacTXT.setText(miEst.muestraDniPaciente());
        matriculaTXT.setText(miEst.muestraMatriculaProfesional());
        fechaReTXT.setText(miEst.muestraStringFechaRealizacion());
        subtitulo.setVisible(false);
        subtitulo.setEnabled(false);
        campoDniPac.setVisible(false);
        campoDniPac.setEnabled(false);
        buscarModEst.setVisible(false);
        buscarModEst.setEnabled(false);
    }
    
    private void muestraOnoCamposModEst(boolean siOno){
        if (siOno){
            separador.setVisible(true);
            noEncontro.setVisible(false);
            nombreSig.setVisible(true);
            dniPacTXT.setVisible(true);
            apellidoSig.setVisible(true);
            matriculaTXT.setVisible(true);
            telefonoSig.setVisible(true);
            emailSig.setVisible(true);
            dniSig.setVisible(true);
            fechaReTXT.setVisible(true);
            estadoEst.setVisible(true);
            estadoEst.setEnabled(true);
            fechaEntEst.setVisible(true);
            fechaEntEst.setEnabled(true);   
            btnConfirmarEstMod.setVisible(true);
            btnConfirmarEstMod.setEnabled(true);
        }else{
            noEncontro.setVisible(false);
            nombreSig.setVisible(false);
            dniPacTXT.setVisible(false);
            apellidoSig.setVisible(false);
            matriculaTXT.setVisible(false);
            telefonoSig.setVisible(false);
            emailSig.setVisible(false);
            dniSig.setVisible(false);
            fechaReTXT.setVisible(false);
            estadoEst.setVisible(false);
            estadoEst.setEnabled(false);
            fechaEntEst.setVisible(false);
            fechaEntEst.setEnabled(false);   
            btnConfirmarEstMod.setVisible(false);
            btnConfirmarEstMod.setEnabled(false);
        }     
    }
    
    private void campoDniPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniPacActionPerformed

    }//GEN-LAST:event_campoDniPacActionPerformed

    private void campoDniPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDniPacKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_campoDniPacKeyTyped

    private void btnConfirmarEstModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEstModActionPerformed
        
       if (this.estudioSelec != null){
        java.util.Date dateEntrega = (java.util.Date) fechaEntEst.getValue();
        java.util.Calendar cal2 = java.util.Calendar.getInstance();
        cal2.setTime(dateEntrega);
        int diaE = cal2.get(java.util.Calendar.DAY_OF_MONTH);
        int mesE = cal2.get(java.util.Calendar.MONTH) + 1;
        int anioE = cal2.get(java.util.Calendar.YEAR);
        Fecha fechaE = new Fecha(diaE, mesE, anioE);
        EstudioController miEstudio = new EstudioController(estudioSelec);
        miEstudio.ColocarFechaEntrega(fechaE);
        miEstudio.ColocarEstado(estadoEst.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.");
        actualizarArchivoGeneral();
        
        jPanelModificarEst.setVisible(false);
        this.estudioSelec = null; 
        this.dispose();
       }
    }//GEN-LAST:event_btnConfirmarEstModActionPerformed

    private void btnCancelarPacModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPacModActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarPacModActionPerformed

    private void estadoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoEstActionPerformed

    private void jTableMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMostrarMouseClicked
      if (accionActual.equals("Modificar")){
          int fila = jTableMostrar.getSelectedRow();
         if (fila != -1) {
            // 1. Extraemos los datos de la fila
            String dniTab = jTableMostrar.getValueAt(fila, 0).toString();
            String matTab = jTableMostrar.getValueAt(fila, 1).toString();
            Fecha fechaRealTab = (Fecha) jTableMostrar.getValueAt(fila, 2);
            String anaTab = jTableMostrar.getValueAt(fila, 5).toString();
            // 2. Buscamos el estudio en la lista
            for (Estudio e : listaEstudios) {
            EstudioController miEst = new EstudioController(e);
            // Usamos tu función esMismaFecha del controlador
            if (miEst.esMismaFecha(fechaRealTab) && 
                miEst.muestraDniPaciente().equals(dniTab) && 
                miEst.muestraMatriculaProfesional().equals(matTab) &&
                miEst.muestraAnalisisRealizados().equals(anaTab)) {
                this.estudioSelec = miEst.obtenerEstudio();
                muestraDatosModEst(miEst);
                jPanelMostrarEstudios.setVisible(false);
                jPanelModificarEst.setVisible(true);
            }
        }
      }
    }
    }//GEN-LAST:event_jTableMostrarMouseClicked

    
    public class RenderAnalisis extends JTextArea implements TableCellRenderer {
        
    public RenderAnalisis() {
        setLineWrap(true);       // Hace que el texto salte de línea
        setWrapStyleWord(true);  // Salta de línea en espacios/puntos
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        
        //Ajusta la altura de la fila
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
        return this;
    }
}

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel apellidoSig;
      private javax.swing.JButton btnBuscarEstEsta;
      private javax.swing.JButton btnBuscarEstFec;
      private javax.swing.JButton btnBuscarEstPro;
      private javax.swing.JButton btnCancelarPacMod;
      private javax.swing.JButton btnConfirmarEstMod;
      private javax.swing.JButton buscarModEst;
      private javax.swing.JTextField campoDniPac;
      private javax.swing.JLabel dniPacTXT;
      private javax.swing.JLabel dniSig;
      private javax.swing.JLabel emailSig;
      private javax.swing.JComboBox<String> estadoEst;
      private javax.swing.JComboBox<String> estadoInput;
      private javax.swing.JSpinner fechaEntEst;
      private javax.swing.JLabel fechaReTXT;
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
      private javax.swing.JPanel jPanelBusquedas;
      private javax.swing.JPanel jPanelModificarEst;
      private javax.swing.JPanel jPanelMostrarEstudios;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JSplitPane jSplitPane1;
      private javax.swing.JTable jTableMostrar;
      private javax.swing.JTextField matProEstInput;
      private javax.swing.JLabel matriculaTXT;
      private javax.swing.JLabel noEncontro;
      private javax.swing.JLabel nombreSig;
      private javax.swing.JSeparator separador;
      private javax.swing.JLabel subtitulo;
      private javax.swing.JLabel telefonoSig;
      private javax.swing.JLabel titulo;
      // End of variables declaration//GEN-END:variables
}
