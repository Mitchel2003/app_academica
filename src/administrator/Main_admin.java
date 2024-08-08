package administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import projectbd.*;

public class Main_admin extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();
    
    public Main_admin() {
        initComponents();
        this.setLocationRelativeTo(null);  
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButtonGoToDepartamento = new javax.swing.JButton();
        jButtonGoToProfesor = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonGoToCurso = new javax.swing.JButton();
        jButtonGoToEstudiante = new javax.swing.JButton();
        jButtonGoToEvaluacion = new javax.swing.JButton();
        jButtonGoToTipoEvaluacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/background_login.jpg"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setFocusable(false);

        jButtonGoToDepartamento.setBackground(new java.awt.Color(0, 0, 0));
        jButtonGoToDepartamento.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToDepartamento.setText("Create Departamento");
        jButtonGoToDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToDepartamentoActionPerformed(evt);
            }
        });

        jButtonGoToProfesor.setBackground(new java.awt.Color(102, 102, 0));
        jButtonGoToProfesor.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToProfesor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToProfesor.setText("Create Profesor");
        jButtonGoToProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToProfesorActionPerformed(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(255, 102, 102));
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/back.png"))); // NOI18N
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonGoToCurso.setBackground(new java.awt.Color(102, 0, 51));
        jButtonGoToCurso.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToCurso.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToCurso.setText("Create Curso");
        jButtonGoToCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToCursoActionPerformed(evt);
            }
        });

        jButtonGoToEstudiante.setBackground(new java.awt.Color(51, 0, 102));
        jButtonGoToEstudiante.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToEstudiante.setText("Create Estudiante");
        jButtonGoToEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToEstudianteActionPerformed(evt);
            }
        });

        jButtonGoToEvaluacion.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGoToEvaluacion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToEvaluacion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToEvaluacion.setText("Gestion Evaluacion");
        jButtonGoToEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToEvaluacionActionPerformed(evt);
            }
        });

        jButtonGoToTipoEvaluacion.setBackground(new java.awt.Color(0, 102, 102));
        jButtonGoToTipoEvaluacion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jButtonGoToTipoEvaluacion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGoToTipoEvaluacion.setText("Gestion TipoEvaluacion");
        jButtonGoToTipoEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToTipoEvaluacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGoToDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGoToProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGoToCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGoToEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGoToTipoEvaluacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGoToEvaluacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGoToDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGoToProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGoToCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGoToEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButtonGoToEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGoToTipoEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.setVisible(false);
        
        Interfaz inter=new Interfaz();
        inter.setVisible(true);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonGoToDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToDepartamentoActionPerformed

        this.setVisible(false);
        
        Departamento adminDepartament=new Departamento();
        adminDepartament.setVisible(true);
    }//GEN-LAST:event_jButtonGoToDepartamentoActionPerformed

    private void jButtonGoToProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToProfesorActionPerformed
        this.setVisible(false);
        
        Profesor adminProfesor=new Profesor();
        adminProfesor.setVisible(true);
    }//GEN-LAST:event_jButtonGoToProfesorActionPerformed

    private void jButtonGoToCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToCursoActionPerformed
        this.setVisible(false);
        
        Curso adminCurso=new Curso();
        adminCurso.setVisible(true);
    }//GEN-LAST:event_jButtonGoToCursoActionPerformed

    private void jButtonGoToEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToEstudianteActionPerformed
        this.setVisible(false);
        
        Estudiante adminEstudiante=new Estudiante();
        adminEstudiante.setVisible(true);
    }//GEN-LAST:event_jButtonGoToEstudianteActionPerformed

    private void jButtonGoToEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToEvaluacionActionPerformed
        this.setVisible(false);
        
        Evaluacion adminEvaluacion=new Evaluacion();
        adminEvaluacion.setVisible(true);
    }//GEN-LAST:event_jButtonGoToEvaluacionActionPerformed

    private void jButtonGoToTipoEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToTipoEvaluacionActionPerformed
        this.setVisible(false);
        
        TipoEvaluacion adminTipoE=new TipoEvaluacion();
        adminTipoE.setVisible(true);
    }//GEN-LAST:event_jButtonGoToTipoEvaluacionActionPerformed

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
                new Main_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGoToCurso;
    private javax.swing.JButton jButtonGoToDepartamento;
    private javax.swing.JButton jButtonGoToEstudiante;
    private javax.swing.JButton jButtonGoToEvaluacion;
    private javax.swing.JButton jButtonGoToProfesor;
    private javax.swing.JButton jButtonGoToTipoEvaluacion;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
