package profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectbd.Interfaz;
import projectbd.InterfazClass;

/**
 *
 * @author aprendiz
 */
public class Main_profesor extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();

    //variables globals
    private static String id_user = "";
    private String nameStudent_selected = "";

    //list
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<String> list_estudiantes = new ArrayList<>();
    private static ArrayList<String> list_evaluacion = new ArrayList<>();
    private static ArrayList<String> list_evaluacion_minimizer = new ArrayList<>();

    private static ArrayList<String> list_gestionEvaluacion = new ArrayList<>();
    private static ArrayList<String> sendAnswer = new ArrayList<>();

    public Main_profesor(String id_user) {
        this.id_user = id_user;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboBox();
        setLabel();
    }

    public void setLabel() {
        String sql = "SELECT nombre FROM profesor WHERE id_profesor = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id_user);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                jLabel7.setText("Welcome Sr. " + rs.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar el combo box", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarComboBox() {
        try {
            String sql = "SELECT nombreCurso FROM curso WHERE id_profesor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id_user);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                comboBoxCurso.addItem(rs.getString("nombreCurso"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void mostrartabla() {
        try {

//---------------------------------------------------------Tabla students------------------------------------------------------------
            int way = 0;
            DefaultTableModel modelo = new DefaultTableModel();

            //part for know if this teacher contain some course
            String sql2 = "SELECT id_curso FROM curso WHERE id_profesor = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, id_user);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                list.add(rs2.getString("id_curso"));
            }

            //this part with "for"; intent that each course of context teacher, be inspected the students;
            //then, be saved the students and if this course is the selected in the comboBox, has been view the list students of this area
            String sql3 = "SELECT id_estudiante FROM cursoestudiante WHERE id_curso = ?";
            PreparedStatement ps3 = cn.prepareStatement(sql3);
            for (int i = 0; i < list.size(); i++) {

                ps3.setString(1, list.get(i));
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    list_estudiantes.add(rs3.getString("id_estudiante"));
                }

                String sql5 = "SELECT nombreCurso FROM curso WHERE id_curso = ?";
                PreparedStatement ps5 = cn.prepareStatement(sql5);
                ps5.setString(1, list.get(i));
                ResultSet rs5 = ps5.executeQuery();

                String cursoSelected = (String) comboBoxCurso.getSelectedItem();
                String answer = "";
                while (rs5.next()) {
                    answer = rs5.getString("nombreCurso");
                }

                if (cursoSelected.equalsIgnoreCase(answer) && !list_estudiantes.isEmpty()) {
                    //custom columns of the table
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Correo");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("P1");
                    modelo.addColumn("P2");
                    modelo.addColumn("P3");
                    modelo.addColumn("P4");
                    Tabla.setModel(modelo);

                    String datos[] = new String[8];

                    String sql4 = "SELECT * FROM estudiante WHERE id_estudiante = ?";
                    PreparedStatement ps4 = cn.prepareStatement(sql4);
                    for (int e = 0; e < list_estudiantes.size(); e++) {

                        ps4.setString(1, list_estudiantes.get(e));
                        ResultSet rs4 = ps4.executeQuery();

                        //query id_cursoEstudiante
                        String id_cursoEstudiante = "";

                        String sql6 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
                        PreparedStatement ps6 = cn.prepareStatement(sql6);
                        ps6.setString(1, list.get(i));
                        ps6.setString(2, list_estudiantes.get(e));
                        ResultSet rs6 = ps6.executeQuery();
                        while (rs6.next()) {
                            id_cursoEstudiante = rs6.getString("id_cursoEstudiante");
                        }

                        //get all notes
                        String sql7 = "SELECT * FROM calificacion WHERE id_cursoEstudiante = ?";
                        PreparedStatement ps7 = cn.prepareStatement(sql7);
                        ps7.setString(1, id_cursoEstudiante);
                        ResultSet rs7 = ps7.executeQuery();

                        while (rs4.next()) {
                            datos[0] = rs4.getString(2);
                            datos[1] = rs4.getString(3);
                            datos[2] = rs4.getString(4);
                            datos[3] = rs4.getString(5);

                            if (rs7.next()) {
                                datos[4] = rs7.getString(3);
                                datos[5] = rs7.getString(4);
                                datos[6] = rs7.getString(5);
                                datos[7] = rs7.getString(6);
                            } else {
                                datos[4] = "";
                                datos[5] = "";
                                datos[6] = "";
                                datos[7] = "";
                            }
                            modelo.addRow(datos);
                        }
                    }

                    // Establecer el ancho preferido de las siguientes cuatro columnas
                    Tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
                    Tabla.getColumnModel().getColumn(5).setPreferredWidth(20);
                    Tabla.getColumnModel().getColumn(6).setPreferredWidth(20);
                    Tabla.getColumnModel().getColumn(7).setPreferredWidth(20);

                    Tabla.setModel(modelo);
                    way++;
                }

                list_estudiantes.clear();
            }

            if (way == 0) {
                modelo.addColumn("      nothing student has been found in this course");
                Tabla.setModel(modelo);
            }

            list.clear();

//---------------------------------------------------------Tabla evaluations------------------------------------------------------------
            DefaultTableModel modelo2 = new DefaultTableModel();

            String cursoSelected = (String) comboBoxCurso.getSelectedItem();
            String id_cursoContext = "";
            String id_estudiante = "";

            String ask = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement psp = cn.prepareStatement(ask);
            psp.setString(1, cursoSelected);
            ResultSet rsr = psp.executeQuery();
            while (rsr.next()) {
                id_cursoContext = rsr.getString("id_curso");
            }

            //select some student into "cursoContext" 
            String ask3 = "SELECT id_estudiante FROM cursoestudiante WHERE id_curso = ?";
            PreparedStatement psp3 = cn.prepareStatement(ask3);
            psp3.setString(1, cursoSelected);
            ResultSet rsr3 = psp3.executeQuery();
            while (rsr3.next()) {
                id_estudiante = rsr3.getString("id_estudiante");
            }

            //part for know all evaluation into "cursoContext"
            String ask2 = "SELECT nombreEvaluacion FROM evaluacion WHERE id_curso = ?";
            PreparedStatement psp2 = cn.prepareStatement(ask2);
            psp2.setString(1, id_cursoContext);
            ResultSet rsr2 = psp2.executeQuery();
            while (rsr2.next()) {
                list_evaluacion_minimizer.add(rsr2.getString("nombreEvaluacion"));
            }

            //delete redundancy
            HashSet<String> setList = new HashSet<>(list_evaluacion_minimizer);
            List<String> new_list_evaluacion = new ArrayList<>(setList);

            //preparated table2
            modelo2.addColumn("Type");
            modelo2.addColumn("Name activity");
            modelo2.addColumn("Date");
            modelo2.addColumn("Qualified");
            Tabla2.setModel(modelo2);

            String datos2[] = new String[4];

            String nombreEvaluacion = "";
            String nombreEvaluacionContext = "";
            for (int a = 0; a < new_list_evaluacion.size(); a++) {

                String id_evaluacion = "";
                String id_tipoEvaluacion = "";
                String nombreTipo = "";
                String fechaEvaluacion = "";
                int totalEstudiantesCurso = 0;
                int calificados = 0;

                String ask4 = "SELECT id_evaluacion FROM evaluacion WHERE nombreEvaluacion = ? AND id_curso = ?";
                PreparedStatement psp4 = cn.prepareStatement(ask4);
                psp4.setString(1, new_list_evaluacion.get(a));
                psp4.setString(2, id_cursoContext);
                ResultSet rsr4 = psp4.executeQuery();
                while (rsr4.next()) {
                    id_evaluacion = rsr4.getString("id_evaluacion");
                    calificados++;
                }
                
                String ask5 = "SELECT * FROM evaluacion WHERE id_evaluacion = ?";
                PreparedStatement psp5 = cn.prepareStatement(ask5);
                psp5.setString(1, id_evaluacion);
                ResultSet rsr5 = psp5.executeQuery();
                while (rsr5.next()) {
                    fechaEvaluacion = rsr5.getString(3);
                    id_tipoEvaluacion = rsr5.getString(7);
                }

                //consulta externa; nombreTipo de tipoevaluacion
                String ask6 = "SELECT nombreTipo FROM tipoevaluacion WHERE id_tipoEvaluacion = ?";
                PreparedStatement psp6 = cn.prepareStatement(ask6);
                psp6.setString(1, id_tipoEvaluacion);
                ResultSet rsr6 = psp6.executeQuery();
                while (rsr6.next()) {
                    nombreTipo = rsr6.getString("nombreTipo");
                }

                //consulta cantidad de alumnos en el curso
                String ask7 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ?";
                PreparedStatement psp7 = cn.prepareStatement(ask7);
                psp7.setString(1, id_cursoContext);
                ResultSet rsr7 = psp7.executeQuery();
                while (rsr7.next()) {
                    totalEstudiantesCurso++;
                }

                //working here...
                datos2[0] = nombreTipo;
                datos2[1] = new_list_evaluacion.get(a);
                datos2[2] = fechaEvaluacion;

                if (calificados >= totalEstudiantesCurso) {
                    datos2[3] = "yes";
                } else {
                    datos2[3] = "no";
                }

                list_gestionEvaluacion.add(new_list_evaluacion.get(a));

                modelo2.addRow(datos2);

                Tabla2.setModel(modelo2);
            }
            Tabla2.getColumnModel().getColumn(3).setPreferredWidth(20);
            Tabla2.setModel(modelo2);

            list_evaluacion_minimizer.clear();

//---------------------------------------------------------END------------------------------------------------------------
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado" + ex, "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        comboBoxCurso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        ConsuEva = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        ConsuEva1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROFESOR");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(68, 45, 114));
        jPanel1.setToolTipText("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/background_profesor.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setFocusable(false);

        Tabla.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(640, 150));

        Tabla2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tabla2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        comboBoxCurso.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        comboBoxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxCursoItemStateChanged(evt);
            }
        });
        comboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursoActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bienvenido Sr.");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Table students");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Curso");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("if wish change the qualifications of student, push the student field and then click in the operation qualify");

        Eliminar.setBackground(new java.awt.Color(204, 0, 0));
        Eliminar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Delete student");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Editar.setBackground(new java.awt.Color(42, 127, 0));
        Editar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Qualify");
        Editar.setPreferredSize(new java.awt.Dimension(73, 23));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pending activities");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Status green mean that everyone the students of context course has been qualified");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, Short.MAX_VALUE))
        );

        jMenuBar1.setToolTipText("Profesor");

        jMenu1.setBackground(new java.awt.Color(31, 67, 124));
        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("   Inicio   ");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Cerrar sesion");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("   Curso   ");
        jMenu2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMenu2StateChanged(evt);
            }
        });

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Crear C.");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setText("   Evaluacion   ");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Crear Ev.");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem3);

        ConsuEva.setSelected(true);
        ConsuEva.setText("Consultar Ev.");
        ConsuEva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsuEvaActionPerformed(evt);
            }
        });
        jMenu3.add(ConsuEva);

        jMenu5.setText("Calificaciones");

        jCheckBoxMenuItem7.setSelected(true);
        jCheckBoxMenuItem7.setText("Calificar estudiante");
        jCheckBoxMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem7);

        ConsuEva1.setSelected(true);
        ConsuEva1.setText("Editar calificacion");
        ConsuEva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsuEva1ActionPerformed(evt);
            }
        });
        jMenu5.add(ConsuEva1);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        this.setEnabled(false);

        Create_curso open = new Create_curso(id_user);
        open.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void ConsuEvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsuEvaActionPerformed

    }//GEN-LAST:event_ConsuEvaActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        this.setVisible(false);

        Create_evaluation open = new Create_evaluation(id_user);
        open.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        this.setVisible(false);

        Interfaz admin = new Interfaz();
        admin.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenu2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2StateChanged

    private void jCheckBoxMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItem7ActionPerformed

    private void ConsuEva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsuEva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsuEva1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed

        try {
            int value = Tabla.getSelectedRow();

            String nameEstudiante = Tabla.getValueAt(value, 0).toString();
            String nameCurso = comboBoxCurso.getSelectedItem().toString();

            if (value == -1) {
                return;
            }

            //pending activity
            String id_estudiante = "";
            String id_curso = "";

            String sql = "SELECT id_estudiante FROM estudiante WHERE nombre = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nameEstudiante);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_estudiante = rs.getString("id_estudiante");
            }

            String sql2 = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, nameCurso);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id_curso = rs2.getString("id_curso");
            }

            //query all evaluations in "curso" context            
            for (int i = 0; i < list_gestionEvaluacion.size(); i++) {
                int way = 0;

                String sql3 = "SELECT id_evaluacion FROM evaluacion WHERE nombreEvaluacion = ? AND id_curso = ? AND id_estudiante = ?";
                PreparedStatement ps3 = cn.prepareStatement(sql3);
                ps3.setString(1, list_gestionEvaluacion.get(i));
                ps3.setString(2, id_curso);
                ps3.setString(3, id_estudiante);
                ResultSet rs3 = ps3.executeQuery();

                while (rs3.next()) {//exist, then not allow entry to create qualification with this context
                    way++;
                }
                if (way == 0) {//not exist; then add to sendAnswer and allow qualificacion into page Qualify
                    sendAnswer.add(list_gestionEvaluacion.get(i));
                }
            }

            if (sendAnswer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "this student has been qualified in all activities");
                return;
            }

            this.setVisible(false);

            Qualify entry = new Qualify(id_user, nameCurso, nameEstudiante, sendAnswer);
            entry.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e);
        }


    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            
            String cursoSelected = comboBoxCurso.getSelectedItem().toString();
            String id_curso = "";
            String id_estudiante = "";

            //query id_curso
            String sql = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cursoSelected);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id_curso = rs.getString("id_curso");
            }

            //query id_estudiante
            String sql2 = "SELECT id_estudiante FROM estudiante WHERE nombre = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, nameStudent_selected);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id_estudiante = rs2.getString("id_estudiante");
            }

            //delete id_cursoEstudiante context
            String sql3 = "DELETE FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
            PreparedStatement ps3 = cn.prepareStatement(sql3);
            ps3.setString(1, id_curso);
            ps3.setString(2, id_estudiante);
            int valueOperation = ps3.executeUpdate();

            if (valueOperation == 0) {
                JOptionPane.showMessageDialog(this, "this student not has been deleted", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "Correctamente eliminado");
            mostrartabla();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error inesperado" + e, "error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_EliminarActionPerformed

    private void comboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCursoActionPerformed

    private void comboBoxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCursoItemStateChanged
        this.Editar.setVisible(false);
        this.Eliminar.setVisible(false);
        list_gestionEvaluacion.clear();
        sendAnswer.clear();
        mostrartabla();
    }//GEN-LAST:event_comboBoxCursoItemStateChanged

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        int filaSeleccionada = Tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            return;
        }
        if (Editar.isVisible()) {

        } else {
            this.Editar.setVisible(true);
            this.Eliminar.setVisible(true);
        }

        // Obtiene los datos de la fila seleccionada
        nameStudent_selected = Tabla.getValueAt(filaSeleccionada, 0).toString();
    }//GEN-LAST:event_TablaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_profesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_profesor(id_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem ConsuEva;
    private javax.swing.JCheckBoxMenuItem ConsuEva1;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable Tabla2;
    private javax.swing.JComboBox<String> comboBoxCurso;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
