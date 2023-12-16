package br.com.mercadoTeste;

import java.util.Locale;
import java.util.Scanner;

public class ControladorDeMetodos {
	

   controladorDeProdutos controladorDeProdutos = new controladorDeProdutos();
   Scanner scanner = new Scanner(System.in).useLocale(Locale.US); //SERVE PARA SUBSTITUIR A VIRGULA PELO O PONTO EX 4,50 PRA 4.50
   
   
   
   
     //CONTROLADO PARA ADICIONA PRODUTOS
    public void AdicionaProdutos() {
     System.out.println("-------------------------");
     System.out.println("|    Adiciona Produtos  |");
     System.out.println("-------------------------");
     System.out.print("Produto:");
      String nome = scanner.nextLine().toLowerCase();
     System.out.print("Preco:");
       double preco = scanner.nextDouble();
     System.out.print("Qtd:");
       int qtd = scanner.nextInt();
     System.out.print("Cod Produto: ");
       int codProduto = scanner.nextInt();
         scanner.nextLine();
       produtos produtoNovo = new produtos(codProduto, nome, qtd, preco);
       controladorDeProdutos.adicionaProdutoHash(produtoNovo);
       
       
    }

   
    
     //CONTROLADOR PARA BUSCA PRODUTOS
	public void opçõesDeBuscaDeProduto() {
     System.out.println("-------------------------");
     System.out.println("|      Busca produto    |");
     System.out.println("-------------------------");
	 System.out.println("Produto (Nome ou Id):");
	   String busca = scanner.nextLine().toLowerCase();
	      controladorDeProdutos.buscaProdutosNomeOuID(busca); 
//	      if (produtoEncontrado != null) {
//	          System.out.println("Dados do Produto Encontrado:");
//	          System.out.println("------------------------------");
//	          System.out.println("Nome: " + produtoEncontrado.getProdutos());
//	          System.out.println("Preço: " + produtoEncontrado.getPreco());
//	          System.out.println("Quantidade: " + produtoEncontrado.getQuantidade());
//	          System.out.println("Código do Produto: " + produtoEncontrado.getCodigoProduto());
//	          System.out.println("------------------------------");
//	      } else {
//	          System.out.println("Produto não encontrado.");
//	      }

	    
	    
	 System.out.println("-------------------------");
	 System.out.println();
     }
	
	
}
