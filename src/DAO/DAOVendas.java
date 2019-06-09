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
import model.ModelVendas;

public class DAOVendas
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO vendas (clientes_codigo,data_venda,valor_total,desconto, tipo_pagamento, tipo, observacao ) VALUES ('" + pModelVendas.getClientesCodigo() + "'," + "'" + pModelVendas.getDataVenda() + "'," + "'" + pModelVendas.getValorTotal() + "'," + "'" + pModelVendas.getDesconto() + "'," + "'" + pModelVendas.getTipoPagamento() + "'," + "'" + pModelVendas.getTipo() + "'," + "'" + pModelVendas.getObservacao() + "'" + ") RETURNING codigo;");
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
    public boolean salvarProdutosVendasDAO(ModelVendas pModelVendas) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelVendas.getListamModelVendases().size();
            for (i = 0; i < sizeLista; ++i) {
                this.insertSQL("insert into VENDAS_PRODUTO( CODIGO_PRODUTO,CODIGO_VENDA,QUANTIDADE, VALOR_UNITARIO)  VALUES ('" + pModelVendas.getListamModelVendases().get(i).getProdutosCodigo() + "'," + "'" + pModelVendas.getCodigo() + "'," + "'" + pModelVendas.getListamModelVendases().get(i).getQuantidade() + "'," + "'" + pModelVendas.getListamModelVendases().get(i).getValor() + "'" + ") RETURNING codigo;");
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
    public ModelVendas getVendasDAO(int pCodigo) {
        ModelVendas modelVendas;
        modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas> getListaPedidosDAO() {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE tipo = 1;");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas> getListaOrcamentoDAO() {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento, tipo, observacao  FROM vendas WHERE tipo = 0;");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas> getListaVendasDAO(int pCodigo) {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo_produto,codigo_venda,quantidade, valor_unitario  FROM  vendas_produto WHERE codigo_venda = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getFloat(3));
                modelVendas.setValor(this.getResultSet().getDouble(4));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas> getListaPedidosDAO(ModelVendas pModelVendas) {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        String dataInicial = "";
        String dataFInal = "";
        try {
            dataInicial = pModelVendas.getDataVenda() + "";
            dataFInal = pModelVendas.getDataVenda1() + "";
        }
        catch (Exception ex) {
            Logger.getLogger(DAOClienteContaParcelaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento,tipo,observacao  FROM vendas WHERE data_venda >= '" + dataInicial + "' and data_venda <='" + dataFInal + "' AND tipo = 1" + ";");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendas> getListaOrcamentoDAO(ModelVendas pModelVendas) {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,valor_total,clientes_codigo,data_venda,desconto, tipo_pagamento,tipo,observacao  FROM vendas WHERE data_venda = '" + pModelVendas.getDataVenda() + "' AND tipo = 0" + ";");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(Float.valueOf(this.getResultSet().getFloat(2)));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(Float.valueOf(this.getResultSet().getFloat(5)));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE vendas SET codigo = '" + pModelVendas.getCodigo() + "'," + "valor_total = '" + pModelVendas.getValorTotal() + "'," + "clientes_codigo = '" + pModelVendas.getClientesCodigo() + "'," + "data_venda = '" + pModelVendas.getDataVenda() + "'," + "desconto = '" + pModelVendas.getDesconto() + "'," + "tipo_pagamento = '" + pModelVendas.getTipoPagamento() + "'," + "tipo = '" + pModelVendas.getTipo() + "'," + "observacao = '" + pModelVendas.getObservacao() + "'" + " WHERE " + "codigo = '" + pModelVendas.getCodigo() + "'" + ";");
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
    public ArrayList<ModelVendas> getListaVendasProdutosDAO(int pCodigo) {
        ArrayList<ModelVendas> listamodelVendas;
        listamodelVendas = new ArrayList<ModelVendas>();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo_produto,codigo_venda,quantidade  FROM  vendas_produto WHERE codigo_venda = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getFloat(3));
                listamodelVendas.add(modelVendas);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }
}

