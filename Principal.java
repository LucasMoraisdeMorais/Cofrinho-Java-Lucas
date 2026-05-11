package Uninter;

import java.util.Scanner;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Cofre cofre = new Cofre();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (opcao) {
                    case 1:
                        adicionarMoeda();
                        break;
                    case 2:
                        removerMoeda();
                        break;
                    case 3:
                        cofre.listarMoedas();
                        break;
                    case 4:
                        double total = cofre.totalConvertido();
                        System.out.printf("\n💰 Total em Reais (R$): %.2f%n", total);
                        break;
                    case 0:
                        System.out.println("\n👋 Saindo do sistema. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpa o buffer
                opcao = -1; 
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Cofrinho ---");
        System.out.println("1. Adicionar Moeda");
        System.out.println("2. Remover Moeda");
        System.out.println("3. Listar Moedas");
        System.out.println("4. Calcular Total Convertido para Real");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: "); // Menu
    }

    private static void adicionarMoeda() {
        System.out.println("\n--- Adicionar Moeda ---");
        System.out.println("1. Real");
        System.out.println("2. Dólar");
        System.out.println("3. Euro");
        System.out.print("Selecione o tipo de moeda: "); // Menu de adicao de moeda
        
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida para tipo de moeda.");
            scanner.nextLine();
            return;
        }
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o valor da moeda (ex: 1.00): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido.");
            scanner.nextLine();
            return;
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Moeda novaMoeda = null;
        switch (tipo) {
            case 1:
                novaMoeda = new Real(valor);
                break;
            case 2:
                novaMoeda = new Dolar(valor);
                break;
            case 3:
                novaMoeda = new Euro(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }

        cofre.adicionarMoeda(novaMoeda);
    }

    private static void removerMoeda() {
        System.out.println("\n--- Remover Moeda ---");
        System.out.println("1. Real");
        System.out.println("2. Dólar");
        System.out.println("3. Euro");
        System.out.print("Selecione o tipo de moeda a remover: "); // Menu de remocao de moedas
        
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida para tipo de moeda.");
            scanner.nextLine();
            return;
        }
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o valor da moeda a remover (ex: 1.00): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido.");
            scanner.nextLine();
            return;
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Moeda moedaParaRemover = null;
        switch (tipo) {
            case 1:
                moedaParaRemover = new Real(valor);
                break;
            case 2:
                moedaParaRemover = new Dolar(valor);
                break;
            case 3:
                moedaParaRemover = new Euro(valor);
                break;
            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }

        cofre.removerMoeda(moedaParaRemover);
    }
}
