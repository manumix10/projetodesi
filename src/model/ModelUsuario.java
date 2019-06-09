/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelUsuario {
    private int codigo;
    private String nome;
    private String login;
    private String senha;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setLogin(String pLogin) {
        this.login = pLogin;
    }

    public String getLogin() {
        return this.login;
    }

    public void setSenha(String pSenha) {
        this.senha = pSenha;
    }

    public String getSenha() {
        return this.senha;
    }

    public String toString() {
        return "ModelUsuario {::codigo = " + this.codigo + "::nome = " + this.nome + "::login = " + this.login + "::senha = " + this.senha + "}";
    }
}

