/*
 * ViewVenda.java
 *
 * Created on 2 de Fevereiro de 2008, 00:13
 */

package view;


import controller.ControllerCaixa;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendas;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCaixa;
import model.ModelCliente;
import model.ModelFormaPagamento;
import model.ModelProdutos;
import model.ModelVendas;
import util.AguardeGerandoRelatorio;
import util.BLDatas;
import util.BLMascaras;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
 */
public class ViewOrdemDServico extends javax.swing.JFrame {
    
    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ArrayList<ModelVendas> listaModelVendasAlterar = new ArrayList<>();
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    BLMascaras bLMascaras = new BLMascaras();
    BLDatas blDatas = new BLDatas();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    private final SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");
   
   
    
    /** Creates new form RegistrarVenda */
    public ViewOrdemDServico() {
        initComponents();
        listarClientes();
        listarCodigosClientes();
        listarProdutos();
        listarCodigoProdutos();
        listarTipoPagamento();
        this.carregarPedidos();
        this.carregarOrcamentos();
        setLocationRelativeTo(null);
        this.desabilitarCampos();
        retornarDadosCliente();
        retornarDadosProduto();
    }
    private String tipo;
    
    private void listarProdutos(){
        listaModelProdutos = controllerProdutos.getListaProdutosController();
        cbProdutos.removeAllItems();
        for (int i = 0; i < listaModelProdutos.size(); i++){
            cbProdutos.addItem(listaModelProdutos.get(i).getNome());
        }
    }
    
    private void listarCodigoProdutos(){
        listaModelProdutos = controllerProdutos.getListaProdutosController();
        cbCodProduto.removeAllItems();
        for (int i = 0; i < listaModelProdutos.size(); i++){
            cbCodProduto.addItem(listaModelProdutos.get(i).getCodigo());
        }
    }
    
    private void listarClientes(){
        listaModelClientes = controllerCliente.getListaClienteController();
        cbClientes.removeAllItems();
        for (int i = 0; i < listaModelClientes.size(); i++){
            cbClientes.addItem(listaModelClientes.get(i).getNome());
        }
    }
    
    private void listarCodigosClientes(){
        listaModelClientes = controllerCliente.getListaClienteController();
        cbCodCliente.removeAllItems();
        for (int i = 0; i < listaModelClientes.size(); i++){
            cbCodCliente.addItem(listaModelClientes.get(i).getCodigo());
        }
    }
    
