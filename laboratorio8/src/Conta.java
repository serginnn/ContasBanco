import java.util.ArrayList;
import java.util.List;
public class Conta {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private List<Transacao> transacoes;

    public Conta(){
    }
    public Conta(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }


    public void deposito(String data, double valor, String descricao) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao(data, valor, descricao));
        }
    }

    public boolean saque(String data, double valor, String descricao) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao(data, -valor, descricao));
            return true;
        }
        return false;
    }

    public void exibirExtrato() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Nome do Titular: " + nomeTitular);
        for (Transacao transacao : transacoes) {
            System.out.println("Data: " + transacao.getData() + ", Valor: " + transacao.getValor() + ", Descrição: " + transacao.getDescricao());
        }
        System.out.println("Saldo Atual: " + saldo);
    }

}
