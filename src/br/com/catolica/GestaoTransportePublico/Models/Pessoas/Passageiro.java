package br.com.catolica.GestaoTransportePublico.Models.Pessoas;

public class Passageiro extends Pessoa{

    private boolean possuiPassagem= false;
    private boolean embarcou = false;

    public Passageiro(String nome, int idadde, String cpf, String senha) {
        super(nome, idadde, cpf, senha);
    }

    public void embarcar() {
        if (!embarcou) {
            embarcou = true;
            System.out.println(String.format("%s embarcou.", getNome()));
        } else {
            System.out.println(String.format("%s já está embarcado.", getNome()));
        }
    }


}
