package banco;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BancoApp {

	// Lista para armazenar todas as contas bancárias criadas
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();

	// Scanner para ler entradas do usuário, configurado para aceitar números com ponto
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    
    
    public static void main(String[] args) {
    	
    	// Laço infinito para manter o menu principal rodando
        while (true) {
            System.out.println("------------- Banco Simples -------------");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine(); // limpar o ENTER

            switch (opcao) {
                case 1:
                    criarConta(); // Chama método para criar uma nova conta
                    break;
                case 2:
                    fazerLogin(); // Chama método para fazer login
                    break;
                case 3:
                    System.out.println("Saindo... Obrigado por usar nosso banco!");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
	 // Método que cria uma nova conta bancária
    private static void criarConta() {
        System.out.println("------------- Criação de Conta -------------");

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // limpar o ENTER

        System.out.print("Crie uma senha para a conta: ");
        String senha = scanner.nextLine();

        ContaBancaria novaConta = new ContaBancaria(nomeTitular, numeroConta, senha); // Cria um novo objeto ContaBancaria com os dados fornecidos
        contas.add(novaConta); // Adiciona a nova conta à lista de contas
	    

        System.out.println("Conta criada com sucesso!");
    }
	
	 // Método para realizar o login de um usuário
    private static void fazerLogin() {
        System.out.println("------------- Tela de Login -------------");

        System.out.print("Digite o número da conta: ");
        int numeroContaLogin = scanner.nextInt();
        scanner.nextLine(); // limpar o ENTER

        System.out.print("Digite sua senha: ");
        String senhaDigitada = scanner.nextLine();

        ContaBancaria contaEncontrada = encontrarConta(numeroContaLogin); // Procura a conta correspondente na lista

        if (contaEncontrada != null && contaEncontrada.getSenha().equals(senhaDigitada)) { // Se encontrou a conta e a senha está correta
            System.out.println("Login bem-sucedido! Bem-vindo(a), " + contaEncontrada.getNomeTitular() + "!");
            menuConta(contaEncontrada); // Mostra o menu de operações para a conta logada
        } else {
            System.out.println("Número da conta ou senha incorretos."); // Falha no login
        }
    }

    private static ContaBancaria encontrarConta(int numeroConta) { // Método para buscar uma conta na lista pelo número da conta
        for (ContaBancaria conta : contas) { // Percorre todas as contas
            if (conta.getNumeroConta() == numeroConta) { // Se encontrar o número correspondente
                return conta;
            }
        }
        return null; // Se não encontrar, retorna null
    }

    private static void menuConta(ContaBancaria contaLogada) { // Menu de operações para quem já está logado na conta
        boolean logado = true;
        
        while (logado) { // Mantém o usuário no menu da conta até ele optar por sair
            System.out.println("------------- Menu da Conta -------------");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Sacar dinheiro");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sair da conta");
            System.out.print("Escolha uma opção: ");
            
            int opcaoConta = scanner.nextInt();
            scanner.nextLine(); // limpar o ENTER

            switch (opcaoConta) {
                case 1:
                    System.out.println("Saldo atual: R$" + contaLogada.getSaldo()); // Exibe o saldo da conta
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
