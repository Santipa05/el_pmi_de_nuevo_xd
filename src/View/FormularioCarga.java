package View;

import Controller.EstudioController;
import Controller.PacienteController;
import Controller.PersonaController;
import Controller.ProfesionalController;
import Model.Estudio;
import Model.Fecha;
import Model.Paciente;
import Model.Persona;
import Model.Profesional;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FormularioCarga extends javax.swing.JFrame {

    private HashMap <String, Persona> mapaPersonas;
    private ArrayList<Estudio> listaEstudios;
    FondoPanel fondo = new FondoPanel();
    
      public FormularioCarga() {
            this.setContentPane(fondo);
            initComponents();
            setLocationRelativeTo(null);
            LocalDate fechaRe = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaRetxt.setText(fechaRe.format(formato));
      }
      
      public FormularioCarga(HashMap<String, Persona> mapaPersonas, ArrayList<Estudio> listaEstudios) {
        this();
        this.mapaPersonas = mapaPersonas;
        this.listaEstudios = listaEstudios;
    }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            PanelCargaPac = new javax.swing.JPanel();
            nombretxtPac = new javax.swing.JTextField();
            jLabel2 = new javax.swing.JLabel();
            apellidotxtPac = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            dnitxt = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            telefonotxtPac = new javax.swing.JTextField();
            jLabel5 = new javax.swing.JLabel();
            mailtxtPac = new javax.swing.JTextField();
            jLabel6 = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
            obSoc = new javax.swing.JCheckBox();
            jSeparator1 = new javax.swing.JSeparator();
            btnGuardarPaciente = new javax.swing.JButton();
            btnCancelar1 = new javax.swing.JButton();
            PanelCargaPro = new javax.swing.JPanel();
            titulo = new javax.swing.JLabel();
            nombretxt = new javax.swing.JTextField();
            nombreSig = new javax.swing.JLabel();
            apellidotxt = new javax.swing.JTextField();
            apellidoSig = new javax.swing.JLabel();
            matriculatxt = new javax.swing.JTextField();
            matriculaSig = new javax.swing.JLabel();
            telefonoProtxt = new javax.swing.JTextField();
            telefonoSig = new javax.swing.JLabel();
            emailProtxt = new javax.swing.JTextField();
            mailSig = new javax.swing.JLabel();
            separador = new javax.swing.JSeparator();
            btnGuardarProfesional = new javax.swing.JButton();
            dniProtxt = new javax.swing.JTextField();
            dniSig = new javax.swing.JLabel();
            btnCancelar2 = new javax.swing.JButton();
            PanelCargaEst = new javax.swing.JPanel();
            tituloEst = new javax.swing.JLabel();
            jSeparator2 = new javax.swing.JSeparator();
            jLabel8 = new javax.swing.JLabel();
            dniPacEst = new javax.swing.JTextField();
            jLabel7 = new javax.swing.JLabel();
            matProEst = new javax.swing.JTextField();
            jLabel9 = new javax.swing.JLabel();
            fechaEnt = new javax.swing.JSpinner();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            estado = new javax.swing.JComboBox<>();
            jLabel12 = new javax.swing.JLabel();
            estudiosScroll = new javax.swing.JScrollPane();
            estudiosList = new javax.swing.JList<>();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            btnCargarEstudio = new javax.swing.JButton();
            fechaRetxt = new javax.swing.JLabel();
            btnCancelar3 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);

            PanelCargaPac.setBackground(new java.awt.Color(153, 204, 255));
            PanelCargaPac.setOpaque(false);

            nombretxtPac.setBackground(new java.awt.Color(51, 51, 51));
            nombretxtPac.setForeground(new java.awt.Color(255, 255, 255));
            nombretxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nombretxtPacActionPerformed(evt);
                  }
            });
            nombretxtPac.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        nombretxtPacKeyTyped(evt);
                  }
            });

            jLabel2.setBackground(java.awt.Color.white);
            jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("Nombre");

            apellidotxtPac.setBackground(new java.awt.Color(51, 51, 51));
            apellidotxtPac.setForeground(new java.awt.Color(255, 255, 255));
            apellidotxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        apellidotxtPacActionPerformed(evt);
                  }
            });
            apellidotxtPac.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        apellidotxtPacKeyTyped(evt);
                  }
            });

            jLabel3.setBackground(java.awt.Color.yellow);
            jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Apellido");

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

            jLabel4.setBackground(java.awt.Color.white);
            jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(255, 255, 255));
            jLabel4.setText("DNI");

            telefonotxtPac.setBackground(new java.awt.Color(51, 51, 51));
            telefonotxtPac.setForeground(new java.awt.Color(255, 255, 255));
            telefonotxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        telefonotxtPacActionPerformed(evt);
                  }
            });
            telefonotxtPac.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        telefonotxtPacKeyTyped(evt);
                  }
            });

            jLabel5.setBackground(java.awt.Color.white);
            jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setText("Telefono");

            mailtxtPac.setBackground(new java.awt.Color(51, 51, 51));
            mailtxtPac.setForeground(new java.awt.Color(255, 255, 255));
            mailtxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mailtxtPacActionPerformed(evt);
                  }
            });
            mailtxtPac.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        mailtxtPacKeyTyped(evt);
                  }
            });

            jLabel6.setBackground(java.awt.Color.white);
            jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(255, 255, 255));
            jLabel6.setText("Email");

            jLabel1.setBackground(java.awt.Color.white);
            jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Formulario Paciente");

            obSoc.setBackground(new java.awt.Color(153, 204, 255));
            obSoc.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            obSoc.setForeground(new java.awt.Color(255, 255, 255));
            obSoc.setText("Obra Social");
            obSoc.setContentAreaFilled(false);
            obSoc.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        obSocActionPerformed(evt);
                  }
            });

            jSeparator1.setBackground(new java.awt.Color(153, 204, 255));
            jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnGuardarPaciente.setBackground(new java.awt.Color(0, 51, 102));
            btnGuardarPaciente.setForeground(new java.awt.Color(255, 255, 255));
            btnGuardarPaciente.setText("Cargar");
            btnGuardarPaciente.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnGuardarPacienteActionPerformed(evt);
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

            javax.swing.GroupLayout PanelCargaPacLayout = new javax.swing.GroupLayout(PanelCargaPac);
            PanelCargaPac.setLayout(PanelCargaPacLayout);
            PanelCargaPacLayout.setHorizontalGroup(
                  PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaPacLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(jLabel1)
                              .addGroup(PanelCargaPacLayout.createSequentialGroup()
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                          .addComponent(jLabel5)
                                          .addComponent(jLabel6)
                                          .addComponent(jLabel4)
                                          .addComponent(jLabel2)
                                          .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(mailtxtPac)
                                          .addComponent(telefonotxtPac)
                                          .addComponent(dnitxt)
                                          .addComponent(apellidotxtPac)
                                          .addComponent(nombretxtPac, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(obSoc))))
                        .addGap(108, 108, 108))
                  .addGroup(PanelCargaPacLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(btnGuardarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addContainerGap(143, Short.MAX_VALUE))
            );
            PanelCargaPacLayout.setVerticalGroup(
                  PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaPacLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(PanelCargaPacLayout.createSequentialGroup()
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombretxtPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidotxtPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel4))
                                    .addGap(8, 8, 8)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(telefonotxtPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(mailtxtPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel6)))
                              .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obSoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar1)
                        .addContainerGap(191, Short.MAX_VALUE))
            );

            PanelCargaPro.setBackground(new java.awt.Color(153, 204, 255));
            PanelCargaPro.setOpaque(false);

            titulo.setBackground(new java.awt.Color(0, 0, 0));
            titulo.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            titulo.setForeground(new java.awt.Color(255, 255, 255));
            titulo.setText("Formulario Profesional");

            nombretxt.setBackground(new java.awt.Color(51, 51, 51));
            nombretxt.setForeground(new java.awt.Color(255, 255, 255));
            nombretxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nombretxtActionPerformed(evt);
                  }
            });
            nombretxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        nombretxtKeyTyped(evt);
                  }
            });

            nombreSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            nombreSig.setForeground(new java.awt.Color(153, 153, 153));
            nombreSig.setText("Nombre");

            apellidotxt.setBackground(new java.awt.Color(51, 51, 51));
            apellidotxt.setForeground(new java.awt.Color(255, 255, 255));
            apellidotxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        apellidotxtActionPerformed(evt);
                  }
            });
            apellidotxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        apellidotxtKeyTyped(evt);
                  }
            });

            apellidoSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            apellidoSig.setForeground(new java.awt.Color(153, 153, 153));
            apellidoSig.setText("Apellido");

            matriculatxt.setBackground(new java.awt.Color(51, 51, 51));
            matriculatxt.setForeground(new java.awt.Color(255, 255, 255));
            matriculatxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matriculatxtActionPerformed(evt);
                  }
            });
            matriculatxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        matriculatxtKeyTyped(evt);
                  }
            });

            matriculaSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            matriculaSig.setForeground(new java.awt.Color(153, 153, 153));
            matriculaSig.setText("Matricula");

            telefonoProtxt.setBackground(new java.awt.Color(51, 51, 51));
            telefonoProtxt.setForeground(new java.awt.Color(255, 255, 255));
            telefonoProtxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        telefonoProtxtActionPerformed(evt);
                  }
            });
            telefonoProtxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        telefonoProtxtKeyTyped(evt);
                  }
            });

            telefonoSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            telefonoSig.setForeground(new java.awt.Color(153, 153, 153));
            telefonoSig.setText("Telefono");

            emailProtxt.setBackground(new java.awt.Color(51, 51, 51));
            emailProtxt.setForeground(new java.awt.Color(255, 255, 255));
            emailProtxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        emailProtxtActionPerformed(evt);
                  }
            });
            emailProtxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        emailProtxtKeyTyped(evt);
                  }
            });

            mailSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            mailSig.setForeground(new java.awt.Color(153, 153, 153));
            mailSig.setText("Email");

            separador.setBackground(new java.awt.Color(153, 204, 255));
            separador.setForeground(new java.awt.Color(102, 102, 102));
            separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnGuardarProfesional.setBackground(new java.awt.Color(0, 51, 102));
            btnGuardarProfesional.setForeground(new java.awt.Color(255, 255, 255));
            btnGuardarProfesional.setText("Cargar");
            btnGuardarProfesional.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnGuardarProfesionalActionPerformed(evt);
                  }
            });

            dniProtxt.setBackground(new java.awt.Color(51, 51, 51));
            dniProtxt.setForeground(new java.awt.Color(255, 255, 255));
            dniProtxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniProtxtActionPerformed(evt);
                  }
            });
            dniProtxt.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniProtxtKeyTyped(evt);
                  }
            });

            dniSig.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            dniSig.setForeground(new java.awt.Color(153, 153, 153));
            dniSig.setText("DNI");

            btnCancelar2.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelar2.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelar2.setText("Volver");
            btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelar2ActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout PanelCargaProLayout = new javax.swing.GroupLayout(PanelCargaPro);
            PanelCargaPro.setLayout(PanelCargaProLayout);
            PanelCargaProLayout.setHorizontalGroup(
                  PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaProLayout.createSequentialGroup()
                        .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(PanelCargaProLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(titulo))
                              .addGroup(PanelCargaProLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(telefonoSig)
                                          .addComponent(mailSig)
                                          .addComponent(matriculaSig)
                                          .addComponent(dniSig)
                                          .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(nombreSig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(apellidoSig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(22, 22, 22)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(emailProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(dniProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(telefonoProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(matriculatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGroup(PanelCargaProLayout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(btnGuardarProfesional, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                          .addComponent(btnCancelar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(102, Short.MAX_VALUE))
            );
            PanelCargaProLayout.setVerticalGroup(
                  PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaProLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(PanelCargaProLayout.createSequentialGroup()
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(nombreSig))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(apellidoSig)
                                          .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(matriculaSig)
                                          .addComponent(matriculatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(telefonoSig)
                                          .addComponent(telefonoProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(mailSig)
                                          .addComponent(emailProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(dniProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(dniSig)))
                              .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(btnGuardarProfesional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar2)
                        .addContainerGap(90, Short.MAX_VALUE))
            );

            PanelCargaEst.setBackground(new java.awt.Color(153, 204, 255));
            PanelCargaEst.setOpaque(false);
            PanelCargaEst.setPreferredSize(new java.awt.Dimension(380, 500));

            tituloEst.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
            tituloEst.setForeground(new java.awt.Color(255, 255, 255));
            tituloEst.setText("Formulario estudio");

            jSeparator2.setBackground(new java.awt.Color(153, 204, 255));
            jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

            jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setText("DNI del paciente");

            dniPacEst.setBackground(new java.awt.Color(51, 51, 51));
            dniPacEst.setForeground(new java.awt.Color(255, 255, 255));
            dniPacEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPacEstActionPerformed(evt);
                  }
            });
            dniPacEst.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniPacEstKeyTyped(evt);
                  }
            });

            jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(255, 255, 255));
            jLabel7.setText("Matricula del profesional");

            matProEst.setBackground(new java.awt.Color(51, 51, 51));
            matProEst.setForeground(new java.awt.Color(255, 255, 255));
            matProEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matProEstActionPerformed(evt);
                  }
            });
            matProEst.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyTyped(java.awt.event.KeyEvent evt) {
                        matProEstKeyTyped(evt);
                  }
            });

            jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("Fecha de realizacion");

            fechaEnt.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), new java.util.Date(1924997820000L), java.util.Calendar.DAY_OF_MONTH));
            fechaEnt.setEditor(new javax.swing.JSpinner.DateEditor(fechaEnt, "dd/MM/yyyy"));

            jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(255, 255, 255));
            jLabel10.setText("Fecha de entrega");

            jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel11.setForeground(new java.awt.Color(255, 255, 255));
            jLabel11.setText("Estado");

            estado.setBackground(new java.awt.Color(51, 51, 51));
            estado.setForeground(new java.awt.Color(255, 255, 255));
            estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
            estado.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoActionPerformed(evt);
                  }
            });

            jLabel12.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel12.setForeground(new java.awt.Color(255, 255, 255));
            jLabel12.setText("Estudios");

            estudiosList.setBackground(new java.awt.Color(51, 51, 51));
            estudiosList.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            estudiosList.setForeground(new java.awt.Color(255, 255, 255));
            estudiosList.setModel(new javax.swing.AbstractListModel<String>() {
                  String[] strings = { "Hemograma completo", "Glucemia", "Colesterol total", "Orina completa", "Uremia", "Creatinemia", "Hepatograma", "Perfil lipidico", "Grupo y factor", "Coagulograma" };
                  public int getSize() { return strings.length; }
                  public String getElementAt(int i) { return strings[i]; }
            });
            estudiosList.setSelectionBackground(new java.awt.Color(38, 85, 108));
            estudiosList.setSelectionForeground(new java.awt.Color(255, 255, 255));
            estudiosScroll.setViewportView(estudiosList);

            jLabel13.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel13.setForeground(new java.awt.Color(255, 255, 255));
            jLabel13.setText("Mantenga presionado");

            jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel14.setForeground(new java.awt.Color(255, 255, 255));
            jLabel14.setText("control para elegir");

            jLabel15.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            jLabel15.setForeground(new java.awt.Color(255, 255, 255));
            jLabel15.setText("mas de uno");

            btnCargarEstudio.setBackground(new java.awt.Color(0, 51, 102));
            btnCargarEstudio.setForeground(new java.awt.Color(255, 255, 255));
            btnCargarEstudio.setText("Cargar");
            btnCargarEstudio.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCargarEstudioActionPerformed(evt);
                  }
            });

            fechaRetxt.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
            fechaRetxt.setForeground(new java.awt.Color(255, 255, 255));
            fechaRetxt.setText("default");

            btnCancelar3.setBackground(new java.awt.Color(0, 51, 102));
            btnCancelar3.setForeground(new java.awt.Color(255, 255, 255));
            btnCancelar3.setText("Volver");
            btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCancelar3ActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout PanelCargaEstLayout = new javax.swing.GroupLayout(PanelCargaEst);
            PanelCargaEst.setLayout(PanelCargaEstLayout);
            PanelCargaEstLayout.setHorizontalGroup(
                  PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaEstLayout.createSequentialGroup()
                        .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                      .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel9)
                                                            .addComponent(jLabel10)
                                                            .addComponent(jLabel11)
                                                            .addComponent(jLabel13)
                                                            .addComponent(jLabel15)
                                                            .addComponent(jLabel8))
                                                      .addGap(33, 33, 33))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCargaEstLayout.createSequentialGroup()
                                                      .addComponent(jLabel7)
                                                      .addGap(18, 18, 18)))
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(jLabel14)
                                                      .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(dniPacEst)
                                          .addComponent(matProEst)
                                          .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(estudiosScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                          .addComponent(fechaRetxt)))
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(tituloEst))
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGap(141, 141, 141)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(btnCancelar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(btnCargarEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            PanelCargaEstLayout.setVerticalGroup(
                  PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCargaEstLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tituloEst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(jLabel8)
                                          .addComponent(dniPacEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(matProEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jLabel7))
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(jLabel11)
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15))
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(fechaRetxt)
                                                      .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(estudiosScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                              .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarEstudio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar3)
                        .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(PanelCargaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(PanelCargaPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(PanelCargaEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(PanelCargaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(PanelCargaPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(PanelCargaEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents
      
      //metodos auxiliares
      
    private boolean buscarPacDni(String dniBusqueda){
        return (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Paciente));
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
    
      
      //Este metodo hace que aparezca solo el panel correcto
      //evitando que se superpongan
      
      public void metAux(int op){
            if(op == 0){
                  PanelCargaPac.setVisible(true);
                  PanelCargaPac.setEnabled(true);
                  PanelCargaPro.setVisible(false);
                  PanelCargaPro.setEnabled(false);
                  PanelCargaEst.setVisible(false);
                  PanelCargaEst.setEnabled(false);
            } else if(op == 1){
                  PanelCargaPro.setVisible(true);
                  PanelCargaPro.setEnabled(true);
                  PanelCargaPac.setVisible(false);
                  PanelCargaPac.setEnabled(false);
                  PanelCargaEst.setVisible(false);
                  PanelCargaEst.setEnabled(false);
            } else{
                  PanelCargaEst.setVisible(true);
                  PanelCargaEst.setEnabled(true);
                  PanelCargaPro.setVisible(false);
                  PanelCargaPro.setEnabled(false);
                  PanelCargaPac.setVisible(false);
                  PanelCargaPac.setEnabled(false);
            }
            this.revalidate();
            this.repaint();
      }
      
      
      private boolean validarDatosBase(String nombre, String apellido, String dni, String email, String telefono) {
        //Control campos vacios
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
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
        //Control de DNI (Clave unica en el mapa)
        if (mapaPersonas.containsKey(dni)) {
            JOptionPane.showMessageDialog(this, "Error: El DNI ya se encuentra registrado en el sistema.");
            return false;
        }
        //Control de Teléfono y Email
        for (Persona p : mapaPersonas.values()) {
            PersonaController pc = new PersonaController(p);
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
      
      private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_nombretxtActionPerformed

      private void telefonoProtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoProtxtActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_telefonoProtxtActionPerformed

    private void matriculatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculatxtActionPerformed

      private void apellidotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidotxtActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_apellidotxtActionPerformed

      private void nombretxtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtPacActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_nombretxtPacActionPerformed

      private void apellidotxtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidotxtPacActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_apellidotxtPacActionPerformed

      private void telefonotxtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonotxtPacActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_telefonotxtPacActionPerformed

      private void dniPacEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniPacEstActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_dniPacEstActionPerformed

      private void matProEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matProEstActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_matProEstActionPerformed

    private void btnGuardarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPacienteActionPerformed

        //Captura de datos
        String nombre = nombretxtPac.getText().trim();
        String apellido = apellidotxtPac.getText().trim();
        String dni = dnitxt.getText().trim();
        String email = mailtxtPac.getText().trim();
        String telefono = telefonotxtPac.getText().trim();
        //validacion general
        if (validarDatosBase(nombre, apellido, dni, email, telefono)) {
            Paciente pa = new Paciente();
            PacienteController miPaciente = new PacienteController(pa);
            miPaciente.colocarNombre(nombre);
            miPaciente.colocarApellido(apellido);
            miPaciente.colocarDni(dni);
            miPaciente.colocarEmail(email);
            miPaciente.colocarTelefono(telefono);
            miPaciente.colocarObraSocial(obSoc.isSelected());
            mapaPersonas.put(miPaciente.muestraDni(), miPaciente.obtenerPaciente());
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter("archivos/archivoPacientes.txt", true))){
                  escritor.append(nombre + "\n");
                  escritor.append(apellido + "\n");
                  escritor.append(dni + "\n");
                  escritor.append(email + "\n");
                  escritor.append(telefono + "\n");
                  if (obSoc.isSelected())
                        escritor.append("true\n\n");
                  else
                        escritor.append("false\n\n");
            } catch (FileNotFoundException e){
                  JOptionPane.showMessageDialog(this, "Error, no se encontro el archivo correspondiente. Codigo: " + e.getMessage());
            } catch(IOException e){
                  JOptionPane.showMessageDialog(this, "Error al abrir el archivo. " + e.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Paciente cargado correctamente");
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarPacienteActionPerformed

    private void dnitxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnitxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnitxtActionPerformed

    private void mailtxtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailtxtPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailtxtPacActionPerformed

    private void obSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obSocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obSocActionPerformed

    private void btnGuardarProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProfesionalActionPerformed
        // Captura de datos
        String nombre = nombretxt.getText().trim();
        String apellido = apellidotxt.getText().trim();
        String dni = dniProtxt.getText().trim();
        String email = emailProtxt.getText().trim();
        String telefono = telefonoProtxt.getText().trim();
        String matricula = matriculatxt.getText().trim();
        // Validamos primero los datos que comparten todas las personas
        if (validarDatosBase(nombre, apellido,dni, email, telefono)) {
            // Validamos el dato matricula
            if (buscarProMat(matricula)) {
                JOptionPane.showMessageDialog(this, "La matrícula ya se encuentra registrada.");
            }else {
                Profesional pr = new Profesional();
                ProfesionalController miProfesional = new ProfesionalController(pr);
                miProfesional.colocarNombre(nombre);
                miProfesional.colocarApellido(apellido);
                miProfesional.colocarDni(dni);
                miProfesional.colocarEmail(email);
                miProfesional.colocarTelefono(telefono);
                miProfesional.colocarMatricula(matricula);
                mapaPersonas.put(miProfesional.muestraDni(), miProfesional.ObtenerProfesional());
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter("archivos/archivoProfesionales.txt", true))){
                  escritor.append(nombre + "\n");
                  escritor.append(apellido + "\n");
                  escritor.append(dni + "\n");
                  escritor.append(telefono + "\n");
                  escritor.append(email + "\n");
                  escritor.append(matricula + "\n");
            } catch (FileNotFoundException e){
                  JOptionPane.showMessageDialog(this, "Error, no se encontro el archivo correspondiente. Codigo: " + e.getMessage());
            } catch(IOException e){
                  JOptionPane.showMessageDialog(this, "Error al abrir el archivo. " + e.getMessage());
            }
                JOptionPane.showMessageDialog(this, "Profesional cargado correctamente");
            }
        }
    }//GEN-LAST:event_btnGuardarProfesionalActionPerformed

    private void btnCargarEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarEstudioActionPerformed
      
      //Control de que no este repetido
      
          if(!buscarProMat(matProEst.getText())){
                JOptionPane.showMessageDialog(this, "-Error. El profesional no fue encontrado-\n\n");
                return;
          }
          if(!buscarPacDni(dniPacEst.getText())){
                JOptionPane.showMessageDialog(this, "-Error. El paciente no fue encontrado-\n\n");
                return;
          }
          //Control de que seleccione almenos un estudio
          
          int cantSel = estudiosList.getSelectedValuesList().size();
          if(cantSel == 0){
                JOptionPane.showMessageDialog(this, "Error. Debe seleccionar almenos un estudio\n\n");
                return;
          }
            //Crea objeto date para leer fecha ingresada
            LocalDate fechaRe = LocalDate.now();
            java.util.Date dateEntrega = (java.util.Date) fechaEnt.getValue();
            //Crea cal para extraer dia, mes y anio
            java.util.Calendar cal2 = java.util.Calendar.getInstance();
            cal2.setTime(dateEntrega);
            int diaR = fechaRe.getDayOfMonth();
            int mesR = fechaRe.getMonthValue();
            int anioR = fechaRe.getYear();
            int diaE = cal2.get(java.util.Calendar.DAY_OF_MONTH);
            int mesE = cal2.get(java.util.Calendar.MONTH) + 1;
            int anioE = cal2.get(java.util.Calendar.YEAR);
           //Creo fecha
            Fecha fechaR = new Fecha(diaR, mesR, anioR);
            Fecha fechaE = new Fecha(diaE, mesE, anioE);
            
            Estudio est = new Estudio();
            EstudioController miEstudio = new EstudioController(est);
            miEstudio.ColocarDniPaciente(dniPacEst.getText().trim());
            miEstudio.ColocarMatricula(matProEst.getText().trim());
            miEstudio.ColocarFechaRealizacion(fechaR);
            miEstudio.ColocarFechaEntrega(fechaE);
            miEstudio.ColocarEstado(estado.getSelectedItem().toString());
            
            int[] seleccionados = estudiosList.getSelectedIndices(); //Extraigo ids y los guardo en una lista (idsanalisis)
            ArrayList <Integer> idsAnalisis = new ArrayList<>(); //Creo la lista de ids para poder setear los analisis
            for (int i : seleccionados){
                idsAnalisis.add(i);
            }
            miEstudio.colocarAnalisisRealizados(idsAnalisis);
            //Finalmente guardamos el estudio en la lista global
            listaEstudios.add(miEstudio.obtenerEstudio());
            
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter("archivos/archivoEstudios.txt", true))){
                  escritor.append(dniPacEst.getText() + "\n");
                  escritor.append(matProEst.getText() + "\n");
                  escritor.append(estado.getSelectedItem().toString() + "\n");
                  escritor.append(diaR + "\n");
                  escritor.append(mesR + "\n");
                  escritor.append(anioR + "\n");
                  escritor.append(diaE + "\n");
                  escritor.append(mesE + "\n");
                  escritor.append(anioE + "\n");
                  StringBuilder sb = new StringBuilder();
                  for (int i = 0; i < idsAnalisis.size(); i++){
                        sb.append(idsAnalisis.get(i));
                        if (i < idsAnalisis.size() - 1)
                              sb.append(";");
                  }
                  escritor.append(sb.toString() + "\n\n");
            } catch (FileNotFoundException e){
                  JOptionPane.showMessageDialog(this, "Error, no se encontro el archivo correspondiente. Codigo: " + e.getMessage());
            } catch(IOException e){
                  JOptionPane.showMessageDialog(this, "Error al abrir el archivo. " + e.getMessage());
            }
            this.dispose();
    }//GEN-LAST:event_btnCargarEstudioActionPerformed

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void emailProtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailProtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailProtxtActionPerformed

      private void dniPacEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniPacEstKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniPacEstKeyTyped

      private void matProEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matProEstKeyTyped
             char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matProEstKeyTyped

      private void matriculatxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matriculatxtKeyTyped
             char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_matriculatxtKeyTyped

      private void telefonoProtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoProtxtKeyTyped
             char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_telefonoProtxtKeyTyped

      private void dniProtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniProtxtKeyTyped
             char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dniProtxtKeyTyped

      private void nombretxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtKeyTyped
             char c = evt.getKeyChar();
            if(!(Character.isLetter(c) || c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_SPACE)){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_nombretxtKeyTyped

      private void apellidotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotxtKeyTyped
            char c = evt.getKeyChar();
            if(!(Character.isLetter(c) || c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_SPACE)){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_apellidotxtKeyTyped
                                    

      private void apellidotxtPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotxtPacKeyTyped
            char c = evt.getKeyChar();
            if(!(Character.isLetter(c) || c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_SPACE)){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_apellidotxtPacKeyTyped

      private void dnitxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dnitxtKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_dnitxtKeyTyped

      private void telefonotxtPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonotxtPacKeyTyped
            char c = evt.getKeyChar();
            if(!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
      }//GEN-LAST:event_telefonotxtPacKeyTyped

      private void mailtxtPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailtxtPacKeyTyped
            char c = evt.getKeyChar();
            if(c == java.awt.event.KeyEvent.VK_SPACE)
                  evt.consume();
      }//GEN-LAST:event_mailtxtPacKeyTyped

      private void emailProtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailProtxtKeyTyped
            char c = evt.getKeyChar();
            if(c == java.awt.event.KeyEvent.VK_SPACE)
                  evt.consume();
      }//GEN-LAST:event_emailProtxtKeyTyped

    private void dniProtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniProtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniProtxtActionPerformed

    private void nombretxtPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtPacKeyTyped
        char c = evt.getKeyChar();
            if(!(Character.isLetter(c) || c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_SPACE)){
                  evt.consume();
                  java.awt.Toolkit.getDefaultToolkit().beep();
            }
    }//GEN-LAST:event_nombretxtPacKeyTyped

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar3ActionPerformed

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel PanelCargaEst;
      private javax.swing.JPanel PanelCargaPac;
      private javax.swing.JPanel PanelCargaPro;
      private javax.swing.JLabel apellidoSig;
      private javax.swing.JTextField apellidotxt;
      private javax.swing.JTextField apellidotxtPac;
      private javax.swing.JButton btnCancelar1;
      private javax.swing.JButton btnCancelar2;
      private javax.swing.JButton btnCancelar3;
      private javax.swing.JButton btnCargarEstudio;
      private javax.swing.JButton btnGuardarPaciente;
      private javax.swing.JButton btnGuardarProfesional;
      private javax.swing.JTextField dniPacEst;
      private javax.swing.JTextField dniProtxt;
      private javax.swing.JLabel dniSig;
      private javax.swing.JTextField dnitxt;
      private javax.swing.JTextField emailProtxt;
      private javax.swing.JComboBox<String> estado;
      private javax.swing.JList<String> estudiosList;
      private javax.swing.JScrollPane estudiosScroll;
      private javax.swing.JSpinner fechaEnt;
      public javax.swing.JLabel fechaRetxt;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel10;
      private javax.swing.JLabel jLabel11;
      private javax.swing.JLabel jLabel12;
      private javax.swing.JLabel jLabel13;
      private javax.swing.JLabel jLabel14;
      private javax.swing.JLabel jLabel15;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private javax.swing.JLabel jLabel8;
      private javax.swing.JLabel jLabel9;
      private javax.swing.JSeparator jSeparator1;
      private javax.swing.JSeparator jSeparator2;
      private javax.swing.JLabel mailSig;
      private javax.swing.JTextField mailtxtPac;
      private javax.swing.JTextField matProEst;
      private javax.swing.JLabel matriculaSig;
      private javax.swing.JTextField matriculatxt;
      private javax.swing.JLabel nombreSig;
      private javax.swing.JTextField nombretxt;
      private javax.swing.JTextField nombretxtPac;
      private javax.swing.JCheckBox obSoc;
      private javax.swing.JSeparator separador;
      private javax.swing.JTextField telefonoProtxt;
      private javax.swing.JLabel telefonoSig;
      private javax.swing.JTextField telefonotxtPac;
      private javax.swing.JLabel titulo;
      private javax.swing.JLabel tituloEst;
      // End of variables declaration//GEN-END:variables
}
