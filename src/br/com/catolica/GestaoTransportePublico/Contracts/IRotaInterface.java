package br.com.catolica.GestaoTransportePublico.Contracts;

import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Motorista;

public interface IRotaInterface {

    void atribuirMotorista(Motorista motorista);

    void exibirRota();
}
