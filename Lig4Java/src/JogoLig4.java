import java.util.Scanner;

//import utilities.Lig4;

public class JogoLig4 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem-vindo ao jogo Lig 4!");

            int opcao = obterOpcao(scanner);
            boolean modoIA = (opcao == 2);

            Lig4 jogo = new Lig4(modoIA);
            jogo.inicializar();

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
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                case 2:
                    return opcao;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (true);
    }
}