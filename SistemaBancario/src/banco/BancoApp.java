package banco;

import java.util.Locale;
import java.util.Scanner;

public class BancoApp {

	public static void main(String[] args) {
		
			Locale.setDefault(Locale.US);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Digite o nome do titular:");
			String titular = scanner.nextLine();
			
			System.out.println("Digite o número da conta:");
			int numeroConta = scanner.nextInt();
			scanner.nextLine(); 
			
			ContaBancaria conta = new ContaBancaria(titular, numeroConta);
			
			int opcao = 0;
			
			do {
				System.out.println("\n=== Menu ===");
	            System.out.println("1 - Depositar");
	            System.out.println("2 - Sacar");
	            System.out.println("3 - Exibir saldo");
	            System.out.println("4 - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();
	            
	            switch (opcao) {
	            case 1:
	            	System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirSaldo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);
			
			
			scanner.close();
	            }

	}


