/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOVendasProdutos;
import java.util.ArrayList;
import model.ModelVendasProdutos;

public class ControllerVendasProdutos {
    private DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    public int salvarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos) {
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pModelVendasProdutos);
    }

    public ModelVendasProdutos getVendasProdutosController(int pCodigo) {
        return this.daoVendasProdutos.getVendasProdutosDAO(pCodigo);
    }

    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController() {
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }

    public boolean atualizarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos) {
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pModelVendasProdutos);
    }

    public boolean excluirVendasProdutosController(int pCodigo) {
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pCodigo);
    }

    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(int pCodigoVenda) {
        return this.daoVendasProdutos.getListaVendasProdutosDAO(pCodigoVenda);
    }
}

