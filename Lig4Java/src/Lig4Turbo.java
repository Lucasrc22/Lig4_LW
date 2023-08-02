
public class Lig4Turbo extends Lig4 {
    public Lig4Turbo(boolean modoIA){
        super(modoIA);
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
        super.jogar(colunaIA);

        int linha = tabuleiro.obterLinhaInsercao(colunaIA);
        Cor cor = jogadorAtual.getCor();

        alterarPecasVizinhas(linha, colunaIA, cor);
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
