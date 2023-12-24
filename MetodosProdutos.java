package br.com.mercadoTeste;

public class MetodosProdutos {

	double TotalVendaDeTodosOsProdutos = 0;
    int quantidadeBaixa;
    double valorTotalVenda;


    
      //GETTERS E SETTTERS 
      public int getQuantidadeBaixa() {
		return quantidadeBaixa;
	}
      public void setQuantidadeBaixa(int quantidadeBaixa) {
		this.quantidadeBaixa = quantidadeBaixa;
	}
      public double getValorTotalVenda() {
		return valorTotalVenda;
	  } 
      public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
      }
   
      
      
      //METODO PARA RETORNA O TOTAL DE VENDAS
      public double getTotalVendaDeTodosOsProdutos() {
	 	return TotalVendaDeTodosOsProdutos;
	  }
      
   	  //METODO PARA RETORNA O TOTAL DE VENDAS
      public double TotalDeVendas() {
    	  return getTotalVendaDeTodosOsProdutos();
      }
      
      //METODO PARA DA O VALOR DA  VENDA
      public void adicionaValorVenda(double valor) {
          TotalVendaDeTodosOsProdutos += valor;
      }
         
      //METODO PARA MOSTRA NUMEROS DE BAIXA FEITAS PRODUTOS E IR ATUALIZANDO
      public void adicionaQuantidadeBaixa(int quantidade) {
          quantidadeBaixa += quantidade;
      }

    
      
}
