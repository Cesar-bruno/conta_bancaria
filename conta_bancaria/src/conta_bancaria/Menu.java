package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	static Scanner leia = new Scanner(System.in); 
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
	
		int opcao, numero, agencia, tipo, aniversario,numeroDestino;
		String titular;
		float saldo,limite, valor;
		
		
		//exemplo
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
		
		try {
		opcao =  leia.nextInt();
		
		}catch(InputMismatchException e ){
			System.out.println("Digite valores de inteiros !");
			leia.nextLine();
			opcao = 9;
		}	
		
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
			keyPress();
			break;
		case 2 :
			System.out.println("Listar todas as contas\n\n");
			contas.listarTodas();
			keyPress();
			break;
		case 3 :
			System.out.println("Buscar conta\n\n");
				System.out.println("digite o número da conta : ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				keyPress();
			break;
		case 4 :
			System.out.println("Atualizar dados\n\n");
			
			System.out.println("digite o número da conta : ");
			numero = leia.nextInt();
			
			Optional< Conta> conta =contas.buscarNaCollection(numero);
			
			if(conta.isPresent()) {
				System.out.println("Digite o número da agência.");
				agencia= leia.nextInt();
				
				System.out.println("Digite o nome do titular da conta.");
				leia.skip("\\R");
				titular= leia.nextLine();
				
				
				tipo=conta.get().getTipo();
				
				System.out.println("Digite o saldo da conta.");
				saldo= leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Qual é o limite da conta.");
					limite=leia.nextFloat();
					contas.atualizar(new ContaCorrente(numero , agencia, tipo, titular, saldo, limite));
					}
				case 2 -> {
					System.out.println("Qual é o aniversario da conta.");
					aniversario=leia.nextInt();
					contas.atualizar(new ContaPoupanca(numero , agencia, tipo, titular, saldo, aniversario));
					}
				
				}
			}else {
				System.out.println("A Conta " + numero + " não foi encontrada");
			}
			keyPress();
			break;
		case 5 :
			System.out.println("Apagar a conta\n\n");
			
			System.out.println("digite o número da conta : ");
			numero = leia.nextInt();
			
			contas.deletar(numero);
			keyPress();
			break;
		case 6 :
			System.out.println("Fazer Saque\n\n");
			
			System.out.println("digite o número da conta : ");
			numero = leia.nextInt();
			
			System.out.println("Digite o valor que deseja sacar.");
			valor = leia.nextFloat();
			
			contas.sacar(numero, valor);
				
			keyPress();
			break;
		case 7 :
			System.out.println("Fazer Deposito\n\n");
			
			System.out.println("digite o número da conta : ");
			numero = leia.nextInt();
			
			System.out.println("Digite o valor que deseja depositar.");
			valor = leia.nextFloat();
			
			contas.depositar(numero, valor);
			keyPress();
			break;
		case 8 :
			System.out.println("Fazer transfêrencia\n\n");
			
			System.out.println("digite o número da conta de origem : ");
			numero = leia.nextInt();
			
			System.out.println("digite o número da conta de destino : ");
			numeroDestino = leia.nextInt();
			
			if (numero != numeroDestino) {
			System.out.println("Digite o valor que deseja depositar.");
			valor = leia.nextFloat();
			
			contas.tranferir(numero, numeroDestino, valor);
			}else {
				System.out.println("os números das contas são iguais");
			}
			keyPress();
			
			break;
		default :
			System.out.println(Cores.TEXT_RED_BOLD + "Escolha uma opção valida!!\n\n" + Cores.reset_texto);
			keyPress();
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
	
	public static void keyPress() {
		try {
			System.out.println("\n\npressione a tecla Enter para continuar ...");
			System.in.read();
			
		}catch(IOException e){
			
			System.out.println("você pressionou uma tecla invalida");
			
		}
	}
}
