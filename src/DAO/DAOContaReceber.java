/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelContaReceber;

public class DAOContaReceber
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarContaReceberDAO(ModelContaReceber pModelContaRecber) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO contas_receber (fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor ) VALUES ('" + pModelContaRecber.getCodigoPessoa() + "'," + "'" + pModelContaRecber.getDescricao() + "'," + "'" + pModelContaRecber.getData() + "'," + "'" + pModelContaRecber.getVencimento() + "'," + "'" + pModelContaRecber.getPagamento() + "'," + "'" + pModelContaRecber.getTipoPagamento() + "'," + "'" + pModelContaRecber.getObservacao() + "'," + "'" + pModelContaRecber.isSituacao() + "'," + "'" + pModelContaRecber.getValor() + "'" + ") RETURNING pk_codigo;");
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
    public ModelContaReceber getContaPagarDAO(int pCodigo) {
        ModelContaReceber modelConta;
        modelConta = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor FROM contas_receber WHERE pk_codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO() {
        ArrayList<ModelContaReceber> listamodelConta;
        listamodelConta = new ArrayList<ModelContaReceber>();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor FROM contas_receber;");
            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelConta.add(modelContaReceber);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaReceber> getListaContaPagarDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaPagar;
        listamodelContaPagar = new ArrayList<ModelContaReceber>();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_receber where situacao = '" + pStatus + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaReceber);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaReceber> getListaContaReceberDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber;
        listamodelContaReceber = new ArrayList<ModelContaReceber>();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_receber where situacao = '" + pStatus + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(int pStatus) {
        ArrayList<ModelContaReceber> listamodelContaReceber;
        listamodelContaReceber = new ArrayList<ModelContaReceber>();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_receber where situacao = '" + pStatus + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaReceber> getListaContasDAO(ModelContaReceber pModelConta) {
        ArrayList<ModelContaReceber> listamodelContaPagar;
        listamodelContaPagar = new ArrayList<ModelContaReceber>();
        ModelContaReceber modelContaReceber = new ModelContaReceber();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_receber where situacao = '" + pModelConta.isSituacao() + "' AND pagamento = '" + pModelConta.getPagamento() + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaReceber = new ModelContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaReceber);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE contas_receber SET pk_codigo = '" + pModelContaReceber.getCodigo() + "'," + "fk_codigo_pessoa = '" + pModelContaReceber.getCodigoPessoa() + "'," + "descricao = '" + pModelContaReceber.getDescricao() + "'," + "data = '" + pModelContaReceber.getData() + "'," + "vencimento = '" + pModelContaReceber.getVencimento() + "'," + "pagamento = '" + pModelContaReceber.getPagamento() + "'," + "fk_tipo_pagamento = '" + pModelContaReceber.getTipoPagamento() + "'," + "observacao = '" + pModelContaReceber.getObservacao() + "'," + "situacao = '" + pModelContaReceber.isSituacao() + "'," + "valor = '" + pModelContaReceber.getValor() + "'" + " WHERE " + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'" + ";");
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
    public boolean excluirContaReceberDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM contas_receber  WHERE pk_codigo = '" + pCodigo + "'" + ";");
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
    public boolean receberContaReceberDAO(ModelContaReceber pModelContaReceber) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE contas_receber SET pagamento = '" + pModelContaReceber.getPagamento() + "'," + "situacao = '" + pModelContaReceber.isSituacao() + "'" + " WHERE " + "pk_codigo = '" + pModelContaReceber.getCodigo() + "'" + ";");
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

