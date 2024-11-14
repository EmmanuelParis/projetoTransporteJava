package br.com.catolica.GestaoTransportePublico.Contracts;

public interface IPassageiroInterface {

    void comprarBilhete(String origem, String destino, double valorPago);

    void exibirBilhetes();
}
