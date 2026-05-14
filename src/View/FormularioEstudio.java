package View;

import Controller.EstudioController;
import Controller.PacienteController;
import Model.Estudio;
import Model.Fecha;
import Model.Paciente;
import Model.Persona;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class FormularioEstudio extends javax.swing.JFrame {
    
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private Estudio estudioSelec;
    FondoPanel fondo = new FondoPanel();
    
      public FormularioEstudio() {
            this.setContentPane(fondo);
            initComponents();
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/unnamed.png")).getImage());
            jTableMostrar.setFillsViewportHeight(true);
            jScrollPane2.setBorder(null);
            jScrollPane2.setViewportBorder(null);
            jScrollPane2.setOpaque(false);
            jScrollPane2.getViewport().setOpaque(false);
            jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            this.pack();
            setLocationRelativeTo(null);
      }
      
      public FormularioEstudio(HashMap<String, Persona> mapaPersonas, String operacion, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.accionActual = operacion; 
        this.listaEstudios = listaEstudios;
        this.pack();
        setLocationRelativeTo(null);
        muestraOnoCamposModEst(false);
        metAux(accionActual);
        jTableMostrar.getColumnModel().getColumn(5).setCellRenderer(new RenderAnalisis());
        jTableMostrar.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableMostrar.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableMostrar.getColumnModel().getColumn(0).setPreferredWidth(80); // DNI
        jTableMostrar.getColumnModel().getColumn(1).setPreferredWidth(80); // Matrícula
        
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
            jPanelMostrarBuscar.setVisible(true);
            jPanelModificarEst.setVisible(false);
            switch (accionActual) {
                case "Modificar":
                    muestraOnoCamposModEst(false);
                    jTableMostrar.setVisible(true);
                    comboboxOpcion.setVisible(false);
                    comboboxOpcion.setEnabled(false);
                    ocultarMostrarBuscar();
                    tituloMostrar.setVisible(true);
                    dniModTxt.setVisible(true);
                    campoDniEst.setVisible(true);
                    campoDniEst.setEnabled(true);
                    buscarModEst1.setVisible(true);
                    buscarModEst1.setEnabled(true);
                    jPanelModificarEst.setVisible(true);
                    break;
                case "Mostrar/Buscar":
                    ocultarModEst();
                    ocultarMostrarBuscar();
                    jPanelMostrarBuscar.setVisible(true);
                    jScrollPane2.setVisible(true);
                    jTableMostrar.setVisible(true);
                    jPanelModificarEst.setVisible(false);
            }
            this.revalidate();
            this.repaint();
            this.pack();
            }
        }
      
      private void ocultarMostrarBuscar() {
            tituloModificar.setVisible(false);
            btnCancelarMod.setVisible(false);
            btnCancelarMod.setEnabled(false);
        tituloMostrar.setVisible(false);
        fechaRealtxt.setVisible(false);
        estadotxt.setVisible(false);
        estadoInput.setVisible(false);
        estadoInput.setEnabled(false);
        dniModTxt.setVisible(false);
        fechaRealInput.setVisible(false);
        fechaRealInput.setEnabled(false);
        matriculatxt.setVisible(false);
        campoDniEst.setVisible(false);
        campoDniEst.setEnabled(false);
        matProEstInput.setVisible(false);
        matProEstInput.setEnabled(false);
        buscarModEst1.setVisible(false);
        buscarModEst1.setEnabled(false);
        btnBuscarEstPro.setVisible(false);
        btnBuscarEstPro.setEnabled(false);
        ENCONTRO.setVisible(false);
    }
      
    private void ocultarModEst(){
        campoDniEst.setVisible(false);
        tituloMostrar.setVisible(false);
        dniModTxt.setVisible(false);
        buscarModEst1.setVisible(false);
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
    
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanelMostrarBuscar = new javax.swing.JPanel();
            estadoInput = new javax.swing.JComboBox<>();
            fechaRealInput = new javax.swing.JSpinner();
            matProEstInput = new javax.swing.JTextField();
            estadotxt = new javax.swing.JLabel();
            matriculatxt = new javax.swing.JLabel();
            fechaRealtxt = new javax.swing.JLabel();
            jSeparator1 = new javax.swing.JSeparator();
            btnBuscarEstPro = new javax.swing.JButton();
            campoDniEst = new javax.swing.JTextField();
            dniModTxt = new javax.swing.JLabel();
            tituloMostrar = new javax.swing.JLabel();
            buscarModEst1 = new javax.swing.JButton();
            ENCONTRO = new javax.swing.JLabel();
            btnVolver = new javax.swing.JButton();
            comboboxOpcion = new javax.swing.JComboBox<>();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTableMostrar = new javax.swing.JTable();
            jPanelModificarEst = new javax.swing.JPanel();
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
            estadoEst = new javax.swing.JComboBox<>();
            fechaEntEst = new javax.swing.JSpinner();
            btnCancelarMod = new javax.swing.JButton();
            tituloModificar = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setBackground(new java.awt.Color(153, 204, 255));
            setMaximumSize(new java.awt.Dimension(940, 1324));
            setResizable(false);
            getContentPane().setLayout(new java.awt.CardLayout());

            jPanelMostrarBuscar.setMaximumSize(new java.awt.Dimension(940, 834));
            jPanelMostrarBuscar.setOpaque(false);

            estadoInput.setBackground(new java.awt.Color(51, 51, 51));
            estadoInput.setForeground(new java.awt.Color(255, 255, 255));
            estadoInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
            estadoInput.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoInputActionPerformed(evt);
                  }
            });

            fechaRealInput.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
            fechaRealInput.setEditor(new javax.swing.JSpinner.DateEditor(fechaRealInput, "dd/MM/yyyy"));
            fechaRealInput.addChangeListener(new javax.swing.event.ChangeListener() {
                  public void stateChanged(javax.swing.event.ChangeEvent evt) {
                        fechaRealInputStateChanged(evt);
                  }
            });

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

            estadotxt.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            estadotxt.setForeground(new java.awt.Color(255, 255, 255));
            estadotxt.setText("Estado");

            matriculatxt.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            matriculatxt.setForeground(new java.awt.Color(255, 255, 255));
            matriculatxt.setText("Matricula");

            fechaRealtxt.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            fechaRealtxt.setForeground(new java.awt.Color(255, 255, 255));
            fechaRealtxt.setText("Fecha de realizacion");

            btnBuscarEstPro.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarEstPro.setForeground(new java.awt.Color(255, 255, 255));
            btnBuscarEstPro.setText("Buscar");
            btnBuscarEstPro.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBuscarEstProActionPerformed(evt);
                  }
            });

            campoDniEst.setBackground(new java.awt.Color(51, 51, 51));
            campoDniEst.setForeground(new java.awt.Color(255, 255, 255));
            campoDniEst.setToolTipText("Ingrese el DNI");
            campoDniEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        campoDniEstActionPerformed(evt);
                  }
            });
            campoDniEst.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        campoDniEstKeyTyped(evt);
                  }
            });

            dniModTxt.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
            dniModTxt.setForeground(new java.awt.Color(153, 153, 153));
            dniModTxt.setText("DNI del paciente");

            tituloMostrar.setBackground(new java.awt.Color(255, 255, 255));
            tituloMostrar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            tituloMostrar.setForeground(new java.awt.Color(255, 255, 255));
            tituloMostrar.setText("Modificacion de estudio");

            buscarModEst1.setBackground(new java.awt.Color(0, 51, 102));
            buscarModEst1.setForeground(new java.awt.Color(255, 255, 255));
            buscarModEst1.setText("Buscar");
            buscarModEst1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buscarModEst1ActionPerformed(evt);
                  }
            });

            ENCONTRO.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N
            ENCONTRO.setForeground(new java.awt.Color(153, 153, 153));
            ENCONTRO.setText("SELECCIONE EN LA TABLA EL ESTUDIO QUE DESEA MODIFICAR");
            ENCONTRO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            btnVolver.setBackground(new java.awt.Color(0, 51, 102));
            btnVolver.setForeground(new java.awt.Color(255, 255, 255));
            btnVolver.setText("Volver");
            btnVolver.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnVolverActionPerformed(evt);
                  }
            });

            comboboxOpcion.setBackground(new java.awt.Color(0, 102, 153));
            comboboxOpcion.setForeground(new java.awt.Color(255, 255, 255));
            comboboxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver todos", "Ver por estado", "Ver por fecha de realizacion", "Ver por matricula" }));
            comboboxOpcion.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        comboboxOpcionActionPerformed(evt);
                  }
            });

            jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            jTableMostrar.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                  },
                  new String [] {
                        "DNI paciente", "Matricula profesional", "Fecha de realizacion", "Fecha de entrega", "Estado", "Analisis"
                  }
            ) {
                  Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
            jTableMostrar.setFillsViewportHeight(true);
            jTableMostrar.setOpaque(false);
            jTableMostrar.setSelectionBackground(new java.awt.Color(0, 255, 153));
            jTableMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jTableMostrarMouseClicked(evt);
                  }
            });
            jScrollPane2.setViewportView(jTableMostrar);

            javax.swing.GroupLayout jPanelMostrarBuscarLayout = new javax.swing.GroupLayout(jPanelMostrarBuscar);
            jPanelMostrarBuscar.setLayout(jPanelMostrarBuscarLayout);
            jPanelMostrarBuscarLayout.setHorizontalGroup(
                  jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                        .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboboxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addGap(174, 174, 174)
                                    .addComponent(dniModTxt)
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                                .addComponent(btnBuscarEstPro, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buscarModEst1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                                .addComponent(estadotxt)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(matriculatxt)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fechaRealtxt)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tituloMostrar))
                                          .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                                .addComponent(campoDniEst, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fechaRealInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(matProEstInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addGap(189, 189, 189)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(ENCONTRO))
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addGap(316, 316, 316)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(87, Short.MAX_VALUE))
            );
            jPanelMostrarBuscarLayout.setVerticalGroup(
                  jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboboxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(fechaRealtxt)
                                          .addComponent(estadotxt)
                                          .addComponent(matriculatxt)
                                          .addComponent(tituloMostrar))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(campoDniEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(fechaRealInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(matProEstInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(dniModTxt))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelMostrarBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(btnBuscarEstPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(buscarModEst1))
                                    .addGap(12, 12, 12)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelMostrarBuscarLayout.createSequentialGroup()
                                    .addGap(125, 125, 125)
                                    .addComponent(ENCONTRO)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver)
                        .addGap(75, 75, 75))
            );

            getContentPane().add(jPanelMostrarBuscar, "card2");

            jPanelModificarEst.setMaximumSize(new java.awt.Dimension(570, 490));
            jPanelModificarEst.setMinimumSize(new java.awt.Dimension(570, 490));
            jPanelModificarEst.setOpaque(false);
            jPanelModificarEst.setPreferredSize(new java.awt.Dimension(570, 490));

            nombreSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            nombreSig.setForeground(new java.awt.Color(153, 153, 153));
            nombreSig.setText("DNI paciente");

            dniPacTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
            dniPacTXT.setForeground(new java.awt.Color(255, 255, 255));
            dniPacTXT.setText("default");

            apellidoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            apellidoSig.setForeground(new java.awt.Color(153, 153, 153));
            apellidoSig.setText("Matricula profesional");

            matriculaTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
            matriculaTXT.setForeground(new java.awt.Color(255, 255, 255));
            matriculaTXT.setText("default");

            dniSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            dniSig.setForeground(new java.awt.Color(153, 153, 153));
            dniSig.setText("Fecha de realizacion");

            fechaReTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
            fechaReTXT.setForeground(new java.awt.Color(255, 255, 255));
            fechaReTXT.setText("default");

            telefonoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            telefonoSig.setForeground(new java.awt.Color(153, 153, 153));
            telefonoSig.setText("Estado");

            emailSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            emailSig.setForeground(new java.awt.Color(153, 153, 153));
            emailSig.setText("Fecha de entrega");

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

            estadoEst.setBackground(new java.awt.Color(51, 51, 51));
            estadoEst.setForeground(new java.awt.Color(255, 255, 255));
            estadoEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
            estadoEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoEstActionPerformed(evt);
                  }
            });

            fechaEntEst.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH));
            fechaEntEst.setEditor(new javax.swing.JSpinner.DateEditor(fechaEntEst, "dd/MM/yyyy"));

            btnCancelarMod.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelarMod.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelarMod.setText("Cancelar");
            btnCancelarMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelarModActionPerformed(evt);
                  }
            });

            tituloModificar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            tituloModificar.setForeground(new java.awt.Color(255, 255, 255));
            tituloModificar.setText("Modificacion del estudio");

            javax.swing.GroupLayout jPanelModificarEstLayout = new javax.swing.GroupLayout(jPanelModificarEst);
            jPanelModificarEst.setLayout(jPanelModificarEstLayout);
            jPanelModificarEstLayout.setHorizontalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarEstLayout.createSequentialGroup()
                                          .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dniSig)
                                                .addComponent(emailSig)
                                                .addComponent(telefonoSig)
                                                .addComponent(apellidoSig)
                                                .addComponent(nombreSig))
                                          .addGap(25, 25, 25)
                                          .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                      .addComponent(estadoEst, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                      .addComponent(fechaEntEst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(fechaReTXT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                      .addComponent(dniPacTXT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                      .addComponent(matriculaTXT, javax.swing.GroupLayout.Alignment.LEADING))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarEstLayout.createSequentialGroup()
                                          .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCancelarMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnConfirmarEstMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGap(79, 79, 79)))
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(tituloModificar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanelModificarEstLayout.setVerticalGroup(
                  jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tituloModificar)
                        .addGap(58, 58, 58)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombreSig)
                                          .addComponent(dniPacTXT))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidoSig)
                                          .addComponent(matriculaTXT))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(fechaReTXT)
                                          .addComponent(dniSig))
                                    .addGap(14, 14, 14)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(estadoEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(telefonoSig))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(emailSig)
                                          .addComponent(fechaEntEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmarEstMod)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarMod)
                        .addGap(147, 147, 147))
            );

            getContentPane().add(jPanelModificarEst, "card3");

            pack();
      }// </editor-fold>//GEN-END:initComponents

    private void estadoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoInputActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        String estadoSelec = estadoInput.getSelectedItem().toString();
        for (Estudio est : listaEstudios) {
            EstudioController miEst = new EstudioController(est);
            if (miEst.muestraEstado().equals(estadoSelec)){
                cargarEstudioATabla(miEst.obtenerEstudio());
            }
        }
    }//GEN-LAST:event_estadoInputActionPerformed

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

    private void muestraDatosModEst(EstudioController miEst) {
        muestraOnoCamposModEst(true);
        dniPacTXT.setText(miEst.muestraDniPaciente());
        matriculaTXT.setText(miEst.muestraMatriculaProfesional());
        fechaReTXT.setText(miEst.muestraStringFechaRealizacion());
    }
    
    private void muestraOnoCamposModEst(boolean siOno){
        if (siOno){
            separador.setVisible(true);
            ENCONTRO.setVisible(false);
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
            separador.setVisible(false);
            ENCONTRO.setVisible(false);
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

    private void estadoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoEstActionPerformed

    private void btnCancelarModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarModActionPerformed

    private void fechaRealInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fechaRealInputStateChanged
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        java.util.Date dateRealizacion = (java.util.Date) fechaRealInput.getValue();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dateRealizacion);
        int diaR = cal.get(java.util.Calendar.DAY_OF_MONTH);
        int mesR = cal.get(java.util.Calendar.MONTH) + 1;
        int anioR = cal.get(java.util.Calendar.YEAR);
        Fecha fechaR = new Fecha(diaR, mesR, anioR);
        for (Estudio est : listaEstudios) {
            EstudioController miEst = new EstudioController(est);
            if (miEst.esMismaFecha(fechaR)){
                cargarEstudioATabla(miEst.obtenerEstudio());
            }
        }
    }//GEN-LAST:event_fechaRealInputStateChanged

    private void btnBuscarEstProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstProActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        String matricula = matProEstInput.getText().trim();
        boolean noMat = false;
        boolean encontro = false;
        if (!matricula.isEmpty()){
            for (Estudio est : listaEstudios) {
                EstudioController miEst = new EstudioController(est);
                if (miEst.muestraMatriculaProfesional().trim().equals(matricula.trim())){
                    cargarEstudioATabla(miEst.obtenerEstudio());
                    encontro = true;
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una matrícula.");
            noMat = true;
        }
        if (encontro == false && noMat==false){
            JOptionPane.showMessageDialog(this, "No se encontro estudio con matricula -" + matricula + "-");
        }
    }//GEN-LAST:event_btnBuscarEstProActionPerformed

    private void campoDniEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDniEstActionPerformed

    private void campoDniEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDniEstKeyTyped
        char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
            int limite = 8;
            if(campoDniEst.getText().length() >= limite){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
    }//GEN-LAST:event_campoDniEstKeyTyped

    private void buscarModEst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarModEst1ActionPerformed
        String dniBusqueda = campoDniEst.getText().trim();
        
        if (dniBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI. El campo no puede estar vacío.");
            return;
        }

        boolean existePaciente = false;
        for (Persona p : mapaPersonas.values()) {
            if (p instanceof Paciente pac){
                PacienteController miPac = new PacienteController(pac);
                if (miPac.muestraDni().trim().equals(dniBusqueda)) {
                existePaciente = true;
                break;
                } 
            }
        }

    if (!existePaciente) {
        JOptionPane.showMessageDialog(this, "El paciente con DNI " + dniBusqueda + " no está registrado en el sistema.");
        muestraOnoCamposModEst(false);
        return;
    }
        
        boolean encontro = false;
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        for (Estudio est : listaEstudios) {
            EstudioController miEst = new EstudioController(est);
            if (miEst.muestraDniPaciente().trim().equals(dniBusqueda)){
                cargarEstudioATabla(miEst.obtenerEstudio());
                encontro = true;
            }
        }
        if (encontro == true){
            ENCONTRO.setVisible(true);
        }else{
            muestraOnoCamposModEst(false);
            JOptionPane.showMessageDialog(this, "El paciente ingresado no posee estudios.");
        }
    }//GEN-LAST:event_buscarModEst1ActionPerformed

      private void comboboxOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxOpcionActionPerformed
            int op = comboboxOpcion.getSelectedIndex();
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
            btnVolver.setVisible(true);
            btnVolver.setEnabled(true);
            switch(op){
                  case 0:
                        modelo.setRowCount(0);
                        ocultarMostrarBuscar();
                        for (Estudio est : listaEstudios) {
                              EstudioController miEst = new EstudioController(est);
                              cargarEstudioATabla(miEst.obtenerEstudio());
                              }
                        break;
                  case 1:
                        modelo.setRowCount(0);
                        ocultarMostrarBuscar();
                        estadotxt.setVisible(true);
                        estadoInput.setVisible(true);
                        estadoInput.setEnabled(true);
                        break;
                  case 2:
                        modelo.setRowCount(0);
                        ocultarMostrarBuscar();
                        fechaRealtxt.setVisible(true);
                        fechaRealInput.setVisible(true);
                        fechaRealInput.setEnabled(true);
                        break;
                  case 3:
                        modelo.setRowCount(0);
                        ocultarMostrarBuscar();
                        matriculatxt.setVisible(true);
                        matProEstInput.setVisible(true);
                        matProEstInput.setEnabled(true);
                        btnBuscarEstPro.setVisible(true);
                        btnBuscarEstPro.setEnabled(true);
                        
            }
      }//GEN-LAST:event_comboboxOpcionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

      private void jTableMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMostrarMouseClicked
            if (accionActual.equals("Modificar")) {
                  int fila = jTableMostrar.getSelectedRow();
                  if (fila != -1) {
                        String dniTab = jTableMostrar.getValueAt(fila, 0).toString();
                        String matTab = jTableMostrar.getValueAt(fila, 1).toString();
                        Fecha fechaRealTab = (Fecha) jTableMostrar.getValueAt(fila, 2);
                        String anaTab = jTableMostrar.getValueAt(fila, 5).toString();
                        for (Estudio e : listaEstudios) {
                              EstudioController miEst = new EstudioController(e);
                              if (miEst.esMismaFecha(fechaRealTab) &&
                                    miEst.muestraDniPaciente().equals(dniTab) &&
                                    miEst.muestraMatriculaProfesional().equals(matTab) &&
                                    miEst.muestraAnalisisRealizados().equals(anaTab)) {
                                    this.estudioSelec = miEst.obtenerEstudio();
                                    muestraDatosModEst(miEst);
                                    jPanelModificarEst.setVisible(true);
                                    jTableMostrar.setVisible(false);
                                    ocultarModEst();
                                    ocultarMostrarBuscar();
                                    jPanelMostrarBuscar.setVisible(false);
                                    jPanelMostrarBuscar.setEnabled(false);
                                    tituloModificar.setVisible(true);
                                    btnCancelarMod.setVisible(true);
                                    btnCancelarMod.setEnabled(true);
                        }
                  }
            }
      }
      }//GEN-LAST:event_jTableMostrarMouseClicked

    
    public class RenderAnalisis extends JTextArea implements TableCellRenderer {
        
    public RenderAnalisis() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
        return this;
    }
}

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel ENCONTRO;
      private javax.swing.JLabel apellidoSig;
      private javax.swing.JButton btnBuscarEstPro;
      private javax.swing.JButton btnCancelarMod;
      private javax.swing.JButton btnConfirmarEstMod;
      private javax.swing.JButton btnVolver;
      private javax.swing.JButton buscarModEst1;
      private javax.swing.JTextField campoDniEst;
      private javax.swing.JComboBox<String> comboboxOpcion;
      private javax.swing.JLabel dniModTxt;
      private javax.swing.JLabel dniPacTXT;
      private javax.swing.JLabel dniSig;
      private javax.swing.JLabel emailSig;
      private javax.swing.JComboBox<String> estadoEst;
      private javax.swing.JComboBox<String> estadoInput;
      private javax.swing.JLabel estadotxt;
      private javax.swing.JSpinner fechaEntEst;
      private javax.swing.JLabel fechaReTXT;
      private javax.swing.JSpinner fechaRealInput;
      private javax.swing.JLabel fechaRealtxt;
      private javax.swing.JPanel jPanelModificarEst;
      private javax.swing.JPanel jPanelMostrarBuscar;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JSeparator jSeparator1;
      private javax.swing.JTable jTableMostrar;
      private javax.swing.JTextField matProEstInput;
      private javax.swing.JLabel matriculaTXT;
      private javax.swing.JLabel matriculatxt;
      private javax.swing.JLabel nombreSig;
      private javax.swing.JSeparator separador;
      private javax.swing.JLabel telefonoSig;
      private javax.swing.JLabel tituloModificar;
      private javax.swing.JLabel tituloMostrar;
      // End of variables declaration//GEN-END:variables
}
