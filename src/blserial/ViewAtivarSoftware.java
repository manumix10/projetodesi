
package blserial;

import com.thoughtworks.xstream.XStream;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ViewAtivarSoftware
extends JFrame {
    private Config configGlobal;
    private JButton btFechar;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton jbNFe;
    private JButton jbRede;

    public ViewAtivarSoftware() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jbRede = new JButton();
        this.jbNFe = new JButton();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.btFechar = new JButton();
        this.jLabel2 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Ativa\u00e7\u00e3o do software");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/imagens/blicon.png")).getImage());
        this.jButton1.setBackground(new Color(0, 0, 153));
        this.jButton1.setFont(new Font("Tahoma", 1, 14));
        this.jButton1.setForeground(new Color(255, 255, 255));
        this.jButton1.setText("Gratuito");
        this.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtivarSoftware.this.jButton1ActionPerformed(evt);
            }
        });
        this.jbRede.setBackground(new Color(0, 153, 102));
        this.jbRede.setFont(new Font("Tahoma", 1, 14));
        this.jbRede.setForeground(new Color(255, 255, 255));
        this.jbRede.setText("Pago c/ Rede");
        this.jbRede.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtivarSoftware.this.jbRedeActionPerformed(evt);
            }
        });
        this.jbNFe.setBackground(new Color(255, 255, 0));
        this.jbNFe.setFont(new Font("Tahoma", 1, 14));
        this.jbNFe.setForeground(new Color(0, 0, 204));
        this.jbNFe.setText("Pago c/ NFe");
        this.jbNFe.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtivarSoftware.this.jbNFeActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setForeground(new Color(153, 0, 204));
        this.jLabel1.setText("Fun\u00e7\u00f5es do Software");
        this.jTable1.setModel(new DefaultTableModel(new Object[][]{{"Instala\u00e7\u00e3o em v\u00e1rios computadores em rede", "N\u00c3O", "SIM", "SIM"}, {"Emiss\u00e3o de Nota Fiscal Eletr\u00f4nica", "N\u00c3O", "N\u00c3O", "SIM"}, {"Suporte gratuito incluso", "N\u00c3O", "N\u00c3O", "N\u00c3O"}, {"Treinamento em v\u00eddeo-aula", "SIM", "SIM", "SIM"}, {"Cadastro de empresa com logo marca", "SIM", "SIM", "SIM"}, {"Cadastro de empresa com logo marca", "SIM", "SIM", "SIM"}, {"Cadastro de usu\u00e1rios", "SIM", "SIM", "SIM"}, {"Cadastro de clientes", "SIM", "SIM", "SIM"}, {"Cadastro de fornecedores", "SIM", "SIM", "SIM"}, {"Cadastro de cidades", "SIM", "SIM", "SIM"}, {"Cadastro de unidade de medida", "SIM", "SIM", "SIM"}, {"Cadastro de forma de pagamento", "SIM", "SIM", "SIM"}, {"Cadastro de produtos com c\u00f3digo de barras", "SIM", "SIM", "SIM"}, {"Controle de estoque", "SIM", "SIM", "SIM"}, {"Emiss\u00e3o de or\u00e7amento", "SIM", "SIM", "SIM"}, {"Emiss\u00e3o de pedidos", "SIM", "SIM", "SIM"}, {"PDV n\u00e3o fiscal", "SIM", "SIM", "SIM"}, {"Contas a pagar e contas a receber", "SIM", "SIM", "SIM"}, {"Fluxo de caixa", "SIM", "SIM", "SIM"}, {"Atualiza\u00e7\u00e3o autom\u00e1tica de vers\u00f5es", "SIM", "SIM", "SIM"}, {"Emiss\u00e3o de etiquetas de c\u00f3digos de barras", "SIM", "SIM", "SIM"}, {"Relat\u00f3rios de pedidos de vendas", "SIM", "SIM", "SIM"}, {"Relat\u00f3rios de produtos", "SIM", "SIM", "SIM"}, {"Relat\u00f3rios de clientes", "SIM", "SIM", "SIM"}, {"Relat\u00f3rios de fornecedores", "SIM", "SIM", "SIM"}, {"Relat\u00f3rio de vendas por per\u00edodo", "SIM", "SIM", "SIM"}, {"Relat\u00f3rio de contas por per\u00edodo", "SIM", "SIM", "SIM"}, {"Relat\u00f3rios de movimenta\u00e7\u00f5es de caixa", "SIM", "SIM", "SIM"}}, new String[]{"", "", "", ""}));
        this.jTable1.setCursor(new Cursor(0));
        this.jScrollPane1.setViewportView(this.jTable1);
        if (this.jTable1.getColumnModel().getColumnCount() > 0) {
            this.jTable1.getColumnModel().getColumn(0).setResizable(false);
            this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(215);
            this.jTable1.getColumnModel().getColumn(1).setResizable(false);
            this.jTable1.getColumnModel().getColumn(2).setResizable(false);
            this.jTable1.getColumnModel().getColumn(3).setResizable(false);
        }
        this.btFechar.setIcon(new ImageIcon(this.getClass().getResource("/imagens/24x24/Exit.png")));
        this.btFechar.setText("Sair do software");
        this.btFechar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ViewAtivarSoftware.this.btFecharActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Tahoma", 3, 12));
        this.jLabel2.setForeground(new Color(0, 102, 102));
        this.jLabel2.setText("Selecione uma op\u00e7\u00e3o de licen\u00e7a para ativar o software:");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(50, 50, 50).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, 32767).addComponent(this.jButton1, -2, 130, -2).addGap(18, 18, 18).addComponent(this.jbRede, -2, 130, -2).addGap(18, 18, 18).addComponent(this.jbNFe, -2, 130, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(290, 290, 290).addComponent(this.btFechar).addGap(0, 0, 32767))).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGap(174, 174, 174).addComponent(this.jLabel2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jbRede, -2, 50, -2).addComponent(this.jbNFe, -2, 50, -2).addComponent(this.jButton1, -2, 50, -2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 476, 32767).addGap(12, 12, 12).addComponent(this.btFechar).addContainerGap()));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.imprimirLicenca();
        this.configGlobal = this.pegarDadosInterface();
        this.configGlobal = this.getDadosInterface(this.imprimirSerial(this.configGlobal));
        try {
            this.gerarArquivo(this.configGlobal);
            JOptionPane.showMessageDialog(this, "Software registrado gratuitamente com sucesso! \n Inicie novamente o software.");
            System.exit(0);
        }
        catch (IOException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jbNFeActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Vers\u00e3o com NFe ainda n\u00e3o disponivel!");
    }

    private void jbRedeActionPerformed(ActionEvent evt) {
   //     Desktop desk = Desktop.getDesktop();
        try {
 //           desk.browse(new URI("http://www.blsoft.com.br/loja/index.php?route=product/product&path=20_27&product_id=76"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btFecharActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private Config pegarDadosInterface() {
        Config config = new Config();
        BLCriptografiaReversivel criptografia = new BLCriptografiaReversivel();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            config.setIp(BLCriptografiaReversivel.criptografar("localhost"));
        }
        catch (BadPaddingException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchPaddingException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalBlockSizeException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InvalidKeyException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config;
    }

    private String imprimirSerial(Config pConfig) {
   //     return null;
        String serialComTralha = pConfig.getMac() + "#" + pConfig.getSoftware() + "#" + pConfig.getDataAtualStr() + "#" + pConfig.getDiasValidadeStr() + "#" + pConfig.getDataGeracaoStr() + "#" + pConfig.getIp();
        return serialComTralha;
    }

    private Config getDadosInterface(String pSerialComTralha) {
        Config config = new Config();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        return config;
    }

    private boolean gerarArquivo(Config pConfing) throws IOException {
        String textoArquivo = new String();
        XStream xStream = new XStream();
        FileWriter fileWriter = new FileWriter("config/config.xml");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        xStream.alias("config", Config.class);
        textoArquivo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
       textoArquivo = textoArquivo + xStream.toXML((Object)pConfing);
        printWriter.printf(textoArquivo, new Object[0]);
        fileWriter.close();
        return true;
    }

    public boolean imprimirLicenca() {
        Config config = new Config();
        XStream xStream = new XStream();
        BLDatas bLDatas = new BLDatas();
        BLCriptografiaReversivel criptografia = new BLCriptografiaReversivel();
        ConfigXML configXML = new ConfigXML();
        xStream.alias("config", Config.class);
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            config = configXML.getConfig("config/config.xml");
            config.setSoftware(BLCriptografiaReversivel.descriptografar(config.getSoftware()));
            config.setMac(new NomeComputador().getComputador());
            config.setDataAtualStr(BLCriptografiaReversivel.descriptografar(config.getDataAtualStr()));
            config.setDataGeracaoStr(BLCriptografiaReversivel.descriptografar(config.getDataGeracaoStr()));
            config.setDiasValidade(Integer.parseInt(BLCriptografiaReversivel.descriptografar(config.getDiasValidadeStr())));
            config.setDataAtual(formater.parse(config.getDataAtualStr()));
            config.setDataGeracao(formater.parse(config.getDataGeracaoStr()));
            config.setDataValidade(bLDatas.addDias(config.getDiasValidade(), config.getDataGeracao()));
            config.setNomePC(new NomeComputador().getComputador());
            this.configGlobal = config;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: Serial incorreto.");
            return false;
        }
        return true;
    }

    public boolean validarArquivoXML() {
        String textoArquivo = new String();
        Config config = new Config();
        NomeComputador mac = new NomeComputador();
        XStream xStream = new XStream();
        BLDatas bLDatas = new BLDatas();
        BLCriptografiaReversivel criptografia = new BLCriptografiaReversivel();
        ConfigXML configXML = new ConfigXML();
        xStream.alias("config", Config.class);
        FileWriter fileWriter2 = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            config = configXML.getConfig("config/config.xml");
            config.setSoftware(BLCriptografiaReversivel.descriptografar(config.getSoftware()));
            config.setDataAtualStr(BLCriptografiaReversivel.descriptografar(config.getDataAtualStr()));
            config.setDataGeracaoStr(BLCriptografiaReversivel.descriptografar(config.getDataGeracaoStr()));
            config.setDiasValidade(Integer.parseInt(BLCriptografiaReversivel.descriptografar(config.getDiasValidadeStr())));
            config.setDiasValidadeStr(BLCriptografiaReversivel.descriptografar(config.getDiasValidadeStr()));
            config.setDataAtual(formater.parse(config.getDataAtualStr()));
            config.setDataGeracao(formater.parse(config.getDataGeracaoStr()));
            config.setDataValidade(bLDatas.addDias(config.getDiasValidade(), config.getDataGeracao()));
            config.setMac(BLCriptografiaReversivel.descriptografar(config.getMac()));
            if (!config.getMac().equals(mac.getComputador())) {
                JOptionPane.showMessageDialog(this, "Software n\u00e3o registrado! \n Siga os passos para registrar o software e solicitar o serial!");
                return false;
            }
            if (new Date().before(config.getDataAtual())) {
                JOptionPane.showMessageDialog(this, "A data do seu sistema est\u00e1 incorreta!\nAltere para a data correta para usar o sistema.");
                return false;
            }
            if (new Date().after(config.getDataValidade())) {
                JOptionPane.showMessageDialog(this, "Licen\u00e7a expirada.\nPara renovar a licen\u00e7a acesse: www.blsoft.com.br");
                return false;
            }
            config.setDataAtualStr(BLCriptografiaReversivel.criptografar(formater.format(new Date())));
            config.setSoftware(BLCriptografiaReversivel.criptografar(config.getSoftware()));
            config.setDataGeracaoStr(BLCriptografiaReversivel.criptografar(config.getDataGeracaoStr()));
            config.setDiasValidade(0);
            config.setDiasValidadeStr(BLCriptografiaReversivel.criptografar(config.getDiasValidadeStr()));
            config.setDataAtual(null);
            config.setDataGeracao(null);
            config.setDataValidade(null);
            config.setMac(BLCriptografiaReversivel.criptografar(config.getMac()));
            fileWriter2 = new FileWriter("config/config.xml");
            PrintWriter printWriter2 = new PrintWriter(fileWriter2);
            textoArquivo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            textoArquivo = textoArquivo + xStream.toXML((Object)config);
            printWriter2.printf(textoArquivo, new Object[0]);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Arquivo de configura\u00e7\u00f5es n\u00e3o encontrado.");
            return false;
        }
        catch (BadPaddingException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x01");
            return false;
        }
        catch (NoSuchPaddingException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x02");
            return false;
        }
        catch (IllegalBlockSizeException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x03");
            return false;
        }
        catch (InvalidKeyException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x04");
            return false;
        }
        catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x05");
            return false;
        }
        catch (InvalidAlgorithmParameterException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x06");
            return false;
        }
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es. x07");
            return false;
        }
        try {
            fileWriter2.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: Ocorreu um erro no Arquivo de configura\u00e7\u00f5es.");
            return false;
        }
        return true;
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
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewAtivarSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new ViewAtivarSoftware().setVisible(true);
               // new ViewLogin().setVisible(true);
            }
        });
    }

}

