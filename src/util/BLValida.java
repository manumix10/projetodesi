/*
 * Decompiled with CFR 0_122.
 */
package util;

import model.ModelSessaoUsuario;
import util.Mensagem;

public class BLValida {
    public static void validarUsuarioSistema() {
        if (ModelSessaoUsuario.login == null || ModelSessaoUsuario.login == "") {
            Mensagem.Erro(null, "Erro de ativa\u00e7\u00e3o do software entre em contato com o administrador do sistema!222");
        //    System.exit(0);
        }
    }
}

