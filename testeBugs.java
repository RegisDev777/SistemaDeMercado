package br.com.mercadoTeste;

import java.util.Locale;

public class testeBugs {
   public static void main(String[] args) {
	   
	   
	   Locale.setDefault(null);
	   
	   produtos p1 = new produtos(234, "bolo", 23, 10.90);

       controladorDeProdutos c1 = new controladorDeProdutos();
       
       c1.adicionaProdutoHash(p1);
       
     
	   String p = "BOLO";
       
       c1.buscaProdutoPeloNome(p);
	   c1.buscaProdutosId(234);
			   
			   
			   
	   
	   
	   
	   
   }
}
