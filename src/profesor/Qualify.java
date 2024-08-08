package profesor;

import projectbd.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Qualify extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    private static String id_profesor = "";
    private static String nameCurso = "";
    private static String nameEstudiante = "";

    ArrayList<String> list = new ArrayList<>();
    private static ArrayList<String> nombreEvaluacion = new ArrayList<>();
    

    public Qualify(String id_profesor, String nameCurso, String nameEstudiante, ArrayList<String> nombreEvaluacion) {
        this.id_profesor = id_profesor;
        this.nameCurso = nameCurso;
        this.nameEstudiante = nameEstudiante;
        this.nombreEvaluacion=nombreEvaluacion;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboBox();
    }

    public void llenarComboBox() {
        try {
            //nums qualify
            int num = 1;
            Nota.addItem("");
            
            while (num <= 10) {
                Nota.addItem(String.valueOf(num));
                num++;
            }

            //fully with name of pendign activities
            for(int i=0; i<nombreEvaluacion.size();i++){
                ActivityPending.addItem(nombreEvaluacion.get(i));
            }

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
        Guardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();
        ActivityPending = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Nota = new javax.swing.JComboBox<>();

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
        jLabel7.setText("Qualify");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Specifies the activity and student");

        Guardar.setBackground(new java.awt.Color(153, 255, 153));
        Guardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Guardar.setText("Done");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pending activity");

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/back.png"))); // NOI18N
        buttonBack.setContentAreaFilled(false);
        buttonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        ActivityPending.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ActivityPending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActivityPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivityPendingActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Qualify");

        Nota.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Nota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotaActionPerformed(evt);
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
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(buttonBack)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ActivityPending, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(buttonBack)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(ActivityPending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkComboBox(String value) {
        return !value.equals("");
    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        try {
            String activitySelected = (String)ActivityPending.getSelectedItem();
            String notaSelected = (String) Nota.getSelectedItem();
            
            String date = "";
            String id_curso = "";
            String id_estudiante = "";
            String id_tipoEvaluacion = "";
            String id_cursoEstudiante="";
            

            if (checkComboBox(notaSelected)) {
            //tools for send evaluation
            
                //Query date or "fecha"
                String sql2 = "SELECT fechaEvaluacion FROM evaluacion WHERE nombreEvaluacion = ?";
                PreparedStatement ps2 = cn.prepareStatement(sql2);
                ps2.setString(1, activitySelected);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    date=rs2.getString("fechaEvaluacion");
                }
                
                //Query id_curso
                String sql3 = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
                PreparedStatement ps3 = cn.prepareStatement(sql3);
                ps3.setString(1, nameCurso);
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    id_curso=rs3.getString("id_curso");
                }
                
                //Query id_estudiante
                String sql4 = "SELECT id_estudiante FROM estudiante WHERE nombre = ?";
                PreparedStatement ps4 = cn.prepareStatement(sql4);
                ps4.setString(1, nameEstudiante);
                ResultSet rs4 = ps4.executeQuery();
                while (rs4.next()) {
                    id_estudiante=rs4.getString("id_estudiante");
                }
                
                //Query id_tipoEvaluacion
                String sql = "SELECT id_tipoEvaluacion FROM evaluacion WHERE nombreEvaluacion = ?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, activitySelected);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    id_tipoEvaluacion=rs.getString("id_tipoEvaluacion");
                }
                
                
            //tools for send calification    
                
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
                            ps5.setString(1,notaSelected);
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
                
                //send data
                String sql5 = "INSERT INTO evaluacion (nombreEvaluacion, fechaEvaluacion, calificaciones, id_curso, id_estudiante, id_tipoEvaluacion) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps5 = cn.prepareStatement(sql5);
                ps5.setString(1, activitySelected);
                ps5.setString(2, date);
                ps5.setString(3, notaSelected);
                ps5.setString(4, id_curso);
                ps5.setString(5, id_estudiante);
                ps5.setString(6, id_tipoEvaluacion);
                
                int querySave = ps5.executeUpdate();

                if (querySave > 0) {
                    //data saved
                    JOptionPane.showMessageDialog(null, "datos guardados");
                    Nota.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "error al almacenar datos");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Sorry, select something", "error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "something has happened", "error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);

        Main_profesor open = new Main_profesor(id_profesor);
        open.setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void ActivityPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivityPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActivityPendingActionPerformed

    private void NotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Qualify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Qualify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Qualify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Qualify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Qualify(id_profesor, nameCurso, nameEstudiante, nombreEvaluacion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ActivityPending;
    private javax.swing.JButton Guardar;
    private javax.swing.JComboBox<String> Nota;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
