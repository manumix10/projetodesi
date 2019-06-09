/*
 * Decompiled with CFR 0_122.
 */
package controller;

import DAO.DAOUnidadeMedia;
import java.util.ArrayList;
import model.ModelUnidadeMedia;

public class ControllerUnidadeMedia {
    private DAOUnidadeMedia daoUnidadeMedia = new DAOUnidadeMedia();

    public int salvarUnidadeMediaController(ModelUnidadeMedia pModelUnidadeMedia) {
        return this.daoUnidadeMedia.salvarUnidadeMediaDAO(pModelUnidadeMedia);
    }

    public ModelUnidadeMedia getUnidadeMediaController(int pCodigo) {
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pCodigo);
    }

    public ModelUnidadeMedia getUnidadeMediaController(String pNome) {
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pNome);
    }

    public ArrayList<ModelUnidadeMedia> getListaUnidadeMediaController() {
        return this.daoUnidadeMedia.getListaUnidadeMediaDAO();
    }

    public boolean atualizarUnidadeMediaController(ModelUnidadeMedia pModelUnidadeMedia) {
        return this.daoUnidadeMedia.atualizarUnidadeMediaDAO(pModelUnidadeMedia);
    }

    public boolean excluirUnidadeMediaController(int pCodigo) {
        return this.daoUnidadeMedia.excluirUnidadeMediaDAO(pCodigo);
    }
}

