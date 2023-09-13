package ProjetoPoo2;

import java.time.LocalDateTime;

public class CadastroAluguel <T> extends  AluguelVeiculosRepositorio {

    public boolean alugarVeiculo (int id, T pessoa, T veiculo,  LocalDateTime data, String local){
            AluguelVeiculos aluguel = new AluguelVeiculos<>(id,pessoa,veiculo,data,local);
            aluguelVeiculos.add(aluguel);
            return true;
    }

    public boolean consultarLocacaoExiste (int id) {
        int idRecebido;
        for (int i = 0; i < aluguelVeiculos.size(); i++) {
            AluguelVeiculos aluguel = aluguelVeiculos.get(i);
            idRecebido = aluguel.getId();

            if(idRecebido == id) {
                return true;
            }
        }
        return false;
    }

    public AluguelVeiculos consultarLocacao (int id) {
        int idRecebido;
        for (int i = 0; i < aluguelVeiculos.size(); i++) {
            AluguelVeiculos aluguel = aluguelVeiculos.get(i);
            idRecebido = aluguel.getId();

            if(idRecebido == id) {
                return aluguel;
            }
        }
        return null;
    }
}
