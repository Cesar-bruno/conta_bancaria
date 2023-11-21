package conta_bancaria;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

import java.util.Scanner;

public class Menu {
	static Scanner leia = new Scanner(System.in); 
	public static void main(String[] args) {
		int opcao;
		 /*criar objetos da classe conta para teste*/
		
		/*Conta c1= new Conta(1 , 123 , 1 ,"Bruno", 1500.0f);
		c1.visualizar();
		System.out.println("exibit o saldo " + c1.getSaldo());
		c1.setSaldo(2500.00f);
		System.out.println("exibit o saldo " + c1.getSaldo());
		
		c1.sacar(500.00f);
		System.out.println("exibit o saldo " + c1.getSaldo());
		c1.depositar(5000.00f);
		System.out.println("exibit o saldo " + c1.getSaldo());*/
		
		/*ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Bruno", 1000, 2000.00f);
		cc1.visualizar();
		cc1.sacar(2500.00f);
		cc1.visualizar();*/
		
		ContaPoupanca cc2 = new ContaPoupanca ( 4, 555,2,"bruno", 1000, 10);
		cc2.visualizar();
		

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
			break;
		case 2 :
			System.out.println("Listar todas as contas\n\n");
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
