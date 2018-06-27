package up.edu.br.minhasfinancas;

import java.io.Serializable;

public class Conta  implements Serializable{

    private Integer id;
    private Double saldo;
    private Double poupanca;
    private String nomeDespesa;
    private Double despesa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(Double poupanca) {
        this.poupanca = poupanca;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public Double getDespesa() {
        return despesa;
    }

    public void setDespesa(Double despesa) {
        this.despesa = despesa;
    }
}
