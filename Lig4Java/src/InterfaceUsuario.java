import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public int solicitarColuna() {
        System.out.print("Digite a coluna para jogar (1-7): ");
        return scanner.nextInt();
    }

    public void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("Tabuleiro:");
        for (int linha = 0; linha < tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                System.out.print("| " + tabuleiro[linha][coluna] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
