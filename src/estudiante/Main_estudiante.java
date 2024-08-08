package estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectbd.Interfaz;
import projectbd.InterfazClass;

/**
 *
 * @author aprendiz
 */
public class Main_estudiante extends javax.swing.JFrame {

    InterfazClass con = new InterfazClass();
    Connection cn = con.conexion();

    //variables globals
    private static String id_user = "";

    //list
    private static ArrayList<String> list_evaluacion = new ArrayList<>();

    //estudiante
    private static ArrayList<String> id_curso = new ArrayList<>();
    private static ArrayList<String> name_curso = new ArrayList<>();
    
    

    public Main_estudiante(String id_user) {
        this.id_user = id_user;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        llenarComboBox();
        setLabel();
    }

    public void setLabel() {
        String sql = "SELECT nombre FROM estudiante WHERE id_estudiante = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id_user);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                jLabel7.setText("Welcome student " + rs.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al llenar el combo box", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarComboBox() {
        try {
            String sql2 = "SELECT id_curso FROM cursoestudiante WHERE id_estudiante = ?";
            PreparedStatement ps2 = cn.prepareStatement(sql2);
            ps2.setString(1, id_user);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id_curso.add(rs2.getString("id_curso"));
            }
            
            for(int i =0; i<id_curso.size(); i++){
                String sql = "SELECT nombreCurso FROM curso WHERE id_curso = ?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, id_curso.get(i));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    name_curso.add(rs.getString("nombreCurso"));
                }
            }
            
            for(int i=0; i<name_curso.size(); i++){
                comboBoxCurso.addItem(name_curso.get(i));
            }
            
            id_curso.clear();
            name_curso.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void mostrartabla() {
        try {

            DefaultTableModel modelo2 = new DefaultTableModel();

            String cursoSelected = (String) comboBoxCurso.getSelectedItem();
            String id_cursoContext = "";
            String id_cursoEstudiante = "";

            String ask = "SELECT id_curso FROM curso WHERE nombreCurso = ?";
            PreparedStatement psp = cn.prepareStatement(ask);
            psp.setString(1, cursoSelected);
            ResultSet rsr = psp.executeQuery();
            while (rsr.next()) {
                id_cursoContext = rsr.getString("id_curso");
            }

//            //select some student into "cursoContext" 
//            String ask3 = "SELECT id_cursoEstudiante FROM cursoestudiante WHERE id_curso = ? AND id_estudiante = ?";
//            PreparedStatement psp3 = cn.prepareStatement(ask3);
//            psp3.setString(1, id_cursoContext);
//            psp3.setString(1, id_user);
//            ResultSet rsr3 = psp3.executeQuery();
//            while (rsr3.next()) {
//                id_cursoEstudiante = rsr3.getString("id_cursoEstudiante");
//            }

            //part for know all evaluation into "cursoContext"
            String ask2 = "SELECT nombreEvaluacion FROM evaluacion WHERE id_curso = ? AND id_estudiante = ?";
            PreparedStatement psp2 = cn.prepareStatement(ask2);
            psp2.setString(1, id_cursoContext);
            psp2.setString(2, id_user);
            ResultSet rsr2 = psp2.executeQuery();
            while (rsr2.next()) {
                list_evaluacion.add(rsr2.getString("nombreEvaluacion"));
            }

            //preparated table2
            modelo2.addColumn("Type");
            modelo2.addColumn("Name activity");
            modelo2.addColumn("Date");
            modelo2.addColumn("Qualify");
            Tabla2.setModel(modelo2);

            String datos2[] = new String[4];

            for (int a = 0; a < list_evaluacion.size(); a++) {
                String id_evaluacion = "";
                String id_tipoEvaluacion = "";
                String nombreTipo = "";
                String fechaEvaluacion = "";
                String calificacion="";
                
                String ask4 = "SELECT id_evaluacion FROM evaluacion WHERE nombreEvaluacion = ? AND id_curso = ? AND id_estudiante = ?";
                PreparedStatement psp4 = cn.prepareStatement(ask4);
                psp4.setString(1, list_evaluacion.get(a));
                psp4.setString(2, id_cursoContext);
                psp4.setString(3, id_user);
                ResultSet rsr4 = psp4.executeQuery();
                while (rsr4.next()) {
                    id_evaluacion = rsr4.getString("id_evaluacion");
                }
                
                String ask5 = "SELECT * FROM evaluacion WHERE id_evaluacion = ?";
                PreparedStatement psp5 = cn.prepareStatement(ask5);
                psp5.setString(1, id_evaluacion);
                ResultSet rsr5 = psp5.executeQuery();
                while (rsr5.next()) {
                    fechaEvaluacion = rsr5.getString(3);
                    calificacion = rsr5.getString(4);
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

                //working here...
                datos2[0] = nombreTipo;
                datos2[1] = list_evaluacion.get(a);
                datos2[2] = fechaEvaluacion;
                datos2[3] = calificacion;

                modelo2.addRow(datos2);
                Tabla2.setModel(modelo2);
            }
            Tabla2.getColumnModel().getColumn(3).setPreferredWidth(20);
            Tabla2.setModel(modelo2);           

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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        comboBoxCurso = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROFESOR");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(68, 45, 114));
        jPanel1.setToolTipText("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectbd/image/background_profesor.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setFocusable(false);

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

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Curso");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Activities");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("if have some dude, contact teacher of course");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("These are your courses");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 409, Short.MAX_VALUE)))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, Short.MAX_VALUE))
        );

        jMenuBar1.setToolTipText("Estudiante");

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
        jCheckBoxMenuItem2.setText("Join to curso");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        this.setVisible(false);

        Join_curso open = new Join_curso(id_user);
        open.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        this.setVisible(false);

        Interfaz admin = new Interfaz();
        admin.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenu2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2StateChanged

    private void comboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCursoActionPerformed

    private void comboBoxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCursoItemStateChanged
        list_evaluacion.clear();
        mostrartabla();
    }//GEN-LAST:event_comboBoxCursoItemStateChanged

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
            java.util.logging.Logger.getLogger(Main_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_estudiante(id_user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla2;
    private javax.swing.JComboBox<String> comboBoxCurso;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
