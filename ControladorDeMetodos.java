 package br.com.mercadoTeste;

import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class ControladorDeMetodos {
	
	//VARIAVEL DA FINANCIAS ==> BAIXA DE PRODUTOS 
	double precosDaVendas;

   controladorDeProdutos controladorDeProdutos = new controladorDeProdutos();
   Scanner scanner = new Scanner(System.in).useLocale(Locale.US); //SERVE PARA SUBSTITUIR A VIRGULA PELO O PONTO EX 4,50 PRA 4.50
   
   
     //CONTROLADOR PARA PRODUTOS NO ESTOQUE
    public void produtosNoEstoque() {
	   System.out.println("--------------------------------------");
	   System.out.println("|              Produtos               |");
	   System.out.println("--------------------------------------");
	   controladorDeProdutos.produtsTotalEstoque();
	   System.out.println("--------------------------------------");
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
    	         		     System.out.print("Preco Via fornecedor:");
    	         		       double precoViaFornecedor = scanner.nextDouble();
    	         		      System.out.print("Qtd:");
    	         		       int qtd = scanner.nextInt();  
    	         		     System.out.print("Preco a venda 'Un':");
    	         		       double precoAvendaUn = scanner.nextDouble(); 
    	         		     System.out.print("Cod Produto: ");
    	         		       int codProduto = scanner.nextInt();
    	         		         scanner.nextLine();
    	         		       produtos produtoNovo = new produtos(codProduto, nome, qtd, precoViaFornecedor, precoAvendaUn);
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
	
	
	//CONTROLADOR DE FINANCIAS
	public void financias() {
		
		int opcao = 0;
		
		while(opcao != 5) {
			
			System.out.println("--------------------------");
	    	System.out.println("|        Financias       |");
	    	System.out.println("--------------------------");
	    	System.out.println("| (1) baixa em produtos  |");
	    	System.out.println("| (2) vendas de Produtos |");
	    	System.out.println("| (3)  Lucros liquido    |");
	    	System.out.println("| (4) Total de vendas    |");
	    	System.out.println("| (5)     voltar         |");
	    	System.out.println("--------------------------");
			  opcao = scanner.nextInt();
			    scanner.nextLine();
			    	switch (opcao) {
			    		case 1: { 
			    			
			    		    System.out.println("-----------------------------------");	
			    	        System.out.println("|         Baixa de Produtos       |");	
			    	        System.out.println("-----------------------------------");	
			    	        System.out.print("Produto: ");
			    	        String produto = scanner.nextLine().toLowerCase();
			    	        produtos produtoParaBaixa = controladorDeProdutos.VerificaIdOuNome(produto);
			    	          if(produtoParaBaixa != null) {
			    	        	   System.out.print("Quantas unidades gostaria de dar baixa?");
			    	                int  quantidadeBaixa = scanner.nextInt();
			    	                double  valorDeVendas = produtoParaBaixa.removeUnidade(quantidadeBaixa);
			    	                precosDaVendas = valorDeVendas;
			    	                System.out.println("Baixa realizada com sucesso! ");
			    	                System.out.println("-----------------------------------");
			    	                System.out.println();
			    	          }    	    
			    			break;
			    			
			         	}
			    		
			    		case 2: {
			    		      System.out.println("------------------------------------");
			    		      System.out.println("|               Vendas             |");
			    		      System.out.println("------------------------------------");
			    		      System.out.println("Produto / Id:");
			    		        String produtoAprocura = scanner.nextLine();
			    		           produtos existe = controladorDeProdutos.FinanicaIdOuNome(produtoAprocura);	    
			    		              controladorDeProdutos.InvestimentoFeitoXLucroObtidoNoProduto(existe);
			    			        	System.out.println("vendas: " + precosDaVendas + " Reais");	  
			    			  System.out.println("------------------------------------");
			    			         System.out.println();
			    		   break;        
			    		}
			    		
			    		case 3: {
			    			break;
			    		}
			    		
			    		case 4: {
			    			
			    			break;
			    		}
			    		
			    		case 5: {
			    			
			    			break;
			    		}
			    		
			    		default:
			    			throw new IllegalArgumentException("Unexpected value: " + opcao);
			    		
			
		}      
	}
	
	
	
	}
}
