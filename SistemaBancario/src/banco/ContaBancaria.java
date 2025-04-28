package banco;

public class ContaBancaria {
	
		String titular;
		int numeroConta;
		double saldo;
		
		// Construtor
		  public ContaBancaria(String titular, int numeroConta) {
			this.titular = titular;
			this.numeroConta = numeroConta;
			this.saldo = 0.0;
		}
		  
		  // Métodos
		  
		  public void depositar(double valor) {
			  if(valor > 0 ) {
				  saldo += valor;
				  System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
			  }
		  }
		  
		    public void sacar(double valor) {
		        if (valor > 0 && valor <= saldo) {
		            saldo -= valor;
		            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
		        } else {
		            System.out.println("Saldo insuficiente ou valor inválido.");
		        }
		    }

		    public void exibirSaldo() {
		        System.out.println("Saldo atual: R$" + saldo);
		    }
		}
		  
		  


