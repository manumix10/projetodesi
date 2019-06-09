/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOUsuario;
import java.util.ArrayList;
import model.ModelUsuario;

public class ControllerUsuario {
    private DAOUsuario daoUsuario = new DAOUsuario();

    public int salvarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    public ModelUsuario getUsuarioController(int pCodigo) {
        return this.daoUsuario.getUsuarioDAO(pCodigo);
    }

    public ModelUsuario getUsuarioController(String pLogin) {
        return this.daoUsuario.getUsuarioDAO(pLogin);
    }

    public boolean getUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.getUsuarioDAO(pModelUsuario);
    }

    public ArrayList<ModelUsuario> getListaUsuarioController() {
        return this.daoUsuario.getListaUsuarioDAO();
    }

    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    public boolean excluirUsuarioController(int pCodigo) {
        return this.daoUsuario.excluirUsuarioDAO(pCodigo);
    }
}

