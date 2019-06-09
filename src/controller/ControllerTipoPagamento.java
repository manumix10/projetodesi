/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOTipoPagamento;
import java.util.ArrayList;
import model.ModelTipoPagamento;

public class ControllerTipoPagamento {
    private DAOTipoPagamento daoTipoPagamento = new DAOTipoPagamento();

    public int salvarTipoPagamentoController(ModelTipoPagamento pModelTipoPagamento) {
        return this.daoTipoPagamento.salvarTipoPagamentoDAO(pModelTipoPagamento);
    }

    public ModelTipoPagamento getTipoPagamentoController(int pCodigo) {
        return this.daoTipoPagamento.getTipoPagamentoDAO(pCodigo);
    }

    public ModelTipoPagamento getTipoPagamentoController(String pNome) {
        return this.daoTipoPagamento.getTipoPagamentoDAO(pNome);
    }

    public ArrayList<ModelTipoPagamento> getListaTipoPagamentoController() {
        return this.daoTipoPagamento.getListaTipoPagamentoDAO();
    }

    public boolean atualizarTipoPagamentoController(ModelTipoPagamento pModelTipoPagamento) {
        return this.daoTipoPagamento.atualizarTipoPagamentoDAO(pModelTipoPagamento);
    }

    public boolean excluirTipoPagamentoController(int pCodigo) {
        return this.daoTipoPagamento.excluirTipoPagamentoDAO(pCodigo);
    }
}

