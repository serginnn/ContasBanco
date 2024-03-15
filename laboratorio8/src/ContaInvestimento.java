public class ContaInvestimento extends Conta {
    private double taxaRetornoAnual;

    public ContaInvestimento(int numeroConta, String nomeTitular, double taxaRetornoAnual) {
        super(numeroConta, nomeTitular);
        this.taxaRetornoAnual = taxaRetornoAnual;
    }

    public double getTaxaRetornoAnual() {
        return taxaRetornoAnual;
    }
}