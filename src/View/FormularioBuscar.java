package View;


import Controller.PacienteController;
import Controller.PersonaController;
import Controller.ProfesionalController;
import Model.Estudio;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioBuscar extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private int op;
    FondoPanel fondo = new FondoPanel();

      public FormularioBuscar() {
          this.setContentPane(fondo);
          initComponents();
          setLocationRelativeTo(null);
          jTableMostrar.setFillsViewportHeight(true);
          Color cel = new Color(153, 204, 255);
          jScrollPane1.setBackground(cel);
          jScrollPane1.getViewport().setBackground(cel);
          jScrollPane1.setBorder(null);
          jScrollPane1.setViewportBorder(null);
          jScrollPane1.setOpaque(false);
          jScrollPane1.getViewport().setOpaque(false);
      }

    public FormularioBuscar(HashMap<String, Persona> mapaPersonas, int op, String operacion, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.accionActual = operacion; 
        this.listaEstudios = listaEstudios;
        this.op = op;
        setLocationRelativeTo(null);
        metAux(this.op);
    }
    
    
    private void metAux(int op){
            if(op == 0){
                  if ("Ver cantidad de estudios".equals(accionActual)){
                    jPanelContarEstPac.setVisible(true);
                    jPanelContarEstPac.setEnabled(true);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    jPanelMostrarTodos.setVisible(false);
                    jPanelMostrarTodos.setEnabled(false);
                    this.pack();
                  }else if ("Modificar".equals(accionActual)){
                      muestraOnoCamposModPac(false);
                      jPanelModificarPac.setVisible(true);
                      jPanelModificarPac.setEnabled(true);
                      jPanelContarEstPac.setVisible(false);
                      jPanelContarEstPac.setEnabled(false);
                      jPanelBuscarPaciente.setVisible(false);
                      jPanelBuscarPaciente.setEnabled(false);
                      jPanelBuscarProfesional.setVisible(false);
                      jPanelBuscarProfesional.setEnabled(false);
                      jPanelBuscarProfesional.setVisible(false);
                      jPanelBuscarProfesional.setEnabled(false);
                      jPanelModificarPro.setVisible(false);
                      jPanelModificarPro.setEnabled(false);
                    jPanelMostrarTodos.setVisible(false);
                    jPanelMostrarTodos.setEnabled(false);
                    this.pack();
                  }
                  else if ("Mostrar todos".equals(accionActual)){
                        jPanelMostrarTodos.setVisible(true);
                        jPanelMostrarTodos.setEnabled(true);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    this.pack();
                  } else{
                    jPanelBuscarPaciente.setVisible(true);
                    jPanelBuscarPaciente.setEnabled(true);
                    jPanelMostrarTodos.setVisible(false);
                    jPanelMostrarTodos.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    this.pack();
                  }
                  
            }else if(op == 1){
                  if ("Buscar por matricula".equals(accionActual)){
                    jPanelBuscarProfesional.setVisible(true);
                    jPanelBuscarProfesional.setEnabled(true);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    jPanelMostrarTodos.setVisible(false);
                    jPanelMostrarTodos.setEnabled(false);
                    this.pack();
                  }else if ("Modificar".equals(accionActual)){
                    muestraOnoCamposModPro(false);  
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelModificarPro.setVisible(true);
                    jPanelModificarPro.setEnabled(true);
                    jPanelMostrarTodos.setVisible(false);
                    jPanelMostrarTodos.setEnabled(false);
                    this.pack();
                  }
                  else if ("Mostrar todos".equals(accionActual)){
                    jPanelMostrarTodos.setVisible(true);
                    jPanelMostrarTodos.setEnabled(true); 
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    this.pack();
                  } else{
                    jPanelBuscarProfesional.setVisible(true);
                    jPanelBuscarProfesional.setEnabled(true);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    this.pack();
                  }
            }
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanelBuscarPaciente = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            dniPacBuscarTxt = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            btnBuscarPac = new javax.swing.JButton();
            jPanelContarEstPac = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            dniPacContarEstTxt = new javax.swing.JTextField();
            jLabel6 = new javax.swing.JLabel();
            btnContarEstPac = new javax.swing.JButton();
            jPanelBuscarProfesional = new javax.swing.JPanel();
            jLabel7 = new javax.swing.JLabel();
            matProBuscartxt1 = new javax.swing.JTextField();
            jLabel8 = new javax.swing.JLabel();
            btnBuscarMatPro = new javax.swing.JButton();
            jPanelModificarPac = new javax.swing.JPanel();
            titulo = new javax.swing.JLabel();
            subtitulo = new javax.swing.JLabel();
            buscarModPac = new javax.swing.JButton();
            campoDniPac = new javax.swing.JTextField();
            noEncontro = new javax.swing.JLabel();
            nombreSig = new javax.swing.JLabel();
            nombreTXT = new javax.swing.JLabel();
            apellidoSig = new javax.swing.JLabel();
            apellidoTXT = new javax.swing.JLabel();
            dniSig = new javax.swing.JLabel();
            dniTXT = new javax.swing.JLabel();
            telefonoSig = new javax.swing.JLabel();
            emailSig = new javax.swing.JLabel();
            obSocSig = new javax.swing.JLabel();
            campoTelMod = new javax.swing.JTextField();
            campoMailMod = new javax.swing.JTextField();
            separador = new javax.swing.JSeparator();
            btnConfirmarPacMod = new javax.swing.JButton();
            btnCancelarPacMod = new javax.swing.JButton();
            campoModObSocPac = new javax.swing.JCheckBox();
            jPanelModificarPro = new javax.swing.JPanel();
            nombreTXT1 = new javax.swing.JLabel();
            apellidoSig1 = new javax.swing.JLabel();
            apellidoTXT1 = new javax.swing.JLabel();
            dniSig1 = new javax.swing.JLabel();
            modTelInput1 = new javax.swing.JTextField();
            dniTXT1 = new javax.swing.JLabel();
            modMailInput1 = new javax.swing.JTextField();
            titulo1 = new javax.swing.JLabel();
            telefonoSig1 = new javax.swing.JLabel();
            subtitulo1 = new javax.swing.JLabel();
            separador1 = new javax.swing.JSeparator();
            buscarModPro = new javax.swing.JButton();
            emailSig1 = new javax.swing.JLabel();
            campoMatiProMod = new javax.swing.JTextField();
            noEncontro1 = new javax.swing.JLabel();
            matMod = new javax.swing.JLabel();
            nombreSig1 = new javax.swing.JLabel();
            matriculaTXT1 = new javax.swing.JLabel();
            confirmarProbtn = new javax.swing.JButton();
            cancelarProbtn = new javax.swing.JButton();
            jPanelMostrarTodos = new javax.swing.JPanel();
            verPacientes = new javax.swing.JRadioButton();
            verProfesionales = new javax.swing.JRadioButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTableMostrar = new javax.swing.JTable();
            cancelarbtn = new javax.swing.JButton();
            jRadioButton1 = new javax.swing.JRadioButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new java.awt.CardLayout());

            jPanelBuscarPaciente.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBuscarPaciente.setOpaque(false);

            jLabel1.setBackground(new java.awt.Color(0, 0, 0));
            jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Buscar paciente");

            dniPacBuscarTxt.setBackground(new java.awt.Color(51, 51, 51));
            dniPacBuscarTxt.setForeground(new java.awt.Color(255, 255, 255));
            dniPacBuscarTxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPacBuscarTxtActionPerformed(evt);
                  }
            });
            dniPacBuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniPacBuscarTxtKeyTyped(evt);
                  }
            });

            jLabel4.setForeground(new java.awt.Color(255, 255, 255));
            jLabel4.setText("DNI");

            btnBuscarPac.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarPac.setForeground(new java.awt.Color(255, 255, 255));
            btnBuscarPac.setText("Buscar");
            btnBuscarPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBuscarPacActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelBuscarPacienteLayout = new javax.swing.GroupLayout(jPanelBuscarPaciente);
            jPanelBuscarPaciente.setLayout(jPanelBuscarPacienteLayout);
            jPanelBuscarPacienteLayout.setHorizontalGroup(
                  jPanelBuscarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelBuscarPacienteLayout.createSequentialGroup()
                        .addContainerGap(157, Short.MAX_VALUE)
                        .addGroup(jPanelBuscarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarPacienteLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dniPacBuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarPacienteLayout.createSequentialGroup()
                                    .addComponent(btnBuscarPac)
                                    .addGap(59, 59, 59))
                              .addGroup(jPanelBuscarPacienteLayout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(jLabel1)))
                        .addContainerGap(188, Short.MAX_VALUE))
            );
            jPanelBuscarPacienteLayout.setVerticalGroup(
                  jPanelBuscarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelBuscarPacienteLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBuscarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(dniPacBuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscarPac)
                        .addContainerGap(371, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelBuscarPaciente, "card2");

            jPanelContarEstPac.setBackground(new java.awt.Color(153, 204, 255));
            jPanelContarEstPac.setOpaque(false);

            jLabel3.setBackground(new java.awt.Color(0, 0, 0));
            jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Ingrese datos de paciente");

            dniPacContarEstTxt.setBackground(new java.awt.Color(51, 51, 51));
            dniPacContarEstTxt.setForeground(new java.awt.Color(255, 255, 255));
            dniPacContarEstTxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPacContarEstTxtActionPerformed(evt);
                  }
            });
            dniPacContarEstTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniPacContarEstTxtKeyTyped(evt);
                  }
            });

            jLabel6.setForeground(new java.awt.Color(255, 255, 255));
            jLabel6.setText("DNI");

            btnContarEstPac.setBackground(new java.awt.Color(0, 51, 102));
            btnContarEstPac.setForeground(new java.awt.Color(255, 255, 255));
            btnContarEstPac.setText("Buscar");
            btnContarEstPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnContarEstPacActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelContarEstPacLayout = new javax.swing.GroupLayout(jPanelContarEstPac);
            jPanelContarEstPac.setLayout(jPanelContarEstPacLayout);
            jPanelContarEstPacLayout.setHorizontalGroup(
                  jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelContarEstPacLayout.createSequentialGroup()
                        .addGroup(jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelContarEstPacLayout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addGroup(jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(jLabel3)
                                          .addGroup(jPanelContarEstPacLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(dniPacContarEstTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                              .addGroup(jPanelContarEstPacLayout.createSequentialGroup()
                                    .addGap(165, 165, 165)
                                    .addComponent(btnContarEstPac)))
                        .addContainerGap(231, Short.MAX_VALUE))
            );
            jPanelContarEstPacLayout.setVerticalGroup(
                  jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelContarEstPacLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(dniPacContarEstTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContarEstPac)
                        .addContainerGap(392, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelContarEstPac, "card3");

            jPanelBuscarProfesional.setBackground(new java.awt.Color(153, 204, 255));
            jPanelBuscarProfesional.setOpaque(false);

            jLabel7.setBackground(new java.awt.Color(0, 0, 0));
            jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(255, 255, 255));
            jLabel7.setText("Buscar profesional");

            matProBuscartxt1.setBackground(new java.awt.Color(51, 51, 51));
            matProBuscartxt1.setForeground(new java.awt.Color(255, 255, 255));
            matProBuscartxt1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matProBuscartxt1ActionPerformed(evt);
                  }
            });
            matProBuscartxt1.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        matProBuscartxt1KeyTyped(evt);
                  }
            });

            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setText("Matricula");

            btnBuscarMatPro.setBackground(new java.awt.Color(0, 51, 102));
            btnBuscarMatPro.setForeground(new java.awt.Color(255, 255, 255));
            btnBuscarMatPro.setText("Buscar");
            btnBuscarMatPro.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBuscarMatProActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelBuscarProfesionalLayout = new javax.swing.GroupLayout(jPanelBuscarProfesional);
            jPanelBuscarProfesional.setLayout(jPanelBuscarProfesionalLayout);
            jPanelBuscarProfesionalLayout.setHorizontalGroup(
                  jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                        .addContainerGap(113, Short.MAX_VALUE)
                        .addGroup(jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarProfesionalLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(matProBuscartxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarProfesionalLayout.createSequentialGroup()
                                    .addComponent(btnBuscarMatPro)
                                    .addGap(46, 46, 46)))
                        .addContainerGap(202, Short.MAX_VALUE))
            );
            jPanelBuscarProfesionalLayout.setVerticalGroup(
                  jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(matProBuscartxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarMatPro)
                        .addContainerGap(380, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelBuscarProfesional, "card4");

            jPanelModificarPac.setBackground(new java.awt.Color(153, 204, 255));
            jPanelModificarPac.setOpaque(false);

            titulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            titulo.setForeground(new java.awt.Color(255, 255, 255));
            titulo.setText("Modificacion de paciente");

            subtitulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            subtitulo.setForeground(new java.awt.Color(255, 255, 255));
            subtitulo.setText("DNI");

            buscarModPac.setBackground(new java.awt.Color(0, 51, 102));
            buscarModPac.setForeground(new java.awt.Color(255, 255, 255));
            buscarModPac.setText("Buscar");
            buscarModPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buscarModPacActionPerformed(evt);
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
            noEncontro.setForeground(new java.awt.Color(255, 255, 255));
            noEncontro.setText("Paciente no encontrado");
            noEncontro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            nombreSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            nombreSig.setForeground(new java.awt.Color(255, 255, 255));
            nombreSig.setText("Nombre");

            nombreTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            nombreTXT.setForeground(new java.awt.Color(255, 255, 255));
            nombreTXT.setText("default");

            apellidoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            apellidoSig.setForeground(new java.awt.Color(255, 255, 255));
            apellidoSig.setText("Apellido");

            apellidoTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            apellidoTXT.setForeground(new java.awt.Color(255, 255, 255));
            apellidoTXT.setText("default");

            dniSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            dniSig.setForeground(new java.awt.Color(255, 255, 255));
            dniSig.setText("DNI");

            dniTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            dniTXT.setForeground(new java.awt.Color(255, 255, 255));
            dniTXT.setText("default");

            telefonoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            telefonoSig.setForeground(new java.awt.Color(255, 255, 255));
            telefonoSig.setText("Telefono");

            emailSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            emailSig.setForeground(new java.awt.Color(255, 255, 255));
            emailSig.setText("Email");

            obSocSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            obSocSig.setForeground(new java.awt.Color(255, 255, 255));
            obSocSig.setText("Obra Social");

            campoTelMod.setBackground(new java.awt.Color(51, 51, 51));
            campoTelMod.setForeground(new java.awt.Color(255, 255, 255));
            campoTelMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        campoTelModActionPerformed(evt);
                  }
            });
            campoTelMod.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        campoTelModKeyTyped(evt);
                  }
            });

            campoMailMod.setBackground(new java.awt.Color(51, 51, 51));
            campoMailMod.setForeground(new java.awt.Color(255, 255, 255));
            campoMailMod.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        campoMailModKeyTyped(evt);
                  }
            });

            separador.setBackground(new java.awt.Color(153, 204, 255));
            separador.setForeground(new java.awt.Color(102, 102, 102));
            separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnConfirmarPacMod.setBackground(new java.awt.Color(0, 51, 102));
            btnConfirmarPacMod.setForeground(new java.awt.Color(255, 255, 255));
            btnConfirmarPacMod.setText("Confirmar cambios");
            btnConfirmarPacMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnConfirmarPacModActionPerformed(evt);
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

            campoModObSocPac.setBackground(new java.awt.Color(153, 204, 255));
            campoModObSocPac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            campoModObSocPac.setForeground(new java.awt.Color(255, 255, 255));
            campoModObSocPac.setContentAreaFilled(false);
            campoModObSocPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        campoModObSocPacActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelModificarPacLayout = new javax.swing.GroupLayout(jPanelModificarPac);
            jPanelModificarPac.setLayout(jPanelModificarPacLayout);
            jPanelModificarPacLayout.setHorizontalGroup(
                  jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(subtitulo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addGap(113, 113, 113)
                                    .addComponent(titulo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGap(0, 114, Short.MAX_VALUE)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(dniSig)
                                          .addComponent(emailSig)
                                          .addComponent(telefonoSig)
                                          .addComponent(obSocSig)
                                          .addComponent(apellidoSig)
                                          .addComponent(nombreSig))
                                    .addGap(25, 25, 25)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(nombreTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(apellidoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(campoMailMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(campoTelMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(campoModObSocPac)))
                              .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(noEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(97, Short.MAX_VALUE))
                  .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(btnConfirmarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnCancelarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(buscarModPac, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanelModificarPacLayout.setVerticalGroup(
                  jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(subtitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarModPac)
                        .addGap(12, 12, 12)
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addComponent(noEncontro)
                                    .addGap(7, 7, 7)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombreSig)
                                          .addComponent(nombreTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidoSig)
                                          .addComponent(apellidoTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniSig)
                                          .addComponent(dniTXT))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(telefonoSig)
                                          .addComponent(campoTelMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(campoMailMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(emailSig))
                                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(obSocSig))
                                          .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoModObSocPac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                              .addComponent(separador))
                        .addGap(55, 55, 55)
                        .addComponent(btnConfirmarPacMod)
                        .addGap(32, 32, 32)
                        .addComponent(btnCancelarPacMod)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelModificarPac, "card5");

            jPanelModificarPro.setBackground(new java.awt.Color(153, 204, 255));
            jPanelModificarPro.setOpaque(false);
            jPanelModificarPro.setPreferredSize(new java.awt.Dimension(513, 704));

            nombreTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            nombreTXT1.setForeground(new java.awt.Color(255, 255, 255));
            nombreTXT1.setText("default");

            apellidoSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            apellidoSig1.setForeground(new java.awt.Color(255, 255, 255));
            apellidoSig1.setText("Apellido");

            apellidoTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            apellidoTXT1.setForeground(new java.awt.Color(255, 255, 255));
            apellidoTXT1.setText("default");

            dniSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            dniSig1.setForeground(new java.awt.Color(255, 255, 255));
            dniSig1.setText("DNI");

            modTelInput1.setBackground(new java.awt.Color(51, 51, 51));
            modTelInput1.setForeground(new java.awt.Color(255, 255, 255));
            modTelInput1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        modTelInput1ActionPerformed(evt);
                  }
            });
            modTelInput1.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        modTelInput1KeyTyped(evt);
                  }
            });

            dniTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            dniTXT1.setForeground(new java.awt.Color(255, 255, 255));
            dniTXT1.setText("default");

            modMailInput1.setBackground(new java.awt.Color(51, 51, 51));
            modMailInput1.setForeground(new java.awt.Color(255, 255, 255));
            modMailInput1.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        modMailInput1KeyTyped(evt);
                  }
            });

            titulo1.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            titulo1.setForeground(new java.awt.Color(255, 255, 255));
            titulo1.setText("Modificacion de profesional");

            telefonoSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            telefonoSig1.setForeground(new java.awt.Color(255, 255, 255));
            telefonoSig1.setText("Telefono");

            subtitulo1.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
            subtitulo1.setForeground(new java.awt.Color(255, 255, 255));
            subtitulo1.setText("Matricula");

            separador1.setBackground(new java.awt.Color(153, 204, 255));
            separador1.setForeground(new java.awt.Color(102, 102, 102));
            separador1.setOrientation(javax.swing.SwingConstants.VERTICAL);

            buscarModPro.setBackground(new java.awt.Color(0, 51, 102));
            buscarModPro.setForeground(new java.awt.Color(255, 255, 255));
            buscarModPro.setText("Buscar");
            buscarModPro.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buscarModProActionPerformed(evt);
                  }
            });

            emailSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            emailSig1.setForeground(new java.awt.Color(255, 255, 255));
            emailSig1.setText("Email");

            campoMatiProMod.setBackground(new java.awt.Color(51, 51, 51));
            campoMatiProMod.setForeground(new java.awt.Color(255, 255, 255));
            campoMatiProMod.setToolTipText("Ingrese el DNI");
            campoMatiProMod.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        campoMatiProModActionPerformed(evt);
                  }
            });
            campoMatiProMod.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        campoMatiProModKeyTyped(evt);
                  }
            });

            noEncontro1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            noEncontro1.setForeground(new java.awt.Color(255, 255, 255));
            noEncontro1.setText("Paciente no encontrado");
            noEncontro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

            matMod.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            matMod.setForeground(new java.awt.Color(255, 255, 255));
            matMod.setText("Matricula");

            nombreSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
            nombreSig1.setForeground(new java.awt.Color(255, 255, 255));
            nombreSig1.setText("Nombre");

            matriculaTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            matriculaTXT1.setForeground(new java.awt.Color(255, 255, 255));
            matriculaTXT1.setText("default");

            confirmarProbtn.setBackground(new java.awt.Color(0, 51, 102));
            confirmarProbtn.setForeground(new java.awt.Color(255, 255, 255));
            confirmarProbtn.setText("Confirmar cambios");
            confirmarProbtn.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        confirmarProbtnActionPerformed(evt);
                  }
            });

            cancelarProbtn.setBackground(new java.awt.Color(0, 51, 102));
            cancelarProbtn.setForeground(new java.awt.Color(255, 255, 255));
            cancelarProbtn.setText("Cancelar");
            cancelarProbtn.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cancelarProbtnActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout jPanelModificarProLayout = new javax.swing.GroupLayout(jPanelModificarPro);
            jPanelModificarPro.setLayout(jPanelModificarProLayout);
            jPanelModificarProLayout.setHorizontalGroup(
                  jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarProLayout.createSequentialGroup()
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(subtitulo1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(titulo1)
                                          .addComponent(campoMatiProMod, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                                            .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(dniSig1)
                                                                  .addComponent(emailSig1)
                                                                  .addComponent(telefonoSig1)
                                                                  .addComponent(matMod)
                                                                  .addComponent(apellidoSig1)
                                                                  .addComponent(nombreSig1))
                                                            .addGap(25, 25, 25)
                                                            .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                  .addComponent(nombreTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(apellidoTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(dniTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(modMailInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(modTelInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                  .addComponent(matriculaTXT1)))
                                                      .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                                            .addGap(22, 22, 22)
                                                            .addComponent(noEncontro1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                              .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                    .addGap(193, 193, 193)
                                    .addComponent(buscarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                          .addComponent(confirmarProbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(cancelarProbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            jPanelModificarProLayout.setVerticalGroup(
                  jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelModificarProLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(titulo1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(campoMatiProMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(subtitulo1))
                        .addGap(18, 18, 18)
                        .addComponent(buscarModPro)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                    .addComponent(noEncontro1)
                                    .addGap(7, 7, 7)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombreSig1)
                                          .addComponent(nombreTXT1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidoSig1)
                                          .addComponent(apellidoTXT1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniSig1)
                                          .addComponent(dniTXT1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(telefonoSig1)
                                          .addComponent(modTelInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(modMailInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(emailSig1))
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(matMod)
                                          .addComponent(matriculaTXT1)))
                              .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(confirmarProbtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarProbtn)
                        .addContainerGap(183, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelModificarPro, "card6");

            jPanelMostrarTodos.setBackground(new java.awt.Color(153, 204, 255));
            jPanelMostrarTodos.setOpaque(false);

            verPacientes.setBackground(new java.awt.Color(153, 204, 255));
            verPacientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            verPacientes.setForeground(new java.awt.Color(255, 255, 255));
            verPacientes.setText("Ver todos");
            verPacientes.setContentAreaFilled(false);
            verPacientes.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        verPacientesActionPerformed(evt);
                  }
            });

            verProfesionales.setBackground(new java.awt.Color(255, 255, 255));
            verProfesionales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            verProfesionales.setForeground(new java.awt.Color(255, 255, 255));
            verProfesionales.setText("Ver con obra social");
            verProfesionales.setContentAreaFilled(false);
            verProfesionales.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        verProfesionalesActionPerformed(evt);
                  }
            });

            jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
            jScrollPane1.setForeground(new java.awt.Color(153, 204, 255));

            jTableMostrar.setBackground(new java.awt.Color(102, 153, 255));
            jTableMostrar.setForeground(new java.awt.Color(0, 0, 0));
            jTableMostrar.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                  },
                  new String [] {
                        "Nombre", "Apellido", "DNI", "Email", "Telefono", "Obra social"
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
            jTableMostrar.setOpaque(false);
            jScrollPane1.setViewportView(jTableMostrar);

            cancelarbtn.setBackground(new java.awt.Color(0, 51, 102));
            cancelarbtn.setForeground(new java.awt.Color(255, 255, 255));
            cancelarbtn.setText("Volver");
            cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cancelarbtnActionPerformed(evt);
                  }
            });

            jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
            jRadioButton1.setText("Ver sin obra social");
            jRadioButton1.setContentAreaFilled(false);

            javax.swing.GroupLayout jPanelMostrarTodosLayout = new javax.swing.GroupLayout(jPanelMostrarTodos);
            jPanelMostrarTodos.setLayout(jPanelMostrarTodosLayout);
            jPanelMostrarTodosLayout.setHorizontalGroup(
                  jPanelMostrarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                  .addGroup(jPanelMostrarTodosLayout.createSequentialGroup()
                        .addGroup(jPanelMostrarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(jPanelMostrarTodosLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(verPacientes)
                                    .addGap(18, 18, 18)
                                    .addComponent(verProfesionales)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton1))
                              .addGroup(jPanelMostrarTodosLayout.createSequentialGroup()
                                    .addGap(211, 211, 211)
                                    .addComponent(cancelarbtn)))
                        .addContainerGap(109, Short.MAX_VALUE))
            );
            jPanelMostrarTodosLayout.setVerticalGroup(
                  jPanelMostrarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanelMostrarTodosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanelMostrarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(verPacientes)
                              .addComponent(verProfesionales)
                              .addComponent(jRadioButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarbtn)
                        .addContainerGap(150, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelMostrarTodos, "card7");

            pack();
      }// </editor-fold>//GEN-END:initComponents

    
    /////////////////////////////
    ////METODOS REUTILIZABLES////
    /////////////////////////////
    
    private boolean buscarPacDni(String dniBusqueda){
        return (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Paciente));
    }
    
    private PacienteController obtenerPac(String dni){
        Paciente encontrada = (Paciente) mapaPersonas.get(dni);
        return new PacienteController(encontrada);
    }
    
    private ProfesionalController obtenerPro(String dni){
        Profesional encontrada = (Profesional) mapaPersonas.get(dni);
        return new ProfesionalController(encontrada);
    }
    
    private void muestraOnoCamposModPac(boolean siOno){
        if (siOno){
            separador.setVisible(true);
            noEncontro.setVisible(false);
            nombreSig.setVisible(true);
            nombreTXT.setVisible(true);
            apellidoSig.setVisible(true);
            apellidoTXT.setVisible(true);
            telefonoSig.setVisible(true);
            emailSig.setVisible(true);
            dniSig.setVisible(true);
            dniTXT.setVisible(true);
            obSocSig.setVisible(true);
            campoTelMod.setVisible(true);
            campoTelMod.setEnabled(true);
            campoMailMod.setVisible(true);
            campoMailMod.setEnabled(true);
            campoModObSocPac.setVisible(true);
            campoModObSocPac.setEnabled(true);    
            btnConfirmarPacMod.setVisible(true);
            btnConfirmarPacMod.setEnabled(true);
        }else{
            separador.setVisible(false);
            noEncontro.setVisible(false);
            nombreSig.setVisible(false);
            nombreTXT.setVisible(false);
            apellidoSig.setVisible(false);
            apellidoTXT.setVisible(false);
            telefonoSig.setVisible(false);
            emailSig.setVisible(false);
            dniSig.setVisible(false);
            dniTXT.setVisible(false);
            obSocSig.setVisible(false);
            campoTelMod.setVisible(false);
            campoTelMod.setEnabled(false);
            campoMailMod.setVisible(false);
            campoMailMod.setEnabled(false);
            campoModObSocPac.setVisible(false);
            campoModObSocPac.setEnabled(false);
            campoTelMod.setVisible(false);
            campoTelMod.setEnabled(false);
            campoMailMod.setVisible(false);
            campoMailMod.setEnabled(false);
            campoModObSocPac.setVisible(false);
            campoModObSocPac.setEnabled(false);
            btnConfirmarPacMod.setVisible(false);
            btnConfirmarPacMod.setEnabled(false);
        }     
    }
    
    private void muestraOnoCamposModPro(boolean siOno){
        if (siOno){
            separador1.setVisible(true);
            noEncontro1.setVisible(false);
            nombreSig1.setVisible(true);
            nombreTXT1.setVisible(true);
            apellidoSig1.setVisible(true);
            apellidoTXT1.setVisible(true);
            telefonoSig1.setVisible(true);
            emailSig1.setVisible(true);
            dniSig1.setVisible(true);
            dniTXT1.setVisible(true);
            modTelInput1.setVisible(true);
            modTelInput1.setEnabled(true);
            modMailInput1.setVisible(true);
            modMailInput1.setEnabled(true);
            matMod.setVisible(true);
            matriculaTXT1.setVisible(true);    
            confirmarProbtn.setVisible(true);
            confirmarProbtn.setEnabled(true);
        }else{
            separador1.setVisible(false);
            noEncontro1.setVisible(false);
            nombreSig1.setVisible(false);
            nombreTXT1.setVisible(false);
            apellidoSig1.setVisible(false);
            apellidoTXT1.setVisible(false);
            telefonoSig1.setVisible(false);
            emailSig1.setVisible(false);
            dniSig1.setVisible(false);
            dniTXT1.setVisible(false);
            modTelInput1.setVisible(false);
            modTelInput1.setEnabled(false);
            modMailInput1.setVisible(false);
            modMailInput1.setEnabled(false);
            matMod.setVisible(false);
            matriculaTXT1.setVisible(false);    
            confirmarProbtn.setVisible(false);
            confirmarProbtn.setEnabled(false);
        }     
    }
    
    private void mostrarTodosPac(Paciente pac) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        PacienteController miPac = new PacienteController(pac);
        Object[] nuevaFila = new Object[6]; 
        nuevaFila[0] = miPac.muestraNombre();
        nuevaFila[1] = miPac.muestraApellido();
        nuevaFila[2] = miPac.muestraDni();
        nuevaFila[3] = miPac.muestraTelefono();
        nuevaFila[4] = miPac.muestraMail();
        if(miPac.muestraObraSocial())
              nuevaFila[5] = "SI";
        else
              nuevaFila[5] = "NO";
        modelo.addRow(nuevaFila);
}
    
    private void mostrarSinObSoc(Paciente pac){
          DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
          
    }
    
    private void mostrarTodosPro(Profesional pro) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        ProfesionalController miPro = new ProfesionalController(pro);
        Object[] nuevaFila = new Object[6];
        nuevaFila[0] = miPro.muestraNombre();
        nuevaFila[1] = miPro.muestraApellido();
        nuevaFila[2] = miPro.muestraDni();
        nuevaFila[3] = miPro.muestraTelefono();
        nuevaFila[4] = miPro.muestraMail();
        nuevaFila[5] = miPro.muestraMatricula();
        modelo.addRow(nuevaFila);
}
    
    private boolean validarDatosBaseMod(String email, String telefono, String dniMod) {
        //Control campos vacios
        if (telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No pueden haber campos vacios.");
            return false;
        }
        //Control de formato de email
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "El email debe contener '@' ");
            return false;
        }
        if (email.contains(" ")) {
            JOptionPane.showMessageDialog(this, "El email no puede contener espacios");
            return false;
        }
        //Control de Teléfono y Email
        for (Persona p : mapaPersonas.values()) {
            PersonaController pc = new PersonaController(p);
            
            if(pc.muestraDni().equals(dniMod)){
                continue;
            }
            
            if (pc.muestraTelefono().equals(telefono)) {
                JOptionPane.showMessageDialog(this, "Error: El teléfono ya pertenece a otro usuario.");
                return false;
            }
            if (pc.muestraMail().equalsIgnoreCase(email)) {
                JOptionPane.showMessageDialog(this, "Error: El email ya pertenece a otro usuario.");
                return false;
            }
        }
        return true;
    }
    
    private boolean buscarProMat(String matBusqueda){
        for (Persona p : mapaPersonas.values()){
            if (p instanceof Profesional pro){
                ProfesionalController miPro = new ProfesionalController(pro);
                if(miPro.muestraMatricula().equals(matBusqueda)){
                    return true;
                }
            }
        }
        return false;
    }
    
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
                        escritorPac.append(miPac.muestraTelefono() + "\n");
                        escritorPac.append(miPac.muestraMail() + "\n");
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
      
    private void btnBuscarPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacActionPerformed
        String dniBusqueda = dniPacBuscarTxt.getText();
        if (buscarPacDni(dniBusqueda)){
                Object[] opciones = {"Salir", "Reintentar"}; 
                int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Paciente encontrado!\n\nNombre: " + obtenerPac(dniBusqueda).muestraNombre() + "\nDNI: " + obtenerPac(dniBusqueda).muestraDni()
                        + "\n\nDesea intentarlo nuevamente?", "Busqueda", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(seleccion == 0)
                      this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
    }//GEN-LAST:event_btnBuscarPacActionPerformed

    private void dniPacBuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacBuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacBuscarTxtActionPerformed

    private void matProBuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProBuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProBuscarTxtActionPerformed

    private void dniPacContarEstTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacContarEstTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacContarEstTxtActionPerformed

    private void btnContarEstPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContarEstPacActionPerformed
        String dniBusqueda = dniPacContarEstTxt.getText();
        if (buscarPacDni(dniBusqueda)){
                Paciente encontrada = (Paciente) mapaPersonas.get(dniBusqueda);
                PacienteController miPac = new PacienteController(encontrada);
                int cantEst = miPac.obtenerCantidadEstudios(listaEstudios);
                Object[] opciones = {"Salir", "Reintentar"}; 
                int seleccion = javax.swing.JOptionPane.showOptionDialog(this,"Nombre: " + miPac.muestraNombre() + "\nDNI: " +
                        miPac.muestraDni() + "\nCantidad de estudios: " + cantEst + "\n\nDesea intentarlo con otro paciente?\n", "Muestra",
                        javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if(seleccion == 0)
                      this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
    }//GEN-LAST:event_btnContarEstPacActionPerformed

    private void matProBuscartxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProBuscartxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProBuscartxt1ActionPerformed

    private void btnBuscarMatProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatProActionPerformed
        String matIngresada = matProBuscartxt1.getText();
        boolean encontro = false;
        
        for (Persona p : mapaPersonas.values()){
            if (p instanceof Profesional pro){
                ProfesionalController miPro = new ProfesionalController(pro);
                if(miPro.muestraMatricula().equals(matIngresada)){
                    JOptionPane.showMessageDialog(this, "---Profesional encontrado---\n\n" + miPro.mostrarDatos());
                    encontro = true;
                    break;
                }
            }
        }
        if (encontro == false){
            JOptionPane.showMessageDialog(this, "No se encontro profesional con matricula -" + matIngresada + "-");
        }
    }//GEN-LAST:event_btnBuscarMatProActionPerformed

    private void buscarModPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarModPacActionPerformed
        String dniBusqueda = campoDniPac.getText();
        if (buscarPacDni(dniBusqueda)){
            //Mostramos todo para modificar
            muestraOnoCamposModPac(true);
            nombreTXT.setText(obtenerPac(dniBusqueda).muestraNombre());
            apellidoTXT.setText(obtenerPac(dniBusqueda).muestraApellido());
            dniTXT.setText(obtenerPac(dniBusqueda).muestraDni());
            campoTelMod.setText(obtenerPac(dniBusqueda).muestraTelefono());
            campoMailMod.setText(obtenerPac(dniBusqueda).muestraMail());
            subtitulo.setVisible(false);
            subtitulo.setEnabled(false);
            campoDniPac.setVisible(false);
            campoDniPac.setEnabled(false);
            buscarModPac.setVisible(false);
            buscarModPac.setEnabled(false);
        }
        else{
            muestraOnoCamposModPac(false);
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
        }
    }//GEN-LAST:event_buscarModPacActionPerformed

    private void campoDniPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniPacActionPerformed
        
    }//GEN-LAST:event_campoDniPacActionPerformed

    private void campoTelModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelModActionPerformed

    private void btnConfirmarPacModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPacModActionPerformed
        String email = campoMailMod.getText().trim();
        String telefono = campoTelMod.getText().trim();
        String dniMod = dniTXT.getText().trim();
        if (validarDatosBaseMod(email, telefono, dniMod)){
            PacienteController miPaciente = obtenerPac(dniMod);
            miPaciente.colocarTelefono(telefono);
            miPaciente.colocarEmail(email);
            miPaciente.colocarObraSocial(campoModObSocPac.isSelected());
            mapaPersonas.put(miPaciente.muestraDni(), miPaciente.obtenerPaciente());
            muestraOnoCamposModPac(false);
            JOptionPane.showMessageDialog(this, "Paciente modificado correctamente.");
            subtitulo.setVisible(true);
            subtitulo.setEnabled(true);
            campoDniPac.setVisible(true);
            campoDniPac.setEnabled(true);
            buscarModPac.setVisible(true);
            buscarModPac.setEnabled(true);
            actualizarArchivoGeneral();
        }
    }//GEN-LAST:event_btnConfirmarPacModActionPerformed

    private void modTelInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modTelInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modTelInput1ActionPerformed

    private void buscarModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarModProActionPerformed
        String matBusqueda = campoMatiProMod.getText();
        if (buscarProMat(matBusqueda)){
            Profesional pr = new Profesional();
            ProfesionalController miPro = new ProfesionalController(pr);
            Profesional pr2 = miPro.ObtenerProfesionalMat(matBusqueda, mapaPersonas);
            ProfesionalController miPro2 = new ProfesionalController(pr2);
            //Mostramos todo para modificar
            muestraOnoCamposModPro(true);
            nombreTXT1.setText(miPro2.muestraNombre());
            apellidoTXT1.setText(miPro2.muestraApellido());
            dniTXT1.setText(miPro2.muestraDni());
            modTelInput1.setText(miPro2.muestraTelefono());
            modMailInput1.setText(miPro2.muestraMail());
            matriculaTXT1.setText(miPro2.muestraMatricula());
        }
        else{
            muestraOnoCamposModPro(false);
            JOptionPane.showMessageDialog(this, "Profesional no encontrado.");
        }
    }//GEN-LAST:event_buscarModProActionPerformed

    private void campoMatiProModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMatiProModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMatiProModActionPerformed

    private void confirmarProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarProbtnActionPerformed
        String email = modMailInput1.getText().trim();
        String telefono = modTelInput1.getText().trim();
        String dniMod = dniTXT1.getText().trim();
        if (validarDatosBaseMod(email, telefono, dniMod)){
            ProfesionalController miProfesional = obtenerPro(dniMod);
            miProfesional.colocarTelefono(telefono);
            miProfesional.colocarEmail(email);
            mapaPersonas.put(miProfesional.muestraDni(), miProfesional.ObtenerProfesional());
            muestraOnoCamposModPro(false);
            JOptionPane.showMessageDialog(this, "Profesional modificado correctamente.");
            actualizarArchivoGeneral();
        }
    }//GEN-LAST:event_confirmarProbtnActionPerformed

    private void btnCancelarPacModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPacModActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarPacModActionPerformed

    private void cancelarProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarProbtnActionPerformed

      private void dniPacBuscarTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniPacBuscarTxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniPacBuscarTxtKeyTyped

      private void dniPacContarEstTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniPacContarEstTxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniPacContarEstTxtKeyTyped

      private void matProBuscartxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matProBuscartxt1KeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matProBuscartxt1KeyTyped

      private void campoDniPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDniPacKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_campoDniPacKeyTyped

      private void campoMatiProModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMatiProModKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_campoMatiProModKeyTyped

    private void campoTelModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelModKeyTyped
        char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
    }//GEN-LAST:event_campoTelModKeyTyped

    private void campoMailModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMailModKeyTyped
        char c = evt.getKeyChar();
            if(c == java.awt.event.KeyEvent.VK_SPACE)
                  evt.consume();
    }//GEN-LAST:event_campoMailModKeyTyped

    private void modTelInput1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modTelInput1KeyTyped
        char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
    }//GEN-LAST:event_modTelInput1KeyTyped

    private void modMailInput1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modMailInput1KeyTyped
        char c = evt.getKeyChar();
            if(c == java.awt.event.KeyEvent.VK_SPACE)
                  evt.consume();
    }//GEN-LAST:event_modMailInput1KeyTyped

      private void verPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPacientesActionPerformed
       DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
       modelo.setRowCount(0);
       for(Persona p : mapaPersonas.values()){
             if(p instanceof Paciente pac){
                  PacienteController miPac = new PacienteController(pac);
                   mostrarTodosPac(miPac.obtenerPaciente());
                   jTableMostrar.getColumnModel().getColumn(5).setHeaderValue("Obra social");
                   this.repaint();
                   verProfesionales.setSelected(false);
             }
       }
      }//GEN-LAST:event_verPacientesActionPerformed

      private void verProfesionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verProfesionalesActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
            modelo.setRowCount(0);
            for(Persona p : mapaPersonas.values()){
                  if(p instanceof Profesional pro){
                        ProfesionalController miPro = new ProfesionalController(pro);
                        mostrarTodosPro(miPro.ObtenerProfesional());
                        jTableMostrar.getColumnModel().getColumn(5).setHeaderValue("Matricula");
                        this.repaint();
                        verPacientes.setSelected(false);
                  }
            }
      }//GEN-LAST:event_verProfesionalesActionPerformed

      private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
            this.dispose();
      }//GEN-LAST:event_cancelarbtnActionPerformed

      private void campoModObSocPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoModObSocPacActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_campoModObSocPacActionPerformed

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel apellidoSig;
      private javax.swing.JLabel apellidoSig1;
      private javax.swing.JLabel apellidoTXT;
      private javax.swing.JLabel apellidoTXT1;
      private javax.swing.JButton btnBuscarMatPro;
      private javax.swing.JButton btnBuscarPac;
      private javax.swing.JButton btnCancelarPacMod;
      private javax.swing.JButton btnConfirmarPacMod;
      private javax.swing.JButton btnContarEstPac;
      private javax.swing.JButton buscarModPac;
      private javax.swing.JButton buscarModPro;
      private javax.swing.JTextField campoDniPac;
      private javax.swing.JTextField campoMailMod;
      private javax.swing.JTextField campoMatiProMod;
      private javax.swing.JCheckBox campoModObSocPac;
      private javax.swing.JTextField campoTelMod;
      private javax.swing.JButton cancelarProbtn;
      private javax.swing.JButton cancelarbtn;
      private javax.swing.JButton confirmarProbtn;
      private javax.swing.JTextField dniPacBuscarTxt;
      private javax.swing.JTextField dniPacContarEstTxt;
      private javax.swing.JLabel dniSig;
      private javax.swing.JLabel dniSig1;
      private javax.swing.JLabel dniTXT;
      private javax.swing.JLabel dniTXT1;
      private javax.swing.JLabel emailSig;
      private javax.swing.JLabel emailSig1;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private javax.swing.JLabel jLabel8;
      private javax.swing.JPanel jPanelBuscarPaciente;
      private javax.swing.JPanel jPanelBuscarProfesional;
      private javax.swing.JPanel jPanelContarEstPac;
      private javax.swing.JPanel jPanelModificarPac;
      private javax.swing.JPanel jPanelModificarPro;
      private javax.swing.JPanel jPanelMostrarTodos;
      private javax.swing.JRadioButton jRadioButton1;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JTable jTableMostrar;
      private javax.swing.JLabel matMod;
      private javax.swing.JTextField matProBuscartxt1;
      private javax.swing.JLabel matriculaTXT1;
      private javax.swing.JTextField modMailInput1;
      private javax.swing.JTextField modTelInput1;
      private javax.swing.JLabel noEncontro;
      private javax.swing.JLabel noEncontro1;
      private javax.swing.JLabel nombreSig;
      private javax.swing.JLabel nombreSig1;
      private javax.swing.JLabel nombreTXT;
      private javax.swing.JLabel nombreTXT1;
      private javax.swing.JLabel obSocSig;
      private javax.swing.JSeparator separador;
      private javax.swing.JSeparator separador1;
      private javax.swing.JLabel subtitulo;
      private javax.swing.JLabel subtitulo1;
      private javax.swing.JLabel telefonoSig;
      private javax.swing.JLabel telefonoSig1;
      private javax.swing.JLabel titulo;
      private javax.swing.JLabel titulo1;
      private javax.swing.JRadioButton verPacientes;
      private javax.swing.JRadioButton verProfesionales;
      // End of variables declaration//GEN-END:variables

}
