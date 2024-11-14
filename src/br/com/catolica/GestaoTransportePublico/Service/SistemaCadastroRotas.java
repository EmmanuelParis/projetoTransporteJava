package br.com.catolica.GestaoTransportePublico.Service;

import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;
import br.com.catolica.GestaoTransportePublico.Models.Misc.Rota;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Gerente;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Motorista;
import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Metro;
import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Onibus;
import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Trem;
import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Veiculo;

import java.util.Scanner;

public class SistemaCadastroRotas {

    private static Rota[] rotasCadastradas = new Rota[15];
    private static int numRotas = 0;

    public static void cadastrarRota(Gerente gerente) {
        if (numRotas >= rotasCadastradas.length) {
            System.out.println("Limite de rotas cadastradas atingido.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n---CADASTRAR ROTA---");

        System.out.print("Digite a origem da rota: ");
        String origem = scanner.nextLine();

        System.out.print("Digite o destino da rota: ");
        String destino = scanner.nextLine();

        System.out.println("Escolha o tipo de veículo\n[1] - Ônibus\n[2] - Trem\n[3] - Metrô\nOpção: ");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe a qualidade do veículo\n[1] - Bom\n[2] - Mediano\n[3] - Ruim\nOpção: ");
        int tipoQualidade = scanner.nextInt();
        scanner.nextLine();

        EnumQualidadeDoVeiculo qualidadeVeiculo;

        switch (tipoQualidade) {
            case 1:
                qualidadeVeiculo = EnumQualidadeDoVeiculo.BOM;
                break;
            case 2:
                qualidadeVeiculo = EnumQualidadeDoVeiculo.MEDIANO;
                break;
            case 3:
                qualidadeVeiculo = EnumQualidadeDoVeiculo.RUIM;
                break;
            default:
                System.out.println("Opção inválida para qualidade.");
                return;
        }

        Veiculo veiculo;

        switch (tipoVeiculo) {
            case 1:
                System.out.print("Digite o ID do Ônibus: ");
                int idOnibus = scanner.nextInt();
                veiculo = new Onibus(idOnibus, qualidadeVeiculo);
                break;
            case 2:
                System.out.print("Digite o ID do Trem: ");
                int idTrem = scanner.nextInt();
                veiculo = new Trem(idTrem, qualidadeVeiculo);
                break;
            case 3:
                System.out.print("Digite o ID do Metrô: ");
                int idMetro = scanner.nextInt();
                veiculo = new Metro(idMetro, qualidadeVeiculo);
                break;
            default:
                System.out.println("Opção inválida para tipo de veículo.");
                return;
        }

        Rota rota = new Rota(origem, destino, veiculo);
        rotasCadastradas[numRotas] = rota;
        numRotas++;

        System.out.println("\nRota cadastrada com sucesso!");
    }

    public static void exibirRotas() {
        if (numRotas == 0) {
            System.out.println("Nenhuma rota cadastrada.");
            return;
        }

        System.out.println("\n--- ROTAS CADASTRADAS ---");
        for (int i = 0; i < numRotas; i++) {
            rotasCadastradas[i].exibirRota();
        }
    }

    public static void exibirRotasSemMotorista() {
        System.out.println("\n---ROTAS DISPONÍVEIS PARA DIRIGIR---");
        for (int i = 0; i < numRotas; i++) {
            if (rotasCadastradas[i].getMotorista() == null) {
                System.out.println("Rota " + (i + 1) + ": " + rotasCadastradas[i].getOrigem() + " -> " + rotasCadastradas[i].getDestino());
            }
        }
    }

    public static void escolherRota(Motorista motorista) {
        Scanner scanner = new Scanner(System.in);

        exibirRotasSemMotorista();

        System.out.print("Escolha o número da rota que deseja dirigir (ou 0 para voltar): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= numRotas) {
            Rota rotaEscolhida = rotasCadastradas[escolha - 1];
            if (rotaEscolhida.getMotorista() == null) {
                rotaEscolhida.atribuirMotorista(motorista);
                System.out.println("Você agora é o motorista desta rota!");
                rotaEscolhida.exibirRota();
            } else {
                System.out.println("Essa rota já tem um motorista.");
            }
        } else {
            System.out.println("Opção inválida ou rota inexistente.");
        }
    }

    public static Rota[] getRotasCadastradas() {
        return rotasCadastradas;
    }


    public static void exibirRotacomId() {
        System.out.println("Rotas disponíveis:");
        for (int i = 0; i < numRotas; i++) {
            if (rotasCadastradas[i] != null) {
                System.out.println("ID: " + i);
                rotasCadastradas[i].exibirRota();
            }
        }
    }

    public static void removerRota(int id) {
        if (id < 0 || id >= numRotas || rotasCadastradas[id] == null) {
            System.out.println("ID de rota inválido.");
            return;
        }

        for (int i = id; i < numRotas - 1; i++) {
            rotasCadastradas[i] = rotasCadastradas[i + 1];
        }

        rotasCadastradas[--numRotas] = null;
        System.out.println("Rota removida com sucesso.");
    }
}


