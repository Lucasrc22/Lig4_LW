public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome, Cor cor) {
        super(nome, cor.getValor());
    }

    @Override
    public void fazerJogada(TabuleiroInterface tabuleiro, int coluna) {
        Cor corPecaJogador = getCor();  
        tabuleiro.inserirPeca(coluna, corPecaJogador); 
        if (!tabuleiro.colunaValida(coluna)) {
            System.out.println("Coluna inválida. Escolha uma coluna válida.");
            return;
        }

        if (tabuleiro.colunaCheia(coluna)) {
            System.out.println("Coluna cheia. Escolha outra coluna.");
            return;
        }

        
    

    }
    @Override
    public String obterTipoJogador() {
        return "Humano";
    }
}
