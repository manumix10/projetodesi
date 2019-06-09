/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelTipoPagamento;

public class DAOTipoPagamento
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarTipoPagamentoDAO(ModelTipoPagamento pModelTipoPagamento) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO tbl_tipo_pagamento (pk_codigo,descricao,fk_banco) VALUES ('" + pModelTipoPagamento.getCodigo() + "','" + pModelTipoPagamento.getDescricao() + "','" + pModelTipoPagamento.getBanco() + "');");
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
    public ModelTipoPagamento getTipoPagamentoDAO(int pCodigo) {
        ModelTipoPagamento modelTipoPagamento;
        modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,descricao,fk_banco FROM tbl_tipo_pagamento WHERE pk_codigo = '" + pCodigo + "';");
            while (this.getResultSet().next()) {
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
                modelTipoPagamento.setBanco(this.getResultSet().getInt(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelTipoPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelTipoPagamento getTipoPagamentoDAO(String pNome) {
        ModelTipoPagamento modelTipoPagamento;
        modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,descricao,fk_banco FROM tbl_tipo_pagamento WHERE descricao = '" + pNome + "';");
            while (this.getResultSet().next()) {
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
                modelTipoPagamento.setBanco(this.getResultSet().getInt(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelTipoPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelTipoPagamento> getListaTipoPagamentoDAO() {
        ArrayList<ModelTipoPagamento> listamodelTipoPagamento;
        listamodelTipoPagamento = new ArrayList<ModelTipoPagamento>();
        ModelTipoPagamento modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,descricao,fk_banco FROM tbl_tipo_pagamento;");
            while (this.getResultSet().next()) {
                modelTipoPagamento = new ModelTipoPagamento();
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
                modelTipoPagamento.setBanco(this.getResultSet().getInt(3));
                listamodelTipoPagamento.add(modelTipoPagamento);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelTipoPagamento;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarTipoPagamentoDAO(ModelTipoPagamento pModelTipoPagamento) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_tipo_pagamento SET pk_codigo = '" + pModelTipoPagamento.getCodigo() + "',descricao = '" + pModelTipoPagamento.getDescricao() + "',fk_banco = '" + pModelTipoPagamento.getBanco() + "' WHERE pk_codigo = '" + pModelTipoPagamento.getCodigo() + "';");
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
    public boolean excluirTipoPagamentoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM tbl_tipo_pagamento  WHERE pk_codigo = '" + pCodigo + "';");
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

