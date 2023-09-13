package ProjetoPoo2;

import java.time.LocalDate;

public class CadastroPessoaJuridica extends PessoaJuridicaRepositorio {

    public boolean cadastrarEmpresa(String nome, String endereco, String cnpjRecebido) {
            String verificadorCnpj;
            String cnpj;

                for (int i = 0; i < pessoaJuridicarep.size(); i++) {
                    PessoaJuridica pessoaJuridica = pessoaJuridicarep.get(i);
                    cnpj = pessoaJuridica.getCnpj();
                    if (cnpjRecebido.equals(cnpj)) {
                        return false;
                    }
                }
                if (cnpjRecebido.length()==14) {
                    PessoaJuridica empresa = new PessoaJuridica(nome, endereco, cnpjRecebido);
                    pessoaJuridicarep.add(empresa);
                    return true;
                }else{
                    System.out.println("Cnpj não tem 14 digitos");
                    return false;
                }


    }

    public boolean alterarEmpresa(String nome, String endereco, String cnpjRecebido){
        String cnpjConsultado;
        boolean existeCnpj = consultarSeCnpjExiste(cnpjRecebido);
        if(existeCnpj) {
            PessoaJuridica empresa = consultarPessoaJuridica(cnpjRecebido);
            empresa.setCnpj(cnpjRecebido);
            empresa.setEndereco(endereco);
            empresa.setNome(nome);
            return true;
        }

    return false;
    }
    public boolean consultarSeCnpjExiste(String cnpj){
        String cnpjRecebido;
        for (int i = 0; i < pessoaJuridicarep.size(); i++) {
            PessoaJuridica pessoa = pessoaJuridicarep.get(i);
            cnpjRecebido = pessoa.getCnpj();
            if (cnpjRecebido.equals(cnpj)) {
                return true;
            }

            }
        return false;
        }

    public PessoaJuridica consultarPessoaJuridica(String cpf){
        String cpfRecebido;
        for (int i = 0; i < pessoaJuridicarep.size(); i++) {
            PessoaJuridica pessoa = pessoaJuridicarep.get(i);
            cpfRecebido = pessoa.getCnpj();
            if (cpfRecebido.equals(cpf)) {
                return pessoa;
            }

        }
        return null;
    }
    }




