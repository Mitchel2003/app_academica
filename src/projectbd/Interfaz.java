package projectbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import administrator.*;
import profesor.Main_profesor;
import estudiante.Main_estudiante;

public class Interfaz extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);  
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonEntry = new javax.swing.JButton();
        jButtonRegist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/background_login.jpg"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setFocusable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/image.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusable(false);

        jButtonExit.setBackground(new java.awt.Color(255, 102, 102));
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/logout.png"))); // NOI18N
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExitMouseExited(evt);
            }
        });
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/login-session.jpg"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(31, 67, 124));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingreso Sistema");

        txtUser.setBackground(new java.awt.Color(25, 25, 25));
        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User");

        txtCode.setBackground(new java.awt.Color(25, 25, 25));
        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCode.setForeground(new java.awt.Color(255, 255, 255));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo");

        jButtonEntry.setBackground(new java.awt.Color(0, 75, 114));
        jButtonEntry.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButtonEntry.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntry.setText("Entry");
        jButtonEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntryActionPerformed(evt);
            }
        });

        jButtonRegist.setBackground(new java.awt.Color(0, 74, 114));
        jButtonRegist.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButtonRegist.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegist.setText("Register");
        jButtonRegist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRegist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEntry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 191, Short.MAX_VALUE)
                    .addComponent(jLabel1)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean verificarCredenciales(String tipo) {
        
        String usuario = txtUser.getText();
        String codigo = txtCode.getText();
    
        try {
            // Realiza una consulta SQL para verificar las credenciales en la base de datos
            String sql = "";
            
            if (tipo.equals("Profesor")) {
                sql = "SELECT * FROM profesor WHERE id_profesor = ? AND nombre = ?";
            } 
            
            else if (tipo.equals("Estudiante")) {
                sql = "SELECT * FROM estudiante WHERE id_estudiante = ? AND nombre = ?";
            } 
            
            else if (tipo.equals("Administrador"))
                 sql = "SELECT * FROM administrador WHERE id_admin = ? AND nombre = ?";
            
            else {
                return false; 
            }

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, usuario);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Devuelve true si se encuentra un registro que coincide, de lo contrario, false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void jButtonEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntryActionPerformed
        String id_user = txtCode.getText();
        
        // Verificar si las credenciales corresponden a un profesor
    if (verificarCredenciales("Profesor")) {
        Main_profesor profesor = new Main_profesor(id_user);
        profesor.setVisible(true);
        dispose(); // Cierra la ventana de inicio de sesión
    }
    // Verificar si las credenciales corresponden a un estudiante
    else if (verificarCredenciales("Estudiante")) {
        Main_estudiante estudiante = new Main_estudiante(id_user);
        estudiante.setVisible(true);
        dispose();
    }
    else if (verificarCredenciales("Administrador")) {
        
    }
    else {
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
    }
        
    }//GEN-LAST:event_jButtonEntryActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void jButtonRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistActionPerformed
            this.setVisible(false);
        
            TypePerson open=new TypePerson();
            open.setVisible(true);
    }//GEN-LAST:event_jButtonRegistActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void jButtonExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExitMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExitMouseEntered

    private void jButtonExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExitMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExitMouseExited

    //main - first view
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
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntry;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRegist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
