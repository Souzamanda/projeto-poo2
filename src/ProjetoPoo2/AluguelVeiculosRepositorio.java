package ProjetoPoo2;

import java.util.ArrayList;

public class AluguelVeiculosRepositorio {

   public static ArrayList<AluguelVeiculos> aluguelVeiculos = new ArrayList<>();

    public static void listarAlugueis (){
        System.out.println("Lista de alugueis realizados:");
        for (AluguelVeiculos aluguel:aluguelVeiculos){
            System.out.println(aluguel);
        }
    }

    //public static AluguelVeiculos removerAluguel(){
   //     return aluguelVeiculos.remove(0);
  //  }

}
