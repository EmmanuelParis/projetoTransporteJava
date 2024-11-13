package br.com.catolica.GestaoTransportePublico.Models.Misc;

import br.com.catolica.GestaoTransportePublico.Models.Veiculos.Veiculo;

public class Rota {

    private String origem;
    private String destino;
    private Veiculo veiculo;

    public Rota(String origem, String destino, Veiculo veiculo) {
        this.origem = origem;
        this.destino = destino;
        this.veiculo = veiculo;
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

    public void exibirRota() {
        System.out.println(String.format("Rota: %s -> %s ", origem ,destino));
        veiculo.exibirInformacoes();
    }

}
