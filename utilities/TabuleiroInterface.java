public interface TabuleiroInterface {
    void inicializar();
    void imprimir();
    boolean colunaValida(int coluna);
    boolean colunaCheia(int coluna);
    boolean posicaoValida(int linha, int coluna);
    char getPeca(int linha, int coluna);
    void setPeca(int linha, int coluna, char peca);
    int obterLinhaInsercao(int coluna);
    void inserirPeca(int coluna, char peca);
    void adicionarPeca(int linha, int coluna, char peca);
    int getColunas();
    int getLinhas();
}
