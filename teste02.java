package br.com.mercadoTeste;

import java.util.Scanner;

public class teste02 {

	public static void main(String[] args) {
	   
	 
	  ControladorDeMetodos controladorDeMetodos = new ControladorDeMetodos();
      Scanner scanner = new Scanner(System.in);
      int opção = 0;
      
      
	  
	  while(opção != 6) {
		  
		  System.out.println("-----------------------------------");
		  System.out.println("|          Mercado Da Vila        |");
		  System.out.println("|---------------------------------|");
		  System.out.println("| (1)         Produtos            |");
		  System.out.println("| (2)     Adiciona produto        |");
		  System.out.println("| (3)       busca produtos        |");
		  System.out.println("| (4)     saida de produtos       |");
		  System.out.println("| (5)         finançias           |");
		  System.out.println("| (6)           sair              |");
		  System.out.println("-----------------------------------");
		   opção = scanner.nextInt();
		      System.out.println();
		   
		   
		   switch (opção) {
		   		case 1 : {
			         controladorDeMetodos.produtosNoEstoque();
			     break;
		   		}
		   		
		   		case 2: {
		   			controladorDeMetodos.AdicionaProdutos();
		   	     break;		
		   		}
		   		case 3: {
		   			controladorDeMetodos.opçõesDeBuscaDeProduto();
		   			break;
		   		}
		   		case 4: {
		   			
		   			break;
		   		}
		   		case 5: {

		   		}
		   		case 6: {
		   			System.out.println("Saindo...");
		   			break;
		   		}
		   		default:
		   			throw new IllegalArgumentException("Unexpected value: " + opção);
		   		}
		   
		   
		   
		   
		
		   
		   
		   
		   
		   
	  }
	  
	  
	     scanner.close();

	}

}
