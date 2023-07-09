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
    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }
    public char getPeca(int linha, int coluna) {
        if (posicaoValida(linha, coluna)) {
            return matriz[linha][coluna];
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
    }
    public void setPeca(int linha, int coluna, char peca) {
        if (posicaoValida(linha, coluna)) {
            matriz[linha][coluna] = peca;
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
    }

    public int obterLinhaInsercao(int coluna) {
        for (int i = linhas - 1; i >= 0; i--) {
            if (matriz[i][coluna] == ' ') {
                return i;
            }
        }
        return -1; 
    }

    public void inserirPeca(int coluna, char peca) {
        int linhaInsercao = obterLinhaInsercao(coluna);
        if (linhaInsercao != -1) {
            matriz[linhaInsercao][coluna] = peca;
        }
    }
    public void adicionarPeca(int linha, int coluna, char peca) {
        matriz[linha][coluna] = peca;
    }
    public int getColunas() {
        return colunas;
    }
    public int getLinhas() {
        return linhas;
    }
}
