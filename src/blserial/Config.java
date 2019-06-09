/*
 * Decompiled with CFR 0_122.
 */
package blserial;

import java.util.Date;

public class Config {
    private String software;
    private String ip;
    private String mac;
    private Date dataGeracao;
    private Date dataAtual;
    private Date dataValidade;
    private String dataGeracaoStr;
    private String dataAtualStr;
    private int diasValidade;
    private String diasValidadeStr;
    private String nomePC;

    public String getSoftware() {
        return this.software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String cnpj) {
        this.mac = cnpj;
    }

    public Date getDataGeracao() {
        return this.dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Date getDataAtual() {
        return this.dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Date getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDataGeracaoStr() {
        return this.dataGeracaoStr;
    }

    public void setDataGeracaoStr(String dataGeracaoStr) {
        this.dataGeracaoStr = dataGeracaoStr;
    }

    public String getDataAtualStr() {
        return this.dataAtualStr;
    }

    public void setDataAtualStr(String dataAtualStr) {
        this.dataAtualStr = dataAtualStr;
    }

    public int getDiasValidade() {
        return this.diasValidade;
    }

    public void setDiasValidade(int diasValidade) {
        this.diasValidade = diasValidade;
    }

    public String getDiasValidadeStr() {
        return this.diasValidadeStr;
    }

    public void setDiasValidadeStr(String diasValidadeStr) {
        this.diasValidadeStr = diasValidadeStr;
    }

    public String toString() {
        return "Config{software=" + this.software + ", ip=" + this.ip + ", cnpj=" + this.mac + ", dataGeracao=" + this.dataGeracao + ", dataAtual=" + this.dataAtual + ", dataValidade=" + this.dataValidade + ", dataGeracaoStr=" + this.dataGeracaoStr + ", dataAtualStr=" + this.dataAtualStr + ", diasValidade=" + this.diasValidade + ", diasValidadeStr=" + this.diasValidadeStr + '}';
    }

    public String getNomePC() {
        return this.nomePC;
    }

    public void setNomePC(String nomePC) {
        this.nomePC = nomePC;
    }
}

