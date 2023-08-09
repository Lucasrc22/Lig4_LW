import java.util.Random;

public class Lig4TurboMaluco extends Lig4 {

    private String nivelMaluquice;

    public Lig4TurboMaluco(boolean modoIA, String nivelMaluquice) {
        super(modoIA);
        this.nivelMaluquice = nivelMaluquice;

        Cor corJogador1 = obterCorDiferente(Cor.VAZIO);
        Cor corJogador2 = obterCorDiferente(Cor.VAZIO);
        jogador1 = new JogadorHumano("Jogador 1", corJogador1);
        jogador2 = modoIA ? new IA("IA", obterCorDiferente(corJogador2)) : new JogadorHumano("Jogador 2", obterCorDiferente(corJogador2));
        jogadorAtual = jogador1;
    }
    public void setNivelMaluquice(String nivelMaluquice)throws IllegalArgumentException {
        if (nivelMaluquice!="Normal"  || nivelMaluquice!="normal" || nivelMaluquice !="Medio" || nivelMaluquice !="medio" || nivelMaluquice !="Tricolor" || nivelMaluquice !="tricolor") {
            throw new IllegalArgumentException("Nível de maluquice inválido! Deve ser entre Normal, Medio ou Tricolor");
        }
        this.nivelMaluquice = nivelMaluquice;
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
        }else{
            trocarJogador();
        }
    
        trocarJogador();
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
        
        if ("Facil".equalsIgnoreCase(nivelMaluquice) || "facil".equalsIgnoreCase(nivelMaluquice)) {
            if (random.nextInt(29) < 30) {
                return jogadorAtual.getCor();
            } else {
                Cor[] cores = Cor.values();
                return cores[random.nextInt(cores.length)];
            }
        } else if ("Medio".equalsIgnoreCase(nivelMaluquice) || "medio".equalsIgnoreCase(nivelMaluquice)) {
            if (random.nextInt(49) < 50) {
                return jogadorAtual.getCor();
            } else {
                Cor[] cores = Cor.values();
                return cores[random.nextInt(cores.length)];
            }
        } else if ("Tricolor".equalsIgnoreCase(nivelMaluquice) || "tricolor".equalsIgnoreCase(nivelMaluquice)) {
            if (random.nextInt(69) < 70) {
                return jogadorAtual.getCor();
            } else {
                Cor[] cores = Cor.values();
                return cores[random.nextInt(cores.length)];
            }
        } else {
            return jogadorAtual.getCor();
        }
    }
    
    
    
}
