/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.netbeans.lib.awtextra.AbsoluteConstraints
 *  org.netbeans.lib.awtextra.AbsoluteLayout
 */
package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Aguarde
extends JFrame {
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;

    public Aguarde() {
        this.initComponents();
        this.jProgressBar1.setIndeterminate(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jProgressBar1 = new JProgressBar();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel1.add((Component)this.jProgressBar1, (Object)new AbsoluteConstraints(10, 60, 350, -1));
        this.jLabel1.setFont(new Font("Lucida Sans", 0, 18));
        this.jLabel1.setText("Aguarde, carregando...");
        this.jPanel1.add((Component)this.jLabel1, (Object)new AbsoluteConstraints(90, 20, -1, -1));
        this.getContentPane().add((Component)this.jPanel1, (Object)new AbsoluteConstraints(0, 0, 370, 90));
        this.pack();
    }
}

