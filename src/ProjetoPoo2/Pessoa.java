package ProjetoPoo2;

public class Pessoa {

    private String nome;
    private String endereco;

    public Pessoa(){}

    public Pessoa(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public static boolean VerificarPessoa(String numero) {
        if (numero.length() == 11) {
            return true;
        } else {
            return false;
        }
    }


    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }





}
