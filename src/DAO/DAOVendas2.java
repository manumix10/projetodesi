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
import model.ModelVendas2;

public class DAOVendas2
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarVendasDAO(ModelVendas2 pModelVendas2) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO vendas (clientes_codigo,data_venda,valor_total,desconto, tipo_pagamento, tipo, observacao ) VALUES ('" + pModelVendas2.getClientesCodigo() + "'," + "'" + pModelVendas2.getDataVenda() + "'," + "'" + pModelVendas2.getValorTotal() + "'," + "'" + pModelVendas2.getDesconto() + "'," + "'" + pModelVendas2.getTipoPagamento() + "'," + "'" + pModelVendas2.getTipo() + "'," + "'" + pModelVendas2.getObservacao() + "'" + ") RETURNING codigo;");
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
    public boolean salvarProdutosVendasDAO(ModelVendas2 pModelVendas2) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelVendas2.getListamModelVendases().size();
            for (i = 0; i < sizeLista; ++i) {
                this.insertSQL("insert into VENDAS_PRODUTO( CODIGO_PRODUTO,CODIGO_VENDA,QUANTIDADE, VALOR_UNITARIO)  VALUES ('" + pModelVendas2.getListamModelVendases().get(i).getProdutosCodigo() + "'," + "'" + pModelVendas2.getCodigo() + "'," + "'" + pModelVendas2.getListamModelVendases().get(i).getQuantidade() + "'," + "'" + pModelVendas2.getListamModelVendases().get(i).getValor() + "'" + ") RETURNING codigo;");
            }
            i = 1;
      //      return (boolean)i;
        }
        catch (Exception e) {
            e.printStackTrace();
            boolean i = false;
            return i;
        }
        finally {
            this.fecharConexao();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelVendas2 getVendasDAO(int pCodigo) {
        ModelVendas2 modelVendas2;
        modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas2.setCodigo(this.getResultSet().getInt(1));
                modelVendas2.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas2.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas2.setDataVenda(this.getResultSet().getDate(4));
                modelVendas2.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas2.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas2.setTipo(this.getResultSet().getInt(7));
                modelVendas2.setObservacao(this.getResultSet().getString(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas2> getListaPedidosDAO() {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE tipo = 1;");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setCodigo(this.getResultSet().getInt(1));
                modelVendas2.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas2.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas2.setDataVenda(this.getResultSet().getDate(4));
                modelVendas2.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas2.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas2.setTipo(this.getResultSet().getInt(7));
                modelVendas2.setObservacao(this.getResultSet().getString(8));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas2> getListaOrcamentoDAO() {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE tipo = 0;");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setCodigo(this.getResultSet().getInt(1));
                modelVendas2.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas2.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas2.setDataVenda(this.getResultSet().getDate(4));
                modelVendas2.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas2.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas2.setTipo(this.getResultSet().getInt(7));
                modelVendas2.setObservacao(this.getResultSet().getString(8));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas2> getListaVendasDAO(int pCodigo) {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo_produto,codigo_venda,quantidade, valor_unitario  FROM  vendas_produto WHERE codigo_venda = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas2.setCodigo(this.getResultSet().getInt(2));
                modelVendas2.setQuantidade(this.getResultSet().getFloat(3));
                modelVendas2.setValor(this.getResultSet().getDouble(4));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas2> getListaPedidosDAO(ModelVendas2 pModelVendas2) {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        String dataInicial = "";
        String dataFInal = "";
        try {
            dataInicial = pModelVendas2.getDataVenda() + "";
            dataFInal = pModelVendas2.getDataVenda1() + "";
        }
        catch (Exception ex) {
            Logger.getLogger(DAOClienteContaParcelaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento,tipo,observacao  FROM vendas WHERE data_venda >= '" + dataInicial + "' and data_venda <='" + dataFInal + "' AND tipo = 1" + ";");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setCodigo(this.getResultSet().getInt(1));
                modelVendas2.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas2.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas2.setDataVenda(this.getResultSet().getDate(4));
                modelVendas2.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas2.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas2.setTipo(this.getResultSet().getInt(7));
                modelVendas2.setObservacao(this.getResultSet().getString(8));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas2> getListaOrcamentoDAO(ModelVendas2 pModelVendas2) {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento,tipo,observacao  FROM vendas WHERE data_venda = '" + pModelVendas2.getDataVenda() + "' AND tipo = 0" + ";");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setCodigo(this.getResultSet().getInt(1));
                modelVendas2.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas2.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas2.setDataVenda(this.getResultSet().getDate(4));
                modelVendas2.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas2.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas2.setTipo(this.getResultSet().getInt(7));
                modelVendas2.setObservacao(this.getResultSet().getString(8));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarVendasDAO(ModelVendas2 pModelVendas2) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE vendas SET codigo = '" + pModelVendas2.getCodigo() + "'," + "valor_total = '" + pModelVendas2.getValorTotal() + "'," + "clientes_codigo = '" + pModelVendas2.getClientesCodigo() + "'," + "data_venda = '" + pModelVendas2.getDataVenda() + "'," + "desconto = '" + pModelVendas2.getDesconto() + "'," + "tipo_pagamento = '" + pModelVendas2.getTipoPagamento() + "'," + "tipo = '" + pModelVendas2.getTipo() + "'," + "observacao = '" + pModelVendas2.getObservacao() + "'" + " WHERE " + "codigo = '" + pModelVendas2.getCodigo() + "'" + ";");
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
    public boolean desaprovarPedidoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE vendas SET tipo = 0  WHERE codigo = '" + pCodigo + "'" + ";");
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
    public boolean excluirVendasDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM vendas  WHERE codigo = '" + pCodigo + "'" + ";");
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
    public boolean excluirProdutoVendasDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM vendas_produto WHERE codigo_venda = '" + pCodigo + "'" + ";");
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
    public ArrayList<ModelVendas2> getListaVendasProdutosDAO(int pCodigo) {
        ArrayList<ModelVendas2> listamodelVendas2;
        listamodelVendas2 = new ArrayList<ModelVendas2>();
        ModelVendas2 modelVendas2 = new ModelVendas2();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo_produto,codigo_venda,quantidade  FROM  vendas_produto WHERE codigo_venda = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas2 = new ModelVendas2();
                modelVendas2.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas2.setCodigo(this.getResultSet().getInt(2));
                modelVendas2.setQuantidade(this.getResultSet().getFloat(3));
                listamodelVendas2.add(modelVendas2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas2;
    }
}

