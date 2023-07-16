package utilities;

public class Lig4 {
    protected Tabuleiro tabuleiro;
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorAtual;
    private boolean modoIA;

    public void inicializar(boolean modoIA) {
        this.modoIA = modoIA;
        tabuleiro = new Tabuleiro(6, 7);
        jogador1 = new Jogador("Jogador 1", 'X');
        jogador2 = modoIA ? new IA('O') : new Jogador("Jogador 2", 'O');
        jogadorAtual = jogador1;
    }

    public void jogar(int coluna) {
        if (jogadorAtual == jogador1) {
            jogador1.fazerJogada(tabuleiro, coluna);
        } else {
            jogador2.fazerJogada(tabuleiro, coluna);
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
    }

    private boolean checkVitoria() {
        for (int linha = 0; linha < tabuleiro.getLinhas(); linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                char peca = tabuleiro.getPeca(linha, coluna);
                if (peca != ' ' &&
                        peca == tabuleiro.getPeca(linha, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha, coluna + 3)) {
                    return true;
                }
            }
        }


        for (int coluna = 0; coluna < tabuleiro.getColunas(); coluna++) {
            for (int linha = 0; linha <= tabuleiro.getLinhas() - 4; linha++) {
                char peca = tabuleiro.getPeca(linha, coluna);
                if (peca != ' ' &&
                        peca == tabuleiro.getPeca(linha + 1, coluna) &&
                        peca == tabuleiro.getPeca(linha + 2, coluna) &&
                        peca == tabuleiro.getPeca(linha + 3, coluna)) {
                    return true;
                }
            }
        }


        for (int linha = 0; linha <= tabuleiro.getLinhas() - 4; linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                char peca = tabuleiro.getPeca(linha, coluna);
                if (peca != ' ' &&
                        peca == tabuleiro.getPeca(linha + 1, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha + 2, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha + 3, coluna + 3)) {
                    return true;
                }
            }
        }


        for (int linha = 3; linha < tabuleiro.getLinhas(); linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                char peca = tabuleiro.getPeca(linha, coluna);
                if (peca != ' ' &&
                        peca == tabuleiro.getPeca(linha - 1, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha - 2, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha - 3, coluna + 3)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkEmpate() {
        for (int coluna = 0; coluna < tabuleiro.getColunas(); coluna++) {
            if (!tabuleiro.colunaCheia(coluna)) {
                return false;
            }
        }

        return true;
    }


    public void trocarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }

    private void reiniciarJogo() {
        tabuleiro.inicializar();
        jogadorAtual = jogador1;
    }

    public boolean ehModoIA() {
        return modoIA;
    }
}