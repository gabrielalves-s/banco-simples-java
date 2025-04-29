package banco;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BancoApp {
	
	
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    
    
    public static void main(String[] args) {
    	
    	
        while (true) {
            System.out.println("\n=== Banco Simples ===");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o ENTER

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 3:
                    System.out.println("Saindo... Obrigado por usar nosso banco!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarConta() {
        System.out.println("\n=== Criação de Conta ===");

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // limpar o ENTER

        System.out.print("Crie uma senha para a conta: ");
        String senha = scanner.nextLine();

        ContaBancaria novaConta = new ContaBancaria(nomeTitular, numeroConta, senha);
        contas.add(novaConta);

        System.out.println("Conta criada com sucesso!");
    }

    private static void fazerLogin() {
        System.out.println("\n=== Tela de Login ===");

        System.out.print("Digite o número da conta: ");
        int numeroContaLogin = scanner.nextInt();
        scanner.nextLine(); // limpar o ENTER

        System.out.print("Digite sua senha: ");
        String senhaDigitada = scanner.nextLine();

        ContaBancaria contaEncontrada = encontrarConta(numeroContaLogin);

        if (contaEncontrada != null && contaEncontrada.getSenha().equals(senhaDigitada)) {
            System.out.println("Login bem-sucedido! Bem-vindo(a), " + contaEncontrada.getNomeTitular() + "!");
            menuConta(contaEncontrada);
        } else {
            System.out.println("Número da conta ou senha incorretos.");
        }
    }

    private static ContaBancaria encontrarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    private static void menuConta(ContaBancaria contaLogada) {
        boolean logado = true;
        
        while (logado) {
            System.out.println("\n=== Menu da Conta ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Sacar dinheiro");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sair da conta");
            System.out.print("Escolha uma opção: ");
            
            int opcaoConta = scanner.nextInt();
            scanner.nextLine(); // limpar o ENTER

            switch (opcaoConta) {
                case 1:
                    System.out.println("Saldo atual: R$" + contaLogada.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();

                    boolean sucessoSaque = contaLogada.sacar(valorSaque);
                    if (sucessoSaque) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para saque.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    contaLogada.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 4:
                    logado = false;
                    System.out.println("Logout feito com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
