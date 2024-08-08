/*
comment:
working here...
 */
package profesor;

import projectbd.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Create_evaluation extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    private static String teacher_context="";
    private String id_curso="";
    
    //list
    ArrayList<String> list_estudiantes = new ArrayList<>();
    
    public Create_evaluation(String teacher_context) {
        this.teacher_context=teacher_context;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboBox_curso();
    }

    private void gestionar_tipoEvaluacion(String name){
        try{
        
            String search = "SELECT * FROM tipoevaluacion";
            PreparedStatement pss=cn.prepareStatement(search);
            ResultSet rss=pss.executeQuery();
            boolean valueQuery=rss.next();
        
            if(valueQuery==false){//create with id
                
                String sql="INSERT INTO tipoevaluacion (id_tipoEvaluacion, nombreTipo) VALUES (?,?)";
                PreparedStatement ps=cn.prepareStatement(sql);
                ps.setInt(1, 601);
                ps.setString(2, name);
                ResultSet rs=ps.executeQuery();
                boolean valueCreate=rs.next();
                
                if(valueCreate){
                    System.out.println("tipoEvaluacion created successfully");
                }
                
            }else{//create without id
                
                String ask = "SELECT id_tipoEvaluacion FROM tipoevaluacion WHERE nombreTipo = ?";
                PreparedStatement psp = cn.prepareStatement(ask);
                psp.setString(1, name);
                ResultSet rsr=psp.executeQuery();
                
                //if coincide con algun tipo en bd
                if(rsr.next()){
                    //nothing
                    System.out.println("ya hay un nombreTipoEvaluacion con este nombre");
                }else{
                    
                    String sql2="INSERT INTO tipoevaluacion (nombreTipo) VALUES (?)";
                    PreparedStatement ps2=cn.prepareStatement(sql2);
                    ps2.setString(1, name);
                    int entry=ps2.executeUpdate();
                    
                    if(entry!=0){
                        JOptionPane.showMessageDialog(null, "tipoEvaluacion registrado correctamente");
                    }
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void llenarComboBox_curso(){
        try{
            //select course
            String sql = "SELECT nombreCurso FROM curso WHERE id_profesor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, teacher_context);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                selectCurso.addItem(rs.getString("nombreCurso"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error al llenar el combo box"+e, "error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarComboBox() {
        try {
            //tipoEvaluacion
            tipoEvaluacion.removeAllItems();
            tipoEvaluacion.addItem("Quiz");
            tipoEvaluacion.addItem("Taller");
            tipoEvaluacion.addItem("Evaluacion");
            tipoEvaluacion.addItem("Actividad");
            
            //student
            String nombreCurso=selectCurso.getSelectedItem().toString();
            
            String sql3 = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement ps3 = cn.prepareStatement(sql3);
            ps3.setString(1, nombreCurso);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                id_curso=rs3.getString("id_curso");
            }
            
            String sql2 = "SELECT id_estudiante FROM cursoestudiante WHERE id_curso = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, id_curso);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                list_estudiantes.add(rs2.getString("id_estudiante"));
            }
            
            student.removeAllItems();
            String sql4 = "SELECT nombre FROM estudiante WHERE id_estudiante = ?";
            PreparedStatement ps4 = cn.prepareStatement(sql4);
            for(int i=0; i<list_estudiantes.size();i++){
                
                ps4.setString(1, list_estudiantes.get(i));
                ResultSet rs4 = ps4.executeQuery();
                while (rs4.next()) {
                    student.addItem(rs4.getString("nombre"));
                }
            }
            
            list_estudiantes.clear();
            
            //qualification
            calificacion.removeAllItems();
            calificacion.addItem("1");
            calificacion.addItem("2");
            calificacion.addItem("3");
            calificacion.addItem("4");
            calificacion.addItem("5");
            calificacion.addItem("6");
            calificacion.addItem("7");
            calificacion.addItem("8");
            calificacion.addItem("9");
            calificacion.addItem("10");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar el combo box", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        Guardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tipoEvaluacion = new javax.swing.JComboBox<>();
        buttonBack = new javax.swing.JButton();
        selectCurso = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        student = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        calificacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(496, 500));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/background_login.jpg"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setFocusable(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("New evaluation");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter the information requerid");

        name.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(153, 255, 153));
        Guardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Guardar.setText("Create");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name evaluation");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Type evaluation");

        tipoEvaluacion.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tipoEvaluacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoEvaluacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoEvaluacionItemStateChanged(evt);
            }
        });
        tipoEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoEvaluacionActionPerformed(evt);
            }
        });

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/back.png"))); // NOI18N
        buttonBack.setContentAreaFilled(false);
        buttonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        selectCurso.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        selectCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectCursoItemStateChanged(evt);
            }
        });
        selectCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCursoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Select course");

        date.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date of realization");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Now, add the first qualification in this activity");

        student.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select student");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Qualification");

        calificacion.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        calificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(student, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(buttonBack))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(Guardar)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkComboBox(String value) {
        return !value.equals("");
    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        try {
            String TipoSelected = (String) tipoEvaluacion.getSelectedItem();
            String StudentSelected = (String) student.getSelectedItem();
            String valueName = name.getText().toLowerCase();
            String id_estudiante="";
            String id_tipoEvaluacion="";
            String id_cursoEstudiante="";

            if (checkComboBox(TipoSelected)) {
                boolean way=false;
                
                //send evaluacion
                    String sql = "SELECT id_evaluacion FROM evaluacion WHERE nombreEvaluacion = ? AND id_curso = ?";
                    PreparedStatement ps = cn.prepareStatement(sql);
                    ps.setString(1, valueName);
                    ps.setString(2, id_curso);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        way=true;
                    }
                
                    if(way){
                        JOptionPane.showMessageDialog(this, "A course with this name has been found, please retry", "error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                
                    String sql2 = "SELECT id_estudiante FROM estudiante WHERE nombre = ?";
                    PreparedStatement ps2 = cn.prepareStatement(sql2);
                    ps2.setString(1, StudentSelected);
                    ResultSet rs2=ps2.executeQuery();
                    while(rs2.next()){
                        id_estudiante=rs2.getString("id_estudiante");
                    }
                
                //gestionar tipoEvaluacion
                    gestionar_tipoEvaluacion(TipoSelected);
                
                    String sql4 = "SELECT id_tipoEvaluacion FROM tipoevaluacion WHERE nombreTipo = ?";
                    PreparedStatement ps4 = cn.prepareStatement(sql4);
                    ps4.setString(1, TipoSelected);
                    ResultSet rs4=ps4.executeQuery();
                    while(rs4.next()){
                        id_tipoEvaluacion=rs4.getString("id_tipoEvaluacion");
                    }
                
                    String fecha=date.getText();
                    String nota=calificacion.getSelectedItem().toString();
                
                
                //send calificacion
                
                    //id_cursoEstudiante
                    String sql7 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
                    PreparedStatement ps7 = cn.prepareStatement(sql7);
                    ps7.setString(1, id_curso);
                    ps7.setString(2, id_estudiante);
                    ResultSet rs7=ps7.executeQuery();
                    while(rs7.next()){
                        id_cursoEstudiante=rs7.getString("id_cursoEstudiante");
                    }
                
                    int ask=0, done=0;
                    int p=1;
                    for(int e=0; e<4; e++){
                        int valueP=0;
                    
                        String sql6 = "SELECT p"+p+" FROM calificacion WHERE id_cursoEstudiante = ?";
                        PreparedStatement ps6 = cn.prepareStatement(sql6);
                        ps6.setString(1, id_cursoEstudiante);
                        ResultSet rs6=ps6.executeQuery();
                        while(rs6.next()){
                            valueP=rs6.getInt("p"+p);
                        
                            if(valueP!=0){
                                ask++;
                                //nothing
                            }else{
                                String sql5="UPDATE calificacion SET p"+p+" = ? WHERE id_cursoEstudiante = ?";
                                PreparedStatement ps5=cn.prepareStatement(sql5);
                                ps5.setString(1,nota);
                                ps5.setString(2,id_cursoEstudiante);
                                int save=ps5.executeUpdate();
                                
                                if(save!=0){
                                    JOptionPane.showMessageDialog(null,"calificacion guardada");
                                    done++;
                                }
                            }
                        }
                        p++;
                        
                        if(done>0){
                            break;
                        }
                    }
                    
                    if(ask>=4){
                        JOptionPane.showMessageDialog(null,"This student have all notes, please try with other");
                        return;
                    }
                
                    String sql3="INSERT INTO evaluacion (nombreEvaluacion, fechaEvaluacion, calificaciones, id_curso, id_estudiante, id_tipoEvaluacion) VALUES (?,?,?,?,?,?)";
                    PreparedStatement ps3=cn.prepareStatement(sql3);
                    ps3.setString(1,valueName);
                    ps3.setString(2,fecha);
                    ps3.setString(3,nota);
                    ps3.setString(4,id_curso);
                    ps3.setString(5,id_estudiante);
                    ps3.setString(6,id_tipoEvaluacion);
                    int querySave=ps3.executeUpdate();
                
                    if(querySave>0) {
                        //data saved
                        JOptionPane.showMessageDialog(null,"datos guardados");
                        name.setText("");
                        date.setText("");
                        tipoEvaluacion.setSelectedIndex(0);
                    }else {
                        JOptionPane.showMessageDialog(null,"error al almacenar datos");
                    }

            }else {
                JOptionPane.showMessageDialog(this, "Sorry, select something", "error", JOptionPane.ERROR_MESSAGE);
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"something has happened","error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void tipoEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoEvaluacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoEvaluacionActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);
        
        Main_profesor open=new Main_profesor(teacher_context);
        open.setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void selectCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCursoActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentActionPerformed

    private void calificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calificacionActionPerformed

    private void selectCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectCursoItemStateChanged
        llenarComboBox();        
    }//GEN-LAST:event_selectCursoItemStateChanged

    private void tipoEvaluacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoEvaluacionItemStateChanged
        
    }//GEN-LAST:event_tipoEvaluacionItemStateChanged

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Create_evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_evaluation(teacher_context).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton buttonBack;
    private javax.swing.JComboBox<String> calificacion;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> selectCurso;
    private javax.swing.JComboBox<String> student;
    private javax.swing.JComboBox<String> tipoEvaluacion;
    // End of variables declaration//GEN-END:variables
}
