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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioBuscar extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private int op;
    private javax.swing.JFrame ventanaPrincipal;
    FondoPanel fondo = new FondoPanel();

      public FormularioBuscar() {
          this.setContentPane(fondo);
          initComponents();
          setIconImage(new ImageIcon(getClass().getResource("/imagenes/unnamed.png")).getImage());
          jScrollPane1.setOpaque(false);
          jScrollPane1.getViewport().setOpaque(false);
          jTableMostrar.setOpaque(false);
          setLocationRelativeTo(null);
          jTableMostrar.setFillsViewportHeight(true);
          Color cel = new Color(153, 204, 255);
          jScrollPane1.setBackground(cel);
          jScrollPane1.getViewport().setBackground(cel);
          jScrollPane1.setBorder(null);
          jScrollPane1.setViewportBorder(null);
          jScrollPane1.setOpaque(false);
          jScrollPane1.getViewport().setOpaque(false);
          jTableMostrar.getColumnModel().getColumn(3).setPreferredWidth(100);
          jTableMostrar.getColumnModel().getColumn(4).setPreferredWidth(200);
          jTableMostrar.getColumnModel().getColumn(0).setPreferredWidth(100);
          jTableMostrarPro.setFillsViewportHeight(true);
          jScrollPane2.setBackground(cel);
          jScrollPane2.getViewport().setBackground(cel);
          jScrollPane2.setBorder(null);
          jScrollPane2.setViewportBorder(null);
          jScrollPane2.setOpaque(false);
          jScrollPane2.getViewport().setOpaque(false);
      }

    public FormularioBuscar(HashMap<String, Persona> mapaPersonas, int op, String operacion, ArrayList<Estudio> listaEstudios, javax.swing.JFrame ventanaPrincipal) {
        this();
        this.ventanaPrincipal = ventanaPrincipal;
        this.mapaPersonas = mapaPersonas;
        this.accionActual = operacion; 
        this.listaEstudios = listaEstudios;
        this.op = op;
        setLocationRelativeTo(null);
        metAux(this.op);
    }
    
    
    private void metAux(int op){
            if(op == 0){
                 if ("Modificar".equals(accionActual)){
                    muestraOnoCamposModPac(false);
                    jPanelModificarPac.setVisible(true);
                    jPanelModificarPac.setEnabled(true);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    jPanelMostrarTodosPac.setVisible(false);
                    jPanelMostrarTodosPac.setEnabled(false);
                    jPanelMostrarTodosPro.setVisible(false);
                    jPanelMostrarTodosPro.setEnabled(false);
                    this.pack();
                  }
                  else if ("Mostrar/Buscar".equals(accionActual)){
                    jPanelMostrarTodosPac.setVisible(true);
                    jPanelMostrarTodosPac.setEnabled(true);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    this.pack();
                  }
                  
            }else if(op == 1){
                 if ("Modificar".equals(accionActual)){
                    muestraOnoCamposModPro(false);  
                    jPanelModificarPro.setVisible(true);
                    jPanelModificarPro.setEnabled(true);
                    jPanelMostrarTodosPac.setVisible(false);
                    jPanelMostrarTodosPac.setEnabled(false);
                    jPanelMostrarTodosPro.setVisible(false);
                    jPanelMostrarTodosPro.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    this.pack();
                  }
                  else if ("Mostrar/Buscar".equals(accionActual)){
                    jPanelMostrarTodosPro.setVisible(true);
                    jPanelMostrarTodosPro.setEnabled(true);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                    jPanelMostrarTodosPac.setVisible(false);
                    jPanelMostrarTodosPac.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    this.pack();
                  }
            }
      }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanelMostrarTodosPac = new javax.swing.JPanel();
        verTodos = new javax.swing.JRadioButton();
        verConObSoc = new javax.swing.JRadioButton();
        cancelarbtn = new javax.swing.JButton();
        verSinObSoc = new javax.swing.JRadioButton();
        dnitxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMostrar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        buscarPorDni = new javax.swing.JButton();
        jPanelMostrarTodosPro = new javax.swing.JPanel();
        verTodosPro = new javax.swing.JRadioButton();
        volverBtn = new javax.swing.JButton();
        mattxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMostrarPro = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        buscarProMat = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelModificarPac.setBackground(new java.awt.Color(153, 204, 255));
        jPanelModificarPac.setOpaque(false);

        titulo.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Modificacion de paciente");

        subtitulo.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
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

        noEncontro.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N
        noEncontro.setForeground(new java.awt.Color(255, 255, 255));
        noEncontro.setText("Paciente no encontrado");
        noEncontro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nombreSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        nombreSig.setForeground(new java.awt.Color(153, 153, 153));
        nombreSig.setText("Nombre");

        nombreTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        nombreTXT.setForeground(new java.awt.Color(255, 255, 255));
        nombreTXT.setText("default");

        apellidoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        apellidoSig.setForeground(new java.awt.Color(153, 153, 153));
        apellidoSig.setText("Apellido");

        apellidoTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        apellidoTXT.setForeground(new java.awt.Color(255, 255, 255));
        apellidoTXT.setText("default");

        dniSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        dniSig.setForeground(new java.awt.Color(153, 153, 153));
        dniSig.setText("DNI");

        dniTXT.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        dniTXT.setForeground(new java.awt.Color(255, 255, 255));
        dniTXT.setText("default");

        telefonoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        telefonoSig.setForeground(new java.awt.Color(153, 153, 153));
        telefonoSig.setText("Telefono");

        emailSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        emailSig.setForeground(new java.awt.Color(153, 153, 153));
        emailSig.setText("Email");

        obSocSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        obSocSig.setForeground(new java.awt.Color(153, 153, 153));
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
                .addGap(179, 179, 179)
                .addComponent(buscarModPac, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificarPacLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelModificarPacLayout.createSequentialGroup()
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
                                        .addComponent(campoModObSocPac)
                                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(campoMailMod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(campoTelMod, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(noEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                            .addComponent(subtitulo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCancelarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnConfirmarPacMod, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(162, 162, 162))))
                .addGap(49, 49, 49))
        );
        jPanelModificarPacLayout.setVerticalGroup(
            jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDniPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarModPac)
                .addGap(18, 18, 18)
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
                .addGap(57, 57, 57)
                .addComponent(btnConfirmarPacMod)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarPacMod)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelModificarPac, "card5");

        jPanelModificarPro.setBackground(new java.awt.Color(153, 204, 255));
        jPanelModificarPro.setOpaque(false);
        jPanelModificarPro.setPreferredSize(new java.awt.Dimension(513, 704));

        nombreTXT1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        nombreTXT1.setForeground(new java.awt.Color(255, 255, 255));
        nombreTXT1.setText("default");

        apellidoSig1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        apellidoSig1.setForeground(new java.awt.Color(255, 255, 255));
        apellidoSig1.setText("Apellido");

        apellidoTXT1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        apellidoTXT1.setForeground(new java.awt.Color(255, 255, 255));
        apellidoTXT1.setText("default");

        dniSig1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
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

        dniTXT1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        dniTXT1.setForeground(new java.awt.Color(255, 255, 255));
        dniTXT1.setText("default");

        modMailInput1.setBackground(new java.awt.Color(51, 51, 51));
        modMailInput1.setForeground(new java.awt.Color(255, 255, 255));
        modMailInput1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modMailInput1KeyTyped(evt);
            }
        });

        titulo1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setText("Modificacion de profesional");

        telefonoSig1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        telefonoSig1.setForeground(new java.awt.Color(255, 255, 255));
        telefonoSig1.setText("Telefono");

        subtitulo1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
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

        emailSig1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
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

        noEncontro1.setFont(new java.awt.Font("Nirmala UI", 3, 14)); // NOI18N
        noEncontro1.setForeground(new java.awt.Color(255, 255, 255));
        noEncontro1.setText("Paciente no encontrado");
        noEncontro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        matMod.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        matMod.setForeground(new java.awt.Color(255, 255, 255));
        matMod.setText("Matricula");

        nombreSig1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        nombreSig1.setForeground(new java.awt.Color(255, 255, 255));
        nombreSig1.setText("Nombre");

        matriculaTXT1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
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
                                            .addComponent(matriculaTXT1)
                                            .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(modMailInput1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                .addComponent(modTelInput1, javax.swing.GroupLayout.Alignment.LEADING))))
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
                .addContainerGap(71, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoSig1)
                            .addComponent(apellidoTXT1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dniSig1)
                            .addComponent(dniTXT1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonoSig1)
                            .addComponent(modTelInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailSig1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modMailInput1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(matMod)
                            .addComponent(matriculaTXT1)))
                    .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(confirmarProbtn)
                .addGap(18, 18, 18)
                .addComponent(cancelarProbtn)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelModificarPro, "card6");

        jPanelMostrarTodosPac.setBackground(new java.awt.Color(153, 204, 255));
        jPanelMostrarTodosPac.setOpaque(false);

        verTodos.setBackground(new java.awt.Color(153, 204, 255));
        verTodos.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        verTodos.setForeground(new java.awt.Color(255, 255, 255));
        verTodos.setText("Ver todos");
        verTodos.setContentAreaFilled(false);
        verTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodosActionPerformed(evt);
            }
        });

        verConObSoc.setBackground(new java.awt.Color(255, 255, 255));
        verConObSoc.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        verConObSoc.setForeground(new java.awt.Color(255, 255, 255));
        verConObSoc.setText("Ver con obra social");
        verConObSoc.setContentAreaFilled(false);
        verConObSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verConObSocActionPerformed(evt);
            }
        });

        cancelarbtn.setBackground(new java.awt.Color(0, 51, 102));
        cancelarbtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarbtn.setText("Volver");
        cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtnActionPerformed(evt);
            }
        });

        verSinObSoc.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        verSinObSoc.setForeground(new java.awt.Color(255, 255, 255));
        verSinObSoc.setText("Ver sin obra social");
        verSinObSoc.setContentAreaFilled(false);
        verSinObSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSinObSocActionPerformed(evt);
            }
        });

        dnitxt.setBackground(new java.awt.Color(51, 51, 51));
        dnitxt.setForeground(new java.awt.Color(255, 255, 255));
        dnitxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnitxtActionPerformed(evt);
            }
        });
        dnitxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dnitxtKeyTyped(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane1.setForeground(new java.awt.Color(153, 204, 255));

        jTableMostrar.setBackground(new java.awt.Color(153, 153, 153));
        jTableMostrar.setForeground(new java.awt.Color(0, 0, 0));
        jTableMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Telefono", "Email", "Obra social", "Estudios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por DNI");

        buscarPorDni.setBackground(new java.awt.Color(0, 51, 102));
        buscarPorDni.setForeground(new java.awt.Color(255, 255, 255));
        buscarPorDni.setText("Buscar");
        buscarPorDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorDniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMostrarTodosPacLayout = new javax.swing.GroupLayout(jPanelMostrarTodosPac);
        jPanelMostrarTodosPac.setLayout(jPanelMostrarTodosPacLayout);
        jPanelMostrarTodosPacLayout.setHorizontalGroup(
            jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                        .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(cancelarbtn))
                            .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                                        .addComponent(verSinObSoc)
                                        .addGap(90, 90, 90)
                                        .addComponent(buscarPorDni))
                                    .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                                        .addComponent(verTodos)
                                        .addGap(115, 115, 115)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                                        .addComponent(verConObSoc)
                                        .addGap(51, 51, 51)
                                        .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMostrarTodosPacLayout.setVerticalGroup(
            jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarTodosPacLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verTodos)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verConObSoc)
                    .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMostrarTodosPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verSinObSoc)
                    .addComponent(buscarPorDni))
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(cancelarbtn)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanelMostrarTodosPac, "card7");

        jPanelMostrarTodosPro.setBackground(new java.awt.Color(153, 204, 255));
        jPanelMostrarTodosPro.setOpaque(false);

        verTodosPro.setBackground(new java.awt.Color(153, 204, 255));
        verTodosPro.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        verTodosPro.setForeground(new java.awt.Color(255, 255, 255));
        verTodosPro.setText("Ver todos");
        verTodosPro.setContentAreaFilled(false);
        verTodosPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodosProActionPerformed(evt);
            }
        });

        volverBtn.setBackground(new java.awt.Color(0, 51, 102));
        volverBtn.setForeground(new java.awt.Color(255, 255, 255));
        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        mattxt.setBackground(new java.awt.Color(51, 51, 51));
        mattxt.setForeground(new java.awt.Color(255, 255, 255));
        mattxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mattxtActionPerformed(evt);
            }
        });
        mattxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mattxtKeyTyped(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(153, 204, 255));
        jScrollPane2.setForeground(new java.awt.Color(153, 204, 255));

        jTableMostrarPro.setBackground(new java.awt.Color(204, 204, 204));
        jTableMostrarPro.setForeground(new java.awt.Color(0, 0, 0));
        jTableMostrarPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Email", "Telefono", "Matricula"
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
        jTableMostrarPro.setOpaque(false);
        jScrollPane2.setViewportView(jTableMostrarPro);

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar por matricula");

        buscarProMat.setBackground(new java.awt.Color(0, 51, 102));
        buscarProMat.setForeground(new java.awt.Color(255, 255, 255));
        buscarProMat.setText("Buscar");
        buscarProMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProMatActionPerformed(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Ver sin obra social");
        jRadioButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanelMostrarTodosProLayout = new javax.swing.GroupLayout(jPanelMostrarTodosPro);
        jPanelMostrarTodosPro.setLayout(jPanelMostrarTodosProLayout);
        jPanelMostrarTodosProLayout.setHorizontalGroup(
            jPanelMostrarTodosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                .addGroup(jPanelMostrarTodosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                        .addGroup(jPanelMostrarTodosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(volverBtn))
                            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(buscarProMat))
                            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(verTodosPro)
                                .addGap(109, 109, 109)
                                .addComponent(mattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel5)))
                        .addGap(0, 159, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMostrarTodosProLayout.setVerticalGroup(
            jPanelMostrarTodosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarTodosProLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMostrarTodosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verTodosPro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarProMat)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanelMostrarTodosPro, "card7");

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
    
    private void cargarTablaPac(Paciente pac) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
        PacienteController miPac = new PacienteController(pac);
        Object[] nuevaFila = new Object[7]; 
        nuevaFila[0] = miPac.muestraNombre();
        nuevaFila[1] = miPac.muestraApellido();
        nuevaFila[2] = miPac.muestraDni();
        nuevaFila[3] = miPac.muestraTelefono();
        nuevaFila[4] = miPac.muestraMail();
        if(miPac.muestraObraSocial())
              nuevaFila[5] = "SI";
        else
              nuevaFila[5] = "NO";
        nuevaFila[6] = miPac.obtenerCantidadEstudios(listaEstudios);
        modelo.addRow(nuevaFila);
}
    private void cargarTablaPro(Profesional pro) {
        DefaultTableModel modelo = (DefaultTableModel) jTableMostrarPro.getModel();
        ProfesionalController miPro = new ProfesionalController(pro);
        Object[] nuevaFila = new Object[6]; 
        nuevaFila[0] = miPro.muestraNombre();
        nuevaFila[1] = miPro.muestraApellido();
        nuevaFila[2] = miPro.muestraDni();
        nuevaFila[3] = miPro.muestraMail();
        nuevaFila[4] = miPro.muestraTelefono();
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
      
    private void matProBuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProBuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProBuscarTxtActionPerformed

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
        retornar();
    }//GEN-LAST:event_btnCancelarPacModActionPerformed

    private void cancelarProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProbtnActionPerformed
        retornar();
    }//GEN-LAST:event_cancelarProbtnActionPerformed

      private void campoDniPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDniPacKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
            int limite = 8;
            if(campoDniPac.getText().length() >= limite){
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

      private void verTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodosActionPerformed
       DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
       modelo.setRowCount(0);
       for(Persona p : mapaPersonas.values()){
             if(p instanceof Paciente pac){
                  PacienteController miPac = new PacienteController(pac);
                   cargarTablaPac(miPac.obtenerPaciente());
                   jTableMostrar.getColumnModel().getColumn(5).setHeaderValue("Obra social");
                   this.repaint();
                   verConObSoc.setSelected(false);
                   verSinObSoc.setSelected(false);
             }
       }
      }//GEN-LAST:event_verTodosActionPerformed

      private void verConObSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verConObSocActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
            modelo.setRowCount(0);
            for(Persona p : mapaPersonas.values()){
                  if(p instanceof Paciente pac){
                        PacienteController miPac = new PacienteController(pac);
                        if(miPac.muestraObraSocial()){
                              cargarTablaPac(miPac.obtenerPaciente());
                              this.repaint();
                              verSinObSoc.setSelected(false);
                              verTodos.setSelected(false);
                        }
                  }
            }
      }//GEN-LAST:event_verConObSocActionPerformed

      private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
            retornar();
      }//GEN-LAST:event_cancelarbtnActionPerformed

      private void campoModObSocPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoModObSocPacActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_campoModObSocPacActionPerformed

      private void verSinObSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSinObSocActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
            modelo.setRowCount(0);
            for (Persona p : mapaPersonas.values()){
                  if (p instanceof Paciente pac){
                        PacienteController miPac = new PacienteController(pac);
                        if(miPac.muestraObraSocial() == false){
                              cargarTablaPac(miPac.obtenerPaciente());
                              this.repaint();
                              verConObSoc.setSelected(false);
                              verTodos.setSelected(false);
                        }
                  }
            }
      }//GEN-LAST:event_verSinObSocActionPerformed

      private void buscarPorDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorDniActionPerformed
            String dniBusqueda = dnitxt.getText();
            verTodos.setSelected(false);
            verConObSoc.setSelected(false);
            verSinObSoc.setSelected(false);
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrar.getModel();
            modelo.setRowCount(0);
             if (buscarPacDni(dniBusqueda)){
                  Paciente pac = new Paciente();
                  PacienteController miPac = new PacienteController(pac);
                   cargarTablaPac(obtenerPac(dniBusqueda).obtenerPaciente());
        }else{
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
             dnitxt.setText("");
            
      }//GEN-LAST:event_buscarPorDniActionPerformed

      private void dnitxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dnitxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
            int limite = 8;
            if(dnitxt.getText().length() >= limite){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dnitxtKeyTyped

      private void verTodosProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodosProActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrarPro.getModel();
       modelo.setRowCount(0);
       for(Persona p : mapaPersonas.values()){
             if(p instanceof Profesional pro){
                  ProfesionalController miPro = new ProfesionalController(pro);
                   cargarTablaPro(miPro.ObtenerProfesional());
                   this.repaint();
             }
       }
      }//GEN-LAST:event_verTodosProActionPerformed

      private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
           retornar();
      }//GEN-LAST:event_volverBtnActionPerformed

      private void mattxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mattxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_mattxtKeyTyped

      private void buscarProMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProMatActionPerformed
          boolean encontro = false;  
          boolean noMat= false;
          String matIngresada = mattxt.getText();
          if (matIngresada.isEmpty()){
            JOptionPane.showMessageDialog(this, "-Ingrese una matricula-");
            noMat= true;
            }else{
            verTodosPro.setSelected(false);
            DefaultTableModel modelo = (DefaultTableModel) jTableMostrarPro.getModel();
            modelo.setRowCount(0);
            for (Persona p : mapaPersonas.values()){
                if (p instanceof Profesional pro){
                    ProfesionalController miPro = new ProfesionalController(pro);
                    if(miPro.muestraMatricula().equals(matIngresada)){
                      cargarTablaPro(miPro.ObtenerProfesional());
                        encontro = true;
                        break;
                    }
                }
            }
        }
        if (encontro == false && noMat == false){
            JOptionPane.showMessageDialog(this, "No se encontro profesional con matricula -" + matIngresada + "-");
        }
        mattxt.setText("");
      }//GEN-LAST:event_buscarProMatActionPerformed

      private void mattxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mattxtActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_mattxtActionPerformed

      private void dnitxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnitxtActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_dnitxtActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       retornar();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoSig;
    private javax.swing.JLabel apellidoSig1;
    private javax.swing.JLabel apellidoTXT;
    private javax.swing.JLabel apellidoTXT1;
    private javax.swing.JButton btnCancelarPacMod;
    private javax.swing.JButton btnConfirmarPacMod;
    private javax.swing.JButton buscarModPac;
    private javax.swing.JButton buscarModPro;
    private javax.swing.JButton buscarPorDni;
    private javax.swing.JButton buscarProMat;
    private javax.swing.JTextField campoDniPac;
    private javax.swing.JTextField campoMailMod;
    private javax.swing.JTextField campoMatiProMod;
    private javax.swing.JCheckBox campoModObSocPac;
    private javax.swing.JTextField campoTelMod;
    private javax.swing.JButton cancelarProbtn;
    private javax.swing.JButton cancelarbtn;
    private javax.swing.JButton confirmarProbtn;
    private javax.swing.JLabel dniSig;
    private javax.swing.JLabel dniSig1;
    private javax.swing.JLabel dniTXT;
    private javax.swing.JLabel dniTXT1;
    private javax.swing.JTextField dnitxt;
    private javax.swing.JLabel emailSig;
    private javax.swing.JLabel emailSig1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelModificarPac;
    private javax.swing.JPanel jPanelModificarPro;
    private javax.swing.JPanel jPanelMostrarTodosPac;
    private javax.swing.JPanel jPanelMostrarTodosPro;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMostrar;
    private javax.swing.JTable jTableMostrarPro;
    private javax.swing.JLabel matMod;
    private javax.swing.JLabel matriculaTXT1;
    private javax.swing.JTextField mattxt;
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
    private javax.swing.JRadioButton verConObSoc;
    private javax.swing.JRadioButton verSinObSoc;
    private javax.swing.JRadioButton verTodos;
    private javax.swing.JRadioButton verTodosPro;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void retornar() {
        if (ventanaPrincipal != null) {
        ventanaPrincipal.setVisible(true);
        this.dispose(); 
        }
    }

}