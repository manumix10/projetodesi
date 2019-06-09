/*
 * Decompiled with CFR 0_122.
 */
package model;

public class ModelEmpresa {
    private int codigo;
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String bairro;
    private int codCidade;
    private int codEstado;
    private String cep;
    private String telefone;
    private String cnpj;

    public void setCodigo(int pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setRazaoSocial(String pRazaoSocial) {
        this.razaoSocial = pRazaoSocial;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setNomeFantasia(String pNomeFantasia) {
        this.nomeFantasia = pNomeFantasia;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
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

    public void setCodCidade(int pCodCidade) {
        this.codCidade = pCodCidade;
    }

    public int getCodCidade() {
        return this.codCidade;
    }

    public void setCodEstado(int pCodEstado) {
        this.codEstado = pCodEstado;
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
        return "ModelEmpresa {::codigo = " + this.codigo + "::razaoSocial = " + this.razaoSocial + "::nomeFantasia = " + this.nomeFantasia + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::codCidade = " + this.codCidade + "::codEstado = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone + "}";
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

