public class ContaCorrentePremium extends Conta {
    private double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public ContaCorrentePremium(int numeroConta, String nomeTitular, double limiteCredito) {
        super(numeroConta, nomeTitular);
        this.limiteCredito = limiteCredito;
    }

}

