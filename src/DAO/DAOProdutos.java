/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelProdutos;

public class DAOProdutos
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            int n = this.insertSQL("INSERT INTO produtos (fornecedores_codigo,nome,valor,codigo_barras,unidade_medida, valor_custo ) VALUES ('" + pModelProdutos.getFornecedoresCodigo() + "'," + "'" + pModelProdutos.getNome() + "'," + "'" + pModelProdutos.getValor() + "'," + "'" + pModelProdutos.getCodigoBarras() + "'," + "'" + pModelProdutos.getUnidadeMedida() + "'," + "'" + pModelProdutos.getValorCusto() + "'" + ") RETURNING codigo;");
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
    public ModelProdutos getProdutosDAO(int pCodigo) {
        ModelProdutos modelProdutos;
        modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,fornecedores_codigo,nome,valor,codigo_barras,estoque,unidade_medida,valor_custo   FROM produtos WHERE codigo = '" + pCodigo + "'" + ";");
            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getDouble(4));
                modelProdutos.setCodigoBarras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(7));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelProdutos getProdutosDAO(String pNome) {
        ModelProdutos modelProdutos;
        modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,fornecedores_codigo,nome,valor,codigo_barras,estoque, unidade_medida, valor_custo  FROM produtos WHERE nome = '" + pNome + "'" + ";");
            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getDouble(4));
                modelProdutos.setCodigoBarras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(7));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelProdutos> getListaProdutosDAO() {
        ArrayList<ModelProdutos> listamodelProdutos;
        listamodelProdutos = new ArrayList<ModelProdutos>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,fornecedores_codigo,nome,valor,codigo_barras,estoque, unidade_medida, valor_custo  FROM produtos;");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getDouble(4));
                modelProdutos.setCodigoBarras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(7));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(8));
                listamodelProdutos.add(modelProdutos);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE produtos SET codigo = '" + pModelProdutos.getCodigo() + "'," + "fornecedores_codigo = '" + pModelProdutos.getFornecedoresCodigo() + "'," + "nome = '" + pModelProdutos.getNome() + "'," + "valor = '" + pModelProdutos.getValor() + "'," + "codigo_barras = '" + pModelProdutos.getCodigoBarras() + "'," + "unidade_medida = '" + pModelProdutos.getUnidadeMedida() + "'," + "valor_custo = '" + pModelProdutos.getValorCusto() + "'" + " WHERE " + "codigo = '" + pModelProdutos.getCodigo() + "'" + ";");
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
    public boolean excluirProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("DELETE FROM produtos  WHERE codigo = '" + pCodigo + "'" + ";");
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
    public boolean atualizarProdutosQuantidadeDAO(ModelProdutos pModelProdutos) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelProdutos.getListaModelProdutoses().size();
            for (i = 0; i < sizeLista; ++i) {
                this.executarUpdateDeleteSQL("UPDATE produtos SET estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getEstoque() + "'" + " WHERE " + "codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getCodigo() + "'" + ";");
            }
            i = 1;
     //       return (boolean)i;
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
    public boolean atualizarProdutosQuantidadeUmDAO(int pCodigo, float pQuantidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL("UPDATE produtos SET estoque = '" + pQuantidade + "'" + " WHERE " + "codigo = '" + pCodigo + "'" + ";");
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
    public ModelProdutos getProdutosCodigoBarrasDAO(String pCodigoBarras) {
        ModelProdutos modelProdutos;
        modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT codigo,fornecedores_codigo,nome,valor,codigo_barras,estoque, unidade_medida,valor_custo  FROM produtos WHERE codigo_barras = '" + pCodigoBarras + "'" + ";");
            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setValor(this.getResultSet().getDouble(4));
                modelProdutos.setCodigoBarras(this.getResultSet().getString(5));
                modelProdutos.setEstoque(this.getResultSet().getFloat(6));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(7));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(8));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean atualizarEstoqueProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            int i;
            this.conectar();
            int sizeLista = pModelProdutos.getListaModelProdutoses().size();
            for (i = 0; i < sizeLista; ++i) {
                this.executarUpdateDeleteSQL("UPDATE produtos SET estoque = '" + pModelProdutos.getListaModelProdutoses().get(i).getEstoque() + "'," + "fornecedores_codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getFornecedoresCodigo() + "'," + "valor_custo = '" + pModelProdutos.getListaModelProdutoses().get(i).getValorCusto() + "' " + " WHERE " + "codigo = '" + pModelProdutos.getListaModelProdutoses().get(i).getCodigo() + "'" + ";");
            }
            i = 1;
     //       return (boolean)i;
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
}

