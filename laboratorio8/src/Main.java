import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar conta");
            System.out.println("2. Fazer depósito");
            System.out.println("3. Fazer saque");
            System.out.println("4. Exibir extrato");
            System.out.println("5. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de conta:");
                    System.out.println("1. Conta Corrente Comum");
                    System.out.println("2. Conta Corrente Premium");
                    System.out.println("3. Conta Poupança");
                    System.out.println("4. Conta de Investimento");
                    int tipoConta = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o número da conta:");
                    int numeroConta = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do titular:");
                    String nomeTitular = sc.nextLine();

                    switch (tipoConta) {
                        case 1:
                            contas.add(new ContaCorrenteComum(numeroConta, nomeTitular));
                            break;
                        case 2:
                            System.out.println("Digite o limite de crédito: ");
                            double limiteCredito = sc.nextDouble();
                            sc.nextLine();
                            contas.add(new ContaCorrentePremium(numeroConta, nomeTitular, limiteCredito));
                            break;
                        case 3:
                            System.out.println("Digite a data de aniversário (formato: dd/mm/yyyy):");
                            String aniversario = sc.nextLine();
                            contas.add(new ContaPoupanca(numeroConta, nomeTitular, aniversario));
                            break;
                        case 4:
                            System.out.println("Digite a taxa de retorno anual:");
                            double taxaRetornoAnual = sc.nextDouble();
                            sc.nextLine();
                            contas.add(new ContaInvestimento(numeroConta, nomeTitular, taxaRetornoAnual));
                            break;
                    }
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    int numeroContaDeposito = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o dia do Deposito: ");
                    String dataDeposito = sc.nextLine();
                    System.out.println("Digite a descrição do depósito:");
                    String descricaoDeposito = sc.nextLine();
                    for (Conta conta : contas) {
                        if (conta.getNumeroConta() == numeroContaDeposito) {
                            conta.deposito(dataDeposito,valorDeposito, descricaoDeposito);
                            System.out.println("Depósito realizado com sucesso!");
                        }
                        else{
                            System.out.println("Não existe esse numero de conta");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o número da conta:");
                    int numeroContaSaque = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite o dia do saque: ");
                    String dataSaque= sc.nextLine();
                    System.out.println("Digite a descrição do saque:");
                    String descricaoSaque = sc.nextLine();
                    for (Conta conta : contas) {
                        if (conta.getNumeroConta() == numeroContaSaque) {
                            boolean saqueRealizado = conta.saque(dataSaque, valorSaque, descricaoSaque);
                            if (saqueRealizado) {
                                System.out.println("Saque realizado com sucesso!");
                            } else {
                                System.out.println("Saque não pôde ser realizado. Saldo insuficiente.");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o número da conta:");
                    int numeroContaExtrato = sc.nextInt();
                    sc.nextLine();
                    for (Conta conta : contas) {
                        if (conta.getNumeroConta() == numeroContaExtrato) {
                            System.out.println("Extrato da conta:");
                            conta.exibirExtrato();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}