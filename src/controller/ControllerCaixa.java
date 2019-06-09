/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOCaixa;
import java.util.ArrayList;
import model.ModelCaixa;

public class ControllerCaixa {
    private DAOCaixa daoCaixa = new DAOCaixa();

    public int salvarCaixaController(ModelCaixa pModelCaixa) {
        return this.daoCaixa.salvarCaixaDAO(pModelCaixa);
    }

    public ModelCaixa getCaixaController(int pCodigo) {
        return this.daoCaixa.getCaixaDAO(pCodigo);
    }

    public ArrayList<ModelCaixa> getListaCaixaController() {
        return this.daoCaixa.getListaCaixaDAO();
    }

    public boolean atualizarCaixaController(ModelCaixa pModelCaixa) {
        return this.daoCaixa.atualizarCaixaDAO(pModelCaixa);
    }

    public boolean excluirCaixaController(int pCodigo) {
        return this.daoCaixa.excluirCaixaDAO(pCodigo);
    }
}

