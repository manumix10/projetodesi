/*
 * Decompiled with CFR 0_122.
 */
package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class AguardeDownload
extends JFrame {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JProgressBar jProgressBar1;

    public AguardeDownload() {
        this.initComponents();
        this.jProgressBar1.setIndeterminate(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jProgressBar1 = new JProgressBar();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Atualiza\u00e7\u00e3o");
        this.setAlwaysOnTop(true);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jLabel1.setFont(new Font("Lucida Sans", 0, 18));
        this.jLabel1.setText("Aguarde, carregando...");
        this.jLabel2.setText("ATEN\u00c7\u00c3O: N\u00e3o desligue o computador ou interrompa este processo:");
        this.jLabel3.setText("do BLVendasMEI para seu computador.");
        this.jLabel4.setText("O sistema est\u00e1 efetuando o download da nova vers\u00e3o");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.jLabel2)).addGroup(layout.createSequentialGroup().addGap(60, 60, 60).addComponent(this.jLabel4)).addGroup(layout.createSequentialGroup().addGap(100, 100, 100).addComponent(this.jLabel3)).addGroup(layout.createSequentialGroup().addGap(90, 90, 90).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jProgressBar1, -2, 350, -2))).addContainerGap(25, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel2, -2, 20, -2).addGap(0, 0, 0).addComponent(this.jLabel4, -2, 20, -2).addGap(0, 0, 0).addComponent(this.jLabel3).addGap(16, 16, 16).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jProgressBar1, -2, -1, -2).addContainerGap(30, 32767)));
        this.pack();
    }
}

