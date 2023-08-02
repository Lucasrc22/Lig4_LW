import java.util.Random;

public class IA extends Jogador {
    public IA(String nome, Cor cor) {  
        super(nome, cor.getValor());
    }

    @Override
public void fazerJogada(TabuleiroInterface tabuleiro, int coluna) {
    Random random = new Random();
    int colunaIA = random.nextInt(tabuleiro.getColunas());

    while (!tabuleiro.colunaValida(colunaIA) || tabuleiro.colunaCheia(colunaIA)) {
        colunaIA = random.nextInt(tabuleiro.getColunas());
    }

    Cor corPecaIA = Cor.fromChar(getPeca());  // Converte o char da peça para a enumeração Cor
    tabuleiro.inserirPeca(colunaIA, corPecaIA);  // Insere a peça com a enumeração Cor

    System.out.println("A IA jogou na coluna " + (colunaIA + 1));
}


    @Override
    public String obterTipoJogador() {
        return "IA";
    }
}
