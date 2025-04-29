package banco;

public class ContaBancaria {
	
		String nomeTitular;
		int numeroConta;
		double saldo;
		private String senha;
		
		// Construtor 
		
		  public ContaBancaria(String nomeTitular, int numeroConta, String senha) {
			this.nomeTitular = nomeTitular;
			this.numeroConta = numeroConta;
			this.senha = senha;
			this.saldo = 0.0;
		}
		  
		    
		    // Getters e Setters 
		    
			public String getSenha() {
				return senha;
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}
			
		    public String getNomeTitular() {
		        return nomeTitular;
		    }
		    
		    public int getNumeroConta() {
		        return numeroConta;
		    }

		    public double getSaldo() {
		        return saldo;
		    }
		    
			  // Métodos
			  
			 public void depositar(double valor) {
				  if(valor > 0 ) {
					  saldo += valor;
					  System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
				  }
			  }
			  
			  public boolean sacar(double valor) {
			        if (valor > 0 && saldo >= valor) {
			            saldo -= valor;
			            return true;
			        } else {
			            return false;
			        }
			    }

			   public void exibirSaldo() {
			        System.out.println("Saldo atual: R$" + saldo);
			    }
			    
		}
		  
		  


