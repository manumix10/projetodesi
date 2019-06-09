/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelFormaPagamento;

public class DAOFormaPagamento
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento) {
        try {
            this.conectar();
            int situacao = 0;
            situacao = pModelFormaPagamento.isSituacao() ? 1 : 0;
            int n = this.insertSQL("INSERT INTO forma_pagamento (descricao,desconto,quantidade_parcelas,observacao,situacao) VALUES ('" + pModelFormaPagamento.getDescricao() + "'," + "'" + pModelFormaPagamento.getDesconto() + "'," + "'" + pModelFormaPagamento.getQuantidadeParcelas() + "'," + "'" + pModelFormaPagamento.getObservacao() + "'," + "'" + situacao + "'" + ") RETURNING codigo;");
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
    public ModelFormaPagamento getFormaPagamentoDAO(int pCodigo) {
        ModelFormaPagamento modelFormaPagamento;
        modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,descricao,desconto,quantidade_parcelas,observacao,situacao FROM forma_pagamento WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelFormaPagamento getFormaPagamentoDAO(String pDescricao) {
        ModelFormaPagamento modelFormaPagamento;
        modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,descricao,desconto,quantidade_parcelas,observacao,situacao FROM forma_pagamento WHERE descricao = '" + pDescricao + "'" + ";");
            while (this.getResultSet().next()) {
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoDAO() {
        ArrayList<ModelFormaPagamento> listamodelFormaPagamento;
        listamodelFormaPagamento = new ArrayList<ModelFormaPagamento>();
        ModelFormaPagamento modelFormaPagamento = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,descricao,desconto,quantidade_parcelas,observacao,situacao FROM forma_pagamento;");
            while (this.getResultSet().next()) {
                modelFormaPagamento = new ModelFormaPagamento();
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarFormaPagamentoDAO(ModelFormaPagamento pModelFormaPagamento) {
        try {
            this.conectar();
            int situacao = 0;
            situacao = pModelFormaPagamento.isSituacao() ? 1 : 0;
            this.executarUpdateDeleteSQL("UPDATE forma_pagamento SET codigo = '" + pModelFormaPagamento.getCodigo() + "'," + "descricao = '" + pModelFormaPagamento.getDescricao() + "'," + "desconto = '" + pModelFormaPagamento.getDesconto() + "'," + "quantidade_parcelas = '" + pModelFormaPagamento.getQuantidadeParcelas() + "'," + "observacao = '" + pModelFormaPagamento.getObservacao() + "'," + "situacao = '" + situacao + "'" + " WHERE " + "codigo = '" + pModelFormaPagamento.getCodigo() + "'" + ";");
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
    public boolean excluirFormaPagamentoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM forma_pagamento  WHERE codigo = '" + pCodigo + "'" + ";");
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

