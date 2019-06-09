/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOProdutos;
import java.util.ArrayList;
import model.ModelProdutos;
import relatorios.DAORelatorios;

public class ControllerProdutos {
    private DAOProdutos daoProdutos = new DAOProdutos();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    public ModelProdutos getProdutosController(int pCodigo) {
        return this.daoProdutos.getProdutosDAO(pCodigo);
    }

    public ModelProdutos getProdutosController(String pNome) {
        return this.daoProdutos.getProdutosDAO(pNome);
    }

    public ArrayList<ModelProdutos> getListaProdutosController() {
        return this.daoProdutos.getListaProdutosDAO();
    }

    public boolean atualizarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

    public boolean excluirProdutosController(int pCodigo) {
        return this.daoProdutos.excluirProdutosDAO(pCodigo);
    }

    public boolean atualizarProdutosQuantidadeController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutosQuantidadeDAO(pModelProdutos);
    }

    public boolean atualizarProdutosQuantidadeUmController(int pcodigo, float pQuantidade) {
        return this.daoProdutos.atualizarProdutosQuantidadeUmDAO(pcodigo, pQuantidade);
    }

    public boolean gerarRelatorioProdutos() {
        return this.dAORelatorios.gerarRelatorioProdutos();
    }

    public ModelProdutos getProdutosCodigoBarrasController(String pCodigoBarras) {
        return this.daoProdutos.getProdutosCodigoBarrasDAO(pCodigoBarras);
    }

    public boolean atualizarEstoqueProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarEstoqueProdutosDAO(pModelProdutos);
    }
}

