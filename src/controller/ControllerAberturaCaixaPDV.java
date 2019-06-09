/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOAberturaCaixaPDV;
import java.util.ArrayList;
import model.ModelAberturaCaixaPDV;
import relatorios.DAORelatorios;

public class ControllerAberturaCaixaPDV {
    private DAOAberturaCaixaPDV daoAberturaCaixaPDV = new DAOAberturaCaixaPDV();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    public int salvarAberturaCaixaPDVController(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        return this.daoAberturaCaixaPDV.salvarAberturaCaixaPDVDAO(pModelAberturaCaixaPDV);
    }

    public ModelAberturaCaixaPDV getAberturaCaixaPDVController(int pCodigo) {
        return this.daoAberturaCaixaPDV.getAberturaCaixaPDVDAO(pCodigo);
    }

    public ArrayList<ModelAberturaCaixaPDV> getListaAberturaCaixaPDVController() {
        return this.daoAberturaCaixaPDV.getListaAberturaCaixaPDVDAO();
    }

    public ArrayList<ModelAberturaCaixaPDV> getListaAberturaCaixaNomeUsuPDVController() {
        return this.daoAberturaCaixaPDV.getListaAberturaCaixaNomeUsuPDVDAO();
    }

    public boolean atualizarAberturaCaixaPDVController(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        return this.daoAberturaCaixaPDV.atualizarAberturaCaixaPDVDAO(pModelAberturaCaixaPDV);
    }

    public boolean excluirAberturaCaixaPDVController(int pCodigo) {
        return this.daoAberturaCaixaPDV.excluirAberturaCaixaPDVDAO(pCodigo);
    }

    public ModelAberturaCaixaPDV getDadosCaixaAtualPeloUsuarioController(int pCodigo) {
        return this.daoAberturaCaixaPDV.getDadosCaixaAtualPeloUsuarioDAO(pCodigo);
    }

    public boolean atualizarValorFechamentoCaixaController(ModelAberturaCaixaPDV pModelAberturaCaixaPDV) {
        return this.daoAberturaCaixaPDV.atualizarValorFechamentoCaixaDAO(pModelAberturaCaixaPDV);
    }

    public boolean gerarRelatorioAberturaFechamentoCaixaPDVController(int pCodigoCaixa) {
        return this.dAORelatorios.gerarRelatorioAberturaFechamentoCaixaPDVDAO(pCodigoCaixa);
    }
}

