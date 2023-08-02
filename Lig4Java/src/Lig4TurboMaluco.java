import java.util.Random;

public class Lig4TurboMaluco extends Lig4 {

    private int nivelMaluquice;

    public Lig4TurboMaluco(boolean modoIA, int nivelMaluquice) {
        super(modoIA);
        this.nivelMaluquice = nivelMaluquice;

        Cor corJogador1 = obterCorRandom();
        Cor corJogador2 = obterCorRandom();
        jogador1 = new JogadorHumano("Jogador 1", corJogador1);
        jogador2 = modoIA ? new IA("IA", corJogador2) : new JogadorHumano("Jogador 2", corJogador2);
        jogadorAtual = jogador1;
    }
    public void setNivelMaluquice(int nivelMaluquice)throws IllegalArgumentException {
        if (nivelMaluquice < 0 || nivelMaluquice > 100) {
            throw new IllegalArgumentException("O nível de maluquice deve estar entre 0 e 100.");
        }
        this.nivelMaluquice = nivelMaluquice;
    }

    @Override
    public void jogar(int coluna) {
        super.jogar(coluna);

        if (jogadorAtual instanceof JogadorHumano) {
            JogadorHumano jogador = (JogadorHumano) jogadorAtual;
            Cor corJogadorAtual = jogador.getCor();
            alterarPecasVizinhas(coluna, corJogadorAtual);
        }
    }

    private void alterarPecasVizinhas(int coluna, Cor cor) {
        int linhaInsercao = tabuleiro.obterLinhaInsercao(coluna);
    
        for (int linha = Math.max(0, linhaInsercao - 1); linha <= Math.min(tabuleiro.getLinhas() - 1, linhaInsercao + 1); linha++) {
            tabuleiro.setPeca(linha, coluna, cor);
        }
    
        for (int col = Math.max(0, coluna - 1); col <= Math.min(tabuleiro.getColunas() - 1, coluna + 1); col++) {
            tabuleiro.setPeca(linhaInsercao, col, cor);
        }
    }
    

    private Cor obterCorRandom() {
        Random random = new Random();
        int prob = random.nextInt(100);

        if (prob < nivelMaluquice) {
            Cor[] cores = Cor.values();
            return cores[random.nextInt(cores.length)];
        } else {
            return jogadorAtual.getCor();
        }
    }
}
