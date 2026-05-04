package View;

import CRUDPMI.PMI;
import Controller.EstudioController;
import Controller.PacienteController;
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

public class FormularioCarga extends javax.swing.JFrame {

    private HashMap <String, Persona> mapaPersonas;
    private ArrayList<Estudio> listaEstudios;
    private String modoActual; //Paciente profesional o estudio
    
      public FormularioCarga() {
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
            btnGuardarPersona = new javax.swing.JButton();
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
            btnGuardarPersona1 = new javax.swing.JButton();
            dniProtxt = new javax.swing.JTextField();
            dniSig = new javax.swing.JLabel();
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
            dniProEst = new javax.swing.JTextField();
            jLabel16 = new javax.swing.JLabel();
            fechaRetxt = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setResizable(false);

            PanelCargaPac.setBackground(new java.awt.Color(153, 204, 255));

            nombretxtPac.setBackground(new java.awt.Color(0, 51, 102));
            nombretxtPac.setForeground(new java.awt.Color(255, 255, 255));
            nombretxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nombretxtPacActionPerformed(evt);
                  }
            });

            jLabel2.setForeground(new java.awt.Color(102, 102, 102));
            jLabel2.setText("Nombre");

            apellidotxtPac.setBackground(new java.awt.Color(0, 51, 102));
            apellidotxtPac.setForeground(new java.awt.Color(255, 255, 255));
            apellidotxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        apellidotxtPacActionPerformed(evt);
                  }
            });

            jLabel3.setForeground(new java.awt.Color(102, 102, 102));
            jLabel3.setText("Apellido");

            dnitxt.setBackground(new java.awt.Color(0, 51, 102));
            dnitxt.setForeground(new java.awt.Color(255, 255, 255));
            dnitxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dnitxtActionPerformed(evt);
                  }
            });

            jLabel4.setForeground(new java.awt.Color(102, 102, 102));
            jLabel4.setText("DNI");

            telefonotxtPac.setBackground(new java.awt.Color(0, 51, 102));
            telefonotxtPac.setForeground(new java.awt.Color(255, 255, 255));
            telefonotxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        telefonotxtPacActionPerformed(evt);
                  }
            });

            jLabel5.setForeground(new java.awt.Color(102, 102, 102));
            jLabel5.setText("Telefono");

            mailtxtPac.setBackground(new java.awt.Color(0, 51, 102));
            mailtxtPac.setForeground(new java.awt.Color(255, 255, 255));
            mailtxtPac.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mailtxtPacActionPerformed(evt);
                  }
            });

            jLabel6.setForeground(new java.awt.Color(102, 102, 102));
            jLabel6.setText("Email");

            jLabel1.setBackground(new java.awt.Color(0, 0, 0));
            jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(0, 0, 0));
            jLabel1.setText("Formulario Paciente");

            obSoc.setBackground(new java.awt.Color(153, 204, 255));
            obSoc.setForeground(new java.awt.Color(0, 0, 0));
            obSoc.setText("Obra Social");
            obSoc.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        obSocActionPerformed(evt);
                  }
            });

            jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnGuardarPersona.setText("Cargar");
            btnGuardarPersona.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnGuardarPersonaActionPerformed(evt);
                  }
            });

            javax.swing.GroupLayout PanelCargaPacLayout = new javax.swing.GroupLayout(PanelCargaPac);
            PanelCargaPac.setLayout(PanelCargaPacLayout);
            PanelCargaPacLayout.setHorizontalGroup(
                  PanelCargaPacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaPacLayout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
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
                        .addComponent(btnGuardarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnGuardarPersona)
                        .addContainerGap(228, Short.MAX_VALUE))
            );

            PanelCargaPro.setBackground(new java.awt.Color(153, 204, 255));

            titulo.setBackground(new java.awt.Color(0, 0, 0));
            titulo.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
            titulo.setForeground(new java.awt.Color(0, 0, 0));
            titulo.setText("Formulario Profesional");

            nombretxt.setBackground(new java.awt.Color(0, 51, 102));
            nombretxt.setForeground(new java.awt.Color(255, 255, 255));
            nombretxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nombretxtActionPerformed(evt);
                  }
            });

            nombreSig.setForeground(new java.awt.Color(102, 102, 102));
            nombreSig.setText("Nombre");

            apellidotxt.setBackground(new java.awt.Color(0, 51, 102));
            apellidotxt.setForeground(new java.awt.Color(255, 255, 255));
            apellidotxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        apellidotxtActionPerformed(evt);
                  }
            });

            apellidoSig.setForeground(new java.awt.Color(102, 102, 102));
            apellidoSig.setText("Apellido");

            matriculatxt.setBackground(new java.awt.Color(0, 51, 102));
            matriculatxt.setForeground(new java.awt.Color(255, 255, 255));
            matriculatxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matriculatxtActionPerformed(evt);
                  }
            });

            matriculaSig.setForeground(new java.awt.Color(102, 102, 102));
            matriculaSig.setText("Matricula");

            telefonoProtxt.setBackground(new java.awt.Color(0, 51, 102));
            telefonoProtxt.setForeground(new java.awt.Color(255, 255, 255));
            telefonoProtxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        telefonoProtxtActionPerformed(evt);
                  }
            });

            telefonoSig.setForeground(new java.awt.Color(102, 102, 102));
            telefonoSig.setText("Telefono");

            emailProtxt.setBackground(new java.awt.Color(0, 51, 102));
            emailProtxt.setForeground(new java.awt.Color(255, 255, 255));
            emailProtxt.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        emailProtxtActionPerformed(evt);
                  }
            });

            mailSig.setForeground(new java.awt.Color(102, 102, 102));
            mailSig.setText("Email");

            separador.setForeground(new java.awt.Color(102, 102, 102));
            separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

            btnGuardarPersona1.setText("Cargar");
            btnGuardarPersona1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnGuardarPersona1ActionPerformed(evt);
                  }
            });

            dniProtxt.setBackground(new java.awt.Color(0, 51, 102));
            dniProtxt.setForeground(new java.awt.Color(255, 255, 255));

            dniSig.setForeground(new java.awt.Color(102, 102, 102));
            dniSig.setText("DNI");

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
                                          .addComponent(nombreSig, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(telefonoSig)
                                          .addComponent(apellidoSig)
                                          .addComponent(mailSig)
                                          .addComponent(matriculaSig)
                                          .addComponent(dniSig))
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
                                    .addComponent(btnGuardarPersona1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(90, Short.MAX_VALUE))
            );
            PanelCargaProLayout.setVerticalGroup(
                  PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaProLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                          .addComponent(emailProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCargaProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(dniProtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(dniSig))
                        .addGap(48, 48, 48)
                        .addComponent(btnGuardarPersona1)
                        .addContainerGap(123, Short.MAX_VALUE))
            );

            PanelCargaEst.setBackground(new java.awt.Color(153, 204, 255));
            PanelCargaEst.setPreferredSize(new java.awt.Dimension(380, 500));

            tituloEst.setFont(new java.awt.Font("Nirmala Text", 1, 18)); // NOI18N
            tituloEst.setForeground(new java.awt.Color(0, 0, 0));
            tituloEst.setText("Formulario estudio");

            jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
            jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

            jLabel8.setForeground(new java.awt.Color(102, 102, 102));
            jLabel8.setText("DNI del paciente");

            dniPacEst.setBackground(new java.awt.Color(0, 51, 102));
            dniPacEst.setForeground(new java.awt.Color(255, 255, 255));
            dniPacEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniPacEstActionPerformed(evt);
                  }
            });

            jLabel7.setForeground(new java.awt.Color(102, 102, 102));
            jLabel7.setText("Matricula del profesional");

            matProEst.setBackground(new java.awt.Color(0, 51, 102));
            matProEst.setForeground(new java.awt.Color(255, 255, 255));
            matProEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        matProEstActionPerformed(evt);
                  }
            });

            jLabel9.setForeground(new java.awt.Color(102, 102, 102));
            jLabel9.setText("Fecha de realizacion");

            fechaEnt.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1777426620000L), new java.util.Date(1777426620000L), new java.util.Date(1924997820000L), java.util.Calendar.DAY_OF_MONTH));
            fechaEnt.setEditor(new javax.swing.JSpinner.DateEditor(fechaEnt, "dd/MM/yyyy"));

            jLabel10.setForeground(new java.awt.Color(102, 102, 102));
            jLabel10.setText("Fecha de entrega");

            jLabel11.setForeground(new java.awt.Color(102, 102, 102));
            jLabel11.setText("Estado");

            estado.setBackground(new java.awt.Color(0, 51, 102));
            estado.setForeground(new java.awt.Color(255, 255, 255));
            estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En elaboracion", "Finalizado", "Retirado", "Enviado" }));
            estado.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoActionPerformed(evt);
                  }
            });

            jLabel12.setForeground(new java.awt.Color(102, 102, 102));
            jLabel12.setText("Estudios");

            estudiosList.setBackground(new java.awt.Color(0, 51, 102));
            estudiosList.setForeground(new java.awt.Color(255, 255, 255));
            estudiosList.setModel(new javax.swing.AbstractListModel<String>() {
                  String[] strings = { "Hemograma completo", "Glucemia", "Colesterol total", "Orina completa", "Uremia", "Creatinemia", "Hepatograma", "Perfil lipidico", "Grupo y factor", "Coagulograma" };
                  public int getSize() { return strings.length; }
                  public String getElementAt(int i) { return strings[i]; }
            });
            estudiosList.setSelectionBackground(new java.awt.Color(0, 102, 204));
            estudiosList.setSelectionForeground(new java.awt.Color(255, 255, 255));
            estudiosScroll.setViewportView(estudiosList);

            jLabel13.setForeground(new java.awt.Color(102, 102, 102));
            jLabel13.setText("Mantenga presionado");

            jLabel14.setForeground(new java.awt.Color(102, 102, 102));
            jLabel14.setText("control para elegir");

            jLabel15.setForeground(new java.awt.Color(102, 102, 102));
            jLabel15.setText("mas de uno");

            btnCargarEstudio.setBackground(new java.awt.Color(0, 51, 102));
            btnCargarEstudio.setForeground(new java.awt.Color(255, 255, 255));
            btnCargarEstudio.setText("CARGAR");
            btnCargarEstudio.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCargarEstudioActionPerformed(evt);
                  }
            });

            dniProEst.setBackground(new java.awt.Color(0, 51, 102));
            dniProEst.setForeground(new java.awt.Color(255, 255, 255));
            dniProEst.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        dniProEstActionPerformed(evt);
                  }
            });

            jLabel16.setForeground(new java.awt.Color(102, 102, 102));
            jLabel16.setText("DNI del profesional");

            fechaRetxt.setForeground(new java.awt.Color(0, 0, 0));
            fechaRetxt.setText("default");

            javax.swing.GroupLayout PanelCargaEstLayout = new javax.swing.GroupLayout(PanelCargaEst);
            PanelCargaEst.setLayout(PanelCargaEstLayout);
            PanelCargaEstLayout.setHorizontalGroup(
                  PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(PanelCargaEstLayout.createSequentialGroup()
                        .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                      .addComponent(jLabel7)
                                                      .addComponent(jLabel9)
                                                      .addComponent(jLabel10)
                                                      .addComponent(jLabel11)
                                                      .addComponent(jLabel12)
                                                      .addComponent(jLabel13)
                                                      .addComponent(jLabel14)
                                                      .addComponent(jLabel15)
                                                      .addComponent(jLabel8)
                                                      .addComponent(jLabel16))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                      .addComponent(dniProEst)
                                                      .addComponent(dniPacEst)
                                                      .addComponent(matProEst)
                                                      .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(estudiosScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                      .addComponent(fechaRetxt)))
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(btnCargarEstudio))))
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(tituloEst)))
                        .addContainerGap(17, Short.MAX_VALUE))
            );
            PanelCargaEstLayout.setVerticalGroup(
                  PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCargaEstLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tituloEst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(jLabel8)
                                          .addComponent(dniPacEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(jLabel16)
                                          .addComponent(dniProEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(jLabel7)
                                          .addComponent(matProEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15))
                                          .addGroup(PanelCargaEstLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(fechaRetxt)
                                                      .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelCargaEstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                      .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                      .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(estudiosScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                    .addComponent(btnCargarEstudio))
                              .addComponent(jSeparator2))
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
    
    private boolean buscarProMat(String dniBusqueda){
        return (mapaPersonas.containsKey(dniBusqueda) && (mapaPersonas.get(dniBusqueda) instanceof Profesional));
    }
    
      
      //Este metodo hace que aparezca solo el panel correcto
      //evitando que se superpongan
      
      public void metAux(int op){
            if(op == 0){
                  this.modoActual = "Paciente";
                  PanelCargaPac.setVisible(true);
                  PanelCargaPac.setEnabled(true);
                  PanelCargaPro.setVisible(false);
                  PanelCargaPro.setEnabled(false);
                  PanelCargaEst.setVisible(false);
                  PanelCargaEst.setEnabled(false);
            } else if(op == 1){
                  this.modoActual = "Profesional";
                  PanelCargaPro.setVisible(true);
                  PanelCargaPro.setEnabled(true);
                  PanelCargaPac.setVisible(false);
                  PanelCargaPac.setEnabled(false);
                  PanelCargaEst.setVisible(false);
                  PanelCargaEst.setEnabled(false);
            } else{
                  this.modoActual = "Estudio";
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

    private void btnGuardarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPersonaActionPerformed

        Paciente pa = new Paciente();
        PacienteController miPaciente = new PacienteController(pa);
        miPaciente.colocarNombre(nombretxtPac.getText());
        miPaciente.colocarApellido(apellidotxtPac.getText());
        miPaciente.colocarDni(dnitxt.getText().trim());
        miPaciente.colocarEmail(mailtxtPac.getText().trim());
        miPaciente.colocarTelefono(telefonotxtPac.getText().trim());
        miPaciente.colocarObraSocial(obSoc.isSelected());
        mapaPersonas.put(miPaciente.muestraDni(), miPaciente.obtenerPaciente());
        JOptionPane.showMessageDialog(this,"Paciente cargado correctamente");
        this.dispose();
        
    }//GEN-LAST:event_btnGuardarPersonaActionPerformed

    private void dnitxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnitxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnitxtActionPerformed

    private void mailtxtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailtxtPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailtxtPacActionPerformed

    private void obSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obSocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obSocActionPerformed

    private void btnGuardarPersona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPersona1ActionPerformed
            Profesional pr = new Profesional();
            ProfesionalController miProfesional = new ProfesionalController(pr);
            miProfesional.colocarNombre(nombretxt.getText());
            miProfesional.colocarApellido(apellidotxt.getText());
            miProfesional.colocarDni(dniProtxt.getText().trim());
            miProfesional.colocarEmail(emailProtxt.getText().trim());
            miProfesional.colocarTelefono(telefonoProtxt.getText().trim());
            miProfesional.colocarMatricula(matriculatxt.getText().trim());
            mapaPersonas.put(miProfesional.muestraDni(), miProfesional.ObtenerProfesional());
            JOptionPane.showMessageDialog(this,"Profesional cargado correctamente");
            this.dispose();
    }//GEN-LAST:event_btnGuardarPersona1ActionPerformed

    private void btnCargarEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarEstudioActionPerformed
          //Controles del profesional
          
          //Control de que no este repetido
          if(!buscarProMat(dniPacEst.getText())){
                JOptionPane.showMessageDialog(this, "-Error. El profesional no fue encontrado-\n\n");
                this.dispose();
                return;
          }
          if(!buscarPacDni(dniProEst.getText())){
                JOptionPane.showMessageDialog(this, "-Error. El paciente no fue encontrado-\n\n");
                this.dispose();
                return;
          }
          
            //Crea objeto date para leer fecha ingresada
            LocalDate fechaRe = LocalDate.now();
            java.util.Date dateEntrega = (java.util.Date) fechaEnt.getValue();
            //Crea cal para extraer dia, mes y anio
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
            miEstudio.ColocarDniProfesional(dniProEst.getText().trim());
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
            JOptionPane.showMessageDialog(this,"Estudio cargado correctamente\n" + listaEstudios.toString());
            this.dispose();
    }//GEN-LAST:event_btnCargarEstudioActionPerformed

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void emailProtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailProtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailProtxtActionPerformed

    private void dniProEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniProEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniProEstActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel PanelCargaEst;
      private javax.swing.JPanel PanelCargaPac;
      private javax.swing.JPanel PanelCargaPro;
      private javax.swing.JLabel apellidoSig;
      private javax.swing.JTextField apellidotxt;
      private javax.swing.JTextField apellidotxtPac;
      private javax.swing.JButton btnCargarEstudio;
      private javax.swing.JButton btnGuardarPersona;
      private javax.swing.JButton btnGuardarPersona1;
      private javax.swing.JTextField dniPacEst;
      private javax.swing.JTextField dniProEst;
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
      private javax.swing.JLabel jLabel16;
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
