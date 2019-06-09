/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOFornecedorContaParcela;
import java.util.ArrayList;
import model.ModelContaPagar;
import model.ModelFornecedorContaParcela;

public class ControllerFornecedorContaParcela {
    private DAOFornecedorContaParcela daoFornecedorContaParcela = new DAOFornecedorContaParcela();

    public int salvarFornecedorContaParcelaController(ModelFornecedorContaParcela pModelFornecedorContaParcela) {
        return this.daoFornecedorContaParcela.salvarFornecedorContaParcelaDAO(pModelFornecedorContaParcela);
    }

    public ArrayList<ModelFornecedorContaParcela> getListaFornecedorContaParcelaController(int pStatus) {
        return this.daoFornecedorContaParcela.getListaFornecedorContaParcelaDAO(pStatus);
    }

    public boolean atualizarFornecedorContaParcelaController(ModelFornecedorContaParcela pModelFornecedorContaParcela) {
        return this.daoFornecedorContaParcela.atualizarFornecedorContaParcelaDAO(pModelFornecedorContaParcela);
    }

    public boolean excluirFornecedorContaParcelaController(ModelContaPagar pModelContaPagar) {
        return this.daoFornecedorContaParcela.excluirFornecedorContaParcelaDAO(pModelContaPagar);
    }
}

