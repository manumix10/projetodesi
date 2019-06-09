/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelVendasProdutos;

public class DAOVendasProdutos
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO vendas_produto (codigo,codigo_produto,codigo_venda,quantidade, valor_unitario ) VALUES ('" + pModelVendasProdutos.getCodigo() + "'," + "'" + pModelVendasProdutos.getCodigo_produto() + "'," + "'" + pModelVendasProdutos.getCodigo_venda() + "'," + "'" + pModelVendasProdutos.getQuantidade() + "'," + "'" + pModelVendasProdutos.getValorUnitario() + "'" + ");");
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
    public ModelVendasProdutos getVendasProdutosDAO(int pCodigo) {
        ModelVendasProdutos modelVendasProdutos;
        modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_produto,codigo_venda,quantidade, valor_unitario  FROM vendas_produto WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO() {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos;
        listamodelVendasProdutos = new ArrayList<ModelVendasProdutos>();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_produto,codigo_venda,quantidade, valor_unitario  FROM vendas_produto;");
            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE vendas_produto SET codigo = '" + pModelVendasProdutos.getCodigo() + "'," + "codigo_produto = '" + pModelVendasProdutos.getCodigo_produto() + "'," + "codigo_venda = '" + pModelVendasProdutos.getCodigo_venda() + "'," + "quantidade = '" + pModelVendasProdutos.getQuantidade() + "'," + "valor_unitario = '" + pModelVendasProdutos.getValorUnitario() + "'" + " WHERE " + "codigo = '" + pModelVendasProdutos.getCodigo() + "'" + ";");
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
    public boolean excluirVendasProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM vendas_produto  WHERE codigo = '" + pCodigo + "'" + ";");
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
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO(int pCodigoVenda) {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos;
        listamodelVendasProdutos = new ArrayList<ModelVendasProdutos>();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_produto,codigo_venda,quantidade, valor_unitario  FROM vendas_produto WHERE codigo_venda = '" + pCodigoVenda + "'" + ";");
            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getDouble(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }
}

