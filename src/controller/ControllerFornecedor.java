/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOFornecedor;
import java.util.ArrayList;
import model.ModelFornecedor;
import relatorios.DAORelatorios;

public class ControllerFornecedor {
    private DAOFornecedor daoFornecedor = new DAOFornecedor();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarFornecedorController(ModelFornecedor pModelFornecedor) {
        return this.daoFornecedor.salvarFornecedorDAO(pModelFornecedor);
    }

    public ModelFornecedor getFornecedorController(int pCodigo) {
        return this.daoFornecedor.getFornecedorDAO(pCodigo);
    }

    public ModelFornecedor getFornecedorController(String pNome) {
        return this.daoFornecedor.getFornecedorDAO(pNome);
    }

    public ModelFornecedor getFornecedorProdutoController(int pCodigoProduto) {
        return this.daoFornecedor.getFornecedorProdutoDAO(pCodigoProduto);
    }

    public ArrayList<ModelFornecedor> getListaFornecedorController() {
        return this.daoFornecedor.getListaFornecedorDAO();
    }

    public boolean atualizarFornecedorController(ModelFornecedor pModelFornecedor) {
        return this.daoFornecedor.atualizarFornecedorDAO(pModelFornecedor);
    }

    public boolean excluirFornecedorController(int pCodigo) {
        return this.daoFornecedor.excluirFornecedorDAO(pCodigo);
    }

    public boolean gerarRelatorioFornecedor() {
        return this.dAORelatorios.gerarRelatorioFornecedores();
    }
}

