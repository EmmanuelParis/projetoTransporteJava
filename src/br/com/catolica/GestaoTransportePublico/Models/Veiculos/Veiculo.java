package br.com.catolica.GestaoTransportePublico.Models.Veiculos;

import br.com.catolica.GestaoTransportePublico.Contracts.IVeiculoInterface;
import br.com.catolica.GestaoTransportePublico.Enums.EnumQualidadeDoVeiculo;
import br.com.catolica.GestaoTransportePublico.Enums.EnumTipoDeVeiculo;

import java.util.Scanner;

public abstract class Veiculo implements IVeiculoInterface {

    Scanner scanner = new Scanner(System.in);

    private int id;
    private boolean emUso = false;
    private EnumQualidadeDoVeiculo qualidade;
    private EnumTipoDeVeiculo tipoDeVeiculo;

    public Veiculo(int id, EnumTipoDeVeiculo tipo, EnumQualidadeDoVeiculo qualidade) {
        this.id = id;
        this.tipoDeVeiculo = tipo;
        this.qualidade = qualidade;
    }

    public int getId() {
        return id;
    }

    public EnumQualidadeDoVeiculo getQualidade() {
        return qualidade;
    }

    public EnumTipoDeVeiculo getTipo() {
        return tipoDeVeiculo;
    }


    public void iniciarRota(String inicio, String destino){
        if(this.qualidade.equals(EnumQualidadeDoVeiculo.RUIM)) {
            System.out.println("Não é possível realizar a rota, este veículo precisa de manutenção");
            System.out.print("Deseja realizar a manutenção? \n[1- Sim]\n[2- Não]\nOpção: ");
            int resposta = scanner.nextInt();
            switch (resposta){
                case 1:
                    manutencao();
                    break;
                case 2:
                    System.out.println("Cancelando a Rota!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }

        if(this.qualidade.equals(EnumQualidadeDoVeiculo.MEDIANO) ||this.qualidade.equals(EnumQualidadeDoVeiculo.BOM)){
            this.emUso = true;
            System.out.println("-------ROTA-------");
            System.out.println(String.format("Partida: %s", inicio));
            System.out.println(String.format("Destino: %s", destino));
            System.out.println(String.format("Qualidade do Veículo: %s", qualidade));
            System.out.println("-----------------");
            desgaste();
        }
    }

    public boolean parar(){
        if(this.emUso){
            System.out.println("Parando a rota!");
            this.emUso = false;
            return true;
        }
        System.out.println("O veículo já está parado!");
        return false;
    }

    public void manutencao(){
        this.qualidade = EnumQualidadeDoVeiculo.BOM;
        System.out.println("Manutenção feita com sucesso!");
    }

    public void desgaste(){
        switch (this.qualidade){
            case BOM -> this.qualidade = EnumQualidadeDoVeiculo.MEDIANO;
            case MEDIANO -> this.qualidade = EnumQualidadeDoVeiculo.RUIM;
        }
    }

    public void exibirInformacoes() {

    }
}
