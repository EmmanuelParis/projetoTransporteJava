package br.com.catolica.GestaoTransportePublico.Models.Misc;

import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Gerente;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Motorista;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Passageiro;
import br.com.catolica.GestaoTransportePublico.Models.Pessoas.Pessoa;
import br.com.catolica.GestaoTransportePublico.Service.SistemaCadastroRotas;
import br.com.catolica.GestaoTransportePublico.Service.SistemaCompraBilhete;

import java.util.Scanner;

public class Menus {

    public static void mostrarMenuUsuario(Pessoa usuario) {
        Scanner scanner = new Scanner(System.in);
        boolean usuarioAtivo = true;

        while (usuarioAtivo) {
            System.out.println("\n---MENU DO USUÁRIO: " + usuario.getNome() + " ---");

            if (usuario instanceof Gerente) {
                System.out.println("[1] Cadastrar Rota");
                System.out.println("[2] Remover Rotas");
                System.out.println("[3] Visualizar Rotas");
                System.out.println("[0] Logout");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        SistemaCadastroRotas.cadastrarRota((Gerente) usuario);
                        break;
                    case 2:
                        SistemaCadastroRotas.exibirRotacomId();
                        System.out.print("Digite o ID da rota que deseja remover: ");
                        int idRota = scanner.nextInt();
                        SistemaCadastroRotas.removerRota(idRota);
                        break;
                    case 3:
                        SistemaCadastroRotas.exibirRotas();
                        break;
                    case 0:
                        System.out.println("Saindo do Menu de Usuário...");
                        usuarioAtivo = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            } else if (usuario instanceof Motorista) {
                System.out.println("[1] Visualizar Rotas");
                System.out.println("[2] Registrar Presença");
                System.out.println("[0] Logout");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        SistemaCadastroRotas.exibirRotas();
                        break;
                    case 2:
                        SistemaCadastroRotas.escolherRota((Motorista) usuario);
                        break;
                    case 0:
                        System.out.println("Você foi deslogado.");
                        usuarioAtivo = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            } else if (usuario instanceof Passageiro) {
                System.out.println("[1] Visualizar Rotas");
                System.out.println("[2] Comprar Bilhete");
                System.out.println("[3] Exibir Bilhetes");
                System.out.println("[0] Logout");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        SistemaCadastroRotas.exibirRotas();
                        break;
                    case 2:
                        SistemaCompraBilhete.comprarBilhete((Passageiro) usuario);
                        break;
                    case 3:
                        ((Passageiro) usuario).exibirBilhetes();
                        break;
                    case 0:
                        System.out.println("Você foi deslogado.");
                        usuarioAtivo = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            } else {
                System.out.println("Tipo de usuário desconhecido.");
                usuarioAtivo = false;
            }
        }
    }
}