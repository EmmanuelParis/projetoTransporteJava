package br.com.catolica.GestaoTransportePublico.Models.Veiculos;

import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;
import br.com.catolica.GestaoTransportePublico.Enums.EnumTipoDeVeiculo;

public class Trem extends Veiculo {

    public Trem(int id, EnumQualidadeDoVeiculo qualidade) {
        super(id, EnumTipoDeVeiculo.TREM, qualidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Veículo ID: " + getId() + " | Tipo: " + getTipo().getDescricao() + " | Qualidade: " + getQualidade().getDescricao());
    }
}
