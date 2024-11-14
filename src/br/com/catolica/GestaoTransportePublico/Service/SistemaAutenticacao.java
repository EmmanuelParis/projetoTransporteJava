package br.com.catolica.GestaoTransportePublico.Service;

import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Gerente;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Motorista;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Passageiro;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Pessoa;

import java.util.Scanner;

public class SistemaAutenticacao {

    private static Pessoa[] usuariosCadastrados = new Pessoa[15];
    private static int numUsuarios = 0;
    private static Pessoa usuarioLogado = null;

    public static void realizarCadastro() {
        if (numUsuarios >= usuariosCadastrados.length) {
            System.out.println("Limite de usuários cadastrados atingido.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n---CADASTRO---");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        System.out.println("Escolha o cargo\n[1] - Gerente\n[2] - Motorista\n[3] - Passageiro\nOpção:  ");
        int opcaoCargo = scanner.nextInt();
        scanner.nextLine();  //

        Pessoa pessoa;

        switch (opcaoCargo) {
            case 1:
                pessoa = new Gerente(nome, idade, cpf, senha);
                break;
            case 2:
                pessoa = new Motorista(nome, idade, cpf, senha);
                break;
            case 3:
                pessoa = new Passageiro(nome, idade, cpf, senha);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                return;
        }

        usuariosCadastrados[numUsuarios] = pessoa;
        numUsuarios++;

        pessoa.exibirCadastro();
    }


    public static boolean realizarLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n---LOGIN---");
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        for (int i = 0; i < numUsuarios; i++) {
            if (usuariosCadastrados[i].getCpf().equals(cpf) && usuariosCadastrados[i].getSenha().equals(senha)) {
                usuarioLogado = usuariosCadastrados[i];
                System.out.println("Login bem-sucedido! Bem-vindo, " + usuariosCadastrados[i].getNome());
                return true;
            }
        }

        System.out.println("CPF ou senha inválidos.");
        return false;
    }

    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void realizarLogout() {
        usuarioLogado = null;
        System.out.println("Logout realizado com sucesso.");
    }
}

