package br.com.catolica.GestaoTransportePublico.Enums;

public enum EnumTurno {

    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private String descricao;

    EnumTurno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
