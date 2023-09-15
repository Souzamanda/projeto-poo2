package ProjetoPoo2;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu <T> {
    String nome, endereco, cpf, cnpj, data, cpfOuCnpj;
    LocalDate dataDeNascimento;
    boolean retorno;



    public void exibirMenuInicial() {
        System.out.println("0 - Encerrar programa");
        System.out.println("1 - Cadastrar pessoa ou empresa");
        System.out.println("2 - Modificar pessoa ou empresa");
        System.out.println("3 - Listar pessoas cadastradas");
        System.out.println("4 - Listar empresas");
        System.out.println("5 - Alugar um veículo");
        System.out.println("6 - Cadastrar veículo");
        System.out.println("7 - Devolver o veículo");
    }

    public void exibirMenuCadastroPessoa() {
        System.out.println("1 - Pessoa física");
        System.out.println("2 - Pessoa Jurídica");
    }

    public void cadastroVeiculo() throws Exception {
        VehicleService vehicleService = new VehicleService(VehicleRepository.getVehicleRepository());
        System.out.println("Cadastrar veículo no sistema");
        System.out.println("Qual o nome do veiculo?");
        String nome = CapturadorDeEntrada.nextLine();
        System.out.println("Qual a placa do veiculo?");
        String placa = CapturadorDeEntrada.nextLine();
        System.out.println("Qual o tamanho do veiculo? (Pequeno, medio, SUV)");
        Tamanho tamanho = Tamanho.valueOf(CapturadorDeEntrada.nextLine().toUpperCase().trim());

        vehicleService.RegisterVehicle(nome, placa, tamanho);

        System.out.println("Veiculo cadastrado");
    }

    public boolean formularioAluguelVeiculo(CadastroAluguel aluguel) {
        VehicleService vehicleService = new VehicleService(VehicleRepository.getVehicleRepository());
        PessoaFisica pessoaFisica = null;
        PessoaJuridica pessoaJuridica = null;
        List<Vehicle> veiculos = new ArrayList<>();
        String nomeDoCarro, local;
        System.out.println("Digite o id da locação:");
        int idLocacao = Integer.parseInt(CapturadorDeEntrada.nextLine());
        System.out.println("Digite seu CPF ou CNPJ (Somente números)");
        cpfOuCnpj = CapturadorDeEntrada.nextLine();
        if (Pessoa.VerificarPessoa(cpfOuCnpj)) {
            CadastroPessoaFisica cadastroPessoaFisica = new CadastroPessoaFisica();
            if (cadastroPessoaFisica.consultarSeCpfExiste(cpf)) {
                pessoaFisica = cadastroPessoaFisica.consultarPessoaFisica(cpfOuCnpj);

            } else {
                System.out.println("Cpf inválido");

            }

        } else if (!Pessoa.VerificarPessoa(cpfOuCnpj)) {
            CadastroPessoaJuridica cadastroPessoaJuridica = new CadastroPessoaJuridica();
            if (cadastroPessoaJuridica.consultarSeCnpjExiste(cpfOuCnpj)) {
                pessoaJuridica = cadastroPessoaJuridica.consultarPessoaJuridica(cpfOuCnpj);

            } else {
                System.out.println("Cnpj inválido");
            }

        }
        System.out.println("Digite o nome do carro desejado: ");
        nomeDoCarro = CapturadorDeEntrada.nextLine();
        veiculos = vehicleService.veiculosDisponiveisPeloNome(nomeDoCarro);
        Vehicle veiculo = veiculos.get(0);

        System.out.println("Digite o Local de retirada do veículo: ");
        local = CapturadorDeEntrada.nextLine();
        LocalDateTime dataHora = TransformarDataDeAluguel();
        if (pessoaJuridica != null){
            retorno = aluguel.alugarVeiculo(idLocacao,pessoaJuridica,veiculo,dataHora,local);
        }else{
            retorno = aluguel.alugarVeiculo(idLocacao,pessoaFisica,veiculo,dataHora,local);
        }
        if (retorno) {
            veiculo.setStatus(false);
            return true;
        } else {
            return false;
        }

    }

    public void devolucaoDeVeiculo(CadastroAluguel cadastroAluguel) {
        System.out.println("Digite o id da locação do veículo");
        int id = Integer.parseInt(CapturadorDeEntrada.nextLine());
        if(cadastroAluguel.consultarLocacaoExiste(id)) {
            AluguelVeiculos aluguelParaFinalizar = cadastroAluguel.consultarLocacao(id);
            System.out.println("Digite 'fisica' para Pessoa Fisica ou 'juridida' para Pessoa Juridica");
            String tipoDePessoa = CapturadorDeEntrada.nextLine();
            LocalDateTime dataDevolucao = TransformarDataDeAluguel();


            DevolucaoVeiculo devolucaoVeiculo = new DevolucaoVeiculo(aluguelParaFinalizar, dataDevolucao);
            System.out.println(devolucaoVeiculo);

            devolucaoVeiculo.calculoPagamento(tipoDePessoa);
        } else {
            System.out.println("Locação não encontrada");
        }
    }

    public boolean cadastroPessoaFisica(CadastroPessoaFisica cadastroPessoa) {
        System.out.print("Digite seu nome: ");
        nome = CapturadorDeEntrada.nextLine();
        System.out.print("\nDigite seu endereço: ");
        endereco = CapturadorDeEntrada.nextLine();
        System.out.print("\nDigite seu cpf (Somente números) com 11 dígitos: ");
        cpf = CapturadorDeEntrada.nextLine();
        System.out.print("\nEntre com a data de nascimento (dd/mm/yyyy): \n");
        data = CapturadorDeEntrada.nextLine();
        dataDeNascimento = TransformarDataDeNascimento(data);
        retorno = cadastroPessoa.cadastrarPessoa(nome, endereco, cpf, dataDeNascimento);
        if (retorno) {
            return true;
        } else {
            return false;
        }

    }

    public boolean alteracaoPessoaFisica(CadastroPessoaFisica cadastroPessoa) {
        String cpfDigitado;
        System.out.print("Digite o CPF que deseja realizar alteracao: ");
        cpfDigitado = CapturadorDeEntrada.nextLine();
        boolean existeCpf = cadastroPessoa.consultarSeCpfExiste(cpfDigitado);
        if (existeCpf) {
            System.out.print("Digite o nome atualizado: ");
            nome = CapturadorDeEntrada.nextLine();
            System.out.print("\nDigite o endereço atualizado: ");
            endereco = CapturadorDeEntrada.nextLine();
            System.out.print("\nDigite o cpf atualizado (Somente números): ");
            cpf = CapturadorDeEntrada.nextLine();
            System.out.print("\nEntre com a data de nascimento atualizada (dd/mm/yyyy): \n");
            data = CapturadorDeEntrada.nextLine();
            dataDeNascimento = TransformarDataDeNascimento(data);
            retorno = cadastroPessoa.alterarPessoa(nome, endereco, cpf, dataDeNascimento);
            if (retorno) {
                return true;
            }
        } else {
            System.out.println("Cpf não encontrado.");
        }
        return false;
    }

    public boolean cadastroPessoaJuridica(CadastroPessoaJuridica cadastroEmpresa) {
        System.out.print("Digite o nome da empresa: ");
        nome = CapturadorDeEntrada.nextLine();
        System.out.print("\nDigite o endereço da empresa: ");
        endereco = CapturadorDeEntrada.nextLine();
        System.out.print("\nDigite o CNPJ da empresa (Somente números) com 14 dígitos: ");
        cnpj = CapturadorDeEntrada.nextLine();
        retorno = cadastroEmpresa.cadastrarEmpresa(nome, endereco, cnpj);
        if (retorno) {
            return true;
        } else {
            return false;
        }

    }

    public boolean alteracaoPessoaJuridica(CadastroPessoaJuridica cadastroPessoa) {
        String cnpjDigitado;
        System.out.print("Digite o CNPJ que deseja realizar alteracao: ");
        cnpjDigitado = CapturadorDeEntrada.nextLine();
        boolean existeCnpj = cadastroPessoa.consultarSeCnpjExiste(cnpjDigitado);
        if (existeCnpj) {
            System.out.print("Digite o nome da empresa atualizado: ");
            nome = CapturadorDeEntrada.nextLine();
            System.out.print("\nDigite o endereço da empresa atualizado: ");
            endereco = CapturadorDeEntrada.nextLine();
            System.out.print("\nDigite o cnpj da empresa atualizado (Somente números): ");
            cnpj = CapturadorDeEntrada.nextLine();
            retorno = cadastroPessoa.alterarEmpresa(nome, endereco, cnpj);
            if (retorno) {
                return true;
            }
        } else {
            System.out.println("Cnpj não encontrado.");
        }
        return false;
    }

    LocalDate TransformarDataDeNascimento(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(input, formatter);

    }

    LocalDateTime TransformarDataDeAluguel() {
        System.out.println("Digite o dia e horario desejado (dd/MM/yyyy HH:mm:ss) :");
        String dateString = CapturadorDeEntrada.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }

}
