package View;


import Controller.PacienteController;
import Controller.ProfesionalController;
import Model.Estudio;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FormularioBuscar extends javax.swing.JFrame {
    
    private HashMap <String, Persona> mapaPersonas;
    private String accionActual;
    private ArrayList<Estudio> listaEstudios;
    private int op;

      public FormularioBuscar() {
            initComponents();
            setLocationRelativeTo(null);
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
                    jPanelBuscarMatPro.setVisible(false);
                    jPanelBuscarMatPro.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
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
                      jPanelBuscarMatPro.setVisible(false);
                      jPanelBuscarMatPro.setEnabled(false);
                      jPanelModificarPro.setVisible(false);
                      jPanelModificarPro.setEnabled(false);
                  }
                  else{ 
                    jPanelBuscarPaciente.setVisible(true);
                    jPanelBuscarPaciente.setEnabled(true);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false);
                    jPanelBuscarMatPro.setVisible(false);
                    jPanelBuscarMatPro.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                  }
                  
            }else if(op == 1){
                  if ("Buscar por matricula".equals(accionActual)){
                    jPanelBuscarMatPro.setVisible(true);
                    jPanelBuscarMatPro.setEnabled(true);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelBuscarProfesional.setVisible(false);
                    jPanelBuscarProfesional.setEnabled(false); 
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
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
                    jPanelBuscarMatPro.setVisible(false);
                    jPanelBuscarMatPro.setEnabled(false);
                    jPanelModificarPro.setVisible(true);
                    jPanelModificarPro.setEnabled(true);
                  }
                  else{ 
                    jPanelBuscarProfesional.setVisible(true);
                    jPanelBuscarProfesional.setEnabled(true);
                    jPanelBuscarMatPro.setVisible(false);
                    jPanelBuscarMatPro.setEnabled(false);
                    jPanelContarEstPac.setVisible(false);
                    jPanelContarEstPac.setEnabled(false);
                    jPanelBuscarPaciente.setVisible(false);
                    jPanelBuscarPaciente.setEnabled(false);
                    jPanelModificarPac.setVisible(false);
                    jPanelModificarPac.setEnabled(false);
                    jPanelModificarPro.setVisible(false);
                    jPanelModificarPro.setEnabled(false);
                  }
            }
            this.revalidate();
            this.repaint();
      }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBuscarPaciente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dniPacBuscarTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarPac = new javax.swing.JButton();
        jPanelBuscarProfesional = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        matProBuscarTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarPro = new javax.swing.JButton();
        jPanelContarEstPac = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dniPacContarEstTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnContarEstPac = new javax.swing.JButton();
        jPanelBuscarMatPro = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        matProBuscartxt = new javax.swing.JTextField();
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
        campoDniProMod = new javax.swing.JTextField();
        noEncontro1 = new javax.swing.JLabel();
        matMod = new javax.swing.JLabel();
        nombreSig1 = new javax.swing.JLabel();
        matriculaTXT1 = new javax.swing.JLabel();
        confirmarProbtn = new javax.swing.JButton();
        cancelarProbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelBuscarPaciente.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar paciente");

        dniPacBuscarTxt.setBackground(new java.awt.Color(0, 102, 153));
        dniPacBuscarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniPacBuscarTxtActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("DNI");

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
                .addContainerGap(129, Short.MAX_VALUE)
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
                .addContainerGap(164, Short.MAX_VALUE))
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
                .addContainerGap(333, Short.MAX_VALUE))
        );

        jPanelBuscarProfesional.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar profesional");

        matProBuscarTxt.setBackground(new java.awt.Color(0, 102, 153));
        matProBuscarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matProBuscarTxtActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Matricula");

        btnBuscarPro.setText("Buscar");
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarProfesionalLayout = new javax.swing.GroupLayout(jPanelBuscarProfesional);
        jPanelBuscarProfesional.setLayout(jPanelBuscarProfesionalLayout);
        jPanelBuscarProfesionalLayout.setHorizontalGroup(
            jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                .addGroup(jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(matProBuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnBuscarPro)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanelBuscarProfesionalLayout.setVerticalGroup(
            jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarProfesionalLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarProfesionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matProBuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPro)
                .addContainerGap(535, Short.MAX_VALUE))
        );

        jPanelContarEstPac.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ingrese datos de paciente");

        dniPacContarEstTxt.setBackground(new java.awt.Color(0, 102, 153));
        dniPacContarEstTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniPacContarEstTxtActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("DNI");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContarEstPacLayout.createSequentialGroup()
                .addGap(0, 184, Short.MAX_VALUE)
                .addGroup(jPanelContarEstPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContarEstPacLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dniPacContarEstTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContarEstPacLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContarEstPacLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContarEstPac)
                .addGap(135, 135, 135))
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
                .addGap(18, 18, 18)
                .addComponent(btnContarEstPac)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jPanelBuscarMatPro.setBackground(new java.awt.Color(153, 204, 255));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Buscar profesional");

        matProBuscartxt.setBackground(new java.awt.Color(0, 102, 153));
        matProBuscartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matProBuscartxtActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Matricula");

        btnBuscarMatPro.setText("Buscar");
        btnBuscarMatPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMatProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarMatProLayout = new javax.swing.GroupLayout(jPanelBuscarMatPro);
        jPanelBuscarMatPro.setLayout(jPanelBuscarMatProLayout);
        jPanelBuscarMatProLayout.setHorizontalGroup(
            jPanelBuscarMatProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarMatProLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBuscarMatProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(matProBuscartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarMatProLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarMatPro)
                .addGap(125, 125, 125))
        );
        jPanelBuscarMatProLayout.setVerticalGroup(
            jPanelBuscarMatProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarMatProLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarMatProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matProBuscartxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarMatPro)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        jPanelModificarPac.setBackground(new java.awt.Color(153, 204, 255));

        titulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Modificacion de paciente");

        subtitulo.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        subtitulo.setForeground(new java.awt.Color(102, 102, 102));
        subtitulo.setText("DNI");

        buscarModPac.setBackground(new java.awt.Color(0, 51, 102));
        buscarModPac.setText("Buscar");
        buscarModPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarModPacActionPerformed(evt);
            }
        });

        campoDniPac.setForeground(new java.awt.Color(153, 153, 153));
        campoDniPac.setToolTipText("Ingrese el DNI");
        campoDniPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDniPacActionPerformed(evt);
            }
        });

        noEncontro.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        noEncontro.setForeground(new java.awt.Color(102, 102, 102));
        noEncontro.setText("Paciente no encontrado");
        noEncontro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nombreSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        nombreSig.setForeground(new java.awt.Color(102, 102, 102));
        nombreSig.setText("Nombre");

        nombreTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreTXT.setForeground(new java.awt.Color(0, 0, 0));
        nombreTXT.setText("default");

        apellidoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        apellidoSig.setForeground(new java.awt.Color(102, 102, 102));
        apellidoSig.setText("Apellido");

        apellidoTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apellidoTXT.setForeground(new java.awt.Color(0, 0, 0));
        apellidoTXT.setText("default");

        dniSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        dniSig.setForeground(new java.awt.Color(102, 102, 102));
        dniSig.setText("DNI");

        dniTXT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dniTXT.setForeground(new java.awt.Color(0, 0, 0));
        dniTXT.setText("default");

        telefonoSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        telefonoSig.setForeground(new java.awt.Color(102, 102, 102));
        telefonoSig.setText("Telefono");

        emailSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        emailSig.setForeground(new java.awt.Color(102, 102, 102));
        emailSig.setText("Email");

        obSocSig.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        obSocSig.setForeground(new java.awt.Color(102, 102, 102));
        obSocSig.setText("Obra Social");

        campoTelMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelModActionPerformed(evt);
            }
        });

        separador.setBackground(new java.awt.Color(153, 204, 255));
        separador.setForeground(new java.awt.Color(102, 102, 102));
        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnConfirmarPacMod.setBackground(new java.awt.Color(0, 51, 102));
        btnConfirmarPacMod.setText("Confirmar cambios");
        btnConfirmarPacMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPacModActionPerformed(evt);
            }
        });

        btnCancelarPacMod.setBackground(new java.awt.Color(0, 51, 102));
        btnCancelarPacMod.setText("Cancelar");
        btnCancelarPacMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPacModActionPerformed(evt);
            }
        });

        campoModObSocPac.setBackground(new java.awt.Color(153, 204, 255));
        campoModObSocPac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        campoModObSocPac.setForeground(new java.awt.Color(0, 0, 0));
        campoModObSocPac.setText("Si tengo");

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
                .addGap(147, 147, 147)
                .addComponent(buscarModPac, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                .addGap(0, 113, Short.MAX_VALUE)
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
                            .addComponent(campoMailMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelModificarPacLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(noEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCancelarPacMod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmarPacMod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                .addContainerGap(93, Short.MAX_VALUE))
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
                .addGap(12, 12, 12)
                .addComponent(buscarModPac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(7, 7, 7)
                        .addGroup(jPanelModificarPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(obSocSig)
                            .addComponent(campoModObSocPac)))
                    .addComponent(separador))
                .addGap(55, 55, 55)
                .addComponent(btnConfirmarPacMod)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarPacMod)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jPanelModificarPro.setBackground(new java.awt.Color(153, 204, 255));
        jPanelModificarPro.setPreferredSize(new java.awt.Dimension(513, 704));

        nombreTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreTXT1.setForeground(new java.awt.Color(0, 0, 0));
        nombreTXT1.setText("default");

        apellidoSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        apellidoSig1.setForeground(new java.awt.Color(102, 102, 102));
        apellidoSig1.setText("Apellido");

        apellidoTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apellidoTXT1.setForeground(new java.awt.Color(0, 0, 0));
        apellidoTXT1.setText("default");

        dniSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        dniSig1.setForeground(new java.awt.Color(102, 102, 102));
        dniSig1.setText("DNI");

        modTelInput1.setBackground(new java.awt.Color(0, 102, 153));
        modTelInput1.setForeground(new java.awt.Color(255, 255, 255));
        modTelInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modTelInput1ActionPerformed(evt);
            }
        });

        dniTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dniTXT1.setForeground(new java.awt.Color(0, 0, 0));
        dniTXT1.setText("default");

        modMailInput1.setBackground(new java.awt.Color(0, 102, 153));
        modMailInput1.setForeground(new java.awt.Color(255, 255, 255));

        titulo1.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(0, 0, 0));
        titulo1.setText("Modificacion de profesional");

        telefonoSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        telefonoSig1.setForeground(new java.awt.Color(102, 102, 102));
        telefonoSig1.setText("Telefono");

        subtitulo1.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        subtitulo1.setForeground(new java.awt.Color(102, 102, 102));
        subtitulo1.setText("DNI");

        separador1.setBackground(new java.awt.Color(153, 204, 255));
        separador1.setForeground(new java.awt.Color(102, 102, 102));
        separador1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buscarModPro.setBackground(new java.awt.Color(0, 51, 102));
        buscarModPro.setText("Buscar");
        buscarModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarModProActionPerformed(evt);
            }
        });

        emailSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        emailSig1.setForeground(new java.awt.Color(102, 102, 102));
        emailSig1.setText("Email");

        campoDniProMod.setBackground(new java.awt.Color(0, 51, 102));
        campoDniProMod.setForeground(new java.awt.Color(255, 255, 255));
        campoDniProMod.setToolTipText("Ingrese el DNI");
        campoDniProMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDniProModActionPerformed(evt);
            }
        });

        noEncontro1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        noEncontro1.setForeground(new java.awt.Color(102, 102, 102));
        noEncontro1.setText("Paciente no encontrado");
        noEncontro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        matMod.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        matMod.setForeground(new java.awt.Color(102, 102, 102));
        matMod.setText("Matricula");

        nombreSig1.setFont(new java.awt.Font("Nirmala Text", 1, 14)); // NOI18N
        nombreSig1.setForeground(new java.awt.Color(102, 102, 102));
        nombreSig1.setText("Nombre");

        matriculaTXT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        matriculaTXT1.setForeground(new java.awt.Color(0, 0, 0));
        matriculaTXT1.setText("default");

        confirmarProbtn.setBackground(new java.awt.Color(0, 51, 102));
        confirmarProbtn.setText("Confirmar cambios");
        confirmarProbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarProbtnActionPerformed(evt);
            }
        });

        cancelarProbtn.setBackground(new java.awt.Color(0, 51, 102));
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
                        .addGap(59, 59, 59)
                        .addComponent(subtitulo1)
                        .addGap(23, 23, 23)
                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cancelarProbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(confirmarProbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelModificarProLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(noEncontro1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(campoDniProMod, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo1)))
                    .addGroup(jPanelModificarProLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(buscarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanelModificarProLayout.setVerticalGroup(
            jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarProLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(titulo1)
                .addGap(18, 18, 18)
                .addGroup(jPanelModificarProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDniProMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtitulo1))
                .addGap(18, 18, 18)
                .addComponent(buscarModPro)
                .addGap(11, 11, 11)
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
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanelBuscarProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelContarEstPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelBuscarMatPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelModificarPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelModificarPro, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanelBuscarProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelContarEstPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelBuscarMatPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanelModificarPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelModificarPro, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /////////////////////////////
    ////METODOS REUTILIZABLES////
    /////////////////////////////
    
    private boolean buscarPacDni(String dniBusqueda){
        return (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Paciente));
    }
    
    private boolean buscarProDni(String dniBusqueda){
        return (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Profesional));
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
      
    private void btnBuscarPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacActionPerformed
        String dniBusqueda = dniPacBuscarTxt.getText();
        if (buscarPacDni(dniBusqueda)){
                JOptionPane.showMessageDialog(this, "---Paciente encontrado---\n\n" + obtenerPac(dniBusqueda).mostrarDatos());
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
        this.dispose();
    }//GEN-LAST:event_btnBuscarPacActionPerformed

    private void dniPacBuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacBuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacBuscarTxtActionPerformed

    private void matProBuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProBuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProBuscarTxtActionPerformed

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        String dniBusqueda = matProBuscarTxt.getText();
        if (buscarProDni(dniBusqueda)){
                JOptionPane.showMessageDialog(this, "---Profesional encontrado---\n\n" + obtenerPro(dniBusqueda).mostrarDatos());
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun profesional con el dni " + dniBusqueda);
        }
        this.dispose();
    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void dniPacContarEstTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacContarEstTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniPacContarEstTxtActionPerformed

    private void btnContarEstPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContarEstPacActionPerformed
        String dniBusqueda = dniPacContarEstTxt.getText();
        if (buscarPacDni(dniBusqueda)){
                Paciente encontrada = (Paciente) mapaPersonas.get(dniBusqueda);
                PacienteController miPac = new PacienteController(encontrada);
                int cantEst = miPac.obtenerCantidadEstudios(listaEstudios);
                JOptionPane.showMessageDialog(this, "Paciente: " + miPac.muestraNombre() + " " + miPac.muestraApellido() + "\nDNI: " + dniBusqueda + "\nCantidad estudios: " + cantEst);
        }else{
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el dni " + dniBusqueda);
        }
        this.dispose();
    }//GEN-LAST:event_btnContarEstPacActionPerformed

    private void matProBuscartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProBuscartxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matProBuscartxtActionPerformed

    private void btnBuscarMatProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatProActionPerformed
        String matIngresada = matProBuscartxt.getText();
        boolean encontro = false;
        
        for (Persona p : mapaPersonas.values()){
            if (p instanceof Profesional pro){
                ProfesionalController miPro = new ProfesionalController(pro);
                
                if(miPro.muestraMatricula().equals(matIngresada)){
                    JOptionPane.showMessageDialog(this, "---Profesional encontrado---\n\n" + miPro.mostrarDatos());
                    encontro = true;break;
                }
            }
        }
        if (encontro == false){
            JOptionPane.showMessageDialog(this, "No se encontro profesional con matricula -" + matIngresada + "-");
        }
        this.dispose();
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
        PacienteController miPaciente = obtenerPac(dniTXT.getText());
        miPaciente.colocarTelefono(campoTelMod.getText());
        miPaciente.colocarEmail(campoMailMod.getText());
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
    }//GEN-LAST:event_btnConfirmarPacModActionPerformed

    private void modTelInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modTelInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modTelInput1ActionPerformed

    private void buscarModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarModProActionPerformed
        String dniBusqueda = campoDniProMod.getText();
        if (buscarProDni(dniBusqueda)){
            //Mostramos todo para modificar
            muestraOnoCamposModPro(true);
            nombreTXT1.setText(obtenerPro(dniBusqueda).muestraNombre());
            apellidoTXT1.setText(obtenerPro(dniBusqueda).muestraApellido());
            dniTXT1.setText(obtenerPro(dniBusqueda).muestraDni());
            modTelInput1.setText(obtenerPro(dniBusqueda).muestraTelefono());
            modMailInput1.setText(obtenerPro(dniBusqueda).muestraMail());
            matriculaTXT1.setText(obtenerPro(dniBusqueda).muestraMatricula());
        }
        else{
            muestraOnoCamposModPro(false);
            JOptionPane.showMessageDialog(this, "Profesional no encontrado.");
        }
    }//GEN-LAST:event_buscarModProActionPerformed

    private void campoDniProModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniProModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDniProModActionPerformed

    private void confirmarProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarProbtnActionPerformed
        ProfesionalController miProfesional = obtenerPro(dniTXT1.getText());
        miProfesional.colocarTelefono(modTelInput1.getText());
        miProfesional.colocarEmail(modMailInput1.getText());
        
        mapaPersonas.put(miProfesional.muestraDni(), miProfesional.ObtenerProfesional());
        muestraOnoCamposModPro(false);
        JOptionPane.showMessageDialog(this, "Profesional modificado correctamente.");
    }//GEN-LAST:event_confirmarProbtnActionPerformed

    private void btnCancelarPacModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPacModActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarPacModActionPerformed

    private void cancelarProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarProbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoSig;
    private javax.swing.JLabel apellidoSig1;
    private javax.swing.JLabel apellidoTXT;
    private javax.swing.JLabel apellidoTXT1;
    private javax.swing.JButton btnBuscarMatPro;
    private javax.swing.JButton btnBuscarPac;
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnCancelarPacMod;
    private javax.swing.JButton btnConfirmarPacMod;
    private javax.swing.JButton btnContarEstPac;
    private javax.swing.JButton buscarModPac;
    private javax.swing.JButton buscarModPro;
    private javax.swing.JTextField campoDniPac;
    private javax.swing.JTextField campoDniProMod;
    private javax.swing.JTextField campoMailMod;
    private javax.swing.JCheckBox campoModObSocPac;
    private javax.swing.JTextField campoTelMod;
    private javax.swing.JButton cancelarProbtn;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelBuscarMatPro;
    private javax.swing.JPanel jPanelBuscarPaciente;
    private javax.swing.JPanel jPanelBuscarProfesional;
    private javax.swing.JPanel jPanelContarEstPac;
    private javax.swing.JPanel jPanelModificarPac;
    private javax.swing.JPanel jPanelModificarPro;
    private javax.swing.JLabel matMod;
    private javax.swing.JTextField matProBuscarTxt;
    private javax.swing.JTextField matProBuscartxt;
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
    // End of variables declaration//GEN-END:variables

}
