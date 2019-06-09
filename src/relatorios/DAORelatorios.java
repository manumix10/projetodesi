
package relatorios;

import conexoes.ConexaoFirebird;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class DAORelatorios
extends ConexaoFirebird {
    private final String NOME_DO_RELATORIO = "C:/Sistema Assistencia OS/temp/" + new Date().getTime() + ".pdf";

    public boolean gerarRelatorioCliente() {
        try {
            this.conectar();
            this.executarSQL("SELECT      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME  FROM      CIDADE CIDADE INNER JOIN ESTADO ESTADO ON CIDADE.FK_COD_ESTADO = ESTADO.CODIGO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioClienteIndividual(int pCodigoCliente) {
        try {
            this.conectar();
            this.executarSQL("SELECT      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      CIDADE.NOME AS CIDADE_NOME,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME,      CLIENTES.CODIGO AS CLIENTES_CODIGO FROM      CIDADE CIDADE INNER JOIN ESTADO ESTADO ON CIDADE.FK_COD_ESTADO = ESTADO.CODIGO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE WHERE clientes.CODIGO = '" + pCodigoCliente + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioProdutos() {
        try {
            this.conectar();
            this.executarSQL("SELECT      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      UNIDADE_MEDIDA.CODIGO AS UNIDADE_MEDIDA_CODIGO,      UNIDADE_MEDIDA.ABREVIACAO AS UNIDADE_MEDIDA_ABREVIACAO,      UNIDADE_MEDIDA.DESCRICAO AS UNIDADE_MEDIDA_DESCRICAO FROM      UNIDADE_MEDIDA UNIDADE_MEDIDA INNER JOIN PRODUTOS PRODUTOS ON UNIDADE_MEDIDA.CODIGO = PRODUTOS.UNIDADE_MEDIDA      INNER JOIN FORNECEDORES FORNECEDORES ON PRODUTOS.FORNECEDORES_CODIGO = FORNECEDORES.CODIGO");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioFornecedores() {
        try {
            this.conectar();
            this.executarSQL("SELECT      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      CIDADE CIDADE INNER JOIN ESTADO ESTADO ON CIDADE.FK_COD_ESTADO = ESTADO.CODIGO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioFornecedores.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDAS_CODIGO,      VENDAS.CLIENTES_CODIGO AS VENDAS_CLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDAS_DATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDAS_VALOR_TOTAL,      VENDAS.DESCONTO AS VENDAS_DESCONTO,      VENDAS.TIPO_PAGAMENTO AS VENDAS_TIPO_PAGAMENTO,      VENDAS.TIPO AS VENDAS_TIPO,      VENDAS.OBSERVACAO AS VENDAS_OBSERVACAO,      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTO_CODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTO_CODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTO_CODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTO_QUANTIDADE,      VENDAS_PRODUTO.VALOR_UNITARIO AS VENDAS_PRODUTO_VALOR_UNITARIO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME,      FORMA_PAGAMENTO.CODIGO AS FORMA_PAGAMENTO_CODIGO,      FORMA_PAGAMENTO.DESCRICAO AS FORMA_PAGAMENTO_DESCRICAO,      FORMA_PAGAMENTO.DESCONTO AS FORMA_PAGAMENTO_DESCONTO,      FORMA_PAGAMENTO.QUANTIDADE_PARCELAS AS FORMA_PAGAMENTO_QUANTIDADE_PARC,      FORMA_PAGAMENTO.OBSERVACAO AS FORMA_PAGAMENTO_OBSERVACAO,      FORMA_PAGAMENTO.SITUACAO AS FORMA_PAGAMENTO_SITUACAO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      UNIDADE_MEDIDA.CODIGO AS UNIDADE_MEDIDA_CODIGO,      UNIDADE_MEDIDA.ABREVIACAO AS UNIDADE_MEDIDA_ABREVIACAO,      UNIDADE_MEDIDA.DESCRICAO AS UNIDADE_MEDIDA_DESCRICAO FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN VENDAS VENDAS ON CLIENTES.CODIGO = VENDAS.CLIENTES_CODIGO      INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN FORMA_PAGAMENTO FORMA_PAGAMENTO ON VENDAS.TIPO_PAGAMENTO = FORMA_PAGAMENTO.CODIGO      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO      INNER JOIN UNIDADE_MEDIDA UNIDADE_MEDIDA ON PRODUTOS.UNIDADE_MEDIDA = UNIDADE_MEDIDA.CODIGO      INNER JOIN FORNECEDORES FORNECEDORES ON PRODUTOS.FORNECEDORES_CODIGO = FORNECEDORES.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }
    public boolean gerarRelatorioVenda2(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDAS_CODIGO,      VENDAS.CLIENTES_CODIGO AS VENDAS_CLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDAS_DATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDAS_VALOR_TOTAL,      VENDAS.DESCONTO AS VENDAS_DESCONTO,      VENDAS.TIPO_PAGAMENTO AS VENDAS_TIPO_PAGAMENTO,      VENDAS.TIPO AS VENDAS_TIPO,      VENDAS.OBSERVACAO AS VENDAS_OBSERVACAO,      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTO_CODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTO_CODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTO_CODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTO_QUANTIDADE,      VENDAS_PRODUTO.VALOR_UNITARIO AS VENDAS_PRODUTO_VALOR_UNITARIO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME,      FORMA_PAGAMENTO.CODIGO AS FORMA_PAGAMENTO_CODIGO,      FORMA_PAGAMENTO.DESCRICAO AS FORMA_PAGAMENTO_DESCRICAO,      FORMA_PAGAMENTO.DESCONTO AS FORMA_PAGAMENTO_DESCONTO,      FORMA_PAGAMENTO.QUANTIDADE_PARCELAS AS FORMA_PAGAMENTO_QUANTIDADE_PARC,      FORMA_PAGAMENTO.OBSERVACAO AS FORMA_PAGAMENTO_OBSERVACAO,      FORMA_PAGAMENTO.SITUACAO AS FORMA_PAGAMENTO_SITUACAO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      UNIDADE_MEDIDA.CODIGO AS UNIDADE_MEDIDA_CODIGO,      UNIDADE_MEDIDA.ABREVIACAO AS UNIDADE_MEDIDA_ABREVIACAO,      UNIDADE_MEDIDA.DESCRICAO AS UNIDADE_MEDIDA_DESCRICAO FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN VENDAS VENDAS ON CLIENTES.CODIGO = VENDAS.CLIENTES_CODIGO      INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN FORMA_PAGAMENTO FORMA_PAGAMENTO ON VENDAS.TIPO_PAGAMENTO = FORMA_PAGAMENTO.CODIGO      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO      INNER JOIN UNIDADE_MEDIDA UNIDADE_MEDIDA ON PRODUTOS.UNIDADE_MEDIDA = UNIDADE_MEDIDA.CODIGO      INNER JOIN FORNECEDORES FORNECEDORES ON PRODUTOS.FORNECEDORES_CODIGO = FORNECEDORES.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas2.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOrcamento(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDAS_CODIGO,      VENDAS.CLIENTES_CODIGO AS VENDAS_CLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDAS_DATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDAS_VALOR_TOTAL,      VENDAS.DESCONTO AS VENDAS_DESCONTO,      VENDAS.TIPO_PAGAMENTO AS VENDAS_TIPO_PAGAMENTO,      VENDAS.TIPO AS VENDAS_TIPO,      VENDAS.OBSERVACAO AS VENDAS_OBSERVACAO,      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTO_CODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTO_CODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTO_CODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTO_QUANTIDADE,      VENDAS_PRODUTO.VALOR_UNITARIO AS VENDAS_PRODUTO_VALOR_UNITARIO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME,      FORMA_PAGAMENTO.CODIGO AS FORMA_PAGAMENTO_CODIGO,      FORMA_PAGAMENTO.DESCRICAO AS FORMA_PAGAMENTO_DESCRICAO,      FORMA_PAGAMENTO.DESCONTO AS FORMA_PAGAMENTO_DESCONTO,      FORMA_PAGAMENTO.QUANTIDADE_PARCELAS AS FORMA_PAGAMENTO_QUANTIDADE_PARC,      FORMA_PAGAMENTO.OBSERVACAO AS FORMA_PAGAMENTO_OBSERVACAO,      FORMA_PAGAMENTO.SITUACAO AS FORMA_PAGAMENTO_SITUACAO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      UNIDADE_MEDIDA.CODIGO AS UNIDADE_MEDIDA_CODIGO,      UNIDADE_MEDIDA.ABREVIACAO AS UNIDADE_MEDIDA_ABREVIACAO,      UNIDADE_MEDIDA.DESCRICAO AS UNIDADE_MEDIDA_DESCRICAO FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN VENDAS VENDAS ON CLIENTES.CODIGO = VENDAS.CLIENTES_CODIGO      INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN FORMA_PAGAMENTO FORMA_PAGAMENTO ON VENDAS.TIPO_PAGAMENTO = FORMA_PAGAMENTO.CODIGO      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO      INNER JOIN UNIDADE_MEDIDA UNIDADE_MEDIDA ON PRODUTOS.UNIDADE_MEDIDA = UNIDADE_MEDIDA.CODIGO      INNER JOIN FORNECEDORES FORNECEDORES ON PRODUTOS.FORNECEDORES_CODIGO = FORNECEDORES.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioOrcamento.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);            
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDASCODIGO,      VENDAS.CLIENTES_CODIGO AS VENDASCLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDASDATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDASVALOR_TOTAL,      VENDAS.DESCONTO AS VENDASDESCONTO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTOCODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTOCODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTOCODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTOQUANTIDADE,      PRODUTOS.CODIGO AS PRODUTOSCODIGO,      PRODUTOS.NOME AS PRODUTOSNOME,      PRODUTOS.VALOR AS PRODUTOSVALOR,      CLIENTES.CODIGO AS CLIENTESCODIGO,      empresa.RAZAO_SOCIAL AS empresa_RAZAO_SOCIAL,      empresa.NOME_FANTASIA AS empresa_NOME_FANTASIA,      empresa.ENDERECO AS empresa_ENDERECO,      empresa.BAIRRO AS empresa_BAIRRO,      empresa.COD_CIDADE AS empresa_COD_CIDADE,      empresa.COD_ESTADO AS empresa_COD_ESTADO,      empresa.CEP AS empresa_CEP,      empresa.TELEFONE AS empresa_TELEFONE,      empresa.CNPJ AS empresa_CNPJ,      estado.uf AS estado_uf,      cidade.nome AS cidade_nome FROM      VENDAS VENDAS INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN CLIENTES CLIENTES ON VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO,      estado estado INNER JOIN cidade cidade ON estado.codigo = cidade.fk_cod_estado      INNER JOIN empresa empresa ON cidade.codigo = empresa.COD_CIDADE      AND empresa.COD_ESTADO = estado.codigo where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPDV.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_RECEBER.PK_CODIGO AS CONTAS_RECEBER_PK_CODIGO,      CONTAS_RECEBER.FK_CODIGO_PESSOA AS CONTAS_RECEBER_FK_CODIGO_PESSOA,      CONTAS_RECEBER.DESCRICAO AS CONTAS_RECEBER_DESCRICAO,      CONTAS_RECEBER.DATA AS CONTAS_RECEBER_DATA,      CONTAS_RECEBER.VENCIMENTO AS CONTAS_RECEBER_VENCIMENTO,      CONTAS_RECEBER.FK_TIPO_PAGAMENTO AS CONTAS_RECEBER_FK_TIPO_PAGAMENT,      CONTAS_RECEBER.OBSERVACAO AS CONTAS_RECEBER_OBSERVACAO,      CONTAS_RECEBER.SITUACAO AS CONTAS_RECEBER_SITUACAO,      CONTAS_RECEBER.VALOR AS CONTAS_RECEBER_VALOR,      CONTAS_RECEBER.PAGAMENTO AS CONTAS_RECEBER_PAGAMENTO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      CIDADE CIDADE INNER JOIN ESTADO ESTADO ON CIDADE.FK_COD_ESTADO = ESTADO.CODIGO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN CONTAS_RECEBER CONTAS_RECEBER ON CLIENTES.CODIGO = CONTAS_RECEBER.FK_CODIGO_PESSOA WHERE pk_codigo = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_PAGAR.PK_CODIGO AS CONTAS_PAGAR_PK_CODIGO,      CONTAS_PAGAR.FK_CODIGO_PESSOA AS CONTAS_PAGAR_FK_CODIGO_PESSOA,      CONTAS_PAGAR.DESCRICAO AS CONTAS_PAGAR_DESCRICAO,      CONTAS_PAGAR.DATA AS CONTAS_PAGAR_DATA,      CONTAS_PAGAR.VENCIMENTO AS CONTAS_PAGAR_VENCIMENTO,      CONTAS_PAGAR.FK_TIPO_PAGAMENTO AS CONTAS_PAGAR_FK_TIPO_PAGAMENTO,      CONTAS_PAGAR.OBSERVACAO AS CONTAS_PAGAR_OBSERVACAO,      CONTAS_PAGAR.SITUACAO AS CONTAS_PAGAR_SITUACAO,      CONTAS_PAGAR.VALOR AS CONTAS_PAGAR_VALOR,      CONTAS_PAGAR.PAGAMENTO AS CONTAS_PAGAR_PAGAMENTO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,    FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE      INNER JOIN CONTAS_PAGAR CONTAS_PAGAR ON FORNECEDORES.CODIGO = CONTAS_PAGAR.FK_CODIGO_PESSOA WHERE CONTAS_PAGAR.PK_CODIGO = " + pCodigo + ";");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaPagar.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVendasCliente(Date pDataInicial, Date dataFinal, int pCodigoCliente) {
        try {
            this.conectar();
            this.executarSQL("SELECT      vendas.CODIGO AS vendas_CODIGO,      vendas.CLIENTES_CODIGO AS vendas_CLIENTES_CODIGO,      vendas.DATA_VENDA AS vendas_DATA_VENDA,      vendas.VALOR_TOTAL AS vendas_VALOR_TOTAL,      vendas.DESCONTO AS vendas_DESCONTO,      vendas_produto.QUANTIDADE AS vendas_produto_QUANTIDADE,      produtos.CODIGO AS produtos_CODIGO,      produtos.NOME AS produtos_NOME,      produtos.VALOR AS produtos_VALOR,      clientes.CODIGO AS clientes_CODIGO,      clientes.NOME AS clientes_NOME,      clientes.ENDERECO AS clientes_ENDERECO,      clientes.BAIRRO AS clientes_BAIRRO,      clientes.CEP AS clientes_CEP,      clientes.TELEFONE AS clientes_TELEFONE,      cidade.nome AS cidade_nome,      estado.uf AS estado_uf,      unidade_medida.abreviacao AS unidade_medida_abreviacao,      vendas.OBSERVACAO AS vendas_OBSERVACAO,      clientes.CPF_CNPJ AS clientes_CPF_CNPJ,      clientes.OBSERVACAO AS clientes_OBSERVACAO,      forma_pagamento.descricao AS forma_pagamento_descricao,      fornecedores.NOME AS fornecedores_NOME,      vendas_produto.VALOR_UNITARIO AS vendas_produto_VALOR_UNITARIO   FROM      vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.CODIGO = vendas_produto.CODIGO_VENDA      INNER JOIN produtos produtos ON vendas_produto.CODIGO_PRODUTO = produtos.CODIGO      INNER JOIN unidade_medida unidade_medida ON produtos.UNIDADE_MEDIDA = unidade_medida.codigo      INNER JOIN fornecedores fornecedores ON produtos.FORNECEDORES_CODIGO = fornecedores.CODIGO      INNER JOIN clientes clientes ON vendas.CLIENTES_CODIGO = clientes.CODIGO      INNER JOIN forma_pagamento forma_pagamento ON vendas.TIPO_PAGAMENTO = forma_pagamento.codigo      INNER JOIN estado estado ON clientes.COD_ESTADO = estado.codigo      INNER JOIN cidade cidade ON clientes.COD_CIDADE = cidade.codigo      AND estado.codigo = cidade.fk_cod_estado WHERE (data_venda BETWEEN  '" + pDataInicial + "' AND '" + dataFinal + "' )" + "AND (vendas.tipo = 1) " + "AND (clientes.codigo = '" + pCodigoCliente + "')");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPorCliente.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVendaTodosCliente(Date pDataInicial, Date dataFinal) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDAS_CODIGO,      VENDAS.CLIENTES_CODIGO AS VENDAS_CLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDAS_DATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDAS_VALOR_TOTAL,      VENDAS.DESCONTO AS VENDAS_DESCONTO,      VENDAS.TIPO_PAGAMENTO AS VENDAS_TIPO_PAGAMENTO,      VENDAS.TIPO AS VENDAS_TIPO,      VENDAS.OBSERVACAO AS VENDAS_OBSERVACAO,      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTO_CODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTO_CODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTO_CODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTO_QUANTIDADE,      VENDAS_PRODUTO.VALOR_UNITARIO AS VENDAS_PRODUTO_VALOR_UNITARIO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME,      FORMA_PAGAMENTO.CODIGO AS FORMA_PAGAMENTO_CODIGO,      FORMA_PAGAMENTO.DESCRICAO AS FORMA_PAGAMENTO_DESCRICAO,      FORMA_PAGAMENTO.DESCONTO AS FORMA_PAGAMENTO_DESCONTO,      FORMA_PAGAMENTO.QUANTIDADE_PARCELAS AS FORMA_PAGAMENTO_QUANTIDADE_PARC,      FORMA_PAGAMENTO.OBSERVACAO AS FORMA_PAGAMENTO_OBSERVACAO,      FORMA_PAGAMENTO.SITUACAO AS FORMA_PAGAMENTO_SITUACAO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      UNIDADE_MEDIDA.CODIGO AS UNIDADE_MEDIDA_CODIGO,      UNIDADE_MEDIDA.ABREVIACAO AS UNIDADE_MEDIDA_ABREVIACAO,      UNIDADE_MEDIDA.DESCRICAO AS UNIDADE_MEDIDA_DESCRICAO FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN VENDAS VENDAS ON CLIENTES.CODIGO = VENDAS.CLIENTES_CODIGO      INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN FORMA_PAGAMENTO FORMA_PAGAMENTO ON VENDAS.TIPO_PAGAMENTO = FORMA_PAGAMENTO.CODIGO      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO      INNER JOIN UNIDADE_MEDIDA UNIDADE_MEDIDA ON PRODUTOS.UNIDADE_MEDIDA = UNIDADE_MEDIDA.CODIGO      INNER JOIN FORNECEDORES FORNECEDORES ON PRODUTOS.FORNECEDORES_CODIGO = FORNECEDORES.CODIGO WHERE (data_venda BETWEEN  '" + pDataInicial + "' AND '" + dataFinal + "' )" + "AND (VENDAS.TIPO = 1)");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT      VENDAS.CODIGO AS VENDAS_CODIGO,      VENDAS.CLIENTES_CODIGO AS VENDAS_CLIENTES_CODIGO,      VENDAS.DATA_VENDA AS VENDAS_DATA_VENDA,      VENDAS.VALOR_TOTAL AS VENDAS_VALOR_TOTAL,      VENDAS.DESCONTO AS VENDAS_DESCONTO,      VENDAS.TIPO_PAGAMENTO AS VENDAS_TIPO_PAGAMENTO,      VENDAS.TIPO AS VENDAS_TIPO,      VENDAS.OBSERVACAO AS VENDAS_OBSERVACAO,      VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTO_CODIGO,      VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTO_CODIGO_PRODUTO,      VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTO_CODIGO_VENDA,      VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTO_QUANTIDADE,      VENDAS_PRODUTO.VALOR_UNITARIO AS VENDAS_PRODUTO_VALOR_UNITARIO,      PRODUTOS.CODIGO AS PRODUTOS_CODIGO,      PRODUTOS.FORNECEDORES_CODIGO AS PRODUTOS_FORNECEDORES_CODIGO,      PRODUTOS.NOME AS PRODUTOS_NOME,      PRODUTOS.VALOR AS PRODUTOS_VALOR,      PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE,      PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS,      PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN CLIENTES CLIENTES ON CIDADE.CODIGO = CLIENTES.COD_CIDADE      INNER JOIN VENDAS VENDAS ON CLIENTES.CODIGO = VENDAS.CLIENTES_CODIGO      INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA      INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO  WHERE VENDAS.CODIGO = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaVendasReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberCliente(int pCodigoCliente, int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "";
        pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioReceber.jasper" : "ArquivosJasper/relatorioRecebidas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_RECEBER.PK_CODIGO AS CONTAS_RECEBER_PK_CODIGO,      CONTAS_RECEBER.FK_CODIGO_PESSOA AS CONTAS_RECEBER_FK_CODIGO_PESSOA,      CONTAS_RECEBER.DESCRICAO AS CONTAS_RECEBER_DESCRICAO,      CONTAS_RECEBER.DATA AS CONTAS_RECEBER_DATA,      CONTAS_RECEBER.VENCIMENTO AS CONTAS_RECEBER_VENCIMENTO,      CONTAS_RECEBER.FK_TIPO_PAGAMENTO AS CONTAS_RECEBER_FK_TIPO_PAGAMENT,      CONTAS_RECEBER.OBSERVACAO AS CONTAS_RECEBER_OBSERVACAO,      CONTAS_RECEBER.SITUACAO AS CONTAS_RECEBER_SITUACAO,      CONTAS_RECEBER.VALOR AS CONTAS_RECEBER_VALOR,      CONTAS_RECEBER.PAGAMENTO AS CONTAS_RECEBER_PAGAMENTO,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO FROM      CLIENTES CLIENTES INNER JOIN CONTAS_RECEBER CONTAS_RECEBER ON CLIENTES.CODIGO = CONTAS_RECEBER.FK_CODIGO_PESSOA  WHERE (CLIENTES.CODIGO = '" + pCodigoCliente + "') AND (PAGAMENTO BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " ) AND (SITUACAO = '" + pStatus + "');");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasPagarFornecedor(int pCodigoFornecedor, int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "";
        pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioPagar.jasper" : "ArquivosJasper/relatorioPagas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CONTAS_PAGAR.PK_CODIGO AS CONTAS_PAGAR_PK_CODIGO,      CONTAS_PAGAR.FK_CODIGO_PESSOA AS CONTAS_PAGAR_FK_CODIGO_PESSOA,      CONTAS_PAGAR.DESCRICAO AS CONTAS_PAGAR_DESCRICAO,      CONTAS_PAGAR.DATA AS CONTAS_PAGAR_DATA,      CONTAS_PAGAR.VENCIMENTO AS CONTAS_PAGAR_VENCIMENTO,      CONTAS_PAGAR.FK_TIPO_PAGAMENTO AS CONTAS_PAGAR_FK_TIPO_PAGAMENTO,      CONTAS_PAGAR.OBSERVACAO AS CONTAS_PAGAR_OBSERVACAO,      CONTAS_PAGAR.SITUACAO AS CONTAS_PAGAR_SITUACAO,      CONTAS_PAGAR.VALOR AS CONTAS_PAGAR_VALOR,      CONTAS_PAGAR.PAGAMENTO AS CONTAS_PAGAR_PAGAMENTO,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE      INNER JOIN CONTAS_PAGAR CONTAS_PAGAR ON FORNECEDORES.CODIGO = CONTAS_PAGAR.FK_CODIGO_PESSOA WHERE (FORNECEDORES.CODIGO = '" + pCodigoFornecedor + "') AND (PAGAMENTO BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " ) AND (SITUACAO = '" + pStatus + "');");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "";
        pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioReceber.jasper" : "ArquivosJasper/relatorioRecebidas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_RECEBER.PK_CODIGO AS CONTAS_RECEBER_PK_CODIGO,      CONTAS_RECEBER.FK_CODIGO_PESSOA AS CONTAS_RECEBER_FK_CODIGO_PESSOA,      CONTAS_RECEBER.DESCRICAO AS CONTAS_RECEBER_DESCRICAO,      CONTAS_RECEBER.DATA AS CONTAS_RECEBER_DATA,      CONTAS_RECEBER.VENCIMENTO AS CONTAS_RECEBER_VENCIMENTO,      CONTAS_RECEBER.FK_TIPO_PAGAMENTO AS CONTAS_RECEBER_FK_TIPO_PAGAMENT,      CONTAS_RECEBER.OBSERVACAO AS CONTAS_RECEBER_OBSERVACAO,      CONTAS_RECEBER.SITUACAO AS CONTAS_RECEBER_SITUACAO,      CONTAS_RECEBER.VALOR AS CONTAS_RECEBER_VALOR,      CONTAS_RECEBER.PAGAMENTO AS CONTAS_RECEBER_PAGAMENTO,      CLIENTES.CODIGO AS CLIENTES_CODIGO,      CLIENTES.NOME AS CLIENTES_NOME,      CLIENTES.ENDERECO AS CLIENTES_ENDERECO,      CLIENTES.BAIRRO AS CLIENTES_BAIRRO,      CLIENTES.COD_CIDADE AS CLIENTES_COD_CIDADE,      CLIENTES.COD_ESTADO AS CLIENTES_COD_ESTADO,      CLIENTES.CEP AS CLIENTES_CEP,      CLIENTES.TELEFONE AS CLIENTES_TELEFONE,      CLIENTES.CPF_CNPJ AS CLIENTES_CPF_CNPJ,      CLIENTES.OBSERVACAO AS CLIENTES_OBSERVACAO FROM      CLIENTES CLIENTES INNER JOIN CONTAS_RECEBER CONTAS_RECEBER ON CLIENTES.CODIGO = CONTAS_RECEBER.FK_CODIGO_PESSOA  WHERE pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " AND SITUACAO = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasPagarTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "";
        pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioPagar.jasper" : "ArquivosJasper/relatorioPagas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_PAGAR.PK_CODIGO AS CONTAS_PAGAR_PK_CODIGO,      CONTAS_PAGAR.FK_CODIGO_PESSOA AS CONTAS_PAGAR_FK_CODIGO_PESSOA,      CONTAS_PAGAR.DESCRICAO AS CONTAS_PAGAR_DESCRICAO,      CONTAS_PAGAR.DATA AS CONTAS_PAGAR_DATA,      CONTAS_PAGAR.VENCIMENTO AS CONTAS_PAGAR_VENCIMENTO,      CONTAS_PAGAR.FK_TIPO_PAGAMENTO AS CONTAS_PAGAR_FK_TIPO_PAGAMENTO,      CONTAS_PAGAR.OBSERVACAO AS CONTAS_PAGAR_OBSERVACAO,      CONTAS_PAGAR.SITUACAO AS CONTAS_PAGAR_SITUACAO,      CONTAS_PAGAR.VALOR AS CONTAS_PAGAR_VALOR,      CONTAS_PAGAR.PAGAMENTO AS CONTAS_PAGAR_PAGAMENTO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,       FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,    FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,        CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,    ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE      INNER JOIN CONTAS_PAGAR CONTAS_PAGAR ON FORNECEDORES.CODIGO = CONTAS_PAGAR.FK_CODIGO_PESSOA  WHERE pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " AND SITUACAO = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }
    public boolean gerarRelatorioFornecedorTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "ArquivosJasper/relatorioProdutosFornecedor.jasper";
   //     pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioPagar.jasper" : "ArquivosJasper/relatorioPagas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_PAGAR.PK_CODIGO AS CONTAS_PAGAR_PK_CODIGO,      CONTAS_PAGAR.FK_CODIGO_PESSOA AS CONTAS_PAGAR_FK_CODIGO_PESSOA,      CONTAS_PAGAR.DESCRICAO AS CONTAS_PAGAR_DESCRICAO,      CONTAS_PAGAR.DATA AS CONTAS_PAGAR_DATA,      CONTAS_PAGAR.VENCIMENTO AS CONTAS_PAGAR_VENCIMENTO,      CONTAS_PAGAR.FK_TIPO_PAGAMENTO AS CONTAS_PAGAR_FK_TIPO_PAGAMENTO,      CONTAS_PAGAR.OBSERVACAO AS CONTAS_PAGAR_OBSERVACAO,      CONTAS_PAGAR.SITUACAO AS CONTAS_PAGAR_SITUACAO,      CONTAS_PAGAR.VALOR AS CONTAS_PAGAR_VALOR,      CONTAS_PAGAR.PAGAMENTO AS CONTAS_PAGAR_PAGAMENTO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,       FORNECEDORES.COD_CIDADE AS FORNECEDORES_COD_CIDADE,      FORNECEDORES.COD_ESTADO AS FORNECEDORES_COD_ESTADO,    FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,        CIDADE.FK_COD_ESTADO AS CIDADE_FK_COD_ESTADO,    ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE      INNER JOIN CONTAS_PAGAR CONTAS_PAGAR ON FORNECEDORES.CODIGO = CONTAS_PAGAR.FK_CODIGO_PESSOA  WHERE pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " AND SITUACAO = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAberturaFechamentoTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "";
        pCaminho = pStatus == 0 ? "ArquivosJasper/relatorioPagar.jasper" : "ArquivosJasper/relatorioPagas.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      CONTAS_PAGAR.PK_CODIGO AS CONTAS_PAGAR_PK_CODIGO,      CONTAS_PAGAR.FK_CODIGO_PESSOA AS CONTAS_PAGAR_FK_CODIGO_PESSOA,      CONTAS_PAGAR.DESCRICAO AS CONTAS_PAGAR_DESCRICAO,      CONTAS_PAGAR.DATA AS CONTAS_PAGAR_DATA,      CONTAS_PAGAR.VENCIMENTO AS CONTAS_PAGAR_VENCIMENTO,      CONTAS_PAGAR.FK_TIPO_PAGAMENTO AS CONTAS_PAGAR_FK_TIPO_PAGAMENTO,      CONTAS_PAGAR.OBSERVACAO AS CONTAS_PAGAR_OBSERVACAO,      CONTAS_PAGAR.SITUACAO AS CONTAS_PAGAR_SITUACAO,      CONTAS_PAGAR.VALOR AS CONTAS_PAGAR_VALOR,      CONTAS_PAGAR.PAGAMENTO AS CONTAS_PAGAR_PAGAMENTO,      FORNECEDORES.CODIGO AS FORNECEDORES_CODIGO,      FORNECEDORES.NOME AS FORNECEDORES_NOME,      FORNECEDORES.ENDERECO AS FORNECEDORES_ENDERECO,      FORNECEDORES.BAIRRO AS FORNECEDORES_BAIRRO,      FORNECEDORES.CEP AS FORNECEDORES_CEP,      FORNECEDORES.TELEFONE AS FORNECEDORES_TELEFONE,      CIDADE.CODIGO AS CIDADE_CODIGO,      CIDADE.NOME AS CIDADE_NOME,      ESTADO.CODIGO AS ESTADO_CODIGO,      ESTADO.UF AS ESTADO_UF,      ESTADO.NOME AS ESTADO_NOME FROM      ESTADO ESTADO INNER JOIN CIDADE CIDADE ON ESTADO.CODIGO = CIDADE.FK_COD_ESTADO      INNER JOIN FORNECEDORES FORNECEDORES ON CIDADE.CODIGO = FORNECEDORES.COD_CIDADE      INNER JOIN CONTAS_PAGAR CONTAS_PAGAR ON FORNECEDORES.CODIGO = CONTAS_PAGAR.FK_CODIGO_PESSOA  WHERE pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'" + " AND SITUACAO = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioCompraEstoque(int pCodigo) {
        String pCaminho = "ArquivosJasper/relatorioComprarEstoque.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT COMPRAS_PRODUTOS.CODIGO AS COMPRAS_PRODUTOS_CODIGO, COMPRAS_PRODUTOS.CODIGO_PRODUTO AS COMPRAS_PRODUTOS_CODIGO_PRODUTO, COMPRAS_PRODUTOS.CODIGO_FORNECEDOR AS COMPRAS_PRODUTOS_CODIGO_FORNECE, COMPRAS_PRODUTOS.QUANTIDADE AS COMPRAS_PRODUTOS_QUANTIDADE, COMPRAS_PRODUTOS.VALOR_CUSTO AS COMPRAS_PRODUTOS_VALOR_CUSTO, COMPRAS_PRODUTOS.DATA AS COMPRAS_PRODUTOS_DATA, PRODUTOS.CODIGO AS PRODUTOS_CODIGO, PRODUTOS.NOME AS PRODUTOS_NOME, FORNECEDORES.NOME AS FORNECEDORES_NOME, PRODUTOS.ESTOQUE AS PRODUTOS_ESTOQUE, PRODUTOS.UNIDADE_MEDIDA AS PRODUTOS_UNIDADE_MEDIDA, PRODUTOS.CODIGO_BARRAS AS PRODUTOS_CODIGO_BARRAS FROM PRODUTOS PRODUTOS INNER JOIN COMPRAS_PRODUTOS COMPRAS_PRODUTOS ON PRODUTOS.CODIGO = COMPRAS_PRODUTOS.CODIGO_PRODUTO INNER JOIN FORNECEDORES FORNECEDORES ON COMPRAS_PRODUTOS.CODIGO_FORNECEDOR = FORNECEDORES.CODIGO WHERE COMPRAS_PRODUTOS.CODIGO = '" + pCodigo + "'" + ";");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioAberturaFechamentoCaixaPDVDAO(int pCodigoCaixa) {
        String pCaminho = "ArquivosJasper/relatorioAberturaFechamentoCaixa.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT      ABERTURA_CAIXA_PDV.CODIGO AS ABERTURA_CAIXA_PDV_CODIGO,      ABERTURA_CAIXA_PDV.CODIGO_USUARIO AS ABERTURA_CAIXA_PDV_CODIGO_USUAR,      ABERTURA_CAIXA_PDV.VALOR_ABERTURA AS ABERTURA_CAIXA_PDV_VALOR_ABERTU,      ABERTURA_CAIXA_PDV.VALOR_FECHAMENTO AS ABERTURA_CAIXA_PDV_VALOR_FECHAM,      ABERTURA_CAIXA_PDV.DATA AS ABERTURA_CAIXA_PDV_DATA,      ABERTURA_CAIXA_PDV.STATUS AS ABERTURA_CAIXA_PDV_STATUS,      TBL_USUARIOS.PK_CODIGO AS TBL_USUARIOS_PK_CODIGO,      TBL_USUARIOS.NOME AS TBL_USUARIOS_NOME,      TBL_USUARIOS.LOGIN AS TBL_USUARIOS_LOGIN FROM      TBL_USUARIOS TBL_USUARIOS INNER JOIN ABERTURA_CAIXA_PDV ABERTURA_CAIXA_PDV ON TBL_USUARIOS.PK_CODIGO = ABERTURA_CAIXA_PDV.CODIGO_USUARIO  WHERE ABERTURA_CAIXA_PDV.CODIGO = '" + pCodigoCaixa + "'" + ";");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(this.getResultSet());
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport((InputStream)caminhoRelatorio, new HashMap(), (JRDataSource)jrRS);
            JasperExportManager.exportReportToPdfFile((JasperPrint)jasperPrint, (String)this.NOME_DO_RELATORIO);
            File file = new File(this.NOME_DO_RELATORIO);
            try {
                Desktop.getDesktop().open(file);
            }
            catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", 0);
            return false;
        }
        return true;
    }
}

