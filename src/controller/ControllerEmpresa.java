/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOEmpresa;
import java.util.ArrayList;
import model.ModelEmpresa;

public class ControllerEmpresa {
    private DAOEmpresa daoEmpresa = new DAOEmpresa();

    public int salvarEmpresaController(ModelEmpresa pModelEmpresa) {
        return this.daoEmpresa.salvarEmpresaDAO(pModelEmpresa);
    }

    public ModelEmpresa getEmpresaController(int pCodigo) {
        return this.daoEmpresa.getEmpresaDAO(pCodigo);
    }

    public ArrayList<ModelEmpresa> getListaEmpresaController() {
        return this.daoEmpresa.getListaEmpresaDAO();
    }

    public boolean atualizarEmpresaController(ModelEmpresa pModelEmpresa) {
        return this.daoEmpresa.atualizarEmpresaDAO(pModelEmpresa);
    }

    public boolean excluirEmpresaController(int pCodigo) {
        return this.daoEmpresa.excluirEmpresaDAO(pCodigo);
    }
}

