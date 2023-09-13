package ProjetoPoo2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class PessoaFisica extends Pessoa {

    private String cpf;
    private LocalDate dataDeNascimento;




    public PessoaFisica (){
        super();
    }
    public PessoaFisica(String nome, String endereco, String cpf, LocalDate dataDeNascimento) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }



    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento = LocalDate.parse(dataDeNascimento);
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento){
        this.dataDeNascimento =dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return " Nome: " +getNome()+ "\n CPF: " +cpf+ "\n Endereço: " +getEndereco()+ "\n Idade: " +getIdade() + "\n";
    }

}
