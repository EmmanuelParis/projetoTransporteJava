package br.com.catolica.GestaoTransportePublico.Service;

import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Passageiro;
import br.com.catolica.GestaoTransportePublico.Models.Misc.Rota;
import java.util.Scanner;

public class SistemaCompraBilhete {

    private static Rota[] rotasCadastradas = SistemaCadastroRotas.getRotasCadastradas();

    public static void comprarBilhete(Passageiro passageiro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- COMPRAR BILHETE ---");
        System.out.print("Digite a origem da viagem: ");
        String origem = scanner.nextLine();

        System.out.print("Digite o destino da viagem: ");
        String destino = scanner.nextLine();

        Rota rotaSelecionada = verificarRotaDisponivel(origem, destino);

        if (rotaSelecionada != null) {
            System.out.print("Digite o valor pago: R$ ");
            double valorPago = scanner.nextDouble();

            passageiro.comprarBilhete(origem, destino, valorPago);
        } else {
            System.out.println("Rota não encontrada. Verifique se a origem e o destino estão corretos.");
        }
    }

    private static Rota verificarRotaDisponivel(String origem, String destino) {
        for (Rota rota : rotasCadastradas) {
            if (rota != null && rota.getOrigem().equalsIgnoreCase(origem) && rota.getDestino().equalsIgnoreCase(destino)) {
                return rota;
            }
        }
        return null;
    }
}