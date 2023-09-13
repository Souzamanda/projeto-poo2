package ProjetoPoo2;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }


    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return " Nome: " +getNome()+ "\n CNPJ: " +cnpj+ "\n Endereço: " +getEndereco()+ "\n";
    }

}
