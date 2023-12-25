package br.com.mercadoTeste;

public class produtos {
 
	
	
	  private String produtos;
      private int    quantidade;      
      private int    codigoProduto;
      private double precoViaForncedor;
      private double precoAVenda;
      private int QuantidadeInicial; 
      private MetodosProdutos ModificadoresProdutos;

      
      //CONSTRUTOR
      public produtos(int codigoProduto,String produto, int quantidade, double preco, double precoAVenda) {
	     this.codigoProduto = codigoProduto;
    	 this.produtos = produto;
	     this.quantidade = quantidade;   
	     this.QuantidadeInicial = quantidade;
	     this.precoViaForncedor = preco;
	     this.precoAVenda = precoAVenda;
	     this.ModificadoresProdutos = new MetodosProdutos(); 
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
      
      public MetodosProdutos getModificadoresProdutos() {
		 return ModificadoresProdutos;
	  }
    
    
      //METODOS INTERNOS 

  
      //METODO PARA RETORNA O TOTAL DE LUCROS DAS VENDAS X REMOVE DO ESTOQUE UNIDADES
      public double LucrosLiquidosDasVendas() {
         return  getModificadoresProdutos().TotalVendaDeTodosOsProdutos - InvestiimentoInicialDOProduto();
         
      }

      //METODO PARA RETORNA O TOTAL DE VALOR INVESTIDO NO ESTOQUE COM MUDANÇA SE ADICIONA MAIS
      public double totalInvestimento() {
    	  
    	   return quantidade * precoViaForncedor;
      }
      
      //VALOR DO INVESTIMENTO NAO MUDA
      public double InvestiimentoInicialDOProduto() {
         return QuantidadeInicial * precoViaForncedor;     
      }
      
      
      
      //METODOS ADICIONA UNIDADE
      public void AddUnidade(int quantidade) {
    	  this.quantidade += quantidade;
      } 
      
     //METODO PARA REMOVE ESTOQUE DE VENDA
      public double removeUnidade(int quantidade) {
    	    if (this.quantidade >= quantidade) {
    	        this.quantidade -= quantidade;
    	        double valorVendido = quantidade * precoAVenda;

    	        // Atualiza os valores corretamente no ModificadoresProdutos
    	        getModificadoresProdutos().adicionaValorVenda(valorVendido);
    	        getModificadoresProdutos().adicionaQuantidadeBaixa(quantidade);

    	        return valorVendido;
    	    } else {
    	        System.out.println("Quantidade insuficiente em estoque.");
    	        return 0.0;
    	    }
    	}
      
     @Override
      public String toString() {
    	// TODO Auto-generated method stub
    	return "Produto:" + getProdutos() + "\n" + "Ivestimento:" + InvestiimentoInicialDOProduto();
     }
}
    