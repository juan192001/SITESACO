/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SITESACO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juanarcilagomez
 */
public class Registropaci extends javax.swing.JFrame {

    Persistencia persistencia = new Persistencia();
    ArrayList<Persona> pacientes = new ArrayList<Persona>();
    ArrayList<Persona> medicos = new ArrayList<Persona>();
    String txtPacientes = Persistencia.readFromFile("pacientes.txt");

    /**
     * Creates new form Registropaci
     */
    public Registropaci() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (txtPacientes != null) {
            pacientes = Pacientes.convertirTXTaObjetos(txtPacientes, medicos);
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

        jLabel4 = new javax.swing.JLabel();
        Angiologia = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        docpaci = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombrepaci = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechaingpaci = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fechanacipaci = new javax.swing.JTextField();
        tratamiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Angiologia.setBackground(new java.awt.Color(211, 229, 242));

        jPanel3.setBackground(new java.awt.Color(0, 166, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 166, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setText("GESTION EPS SITESACO");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("MENU PRINCIPAL");

        docpaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docpaciActionPerformed(evt);
            }
        });

        jButton1.setText("Capturar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel5.setText("Documento: ");

        nombrepaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrepaciActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha de nacimiento:");

        fechaingpaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaingpaciActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de ingreso:");

        fechanacipaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechanacipaciActionPerformed(evt);
            }
        });

        tratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AngiologÌa", "DermatologÌa", "GinecologÌa", "OftamologÌa", "OtorrinolaringologÌa", "UrologÌa", "TraumatologÌa" }));
        tratamiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tratamientoItemStateChanged(evt);
            }
        });
        tratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tratamientoActionPerformed(evt);
            }
        });

        jLabel8.setText("Tratamiento");

        jButton2.setText("Regresar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AngiologiaLayout = new javax.swing.GroupLayout(Angiologia);
        Angiologia.setLayout(AngiologiaLayout);
        AngiologiaLayout.setHorizontalGroup(
            AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AngiologiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AngiologiaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AngiologiaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))))
            .addGroup(AngiologiaLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AngiologiaLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docpaci, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrepaci, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaingpaci, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechanacipaci, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        AngiologiaLayout.setVerticalGroup(
            AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AngiologiaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrepaci, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docpaci, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechanacipaci, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaingpaci, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(AngiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Angiologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Angiologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void docpaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docpaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docpaciActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
//Pacientes paci = new Pacientes(jTextField2.getText());
//paci.agregarPersona();
        Pacientes paciente = new Pacientes();

//capturar los datos del paciente
        paciente.setNombre(nombrepaci.getText());
        paciente.setDoc(docpaci.getText());
        paciente.setNacimiento(fechanacipaci.getText());
        paciente.setFechaing(fechaingpaci.getText());
        String trata = (String) tratamiento.getSelectedItem();
        paciente.setTratamiento(trata);
//mensaje de aviso de capturacion de datos
        JOptionPane.showMessageDialog(null, "Datos capturados");
        //se añade al arraylist
        pacientes.add(paciente);
        //lo guarda
        persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");
//reinicia los txt
        nombrepaci.setText("");
        docpaci.setText("");
        fechanacipaci.setText("");
        fechaingpaci.setText("");

//persistencia.guardarEnArchivoPacientes(pacientes, "pacientes.txt");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void nombrepaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrepaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrepaciActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fechaingpaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaingpaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaingpaciActionPerformed

    private void fechanacipaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechanacipaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechanacipaciActionPerformed

    private void tratamientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tratamientoItemStateChanged

// TODO add your handling code here:
    }//GEN-LAST:event_tratamientoItemStateChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Menupaci volver = new Menupaci();
        volver.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void tratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tratamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tratamientoActionPerformed

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
            java.util.logging.Logger.getLogger(Registropaci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registropaci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registropaci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registropaci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registropaci().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Angiologia;
    private javax.swing.JTextField docpaci;
    private javax.swing.JTextField fechaingpaci;
    private javax.swing.JTextField fechanacipaci;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField nombrepaci;
    private javax.swing.JComboBox<String> tratamiento;
    // End of variables declaration//GEN-END:variables
}
