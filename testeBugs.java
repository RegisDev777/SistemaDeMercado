package br.com.mercadoTeste;

import java.util.Locale;

public class testeBugs {
   public static void main(String[] args) {
	   
      produtos p1 = new produtos(123, "cafe", 25, 5.50, 8.50);  
      ControladorDeMetodos ct1 = new ControladorDeMetodos();
      controladorDeProdutos cp1 = new controladorDeProdutos();
      
      
    System.out.println(p1.totalInvestimento());
			   
	   
	   
	   
	   
   }
}
