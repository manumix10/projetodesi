/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOPermissaousuario;
import java.util.ArrayList;
import model.ModelPermissaousuario;

public class ControllerPermissaousuario {
    private DAOPermissaousuario daoPermissaousuario = new DAOPermissaousuario();

    public int salvarPermissaousuarioController(ModelPermissaousuario pModelPermissaousuario) {
        return this.daoPermissaousuario.salvarPermissaousuarioDAO(pModelPermissaousuario);
    }

    public ModelPermissaousuario getPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.getPermissaousuarioDAO(pCodigo);
    }

    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioController() {
        return this.daoPermissaousuario.getListaPermissaousuarioDAO();
    }

    public boolean atualizarPermissaousuarioController(ModelPermissaousuario pModelPermissaousuario) {
        return this.daoPermissaousuario.atualizarPermissaousuarioDAO(pModelPermissaousuario);
    }

    public boolean excluirPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.excluirPermissaousuarioDAO(pCodigo);
    }

    public ArrayList<ModelPermissaousuario> getListaPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.getListaPermissaousuarioDAO(pCodigo);
    }
}

