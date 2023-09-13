package ProjetoPoo2;

import java.util.ArrayList;

public class PessoaFisicaRepositorio {
   static ArrayList<PessoaFisica> pessoaFisica = new ArrayList<>();

//falta fazer o listarPessoas funcionar.
   public static void listarPessoas (){
      System.out.println("Lista de pessoas cadastradas:");
      for (PessoaFisica pf:pessoaFisica){
         System.out.println(pf);
      }
   }
}
