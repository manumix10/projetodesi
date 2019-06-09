/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.ModelComprasProdutos;

public class DAOComprasProdutos
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean salvarComprasProdutosDAO(ModelComprasProdutos pModelComprasProdutos) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelComprasProdutos.getListaModelComprasProdutoses().size();
            for (i = 0; i < sizeLista; ++i) {
                this.insertSQL("INSERT INTO compras_produtos (codigo,codigo_produto,codigo_fornecedor,quantidade,valor_custo,data) VALUES ('" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getCodigo() + "'," + "'" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getCodigoProduto() + "'," + "'" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getCodigoFornecedor() + "'," + "'" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getQuantidade() + "'," + "'" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getValorCusto() + "'," + "'" + pModelComprasProdutos.getListaModelComprasProdutoses().get(i).getData() + "'" + ") RETURNING codigo;");
            }
            i = 1;
        //    return (boolean)i;
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
    public ModelComprasProdutos getComprasProdutosDAO(int pCodigo) {
        ModelComprasProdutos modelComprasProdutos;
        modelComprasProdutos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_produto,codigo_fornecedor,quantidade,valor_custo,data FROM compras_produtos WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelComprasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelComprasProdutos.setCodigoProduto(this.getResultSet().getInt(2));
                modelComprasProdutos.setCodigoFornecedor(this.getResultSet().getInt(3));
                modelComprasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelComprasProdutos.setValorCusto(this.getResultSet().getDouble(5));
                modelComprasProdutos.setData(this.getResultSet().getDate(6));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelComprasProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelComprasProdutos> getListaComprasProdutosDAO() {
        ArrayList<ModelComprasProdutos> listamodelComprasProdutos;
        listamodelComprasProdutos = new ArrayList<ModelComprasProdutos>();
        ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT distinct codigo,data FROM compras_produtos;");
            while (this.getResultSet().next()) {
                modelComprasProdutos = new ModelComprasProdutos();
                modelComprasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelComprasProdutos.setData(this.getResultSet().getDate(2));
                listamodelComprasProdutos.add(modelComprasProdutos);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelComprasProdutos;
    }

    public int getUltimoCodigoCompraDAO() {
        int codigoUltimo;
        codigoUltimo = 0;
        try {
            this.conectar();
            this.executarSQL("SELECT MAX(codigo) FROM compras_produtos;");
            while (this.getResultSet().next()) {
                codigoUltimo = this.getResultSet().getInt(1);
            }
            int n = codigoUltimo;
            return n;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return codigoUltimo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelComprasProdutos> getListaComprasProdutosDAO(int pCodigo) {
        ArrayList<ModelComprasProdutos> listamodelComprasProdutos;
        listamodelComprasProdutos = new ArrayList<ModelComprasProdutos>();
        ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,codigo_produto,codigo_fornecedor,quantidade,valor_custo,data FROM compras_produtos WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelComprasProdutos = new ModelComprasProdutos();
                modelComprasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelComprasProdutos.setCodigoProduto(this.getResultSet().getInt(2));
                modelComprasProdutos.setCodigoFornecedor(this.getResultSet().getInt(3));
                modelComprasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelComprasProdutos.setValorCusto(this.getResultSet().getDouble(5));
                modelComprasProdutos.setData(this.getResultSet().getDate(6));
                listamodelComprasProdutos.add(modelComprasProdutos);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelComprasProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarComprasProdutosDAO(ModelComprasProdutos pModelComprasProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE compras_produtos SET codigo = '" + pModelComprasProdutos.getCodigo() + "'," + "codigo_produto = '" + pModelComprasProdutos.getCodigoProduto() + "'," + "codigo_fornecedor = '" + pModelComprasProdutos.getCodigoFornecedor() + "'," + "quantidade = '" + pModelComprasProdutos.getQuantidade() + "'," + "valor_custo = '" + pModelComprasProdutos.getValorCusto() + "'," + "data = '" + pModelComprasProdutos.getData() + "'" + " WHERE " + "codigo = '" + pModelComprasProdutos.getCodigo() + "'" + ";");
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
    public boolean excluirComprasProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM compras_produtos  WHERE codigo = '" + pCodigo + "'" + ";");
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

    public int getNovoCodigoComprasDAO() {
        int codigoProduto;
        codigoProduto = 0;
        try {
            this.conectar();
            this.executarSQL("SELECT MAX(codigo) FROM compras_produtos;");
            while (this.getResultSet().next()) {
                codigoProduto = this.getResultSet().getInt(1) + 1;
            }
            int n = codigoProduto;
            return n;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return codigoProduto;
    }

    public boolean removerProdutoEstoqueDAO(ArrayList<ModelComprasProdutos> listaModelComprasProdutoses) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

