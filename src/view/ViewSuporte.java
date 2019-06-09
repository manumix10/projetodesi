/*
 * Decompiled with CFR 0_122.
 */
package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ViewSuporte
extends JDialog {
    private JScrollPane jScrollPane1;
    private JTextPane jTextPane1;
    private JButton jbOk;

    public ViewSuporte(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTextPane1 = new JTextPane();
        this.jbOk = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Contato para suporte");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.jTextPane1.setEditable(false);
        this.jTextPane1.setFont(new Font("Tahoma", 0, 14));
        this.jTextPane1.setText("SENHA PADR\u00c3O:\nUSU\u00c1RIO: admin\nSENHA: admin\n\nContato para Suporte:\nTelefone: 98150-1313\n");
        this.jScrollPane1.setViewportView(this.jTextPane1);
        this.jbOk.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/OK.png")));
        this.jbOk.setText("Ok");
        this.jbOk.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewSuporte.this.jbOkActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 0, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jbOk, -2, 107, -2).addContainerGap(149, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.jbOk).addContainerGap()));
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
            Logger.getLogger(ViewSuporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewSuporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewSuporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewSuporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewSuporte dialog = new ViewSuporte(new JFrame(), true);
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

