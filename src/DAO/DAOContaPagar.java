/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelContaPagar;

public class DAOContaPagar
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarContaPagarDAO(ModelContaPagar pModelContaPagar) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO contas_pagar (fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor ) VALUES ('" + pModelContaPagar.getCodigoPessoa() + "'," + "'" + pModelContaPagar.getDescricao() + "'," + "'" + pModelContaPagar.getData() + "'," + "'" + pModelContaPagar.getVencimento() + "'," + "'" + pModelContaPagar.getPagamento() + "'," + "'" + pModelContaPagar.getTipoPagamento() + "'," + "'" + pModelContaPagar.getObservacao() + "'," + "'" + pModelContaPagar.isSituacao() + "'," + "'" + pModelContaPagar.getValor() + "'" + ") RETURNING pk_codigo;");
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
    public ModelContaPagar getContaPagarDAO(int pCodigo) {
        ModelContaPagar modelContaPagar;
        modelContaPagar = new ModelContaPagar();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor FROM contas_pagar WHERE pk_codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getFloat(10));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelContaPagar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelContaPagar> getListaContaPagarDAO() {
        ArrayList<ModelContaPagar> listamodelConta;
        listamodelConta = new ArrayList<ModelContaPagar>();
        ModelContaPagar modelContaPagar = new ModelContaPagar();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor FROM contas_pagar;");
            while (this.getResultSet().next()) {
                modelContaPagar = new ModelContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getFloat(10));
                listamodelConta.add(modelContaPagar);
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
    public ArrayList<ModelContaPagar> getListaContaPagarDAO(int pStatus) {
        ArrayList<ModelContaPagar> listamodelContaPagar;
        listamodelContaPagar = new ArrayList<ModelContaPagar>();
        ModelContaPagar modelContaPagar = new ModelContaPagar();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_pagar where situacao = '" + pStatus + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaPagar = new ModelContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaPagar);
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
    public ArrayList<ModelContaPagar> getListaContasDAO(int pStatus) {
        ArrayList<ModelContaPagar> listamodelContaPagar;
        listamodelContaPagar = new ArrayList<ModelContaPagar>();
        ModelContaPagar modelContaPagar = new ModelContaPagar();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_pagar where situacao = '" + pStatus + "'" + ";");
            while (this.getResultSet().next()) {
                modelContaPagar = new ModelContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaPagar);
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
    public ArrayList<ModelContaPagar> getListaContasDAO(ModelContaPagar pModelConta) {
        ArrayList<ModelContaPagar> listamodelContaPagar;
        listamodelContaPagar = new ArrayList<ModelContaPagar>();
        ModelContaPagar modelContaPagar = new ModelContaPagar();
        String dataInicial = "";
        String dataFInal = "";
        try {
            dataInicial = pModelConta.getPagamento() + "";
            dataFInal = pModelConta.getVencimento() + "";
        }
        catch (Exception ex) {
            Logger.getLogger(DAOClienteContaParcelaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,fk_codigo_pessoa,descricao,data,vencimento,pagamento,fk_tipo_pagamento,observacao,situacao,valor  FROM contas_pagar where situacao = '" + pModelConta.isSituacao() + "' AND pagamento >= '" + dataInicial + "' and pagamento <= '" + dataFInal + "';");
            while (this.getResultSet().next()) {
                modelContaPagar = new ModelContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getFloat(10));
                listamodelContaPagar.add(modelContaPagar);
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
    public boolean atualizarContaPagarDAO(ModelContaPagar pModelContaPagar) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE contas_pagar SET pk_codigo = '" + pModelContaPagar.getCodigo() + "'," + "fk_codigo_pessoa = '" + pModelContaPagar.getCodigoPessoa() + "'," + "descricao = '" + pModelContaPagar.getDescricao() + "'," + "data = '" + pModelContaPagar.getData() + "'," + "vencimento = '" + pModelContaPagar.getVencimento() + "'," + "pagamento = '" + pModelContaPagar.getPagamento() + "'," + "fk_tipo_pagamento = '" + pModelContaPagar.getTipoPagamento() + "'," + "observacao = '" + pModelContaPagar.getObservacao() + "'," + "situacao = '" + pModelContaPagar.isSituacao() + "'," + "valor = '" + pModelContaPagar.getValor() + "'" + " WHERE " + "pk_codigo = '" + pModelContaPagar.getCodigo() + "'" + ";");
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
    public boolean excluirContaPagarDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM contas_pagar  WHERE pk_codigo = '" + pCodigo + "'" + ";");
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
    public boolean pagarContaPagarDAO(ModelContaPagar pModelContaPagar) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE contas_pagar SET pagamento = '" + pModelContaPagar.getPagamento() + "'," + "situacao = '" + pModelContaPagar.isSituacao() + "'" + " WHERE " + "pk_codigo = '" + pModelContaPagar.getCodigo() + "'" + ";");
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

