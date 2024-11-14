package br.com.catolica.GestaoTransportePublico.Contracts;

import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;

public interface IVeiculoInterface {

    public void iniciarRota(String inicio, String destino);

    public boolean parar();

    public void manutencao();

    public void desgaste();
}
