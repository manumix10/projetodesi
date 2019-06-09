/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  componentes.UJComboBox
 */
package view;

import com.sun.corba.se.impl.util.Utility;
import componentes.UJComboBox;
import controller.ControllerProdutos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import model.ModelProdutos;
import util.Mascaras;

public class ViewEstoquePDV
extends JFrame {
    Mascaras bLMascaras = new Mascaras();
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private UJComboBox jcbProdutos;
    private JFormattedTextField jtfCodigoProduto;
    private JTextField jtfEstoque;

    public ViewEstoquePDV() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.listarProdutos();
    }

    private void initComponents() {
        this.jtfCodigoProduto = new JFormattedTextField();
        this.jLabel3 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jtfEstoque = new JTextField();
        this.jButton1 = new JButton();
        this.jcbProdutos = new UJComboBox();
        this.setDefaultCloseOperation(2);
        this.setTitle("Consulta de estoque");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.jtfCodigoProduto.setFont(new Font("Tahoma", 0, 24));
        this.jtfCodigoProduto.addKeyListener(new KeyAdapter(){

            @Override
            public void keyReleased(KeyEvent evt) {
                ViewEstoquePDV.this.jtfCodigoProdutoKeyReleased(evt);
            }
        });
        this.jLabel3.setFont(new Font("Tahoma", 0, 14));
        this.jLabel3.setText("C\u00f3digo produto:");
        this.jLabel2.setFont(new Font("Tahoma", 1, 18));
        this.jLabel2.setText("Quantidade em estoque:");
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Descri\u00e7\u00e3o do produto:");
        this.jtfEstoque.setEditable(false);
        this.jtfEstoque.setFont(new Font("Tahoma", 1, 24));
        this.jtfEstoque.setForeground(new Color(0, 102, 51));
        this.jButton1.setText("OK");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewEstoquePDV.this.jButton1ActionPerformed(evt);
            }
        });
        this.jcbProdutos.setFont(new Font("Tahoma", 0, 24));
        this.jcbProdutos.addPopupMenuListener(new PopupMenuListener(){

            @Override
            public void popupMenuCanceled(PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                ViewEstoquePDV.this.jcbProdutosPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent((Component)this.jcbProdutos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jButton1, -2, 165, -2)).addGap(18, 18, 18)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(197, 197, 197).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel2, -1, -1, 32767).addComponent(this.jtfEstoque, -2, 222, -2))).addComponent(this.jLabel3).addComponent(this.jLabel1).addComponent(this.jtfCodigoProduto, -2, 213, -2)).addContainerGap(183, 32767)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfCodigoProduto, -2, 50, -2).addGap(18, 18, 18).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent((Component)this.jcbProdutos, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfEstoque, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.jButton1, -2, 49, -2).addContainerGap()));
        this.pack();
    }

    private void jtfCodigoProdutoKeyReleased(KeyEvent evt) {
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(this.jtfCodigoProduto.getText()));
        }
        catch (NumberFormatException e) {
            Utility.printStackTrace();
        }
        this.jcbProdutos.setSelectedItem((Object)modelProdutos.getNome());
        this.jtfEstoque.setText(this.bLMascaras.arredondamentoComPontoDuasCasasString(modelProdutos.getEstoque()));
    }

    private void jcbProdutosPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        if (this.jcbProdutos.isPopupVisible()) {
            ControllerProdutos controllerProdutos = new ControllerProdutos();
            ModelProdutos modelProdutos = new ModelProdutos();
            String nomeRepresentante = "";
            nomeRepresentante = this.jcbProdutos.getSelectedItem().toString();
            modelProdutos = controllerProdutos.getProdutosController(nomeRepresentante);
            this.jtfCodigoProduto.setText(String.valueOf(modelProdutos.getCodigo()));
            this.jtfEstoque.setText(this.bLMascaras.arredondamentoComPontoDuasCasasString(modelProdutos.getEstoque()));
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void listarProdutos() {
        ControllerProdutos controllerProdutos = new ControllerProdutos();
        ArrayList listaProdutoses = new ArrayList();
        listaProdutoses = controllerProdutos.getListaProdutosController();
        this.jcbProdutos.removeAllItems();
        for (int i = 0; i < listaProdutoses.size(); ++i) {
            this.jcbProdutos.addItem((Object)((ModelProdutos)listaProdutoses.get(i)).getNome());
        }
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
            Logger.getLogger(ViewEstoquePDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewEstoquePDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewEstoquePDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewEstoquePDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewEstoquePDV().setVisible(true);
            }
        });
    }

}

