package br.com.mercadoTeste;

import java.util.Locale;
import java.util.Scanner;

public class ControladorDeMetodos {
	

   controladorDeProdutos controladorDeProdutos = new controladorDeProdutos();
   Scanner scanner = new Scanner(System.in).useLocale(Locale.US); //SERVE PARA SUBSTITUIR A VIRGULA PELO O PONTO EX 4,50 PRA 4.50
   
   
     //CONTROLADOR PARA PRODUTOS NO ESTOQUE
    public void produtosNoEstoque() {
	   System.out.println("----------------------------------------------");
	   System.out.println("|                   Produtos                 |");
	   System.out.println("----------------------------------------------");
	   controladorDeProdutos.produtsTotalEstoque();
	   System.out.println("----------------------------------------------");
	   System.out.println();
   }

     //CONTROLADOR PARA ADICIONA PRODUTOS
    public void AdicionaProdutos() {
    	int opção = 0;
    	
    	while(opção != 3 ) {
    		 System.out.println("-------------------------");
    	     System.out.println("|    Adiciona Produtos   |");
    	     System.out.println("|------------------------|"); 
    	     System.out.println("| (1)      Novos         |"); 
    	     System.out.println("| (2)    Existentes      |"); 
    	     System.out.println("| (3)      Voltar        |"); 
    	     System.out.println("-------------------------"); 
    	      opção = scanner.nextInt();
    	         scanner.nextLine();
    	         	switch (opção) {
    	         		case 1: {
    	         			 System.out.println("-------------------------");
    	         		     System.out.println("|     novo Produtos     |");
    	         		     System.out.println("-------------------------");
    	         		     System.out.print("Produto:");
    	         		      String nome = scanner.nextLine().toLowerCase();
    	         		     System.out.print("Preco Un:");
    	         		       double preco = scanner.nextDouble();
    	         		     System.out.print("Qtd:");
    	         		       int qtd = scanner.nextInt();
    	         		     System.out.print("Cod Produto: ");
    	         		       int codProduto = scanner.nextInt();
    	         		         scanner.nextLine();
    	         		       produtos produtoNovo = new produtos(codProduto, nome, qtd, preco);
    	         		       controladorDeProdutos.adicionaProdutoHash(produtoNovo);
    	         		       System.out.println("-------------------------");
    	         		       System.out.println();
    	         		   break;
    	         	     }
    	         		
    	         		case 2: {
    	         			  System.out.println("-----------------------------------");
    	                      System.out.println("|        Produtos existente       |");
    	                      System.out.println("-----------------------------------");
    	                      System.out.println("produto (nome ou id):");
    	                      String produto = scanner.nextLine().toLowerCase();
    	                      produtos existe = controladorDeProdutos.VerificaIdOuNome(produto);

    	                      if (existe != null) {
    	                          System.out.println("Quantas Unidade gostaria de acrescentar?");
    	                          int unidade = scanner.nextInt();
    	                          controladorDeProdutos.AcrescentaUnidade(unidade);
    	                      }

    	                      System.out.println("-----------------------------------");
    	                      System.out.println();
    	                      break;
    	         		}
    	         		
    	         		case 3: {
    	         			
    	         			break;
    	         		}
    	            default:
    	            	throw new IllegalArgumentException("Unexpected value: " + opção);
    	         	}
           	}
    }

    //CONTROLADOR PARA DAR BAIXAS NA SAIDA DE PRODUTOS
    public void ControleDeSaidaDeProduto() {
       System.out.println("-----------------------------------");	
       System.out.println("|         Baixa de Produtos       |");	
       System.out.println("-----------------------------------");	
       System.out.print("produto: ");
        String produto = scanner.nextLine().toLowerCase();
          produtos confimraProdutoDeBaixa = controladorDeProdutos.VerificaIdOuNome(produto);
          if (confimraProdutoDeBaixa != null) {
              System.out.print("Quantas Unidade gostaria de dar baixa?");
              int unidade = scanner.nextInt();
              controladorDeProdutos.RemoveUnidade(unidade);
          }
      System.out.println("-----------------------------------");
      System.out.println();
      
       
       
    }
    
     //CONTROLADOR PARA BUSCA PRODUTOS
	public void opçõesDeBuscaDeProduto() {
     System.out.println("-----------------------------");
     System.out.println("|         Busca produto     |");
     System.out.println("-----------------------------");
	 System.out.println("Produto (Nome ou Id):");
	   String busca = scanner.nextLine().toLowerCase();
	      controladorDeProdutos.buscaProdutosNomeOuID(busca);     
	 System.out.println("-----------------------------");
	 System.out.println();
     }
	
	
	
	
	
	
	
}
