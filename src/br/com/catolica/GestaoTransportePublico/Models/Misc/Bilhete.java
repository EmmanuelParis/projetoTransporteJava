package br.com.catolica.GestaoTransportePublico.Models.Misc;

import br.com.catolica.GestaoTransportePublico.Enums.EnumStatusBilhete;

public class Bilhete {

    private String origem;
    private String destino;
    private double valorPago;
    private EnumStatusBilhete status;

    // Construtor
    public Bilhete(String origem, String destino, double valorPago) {
        this.origem = origem;
        this.destino = destino;
        this.valorPago = valorPago;
        this.status = EnumStatusBilhete.ATIVO;
    }

    // Getters e Setters
    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getValorPago() {
        return valorPago;
    }

    public EnumStatusBilhete getStatus() {
        return status;
    }

    public void exibirBilhete() {
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Valor Pago: R$ " + valorPago);
        System.out.println("Status do Bilhete: " + status.getDescricao());
    }
}