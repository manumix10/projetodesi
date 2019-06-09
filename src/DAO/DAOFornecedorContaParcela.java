/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.ModelContaPagar;
import model.ModelFornecedor;
import model.ModelFornecedorContaParcela;
import model.ModelParcelaContaPag;

public class DAOFornecedorContaParcela
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarFornecedorContaParcelaDAO(ModelFornecedorContaParcela pModelFornecedorContaParcela) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO tbl_conta_pagar (model_conta_pagar,model_fornecedor,model_parcela_conta) VALUES ('" + pModelFornecedorContaParcela.getModelContaPagar() + "','" + pModelFornecedorContaParcela.getModelFornecedor() + "','" + pModelFornecedorContaParcela.getModelParcelaConta() + "');");
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
    public ArrayList<ModelFornecedorContaParcela> getListaFornecedorContaParcelaDAO(int pStatus) {
        ArrayList<ModelFornecedorContaParcela> listaModelFornecedorContaParcelas;
        listaModelFornecedorContaParcelas = new ArrayList<ModelFornecedorContaParcela>();
        try {
            this.conectar();
            this.executarSQL("select CONTAS_PAGAR.PK_CODIGO     , CONTAS_PAGAR.FK_CODIGO_PESSOA     , CONTAS_PAGAR.DESCRICAO     , CONTAS_PAGAR.DATA     , CONTAS_PAGAR.VENCIMENTO     , CONTAS_PAGAR.FK_TIPO_PAGAMENTO     , CONTAS_PAGAR.OBSERVACAO     , CONTAS_PAGAR.SITUACAO     , CONTAS_PAGAR.VALOR     , CONTAS_PAGAR.PAGAMENTO     , FORNECEDORES.NOME     , FORNECEDORES.ENDERECO     , FORNECEDORES.BAIRRO     , FORNECEDORES.COD_CIDADE     , FORNECEDORES.COD_ESTADO     , FORNECEDORES.CEP     , FORNECEDORES.TELEFONE     , TBL_LISTA_DE_PARC_CONTA_PAG.PK_CODIGO     , TBL_LISTA_DE_PARC_CONTA_PAG.NUMERO_PARCELA     , TBL_LISTA_DE_PARC_CONTA_PAG.DATA_VENCIMENTO     , TBL_LISTA_DE_PARC_CONTA_PAG.STATUS     , TBL_LISTA_DE_PARC_CONTA_PAG.VALOR_PARCIAL     , TBL_LISTA_DE_PARC_CONTA_PAG.JUROS_POR_ATRASO     , TBL_LISTA_DE_PARC_CONTA_PAG.VALOR_PAGAR     , TBL_LISTA_DE_PARC_CONTA_PAG.FK_COD_CONTA     , TBL_LISTA_DE_PARC_CONTA_PAG.FK_COD_TIPO_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_PAG.DATA_PAGAMENTO     , TBL_LISTA_DE_PARC_CONTA_PAG.NUMERO_DOCUMENTO from TBL_CONTAS_PAGAR inner join TBL_FORNECEDOR on TBL_CONTAS_PAGAR.FK_COD_FORNECEDOR = TBL_FORNECEDOR.PK_CODIGO inner join TBL_LISTA_DE_PARC_CONTA_PAG on TBL_CONTAS_PAGAR.PK_CODIGO = TBL_LISTA_DE_PARC_CONTA_PAG.FK_COD_CONTA where TBL_LISTA_DE_PARC_CONTA_PAG.STATUS = '" + pStatus + "' ORDER BY TBL_CONTAS_PAGAR.PK_CODIGO;");
            while (this.getResultSet().next()) {
                ModelContaPagar modelContaPagar = new ModelContaPagar();
                ModelFornecedor modelFornecedor = new ModelFornecedor();
                ModelParcelaContaPag modelParcelaContaPag = new ModelParcelaContaPag();
                ModelFornecedorContaParcela modelFornecedorContaParcela = new ModelFornecedorContaParcela();
               modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(6));
                modelContaPagar.setObservacao(this.getResultSet().getString(7));
                modelContaPagar.setSituacao(this.getResultSet().getInt(8));
                modelContaPagar.setValor(this.getResultSet().getFloat(9));                
                modelFornecedor.setNome(this.getResultSet().getString(10));
                modelFornecedor.setEndereco(this.getResultSet().getString(11));
                modelFornecedor.setBairro(this.getResultSet().getString(12));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(13));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(14));
                modelFornecedor.setCep(this.getResultSet().getString(15));                
                modelFornecedor.setTelefone(this.getResultSet().getString(16));                
                modelParcelaContaPag.setCodigo(this.getResultSet().getInt(17));
                modelParcelaContaPag.setNumeroParcela(this.getResultSet().getInt(18));
                modelParcelaContaPag.setDataVenciamento(this.getResultSet().getDate(19));
                modelParcelaContaPag.setStatus(this.getResultSet().getInt(20));
                modelParcelaContaPag.setValorParcial(this.getResultSet().getFloat(21));
                modelParcelaContaPag.setJurosPorAtraso(this.getResultSet().getFloat(22));
                modelParcelaContaPag.setValorPagar(this.getResultSet().getFloat(23));
                modelParcelaContaPag.setCodConta(this.getResultSet().getInt(24));
                modelParcelaContaPag.setCodTipoPagamento(this.getResultSet().getInt(25));
                modelParcelaContaPag.setDataPagamento(this.getResultSet().getDate(26));
                modelParcelaContaPag.setNumeroDocumento(this.getResultSet().getString(27));
                modelFornecedorContaParcela.setModelContaPagar(modelContaPagar);
                modelFornecedorContaParcela.setModelFornecedor(modelFornecedor);
                modelFornecedorContaParcela.setModelParcelaConta(modelParcelaContaPag);
                listaModelFornecedorContaParcelas.add(modelFornecedorContaParcela);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listaModelFornecedorContaParcelas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarFornecedorContaParcelaDAO(ModelFornecedorContaParcela pModelFornecedorContaParcela) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_conta_pagar SET model_conta_pagar = '" + pModelFornecedorContaParcela.getModelContaPagar() + "',model_fornecedor = '" + pModelFornecedorContaParcela.getModelFornecedor() + "',model_parcela_conta = '" + pModelFornecedorContaParcela.getModelParcelaConta() + "' WHERE model_conta_pagar = '" + pModelFornecedorContaParcela.getModelContaPagar() + "';");
            boolean bl = true;
            return bl;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean excluirFornecedorContaParcelaDAO(ModelContaPagar pModelContaPagar) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM tbl_conta_pagar  WHERE model_conta_pagar = '" + pModelContaPagar + "';");
            boolean bl = true;
            return bl;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl = false;
            return bl;
        }
        finally {
            this.fecharConexao();
        }
    }
}

