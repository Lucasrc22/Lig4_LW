
public class Lig4Turbo extends Lig4 {
    public Lig4Turbo(boolean modoIA) {
        super(modoIA);
        Cor corJogador1 = obterCorDiferente(Cor.VAZIO);
        Cor corJogador2 = obterCorDiferente(Cor.VAZIO);
        jogador1 = new JogadorHumano("Jogador 1", corJogador1);
        jogador2 = modoIA ? new IA("IA", obterCorDiferente(corJogador2))
                : new JogadorHumano("Jogador 2", obterCorDiferente(corJogador2));
        jogadorAtual = jogador1;
        inicializar(null, null);
    }

    private Cor obterCorDiferente(Cor corExcluida) {
        Cor novaCor = obterCorRandom();
        while (novaCor == corExcluida || novaCor == Cor.VAZIO) {
            novaCor = obterCorRandom();
        }
        return novaCor;
    }

    private Cor obterCorRandom() {
        return Cor.obterCorRandom();
    }

    @Override
    public void jogar(int coluna) {
        if (jogadorAtual instanceof JogadorHumano) {
            super.jogar(coluna);

            int linha = tabuleiro.obterLinhaInsercao(coluna);
            Cor cor = jogadorAtual.getCor();

            alterarPecasVizinhas(linha, coluna, cor);
        } else if (jogadorAtual instanceof IA) {
            int colunaIA = obterColunaIA();

            int linha = tabuleiro.obterLinhaInsercao(colunaIA);
            Cor cor = jogadorAtual.getCor();

            alterarPecasVizinhas(linha, colunaIA, cor);
            super.jogar(colunaIA);
        }

        if (checkVitoria()) {
            System.out.println(jogadorAtual.getNome() + " venceu!");
            reiniciarJogo();
        } else if (checkEmpate()) {
            System.out.println("O jogo terminou em empate!");
            reiniciarJogo();
        } else {
            trocarJogador();
        }
        trocarJogador();
    }

    private void alterarPecasVizinhas(int linha, int coluna, Cor cor) {
        for (int i = 1; i <= 3; i++) {
            int linhaVizinha = linha + i;
            int colunaVizinha = coluna + i;

            if (posicaoValida(linhaVizinha, colunaVizinha)) {
                Cor corVizinha = tabuleiro.getPeca(linhaVizinha, colunaVizinha);

                if (corVizinha != cor) {
                    tabuleiro.setPeca(linhaVizinha, colunaVizinha, cor);
                }
            }

            colunaVizinha = coluna - i;

            if (posicaoValida(linhaVizinha, colunaVizinha)) {
                Cor corVizinha = tabuleiro.getPeca(linhaVizinha, colunaVizinha);

                if (corVizinha != cor) {
                    tabuleiro.setPeca(linhaVizinha, colunaVizinha, cor);
                }
            }
        }
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < tabuleiro.getLinhas() && coluna >= 0 && coluna < tabuleiro.getColunas();
    }

}
