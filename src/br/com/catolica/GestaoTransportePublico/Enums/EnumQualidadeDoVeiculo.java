package br.com.catolica.GestaoTransportePublico.Enums;

public enum EnumQualidadeDoVeiculo {

    BOM("Bom"),
    MEDIANO("Mediano"),
    RUIM("Ruim");

    private String descricao;

    EnumQualidadeDoVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
