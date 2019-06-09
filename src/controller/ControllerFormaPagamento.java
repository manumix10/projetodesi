/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOFormaPagamento;
import java.util.ArrayList;
import model.ModelFormaPagamento;

public class ControllerFormaPagamento {
    private DAOFormaPagamento daoFormaPagamento = new DAOFormaPagamento();

    public int salvarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento) {
        return this.daoFormaPagamento.salvarFormaPagamentoDAO(pModelFormaPagamento);
    }

    public ModelFormaPagamento getFormaPagamentoController(int pCodigo) {
        return this.daoFormaPagamento.getFormaPagamentoDAO(pCodigo);
    }

    public ModelFormaPagamento getFormaPagamentoController(String pCodigo) {
        return this.daoFormaPagamento.getFormaPagamentoDAO(pCodigo);
    }

    public ArrayList<ModelFormaPagamento> getListaFormaPagamentoController() {
        return this.daoFormaPagamento.getListaFormaPagamentoDAO();
    }

    public boolean atualizarFormaPagamentoController(ModelFormaPagamento pModelFormaPagamento) {
        return this.daoFormaPagamento.atualizarFormaPagamentoDAO(pModelFormaPagamento);
    }

    public boolean excluirFormaPagamentoController(int pCodigo) {
        return this.daoFormaPagamento.excluirFormaPagamentoDAO(pCodigo);
    }
}

