package ProjetoPoo2;

import java.time.LocalDate;

public class CadastroPessoaFisica extends PessoaFisicaRepositorio {

    public boolean cadastrarPessoa(String nome, String endereco, String cpfRecebido, LocalDate dataDeNascimento) {
            String verificadorCpf;
            String cpf;

                for (int i = 0; i < pessoaFisica.size(); i++) {
                    PessoaFisica pessoa = pessoaFisica.get(i);
                    cpf = pessoa.getCpf();
                    if (cpf.equals(cpfRecebido)) {
                        return false;
                    }
                }
                if (cpfRecebido.length()==11) {
                    PessoaFisica Pessoa = new PessoaFisica(nome, endereco, cpfRecebido, dataDeNascimento);
                    pessoaFisica.add(Pessoa);
                    return true;
                }else{
                    System.out.println("Cpf não tem 11 digitos");
                    return false;
                }

    }

    public boolean alterarPessoa(String nome, String endereco, String cpfRecebido, LocalDate dataDeNascimento){
        String cpfConsultado;
        boolean existeCpf = consultarSeCpfExiste(cpfRecebido);
        if(existeCpf) {
            PessoaFisica pessoa = consultarPessoaFisica(cpfRecebido);
            pessoa.setCpf(cpfRecebido);
            pessoa.setEndereco(endereco);
            pessoa.setNome(nome);
            pessoa.setDataDeNascimento(dataDeNascimento);
            return true;
        }

    return false;
    }
    public boolean consultarSeCpfExiste(String cpf){
        String cpfRecebido;
        for (int i = 0; i < pessoaFisica.size(); i++) {
            PessoaFisica pessoa = pessoaFisica.get(i);
            cpfRecebido = pessoa.getCpf();
            if (cpfRecebido.equals(cpf)) {
                return true;
            }

            }
        return false;
        }

    public PessoaFisica consultarPessoaFisica(String cpf){
        String cpfRecebido;
        for (int i = 0; i < pessoaFisica.size(); i++) {
            PessoaFisica pessoa = pessoaFisica.get(i);
            cpfRecebido = pessoa.getCpf();
            if (cpfRecebido.equals(cpf)) {
                return pessoa;
            }

        }
        return null;
    }
    }




