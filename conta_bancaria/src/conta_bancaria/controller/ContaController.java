package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	// criar a collection
	
	private ArrayList<Conta> listaContas = new ArrayList <Conta> () ;
	
	// variavel para receber o número da conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		 
		 if (conta.isPresent())
			 conta.get().visualizar();
		 else 
			 System.out.println("A conta número " + numero + " não foi encontrada");
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta numero : " + conta.getNumero() + " foi criada com sucesso.");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		Optional<Conta> buscaconta = buscarNaCollection(conta.getNumero());
		 
		 if (buscaconta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaconta.get()),conta);
				System.out.println(" a conta número " + conta.getNumero() + " foi atualizada com sucesso .");
		 } else 
			 System.out.println("A conta número " + conta.getNumero() + " não foi encontrada");
		 
	}
		
	

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		 
		 if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
				System.out.println(" a conta número " + numero + " foi excluida com sucesso .");
		 } else 
			 System.out.println("A conta número " + numero + " não foi encontrada");
		 
	}

	@Override
	public void sacar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		 
		 if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.println(" O saque na conta " + numero + " foi efetuado com sucesso .");
		 } else 
			 System.out.println("A conta número " + numero + " não foi encontrada");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		 
		 if (conta.isPresent()) {
			conta.get().depositar(valor);
				System.out.println(" O deposito  na conta " + numero + " foi efetuado com sucesso .");
		 } else 
			 System.out.println("A conta número " + numero + " não foi encontrada");
		
	}

	@Override
	public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		 
		 if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println(" A transferencia foi efetuada com sucesso");
			}	
		 } else 
			 System.out.println("A conta número  de origem e/ou Destino  não foi encontrada");
		
	}
	
	// Criar metodos Auxiliares 
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	
	public Optional <Conta> buscarNaCollection(int numero) {
		for (var conta: listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
	}	
	
	
}
