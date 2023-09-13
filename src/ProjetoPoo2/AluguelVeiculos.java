package ProjetoPoo2;

import java.time.LocalDateTime;


public class AluguelVeiculos <T>{
    int id;
    T tipoDePessoa;
    T veiculo;
    LocalDateTime dataDoAluguel;
    String local;

    public AluguelVeiculos (int id, T tipoDePessoa, T veiculo, LocalDateTime dataDoAluguel, String local) {
        this.id = id;
        this.tipoDePessoa = tipoDePessoa;
        this.veiculo = veiculo;
        this.dataDoAluguel = dataDoAluguel;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getTipoDePessoa() {
        return tipoDePessoa;
    }

    public void setTipoDePessoa(T tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }

    public T getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(T veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataDoAluguel() {
        return dataDoAluguel;
    }

    public void setDataDoAluguel(LocalDateTime dataDoAluguel) {
        this.dataDoAluguel = dataDoAluguel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "AluguelVeiculos{" +
                "tipoDePessoa=" + tipoDePessoa +
                ", veiculo=" + veiculo +
                ", dataDoAluguel=" + dataDoAluguel +
                ", local='" + local + '\'' +
                '}';
    }
    //usar linha abaixo para chegar na diferença de horas na devolução
    //long periodAsHours  = ChronoUnit.HOURS.between(localDateTime12, localDateTime13);
}
