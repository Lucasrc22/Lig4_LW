import java.util.Scanner;

public class JogoLig4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem-vindo ao jogo Lig 4!");

            String nomeJogador1 = obterNomeJogador1(scanner);
            String nomeJogador2 = obterNomeJogador2(scanner);

            int opcao = obterOpcao(scanner);
            boolean modoIA = (opcao == 2);
            boolean modoLig4TurboJogador = (opcao == 3);
            boolean modoLig4TurboIA = (opcao == 4);
            boolean modoLig4TurboMalucoJogador = (opcao == 5);
            boolean modoLig4TurboMalucoIA = (opcao == 6);

            Lig4 jogo;

            if (modoLig4TurboIA || modoLig4TurboJogador) {
                jogo = new Lig4Turbo(modoIA);
            } else if (modoLig4TurboMalucoIA || modoLig4TurboMalucoJogador) {

                jogo = new Lig4TurboMaluco(modoIA);
            } else {
                jogo = new Lig4(modoIA);
            }

            jogo.inicializar(nomeJogador1, nomeJogador2);

            jogarPartida(jogo, scanner);

            System.out.println("Obrigado por jogar! Até a próxima.");

            scanner.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do jogo: " + e.getMessage());
        }
    }

    public static int obterOpcao(Scanner scanner) {
        int opcao;
        do {
            System.out.println("Escolha o modo de jogo:");
            System.out.println("1. Jogador vs Jogador");
            System.out.println("2. Jogador vs IA");
            System.out.println("3. Jogador vs Jogador (Lig4Turbo)");
            System.out.println("4. Jogador vs IA (Lig4Turbo)");
            System.out.println("5. Jogador vs Jogador (Lig4TurboMaluco)");
            System.out.println("6. Jogador vs IA (Lig4TurboMaluco)");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return opcao;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (true);
    }

    public static void jogarPartida(Lig4 jogo, Scanner scanner) {
        boolean continuarJogando = true;
        while (continuarJogando) {
            while (true) {
                jogo.tabuleiro.imprimir();

                int coluna;
                if (jogo.jogadorAtual instanceof JogadorHumano) {
                    System.out.println(jogo.jogadorAtual.getNome() + ", é a sua vez! Escolha a coluna (1 a 7):");
                    coluna = scanner.nextInt() - 1;
                    jogo.jogar(coluna);

                } else if (jogo.jogadorAtual instanceof IA) {
                    coluna = jogo.obterColunaIA();
                    jogo.jogar(coluna);

                } else {
                    continue;
                }

                if (jogo.checkVitoria()) {
                    jogo.tabuleiro.imprimir();
                    System.out.println(jogo.jogadorAtual.getNome() + " venceu!");
                    break;
                } else if (jogo.checkEmpate()) {
                    jogo.tabuleiro.imprimir();
                    System.out.println("O jogo terminou em empate!");
                    break;
                }

                jogo.trocarJogador();
            }
            continuarJogando = desejaContinuar(scanner);
            if (continuarJogando) {
                jogo.reiniciarJogo();
            }
        }

    }

    public static String obterNivelMaluquice(Scanner scanner) {
        String nivelMaluquice;
        do {
            System.out.print("Digite o nível de maluquice Facil, Medio ou Tricolor: ");
            nivelMaluquice = scanner.nextLine().trim();

            if ("facil".equalsIgnoreCase(nivelMaluquice)) {
                return nivelMaluquice;
            } else if ("medio".equalsIgnoreCase(nivelMaluquice)) {
                return nivelMaluquice;
            } else if ("tricolor".equalsIgnoreCase(nivelMaluquice)) {
                return nivelMaluquice;
            } else {
                System.out.println("Nível de maluquice inválido! Deve ser entre Facil, Medio ou Tricolor");
            }

        } while (true);
    }

    public static String obterNomeJogador1(Scanner scanner) {
        System.out.print("Digite o nome do Jogador 1: ");
        return scanner.nextLine();
    }

    public static String obterNomeJogador2(Scanner scanner) {
        System.out.print("Digite o nome do Jogador 2: ");
        return scanner.nextLine();
    }

    public static boolean desejaContinuar(Scanner scanner) {
        while (true) {
            System.out.print("Deseja continuar jogando? (S/N): ");
            String resposta = scanner.nextLine().toUpperCase();
            if (resposta.equals("S")) {
                return true;
            } else if (resposta.equals("N")) {
                return false;
            } else {
                System.out.println("");
            }
        }
    }

}
