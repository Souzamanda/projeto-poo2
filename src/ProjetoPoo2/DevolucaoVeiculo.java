package ProjetoPoo2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DevolucaoVeiculo {
    AluguelVeiculos aluguelParaFinalizar;
    LocalDateTime dataDevolucao;
    Vehicle veiculoAlugado = aluguelParaFinalizar.veiculo;
    LocalDateTime dataAluguel = aluguelParaFinalizar.getDataDoAluguel();

    public AluguelVeiculos getAluguelParaFinalizar() {
        return aluguelParaFinalizar;
    }

    public void setAluguelParaFinalizar(AluguelVeiculos aluguelParaFinalizar) {
        this.aluguelParaFinalizar = aluguelParaFinalizar;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public DevolucaoVeiculo(AluguelVeiculos aluguelParaFinalizar, LocalDateTime dataDevolucao) {
        this.aluguelParaFinalizar = aluguelParaFinalizar;
        this.dataDevolucao = dataDevolucao;
    }

    public void calculoPagamento(String tipoDePessoa) {
        double precoDiaria = veiculoAlugado.getPrecoDiaria();
        long diarias = ChronoUnit.DAYS.between(dataAluguel, dataDevolucao);
        double desconto = 0;
        double total = precoDiaria * diarias;

        if (tipoDePessoa.equalsIgnoreCase("fisica") && diarias > 5) {
            desconto = 0.05;
        } else if (tipoDePessoa.equalsIgnoreCase("juridica") && diarias > 3) {
            desconto = 0.1;
        }

        if (desconto > 0) {
            total = total - (total * desconto);
        }

        System.out.println("O total de " + diarias + " por R$" + precoDiaria +
                " cada, fica em: R$" + total);
    }

    @Override
    public String toString() {
        return "Devolução do veículo " + aluguelParaFinalizar.getVeiculo() +
                "\ndo dia: " + aluguelParaFinalizar.getDataDoAluguel() +
                "\naté o dia: " + dataDevolucao;
    }
}
