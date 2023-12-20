package br.com.mercadoTeste;

public class produtos {
 
	
	
	  private String produtos;
      private double precoViaForncedor;
      private double precoAVenda;
      private int    quantidade;      
      private int    codigoProduto;
      
      //CONSTRUTOR
      public produtos(int codigoProduto,String produto, int quantidade, double preco, double precoAVenda) {
	     this.codigoProduto = codigoProduto;
    	 this.produtos = produto;
	     this.quantidade = quantidade;   
	     this.precoViaForncedor = preco;
	     this.precoAVenda = precoAVenda;
 
	  }
      
       
      //GETTER E SETTERS
      public String getProdutos() {
		return produtos;
	}
      public double getPrecoViaFornecedor() {
		return precoViaForncedor;
	}
      public double getPrecoAVenda() {
		return precoAVenda;
	} 
      public int getQuantidade() {
		return quantidade;
	}
      public int getCodigoProduto() {
    	
		return codigoProduto;
	}

      
      //METODOS INTERNOS 
      
      //METODO PARA RETORNAR O LUCRO LIQUIDO
   
      
      //METODO PARA RETORNA O TOTAL DE LUCROS DAS VENDAS X REMOVE DO ESTOQUE UNIDADES
      public void LucrosDasVendas(int quantidadeVendida) {
          
      }

      
      
      
      
      //METODO PARA RETORNA O TOTAL DE VALOR INVESTIDO NO ESTOQUE
      public double totalInvestimento() {
    	   return quantidade * precoViaForncedor;
      }
      //METODOS ADICIONA UNIDADE
      public void AddUnidade(int quantidade) {
    	  this.quantidade += quantidade;
      } 
     //METODO PARA REMOVE ESTOQUE DE VENDA
      public double removeUnidade(double valorTotalVenda) {
    	    if (valorTotalVenda <= this.quantidade) {
    	        this.quantidade -= valorTotalVenda;
    	        double valorVenda = valorTotalVenda * precoAVenda;
    	        return valorVenda;
    	    } else {
    	        System.out.println("Erro de quantidade! Estoque insuficiente para essa quantidade de venda!!");
    	        return 0.0;
    	    }
    	}

      
      

}