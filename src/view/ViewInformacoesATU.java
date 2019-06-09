/*
 * Decompiled with CFR 0_122.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewInformacoesATU
extends JDialog {
    private JScrollPane jScrollPane1;
    private JTextPane jTextPane1;
    private JButton jbOk;

    public ViewInformacoesATU(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTextPane1 = new JTextPane();
        this.jbOk = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Informa\u00e7\u00f5es sobre Atualiza\u00e7\u00f5es");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.jTextPane1.setEditable(false);
        this.jTextPane1.setFont(new Font("Tahoma", 0, 14));
        this.jTextPane1.setText("- Atualiza\u00e7\u00e3o do estoque PDV\n- Inclus\u00e3o de vers\u00e3o com rede\n- Possibilidade de efetuar uma venda no PDV usando apenas o teclado");
        this.jScrollPane1.setViewportView(this.jTextPane1);
        this.jbOk.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/OK.png")));
        this.jbOk.setText("Ok");
        this.jbOk.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewInformacoesATU.this.jbOkActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 654, -2)).addGroup(layout.createSequentialGroup().addGap(279, 279, 279).addComponent(this.jbOk, -2, 107, -2))).addContainerGap(22, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 325, -2).addGap(26, 26, 26).addComponent(this.jbOk).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jbOkActionPerformed(ActionEvent evt) {
        this.dispose();
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
            Logger.getLogger(ViewInformacoesATU.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewInformacoesATU.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewInformacoesATU.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewInformacoesATU.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewInformacoesATU dialog = new ViewInformacoesATU(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter(){

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }

        });
    }

}

