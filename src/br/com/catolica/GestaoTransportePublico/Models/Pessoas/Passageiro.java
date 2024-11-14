package br.com.catolica.GestaoTransportePublico.Models.Pessoas;

import br.com.catolica.GestaoTransportePublico.Contracts.IPassageiroInterface;
import br.com.catolica.GestaoTransportePublico.Models.Misc.Bilhete;

public class Passageiro extends Pessoa implements IPassageiroInterface {

    private Bilhete[] bilhetesComprados;
    private int numBilhetes;

    public Passageiro(String nome, int idade, String cpf, String senha) {
        super(nome, idade, cpf, senha);
        this.bilhetesComprados = new Bilhete[15];
        this.numBilhetes = 0;
    }

    public void comprarBilhete(String origem, String destino, double valorPago) {
        if (numBilhetes < bilhetesComprados.length) {
            Bilhete bilhete = new Bilhete(origem, destino, valorPago);
            bilhetesComprados[numBilhetes] = bilhete;
            numBilhetes++;
            System.out.println("Bilhete comprado com sucesso!");
        } else {
            System.out.println("Você já comprou o número máximo de bilhetes.");
        }
    }

    public void exibirBilhetes() {
        if (numBilhetes == 0) {
            System.out.println("Você ainda não comprou nenhum bilhete.");
        } else {
            System.out.println("Bilhetes comprados: ");
            for (int i = 0; i < numBilhetes; i++) {
                bilhetesComprados[i].exibirBilhete();
            }
        }
    }

    public Bilhete[] getBilhetesComprados() {
        return bilhetesComprados;
    }

    public int getNumBilhetes() {
        return numBilhetes;
    }
}