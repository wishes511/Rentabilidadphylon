/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentabilidadphylon;

import DAO.Producto;
import DAO.Reportes;
import java.awt.Color;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.reporte;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import validacion.validar;

/**
 *
 * @author Michelon
 */
public class Reporte extends javax.swing.JInternalFrame implements Runnable{

    public ButtonGroup bg = new ButtonGroup();
    public ButtonGroup bg2 = new ButtonGroup();
    public ButtonGroup bg3 = new ButtonGroup();
    DateFormat df = DateFormat.getDateInstance();
    DefaultComboBoxModel modelo;
    int l=0;

    public Reporte() {
        super("Reporte de Rentabilidad");
        initComponents();
        t2.setVisible(false);
        combo.setEnabled(false);
        combo.setEditable(false);
        t4.setSelected(true);
        t1.setSelected(true);
        all1.setSelected(true);
        bg.add(t1);
        bg.add(t2);
        bg.add(t3);
        bg2.add(all1);
        bg2.add(all3);
        bg3.add(t4);
        bg3.add(t5);
        loading.setVisible(false);
        jp1.setVisible(false);
        jp1.setOpaque(true);
        jp1.setBackground( new Color(255, 255, 255, 150) );
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        loading = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        f1 = new com.toedter.calendar.JDateChooser();
        f2 = new com.toedter.calendar.JDateChooser();
        all1 = new javax.swing.JRadioButton();
        all3 = new javax.swing.JRadioButton();
        combo = new javax.swing.JComboBox<>();
        t3 = new javax.swing.JRadioButton();
        t2 = new javax.swing.JRadioButton();
        t1 = new javax.swing.JRadioButton();
        ok = new org.edisoncor.gui.button.ButtonAero();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        t5 = new javax.swing.JRadioButton();
        t4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte de rentabilidad");
        setPreferredSize(new java.awt.Dimension(1028, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loading.setIcon(new javax.swing.ImageIcon("C:\\af\\Rentabilidad\\images\\cargando.gif")); // NOI18N
        getContentPane().add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jp1.setOpaque(false);
        getContentPane().add(jp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 570));

        f1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 200, 30));

