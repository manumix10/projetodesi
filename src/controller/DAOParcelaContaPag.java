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
import model.ModelParcelaContaPag;
import util.BLData;

public class DAOParcelaContaPag
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarParcelaContaDAO(ModelParcelaContaPag pModelParcelaConta) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO tbl_lista_de_parc_conta_pag (pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento) VALUES ('" + pModelParcelaConta.getCodigo() + "','" + pModelParcelaConta.getNumeroParcela() + "','" + pModelParcelaConta.getDataVenciamento() + "','" + pModelParcelaConta.getStatus() + "','" + pModelParcelaConta.getValorParcial() + "','" + pModelParcelaConta.getJurosPorAtraso() + "','" + pModelParcelaConta.getValorPagar() + "','" + pModelParcelaConta.getCodConta() + "','" + pModelParcelaConta.getCodTipoPagamento() + "','" + pModelParcelaConta.getDataPagamento() + "','" + pModelParcelaConta.getNumeroDocumento() + "');");
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
    public ModelParcelaContaPag getParcelaContaDAO(int pCodigo) {
        ModelParcelaContaPag modelParcelaConta;
        modelParcelaConta = new ModelParcelaContaPag();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento FROM tbl_lista_de_parc_conta_pag WHERE pk_codigo = '" + pCodigo + "';");
            while (this.getResultSet().next()) {
                modelParcelaConta.setCodigo(this.getResultSet().getInt(1));
                modelParcelaConta.setNumeroParcela(this.getResultSet().getInt(2));
                modelParcelaConta.setDataVenciamento(this.getResultSet().getDate(3));
                modelParcelaConta.setStatus(this.getResultSet().getInt(4));
                modelParcelaConta.setValorParcial(this.getResultSet().getFloat(5));
                modelParcelaConta.setJurosPorAtraso(this.getResultSet().getFloat(6));
                modelParcelaConta.setValorPagar(this.getResultSet().getFloat(7));
                modelParcelaConta.setCodConta(this.getResultSet().getInt(8));
                modelParcelaConta.setCodTipoPagamento(this.getResultSet().getInt(9));
                modelParcelaConta.setDataPagamento(this.getResultSet().getDate(10));
                modelParcelaConta.setNumeroDocumento(this.getResultSet().getString(11));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelParcelaConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelParcelaContaPag getParcelaCodigoContaDAO(int pCodigo) {
        ModelParcelaContaPag modelParcelaConta;
        modelParcelaConta = new ModelParcelaContaPag();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento FROM tbl_lista_de_parc_conta_pag WHERE fk_cod_conta = '" + pCodigo + "';");
            while (this.getResultSet().next()) {
                modelParcelaConta.setCodigo(this.getResultSet().getInt(1));
                modelParcelaConta.setNumeroParcela(this.getResultSet().getInt(2));
                modelParcelaConta.setDataVenciamento(this.getResultSet().getDate(3));
                modelParcelaConta.setStatus(this.getResultSet().getInt(4));
                modelParcelaConta.setValorParcial(this.getResultSet().getFloat(5));
                modelParcelaConta.setJurosPorAtraso(this.getResultSet().getFloat(6));
                modelParcelaConta.setValorPagar(this.getResultSet().getFloat(7));
                modelParcelaConta.setCodConta(this.getResultSet().getInt(8));
                modelParcelaConta.setCodTipoPagamento(this.getResultSet().getInt(9));
                modelParcelaConta.setDataPagamento(this.getResultSet().getDate(10));
                modelParcelaConta.setNumeroDocumento(this.getResultSet().getString(11));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelParcelaConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelParcelaContaPag> getListaParcelaCodigoContaDAO(int pCodigo) {
        ArrayList<ModelParcelaContaPag> listamodelParcelaConta;
        listamodelParcelaConta = new ArrayList<ModelParcelaContaPag>();
        ModelParcelaContaPag modelParcelaConta = new ModelParcelaContaPag();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento FROM tbl_lista_de_parc_conta_pag WHERE fk_cod_conta = '" + pCodigo + "';");
            while (this.getResultSet().next()) {
                modelParcelaConta = new ModelParcelaContaPag();
                modelParcelaConta.setCodigo(this.getResultSet().getInt(1));
                modelParcelaConta.setNumeroParcela(this.getResultSet().getInt(2));
                modelParcelaConta.setDataVenciamento(this.getResultSet().getDate(3));
                modelParcelaConta.setStatus(this.getResultSet().getInt(4));
                modelParcelaConta.setValorParcial(this.getResultSet().getFloat(5));
                modelParcelaConta.setJurosPorAtraso(this.getResultSet().getFloat(6));
                modelParcelaConta.setValorPagar(this.getResultSet().getFloat(7));
                modelParcelaConta.setCodConta(this.getResultSet().getInt(8));
                modelParcelaConta.setCodTipoPagamento(this.getResultSet().getInt(9));
                modelParcelaConta.setDataPagamento(this.getResultSet().getDate(10));
                modelParcelaConta.setNumeroDocumento(this.getResultSet().getString(11));
                listamodelParcelaConta.add(modelParcelaConta);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelParcelaConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelParcelaContaPag> getListaParcelaContaDAO() {
        ArrayList<ModelParcelaContaPag> listamodelParcelaConta;
        listamodelParcelaConta = new ArrayList<ModelParcelaContaPag>();
        ModelParcelaContaPag modelParcelaConta = new ModelParcelaContaPag();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento FROM tbl_lista_de_parc_conta_pag;");
            while (this.getResultSet().next()) {
                modelParcelaConta = new ModelParcelaContaPag();
                modelParcelaConta.setCodigo(this.getResultSet().getInt(1));
                modelParcelaConta.setNumeroParcela(this.getResultSet().getInt(2));
                modelParcelaConta.setDataVenciamento(this.getResultSet().getDate(3));
                modelParcelaConta.setStatus(this.getResultSet().getInt(4));
                modelParcelaConta.setValorParcial(this.getResultSet().getFloat(5));
                modelParcelaConta.setJurosPorAtraso(this.getResultSet().getFloat(6));
                modelParcelaConta.setValorPagar(this.getResultSet().getFloat(7));
                modelParcelaConta.setCodConta(this.getResultSet().getInt(8));
                modelParcelaConta.setCodTipoPagamento(this.getResultSet().getInt(9));
                modelParcelaConta.setDataPagamento(this.getResultSet().getDate(10));
                modelParcelaConta.setNumeroDocumento(this.getResultSet().getString(11));
                listamodelParcelaConta.add(modelParcelaConta);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelParcelaConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarParcelaContaDAO(ModelParcelaContaPag pModelParcelaConta) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_lista_de_parc_conta_pag SET pk_codigo = '" + pModelParcelaConta.getCodigo() + "',numero_parcela = '" + pModelParcelaConta.getNumeroParcela() + "',data_vencimento = '" + pModelParcelaConta.getDataVenciamento() + "',status = '" + pModelParcelaConta.getStatus() + "',valor_parcial = '" + pModelParcelaConta.getValorParcial() + "',juros_por_atraso = '" + pModelParcelaConta.getJurosPorAtraso() + "',valor_pagar = '" + pModelParcelaConta.getValorPagar() + "',fk_cod_conta = '" + pModelParcelaConta.getCodConta() + "',fk_cod_tipo_pagamento = '" + pModelParcelaConta.getCodTipoPagamento() + "',data_pagamento = '" + pModelParcelaConta.getDataPagamento() + "',numero_documento = '" + pModelParcelaConta.getNumeroDocumento() + "' WHERE pk_codigo = '" + pModelParcelaConta.getCodigo() + "';");
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
    public boolean excluirParcelaContaDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM tbl_lista_de_parc_conta_pag  WHERE FK_COD_CONTA = '" + pCodigo + "';");
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
    public ArrayList<ModelParcelaContaPag> getListaParcelaContaDAO(ModelParcelaContaPag pModelParcelaConta) {
        ArrayList<ModelParcelaContaPag> listamodelParcelaConta;
        listamodelParcelaConta = new ArrayList<ModelParcelaContaPag>();
        ModelParcelaContaPag modelParcelaConta = new ModelParcelaContaPag();
        try {
            this.conectar();
            this.executarSQL("SELECT pk_codigo,numero_parcela,data_vencimento,status,valor_parcial,juros_por_atraso,valor_pagar,fk_cod_conta,fk_cod_tipo_pagamento,data_pagamento,numero_documento FROM tbl_lista_de_parc_conta_pag where fk_cod_conta = '" + pModelParcelaConta.getCodConta() + "' and status = '" + pModelParcelaConta.getStatus() + "';");
            while (this.getResultSet().next()) {
                modelParcelaConta = new ModelParcelaContaPag();
                modelParcelaConta.setCodigo(this.getResultSet().getInt(1));
                modelParcelaConta.setNumeroParcela(this.getResultSet().getInt(2));
                modelParcelaConta.setDataVenciamento(this.getResultSet().getDate(3));
                modelParcelaConta.setStatus(this.getResultSet().getInt(4));
                modelParcelaConta.setValorParcial(this.getResultSet().getFloat(5));
                modelParcelaConta.setJurosPorAtraso(this.getResultSet().getFloat(6));
                modelParcelaConta.setValorPagar(this.getResultSet().getFloat(7));
                modelParcelaConta.setCodConta(this.getResultSet().getInt(8));
                modelParcelaConta.setCodTipoPagamento(this.getResultSet().getInt(9));
                modelParcelaConta.setDataPagamento(this.getResultSet().getDate(10));
                modelParcelaConta.setNumeroDocumento(this.getResultSet().getString(11));
                listamodelParcelaConta.add(modelParcelaConta);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelParcelaConta;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean pagarParcelaDAO(ModelParcelaContaPag pModelParcelaConta) {
        BLData bl = new BLData();
        Date dataPagamento = new Date();
        try {
            dataPagamento = bl.converterDataParaDateUS(new Date(System.currentTimeMillis()));
        }
        catch (Exception ex) {
            Logger.getLogger(DAOParcelaContaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_lista_de_parc_conta_pag SET status = 1,fk_cod_tipo_pagamento = '" + pModelParcelaConta.getCodTipoPagamento() + "',data_pagamento = '" + dataPagamento + "' WHERE pk_codigo = '" + pModelParcelaConta.getCodigo() + "';");
            boolean ex = true;
            return ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl2 = false;
            return bl2;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean revogarPagamentoParcelaDAO(ModelParcelaContaPag pModelParcelaContaPag) {
        BLData bl = new BLData();
        Date dataPagamento = new Date();
        try {
            dataPagamento = bl.converterDataParaDateUS(new Date(System.currentTimeMillis()));
        }
        catch (Exception ex) {
            Logger.getLogger(DAOParcelaContaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_lista_de_parc_conta_pag SET status = 0,fk_cod_tipo_pagamento = '" + pModelParcelaContaPag.getCodTipoPagamento() + "',data_pagamento = '" + dataPagamento + "' WHERE pk_codigo = '" + pModelParcelaContaPag.getCodigo() + "';");
            boolean ex = true;
            return ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean bl2 = false;
            return bl2;
        }
        finally {
            this.fecharConexao();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean alterarDadosDaParcelaPagarDAO(ModelParcelaContaPag pModelParcelaContaPag) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE tbl_lista_de_parc_conta_pag SET data_vencimento = '" + pModelParcelaContaPag.getDataVenciamento() + "',status = 0,valor_parcial = '" + pModelParcelaContaPag.getValorParcial() + "',juros_por_atraso = '" + pModelParcelaContaPag.getJurosPorAtraso() + "',valor_pagar = '" + pModelParcelaContaPag.getValorPagar() + "',fk_cod_tipo_pagamento = '" + pModelParcelaContaPag.getCodTipoPagamento() + "',data_pagamento = '" + pModelParcelaContaPag.getDataVenciamento() + "' WHERE pk_codigo = '" + pModelParcelaContaPag.getCodigo() + "';");
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

