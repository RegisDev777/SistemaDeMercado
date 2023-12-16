package br.com.mercadoTeste;

public class produtos {
 
	
	
	  private String produtos;
      private double preco;
      private int    quantidade;      
      private int    codigoProduto;
      
      
      public produtos(int codigoProduto,String produto, int quantidade, double preco ) {
	     this.codigoProduto = codigoProduto;
    	 this.produtos = produto;
	     this.quantidade = quantidade;   
	     this.preco = preco;
 
	  }
      
       
      
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

      

//      @Override
//      public String toString() {
//          return "Produto: " + produtos + ", Preço: " + preco + ", Quantidade: " + quantidade + ", Código do Produto: " + codigoProduto;
//      }



}