        f2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 200, 30));

        all1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        all1.setText("   Todos");
        all1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all1MouseClicked(evt);
            }
        });
        all1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all1ActionPerformed(evt);
            }
        });
        getContentPane().add(all1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        all3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                all3ActionPerformed(evt);
            }
        });
        getContentPane().add(all3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, -1));

        combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboMouseClicked(evt);
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 190, 40));

        t3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        t3.setText("Linea");
        t3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t3MouseClicked(evt);
            }
        });
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        t2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        t2.setText("Agente");
        t2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t2MouseClicked(evt);
            }
        });
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        t1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        t1.setText("Cliente");
        t1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t1MouseClicked(evt);
            }
        });
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        ok.setBackground(new java.awt.Color(204, 204, 204));
        ok.setText("Generar reporte");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/validacion/barraCAL.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 940, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/validacion/barraall.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 502, 1000, -1));

        t5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        t5.setText("Detallado");
        t5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t5MouseClicked(evt);
            }
        });
        t5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t5ActionPerformed(evt);
            }
        });
        getContentPane().add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, -1, -1));

        t4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        t4.setText("Condensado");
        t4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t4MouseClicked(evt);
            }
        });
        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });
        getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/validacion/fondoreport.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        all1.setSelected(true);
        combo.setEnabled(false);
        all1.requestFocus();
    }//GEN-LAST:event_t1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        all1.setSelected(true);
        combo.setEnabled(false);
    }//GEN-LAST:event_t2ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        all1.setSelected(true);
        combo.setEnabled(false);
    }//GEN-LAST:event_t3ActionPerformed

    private void all1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all1ActionPerformed
        t4.requestFocus();
    }//GEN-LAST:event_all1ActionPerformed

    private void all3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_all3ActionPerformed
        //all2.setVisible(true);
        llenacombo();
        //combo.setEditable(false);
        combo.requestFocus();
        combo.setEnabled(true);
    }//GEN-LAST:event_all3ActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        setreport();
    }//GEN-LAST:event_okActionPerformed

    private void comboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboMouseClicked

    }//GEN-LAST:event_comboMouseClicked

    private void t1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t1MouseClicked
        all1.setSelected(true);
        combo.setEnabled(false);
        t4.requestFocus();
    }//GEN-LAST:event_t1MouseClicked

    private void t2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t2MouseClicked
        all1.setSelected(true);
        combo.setEnabled(false);
    }//GEN-LAST:event_t2MouseClicked

    private void t3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t3MouseClicked
        all1.setSelected(true);
        combo.setEnabled(false);
    }//GEN-LAST:event_t3MouseClicked

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        t4.requestFocus();
    }//GEN-LAST:event_comboActionPerformed

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        ok.requestFocus();
    }//GEN-LAST:event_t4ActionPerformed

    private void t5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t5ActionPerformed
        ok.requestFocus();
    }//GEN-LAST:event_t5ActionPerformed

    private void t4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t4MouseClicked
        ok.requestFocus();
    }//GEN-LAST:event_t4MouseClicked

    private void t5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t5MouseClicked
        ok.requestFocus();
    }//GEN-LAST:event_t5MouseClicked

    private void all1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all1MouseClicked
        t4.requestFocus();
    }//GEN-LAST:event_all1MouseClicked

    private void setreport() {
        String nombre = (all1.isSelected()) ? "" : combo.getSelectedItem().toString();
        String tipo = (t1.isSelected()) ? "index" : (t2.isSelected()) ? "indexAg" : "indexlin";
        String tiporeporte = (t4.isSelected()) ? "" : "detalle";
        try {
            ConcurrentHashMap parametross = new ConcurrentHashMap();
            parametross.put("f1", df.format(f1.getDate()));
            parametross.put("f2", df.format(f2.getDate()));
            parametross.put("nombre", nombre);
            Producto pdb = new Producto();
            //System.out.println(tipo+tiporeporte);    
            jp1.setVisible(true);
            loading.setVisible(true);
            
           //JOptionPane.showMessageDialog(null, "Cargando reporte espere pofavor...","Carga de reporte",JOptionPane.);
            JOptionPane.showMessageDialog(null, "Cargando reporte espere pofavor...");
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource(tipo + tiporeporte + ".jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametross, pdb.getconexion());
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            loading.setVisible(false);
            jp1.setVisible(false);
           // JOptionPane.showMessageDialog(null, "");
            ver.setTitle("Rentabilidad");
            ver.setVisible(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No puedes dejar las fechas vacias!, Verificalo.");
            JOptionPane.showMessageDialog(null, e.getCause()+e.getMessage());
            f1.requestFocus();
        } catch (net.sf.jasperreports.engine.JRException es) {
            JOptionPane.showMessageDialog(null, "Error con algunos de los archivos para la generación del reporte.");
            es.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause() + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error desconocido llame a un administrador.\n Causa del error: \n" + e);
            e.printStackTrace();
        }
    }

    public void llenacombo() {
        Reportes r = new Reportes();
        String tabla = (t1.isSelected()) ? "Clientes" : (t2.isSelected()) ? "Agentes" : "Lineas";
        String campo = (t3.isSelected()) ? "Descripcion" : "Nombre";
        Connection conexion = (t1.isSelected() || t2.isSelected()) ? r.getconexion("cliente") : r.getconexion("linea");
        ArrayList<reporte> resp = new ArrayList<reporte>();
        resp = r.getallnombre(tabla, campo, conexion);
        String labels[] = new String[resp.size()];
        for (int i = 0; i < resp.size(); i++) {
            labels[i] = resp.get(i).getNombre();
        }
        modelo = new DefaultComboBoxModel(labels);
        combo.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all1;
    private javax.swing.JRadioButton all3;
    private javax.swing.JComboBox<String> combo;
    private com.toedter.calendar.JDateChooser f1;
    private com.toedter.calendar.JDateChooser f2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jp1;
    private javax.swing.JLabel loading;
    private org.edisoncor.gui.button.ButtonAero ok;
    private javax.swing.JRadioButton t1;
    private javax.swing.JRadioButton t2;
    private javax.swing.JRadioButton t3;
    private javax.swing.JRadioButton t4;
    private javax.swing.JRadioButton t5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
    
    }

}
