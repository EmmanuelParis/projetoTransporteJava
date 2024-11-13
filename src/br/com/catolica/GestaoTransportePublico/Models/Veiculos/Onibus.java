package br.com.catolica.GestaoTransportePublico.Models.Veiculos;

import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;
import br.com.catolica.GestaoTransportePublico.Enums.EnumTipoDeVeiculo;

public class Onibus extends Veiculo {

    public Onibus(int id, EnumQualidadeDoVeiculo qualidade) {
        super(id, EnumTipoDeVeiculo.ONIBUS, qualidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Veículo ID: " + getId() + " | Tipo: " + getTipo().getDescricao() + " | Qualidade: " + getQualidade().getDescricao());
    }
}
