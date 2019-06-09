
package view;

import controller.ControllerPermissaousuario;
import controller.ControllerUsuario;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.ModelPermissaousuario;
import model.ModelUsuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ViewUsuario
extends JFrame {
    private ButtonGroup buttonGroup1;
    private JButton jButtonAlterar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPaneTipoProduto;
    private JTable jTableUsuarios;
    private JButton jbCadastrar;
    private JButton jbCancelar;
    private JButton jbConfirmarAlteracao;
    private JButton jbExcluir;
    private JButton jbNovo;
    private JCheckBox jcbAbrirFecharCaixa;
    private JCheckBox jcbNotaFiscal;
    private JCheckBox jcbCaixa;
    private JCheckBox jcbCidades;
    private JCheckBox jcbClientes;
    private JCheckBox jcbContasPagar;
    private JCheckBox jcbContasReceber;
    private JCheckBox jcbEmpresa;
    private JCheckBox jcbFormaPagamento;
    private JCheckBox jcbFornecedores;
    private JCheckBox jcbOrcamento;
    private JCheckBox jcbProdutos;
    private JCheckBox jcbUnidadeMedida;
    private JCheckBox jcbUsuario;
    private JCheckBox jcbVendas;
    private JPanel jpCadastro;
    private JPanel jpConsulta;
    private JTextField jtfCodigo;
    private JPasswordField jtfConfirmarSenha;
    private JTextField jtfLogin;
    private JTextField jtfNome;
    private JPasswordField jtfSenha;

    public ViewUsuario() {
        this.initComponents();
        this.carregarUsuarios();
        this.setLocationRelativeTo(null);
        this.cancelarOperacao();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jTabbedPaneTipoProduto = new JTabbedPane();
        this.jpCadastro = new JPanel();
        this.jtfCodigo = new JTextField();
        this.jLabel1 = new JLabel();
        this.jtfNome = new JTextField();
        this.jLabel2 = new JLabel();
        this.jbConfirmarAlteracao = new JButton();
        this.jbCadastrar = new JButton();
        this.jbCancelar = new JButton();
        this.jbNovo = new JButton();
        this.jLabel3 = new JLabel();
        this.jtfConfirmarSenha = new JPasswordField();
        this.jLabel4 = new JLabel();
        this.jtfSenha = new JPasswordField();
        this.jLabel5 = new JLabel();
        this.jtfLogin = new JTextField();
        this.jPanel1 = new JPanel();
        this.jcbOrcamento = new JCheckBox();
        this.jcbUsuario = new JCheckBox();
        this.jcbVendas = new JCheckBox();
        this.jcbClientes = new JCheckBox();
        this.jcbProdutos = new JCheckBox();
        this.jcbContasPagar = new JCheckBox();
        this.jcbContasReceber = new JCheckBox();
        this.jcbEmpresa = new JCheckBox();
        this.jcbCaixa = new JCheckBox();
        this.jcbUnidadeMedida = new JCheckBox();
        this.jcbFormaPagamento = new JCheckBox();
        this.jcbFornecedores = new JCheckBox();
        this.jcbCidades = new JCheckBox();
        this.jcbAbrirFecharCaixa = new JCheckBox();
        this.jcbNotaFiscal = new JCheckBox();
        this.jpConsulta = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jTableUsuarios = new JTable();
        this.jbExcluir = new JButton();
        this.jButtonAlterar = new JButton();
        this.setDefaultCloseOperation(2);
        this.setTitle("Usu\u00e1rios");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.setResizable(false);
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.jpCadastro.setLayout((LayoutManager)new AbsoluteLayout());
        this.jtfCodigo.setEditable(false);
        this.jtfCodigo.setToolTipText("C\u00f3digo do tipo do produto");
        this.jtfCodigo.setEnabled(false);
        this.jpCadastro.add((Component)this.jtfCodigo, (Object)new AbsoluteConstraints(10, 30, 85, -1));
        this.jLabel1.setText("C\u00f3digo:");
        this.jpCadastro.add((Component)this.jLabel1, (Object)new AbsoluteConstraints(10, 10, -1, -1));
        this.jtfNome.setToolTipText("Descri\u00e7\u00e3o do tipo do produto");
        this.jpCadastro.add((Component)this.jtfNome, (Object)new AbsoluteConstraints(100, 30, 420, -1));
        this.jLabel2.setText("Nome:");
        this.jpCadastro.add((Component)this.jLabel2, (Object)new AbsoluteConstraints(100, 10, -1, -1));
        this.jbConfirmarAlteracao.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.jbConfirmarAlteracao.setText("Salvar Altera\u00e7\u00e3o");
        this.jbConfirmarAlteracao.setToolTipText("Confirmar altera\u00e7\u00e3o no cadastro do tipo do produto");
        this.jbConfirmarAlteracao.setEnabled(false);
        this.jbConfirmarAlteracao.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jbConfirmarAlteracaoActionPerformed(evt);
            }
        });
        this.jpCadastro.add((Component)this.jbConfirmarAlteracao, (Object)new AbsoluteConstraints(250, 330, -1, -1));
        this.jbCadastrar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Save.png")));
        this.jbCadastrar.setText("Salvar");
        this.jbCadastrar.setToolTipText("Salvar cadastro do tipo de produto");
        this.jbCadastrar.setEnabled(false);
        this.jbCadastrar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jbCadastrarActionPerformed(evt);
            }
        });
        this.jpCadastro.add((Component)this.jbCadastrar, (Object)new AbsoluteConstraints(395, 330, 130, -1));
        this.jbCancelar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/No.png")));
        this.jbCancelar.setText("Cancelar");
        this.jbCancelar.setToolTipText("Cancelar opera\u00e7\u00e3o");
        this.jbCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jbCancelarActionPerformed(evt);
            }
        });
        this.jpCadastro.add((Component)this.jbCancelar, (Object)new AbsoluteConstraints(10, 330, -1, -1));
        this.jbNovo.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Add.png")));
        this.jbNovo.setText("Novo");
        this.jbNovo.setToolTipText("Limpar todos os campos");
        this.jbNovo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jbNovoActionPerformed(evt);
            }
        });
        this.jpCadastro.add((Component)this.jbNovo, (Object)new AbsoluteConstraints(120, 330, -1, -1));
        this.jLabel3.setText("Login:");
        this.jpCadastro.add((Component)this.jLabel3, (Object)new AbsoluteConstraints(10, 70, -1, -1));
        this.jpCadastro.add((Component)this.jtfConfirmarSenha, (Object)new AbsoluteConstraints(390, 90, 130, -1));
        this.jLabel4.setText("Senha:");
        this.jpCadastro.add((Component)this.jLabel4, (Object)new AbsoluteConstraints(250, 70, -1, -1));
        this.jpCadastro.add((Component)this.jtfSenha, (Object)new AbsoluteConstraints(250, 90, 130, -1));
        this.jLabel5.setText("Confirmar senha:");
        this.jpCadastro.add((Component)this.jLabel5, (Object)new AbsoluteConstraints(390, 70, -1, -1));
        this.jpCadastro.add((Component)this.jtfLogin, (Object)new AbsoluteConstraints(10, 90, 230, -1));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("Permiss\u00f5es"));
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
        this.jcbOrcamento.setText("Or\u00e7amento");
        this.jPanel1.add((Component)this.jcbOrcamento, (Object)new AbsoluteConstraints(180, 90, -1, -1));
        this.jcbUsuario.setText("Cadastro de Usu\u00e1rio");
        this.jPanel1.add((Component)this.jcbUsuario, (Object)new AbsoluteConstraints(180, 30, -1, -1));
        this.jcbVendas.setText("Vendas e PDV");
        this.jcbVendas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jcbVendasActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jcbVendas, (Object)new AbsoluteConstraints(180, 60, -1, -1));
        this.jcbClientes.setText("Cadastro de Clientes");
        this.jPanel1.add((Component)this.jcbClientes, (Object)new AbsoluteConstraints(20, 30, -1, -1));
        this.jcbProdutos.setText("Cadastro de Produtos");
        this.jPanel1.add((Component)this.jcbProdutos, (Object)new AbsoluteConstraints(20, 60, -1, -1));
        this.jcbContasPagar.setText("Contas a pagar");
        this.jPanel1.add((Component)this.jcbContasPagar, (Object)new AbsoluteConstraints(180, 150, -1, -1));
        this.jcbContasReceber.setText("Contas a receber");
        this.jPanel1.add((Component)this.jcbContasReceber, (Object)new AbsoluteConstraints(350, 30, -1, -1));
        this.jcbEmpresa.setText("Cadastro de Empresa");
        this.jPanel1.add((Component)this.jcbEmpresa, (Object)new AbsoluteConstraints(20, 90, -1, -1));
        this.jcbCaixa.setText("Caixa");
        this.jcbCaixa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jcbCaixaActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jcbCaixa, (Object)new AbsoluteConstraints(350, 60, -1, -1));
        this.jcbUnidadeMedida.setText("Unidade de medida");
        this.jcbUnidadeMedida.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jcbUnidadeMedidaActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.jcbUnidadeMedida, (Object)new AbsoluteConstraints(20, 120, -1, -1));
        this.jcbFormaPagamento.setText("Forma de pagamento");
        this.jPanel1.add((Component)this.jcbFormaPagamento, (Object)new AbsoluteConstraints(180, 120, -1, -1));
        this.jcbFornecedores.setText("Cad. de Fornecedores");
        this.jPanel1.add((Component)this.jcbFornecedores, (Object)new AbsoluteConstraints(350, 90, -1, -1));
        this.jcbCidades.setText("Cadastro de Cidades");
        this.jPanel1.add((Component)this.jcbCidades, (Object)new AbsoluteConstraints(20, 150, -1, -1));
        this.jcbAbrirFecharCaixa.setText("Abrir e Fechar caixa PDV");
        this.jPanel1.add((Component)this.jcbAbrirFecharCaixa, (Object)new AbsoluteConstraints(350, 120, -1, -1));
        this.jcbNotaFiscal.setText("Cadastro Nota Fiscal");
        this.jPanel1.add((Component)this.jcbNotaFiscal, (Object)new AbsoluteConstraints(350, 150, -1, -1));
        this.jpCadastro.add((Component)this.jPanel1, (Object)new AbsoluteConstraints(10, 120, 520, 190));
        this.jTabbedPaneTipoProduto.addTab("Cadastro", this.jpCadastro);
        this.jTableUsuarios.setAutoCreateRowSorter(true);
        this.jTableUsuarios.setModel(new DefaultTableModel(new Object[][]{{null, null, null}}, new String[]{"C\u00f3digo", "Nome", "Login"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this.jTableUsuarios.setAutoResizeMode(0);
        this.jTableUsuarios.getTableHeader().setReorderingAllowed(false);
        this.jScrollPane2.setViewportView(this.jTableUsuarios);
        if (this.jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            this.jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(90);
            this.jTableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(250);
            this.jTableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        }
        this.jbExcluir.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Delete.png")));
        this.jbExcluir.setText("Excluir");
        this.jbExcluir.setToolTipText("Excluir tipo de produto selecionado");
        this.jbExcluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jbExcluirActionPerformed(evt);
            }
        });
        this.jButtonAlterar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/18x18/Modify.png")));
        this.jButtonAlterar.setText("Alterar");
        this.jButtonAlterar.setToolTipText("Alterar tipo de produto selecionado");
        this.jButtonAlterar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewUsuario.this.jButtonAlterarActionPerformed(evt);
            }
        });
        GroupLayout jpConsultaLayout = new GroupLayout(this.jpConsulta);
        this.jpConsulta.setLayout(jpConsultaLayout);
        jpConsultaLayout.setHorizontalGroup(jpConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpConsultaLayout.createSequentialGroup().addContainerGap().addGroup(jpConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(jpConsultaLayout.createSequentialGroup().addComponent(this.jbExcluir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 353, 32767).addComponent(this.jButtonAlterar))).addContainerGap()));
        jpConsultaLayout.setVerticalGroup(jpConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpConsultaLayout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 319, 32767).addGroup(jpConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpConsultaLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jbExcluir)).addGroup(jpConsultaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonAlterar))).addContainerGap()));
        this.jTabbedPaneTipoProduto.addTab("Consulta/Altera\u00e7\u00e3o/Exclus\u00e3o", this.jpConsulta);
        this.getContentPane().add((Component)this.jTabbedPaneTipoProduto, (Object)new AbsoluteConstraints(0, 0, 550, 400));
        this.pack();
    }

    private void jbCadastrarActionPerformed(ActionEvent evt) {
        String confirmaSenha;
        if (this.jtfNome.getText().equals("") || this.jtfLogin.getText().equals("") || this.jtfSenha.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this.rootPane, "Voc\u00ea deve informar o nome para salvar!", "Aten\u00e7\u00e3o!", 2);
            return;
        }
        String senha = new String(this.jtfSenha.getPassword());
        if (senha.equals(confirmaSenha = new String(this.jtfConfirmarSenha.getPassword()))) {
            this.salvarUsuario();
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "As senhas digitadas n\u00e3o conferem!", "Aviso", 2);
        }
    }

    private void jbExcluirActionPerformed(ActionEvent evt) {
        int linha = this.jTableUsuarios.getSelectedRow();
        String nome = "";
        int codigo = 0;
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            nome = (String)this.jTableUsuarios.getValueAt(linha, 1);
            codigo = (Integer)this.jTableUsuarios.getValueAt(linha, 0);
            ControllerUsuario controllerUsuario = new ControllerUsuario();
            ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o usu\u00e1rio:\n\n " + nome + "?", "Aten\u00e7\u00e3o", 0);
            if (opcao == 0 && controllerUsuario.excluirUsuarioController(codigo)) {
                controllerPermissaousuario.excluirPermissaousuarioController(codigo);
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarUsuarios();
                this.novoUsuario();
            }
        }
    }

    private void jbCancelarActionPerformed(ActionEvent evt) {
        this.cancelarOperacao();
    }

    private void jbNovoActionPerformed(ActionEvent evt) {
        this.jtfCodigo.setEditable(false);
        this.jbCadastrar.setEnabled(true);
        this.jbConfirmarAlteracao.setEnabled(false);
        this.novoUsuario();
    }

    private void jbConfirmarAlteracaoActionPerformed(ActionEvent evt) {
        String confirmaSenha;
        if (this.jtfNome.getText().equals("") || this.jtfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(this.rootPane, "Voc\u00ea deve informar o nome para salvar!", "Aten\u00e7\u00e3o!", 2);
            return;
        }
        String senha = new String(this.jtfSenha.getPassword());
        if (senha.equals(confirmaSenha = new String(this.jtfConfirmarSenha.getPassword()))) {
            this.alterarUsuario();
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "As senhas digitadas n\u00e3o conferem!", "Aviso", 2);
        }
    }

    private void jButtonAlterarActionPerformed(ActionEvent evt) {
        int linha = this.jTableUsuarios.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Voc\u00ea deve selecionar um item na tabela antes de clicar no bot\u00e3o!", "ATEN\u00c7\u00c3O", 2);
        } else {
            this.desativarPermissao();
            this.recuperarUsuario();
            this.habilitarCampos();
            this.jtfCodigo.setEditable(false);
            this.jbCadastrar.setEnabled(false);
            this.jbConfirmarAlteracao.setEnabled(true);
            this.jTabbedPaneTipoProduto.setSelectedIndex(this.jTabbedPaneTipoProduto.getSelectedIndex() - 1);
        }
    }

    private void jcbVendasActionPerformed(ActionEvent evt) {
    }

    private void jcbUnidadeMedidaActionPerformed(ActionEvent evt) {
    }

    private void jcbCaixaActionPerformed(ActionEvent evt) {
    }

    private boolean salvarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        modelUsuario.setNome(this.jtfNome.getText());
        modelUsuario.setLogin(this.jtfLogin.getText());
        modelUsuario.setSenha(new String(this.jtfSenha.getPassword()));
        int codigousuario = controllerUsuario.salvarUsuarioController(modelUsuario);
        if (codigousuario > 0) {
            controllerPermissaousuario.salvarPermissaousuarioController(this.setardadosPermissaoUsuario(codigousuario));
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.cancelarOperacao();
            this.carregarUsuarios();
            this.novoUsuario();
            this.jTabbedPaneTipoProduto.setSelectedIndex(this.jTabbedPaneTipoProduto.getSelectedIndex() + 1);
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", 0);
        return false;
    }

    public ModelPermissaousuario setardadosPermissaoUsuario(int pCodigoUsuario) {
        ArrayList<ModelPermissaousuario> listaModelPermissaousuarios = new ArrayList<ModelPermissaousuario>();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        modelPermissaousuario = new ModelPermissaousuario();
        if (this.jcbClientes.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("cliente");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbNotaFiscal.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("nota");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbProdutos.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("produto");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbOrcamento.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("fornecedor");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbUsuario.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("usuario");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbVendas.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("venda");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbContasPagar.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("pagar");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbContasReceber.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("receber");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbEmpresa.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("empresa");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbCaixa.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("cidade");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbUnidadeMedida.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("unidade");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbFormaPagamento.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("pagamento");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbOrcamento.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("orcamento");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbCaixa.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("caixa");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (this.jcbCaixa.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("abrirCaixa");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        modelPermissaousuario.setListaModelPermissaousuarios(listaModelPermissaousuarios);
        return modelPermissaousuario;
    }

    private boolean alterarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        modelUsuario.setCodigo(Integer.parseInt(this.jtfCodigo.getText()));
        modelUsuario.setNome(this.jtfNome.getText());
        modelUsuario.setLogin(this.jtfLogin.getText());
        modelUsuario.setSenha(new String(this.jtfSenha.getPassword()));
        if (controllerUsuario.atualizarUsuarioController(modelUsuario)) {
            controllerPermissaousuario.excluirPermissaousuarioController(modelUsuario.getCodigo());
            controllerPermissaousuario.salvarPermissaousuarioController(this.setardadosPermissaoUsuario(modelUsuario.getCodigo()));
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.cancelarOperacao();
            this.carregarUsuarios();
            this.jTabbedPaneTipoProduto.setSelectedIndex(this.jTabbedPaneTipoProduto.getSelectedIndex() + 1);
            return true;
        }
        JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", 0);
        return false;
    }

    private void cancelarOperacao() {
        this.desabilitarCampos();
    }

    private void carregarUsuarios() {
        ArrayList listaUsuarios = new ArrayList();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        listaUsuarios = controllerUsuario.getListaUsuarioController();
        DefaultTableModel modelo = (DefaultTableModel)this.jTableUsuarios.getModel();
        modelo.setNumRows(0);
        int cont = listaUsuarios.size();
        for (int i = 0; i < cont; ++i) {
            modelo.addRow(new Object[]{((ModelUsuario)listaUsuarios.get(i)).getCodigo(), ((ModelUsuario)listaUsuarios.get(i)).getNome(), ((ModelUsuario)listaUsuarios.get(i)).getLogin()});
        }
    }

    private boolean recuperarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ArrayList listaModelPermissaousuarios = new ArrayList();
        int linha = this.jTableUsuarios.getSelectedRow();
        int codigo = (Integer)this.jTableUsuarios.getValueAt(linha, 0);
        try {
            modelUsuario = controllerUsuario.getUsuarioController(codigo);
            listaModelPermissaousuarios = controllerPermissaousuario.getListaPermissaousuarioController(codigo);
            this.jtfCodigo.setText(String.valueOf(modelUsuario.getCodigo()));
            this.jtfNome.setText(modelUsuario.getNome());
            this.jtfLogin.setText(modelUsuario.getLogin());
            for (int i = 0; i < listaModelPermissaousuarios.size(); ++i) {
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("cliente")) {
                    this.jcbClientes.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("nota")) {
                    this.jcbNotaFiscal.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("produto")) {
                    this.jcbProdutos.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("fornecedor")) {
                    this.jcbFornecedores.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("usuario")) {
                    this.jcbUsuario.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("venda")) {
                    this.jcbVendas.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("pagar")) {
                    this.jcbContasPagar.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("receber")) {
                    this.jcbContasReceber.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("empresa")) {
                    this.jcbEmpresa.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("cidade")) {
                    this.jcbCidades.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("unidade")) {
                    this.jcbUnidadeMedida.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("pagamento")) {
                    this.jcbFormaPagamento.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("orcamento")) {
                    this.jcbOrcamento.setSelected(true);
                }
                if (((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("caixa")) {
                    this.jcbCaixa.setSelected(true);
                }
                if (!((ModelPermissaousuario)listaModelPermissaousuarios.get(i)).getPermissao().equals("abrirCaixa")) continue;
                this.jcbAbrirFecharCaixa.setSelected(true);
            }
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "C\u00f3digo inv\u00e1lido ou nenhum registro selecionado", "Aviso", 2);
            return false;
        }
    }

    protected void desabilitarCampos() {
        this.jtfNome.setEditable(false);
        this.jtfCodigo.setEditable(false);
        this.jtfLogin.setEditable(false);
        this.jtfSenha.setEditable(false);
        this.jtfConfirmarSenha.setEditable(false);
        this.carregarUsuarios();
    }

    private void novoUsuario() {
        this.habilitarCampos();
        this.jtfCodigo.setText("Novo");
        this.jtfNome.setText("");
        this.jtfLogin.setText("");
        this.jtfSenha.setText("");
        this.jtfConfirmarSenha.setText("");
        this.desativarPermissao();
    }

    private void desativarPermissao() {
        this.jcbClientes.setSelected(false);
        this.jcbNotaFiscal.setSelected(false);
        this.jcbProdutos.setSelected(false);
        this.jcbOrcamento.setSelected(false);
        this.jcbUsuario.setSelected(false);
        this.jcbVendas.setSelected(false);
        this.jcbEmpresa.setSelected(false);
        this.jcbUnidadeMedida.setSelected(false);
        this.jcbCidades.setSelected(false);
        this.jcbOrcamento.setSelected(false);
        this.jcbFormaPagamento.setSelected(false);
        this.jcbCaixa.setSelected(false);
        this.jcbFornecedores.setSelected(false);
        this.jcbContasPagar.setSelected(false);
        this.jcbContasReceber.setSelected(false);
        this.jcbAbrirFecharCaixa.setSelected(false);
    }

    private void habilitarCampos() {
        this.jtfNome.setEditable(true);
        this.jtfCodigo.setEditable(false);
        this.jtfLogin.setEditable(true);
        this.jtfSenha.setEditable(true);
        this.jtfConfirmarSenha.setEditable(true);
        this.carregarUsuarios();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewUsuario().setVisible(true);
            }
        });
    }

}

