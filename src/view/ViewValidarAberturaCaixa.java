package view;

import controller.ControllerPermissaousuario;
import controller.ControllerUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.ModelPermissaousuario;
import model.ModelUsuario;
import view.ViewAbrirFecharCaixa;

public class ViewValidarAberturaCaixa
extends JDialog {
    private ViewAbrirFecharCaixa viewAbrirFecharCaixa;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField tfLogin;
    private JPasswordField tfSenha;

    public ViewValidarAberturaCaixa(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.viewAbrirFecharCaixa = new ViewAbrirFecharCaixa(parent, true);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.tfLogin = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.tfSenha = new JPasswordField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel3 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Autentica\u00e7\u00e3o de usu\u00e1rio");
        this.jLabel1.setText("Login:");
        this.jLabel2.setText("Senha:");
        this.jButton1.setBackground(new Color(0, 204, 153));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Apply.png")));
        this.jButton1.setText("Confirmar");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewValidarAberturaCaixa.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setBackground(new Color(204, 102, 0));
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.jButton2.setText("Cancelar");
        this.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewValidarAberturaCaixa.this.jButton2ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setForeground(new Color(0, 102, 102));
        this.jLabel3.setText("Entre com login e senha com permiss\u00e3o de abertura e fechamento de caixa.");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING).addComponent(this.tfLogin, GroupLayout.Alignment.LEADING).addComponent(this.tfSenha, GroupLayout.Alignment.LEADING, -2, 330, -2)).addGap(102, 102, 102)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(45, 45, 45).addComponent(this.jButton1, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton2).addGap(31, 31, 31)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tfLogin, -2, -1, -2).addGap(19, 19, 19).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.tfSenha, -2, -1, -2).addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(24, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        modelUsuario.setLogin(this.tfLogin.getText());
        modelUsuario.setSenha(new String(this.tfSenha.getPassword()));
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ArrayList listaModelPermissaousuarios = new ArrayList();
        boolean validaEntrada = false;
        if (controllerUsuario.getUsuarioController(modelUsuario)) {
            modelUsuario = controllerUsuario.getUsuarioController(modelUsuario.getLogin());
            listaModelPermissaousuarios = controllerPermissaousuario.getListaPermissaousuarioController(modelUsuario.getCodigo());
            for (int i = 0; i < listaModelPermissaousuarios.size(); ++i) {
                if (!((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("abrirCaixa")) continue;
                this.dispose();
                this.viewAbrirFecharCaixa.setVisible(true);
                validaEntrada = true;
            }
            if (!validaEntrada) {
                JOptionPane.showMessageDialog(this, "Usu\u00e1rio n\u00e3o tem permiss\u00e3o para abrir e fechar o caixa!", "Aviso", 2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usu\u00e1rio/Senha inv\u00e1lida.", "Aviso", 2);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(ViewValidarAberturaCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewValidarAberturaCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewValidarAberturaCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewValidarAberturaCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewValidarAberturaCaixa dialog = new ViewValidarAberturaCaixa(new JFrame(), true);
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

