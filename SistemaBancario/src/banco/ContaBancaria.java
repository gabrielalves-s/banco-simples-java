package banco;

public class ContaBancaria {
		// Atributos privados da conta
		private String nomeTitular;
		private int numeroConta;
		private double saldo;
		private String senha;
		
		// Construtor 
		
		  public ContaBancaria(String nomeTitular, int numeroConta, String senha) {
			this.nomeTitular = nomeTitular; // Atribui o nome do titular
			this.numeroConta = numeroConta; // Atribui o número da conta
			this.senha = senha; // Atribui a senha da conta
			this.saldo = 0.0; // Inicializa o saldo com 0
		}
		  
		    
		    // Métodos Getters - para acessar informações da conta
	
			public String getSenha() {
				return senha; // Retorna a senha da conta
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}
			
		    public String getNomeTitular() {
		        return nomeTitular; // Retorna o nome do titular
		    }
		    
		    public int getNumeroConta() { 
		        return numeroConta; // Retorna o número da conta
		    }

		    public double getSaldo() {
		        return saldo; // Retorna o saldo da conta
		    }
		    
			  // Métodos
	
			  // Método para depositar dinheiro na conta
			 public void depositar(double valor) {
				  if(valor > 0 ) { // Só aceita valores positivos
					  saldo += valor; // Adiciona o valor ao saldo
				  }
			  }
			   // Método para sacar dinheiro da conta
			  public boolean sacar(double valor) { 
			        if (valor > 0 && saldo >= valor) { // Verifica se o valor é positivo e se há saldo suficiente
			            saldo -= valor; // Diminui o saldo
			            return true; // Retorna true se o saque foi bem-sucedido
			        } else {
			            return false; // Retorna false se não foi possível sacar
			        }
			    }

			   public void exibirSaldo() {
			        System.out.println("Saldo atual: R$" + saldo);
			    }
			    
		}
		  
		  


