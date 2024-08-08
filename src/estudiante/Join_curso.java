package estudiante;

import projectbd.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Join_curso extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    private static String id_user = "";

    //list
    private static ArrayList<String> id_cursoContext = new ArrayList<>();
    private static ArrayList<String> name_cursoContext = new ArrayList<>();
    private static ArrayList<String> all_curso = new ArrayList<>();
    private static ArrayList<String> save = new ArrayList<>();

    public Join_curso(String id_user) {
        this.id_user = id_user;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        llenarComboBox();
    }

    public void llenarComboBox() {
        try {
            listCurso.addItem("");

            //query if student have some course
            String sql2 = "SELECT id_curso FROM cursoestudiante WHERE id_estudiante = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, id_user);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id_cursoContext.add(rs2.getString("id_curso"));
            }

            for (int i = 0; i < id_cursoContext.size(); i++) {
                String sql3 = "SELECT nombreCurso FROM curso WHERE id_curso = ?";
                PreparedStatement ps3 = cn.prepareStatement(sql3);
                ps3.setString(1, id_cursoContext.get(i));
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    name_cursoContext.add(rs3.getString("nombreCurso"));
                }
            }

            String sql4 = "SELECT nombreCurso FROM curso";
            PreparedStatement ps4 = cn.prepareStatement(sql4);
            ResultSet rs4 = ps4.executeQuery();
            while (rs4.next()) {
                all_curso.add(rs4.getString("nombreCurso"));
            }

            for (int i = 0; i < name_cursoContext.size(); i++) {

                for (int e = 0; e < all_curso.size(); e++) {

                    String value = all_curso.get(e);
                    if (value.equals(name_cursoContext.get(i))) {
                        all_curso.remove(name_cursoContext.get(i));
                    }
                }
            }

            for (int i = 0; i < all_curso.size(); i++) {
                listCurso.addItem(all_curso.get(i));
            }

            id_cursoContext.clear();
            name_cursoContext.clear();
            all_curso.clear();

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
        listCurso = new javax.swing.JComboBox<>();
        buttonBack = new javax.swing.JButton();

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
        jLabel7.setText("New course");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter the information requerid");

        Guardar.setBackground(new java.awt.Color(153, 255, 153));
        Guardar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Guardar.setText("Create");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Join to");

        listCurso.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        listCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCursoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(80, 80, 80)))))
                .addComponent(buttonBack)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
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
                    .addComponent(jLabel9)
                    .addComponent(listCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkComboBox(String value) {
        return !value.equals("");
    }

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        try {
            String valueComboBox = (String) listCurso.getSelectedItem();

            if (valueComboBox.equals("")) {
                JOptionPane.showMessageDialog(null, "your has been selected nothing item");
                return;
            }

            //search date necesary for associate with cursoEstudiante
            int id_curso = 0;
//            int id_estudiante = 0;
            int id_cursoEstudiante = 0;

            String sql2 = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, valueComboBox);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id_curso = rs2.getInt("id_curso");
            }

            //once finished the search of ids, create the association whith curso correspondent
            String sql4 = "INSERT INTO cursoestudiante (id_curso, id_estudiante) VALUES (?,?)";
            PreparedStatement ps4 = cn.prepareStatement(sql4);
            ps4.setString(1, String.valueOf(id_curso));
            ps4.setString(2, String.valueOf(id_user));
            int saveCursoEstudiante = ps4.executeUpdate();

            //create qualifications default
            String sql5 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
            PreparedStatement ps5 = cn.prepareStatement(sql5);
            ps5.setString(1, String.valueOf(id_curso));
            ps5.setString(2, String.valueOf(id_user));
            ResultSet rs5 = ps5.executeQuery();
            while (rs5.next()) {
                id_cursoEstudiante = rs5.getInt("id_cursoEstudiante");
            }

            String sql6 = "INSERT INTO calificacion (id_cursoEstudiante, p1, p2, p3, p4) VALUES (?,?,?,?,?)";
            PreparedStatement ps6 = cn.prepareStatement(sql6);
            ps6.setString(1, String.valueOf(id_cursoEstudiante));
            ps6.setInt(2, 0);
            ps6.setInt(3, 0);
            ps6.setInt(4, 0);
            ps6.setInt(5, 0);
            int saveCalificacion = ps6.executeUpdate();

            if (saveCursoEstudiante > 0 && saveCalificacion > 0) {
                //data saved
                JOptionPane.showMessageDialog(null, "date saved");
                listCurso.removeAllItems();
                llenarComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "error al almacenar datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_GuardarActionPerformed

    private void listCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCursoActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        this.setVisible(false);

        Main_estudiante open = new Main_estudiante(id_user);
        open.setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Join_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Join_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Join_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Join_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Join_curso(id_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> listCurso;
    // End of variables declaration//GEN-END:variables
}
