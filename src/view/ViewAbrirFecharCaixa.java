
package view;

import controller.ControllerAberturaCaixaPDV;
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
import java.sql.Date;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.ModelAberturaCaixaPDV;
import model.ModelSessaoUsuario;
import util.BLDatas;
import util.BLMascaras;
import view.ViewPdv;

public class ViewAbrirFecharCaixa
extends JDialog {
    ControllerAberturaCaixaPDV controllerAberturaCaixaPDV = new ControllerAberturaCaixaPDV();
    ModelAberturaCaixaPDV modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
    ArrayList<ModelAberturaCaixaPDV> listaAberturaCaixaPDVs = new ArrayList();
    private ModelSessaoUsuario sessaoUsuario = new ModelSessaoUsuario();
    BLDatas bLDatas = new BLDatas();
    BLMascaras bLMascaras = new BLMascaras();
    private JButton btConfirmar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JTextField tfDiferencaValorAberturaFechamento;
    private JTextField tfValorAbertura;
    private JTextField tfValorFechamento;

    public ViewAbrirFecharCaixa(Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        this.initComponents();
        this.iniciaInterface();
        this.calcularValorDifereca();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.tfValorAbertura = new JTextField();
        this.btConfirmar = new JButton();
        this.jLabel1 = new JLabel();
        this.tfDiferencaValorAberturaFechamento = new JTextField();
        this.jLabel2 = new JLabel();
        this.tfValorFechamento = new JTextField();
        this.jLabel3 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Valor de Abertura e Fechamento de Caixa ");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.tfValorAbertura.setFont(new Font("Tahoma", 0, 24));
        this.tfValorAbertura.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAbrirFecharCaixa.this.tfValorAberturaActionPerformed(evt);
            }
        });
        this.btConfirmar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Apply.png")));
        this.btConfirmar.setText("Confirmar");
        this.btConfirmar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAbrirFecharCaixa.this.btConfirmarActionPerformed(evt);
            }
        });
        this.jLabel1.setText("Valor inicial de abertura de caixa");
        this.tfDiferencaValorAberturaFechamento.setEditable(false);
        this.tfDiferencaValorAberturaFechamento.setFont(new Font("Tahoma", 0, 24));
        this.tfDiferencaValorAberturaFechamento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAbrirFecharCaixa.this.tfDiferencaValorAberturaFechamentoActionPerformed(evt);
            }
        });
        this.jLabel2.setText("Diferen\u00e7a abertura x fechamento (Venda)");
        this.tfValorFechamento.setEditable(false);
        this.tfValorFechamento.setFont(new Font("Tahoma", 0, 24));
        this.jLabel3.setText("Valor de fechamento de caixa");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.tfDiferencaValorAberturaFechamento, GroupLayout.Alignment.LEADING, -1, 200, 32767).addComponent(this.tfValorAbertura, GroupLayout.Alignment.LEADING).addComponent(this.tfValorFechamento, GroupLayout.Alignment.LEADING))).addComponent(this.btConfirmar, -2, 322, -2)).addGap(96, 96, 96)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(42, 42, 42).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfValorAbertura, -2, 35, -2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfValorFechamento, -2, 35, -2).addComponent(this.jLabel3)).addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.tfDiferencaValorAberturaFechamento, -2, 35, -2).addComponent(this.jLabel2)).addGap(44, 44, 44).addComponent(this.btConfirmar).addGap(20, 20, 20)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }

    private void tfValorAberturaActionPerformed(ActionEvent evt) {
    }

    private void btConfirmarActionPerformed(ActionEvent evt) {
        ViewPdv pdv = null;
        this.modelAberturaCaixaPDV = new ModelAberturaCaixaPDV();
        if (this.tfValorAbertura.getText().equals("")) {
            this.modelAberturaCaixaPDV.setValorAbertura(0.0);
        } else {
            this.modelAberturaCaixaPDV.setValorAbertura(Double.parseDouble(this.tfValorAbertura.getText()));
        }
        if (this.tfValorFechamento.getText().equals("")) {
            this.modelAberturaCaixaPDV.setValorFechamento(Double.parseDouble(this.tfValorAbertura.getText()));
        } else {
            this.modelAberturaCaixaPDV.setValorFechamento(Double.parseDouble(this.tfValorFechamento.getText()));
        }
        this.modelAberturaCaixaPDV.setCodigoUsuario(ModelSessaoUsuario.codigo);
        try {
            this.modelAberturaCaixaPDV.setData(this.bLDatas.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        }
        catch (Exception ex) {
            Logger.getLogger(ViewAbrirFecharCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.tfValorAbertura.isEnabled()) {
            this.modelAberturaCaixaPDV.setStatus(1);
            this.controllerAberturaCaixaPDV.salvarAberturaCaixaPDVController(this.modelAberturaCaixaPDV);
            pdv = new ViewPdv();
        } else {
            this.modelAberturaCaixaPDV.setStatus(0);
            this.controllerAberturaCaixaPDV.atualizarAberturaCaixaPDVController(this.modelAberturaCaixaPDV);
            System.exit(0);
        }
        this.dispose();
        if (pdv != null) {
            pdv.setVisible(true);
        }
    }

    private void tfDiferencaValorAberturaFechamentoActionPerformed(ActionEvent evt) {
    }

    private void iniciaInterface() {
        this.modelAberturaCaixaPDV = this.controllerAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioController(ModelSessaoUsuario.codigo);
        if (this.modelAberturaCaixaPDV.getStatus() == 1) {
            this.tfValorAbertura.setText(this.modelAberturaCaixaPDV.getValorAbertura().toString());
            this.tfValorFechamento.setText(this.modelAberturaCaixaPDV.getValorFechamento().toString());
            this.tfValorAbertura.setEnabled(false);
        } else {
            this.tfValorAbertura.setEnabled(true);
        }
    }

    private void calcularValorDifereca() {
        double valorAbertura = this.tfValorAbertura.getText().equals("") ? 0.0 : Double.parseDouble(this.tfValorAbertura.getText());
        double valorFechamento = this.tfValorFechamento.getText().equals("") ? 0.0 : Double.parseDouble(this.tfValorFechamento.getText());
        this.tfDiferencaValorAberturaFechamento.setText(this.bLMascaras.arredondamentoDoubleComPontoDuasCasasString(valorFechamento - valorAbertura));
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
            Logger.getLogger(ViewAbrirFecharCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewAbrirFecharCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewAbrirFecharCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewAbrirFecharCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                ViewAbrirFecharCaixa dialog = new ViewAbrirFecharCaixa(new JFrame(), true);
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

