import java.util.Random;

public class Lig4 {
    protected TabuleiroInterface tabuleiro;
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorAtual;
    protected boolean modoIA;
    public Lig4(boolean modoIA){
        this.modoIA = modoIA;
        inicializar();
    }

    public void inicializar() {
        tabuleiro = new Tabuleiro(6, 7);
        Cor corJogador1 = obterCorRandom();
        Cor corJogador2 = obterCorRandom();
        
        jogador1 = new JogadorHumano("Jogador 1", corJogador1);
        jogador1.setCor(corJogador1);  
        
        jogador2 = modoIA ? new IA("IA", corJogador2) : new JogadorHumano("Jogador 2", corJogador2);
        jogador2.setCor(corJogador2);  
        
        jogadorAtual = jogador1;
    }
    
    private Cor obterCorRandom() {
        return Cor.obterCorRandom();
    }
    public void jogar(int coluna) {
        jogadorAtual.fazerJogada(tabuleiro, coluna);
        
        if (checkVitoria()) {
            System.out.println(jogadorAtual.getNome() + " venceu!");
            reiniciarJogo();
        } else if (checkEmpate()) {
            System.out.println("O jogo terminou em empate!");
            reiniciarJogo();
        } else {
            trocarJogador();
            System.out.println(jogadorAtual.getNome() + ", é a sua vez! Escolha a coluna (1 a 7):");
        }
    }
    
    
    public void trocarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
    

    protected boolean checkVitoria() {
        for (int linha = 0; linha < tabuleiro.getLinhas(); linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                Cor peca = tabuleiro.getPeca(linha, coluna);
                if (peca != Cor.VAZIO &&
                        peca == tabuleiro.getPeca(linha, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha, coluna + 3)) {
                    return true;
                }
            }
        }
    
        for (int coluna = 0; coluna < tabuleiro.getColunas(); coluna++) {
            for (int linha = 0; linha <= tabuleiro.getLinhas() - 4; linha++) {
                Cor peca = tabuleiro.getPeca(linha, coluna);
                if (peca != Cor.VAZIO &&
                        peca == tabuleiro.getPeca(linha + 1, coluna) &&
                        peca == tabuleiro.getPeca(linha + 2, coluna) &&
                        peca == tabuleiro.getPeca(linha + 3, coluna)) {
                    return true;
                }
            }
        }
    
        for (int linha = 0; linha <= tabuleiro.getLinhas() - 4; linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                Cor peca = tabuleiro.getPeca(linha, coluna);
                if (peca != Cor.VAZIO &&
                        peca == tabuleiro.getPeca(linha + 1, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha + 2, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha + 3, coluna + 3)) {
                    return true;
                }
            }
        }
    
        for (int linha = 3; linha < tabuleiro.getLinhas(); linha++) {
            for (int coluna = 0; coluna <= tabuleiro.getColunas() - 4; coluna++) {
                Cor peca = tabuleiro.getPeca(linha, coluna);
                if (peca != Cor.VAZIO &&
                        peca == tabuleiro.getPeca(linha - 1, coluna + 1) &&
                        peca == tabuleiro.getPeca(linha - 2, coluna + 2) &&
                        peca == tabuleiro.getPeca(linha - 3, coluna + 3)) {
                    return true;
                }
            }
        }
    
        return false;
    }
    
    protected boolean checkEmpate() {
        for (int coluna = 0; coluna < tabuleiro.getColunas(); coluna++) {
            if (!tabuleiro.colunaCheia(coluna)) {
                return false; 
            }
        }
    
        return true; 
    }
    

    protected void reiniciarJogo() {
        tabuleiro.inicializar();
        jogadorAtual = jogador1;
    }

    public boolean ehModoIA() {
        return modoIA;
    }

    public int obterColunaIA() {
        Random random = new Random();
        return random.nextInt(tabuleiro.getColunas());
    }

}
