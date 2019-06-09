/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelFornecedor {
    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private String cep;
    private String telefone;

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

    public void setEndereco(String pEndereco) {
        this.endereco = pEndereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setBairro(String pBairro) {
        this.bairro = pBairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setCodCidade(int pCidade) {
        this.codCidade = pCidade;
    }

    public int getCodCidade() {
        return this.codCidade;
    }

    public void setCodEstado(int pUf) {
        this.codEstado = pUf;
    }

    public int getCodEstado() {
        return this.codEstado;
    }

    public void setCep(String pCep) {
        this.cep = pCep;
    }

    public String getCep() {
        return this.cep;
    }

    public void setTelefone(String pTelefone) {
        this.telefone = pTelefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String toString() {
        return "ModelFornecedor {::codigo = " + this.codigo + "::nome = " + this.nome + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::cidade = " + this.codCidade + "::uf = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone + "}";
    }
}

