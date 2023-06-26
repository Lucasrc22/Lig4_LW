public class Jogador {
    private String nome;
    private char peca;
    public Jogador(String nome, char peca) {
        this.nome = nome;
        this.peca = peca;
    }

    public String getNome() {
        return nome;
    }

    public char getPeca() {
        return peca;
    }

    public void fazerJogada(Tabuleiro tabuleiro, int coluna) {

    }
}
