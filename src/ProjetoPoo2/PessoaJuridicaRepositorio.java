package ProjetoPoo2;

import java.util.ArrayList;

public class PessoaJuridicaRepositorio {
   static ArrayList<PessoaJuridica> pessoaJuridicarep = new ArrayList<>();

//falta fazer o listarPessoas funcionar.
   public static void listarPessoasJuridicas (){
      int cont = 0;
      System.out.println("Lista de Empresas cadastradas:");
      for (PessoaJuridica pj:pessoaJuridicarep){
         System.out.println(pj);
         cont++;
      }
      if (cont == 0){
         System.out.println("         Não há empresas cadastradas ainda");
      }
   }
}
