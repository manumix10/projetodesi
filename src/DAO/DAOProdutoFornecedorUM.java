/*
 * Decompiled with CFR 0_122.
 */
package DAO;

import conexoes.ConexaoFirebird;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelFornecedor;
import model.ModelProdutoFornecedorUM;
import model.ModelProdutos;
import model.ModelUnidadeMedia;

public class DAOProdutoFornecedorUM
extends ConexaoFirebird {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<ModelProdutoFornecedorUM> getProdutoFornecedorUM() {
        ArrayList<ModelProdutoFornecedorUM> listaModelProdutoFornecedorUMs;
        listaModelProdutoFornecedorUMs = new ArrayList<ModelProdutoFornecedorUM>();
        ModelProdutoFornecedorUM modelProdutoFornecedorUM = new ModelProdutoFornecedorUM();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelUnidadeMedia modelUnidadeMedida = new ModelUnidadeMedia();
        ModelFornecedor modelFornecedor = new ModelFornecedor();
        try {
            this.conectar();
            this.executarSQL("SELECT   produtos.codigo,  produtos.nome,  produtos.valor, produtos.valor_custo,   produtos.codigo_barras,   unidade_medida.abreviacao,  \t fornecedores.nome  \t FROM \t  produtos inner join unidade_medida on unidade_medida.codigo = produtos.unidade_medida  \t inner join fornecedores on produtos.fornecedores_codigo = fornecedores.codigo;");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelUnidadeMedida = new ModelUnidadeMedia();
                modelFornecedor = new ModelFornecedor();
                modelProdutoFornecedorUM = new ModelProdutoFornecedorUM();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setNome(this.getResultSet().getString(2));
                modelProdutos.setValor(this.getResultSet().getDouble(3));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(4));
                modelProdutos.setCodigoBarras(this.getResultSet().getString(5));
                modelUnidadeMedida.setAbreviacao(this.getResultSet().getString(6));
                modelFornecedor.setNome(this.getResultSet().getString(7));
                modelProdutoFornecedorUM.setModelProdutos(modelProdutos);
                modelProdutoFornecedorUM.setUnidadeMedia(modelUnidadeMedida);
                modelProdutoFornecedorUM.setModelFornecedor(modelFornecedor);
                listaModelProdutoFornecedorUMs.add(modelProdutoFornecedorUM);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.fecharConexao();
        }
        return listaModelProdutoFornecedorUMs;
    }
}

