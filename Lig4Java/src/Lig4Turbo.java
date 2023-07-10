public class Lig4Turbo extends Lig4 {

    @Override
    public void jogar(int coluna) {
        super.jogar(coluna); 

        int linha = tabuleiro.obterLinhaInsercao(coluna); 
        char peca = jogadorAtual.getPeca();

        
        alterarPecasVizinhas(linha, coluna, peca, 1, 0);  
        alterarPecasVizinhas(linha, coluna, peca, -1, 0); 
    }

    private void alterarPecasVizinhas(int linha, int coluna, char peca, int incrementoLinha, int incrementoColuna) {
        for (int i = 1; i <= 3; i++) {
            int linhaVizinha = linha + i * incrementoLinha;
            int colunaVizinha = coluna + i * incrementoColuna;

            if (posicaoValida(linhaVizinha, colunaVizinha)) {
                char pecaVizinha = getPeca(linhaVizinha, colunaVizinha);

                if (pecaVizinha != peca) {
                    setPeca(linhaVizinha, colunaVizinha, peca);
                }
            }
        }
    }

    private boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < tabuleiro.getLinhas() && coluna >= 0 && coluna < tabuleiro.getColunas();
    }
    

    private char getPeca(int linha, int coluna) throws IllegalArgumentException{
        if (posicaoValida(linha, coluna)) {
            return tabuleiro.getPeca(linha, coluna);
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
    }

    private void setPeca(int linha, int coluna, char peca) throws IllegalArgumentException{
        if (posicaoValida(linha, coluna)) {
            tabuleiro.setPeca(linha, coluna, peca);
        } else {
            throw new IllegalArgumentException("Posição inválida no tabuleiro!");
        }
    }
}
