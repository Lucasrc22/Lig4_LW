import java.util.Scanner;

public class JogoLig4 {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem-vindo ao jogo Lig 4!");

            System.out.println("Escolha o modo de jogo:");
            System.out.println("1. Jogador vs Jogador");
            System.out.println("2. Jogador vs IA");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            boolean modoIA = (opcao == 2);

            Lig4 jogo = new Lig4();
            jogo.inicializar(modoIA);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do jogo: " + e.getMessage());
        }
    }
}
