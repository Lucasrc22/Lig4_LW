public class Tabuleiro implements TabuleiroInterface {
    private Cor[][] matriz;
    private int linhas;
    private int colunas;

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new Cor[linhas][colunas];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = Cor.VAZIO;
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("| " + matriz[i][j].getValor() + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------------------");
    }

    public boolean colunaValida(int coluna) {
        return coluna >= 0 && coluna < colunas;
    }

    public boolean colunaCheia(int coluna) {
        return matriz[0][coluna] != Cor.VAZIO;
    }

    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public Cor getPeca(int linha, int coluna) throws IllegalArgumentException {
        if (posicaoValida(linha, coluna)) {
            return matriz[linha][coluna];
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
    }

    public void setPeca(int linha, int coluna, Cor cor) throws IllegalArgumentException {
        if (!posicaoValida(linha, coluna)) {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
        matriz[linha][coluna] = cor;
    }

    public int obterLinhaInsercao(int coluna) {
        for (int i = linhas - 1; i >= 0; i--) {
            if (matriz[i][coluna] == Cor.VAZIO) {
                return i;
            }
        }
        return -1;
    }

    public void inserirPeca(int coluna, Cor cor) {
        int linhaInsercao = obterLinhaInsercao(coluna);
        if (linhaInsercao != -1) {
            matriz[linhaInsercao][coluna] = cor;
        }
    }

    public void adicionarPeca(int linha, int coluna, Cor cor) {
        matriz[linha][coluna] = cor;
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }
}
