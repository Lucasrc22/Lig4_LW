import java.util.Scanner;

public class JogoLig4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem-vindo ao jogo Lig 4!");
    
            int opcao = obterOpcao(scanner);
            boolean modoIA = (opcao == 2);
            boolean modoLig4TurboIA = (opcao == 3);
            boolean modoLig4TurboJogador = (opcao == 4); 
    
            Lig4 jogo;
    
            if (modoLig4TurboIA || modoLig4TurboJogador) {
                jogo = new Lig4Turbo(modoIA);
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
            System.out.println("3. Jogador vs IA (Lig4Turbo)");
            System.out.println("4. Jogador vs Jogador (Lig4Turbo)"); 
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return opcao;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (true);
    }

    public static void jogarPartida(Lig4 jogo, Scanner scanner) {
        while (true) {
            jogo.tabuleiro.imprimir();
    
            if (jogo.checkVitoria()) {
                System.out.println(jogo.jogadorAtual.getNome() + " venceu!");
                break;
            } else if (jogo.checkEmpate()) {
                System.out.println("O jogo terminou em empate!");
                break;
            }
    
            int coluna;
            if (jogo.jogadorAtual instanceof JogadorHumano) {
                System.out.println(jogo.jogadorAtual.getNome() + ", é a sua vez! Escolha a coluna (1 a 7):");
                coluna = scanner.nextInt() - 1;
            } else {
                coluna = jogo.obterColunaIA();
            }
    
            jogo.jogar(coluna);
            jogo.trocarJogador();
        }
    }
    
    
}
