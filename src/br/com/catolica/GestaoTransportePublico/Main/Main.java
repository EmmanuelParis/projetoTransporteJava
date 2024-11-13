package br.com.catolica.GestaoTransportePublico.Main;

import br.com.catolica.GestaoTransportePublico.Service.SistemaAutenticacao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean logado = false;

        while (!logado ) {
            System.out.println("\n---AUTENTICAÇÃO---");
            System.out.println("[1] - Login");
            System.out.println("[2] - Cadastro");
            System.out.println("[3] - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    SistemaAutenticacao.realizarLogin();
                    break;
                case 2:
                    SistemaAutenticacao.realizarCadastro();
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar o programa!");
                    return;
                default:
                    System.out.println("Opção Inválida, tente novamente!");
            }
        }


    }
}
