import java.util.Random;

public class Lig4TurboMaluco extends Lig4 {

    public Lig4TurboMaluco(boolean modoIA) {
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

    @Override
    public void jogar(int coluna) {
        if (jogadorAtual instanceof JogadorHumano) {
            JogadorHumano jogador = (JogadorHumano) jogadorAtual;
            Cor corJogadorAtual = jogador.getCor();
            super.jogar(coluna);
            alterarPecasVizinhas(coluna, corJogadorAtual);
        } else if (jogadorAtual instanceof IA) {
            int colunaIa = obterColunaIA();
            super.jogar(colunaIa);
            Cor cor = jogadorAtual.getCor();
            alterarPecasVizinhas(colunaIa, cor);
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

    private void alterarPecasVizinhas(int coluna, Cor cor) {
        int linhaInsercao = tabuleiro.obterLinhaInsercao(coluna);

        for (int linha = Math.max(0, linhaInsercao - 1); linha <= Math.min(tabuleiro.getLinhas() - 1,
                linhaInsercao + 1); linha++) {
            tabuleiro.setPeca(linha, coluna, cor);
        }

        for (int col = Math.max(0, coluna - 1); col <= Math.min(tabuleiro.getColunas() - 1, coluna + 1); col++) {
            tabuleiro.setPeca(linhaInsercao, col, cor);
        }
    }

    private Cor obterCorRandom() {
        Random random = new Random();

        if (random.nextInt(100) < 50) {
            return jogadorAtual.getCor();
        } else {
            Cor[] cores = Cor.values();
            return cores[random.nextInt(cores.length)];
        }
    }

}
