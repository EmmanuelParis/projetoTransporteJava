package br.com.catolica.GestaoTransportePublico.Enums;

public enum EnumTipoDeVeiculo {

    ONIBUS("Ônibus"),
    TREM("Trem"),
    METRO("Metro");

    private String descricao;

    EnumTipoDeVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
