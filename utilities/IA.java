import java.util.Random;

public class IA extends Jogador {
    public IA(String nome, char peca) {
        super(nome, peca);
    }

    @Override
    public void fazerJogada(TabuleiroInterface tabuleiro, int coluna) {
        Random random = new Random();
        int colunaIA = random.nextInt(tabuleiro.getColunas());

        while (!tabuleiro.colunaValida(colunaIA) || tabuleiro.colunaCheia(colunaIA)) {
            colunaIA = random.nextInt(tabuleiro.getColunas());
        }

        tabuleiro.inserirPeca(colunaIA, getPeca());

        System.out.println("A IA jogou na coluna " + (colunaIA + 1));
    }
    @Override
    public String obterTipoJogador() {
        return "IA";
    }

    
}
