import java.util.Scanner;

public class JogoLig4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem-vindo ao jogo Lig 4!");
    
            int opcao = obterOpcao(scanner);
            boolean modoIA = (opcao == 2);
            boolean modoLig4TurboIA = (opcao == 4);
            boolean modoLig4TurboJogador = (opcao == 3);
            boolean modoLig4TurboMalucoJogador =(opcao ==5);
            boolean modoLig4TurboMalucoIA = (opcao==6); 
    
            Lig4 jogo;
    
            if (modoLig4TurboIA || modoLig4TurboJogador) {
                jogo = new Lig4Turbo(modoIA);
            } else if (modoLig4TurboMalucoIA || modoLig4TurboMalucoJogador) {
                int nivelMaluquice = obterNivelMaluquice(scanner);
                jogo = new Lig4TurboMaluco(modoIA, nivelMaluquice);
            } else {
                jogo = new Lig4(modoIA);
            }
    
            jogo.inicializar();
    
            jogarPartida(jogo, scanner);
    
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
        while (true) {
            jogo.tabuleiro.imprimir();
            
            int coluna;
            if (jogo.jogadorAtual instanceof JogadorHumano) {
                System.out.println(jogo.jogadorAtual.getNome() + ", é a sua vez! Escolha a coluna (1 a 7):");
                coluna = scanner.nextInt() - 1;
            } else if (jogo.jogadorAtual instanceof IA) {
                coluna = jogo.obterColunaIA();
            } else {
               
                continue;
            }
            
            jogo.jogar(coluna);
            
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
    }
    public static int obterNivelMaluquice(Scanner scanner) {
        int nivelMaluquice;
        do {
            System.out.print("Digite o nível de maluquice (0 a 100): ");
            nivelMaluquice = scanner.nextInt();

            if (nivelMaluquice < 0 || nivelMaluquice > 100) {
                System.out.println("Nível de maluquice inválido! Deve estar entre 0 e 100.");
            } else {
                return nivelMaluquice;
            }
        } while (true);
    }
    
    
    
    
}
