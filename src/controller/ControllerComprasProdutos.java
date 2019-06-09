/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOComprasProdutos;
import java.util.ArrayList;
import model.ModelComprasProdutos;
import relatorios.DAORelatorios;

public class ControllerComprasProdutos {
    private DAOComprasProdutos daoComprasProdutos = new DAOComprasProdutos();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public boolean salvarComprasProdutosController(ModelComprasProdutos pModelComprasProdutos) {
        return this.daoComprasProdutos.salvarComprasProdutosDAO(pModelComprasProdutos);
    }

    public ModelComprasProdutos getComprasProdutosController(int pCodigo) {
        return this.daoComprasProdutos.getComprasProdutosDAO(pCodigo);
    }

    public ArrayList<ModelComprasProdutos> getListaComprasProdutosController() {
        return this.daoComprasProdutos.getListaComprasProdutosDAO();
    }

    public ArrayList<ModelComprasProdutos> getListaComprasProdutosController(int pCodigo) {
        return this.daoComprasProdutos.getListaComprasProdutosDAO(pCodigo);
    }

    public boolean atualizarComprasProdutosController(ModelComprasProdutos pModelComprasProdutos) {
        return this.daoComprasProdutos.atualizarComprasProdutosDAO(pModelComprasProdutos);
    }

    public boolean excluirComprasProdutosController(int pCodigo) {
        return this.daoComprasProdutos.excluirComprasProdutosDAO(pCodigo);
    }

    public int getNovoCodigoComprasController() {
        return this.daoComprasProdutos.getNovoCodigoComprasDAO();
    }

    public boolean removerProdutoEstoqueController(ArrayList<ModelComprasProdutos> listaModelComprasProdutoses) {
        return this.daoComprasProdutos.removerProdutoEstoqueDAO(listaModelComprasProdutoses);
    }

    public int getUltimoCodigoCompraController() {
        return this.daoComprasProdutos.getUltimoCodigoCompraDAO();
    }

    public boolean gerarRelatorioCompraEstoque(int pCodigoCliente) {
        return this.dAORelatorios.gerarRelatorioCompraEstoque(pCodigoCliente);
    }
}

