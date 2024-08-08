package projectbd;

import administrator.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Register_student extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    
    ArrayList<String> list = new ArrayList<>();

    public Register_student() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboBox();
    }

    void Limpiar() {
        txtNombre.setText("");
        txtCorreo.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtFechaNacimiento.setText("");
    }

    public void llenarComboBox() {
        
        try{
            //first item empty
            comboBoxCurso.addItem("");
            
            String sql = "SELECT id_curso FROM curso";
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString("id_curso"));
            }
            
            String sql2 = "SELECT maximoEstudiante FROM curso WHERE id_curso = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            
            for(int i=0; i<list.size(); i++){
                
                String valueMaxEstudiante="";
                int valueQueryEstudiante=0;
                
                ps2.setString(1, list.get(i));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    valueMaxEstudiante=rs2.getString("maximoEstudiante");
                }
                
                //count the positions occupied 
                String sql3 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ?";
                PreparedStatement ps3 = cn.prepareStatement(sql3);
                ps3.setString(1, list.get(i));
                ResultSet rs3 = ps3.executeQuery();
                while(rs3.next()){
                    valueQueryEstudiante++;
                }
                
                //verify that curso context not has been found without stock
                if(valueQueryEstudiante>=Integer.parseInt(valueMaxEstudiante)){
                    //do nothing
                }else{
                
                    String sql4 = "SELECT nombreCurso FROM curso WHERE id_curso = ?";
                    PreparedStatement ps4 = cn.prepareStatement(sql4);
                    ps4.setString(1, list.get(i));
                    ResultSet rs4 = ps4.executeQuery();
                    while(rs4.next()){
                        comboBoxCurso.addItem(rs4.getString("nombreCurso"));
                    }
                }
                
            }
        }catch(Exception e){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        buttonBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Borrar = new javax.swing.JButton();
        comboBoxCurso = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(496, 500));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/register_alt.jpg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusable(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Regist student");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Now, fill out the requerided fields");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellido");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("F. nacimiento");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        txtFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/back.png"))); // NOI18N
        buttonBack.setContentAreaFilled(false);
        buttonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));

        Guardar.setBackground(new java.awt.Color(153, 255, 153));
        Guardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Borrar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Borrar.setText("Limpiar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Borrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Borrar)
                .addContainerGap())
        );

        comboBoxCurso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCursoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cursos disponibles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonBack)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(4, 4, 4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 36, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        Limpiar();
    }//GEN-LAST:event_BorrarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

                try{
                    String valueComboBox= (String) comboBoxCurso.getSelectedItem();
                    
                    if (valueComboBox.equals("")) {
                        JOptionPane.showMessageDialog(null, "your has been selected nothing item");
                        return;
                    }
                    
                    if (txtNombre.getText().isEmpty()
                        ||txtApellido.getText().isEmpty()
                        ||txtCorreo.getText().isEmpty()
                        ||txtTelefono.getText().isEmpty()
                        ||txtFechaNacimiento.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please, enter all fields requerid");
                        return;
                    }
                    
                    long value=Long.parseLong(txtTelefono.getText());
                    
                    //create student
                    String insertSQL="INSERT INTO estudiante (nombre, apellido, correo, telefono, fechaNacimiento) VALUES (?,?,?,?,?)";
                    PreparedStatement goInsert=cn.prepareStatement(insertSQL);
                    goInsert.setString(1,txtNombre.getText());
                    goInsert.setString(2,txtApellido.getText());
                    goInsert.setString(3,txtCorreo.getText());
                    goInsert.setLong(4,value);
                    goInsert.setString(5,txtFechaNacimiento.getText());                    
                    int saveEstudiante=goInsert.executeUpdate();
                    
                    //search date necesary for associate with cursoEstudiante
                    int id_curso=0;
                    int id_estudiante=0;
                    int id_cursoEstudiante=0;
                    
                    String sql2 = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
                    PreparedStatement ps2=cn.prepareStatement(sql2);
                    ps2.setString(1, valueComboBox);
                    ResultSet rs2= ps2.executeQuery();
                    while(rs2.next()){
                        id_curso=rs2.getInt("id_curso");
                    }
                    
                    String sql3 = "SELECT id_estudiante FROM estudiante WHERE nombre = ?";
                    PreparedStatement ps3=cn.prepareStatement(sql3);
                    ps3.setString(1, txtNombre.getText());
                    ResultSet rs3= ps3.executeQuery();
                    while(rs3.next()){
                        id_estudiante=rs3.getInt("id_estudiante");
                    }
                    
                    //once finished the search of ids, create the association whith curso correspondent
                    String sql4="INSERT INTO cursoestudiante (id_curso, id_estudiante) VALUES (?,?)";
                    PreparedStatement ps4=cn.prepareStatement(sql4);
                    ps4.setString(1,String.valueOf(id_curso));
                    ps4.setString(2,String.valueOf(id_estudiante));
                    int saveCursoEstudiante=ps4.executeUpdate();
                    
                    //create qualifications default
                    String sql5 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
                    PreparedStatement ps5=cn.prepareStatement(sql5);
                    ps5.setString(1,String.valueOf(id_curso));
                    ps5.setString(2,String.valueOf(id_estudiante));
                    ResultSet rs5=ps5.executeQuery();
                    while(rs5.next()){
                        id_cursoEstudiante=rs5.getInt("id_cursoEstudiante");
                    }
                    
                    String sql6="INSERT INTO calificacion (id_cursoEstudiante, p1, p2, p3, p4) VALUES (?,?,?,?,?)";
                    PreparedStatement ps6=cn.prepareStatement(sql6);
                    ps6.setString(1,String.valueOf(id_cursoEstudiante));
                    ps6.setInt(2,0);
                    ps6.setInt(3,0);
                    ps6.setInt(4,0);
                    ps6.setInt(5,0);
                    int saveCalificacion=ps6.executeUpdate();
                    
                    if(saveEstudiante>0&&saveCursoEstudiante>0&&saveCalificacion>0) {
                        //data saved
                        JOptionPane.showMessageDialog(null,"date saved");
                        Limpiar();
                    }else {
                        JOptionPane.showMessageDialog(null,"error al almacenar datos");
                    }

                }catch(SQLException e) {
                    e.printStackTrace();
                }
        
    }//GEN-LAST:event_GuardarActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);

        Interfaz admin = new Interfaz();
        admin.setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void comboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCursoActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register_student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton buttonBack;
    private javax.swing.JComboBox<String> comboBoxCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
