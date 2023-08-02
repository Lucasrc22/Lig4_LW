public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome, Cor cor) {
        super(nome, cor.getValor());
    }

    @Override
    public void fazerJogada(TabuleiroInterface tabuleiro, int coluna) {
        if (!tabuleiro.colunaValida(coluna)) {
            System.out.println("Coluna inválida. Escolha uma coluna válida.");
            return;
        }

        if (tabuleiro.colunaCheia(coluna)) {
            System.out.println("Coluna cheia. Escolha outra coluna.");
            return;
        }

        int linhaInsercao = tabuleiro.obterLinhaInsercao(coluna);
        tabuleiro.adicionarPeca(linhaInsercao, coluna, getCor());
    }

    @Override
    public String obterTipoJogador() {
        return "Humano";
    }
}
