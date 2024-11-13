package br.com.catolica.GestaoTransportePublico.Models.Pessoas;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String senha;

    public Pessoa(String nome, int idade, String cpf, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() { return idade; }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() { return senha; }

    public void exibirCadastro() {
        System.out.println("\nCadastro concluído:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
    }
}
