/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AguardeGerandoRelatorio
extends JFrame {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;

    public AguardeGerandoRelatorio() {
        this.initComponents();
        this.jProgressBar1.setIndeterminate(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jProgressBar1 = new JProgressBar();
        this.setDefaultCloseOperation(2);
        this.setTitle("Carregando...");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.jLabel2.setFont(new Font("Tahoma", 0, 12));
        this.jLabel2.setText("Aguarde gerando relat\u00f3rio");
        this.jLabel1.setFont(new Font("Lucida Sans", 0, 18));
        this.jLabel1.setText("carregando...");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(123, 123, 123).addComponent(this.jLabel2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(138, 138, 138).addComponent(this.jLabel1))).addContainerGap(134, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 25, 32767).addComponent(this.jProgressBar1, -2, 350, -2).addGap(0, 25, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jLabel2, -2, 20, -2).addGap(18, 18, 18).addComponent(this.jLabel1).addContainerGap(34, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(90, 90, 90).addComponent(this.jProgressBar1, -2, -1, -2).addGap(0, 10, 32767))));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));
        this.pack();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) continue;
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AguardeGerandoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(AguardeGerandoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(AguardeGerandoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AguardeGerandoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new AguardeGerandoRelatorio().setVisible(true);
            }
        });
    }

}

