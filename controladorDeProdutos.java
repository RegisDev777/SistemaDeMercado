package br.com.mercadoTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class controladorDeProdutos {
	
	   private List<produtos> produtosCadastrados = new ArrayList<>();
	   private HashMap<Integer, produtos> IDProduto = new HashMap<>();

	   //GETTER 
	   public List<produtos> getProdutosCadastrados() {
		 return Collections.unmodifiableList(produtosCadastrados);
	   }

	   
	   //METODO VERIFICA SE TEM
	   public produtos VerificaId(int idNumeroDoProduto) {
		    produtos produtoEncontrado = IDProduto.get(idNumeroDoProduto);
		    if (produtoEncontrado == null) {
		        System.out.println("'" + idNumeroDoProduto + "' Id não encontrado.");
		    } else {
		        System.out.println();
		        System.out.println("Produto:");
		        System.out.println("Nome: " + produtoEncontrado.getProdutos());
		        System.out.println("Quantidade: " + produtoEncontrado.getQuantidade());
		        System.out.println("------------------------------");
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
	   
	   
	   //METODOS DE ACRESENTA UNIDAE
	   public void AcrescentaUnidade(int unidade) {
		 for (produtos produtos : produtosCadastrados) {
		    produtos.AddUnidade(unidade);	
		    System.out.println("Estoque atualizado!");
	   	 }
	   }

	   //METODO DE REMOVE UNIDADE
	   public void RemoveUnidade(int unidade) {
		   for (produtos produtos : produtosCadastrados) {
			produtos.RemoveUnidade(unidade);
			System.out.println("Baixa com sucesso!");
		}
	   }
	   
	   //METODO PRA VER TOTAL DE ESTOQUE
	   public void produtsTotalEstoque() {
		   int contador = 1;
	      if(produtosCadastrados != null && !produtosCadastrados.isEmpty()) {
	    	  for (produtos produtos : produtosCadastrados) { 
				 System.out.println(contador + "º Produto:" + produtos.getProdutos() + "| Qtd: " + produtos.getQuantidade() + "| Investimento: " + produtos.totalValueInStock());
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
	   
	   
	   //METODOS DE BUSCA
	   //METODO PRA BUSCA O PRODUTO PELO ID
	   public produtos buscaProdutosId (int idNumeroDoProduto) {
	        if(IDProduto.get(idNumeroDoProduto) == null) {
	        	  System.out.println("'" + idNumeroDoProduto + "' Id não encontrado.");
	        } else {
	        	 for (produtos produto : produtosCadastrados) {
	        		     System.out.println();
	 		        	 System.out.println("Dados do Produto Encontrado:");
	 			          System.out.println("Nome: " + produto.getProdutos());
	 			          System.out.println("Preço: " + produto.getPreco());
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
			          System.out.println("Preço: " + produto.getPreco());
			          System.out.println("Quantidade: " + produto.getQuantidade());
			          System.out.println("Código do Produto: " + produto.getCodigoProduto());
		        }
		    }	
		    System.out.println("'" + nomeProduto + "' não encontrado.");
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
	   
	
}
