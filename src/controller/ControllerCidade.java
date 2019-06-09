/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOCidade;
import java.util.ArrayList;
import model.ModelCidade;

public class ControllerCidade {
    private DAOCidade daoCidade = new DAOCidade();

    public int salvarCidadeController(ModelCidade pModelCidade) {
        return this.daoCidade.salvarCidadeDAO(pModelCidade);
    }

    public ModelCidade getCidadeController(int pCodigo) {
        return this.daoCidade.getCidadeDAO(pCodigo);
    }

    public ModelCidade getCidadeController(String pNome) {
        return this.daoCidade.getCidadeDAO(pNome);
    }

    public ArrayList<ModelCidade> getListaCidadeController() {
        return this.daoCidade.getListaCidadeDAO();
    }

    public ArrayList<ModelCidade> getListaCidadePorEstadoController(int pCodigoEstado) {
        return this.daoCidade.getListaCidadePorEstadoDAO(pCodigoEstado);
    }

    public boolean atualizarCidadeController(ModelCidade pModelCidade) {
        return this.daoCidade.atualizarCidadeDAO(pModelCidade);
    }

    public boolean excluirCidadeController(int pCodigo) {
        return this.daoCidade.excluirCidadeDAO(pCodigo);
    }
}

