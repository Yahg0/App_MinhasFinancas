package up.edu.br.minhasfinancas;

import java.io.Serializable;

public class Conta implements Serializable{
    // Conceito de serializable: tranforma em uma suposta "string" para poder passar o objeto

    private Integer id;
    private String usuario;
    private String saldo;
    private String poupanca;
    private String tipoDespesa;
    private String despesa;

    @Override
    public boolean equals(Object obj) {

        if (getId() == null || ((Conta)obj).getId() == null ){

            return false;
        }
        return getId().equals(((Conta)obj).getId());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(String poupanca) {
        this.poupanca = poupanca;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }
}
