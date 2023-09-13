package ProjetoPoo2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        CadastroPessoaFisica cadastroPessoa = new CadastroPessoaFisica();
        CadastroPessoaJuridica cadastroEmpresa = new CadastroPessoaJuridica();
        AluguelVeiculosRepositorio aluguelVeiculos = new AluguelVeiculosRepositorio();
        CadastroAluguel cadastroAluguel = new CadastroAluguel();
        boolean alterado;
        Menu menu = new Menu();
        int opcao;
        do {
            menu.exibirMenuInicial();
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    boolean resultadoCadastro;
                    menu.exibirMenuCadastroPessoa();
                    opcao = entrada.nextInt();
                    if (opcao == 1){
                            resultadoCadastro = menu.cadastroPessoaFisica(cadastroPessoa);
                            if (resultadoCadastro) {
                                System.out.println("Cadastro realizado com sucesso!\n");
                                PessoaFisicaRepositorio.listarPessoas(); //falta fazer isso funcionar
                            } else {
                                System.out.println("Cpf existente na base\n");
                            }

                    }else if (opcao == 2){
                        resultadoCadastro = menu.cadastroPessoaJuridica(cadastroEmpresa);
                        if (resultadoCadastro) {
                            System.out.println("Cadastro realizado com sucesso!\n");
                            PessoaJuridicaRepositorio.listarPessoasJuridicas();
                        } else {
                            System.out.println("Cnpj existente na base\n");
                        }

                    }else{
                        System.out.println("Opção inválida");
                    }
                    break;
                case 2:

                    menu.exibirMenuCadastroPessoa();
                    opcao = entrada.nextInt();
                        if (opcao == 1){
                            alterado = menu.alteracaoPessoaFisica(cadastroPessoa);
                            if (alterado) {
                                System.out.println("Cadastro atualizado com sucesso!\n");
                                PessoaFisicaRepositorio.listarPessoas();
                            }

                    } else if (opcao == 2) {
                            alterado = menu.alteracaoPessoaJuridica(cadastroEmpresa);
                            if (alterado) {
                                System.out.println("Cadastro atualizado com sucesso!\n");
                                PessoaJuridicaRepositorio.listarPessoasJuridicas();
                            }
                        }
                        else {
                            System.out.println("Opção inválida");
                        }
                    break;
                case 3:
                    PessoaFisicaRepositorio.listarPessoas();
                    break;
                case 4:
                    PessoaJuridicaRepositorio.listarPessoasJuridicas();
                    break;
                case 5:
                    alterado = menu.formularioAluguelVeiculo(cadastroAluguel);
                    if (alterado) {
                        System.out.println("Aluguel realizado com sucesso");
                        AluguelVeiculosRepositorio.listarAlugueis();
                    }
                    break;
                case 6:
                    menu.cadastroVeiculo();
                    break;
                case 7:
                    menu.devolucaoDeVeiculo(cadastroAluguel);
                    break;
            }//switch principal acaba aqui



        }while(opcao != 0);
    }

}
