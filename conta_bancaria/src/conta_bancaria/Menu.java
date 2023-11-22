package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	static Scanner leia = new Scanner(System.in); 
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
	
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo,limite;
		
		
		// exemplo
		ContaCorrente cc1 =  new ContaCorrente ( contas.gerarNumero() , 123 , 1 , "Bruno" , 1000.00f , 500.00f);
		contas.cadastrar(cc1);

		while(true){
		System.out.println(Cores.texto_azul + Cores.ANSI_BLACK_BACKGROUND + "******************************************");
		System.out.println("                                          ");
		System.out.println("Seja Bem vindo ao Banco dos Devs          ");
		System.out.println("                                          ");
		System.out.println("Por favor Digite uma das seguintes opções ");
		System.out.println("                                          ");
		System.out.println("1 : Cadastrar Conta                       ");
		System.out.println("2 : Listar todos as contas                ");
		System.out.println("3 : Buscar conta por número               ");
		System.out.println("4 : Alterar dados de uma conta            ");
		System.out.println("5 : Excluir Conta                         ");
		System.out.println("6 : Fazer Saque                           ");
		System.out.println("7 : Fazer Deposito                        ");
		System.out.println("8 : Fazer transfêrencia                   ");
		System.out.println("0 : sair                                  ");
		System.out.println("                                          ");
		System.out.println("******************************************");
		System.out.println(Cores.reset_texto);
		
		opcao =  leia.nextInt();
				
		
		if(opcao == 0) {
			System.out.println(Cores.TEXT_WHITE_BOLD + "Banco dos Dev - O melhor lugar para desenvolver seu dinheiro");
			sobre();
			System.exit(0);
			}
		
		switch(opcao) {
		
		case 1 :
			System.out.println("Criar conta\n\n");
			
			System.out.println("Digite o número da agência.");
			agencia= leia.nextInt();
			
			System.out.println("Digite o nome do titular da conta.");
			leia.skip("\\R");
			titular= leia.nextLine();
			
			
			System.out.println("Digite o tipo da conta. 1 : Conta Corrente  ou 2 : Conta poupança");
			tipo= leia.nextInt();
			
			System.out.println("Digite o saldo da conta.");
			saldo= leia.nextFloat();
			
			switch(tipo) {
			case 1 -> {
				System.out.println("Qual é o limite da conta.");
				limite=leia.nextFloat();
				contas.cadastrar(new ContaCorrente(contas.gerarNumero() , agencia, tipo, titular, saldo, limite));
				}
			case 2 -> {
				System.out.println("Qual é o aniversario da conta.");
				aniversario=leia.nextInt();
				contas.cadastrar(new ContaPoupanca(contas.gerarNumero() , agencia, tipo, titular, saldo, aniversario));
				}
			}
			break;
		case 2 :
			System.out.println("Listar todas as contas\n\n");
			contas.listarTodas();
			break;
		case 3 :
			System.out.println("Buscar conta\n\n");
			break;
		case 4 :
			System.out.println("Atualizar dados\n\n");
			break;
		case 5 :
			System.out.println("Apagar a conta\n\n");
			break;
		case 6 :
			System.out.println("Fazer Saque\n\n");
			break;
		case 7 :
			System.out.println("Fazer Deposito\n\n");
			break;
		case 8 :
			System.out.println("Excluir a conta\n\n");
			break;
		default :
			System.out.println(Cores.TEXT_RED_BOLD + "Escolha uma opção valida!!\n\n" + Cores.reset_texto);
			break;
			
		}
		
		
		}
		
	}
	
	public static void sobre() {
		System.out.println("\n****************************");
		System.out.println("Projeto desenvolvido por : ");
		System.out.println("Bruno Cesar");
		System.out.println("github.com/Coxadmal");
		System.out.println("\n****************************");
	}
}
