public class Jogador {
    private String nome;
    private char peca;
    private Cor cor;

    public Jogador(String nome, char peca) {
        this.nome = nome;
        this.peca = peca;
    }

    public String getNome() {
        return nome;
    }

    public char getPeca() {
        return peca;
    }
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void fazerJogada(Tabuleiro tabuleiro, int coluna) {
        if (!tabuleiro.colunaValida(coluna)) {
            System.out.println("Coluna inválida. Escolha uma coluna válida.");
            return;
        }

        if (tabuleiro.colunaCheia(coluna)) {
            System.out.println("Coluna cheia. Escolha outra coluna.");
            return;
        }

        int linhaInsercao = tabuleiro.obterLinhaInsercao(coluna);
        tabuleiro.adicionarPeca(linhaInsercao, coluna, peca);
    }
}
