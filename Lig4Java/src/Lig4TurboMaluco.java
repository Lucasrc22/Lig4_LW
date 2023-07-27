import java.util.Random;

public class Lig4TurboMaluco extends Lig4{
    public enum Cor {
        AZUL, VERDE, VERMELHO, AMARELO, ROSA, LARANJA
    }

    private int nivelMaluquice;

    public Lig4TurboMaluco(boolean modoIA, int nivelMaluquice) {
        super(modoIA);
        this.nivelMaluquice = nivelMaluquice;
        
    }
    private Cor obterCor(char peca) {
        for (Cor cor : Cor.values()) {
            if (cor.getValor() == peca) {
                return cor;
            }
        }
        return null; // Caso a peça não corresponda a nenhuma cor do enum.
    }
    private Cor obterCorRandom(){
        Random random = new Random();
        int prob = random.nextInt(100);

        if(prob < nivelMaluquice){
            Cor[] cores = Cor.values();
            return cores[random.nextInt(cores.length)];
        }else{
            return Cor.valueOf(" " + jogadorAtual.getPeca());
        }
    }
    @Override
    public void jogar(int coluna) {
        super.jogar(coluna); 

        if (jogadorAtual == jogador1) {
            mudarCoresVizinhas(jogador1, coluna);
        } else {
            mudarCoresVizinhas(jogador2, coluna);
        }
    }
    private void mudarCoresVizinhas(Jogador jogador, int coluna) {
        int linha = tabuleiro.obterLinhaInsercao(coluna);
        char peca = jogador.getPeca().getValor(); 
        for (int i = coluna + 1; i < tabuleiro.getColunas(); i++) {
            if (tabuleiro.getPeca(linha, i) != ' ') {
                tabuleiro.setPeca(linha, i, peca);
            } else {
                break;
            }
        }

        
        for (int i = coluna - 1; i >= 0; i--) {
            if (tabuleiro.getPeca(linha, i) != ' ') {
                tabuleiro.setPeca(linha, i, peca); 
            } else {
                break;
            }
        }
    }
}