    private void listarTipoPagamento(){
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        jcbTipoPagamento.removeAllItems();
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++){
            jcbTipoPagamento.addItem(listaModelTipoPagamentos.get(i).getDescricao());
        }
    }
    
    public void setViewConsultarVendas(){
        this.jTabbedPane1.setSelectedIndex(1);
    }
    
    // calcula o valor total do produto com quantidade
    private void calcularValorproduto(String pValorUnitario, String pQuantidade, String pValorMaoObra){
        Double valorTotal, valorUnitario = null, quantidade = null;
        Float valorMaoObra = null;
        try{
            valorUnitario = Double.parseDouble(pValorUnitario);
            quantidade = Double.parseDouble(pQuantidade);
            valorMaoObra = Float.parseFloat(pValorMaoObra);
        }catch(NumberFormatException e){
            System.err.println(e+"Erro");
        }
        valorTotal = valorUnitario * quantidade + valorMaoObra;
    //    valorTotal = valorTotal + valorMaoObra;
        
       
        tfValorTotalProduto.setText(bLMascaras.arredondamentoDoubleComPontoDuasCasasString(valorTotal));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btFinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        tfValorTotal = new JFormattedTextField(NumberFormat.getNumberInstance());
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jcbTipoPagamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNumeroVenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbClientes = new javax.swing.JComboBox();
        cbCodCliente = new javax.swing.JComboBox();
        tfCpfCnpj = new javax.swing.JTextField();
        tfObservacaoCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jdDataEntrada = new javax.swing.JFormattedTextField();
        jtfHorario = new javax.swing.JFormattedTextField();
        tfValorOrc = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfUnidadeMedida = new javax.swing.JTextField();
        btIncluirProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btRetirar = new javax.swing.JButton();
        tfDesconto = new javax.swing.JTextField();
        cbProdutos = new javax.swing.JComboBox();
        cbCodProduto = new javax.swing.JComboBox();
        tfQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValorUnitario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfValorTotalProduto = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        S = new javax.swing.JRadioButton();
        N = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        jdPagamento = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jdVencimento = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jbImprimirOrcamento = new javax.swing.JButton();
        tfPesquisaorcamento = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbConsultasOrcamentos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btPesquisarOrcamento = new javax.swing.JButton();
        btCancelar2 = new javax.swing.JButton();
        btAprovar = new javax.swing.JButton();
        cbFiltroPesquisaOrcamento = new javax.swing.JComboBox();
        btAlterar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btPesquisarPedido = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfPesquisaPedido = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbConsultasPedidos = new javax.swing.JTable();
        jbImprimirPedido = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btDesaprovar = new javax.swing.JButton();
        cbFiltroPesquisaPedido = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Serviços");
        setAlwaysOnTop(true);
        setResizable(false);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(520, 405));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Save.png"))); // NOI18N
        btFinalizar.setText("Salvar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 100, -1));

        jLabel5.setText("Total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, -1, -1));

        jLabel4.setText("Aplicar desconto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, -1, -1));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/No.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(255, 153, 153));
        tfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        tfValorTotal.setFocusable(false);
        jPanel1.add(tfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 120, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Add.png"))); // NOI18N
        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, -1, -1));

        tbProdutos.setAutoCreateRowSorter(true);
        tbProdutos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Prod.", "Produto", "Fornecedor", "Valor unit.", "Quantidade", "Valor total", "UM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbProdutos);
        if (tbProdutos.getColumnModel().getColumnCount() > 0) {
            tbProdutos.getColumnModel().getColumn(1).setMinWidth(300);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbProdutos.getColumnModel().getColumn(1).setMaxWidth(300);
            tbProdutos.getColumnModel().getColumn(2).setMinWidth(180);
            tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbProdutos.getColumnModel().getColumn(6).setMinWidth(60);
            tbProdutos.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 330, 830, 160));

        jPanel1.add(jcbTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 250, -1));

        jLabel7.setText("Forma de pagamento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Nome do cliente:");

        tfNumeroVenda.setEditable(false);
        tfNumeroVenda.setBackground(new java.awt.Color(102, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nº Ordem:");

        jLabel9.setText("Código cliente:");

        jLabel12.setText("Endereço:");

        tfEndereco.setEditable(false);

        tfBairro.setEditable(false);

        jLabel13.setText("Bairro:");

        tfEstado.setEditable(false);

        jLabel14.setText("Estado:");

        jLabel15.setText("Cidade:");

        tfCidade.setEditable(false);

        tfTelefone.setEditable(false);

        jLabel16.setText("Telefone");

        cbClientes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbClientesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbCodCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCodClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tfCpfCnpj.setEditable(false);

        tfObservacaoCliente.setEditable(false);
        tfObservacaoCliente.setEnabled(false);

        jLabel17.setText("CPF/CNPJ");

        jLabel18.setText("Observação");

        jLabel22.setText("Data:");

        jLabel23.setText("Hora:");

        jdDataEntrada.setEditable(false);
        jdDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jtfHorario.setEditable(false);
        jtfHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));

        tfValorOrc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfValorOrcFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorOrcFocusLost(evt);
            }
        });

        jLabel54.setText("Valor da Mão de Obra:");

        tfObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do Poblema:"));
        jScrollPane2.setViewportView(tfObservacao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel23)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jtfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfObservacaoCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorOrc)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jdDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(jLabel23))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfCpfCnpj)
                                .addComponent(jtfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNumeroVenda))))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(6, 6, 6)
                        .addComponent(tfValorOrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 280));

        jLabel10.setText("Cód. Produto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel11.setText("Unid. Med.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        tfUnidadeMedida.setEditable(false);
        jPanel1.add(tfUnidadeMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 52, -1));

        btIncluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Create.png"))); // NOI18N
        btIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btIncluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 60, 20));

        jLabel2.setText("Produto ou Mão de Obra");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, -1));

        btRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        btRetirar.setMaximumSize(new java.awt.Dimension(55, 27));
        btRetirar.setMinimumSize(new java.awt.Dimension(55, 27));
        btRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarActionPerformed(evt);
            }
        });
        jPanel1.add(btRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, 60, 20));

        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoKeyReleased(evt);
            }
        });
        jPanel1.add(tfDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, 90, -1));

        cbProdutos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbProdutosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cbProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 290, -1));

        cbCodProduto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCodProdutoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cbCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, -1));

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });
        jPanel1.add(tfQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 50, -1));

        jLabel3.setText("Quant.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        tfValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorUnitarioFocusLost(evt);
            }
        });
        tfValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorUnitarioKeyReleased(evt);
            }
        });
        jPanel1.add(tfValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 70, -1));

        jLabel20.setText("Val. Unitário");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        tfValorTotalProduto.setEditable(false);
        jPanel1.add(tfValorTotalProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 70, -1));

        jLabel21.setText("Val. Total");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        jLabel24.setText("Garantia:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        buttonGroup1.add(S);
        S.setText("SIM");
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        jPanel1.add(S, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        buttonGroup1.add(N);
        N.setText("NÃO");
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });
        jPanel1.add(N, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, -1));

        jLabel25.setText("Garantia Até:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));
        jPanel1.add(jdPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 110, -1));

        jLabel26.setText("Data Saida:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));
        jPanel1.add(jdVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 100, -1));

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbImprimirOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        jbImprimirOrcamento.setText("Imprimir");
        jbImprimirOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirOrcamentoActionPerformed(evt);
            }
        });
        jPanel4.add(jbImprimirOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));
        jPanel4.add(tfPesquisaorcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, -1));

        tbConsultasOrcamentos.setAutoCreateRowSorter(true);
        tbConsultasOrcamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Compra", "Cliente", "CPF/CNPJ", "Observação do cliente", "Data", "Valor total", "Descrição do poblema"
            }
        ) {
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
        tbConsultasOrcamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasOrcamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbConsultasOrcamentos);
        if (tbConsultasOrcamentos.getColumnModel().getColumnCount() > 0) {
            tbConsultasOrcamentos.getColumnModel().getColumn(0).setMinWidth(50);
            tbConsultasOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbConsultasOrcamentos.getColumnModel().getColumn(1).setMinWidth(280);
            tbConsultasOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(280);
            tbConsultasOrcamentos.getColumnModel().getColumn(2).setMinWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(3).setMinWidth(150);
            tbConsultasOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbConsultasOrcamentos.getColumnModel().getColumn(4).setMinWidth(70);
            tbConsultasOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(70);
            tbConsultasOrcamentos.getColumnModel().getColumn(5).setMinWidth(80);
            tbConsultasOrcamentos.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbConsultasOrcamentos.getColumnModel().getColumn(6).setMinWidth(350);
            tbConsultasOrcamentos.getColumnModel().getColumn(6).setPreferredWidth(350);
        }

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 822, 500));

        jLabel19.setText("Pesquisar:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btPesquisarOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Search.png"))); // NOI18N
        btPesquisarOrcamento.setText("Pesquisar");
        btPesquisarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarOrcamentoActionPerformed(evt);
            }
        });
        jPanel4.add(btPesquisarOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        btCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/No.png"))); // NOI18N
        btCancelar2.setText("Cancelar");
        btCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        btAprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Good-mark.png"))); // NOI18N
        btAprovar.setText("Aprovar orçamento");
        btAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAprovarActionPerformed(evt);
            }
        });
        jPanel4.add(btAprovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 580, -1, -1));

        cbFiltroPesquisaOrcamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Nº da OS", " " }));
        jPanel4.add(cbFiltroPesquisaOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 200, -1));

        btAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Modify.png"))); // NOI18N
        btAlterar1.setText("Alterar Orçamento");
        btAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btAlterar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, -1, -1));

        jTabbedPane1.addTab("Orçamentos", jPanel4);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPesquisarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Search.png"))); // NOI18N
        btPesquisarPedido.setText("Pesquisar");
        btPesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Delete.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, -1, -1));

        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/No.png"))); // NOI18N
        btCancelar1.setText("Cancelar");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        jLabel8.setText("Pesquisar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(tfPesquisaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, -1));

        tbConsultasPedidos.setAutoCreateRowSorter(true);
        tbConsultasPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Compra", "Cliente", "CPF/CNPJ", "Observação do Cliente", "Data", "Valor total", "Descrição do poblema"
            }
        ) {
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
        tbConsultasPedidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbConsultasPedidos);
        if (tbConsultasPedidos.getColumnModel().getColumnCount() > 0) {
            tbConsultasPedidos.getColumnModel().getColumn(0).setMinWidth(50);
            tbConsultasPedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbConsultasPedidos.getColumnModel().getColumn(1).setMinWidth(280);
            tbConsultasPedidos.getColumnModel().getColumn(1).setPreferredWidth(280);
            tbConsultasPedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(3).setMinWidth(150);
            tbConsultasPedidos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbConsultasPedidos.getColumnModel().getColumn(4).setMinWidth(80);
            tbConsultasPedidos.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbConsultasPedidos.getColumnModel().getColumn(5).setMinWidth(70);
            tbConsultasPedidos.getColumnModel().getColumn(5).setPreferredWidth(70);
            tbConsultasPedidos.getColumnModel().getColumn(6).setMinWidth(350);
            tbConsultasPedidos.getColumnModel().getColumn(6).setPreferredWidth(350);
        }

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 822, 500));

        jbImprimirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/print.png"))); // NOI18N
        jbImprimirPedido.setText("Imprimir");
        jbImprimirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(jbImprimirPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Modify.png"))); // NOI18N
        btAlterar.setText("Alterar OS");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, -1, -1));

        btDesaprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Bad mark.png"))); // NOI18N
        btDesaprovar.setText("Desaprovar OS");
        btDesaprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesaprovarActionPerformed(evt);
            }
        });
        jPanel2.add(btDesaprovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, -1, -1));

        cbFiltroPesquisaPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Nº da OS", " ", " " }));
        jPanel2.add(cbFiltroPesquisaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 200, -1));

        jTabbedPane1.addTab("OS Finalizado", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDesaprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesaprovarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasPedidos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasPedidos.getValueAt(linha, 0);
        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
            + " transformar o pedido nº:" + pCodigo + " em um orçamento ?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada
        if (opcao == JOptionPane.OK_OPTION) {
            //limpa tela
            this.limpaTelaNovoProduto();
            //recupera os dados do pedido para adicionar ao estoque
            this.recuperarPedido(pCodigo);
            //adiciona ao estoque
            this.retornarProdutoAoEstoque();
            //trasfora pedido em orçamento
            controllerVendas.desaprovarPedidoController(pCodigo);
            //limpa a tela novamente
            this.limpaTelaNovoProduto();
            //carregar lista de v e o
            this.carregarPedidos();
            this.carregarOrcamentos();
        } else {
            JOptionPane.showMessageDialog(this, "Você cancelou a operação!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btDesaprovarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasPedidos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasPedidos.getValueAt(linha, 0);
        tipoCadastro = "Alterar";
        //limpa tela
        this.limpaTelaNovoProduto();
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(pCodigo);
        //recupera cliente
        retornarClientePeloCodigo();
        //volta para aba 1
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void jbImprimirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirPedidoActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasPedidos.getSelectedRow();
                int codigo = (int) tbConsultasPedidos.getValueAt(linha, 0);
                controllerVendas.gerarRelatorioVenda(codigo);
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirPedidoActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        desabilitarCampos();
        carregarPedidos();
        this.carregarOrcamentos();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = tbConsultasPedidos.getSelectedRow();
        String nome = (String) tbConsultasPedidos.getValueAt(linha, 1);
        int codigo = (int) tbConsultasPedidos.getValueAt(linha, 0);

        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
            + " excluir o registro:\n" + "\n " + nome + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerVendas.excluirProdutoVendasController(codigo)) {
                if (controllerVendas.excluirVendasController(codigo)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                }else{
                    JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                carregarPedidos();
                this.carregarOrcamentos();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void btPesquisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPedidoActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasPedidos.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasPedidos.setRowSorter(sorter);
        String text = tfPesquisaPedido.getText();

        if (cbFiltroPesquisaPedido.getSelectedIndex() == 0) {
            //definir pesquisa por n° compra
            sorter.setRowFilter(RowFilter.regexFilter(text, 0));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 1) {
            //definir pesquisa por cliente
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 2) {
            //definir pesquisa por unidade
            sorter.setRowFilter(RowFilter.regexFilter(text, 2));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 3) {
            //definir pesquisa por obra
            sorter.setRowFilter(RowFilter.regexFilter(text, 3));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 4) {
            //definir pesquisa por data
            sorter.setRowFilter(RowFilter.regexFilter(text, 4));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 6) {
            //definir pesquisa por observação
            sorter.setRowFilter(RowFilter.regexFilter(text, 6));
        }
    }//GEN-LAST:event_btPesquisarPedidoActionPerformed

    private void btAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAprovarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasOrcamentos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasOrcamentos.getValueAt(linha, 0);
        tipoCadastro = "Aprovar";
        //limpa tela
        this.limpaTelaNovoProduto();
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(pCodigo);
        //recupera cliente
        retornarClientePeloCodigo();
        //valta para aba 1   
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAprovarActionPerformed

    private void btCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelar2ActionPerformed

    private void btPesquisarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarOrcamentoActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasOrcamentos.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasOrcamentos.setRowSorter(sorter);
        String text = tfPesquisaorcamento.getText();

        if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 0) {
            //definir pesquisa por n° compra
            sorter.setRowFilter(RowFilter.regexFilter(text, 0));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 1) {
            //definir pesquisa por cliente
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 2) {
            //definir pesquisa por unidade
            sorter.setRowFilter(RowFilter.regexFilter(text, 2));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 3) {
            //definir pesquisa por obra
            sorter.setRowFilter(RowFilter.regexFilter(text, 3));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 4) {
            //definir pesquisa por data
            sorter.setRowFilter(RowFilter.regexFilter(text, 4));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 6) {
            //definir pesquisa por observação
            sorter.setRowFilter(RowFilter.regexFilter(text, 6));
        }
    }//GEN-LAST:event_btPesquisarOrcamentoActionPerformed

    private void jbImprimirOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirOrcamentoActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();////////////////////////////////////////////////////////////////////////
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasOrcamentos.getSelectedRow();
                int codigo = (int) tbConsultasOrcamentos.getValueAt(linha, 0);
                controllerVendas.gerarRelatorioOrcamento(codigo);
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirOrcamentoActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        tipo = "NAO";
    }//GEN-LAST:event_NActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        tipo = "SIM";
    }//GEN-LAST:event_SActionPerformed

    private void tfValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorUnitarioKeyReleased
        // TODO add your handling code here:
        this.tfValorUnitario.setText(new BLMascaras().converterVirgulaParaPonto(this.tfValorUnitario.getText()));
      //  this.tfValorUnitario.setText(new BLMascaras().converterVirgulaParaPonto(this.tfValorOrc.getText()));
    }//GEN-LAST:event_tfValorUnitarioKeyReleased

    private void tfValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorUnitarioFocusLost
        // TODO add your handling code here:
        calcularValorproduto(this.tfQuantidade.getText(),this.tfValorUnitario.getText(), tfValorOrc.getText());
    }//GEN-LAST:event_tfValorUnitarioFocusLost

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        // TODO add your handling code here:
        calcularValorproduto(this.tfQuantidade.getText(),this.tfValorUnitario.getText(),tfValorOrc.getText());
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void cbCodProdutoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodProdutoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodProduto.isPopupVisible()) {
            modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
            //recupera o código
            this.cbProdutos.setSelectedItem(String.valueOf(modelProdutos.getNome()));
            this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
            this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
        }
    }//GEN-LAST:event_cbCodProdutoPopupMenuWillBecomeInvisible

    private void cbProdutosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbProdutosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbProdutos.isPopupVisible()) {
            modelProdutos = controllerProdutos.getProdutosController(cbProdutos.getSelectedItem().toString());
            //recupera o nome
            this.cbCodProduto.setSelectedItem(modelProdutos.getCodigo());
            this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
            this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
        }
    }//GEN-LAST:event_cbProdutosPopupMenuWillBecomeInvisible

    private void tfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyReleased
        // TODO add your handling code here:
        this.tfDesconto.setText(new BLMascaras().converterVirgulaParaPonto(this.tfDesconto.getText()));
    }//GEN-LAST:event_tfDescontoKeyReleased

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        try{
            float desconto = Float.parseFloat(this.tfDesconto.getText());
            float valorFinal = somaEAtualizaValorTotal() - desconto;
            this.tfValorTotal.setText(String.valueOf(bLMascaras.arredondamentoComPontoDuasCasas(valorFinal)));
        }catch(NumberFormatException e){
            this.tfDesconto.setText("0");
            JOptionPane.showMessageDialog(this, "Campo numérico!");
        }
    }//GEN-LAST:event_tfDescontoFocusLost

    private void tfDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusGained
        try{
            float desconto = Float.parseFloat(this.tfDesconto.getText());
            float valorFinal = somaEAtualizaValorTotal() - desconto;
            this.tfValorTotal.setText(String.valueOf(bLMascaras.arredondamentoComPontoDuasCasas(valorFinal)));
        }catch(NumberFormatException e){
            this.tfDesconto.setText("0");
            JOptionPane.showMessageDialog(this, "Campo numérico!");
        }
    }//GEN-LAST:event_tfDescontoFocusGained

    private void btRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarActionPerformed
        // para excluir a linha
        int linhaSelecionada = tbProdutos.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
            this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
        }
    }//GEN-LAST:event_btRetirarActionPerformed

    private void btIncluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirProdutoActionPerformed
        this.incluirProduto();
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_btIncluirProdutoActionPerformed

    private void cbCodClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodClientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodCliente.isPopupVisible()) {
            this.retornarClientePeloCodigo();
        }
    }//GEN-LAST:event_cbCodClientePopupMenuWillBecomeInvisible

    private void cbClientesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbClientesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbClientes.isPopupVisible()) {
            modelCliente = controllerCliente.getClienteController(cbClientes.getSelectedItem().toString());
            //recupera o código
            this.cbCodCliente.setSelectedItem(modelCliente.getCodigo());
            this.tfEndereco.setText(modelCliente.getEndereco());
            this.tfBairro.setText(modelCliente.getBairro());
            this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
            this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
            this.tfTelefone.setText(modelCliente.getTelefone());
            this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
            this.tfObservacaoCliente.setText(modelCliente.getObservacao());
        }
    }//GEN-LAST:event_cbClientesPopupMenuWillBecomeInvisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tipoCadastro = "Novo";
        this.limpaTelaNovoProduto();
        //     this.jdDataEntrada.setDate(new Date(System.currentTimeMillis()));
        jtfHorario.setText(blDatas.retornarHorario());
        ViewOrdemDServico.this.jtfHorario.setText(ViewOrdemDServico.this.horaFormatada.format(new Date()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        desabilitarCampos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        if (tipoCadastro.equals("Novo")) {
            zerarValoresCaixa();
            cadastrarOrcamento();
          //  cadastrarVenda();
            desabilitarCampos();
        } else if (tipoCadastro.equals("Alterar")) {
            zerarValoresCaixa();
            alterarPedido();
            desabilitarCampos();
        } else if (tipoCadastro.equals("Aprovar")) {
            zerarValoresCaixa();
            aprovarAlterarPedido();
            desabilitarCampos();
        } 
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterar1ActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasOrcamentos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasOrcamentos.getValueAt(linha, 0);
        tipoCadastro = "Alterar";
        //limpa tela
        this.limpaTelaNovoProduto();
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(pCodigo);
        //recupera cliente
        retornarClientePeloCodigo();
        //volta para aba 1
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAlterar1ActionPerformed

    private void tfValorOrcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorOrcFocusLost
     //   calcularValorproduto(this.tfQuantidade.getText(),this.tfValorUnitario.getText(),tfValorOrc.getText());
        
    }//GEN-LAST:event_tfValorOrcFocusLost

    private void tfValorOrcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorOrcFocusGained
      try{
            float valorMaoObra = Float.parseFloat(this.tfValorOrc.getText());
            float valorFinal = somaEAtualizaValorTotal() + valorMaoObra;
            this.tfValorTotal.setText(String.valueOf(bLMascaras.arredondamentoComPontoDuasCasas(valorFinal)));
        }catch(NumberFormatException e){
            this.tfValorOrc.setText("0");
            JOptionPane.showMessageDialog(this, "Campo numérico!");
        }
    }//GEN-LAST:event_tfValorOrcFocusGained
   private boolean cadastrarOrcamento() { 
        if (tfDesconto.getText().equals("") || tfValorOrc.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto; 
            float quantidade;
            BLDatas bl = new BLDatas();

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
     //           modelVendas.setValorOrc(Float.parseFloat(tfValorOrc.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                try {
                    modelVendas.setDataVenda(bl.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(0);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque();
                modelProdutos.setEstoque(quantidade);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
            //salvar venda
            int codigoVenda = controllerVendas.salvarVendasController(modelVendas);
            if (codigoVenda > 0) {
                modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarOrcamentos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
    protected void desabilitarCampos(){
        cbClientes.setSelectedIndex(0);
        cbProdutos.setSelectedIndex(0);
        tfNumeroVenda.setText("");
        tfQuantidade.setText("");
        tfDesconto.setText("");
        tfValorTotal.setText("");
        tfObservacao.setText("");
        tfValorOrc.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        modelo.setNumRows(0);      
        cbClientes.setEnabled(false);
        cbProdutos.setEnabled(false);
        cbCodCliente.setEnabled(false);
        cbCodProduto.setEnabled(false);
        tfQuantidade.setEnabled(false);
        tfDesconto.setEnabled(false);
        tfValorOrc.setEnabled(false);
  //      tfObservacao.setEditable(false);
       
    }
    
    
   private boolean alterarPedido() {
        if (tfDesconto.getText().equals("") || tfValorOrc.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            //RETORNAR COM AS QUANTIDADES DOS PRODUTOS
            this.retornarProdutoAoEstoque();
            
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto; 
            float quantidade;
            BLDatas bl = new BLDatas();

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
        //        modelVendas.setValorOrc(Float.parseFloat(tfValorOrc.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                try {
                    modelVendas.setDataVenda(bl.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
            //salvar venda
            if (controllerVendas.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                controllerVendas.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarOrcamentos();
                this.carregarPedidos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
   
   private boolean aprovarAlterarPedido() {
        if (tfDesconto.getText().equals("") || tfValorOrc.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else { 
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto; 
            float quantidade;
            BLDatas bl = new BLDatas();

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                //modelVendas.set
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
        //        modelVendas.setValorOrc(Float.parseFloat(tfValorOrc.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                try {
                    modelVendas.setDataVenda(bl.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
            //salvar venda
            if (controllerVendas.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                controllerVendas.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Orçamento aprovado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarOrcamentos();
                this.carregarPedidos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
    
    private boolean cadastrarVenda() {
        if (tfDesconto.getText().equals("") || tfValorOrc.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto; 
            float quantidade;
            BLDatas bl = new BLDatas();
            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
    //            modelVendas.setValorOrc(Float.parseFloat(tfValorOrc.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                try {
                    modelVendas.setDataVenda(bl.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            
            //salvar venda
            int codigoVenda = controllerVendas.salvarVendasController(modelVendas);
            if (codigoVenda > 0) {
                modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarPedidos();
                this.carregarOrcamentos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
        
    
    private void retornarClientePeloCodigo(){
            modelCliente = controllerCliente.getClienteController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));
            //recupera o nome
            this.cbClientes.setSelectedItem(String.valueOf(modelCliente.getNome()));
            this.tfEndereco.setText(modelCliente.getEndereco());
            this.tfBairro.setText(modelCliente.getBairro());
            this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
            this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
            this.tfTelefone.setText(modelCliente.getTelefone());
            this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
            this.tfObservacaoCliente.setText(modelCliente.getObservacao());
            
    }
    
    
  private boolean recuperarPedido(int pCodigo) { 
        try {
            int codigoProduto;
            modelVendas.setCodigo(pCodigo);
            //recupera os dados do banco
            modelVendas = controllerVendas.getVendasController(pCodigo);
            //seta os dados na interface
            this.cbCodCliente.setSelectedItem(modelVendas.getClientesCodigo());
            this.tfNumeroVenda.setText(String.valueOf(modelVendas.getCodigo()));
            this.tfDesconto.setText(String.valueOf(modelVendas.getDesconto()));
            this.tfValorTotal.setText(String.valueOf(modelVendas.getValorTotal()));        
            this.tfObservacao.setText(modelVendas.getObservacao());
    //        this.tfValorOrc.setText(String.valueOf(modelVendas.getValorOrc()));
            this.jcbTipoPagamento.setSelectedItem(controllerTipoPagamento.getFormaPagamentoController(modelVendas.getTipoPagamento()).getDescricao());
            
            //recupera os dados do banco
            listaModelVendasAlterar = controllerVendas.getListaVendasController(pCodigo);
            //carregar lista de produtos da venda
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            modelo.setNumRows(0);
            
            int cont = listaModelVendasAlterar.size();
            String unidadeMedida="";
            String fornecedor="";
            for (int i = 0; i < cont; i++) {
                codigoProduto = listaModelVendasAlterar.get(i).getProdutosCodigo();
                modelProdutos = controllerProdutos.getProdutosController(codigoProduto);
                unidadeMedida = controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao();
                fornecedor = controllerFornecedor.getFornecedorProdutoController(codigoProduto).getNome();
                modelo.addRow(new Object[]{
                    listaModelVendasAlterar.get(i).getProdutosCodigo(),
                    modelProdutos.getNome(),
                    fornecedor,
                    listaModelVendasAlterar.get(i).getValor(),
                    listaModelVendasAlterar.get(i).getQuantidade(),
            //        listaModelVendasAlterar.get(i).getValorOrc(),
                    listaModelVendasAlterar.get(i).getQuantidade() * listaModelVendasAlterar.get(i).getValor(),             
                    unidadeMedida
                });
            }     
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    
    private void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        if (modelVendas.getTipoPagamento() == 1) {
            valorDinheiro = modelVendas.getValorTotal();
            modelCaixa.setDinheiro(modelCaixa.getDinheiro() + valorDinheiro);
        } else if (modelVendas.getTipoPagamento() == 2) {
            valorCartao = modelVendas.getValorTotal();
            modelCaixa.setCartao(modelCaixa.getCartao() + valorCartao);
        } else if (modelVendas.getTipoPagamento() == 3) {
            valorCheque = modelVendas.getValorTotal();
            modelCaixa.setCheque(modelCaixa.getCheque() + valorCheque);
        } else if (modelVendas.getTipoPagamento() == 4) {
            valorVale = modelVendas.getValorTotal();
            modelCaixa.setVale(modelCaixa.getVale() + valorVale);
        }
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }
    
    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosCliente() {
        modelCliente = controllerCliente.getClienteController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));
        //recupera o nome
        this.cbClientes.setSelectedItem(String.valueOf(modelCliente.getNome()));
        this.tfEndereco.setText(modelCliente.getEndereco());
        this.tfBairro.setText(modelCliente.getBairro());
        this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
        this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
        this.tfTelefone.setText(modelCliente.getTelefone());
        this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
        this.tfObservacaoCliente.setText(modelCliente.getObservacao());
        modelVendas.setObservacao(this.tfObservacao.getText());
   //     modelVendas.setValorOrc(this.tfValorOrc.getText());
    }
    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosProduto() {
        modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
        //recupera o código
        this.cbProdutos.setSelectedItem(String.valueOf(modelProdutos.getNome()));
        this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
    }
    
    private void zerarValoresCaixa() {
        valorCartao = 0;
        valorCheque = 0;
        valorDinheiro = 0;
        valorVale = 0;
    }
    
   
    private void limpaTelaNovoProduto(){
        tfNumeroVenda.setText("Novo");
        tfQuantidade.setText("");
        listarClientes();
        listarProdutos();
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        modelo.setNumRows(0);
        this.tfDesconto.setText("0");
        this.tfObservacao.setText("");
        this.tfValorOrc.setText("0");
        habilitarCampos();
    }
    
    private void habilitarCampos(){
        cbClientes.setEnabled(true);
        cbProdutos.setEnabled(true);
        cbCodCliente.setEnabled(true);
        cbCodProduto.setEnabled(true);
        tfQuantidade.setEnabled(true);
        tfDesconto.setEnabled(true);
        tfObservacao.setEnabled(true);
        tfValorOrc.setEnabled(true);
       
    }
    
    private void incluirProduto(){
       // TODO add your handling code here:
       // TODO add your handling code here:
        if(tfQuantidade.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Você deve informar a quantidade para adicionar!");
        }else{
            //Adiciona linhas na tabela
            DefaultTableModel modelo = (DefaultTableModel)tbProdutos.getModel();
            int cont = 0;
            for(int i = 0; i < cont; i++){
                modelo.setNumRows(0);
            }

            int codigoproduto = Integer.parseInt(this.cbCodProduto.getSelectedItem().toString());
            String fornecedor = controllerFornecedor.getFornecedorProdutoController(codigoproduto).getNome();
            //pega a quantidade de linhas e joga na variavel
            modelo.addRow(new Object [] {
            codigoproduto,
            this.cbProdutos.getSelectedItem().toString(),
            fornecedor,
            this.tfValorUnitario.getText(),
            this.tfQuantidade.getText(),            
            this.tfValorTotalProduto.getText(),
            this.tfUnidadeMedida.getText(),
            this.tfObservacao.getText(),
            this.tfValorOrc.getText()
            });
        } 
    }
    
    /**
     * Soma e atualiza os valores total
     * @return 
     */
    private float somaEAtualizaValorTotal() {
        
        float soma = 0;
        float valor = 0;
        int cont = tbProdutos.getRowCount();
        for (int i = 0; i < cont; i++) {
            valor = Float.parseFloat(String.valueOf(tbProdutos.getValueAt(i, 5)));
            soma = valor+soma;
        }
        return bLMascaras.arredondamentoComPontoDuasCasas(soma);
    }
    
    
     private void carregarPedidos() {
        listaModelVendas = controllerVendas.getListaPedidosController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasPedidos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelVendas.size();
        for (int i = 0; i < cont; i++) {
            modelCliente = controllerCliente.getClienteController(listaModelVendas.get(i).getClientesCodigo());
            modelo.addRow(new Object[]{
                listaModelVendas.get(i).getCodigo(),
                modelCliente.getNome(),
                modelCliente.getCpfCNPJ(),
                modelCliente.getObservacao(),
                listaModelVendas.get(i).getDataVenda(),
                listaModelVendas.get(i).getValorTotal(),                
                listaModelVendas.get(i).getObservacao(),
              //  listaModelVendas.get(i).getValorOrc()
            });
        }
    }
     
     private void carregarOrcamentos() {
        listaModelVendas = controllerVendas.getListaOrcamentoController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasOrcamentos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelVendas.size();
        for (int i = 0; i < cont; i++) {
            modelCliente = controllerCliente.getClienteController(listaModelVendas.get(i).getClientesCodigo());
            modelo.addRow(new Object[]{
                listaModelVendas.get(i).getCodigo(),
                modelCliente.getNome(),
                modelCliente.getCpfCNPJ(),
                modelCliente.getObservacao(),
                listaModelVendas.get(i).getDataVenda(),
                listaModelVendas.get(i).getValorTotal(),  
                listaModelVendas.get(i).getObservacao()
            });
        }
    }
    
    
    /**
     * retorna os produtos para o estoque
     * @param pCodigoProduto 
     */
    private void retornarProdutoAoEstoque(){
            float quantidade;
            listaModelProdutos = new ArrayList<>();
            int cont = listaModelVendasAlterar.size();
            for (int i = 0; i < cont; i++) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodigo(listaModelVendasAlterar.get(i).getProdutosCodigo());
                quantidade = controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque() + listaModelVendasAlterar.get(i).getQuantidade();
                modelProdutos.setEstoque(quantidade);
                listaModelProdutos.add(modelProdutos);
            }
            modelProdutos.setListaModelProdutoses(listaModelProdutos);
            controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewOrdemDServico().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton N;
    private javax.swing.JRadioButton S;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btAlterar1;
    private javax.swing.JButton btAprovar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btCancelar2;
    private javax.swing.JButton btDesaprovar;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIncluirProduto;
    private javax.swing.JButton btPesquisarOrcamento;
    private javax.swing.JButton btPesquisarPedido;
    private javax.swing.JButton btRetirar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbClientes;
    private javax.swing.JComboBox cbCodCliente;
    private javax.swing.JComboBox cbCodProduto;
    private javax.swing.JComboBox cbFiltroPesquisaOrcamento;
    private javax.swing.JComboBox cbFiltroPesquisaPedido;
    private javax.swing.JComboBox cbProdutos;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimirOrcamento;
    private javax.swing.JButton jbImprimirPedido;
    private javax.swing.JComboBox jcbTipoPagamento;
    private javax.swing.JFormattedTextField jdDataEntrada;
    private com.toedter.calendar.JDateChooser jdPagamento;
    private com.toedter.calendar.JDateChooser jdVencimento;
    private javax.swing.JFormattedTextField jtfHorario;
    private javax.swing.JTable tbConsultasOrcamentos;
    private javax.swing.JTable tbConsultasPedidos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCpfCnpj;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNumeroVenda;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfObservacaoCliente;
    private javax.swing.JTextField tfPesquisaPedido;
    private javax.swing.JTextField tfPesquisaorcamento;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUnidadeMedida;
    private javax.swing.JTextField tfValorOrc;
    private javax.swing.JFormattedTextField tfValorTotal;
    private javax.swing.JTextField tfValorTotalProduto;
    private javax.swing.JTextField tfValorUnitario;
    // End of variables declaration//GEN-END:variables
    
}
