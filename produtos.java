package br.com.mercadoTeste;

public class produtos {
 
	
	
	  private String produtos;
      private double preco;
      private int    quantidade;      
      private int    codigoProduto;
      
      //CONSTRUTOR
      public produtos(int codigoProduto,String produto, int quantidade, double preco ) {
	     this.codigoProduto = codigoProduto;
    	 this.produtos = produto;
	     this.quantidade = quantidade;   
	     this.preco = preco;
 
	  }
      
       
      //GETTER E SETTERS
      public String getProdutos() {
		return produtos;
	}
      public double getPreco() {
		return preco;
	}
      public int getQuantidade() {
		return quantidade;
	}
      public int getCodigoProduto() {
    	
		return codigoProduto;
	}
  
      
      //METODOS INTERNOS 
      
      //TOTAL DE VALOR INVESTIDO NO ESTOQUE
      public double totalValueInStock() {
    	   return quantidade * preco;
      }
      
      //METODOS ADICIONA UNIDADE
      public void AddUnidade(int quantidade) {
    	  this.quantidade += quantidade;
      }
      
      //METODO REMOVE UNIDADE 
      public void RemoveUnidade(int quantidade) {
    	 this.quantidade -= quantidade;
      }

}