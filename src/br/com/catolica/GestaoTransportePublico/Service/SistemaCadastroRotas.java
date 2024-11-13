package br.com.catolica.GestaoTransportePublico.Service;

import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;
import br.com.catolica.GestaoTransportePublico.Models.Misc.Rota;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Gerente;
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

        if (gerente == null) {
            System.out.println("Somente um Gerente pode cadastrar rotas.");
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
        rota.exibirRota();
    }
}

