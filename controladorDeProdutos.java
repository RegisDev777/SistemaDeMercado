package br.com.mercadoTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class controladorDeProdutos {
	
	   private List<produtos> produtosCadastrados = new ArrayList<>();
	   private HashMap<Integer, produtos> IDProduto = new HashMap<>();

	   
	   public List<produtos> getProdutosCadastrados() {
		 return Collections.unmodifiableList(produtosCadastrados);
	   }

	   
	   

	   
	   
	   
	   //METODO PARA ADICIONA PRODUTO HASHMAP
	   public void adicionaProdutoHash(produtos produtosID) {
		    this.produtosCadastrados.add(produtosID);
		    this.IDProduto.put(produtosID.getCodigoProduto(), produtosID);
		    System.out.println(produtosID.getProdutos() + " add com sucesso!!");
	   }	 
	   
	   
	   //METODO PRA BUSCA O PRODUTO PELO ID
	   public produtos buscaProdutosId (int idNumeroDoProduto) {
	        if(IDProduto.get(idNumeroDoProduto) == null) {
	        	System.out.println("RESULTADO: ID NAO ENCONTRADO");
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
			          System.out.println("------------------------------");
		        }
		    }	
		    System.out.println("Produto não encontrado.");
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
