package br.com.mercadoTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class controladorDeProdutos {
	
	   private List<produtos> produtosCadastrados = new ArrayList<>();
	   private HashMap<Integer, produtos> IDProduto = new HashMap<>();

	   

	   //GETTER 
	   public List<produtos> getProdutosCadastrados() {
		 return Collections.unmodifiableList(produtosCadastrados);
	   }

	   

	   

	   
	   //METODOS DE ACRESENTA UNIDAE
	   public void AcrescentaUnidade(int unidade) {
		 for (produtos produtos : produtosCadastrados) {
		    produtos.AddUnidade(unidade);		    
	   	 }
		 System.out.println("Estoque atualizado!");
	   }
	
	   //METODO PRA VER TOTAL DE ESTOQUE
	   public void produtsTotalEstoque() {
		   int contador = 1;
	      if(produtosCadastrados != null && !produtosCadastrados.isEmpty()) {
	    	  for (produtos produtos : produtosCadastrados) { 
				 System.out.println(contador + "º Produto:" + produtos.getProdutos() + "| Qtd: " + produtos.getQuantidade());
				 contador++;
			   }
	      } else {
	    	     System.out.println("Nenhum Produto cadastrado no momemto!");
	      }  		   	
	   }
	   
	   //METODO PARA ADICIONA PRODUTO HASHMAP
	   public void adicionaProdutoHash(produtos produtosID) {
		    this.produtosCadastrados.add(produtosID);
		    this.IDProduto.put(produtosID.getCodigoProduto(), produtosID);
		    System.out.println(produtosID.getProdutos() + " add com sucesso!!");
	   }	 
	   
	   //METODO DE REMOVE UNIDADEs
	   public void RemoveUnidade(int unidade) {
		   for (produtos produtos : produtosCadastrados) {
			   if(produtos.getQuantidade() >= unidade) {
				  produtos.removeUnidade(unidade);
			      System.out.println("Baixa com sucesso!"); 
			   } 
			  produtos.removeUnidade(unidade);
		   }
	   }
	   	   
	   // METODO PARA MOSTRA O TOTAL DE INVESTIMENTO FEITO EM  DETERMINADO PRODUTO ( FINANCIAS )
	   public produtos InvestimentoFeitoXLucroObtidoNoProduto(produtos produto) {
            return produto;
		}
	   
	   //METODO PARA RETORNA TOTAL DE VENDAS
	   public void TotalDeVendas() {
		    boolean semVenda = true;
		    double totalVendas = 0.0;

		    for (produtos produto : produtosCadastrados) {
		        double vendas = produto.getModificadoresProdutos().getTotalVendaDeTodosOsProdutos();
		        if (vendas > 0) {
		            totalVendas += vendas;
		            semVenda = false;
		        }
		    }

		    if (semVenda) {
		        System.out.println("| Sem vendas no momento!        |");
		    } else {
		        System.out.println(" | Total de vendas: " + totalVendas + "       |");
		    }
		}
	 
	   //METODO PARA RETORNA O VALOR LIQUIDO
	   public void LucroDaVendas() {
		    boolean semLucro = true;

		    for (produtos produto : produtosCadastrados) {
		        Double lucro = produto.LucrosLiquidosDasVendas();

		        if (lucro != null && lucro > 0) {
		            System.out.println("| Total de lucro Liquido: " + lucro + "  |");
		            semLucro = false;
		        }
		    }

		    if (semLucro) {
		        System.out.println("| Sem lucro no momento!         |");
		    }
		}
	   
	   
	   
	   //METODOS DE BUSCA ( BUSCA PRODUTOS )
	   
	   //METODO PRA BUSCA O PRODUTO PELO ID
	   public produtos buscaProdutosId (int idNumeroDoProduto) {
	        if(IDProduto.get(idNumeroDoProduto) == null) {
	        	  System.out.println("'" + idNumeroDoProduto + "' Id não encontrado.");
	        } else {
	        	 for (produtos produto : produtosCadastrados) {
	        		     System.out.println();
	 		        	 System.out.println("Dados do Produto Encontrado:");
	 			          System.out.println("Nome: " + produto.getProdutos());
	 			          System.out.println("Preço: " + produto.getPrecoViaFornecedor());
	 			          System.out.println("Quantidade: " + produto.getQuantidade());
	 			          System.out.println("Código do Produto: " + produto.getCodigoProduto());
	 			          System.out.println("------------------------------");
	 		    }	
	        }
	        	return  IDProduto.get(idNumeroDoProduto) ; 	      	
	   }   
	   //METODO PRA BUSCA PELO NOME DO PRODUTO
	   public produtos buscaProdutoPeloNome(String nomeProduto) {
		    for (produtos produto : produtosCadastrados) {
		        if (produto.getProdutos().equalsIgnoreCase(nomeProduto)) {
		        	 System.out.println();
		        	 System.out.println("Dados do Produto Encontrado:");
			          System.out.println("Nome: " + produto.getProdutos());
			          System.out.println("Preço: " + produto.getPrecoViaFornecedor());
			          System.out.println("Quantidade: " + produto.getQuantidade());
			          System.out.println("Código do Produto: " + produto.getCodigoProduto());
		        }
		    }	
		    return null;
		}    
	   // MÉTODO PARA BUSCAR O PRODUTO PELO ID OU NOME
	   public produtos buscaProdutosNomeOuID(String chavePesquisa) {
	       try {
	           int idNumeroDoProduto = Integer.parseInt(chavePesquisa);
	           return buscaProdutosId(idNumeroDoProduto);
	       } catch (NumberFormatException e) {
	           // Se a conversão falhar, tratar como nome e realizar a busca
	           return buscaProdutoPeloNome(chavePesquisa);
	       }
	   } 
	   
	   
	   //METODO VERIFICA SE TEM NA LISTA PARA O ( ADICIONA PRODUTOS --> PRODUTOS EXISTENTES )
	   public produtos VerificaId(int idNumeroDoProduto) {
		    produtos produtoEncontrado = IDProduto.get(idNumeroDoProduto);
		    if (produtoEncontrado == null) {
		        System.out.println("'" + idNumeroDoProduto + "' Id não encontrado.");
		    } else {
		        System.out.println();
		        System.out.println("Produto:");
		        System.out.println("Nome: " + produtoEncontrado.getProdutos());
		        System.out.println("Quantidade: " + produtoEncontrado.getQuantidade());
		    }
		    return produtoEncontrado;
		}
	   public produtos VerificaNome(String nomeProduto) {
		    for (produtos produto : produtosCadastrados) {
		        if (produto.getProdutos().equalsIgnoreCase(nomeProduto)) {
		            System.out.println();
		            System.out.println("Produto:");
		            System.out.println("Nome: " + produto.getProdutos());
		            System.out.println("Quantidade: " + produto.getQuantidade());
		            System.out.println("------------------------------");
		            return produto;
		        }
		    }
		    System.out.println("'" + nomeProduto + "' Produto não encontrado.");
		    return null;
		}     
	   public produtos VerificaIdOuNome(String chavePesquisa) {
		    try {
		        int idNumeroDoProduto = Integer.parseInt(chavePesquisa);
		        return VerificaId(idNumeroDoProduto);
		    } catch (NumberFormatException e) {
		        // Se a conversão falhar, tratar como nome e realizar a busca
		        return VerificaNome(chavePesquisa);
		    }
		
	    }
	    
	    
	   //METODO VERIFICA SE TEM NA LISTA PARA O ( FINANCIAS -> VENDAS DE PRODUTOS )
	   public produtos financiaId(int idNumeroDoProduto) {
		    produtos produtoEncontrado = IDProduto.get(idNumeroDoProduto);
		    if (produtoEncontrado == null) {
		        System.out.println("'" + idNumeroDoProduto + "' Id não encontrado.");
		    }
		    return produtoEncontrado;
		}
	   public produtos FinanciaNome(String nomeProduto) {
		    for (produtos produto : produtosCadastrados) {
		        if (produto.getProdutos().equalsIgnoreCase(nomeProduto)) {
		            return produto;
		        }
		    }
		    System.out.println("'" + nomeProduto + "' Produto não encontrado.");
		    return null;
		}     
	   public produtos FinanicaIdOuNome(String chavePesquisa) {
		    try {
		        int idNumeroDoProduto = Integer.parseInt(chavePesquisa);
		        return financiaId(idNumeroDoProduto);
		    } catch (NumberFormatException e) {
		        // Se a conversão falhar, tratar como nome e realizar a busca
		        return FinanciaNome(chavePesquisa);
		    }
		
	    }
	     
	    
	    
}
