/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCliente;
import model.ModelClienteContaParcelaRec;
import model.ModelContaReceber;
import model.ModelParcelaContaRec;

public class DAOClienteContaParcelaRec
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarClienteContaParcelaDAO(ModelClienteContaParcelaRec pModelClienteContaParcela) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO contas_receber (model_conta_receber,model_cliente,model_parcela_conta_rec) VALUES ('" + pModelClienteContaParcela.getModelContaReceber() + "','" + pModelClienteContaParcela.getModelCliente() + "','" + pModelClienteContaParcela.getModelParcelaContaRec() + "');");
            return n;
        }
        catch (Exception e) {
            e.printStackTrace();
            int n = 0;
            return n;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelClienteContaParcelaRec> getListaClienteContaParcelaDAO(int pStatus) {
        ArrayList<ModelClienteContaParcelaRec> listaModelClienteContaParcelas;
        listaModelClienteContaParcelas = new ArrayList<ModelClienteContaParcelaRec>();
        try {
            this.conectar();
          //  this.executarSQL("select TBL_CONTAS_RECEBER.PK_CODIGO     , TBL_CONTAS_RECEBER.STATUS     , TBL_CONTAS_RECEBER.VALOR_BRUTO     , TBL_CONTAS_RECEBER.VALOR_RECEBER     , TBL_CONTAS_RECEBER.FK_COD_CLIENTE     , TBL_CONTAS_RECEBER.FK_COD_FORMA_PAGAMENTO     , TBL_CONTAS_RECEBER.FK_COD_TIPO_PAGAMENTO     , TBL_CONTAS_RECEBER.OBSERVACAO     , TBL_CONTAS_RECEBER.DESCONTO     , TBL_CONTAS_RECEBER.FK_CRIACAO     , TBL_CONTAS_RECEBER.FK_ALTERACAO     , TBL_CONTAS_RECEBER.JUROS     , TBL_CONTAS_RECEBER.VALOR_ENTRADA     , TBL_CONTAS_RECEBER.FK_CAIXA_CONTA     , TBL_CLIENTE.PK_CODIGO     , TBL_CLIENTE.NOME     , TBL_CLIENTE.ENDERECO     , TBL_CLIENTE.BAIRRO     , TBL_CLIENTE.CIDADE     , TBL_CLIENTE.UF     , TBL_CLIENTE.CEP     , TBL_CLIENTE.CGC     , TBL_CLIENTE.INSCRICAO_ESTADUAL     , TBL_CLIENTE.TELEFONE     , TBL_CLIENTE.FAX     , TBL_CLIENTE.EMAIL     , TBL_CLIENTE.BLOQUEADO     , TBL_CLIENTE.FISICO_JURIDICO     , TBL_CLIENTE.FK_REPRESENTANTE     , TBL_CLIENTE.FK_FORMA_PAGAMENTO     , TBL_CLIENTE.FK_TABELA_PRECO     , TBL_CLIENTE.CELULAR     , TBL_CLIENTE.ANOTACOES     , TBL_CLIENTE.DATA_NASCIMENTO      , TBL_CLIENTE.DATA_CADASTRO      , TBL_LISTA_DE_PARC_CONTA_REC.PK_CODIGO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_PARCELA     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_VENCIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.STATUS     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_PARCIAL     , TBL_LISTA_DE_PARC_CONTA_REC.JUROS_POR_ATRASO     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_RECEBER     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_TIPO_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_DOCUMENTO from TBL_CONTAS_RECEBER inner join TBL_CLIENTE on TBL_CONTAS_RECEBER.FK_COD_CLIENTE = TBL_CLIENTE.PK_CODIGO inner join TBL_LISTA_DE_PARC_CONTA_REC on TBL_CONTAS_RECEBER.PK_CODIGO = TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA where TBL_LISTA_DE_PARC_CONTA_REC.STATUS = '" + pStatus + "' ORDER BY TBL_CONTAS_RECEBER.PK_CODIGO;");
            
            this.executarSQL("select CONTAS_RECEBER.PK_CODIGO     , CONTAS_RECEBER.FK_CODIGO_PESSOA     , CONTAS_RECEBER.DESCRICAO     , CONTAS_RECEBER.DATA     , CONTAS_RECEBER.VENCIMENTO     , CONTAS_RECEBER.FK_TIPO_PAGAMENTO     , CONTAS_RECEBER.OBSERVACAO     , CONTAS_RECEBER.SITUACAO     , CONTAS_RECEBER.VALOR     , CONTAS_RECEBER.PAGAMENTO     , CLIENTES.CODIGO     , CLIENTES.NOME     , CLIENTES.ENDERECO     , CLIENTES.BAIRRO     , CLIENTES.COD_CIDADE     , CLIENTES.COD_ESTADO     , CLIENTES.CEP     , CLIENTES.TELEFONE     , CLIENTES.CPF_CNPJ     , CLIENTES.OBSERVACAO  , TBL_LISTA_DE_PARC_CONTA_REC.PK_CODIGO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_PARCELA     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_VENCIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.STATUS     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_PARCIAL     , TBL_LISTA_DE_PARC_CONTA_REC.JUROS_POR_ATRASO     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_RECEBER     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_TIPO_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_DOCUMENTO from CONTAS_RECEBER inner join CLIENTES on CONTAS_RECEBER.FK_COD_CLIENTES = CLIENTES.PK_CODIGO inner join TBL_LISTA_DE_PARC_CONTA_REC on CONTAS_RECEBER.PK_CODIGO = TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA where TBL_LISTA_DE_PARC_CONTA_REC.STATUS = '" + pStatus + "' ORDER BY CONTAS_RECEBER.PK_CODIGO;");
            while (this.getResultSet().next()) {
                ModelContaReceber modelContaReceber = new ModelContaReceber();
                ModelCliente modelCliente = new ModelCliente();
                ModelParcelaContaRec modelParcelaContaRec = new ModelParcelaContaRec();
                ModelClienteContaParcelaRec modelClienteContaParcela = new ModelClienteContaParcelaRec();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(6));
                modelContaReceber.setObservacao(this.getResultSet().getString(7));
                modelContaReceber.setSituacao(this.getResultSet().getInt(8));
                modelContaReceber.setValor(this.getResultSet().getFloat(9));
                modelContaReceber.setPagamento(this.getResultSet().getDate(10));                
                modelCliente.setCodigo(this.getResultSet().getInt(11));
                modelCliente.setNome(this.getResultSet().getString(12));
                modelCliente.setEndereco(this.getResultSet().getString(13));
                modelCliente.setBairro(this.getResultSet().getString(14));
                modelCliente.setCodCidade(this.getResultSet().getInt(15));
                modelCliente.setCodEstado(this.getResultSet().getInt(16));
                modelCliente.setCep(this.getResultSet().getString(17));
                modelCliente.setTelefone(this.getResultSet().getString(18));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(19));
                modelCliente.setTelefone(this.getResultSet().getString(20));
                modelCliente.setObservacao(this.getResultSet().getString(21));                
                modelParcelaContaRec.setCodigo(this.getResultSet().getInt(22));
                modelParcelaContaRec.setNumeroParcela(this.getResultSet().getInt(23));
                modelParcelaContaRec.setDataVencimento(this.getResultSet().getDate(24));
                modelParcelaContaRec.setStatus(this.getResultSet().getInt(25));
                modelParcelaContaRec.setValorParcial(this.getResultSet().getFloat(26));
                modelParcelaContaRec.setJurosPorAtraso(this.getResultSet().getFloat(27));
                modelParcelaContaRec.setValorReceber(this.getResultSet().getFloat(28));
                modelParcelaContaRec.setCodConta(this.getResultSet().getInt(29));
                modelParcelaContaRec.setCodTipoPagamento(this.getResultSet().getInt(30));
                modelParcelaContaRec.setDataRecebimento(this.getResultSet().getDate(31));
                modelParcelaContaRec.setNumeroDocumento(this.getResultSet().getString(32));
                modelClienteContaParcela.setModelContaReceber(modelContaReceber);
                modelClienteContaParcela.setModelCliente(modelCliente);
                modelClienteContaParcela.setModelParcelaContaRec(modelParcelaContaRec);
                listaModelClienteContaParcelas.add(modelClienteContaParcela);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listaModelClienteContaParcelas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelClienteContaParcelaRec> getListaClienteContaParcelaDAO(ModelParcelaContaRec pModelParcelaContaRec) {
        ArrayList<ModelClienteContaParcelaRec> listaModelClienteContaParcelas;
        listaModelClienteContaParcelas = new ArrayList<ModelClienteContaParcelaRec>();
        String dataInicio = "";
        String dataTermino = "";
        try {
            dataInicio = pModelParcelaContaRec.getDataRecebimento() + "";
            dataTermino = pModelParcelaContaRec.getDataVencimento() + "";
        }
        catch (Exception ex) {
            Logger.getLogger(DAOClienteContaParcelaRec.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
     //       this.executarSQL("select CONTAS_RECEBER.PK_CODIGO     , CONTAS_RECEBER.FK_CODIGO_PESSOA     , CONTAS_RECEBER.DESCRICAO     , CONTAS_RECEBER.DATA     , CONTAS_RECEBER.VENCIMENTO     , CONTAS_RECEBER.FK_TIPO_PAGAMENTO     , CONTAS_RECEBER.OBSERVACAO     , CONTAS_RECEBER.SITUACAO     , CONTAS_RECEBER.VALOR     , CONTAS_RECEBER.PAGAMENTO     , CLIENTES.CODIGO     , CLIENTES.NOME     , CLIENTES.ENDERECO     , CLIENTE.BAIRRO     , CLIENTE.COD_CIDADE     , CLIENTE.COD_ESTADO     , CLIENTE.CEP     , CLIENTES.TELEFONE     , CLIENTES.CPF_CNPJ     , CLIENTES.OBSERVACAO     , TBL_LISTA_DE_PARC_CONTA_REC.PK_CODIGO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_PARCELA     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_VENCIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.STATUS     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_PARCIAL     , TBL_LISTA_DE_PARC_CONTA_REC.JUROS_POR_ATRASO     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_RECEBER     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_TIPO_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_DOCUMENTO from CONTAS_RECEBER inner join CLIENTES on CONTAS_RECEBER.FK_COD_CLIENTES = CLIENTES.PK_CODIGO inner join TBL_LISTA_DE_PARC_CONTA_REC on CONTAS_RECEBER.PK_CODIGO = TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA where TBL_LISTA_DE_PARC_CONTA_REC.STATUS = '" + pStatus + "' ORDER BY CONTAS_RECEBER.PK_CODIGO;");
            this.executarSQL("select CONTAS_RECEBER.PK_CODIGO     , CONTAS_RECEBER.FK_CODIGO_PESSOA     , CONTAS_RECEBER.DESCRICAO     , CONTAS_RECEBER.DATA     , CONTAS_RECEBER.VENCIMENTO     , CONTAS_RECEBER.FK_TIPO_PAGAMENTO     , CONTAS_RECEBER.OBSERVACAO     , CONTAS_RECEBER.SITUACAO     , CONTAS_RECEBER.VALOR     , CONTAS_RECEBER.PAGAMENTO     , CLIENTES.CODIGO     , CLIENTES.NOME     , CLIENTES.ENDERECO     , CLIENTES.BAIRRO     , CLIENTES.COD_CIDADE     , CLIENTES.COD_ESTADO     , CLIENTES.CEP     , CLIENTES.TELEFONE     , CLIENTES.CPF_CNPJ     , CLIENTES.OBSERVACAO     , TBL_LISTA_DE_PARC_CONTA_REC.PK_CODIGO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_PARCELA     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_VENCIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.STATUS     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_PARCIAL     , TBL_LISTA_DE_PARC_CONTA_REC.JUROS_POR_ATRASO     , TBL_LISTA_DE_PARC_CONTA_REC.VALOR_RECEBER     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA     , TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_TIPO_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO     , TBL_LISTA_DE_PARC_CONTA_REC.NUMERO_DOCUMENTO  from CONTAS_RECEBER inner join CLIENTES on CONTAS_RECEBER.FK_CODIGO_PESSOA = CLIENTES.CODIGO inner join TBL_LISTA_DE_PARC_CONTA_REC on CONTAS_RECEBER.PK_CODIGO = TBL_LISTA_DE_PARC_CONTA_REC.FK_COD_CONTA where TBL_LISTA_DE_PARC_CONTA_REC.STATUS = '" + pModelParcelaContaRec.getStatus() + "' and TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO >='" + dataInicio + "'and TBL_LISTA_DE_PARC_CONTA_REC.DATA_RECEBIMENTO <= '" + dataTermino + "';");
            while (this.getResultSet().next()) {
                ModelContaReceber modelContaReceber = new ModelContaReceber();
                ModelCliente modelCliente = new ModelCliente();
                ModelParcelaContaRec modelParcelaContaRec = new ModelParcelaContaRec();
                ModelClienteContaParcelaRec modelClienteContaParcela = new ModelClienteContaParcelaRec();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(6));
                modelContaReceber.setObservacao(this.getResultSet().getString(7));
                modelContaReceber.setSituacao(this.getResultSet().getInt(8));
                modelContaReceber.setValor(this.getResultSet().getFloat(9));
                modelContaReceber.setPagamento(this.getResultSet().getDate(10));                
                modelCliente.setCodigo(this.getResultSet().getInt(11));
                modelCliente.setNome(this.getResultSet().getString(12));
                modelCliente.setEndereco(this.getResultSet().getString(13));
                modelCliente.setBairro(this.getResultSet().getString(14));
                modelCliente.setCodCidade(this.getResultSet().getInt(15));
                modelCliente.setCodEstado(this.getResultSet().getInt(16));
                modelCliente.setCep(this.getResultSet().getString(17));
                modelCliente.setTelefone(this.getResultSet().getString(18));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(19));
                modelCliente.setTelefone(this.getResultSet().getString(20));
                modelCliente.setObservacao(this.getResultSet().getString(21));                
                modelParcelaContaRec.setCodigo(this.getResultSet().getInt(22));
                modelParcelaContaRec.setNumeroParcela(this.getResultSet().getInt(23));
                modelParcelaContaRec.setDataVencimento(this.getResultSet().getDate(24));
                modelParcelaContaRec.setStatus(this.getResultSet().getInt(25));
                modelParcelaContaRec.setValorParcial(this.getResultSet().getFloat(26));
                modelParcelaContaRec.setJurosPorAtraso(this.getResultSet().getFloat(27));
                modelParcelaContaRec.setValorReceber(this.getResultSet().getFloat(28));
                modelParcelaContaRec.setCodConta(this.getResultSet().getInt(29));
                modelParcelaContaRec.setCodTipoPagamento(this.getResultSet().getInt(30));
                modelParcelaContaRec.setDataRecebimento(this.getResultSet().getDate(31));
                modelParcelaContaRec.setNumeroDocumento(this.getResultSet().getString(32));
                modelClienteContaParcela.setModelContaReceber(modelContaReceber);
                modelClienteContaParcela.setModelCliente(modelCliente);
                modelClienteContaParcela.setModelParcelaContaRec(modelParcelaContaRec);
                listaModelClienteContaParcelas.add(modelClienteContaParcela);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listaModelClienteContaParcelas;
    }
}

