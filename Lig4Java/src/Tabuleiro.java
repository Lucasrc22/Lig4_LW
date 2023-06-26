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

    public boolean inserirPeca(int linha, int coluna, char peca) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            return false; 
        }

        if (matriz[linha][coluna] != ' ') {
            return false; 
        }

        matriz[linha][coluna] = peca;
        return true;
    }
}
