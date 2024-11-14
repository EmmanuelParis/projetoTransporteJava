package br.com.catolica.GestaoTransportePublico.Enums;

public enum EnumStatusBilhete {
    ATIVO("Ativo"),
    UTILIZADO("Utilizado"),
    CANCELADO("Cancelado");

    private String descricao;

    EnumStatusBilhete(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
