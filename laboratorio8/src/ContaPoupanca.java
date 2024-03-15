public class ContaPoupanca extends Conta {
    private String aniversario;

    public ContaPoupanca(int numeroConta, String nomeTitular, String aniversario) {
        super(numeroConta, nomeTitular);
        this.aniversario = aniversario;
    }

    public String getAniversario() {
        return aniversario;
    }
}
