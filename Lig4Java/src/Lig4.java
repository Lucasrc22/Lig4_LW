public class Lig4 {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private boolean modoIA;

    public void inicializar(boolean modoIA) {
        this.modoIA = modoIA;
        tabuleiro = new Tabuleiro(6, 7);
        jogador1 = new Jogador("Jogador 1", 'X');
        jogador2 = modoIA ? new IA('O') : new Jogador("Jogador 2", 'O');
        jogadorAtual = jogador1; // Define o jogador atual como jogador1 no início do jogo
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
        // Lógica para verificar se houve vitória
        return false;
    }

    private boolean checkEmpate() {
        // Lógica para verificar se houve empate
        return false;
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

    public boolean isModoIA() {
        return modoIA;
    }
}
