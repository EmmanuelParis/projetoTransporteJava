package br.com.catolica.GestaoTransportePublico.Models.Misc;

import br.com.catolica.GestaoTransportePublico.Contracts.IRotaInterface;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Motorista;
import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Veiculo;

public class Rota implements IRotaInterface {

    private String origem;
    private String destino;
    private Veiculo veiculo;
    private Motorista motorista;

    public Rota(String origem, String destino, Veiculo veiculo) {
        this.origem = origem;
        this.destino = destino;
        this.veiculo = veiculo;
        this.motorista = null;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void atribuirMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void exibirRota() {
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Veículo: " + veiculo.getClass().getSimpleName());
        System.out.println("Motorista: " + (motorista != null ? motorista.getNome() : "Não atribuído"));
        System.out.println("-----------------------------");
    }
}
