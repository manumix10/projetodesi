/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import util.Aguarde;

public class Autenticando
extends JFrame {
    private JLabel jLabel1;
    private JProgressBar jProgressBar1;

    public Autenticando() {
        this.initComponents();
        this.jProgressBar1.setIndeterminate(true);
        this.setLocationRelativeTo(null);
    }

    public void setarMensagem(String pTexto) {
        this.jLabel1.setText(pTexto);
    }

    private void initComponents() {
        this.jProgressBar1 = new JProgressBar();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(0);
        this.setTitle("Autentica\u00e7\u00e3o do sistema");
        this.setAlwaysOnTop(true);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jProgressBar1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.jLabel1.setFont(new Font("Lucida Sans", 0, 12));
        this.jLabel1.setText("autenticando o sistema....");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(110, 110, 110).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jProgressBar1, -2, 350, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jProgressBar1, -2, -1, -2).addContainerGap(26, 32767)));
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
            Logger.getLogger(Aguarde.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(Aguarde.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(Aguarde.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Aguarde.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Aguarde().setVisible(true);
            }
        });
    }

}

