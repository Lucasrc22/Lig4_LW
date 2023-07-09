public class Tabuleiro {
    private char[][] matriz;
    private int linhas;
    private int colunas;

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new char[linhas][colunas];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = ' ';
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("| " + matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------------------");
    }

    public boolean colunaValida(int coluna) {
        return coluna >= 0 && coluna < colunas;
    }

    public boolean colunaCheia(int coluna) {
        return matriz[0][coluna] != ' ';
    }

    public int obterLinhaInsercao(int coluna) {
        for (int i = linhas - 1; i >= 0; i--) {
            if (matriz[i][coluna] == ' ') {
                return i;
            }
        }
        return -1; // Coluna cheia, não é possível inserir uma peça
    }

    public void adicionarPeca(int linha, int coluna, char peca) {
        matriz[linha][coluna] = peca;
    }
}
