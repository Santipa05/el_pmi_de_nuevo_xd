package View;

import Controller.EstudioController;
import Model.Estudio;
import Model.Fecha;
import Model.Persona;
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
    FondoPanel fondo = new FondoPanel();
    
      public FormularioEstudio() {
            this.setContentPane(fondo);
            initComponents();
            jPanelBusquedas.setOpaque(false);
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
        ocultarTodosLosBusqueda();
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
            jPanel2.setVisible(true);
            switch (accionActual) {
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
        jPanelModificarEst.setVisible(false);
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
        
        switch(accionActual){
            case "Mostrar todos":
                for (Estudio est : listaEstudios) {
                    EstudioController miEst = new EstudioController(est);
                    cargarEstudioATabla(miEst.obtenerEstudio());
                }break;
                
            case "Mostrar por profesional":
                break;
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
    }
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMostrar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        verConObSoc = new javax.swing.JRadioButton();
        estadoInput = new javax.swing.JComboBox<>();
        fechaRealInput = new javax.swing.JSpinner();
        matProEstInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        verConObSoc1 = new javax.swing.JRadioButton();
        btnBuscarEstEsta = new javax.swing.JButton();
        btnBuscarEstFec = new javax.swing.JButton();
        btnBuscarEstPro = new javax.swing.JButton();
        jPanelBusquedas = new javax.swing.JPanel();
        jPanelModificarEst = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        subtitulo = new javax.swing.JLabel();
        buscarModEst = new javax.swing.JButton();
        campoDniPac = new javax.swing.JTextField();
        ENCONTRO = new javax.swing.JLabel();
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
        btnCancelar4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

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
        jTableMostrar.setOpaque(false);
        jTableMostrar.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jTableMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMostrarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMostrar);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verConObSoc.setBackground(new java.awt.Color(255, 255, 255));
        verConObSoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verConObSoc.setForeground(new java.awt.Color(255, 255, 255));
        verConObSoc.setText("Mostrar todos");
        verConObSoc.setContentAreaFilled(false);
        verConObSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verConObSocActionPerformed(evt);
            }
        });
        jPanel2.add(verConObSoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        estadoInput.setBackground(new java.awt.Color(51, 51, 51));
        estadoInput.setForeground(new java.awt.Color(255, 255, 255));
        estadoInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
        estadoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoInputActionPerformed(evt);
            }
        });
        jPanel2.add(estadoInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        fechaRealInput.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        fechaRealInput.setEditor(new javax.swing.JSpinner.DateEditor(fechaRealInput, "dd/MM/yyyy"));
        fechaRealInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fechaRealInputStateChanged(evt);
            }
        });
        jPanel2.add(fechaRealInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

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
        jPanel2.add(matProEstInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Matricula");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha de realizacion");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 70));

        verConObSoc1.setBackground(new java.awt.Color(255, 255, 255));
        verConObSoc1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verConObSoc1.setForeground(new java.awt.Color(255, 255, 255));
        verConObSoc1.setText("Ver con obra social");
        verConObSoc1.setContentAreaFilled(false);
        verConObSoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verConObSoc1ActionPerformed(evt);
            }
        });
        jPanel2.add(verConObSoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        btnBuscarEstEsta.setBackground(new java.awt.Color(0, 51, 102));
        btnBuscarEstEsta.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarEstEsta.setText("Buscar");
        btnBuscarEstEsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstEstaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarEstEsta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        btnBuscarEstFec.setBackground(new java.awt.Color(0, 51, 102));
        btnBuscarEstFec.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarEstFec.setText("Buscar");
        btnBuscarEstFec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstFecActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarEstFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        btnBuscarEstPro.setBackground(new java.awt.Color(0, 51, 102));
        btnBuscarEstPro.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarEstPro.setText("Buscar");
        btnBuscarEstPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstProActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarEstPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanelBusquedas.setBackground(new java.awt.Color(153, 204, 255));
        jPanelBusquedas.setOpaque(false);
        jPanelBusquedas.setPreferredSize(new java.awt.Dimension(790, 427));
        jPanelBusquedas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelModificarEst.setBackground(new java.awt.Color(153, 204, 255));
        jPanelModificarEst.setMaximumSize(new java.awt.Dimension(562, 478));
        jPanelModificarEst.setMinimumSize(new java.awt.Dimension(562, 478));
        jPanelModificarEst.setOpaque(false);
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

        ENCONTRO.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ENCONTRO.setForeground(new java.awt.Color(102, 102, 102));
        ENCONTRO.setText("SELECCIONE EN LA TABLA EL ESTUDIO QUE DESEA MODIFICAR");
        ENCONTRO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        btnCancelar4.setBackground(new java.awt.Color(0, 51, 102));
        btnCancelar4.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar4.setText("Volver");
        btnCancelar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModificarEstLayout = new javax.swing.GroupLayout(jPanelModificarEst);
        jPanelModificarEst.setLayout(jPanelModificarEstLayout);
        jPanelModificarEstLayout.setHorizontalGroup(
            jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnCancelarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(1065, 1065, 1065)
                        .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModificarEstLayout.createSequentialGroup()
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
                                    .addComponent(dniPacTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matriculaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaReTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(estadoEst, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fechaEntEst, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                                .addComponent(subtitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ENCONTRO)
                            .addComponent(titulo)
                            .addComponent(buscarModEst, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCancelar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirmarEstMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelModificarEstLayout.setVerticalGroup(
            jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(titulo)
                .addGap(55, 55, 55)
                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarModEst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ENCONTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelModificarEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(separador))
                    .addGroup(jPanelModificarEstLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
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
                            .addComponent(fechaEntEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmarEstMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar4)
                .addGap(606, 606, 606)
                .addComponent(btnCancelarPacMod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBusquedas.add(jPanelModificarEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelBusquedas, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEstEstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstEstaActionPerformed
        String estadoSelec = estadoInput.getItemAt(estadoInput.getSelectedIndex());
        Fecha fechaR = new Fecha(0, 0, 0);
        mostrarEstudios(accionActual, estadoSelec, fechaR);
        if (jTableMostrar.getRowCount() > 0) {
    }
    }//GEN-LAST:event_btnBuscarEstEstaActionPerformed

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

    private void btnBuscarEstFecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstFecActionPerformed
     
    }//GEN-LAST:event_btnBuscarEstFecActionPerformed

    private void btnBuscarEstProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstProActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        modelo.setRowCount(0);
        String matricula = matProEstInput.getText().trim();
        if (!matricula.isEmpty()){
            for (Estudio est : listaEstudios) {
                EstudioController miEst = new EstudioController(est);
                if (miEst.muestraMatriculaProfesional().trim().equals(matricula.trim())){
                    cargarEstudioATabla(miEst.obtenerEstudio());
                }
            }
        }else{
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
            if (jTableMostrar.getRowCount() > 0) {
        }
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
            }
        }
      }
    }
    }//GEN-LAST:event_jTableMostrarMouseClicked

    private void btnCancelar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar4ActionPerformed

    private void verConObSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verConObSocActionPerformed
        
    }//GEN-LAST:event_verConObSocActionPerformed

    private void verConObSoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verConObSoc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verConObSoc1ActionPerformed

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

    
    public class RenderAnalisis extends JTextArea implements TableCellRenderer {
        
    public RenderAnalisis() {
        setLineWrap(true);
        setWrapStyleWord(true);
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
    private javax.swing.JLabel ENCONTRO;
    private javax.swing.JLabel apellidoSig;
    private javax.swing.JButton btnBuscarEstEsta;
    private javax.swing.JButton btnBuscarEstFec;
    private javax.swing.JButton btnBuscarEstPro;
    private javax.swing.JButton btnCancelar4;
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBusquedas;
    private javax.swing.JPanel jPanelModificarEst;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableMostrar;
    private javax.swing.JTextField matProEstInput;
    private javax.swing.JLabel matriculaTXT;
    private javax.swing.JLabel nombreSig;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel subtitulo;
    private javax.swing.JLabel telefonoSig;
    private javax.swing.JLabel titulo;
    private javax.swing.JRadioButton verConObSoc;
    private javax.swing.JRadioButton verConObSoc1;
    // End of variables declaration//GEN-END:variables
}
