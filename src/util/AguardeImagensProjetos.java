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

public class AguardeImagensProjetos
extends JFrame {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JProgressBar jProgressBar1;

    public AguardeImagensProjetos() {
        this.initComponents();
        this.jProgressBar1.setIndeterminate(true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jProgressBar1 = new JProgressBar();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel1.add((Component)this.jProgressBar1, (Object)new AbsoluteConstraints(20, 100, 350, -1));
        this.jLabel1.setFont(new Font("Lucida Sans", 0, 18));
        this.jLabel1.setText("Aguarde, carregando...");
        this.jPanel1.add((Component)this.jLabel1, (Object)new AbsoluteConstraints(100, 70, -1, -1));
        this.jLabel2.setFont(new Font("Tahoma", 0, 12));
        this.jLabel2.setText("Aguarde o carregamento do sistema");
        this.jPanel1.add((Component)this.jLabel2, (Object)new AbsoluteConstraints(100, 20, -1, 20));
        this.getContentPane().add((Component)this.jPanel1, (Object)new AbsoluteConstraints(0, 0, 390, 130));
        this.pack();
    }
}

